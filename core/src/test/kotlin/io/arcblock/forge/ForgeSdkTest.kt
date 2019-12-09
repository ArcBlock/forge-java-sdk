package io.arcblock.forge

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.LoggerContext
import forge_abi.Enum
import forge_abi.Rpc
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.extension.*
import io.grpc.stub.StreamObserver
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean

/**
 ** Author       : shan@arcblock.io
 * Time         : 2019-09-10
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
@Ignore
@RunWith(JUnit4::class)
class ForgeSdkTest {

  private lateinit var bob: WalletInfo
  private lateinit var alice: WalletInfo
  private lateinit var forge: ForgeSDK

  @Before
  fun setUp() {
    (LoggerFactory.getILoggerFactory() as LoggerContext).getLogger("io.arcblock").level = Level.INFO
    (LoggerFactory.getILoggerFactory() as LoggerContext).getLogger("io.grpc").level = Level.OFF
    (LoggerFactory.getILoggerFactory() as LoggerContext).getLogger("io.netty").level = Level.OFF
    forge = ForgeSDK.connect("localhost", 28212)
    alice = forge.createWallet()
    bob = forge.createWallet()
    forge.declare("alice",alice)
    forge.declare("Bobb",bob)
    forge.poke(alice)
    println("alice:$alice")
    println("bob:$bob")
  }

  @Test
  fun testTranser() {

    val state = forge.getForgeState().state
    println("State: $state")
//
//    for (x in 0..30){
//      val response = forge.transfer(alice, bob.address, BigInteger.ONE)
//      Assert.assertEquals(" send multi sig transaction:", Enum.StatusCode.ok, response.code)
//    }
  }


  @Test
  fun testCreateAsset() {
    val (response, address) = forge.createAsset("string", UUID.randomUUID().toString().toByteArray(), "assetMoniker", bob)
    Assert.assertEquals(" create asset:", Enum.StatusCode.ok, response.code)
    Thread.sleep(5000)
    checkAssetOwner(address, bob.address)
  }

  @Test
  fun testUpdateAsset() {
    val ob = forge.getAssetState(object :StreamObserver<Rpc.ResponseGetAssetState>{
      override fun onNext(value: Rpc.ResponseGetAssetState?) {
        println("\nasset:\n$value")
        Assert.assertEquals(" create asset:","abcdefghijklmnopqrstuvwxyz" ,value?.state?.data?.value )
      }
      override fun onError(t: Throwable?) {}
      override fun onCompleted() {}
    })
    val (response, address) = forge.createAsset("string",  UUID.randomUUID().toString().toByteArray(), "assetMoniker", bob,transferrable = true,ttl = 10)
    Assert.assertEquals(" create asset:", Enum.StatusCode.ok, response.code)
    val ur = forge.updateAsset(address,"changeMoniker","string","abcdefghijklmnopqrstuvwxyz".toByteArray(), bob)
    Assert.assertEquals(" create asset:", Enum.StatusCode.ok, ur.code)
    Thread.sleep(5000)
    ob.onNext(Rpc.RequestGetAssetState.newBuilder().setAddress(address).build())
    Thread.sleep(1000)
  }


  // It seems only asset creator can consume asset
  @Test
  fun testConsumeAsset(){
    val (_, address) = forge.createAsset("string",  UUID.randomUUID().toString().toByteArray(), "assetMoniker", bob)
    forge.exchange(alice, bob, BigInteger.TEN, address)
    val response = forge.consumeAsset(address, bob ,alice)
    Assert.assertEquals(" consume asset:", Enum.StatusCode.ok, response.code)
  }


  @Test
  fun testExchange() {
    val (_, address) = forge.createAsset("string", UUID.randomUUID().toString().toByteArray(), "assetMoniker", bob)
    val response = forge.exchange(alice, bob, BigInteger.ONE, address)
    Assert.assertEquals(" test exchange:", Enum.StatusCode.ok, response.code)
    Thread.sleep(5000)
    checkAssetOwner(address, alice.address)
    println("response:\n$response")
  }

  fun checkAssetOwner(asset: String, assetOwner: String){
    var pending = AtomicBoolean(false)
    var owner = ""
    val handler = forge.getAssetState(object : StreamObserver<Rpc.ResponseGetAssetState> {
      override fun onNext(value: Rpc.ResponseGetAssetState?) {
        println("asset: ${value?.state?.owner}")
        owner = value?.state?.owner?:""
        pending.set(true)
      }
      override fun onError(t: Throwable?) {

      }

      override fun onCompleted() {

      }

    })
    Thread.sleep(1000)
    handler.onNext(Rpc.RequestGetAssetState.newBuilder().setAddress(asset).build())
    var times = 0
    while (times < 20){
      if (pending.get()){
        Assert.assertTrue("$assetOwner  has't asset $asset", owner == assetOwner)
        break
      }else times++
      Thread.sleep(1000)
    }

  }

  /**
   * test failed
   */
  @Test
  fun testDelegateExchange() {
    val celliy = forge.createWallet()
    forge.declare("Celliy",celliy)
    println("create C")
    forge.createDelegate(alice,celliy, listOf(), TypeUrls.EXCHANGE)
    println("delegate A")
    val dendy = forge.createWallet()
    forge.declare("Dendy", dendy)
    forge.createDelegate(bob, dendy, listOf(),TypeUrls.EXCHANGE)
    println("delegate B")
    val (_, address) = forge.createAsset("string", UUID.randomUUID().toString().toByteArray(), "assetMoniker", bob)
    println("delegate create asset")

    val response = forge.exchange(celliy, dendy, BigInteger.ONE, address ,delegateeFrom = alice.address, delegateeTo = bob.address)
    Thread.sleep(5000)
    println("response:\n$response")
    checkAssetOwner(address, alice.address)

  }

  @Test
  fun testDelegate(){
    val celliy = forge.createWallet()
    forge.declare("Celliy",celliy)
    println("appId:${alice.pkBase58()}")
    println("secId:${celliy.sk.encodeB58()}")
    var response = forge.createDelegate(alice,celliy, listOf())
    Assert.assertEquals(" test delegate:", Enum.StatusCode.ok, response.code)
    var sendR = forge.transfer(celliy, bob.address, BigInteger.TEN, delegatee = alice.address)
    Assert.assertEquals(" test delegate transfer:", Enum.StatusCode.ok, sendR.code)

    response = forge.createDelegate(alice,celliy, listOf(),typeUrl = TypeUrls.SETUP_SWAP)
    Assert.assertEquals(" test delegate:", Enum.StatusCode.ok, response.code)
    val mByteArray = ByteArray(128)
    Random().nextBytes(mByteArray)

    sendR = forge.setupSwap(alice, celliy.address, BigInteger.ZERO, 50000, mByteArray)
    Assert.assertEquals(" test delegate setup swap:", Enum.StatusCode.ok, sendR.code)
  }

 @Test
 fun testSwap(){
   Thread.sleep(4000)
   val curBalance = getbalance(alice.address)
   var mByteArray = ByteArray(128)
   Random().nextBytes(mByteArray)

   val bh = forge.getChainInfo().info.blockHeight
   val swapAmount = BigDecimal("5E18").toBigInteger().unSign()
   var response = forge.setupSwap(alice, bob.address, swapAmount, (bh+3).toInt(), mByteArray)
   Assert.assertEquals(" test swap:", Enum.StatusCode.ok, response.code)
   val addr = DIDGenerator.toSwapAddress(hash = response.hash.decodeB16())
   Thread.sleep(4000)
   checkBalance(alice.address, curBalance.minus(swapAmount))
   Thread.sleep(9000)
   response = forge.revokeSwap(alice, addr)
   Assert.assertEquals(" test revoke:", Enum.StatusCode.ok, response.code)

   Thread.sleep(4000)
   checkBalance(alice.address,curBalance)

 }




















  fun checkBalance(who: String, bal: BigInteger){
    val rst = getbalance(who)
    Assert.assertTrue("Account balance is $rst not $bal", rst == bal)
  }

  fun getbalance(who: String): BigInteger{
    var pending = AtomicBoolean(false)
    var balance = BigInteger.ZERO
    val handler = forge.getAccountState(object : StreamObserver<Rpc.ResponseGetAccountState> {
      override fun onNext(value: Rpc.ResponseGetAccountState?) {
        balance = BigInteger(value?.state?.balance?.value?.toByteArray()).unSign()
        println("balance:$balance")
        pending.set(true)
      }
      override fun onError(t: Throwable?) {

      }

      override fun onCompleted() {

      }

    })
    Thread.sleep(1000)
    handler.onNext(Rpc.RequestGetAccountState.newBuilder().setAddress(who).build())
    var times = 0
    while (times < 20){
      if (pending.get()){
        return  balance
      }else times++
      Thread.sleep(1000)
    }
    return balance

  }

  @Test
  fun sendTxTest(){
    val tx = TransactionFactory.unsignTransfer("default",alice.address, alice.pk, bob.address, BigIntegerExt.createWithDecimal(5,18)).signTx(alice.sk)
    println("tx: ${tx.toByteArray().encodeB64Url()}")
  }


}
