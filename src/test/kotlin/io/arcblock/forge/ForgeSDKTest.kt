package io.arcblock.forge

import forge_abi.*
import io.grpc.*
import io.grpc.stub.*
import org.junit.Test

class ForgeSDKTest {
  @Test
  fun testForgeSDK(){
    val forgeSDK = ForgeSDK.getInstance("localhost",27210)
    val response = forgeSDK.getChainInfo(Rpc.RequestGetChainInfo.newBuilder()
      .build())
    println("response:${response.info}")
    forgeSDK.shutdown()
  }

}
