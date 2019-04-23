package io.arcblock.forge

import org.junit.Test

class ForgeSDKTest {
  @Test
  fun testForgeSDK(){
    val forgeSDK = ForgeSDK()
//    val response = forgeSDK.stub.getChainInfo(Rpc.RequestGetChainInfo.newBuilder().build())
//    println("response:${response.info}")
    val x = Class.forName("forge_abi.Rpc\$ResponseCreateTx")
    println("class:$x")
  }

}
