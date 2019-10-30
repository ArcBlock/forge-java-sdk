package io.arcblock.forge

import com.google.protobuf.Any
import com.google.protobuf.ByteString
import forge_abi.Enum
import forge_abi.Rpc
import forge_abi.SetupSwap
import forge_abi.Type
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.extension.decodeB16
import io.arcblock.forge.extension.signTx
import io.arcblock.forge.extension.toByteString
import io.grpc.stub.StreamObserver
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

/**
 *
 *     █████╗ ██████╗  ██████╗██████╗ ██╗      ██████╗  ██████╗██╗  ██╗
 *    ██╔══██╗██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗██╔════╝██║ ██╔╝
 *    ███████║██████╔╝██║     ██████╔╝██║     ██║   ██║██║     █████╔╝
 *    ██╔══██║██╔══██╗██║     ██╔══██╗██║     ██║   ██║██║     ██╔═██╗
 *    ██║  ██║██║  ██║╚██████╗██████╔╝███████╗╚██████╔╝╚██████╗██║  ██╗
 *    ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝
 * Author       : shan@arcblock.io
 * Time         : 2019-09-10
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
@Ignore
@RunWith(JUnit4::class)
class TransferTest {

  private lateinit var bob: WalletInfo
  private lateinit var alice: WalletInfo
  private lateinit var forge: ForgeSDK

  @Before
  fun setUp() {
    forge = ForgeSDK.connect("localhost", 28211)
    alice = forge.createWallet()
    bob = forge.createWallet()
    forge.declare("alice",alice)
    forge.declare("Bobb",bob)
    forge.poke(alice)
  }

  @Test
  fun testTranser() {
    for (x in 0..30){
      val response = forge.transfer(alice, bob, BigInteger.ONE)
      Assert.assertEquals(" send multi sig transaction:", Enum.StatusCode.ok, response.code)
    }
  }

  @Test
  fun testCreateAsset() {
    val (response, address) = forge.createAsset("string", UUID.randomUUID().toString().toByteArray(), "assetMoniker", bob)
    Assert.assertEquals(" create asset:", Enum.StatusCode.ok, response.code)
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
    val list = forge.listAssets(Rpc.RequestListAssets.newBuilder().setOwnerAddress(alice.address) .build())
    Assert.assertTrue("Alice has asset", list.assetsList.map {
      it.address
    }.contains(address)
    )
  }

  /**
   * test failed
   */
  @Test
  fun testDelegateExchange() {
    val celliy = forge.createWallet()
    forge.declare("Celliy",celliy)
    forge.createDelegate(alice,celliy, listOf("itx.value <= 100000000000000"), TypeUrls.EXCHANGE)

    val dendy = forge.createWallet()
    forge.declare("Dendy", dendy)
    forge.createDelegate(bob, dendy, listOf("itx.value <= 100000000000000"),TypeUrls.EXCHANGE)

    val (_, address) = forge.createAsset("string", UUID.randomUUID().toString().toByteArray(), "assetMoniker", bob)
    val response = forge.exchange(celliy, dendy, BigInteger.ONE, address,delegateeFrom = alice.address)
    println("response:\n$response")
    Assert.assertEquals(" test exchange:", Enum.StatusCode.ok, response.code)
    Thread.sleep(5000)
    val list = forge.listAssets(Rpc.RequestListAssets.newBuilder().setOwnerAddress(alice.address) .build())
    Assert.assertTrue("Alice has asset", list.assetsList.map {
      it.address
    }.contains(address)
    )
  }

  @Test
  fun testDelegate(){
    val celliy = forge.createWallet()
    forge.declare("Celliy",celliy)
    val response = forge.createDelegate(alice,celliy, listOf("itx.value <= 100000000000000"))
    Assert.assertEquals(" test delegate:", Enum.StatusCode.ok, response.code)
    val sendR = forge.transfer(celliy, bob, BigInteger.ZERO, delegatee = alice.address)
    Assert.assertEquals(" test delegate transfer:", Enum.StatusCode.ok, sendR.code)
  }

 @Test
 fun testSwap(){
   var mByteArray = ByteArray(128)
   Random().nextBytes(mByteArray)
   val tx = setup_swap("1", 40000, mByteArray,bob.address,forge.chainInfo.value.network,alice.pk,alice.address).signTx(alice.sk)
   val hash = forge.sendTx(tx).hash
   val addr = DIDGenerator.toSwapAddress(hash = hash.decodeB16())

   println("address:$addr")
 }

  fun setup_swap(demandToken:String, blockHeight: Int,hashKey: ByteArray,receiver: String,chainId:String, pk: ByteArray,addr: String): Type.Transaction {
    val itx = SetupSwap.SetupSwapTx.newBuilder()
      .setValue(Type.BigUint.getDefaultInstance().toBuilder().setValue(BigDecimal(demandToken).toBigInteger().toByteArray().toByteString()).buildPartial())
      .setLocktime(blockHeight).setHashlock(Hasher.hash(HashType.SHA3, hashKey).toByteString()).setReceiver(receiver).buildPartial()
    return Type.Transaction.getDefaultInstance().toBuilder().setChainId(chainId).setPk(ByteString.copyFrom(pk)).setFrom(addr)
      .setNonce(System.currentTimeMillis()).setItx(Any.getDefaultInstance().toBuilder().setTypeUrl("fg:t:setup_swap").setValue(itx.toByteString())
        .buildPartial())
      .buildPartial()

  }


}
