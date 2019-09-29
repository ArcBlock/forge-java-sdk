package io.arcblock.forge

import forge_abi.Enum
import forge_abi.Rpc
import forge_abi.Type
import io.grpc.stub.StreamObserver
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
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
class TransferTest {

  private lateinit var bob: Type.WalletInfo
  private lateinit var alice: Type.WalletInfo
  private lateinit var forge: ForgeSDK

  @Before
  fun setUp() {
    forge = ForgeSDK.connect("localhost", 28210)
    alice = forge.createWallet("alice", "123qweASD").wallet
    bob = forge.createWallet("bobbb", "123qweASD").wallet
    forge.poke(alice)

  }

  @Test
  fun testTranser() {
    val response = forge.transfer(alice, bob, BigInteger.ONE)
    Assert.assertEquals(" send multi sig transaction:", Enum.StatusCode.ok, response.code)
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
    val celliy = forge.createWallet("celliy", "123qweASD").wallet
    forge.createDelegate(alice,celliy, listOf(""), TypeUrls.EXCHANGE)

    val dendy = forge.createWallet("denddi", "123qweASD").wallet
    forge.createDelegate(bob, dendy, listOf(""),TypeUrls.EXCHANGE)

    val (_, address) = forge.createAsset("string", UUID.randomUUID().toString().toByteArray(), "assetMoniker", bob)
    val response = forge.exchange(celliy, dendy, BigInteger.ONE, address,alice.address, bob.address)
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
    val celliy = forge.createWallet("celliy", "123qweASD").wallet
    val response = forge.createDelegate(alice,celliy, listOf("itx.value <= 100000000000000"))
    Assert.assertEquals(" test delegate:", Enum.StatusCode.ok, response.code)
    val sendR = forge.transfer(celliy, bob, BigInteger.ZERO, delegatee = alice.address)
    Assert.assertEquals(" test delegate transfer:", Enum.StatusCode.ok, sendR.code)
  }



}
