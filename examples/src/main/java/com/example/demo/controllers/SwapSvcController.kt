package com.example.demo.controllers

import com.example.demo.components.ForgeSDKComponent
import com.google.common.io.BaseEncoding
import forge_abi.Rpc
import io.arcblock.forge.TransactionFactory
import io.arcblock.forge.WalletUtils
import io.arcblock.forge.did.*
import io.arcblock.forge.did.bean.AppInfo
import io.arcblock.forge.did.bean.MetaInfo
import io.arcblock.forge.did.bean.ProfileClaim
import io.arcblock.forge.signTx
import io.arcblock.forge.utils.Base58Btc
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController






@RestController
@RequestMapping("/swap/svc/")
class SwapSvcController {
  var logger = LoggerFactory.getLogger(javaClass)

  @Autowired
  lateinit var forge: ForgeSDKComponent
  @Autowired
  lateinit var app: AppInfo

  val sk = BaseEncoding.base64().decode("dxX9ASBY+BTNayyTnIRC4A8QadAFi3F+GuE3+It8ltcM0h56H8xeJqTHn2w03uEfKJ801fjmeaygaIt0rHBaNg==")
  val pk = BaseEncoding.base64().decode("DNIeeh/MXiakx59sNN7hHyifNNX45nmsoGiLdKxwWjY=")
  val addr = DIDGenerator.pk2did(RoleType.ACCOUNT, KeyType.ED25519, HashType.SHA3, pk).removePrefix("did:abt:")
  val wallet = WalletInfo(addr, pk, sk)
  var ip = "10.165.107.171"
  //val ip = InetAddress.getByName("en0").hostAddress
  val host = "http://$ip"

  init {
    logger.info("iPaddr:$ip")

  }


  val appInfo: AppInfo by lazy {
    AppInfo().let {
      it.description = "Swap Test"
    it.icon = "http://10.113.10.166:8807/images/logo@2x.png"
    it.name = "Anbillum Company"
    it.chainHost = "$host:8410/api/"
    it.chainId = app.chainId
    it.chainToken = app.chainToken
    it.chainVersion = app.chainVersion
    it.decimals = app.decimals
    it.publisher = "did:abt:$addr"
    it
  }
}




  @RequestMapping("/",method = arrayOf(RequestMethod.POST))
  @ResponseBody
  fun allPost(): String{
    return "{\"result\":\"ok\"}"
  }

  @RequestMapping("/swap",method = arrayOf(RequestMethod.GET))
  @ResponseBody
  fun newSwap():String{
    val claim = ProfileClaim(MetaInfo("Mock Swap data",""),
      arrayListOf("name","avatar","signature","birthday","phone","email"))
    val swapClaim = SwapClaim(MetaInfo("Mock data",""),
      arrayOf(""),"$host:8310/api","3","${appInfo.chainId}",""
      )
    val content = DidAuthUtils.createDidAuthToken(arrayOf(swapClaim),appInfo,System.currentTimeMillis()/1000,
      wallet,"$host:8081/did/")
    return "{\"appPk\":\"${Base58Btc.encode(wallet.pk)}\",\"authInfo\":\"$content\"}"
  }

  @RequestMapping("/auth", method = [RequestMethod.GET])
  @ResponseBody
  fun auth():String{
    val claim = ProfileClaim(MetaInfo("Mock data",""),
      arrayListOf("name","avatar","signature","birthday","phone","email"))

    val content = DidAuthUtils.createDidAuthToken(arrayOf(claim),appInfo,System.currentTimeMillis()/1000,
      wallet,"$host:8081/did/auth")
    return "{\"appPk\":\"${Base58Btc.encode(wallet.pk)}\",\"authInfo\":\"$content\"}"
  }


  @RequestMapping("/poke", method = [RequestMethod.GET])
  @ResponseBody
  fun poke(skb64: String):String{
    val sk = BaseEncoding.base64Url().decode(skb64)
    val did = DIDGenerator.sk2did(sk)
    val pk = WalletUtils.sk2pk(KeyType.ED25519,sk)

    val forgeState = forge.forgeSDK
      .getForgeState(Rpc.RequestGetForgeState.newBuilder()
        .build())

    val tmp = WalletInfo(did.removePrefix("did:abt:"),pk,sk)
    val tx = TransactionFactory.unsignPoke(app.chainId,tmp).signTx(sk)
    val rst = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).build())

    return "{${rst.hash}}"
  }



}


