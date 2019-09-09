package com.example.demo.controllers

import com.example.demo.components.ForgeSDKComponent
import com.google.common.io.BaseEncoding
import com.google.gson.Gson
import com.google.protobuf.ByteString
import forge_abi.Rpc
import forge_abi.Type
import io.arcblock.forge.TransactionFactory
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.DidAuthUtils
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.did.bean.*
import io.arcblock.forge.signTx
import io.arcblock.forge.utils.Base58Btc
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.net.InetAddress


@RestController
@RequestMapping("/did")
class SwapController {
  var logger = LoggerFactory.getLogger(javaClass)

  @Autowired
  lateinit var forge: ForgeSDKComponent
  @Autowired
  lateinit var app: AppInfo

  val sk = BaseEncoding.base64Url().decode("tk3pcIjpDRzeUGutXL7mjf52jNfA_kztlQnIgYnBStiY2X5pZlsLGwfiMgFA6a8qLhCEgMjGmEBjcFROew9TXw")
  val pk = BaseEncoding.base64Url().decode("mNl-aWZbCxsH4jIBQOmvKi4QhIDIxphAY3BUTnsPU18")
  val addr = "z1TpjUv5ZVVpY854GVk9W9Zfnb4HKqQzRSg"
  val wallet = WalletInfo(addr, pk, sk)
  var ip = InetAddress.getLocalHost().hostAddress
  val host = "http://$ip"


  init {
    logger.info("iPaddr:$ip")
    logger.info("Pk:${Base58Btc.encode(pk)}")
  }


  val appInfo: AppInfo by lazy {
    AppInfo().let {
      it.description = "Swap Test"
    it.icon = "http://10.113.10.166:8807/images/logo@2x.png"
    it.name = "Anbillum Company"
    it.chainHost = "$host:8310/api/"
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

  @RequestMapping("/paper", method = [RequestMethod.GET])
  @ResponseBody
  fun delegatePaper():String {
    val w = DIDGenerator.randomWallet()
    logger.info("address======>\n ${w.address}")
    val declare = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(TransactionFactory.declare(app.chainId,w).signTx(w.sk)).build())
    logger.info("declare======>\n ${declare.toString()}")
    val forgeState = forge.forgeSDK
      .getForgeState(Rpc.RequestGetForgeState.newBuilder()
        .build())

    val tx = TransactionFactory.unsignPoke(forgeState.state.pokeConfig.address,app.chainId, w).signTx(w.sk)
    val rst = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).build())
    logger.info("poke ->>>>>>> \n $rst")
    return rst.toString()
  }



  @RequestMapping("/poke", method = [RequestMethod.GET])
  @ResponseBody
  fun poke(userDid: String,userPk: String):String{
    val forgeState = forge.forgeSDK
      .getForgeState(Rpc.RequestGetForgeState.newBuilder()
        .build())
    val tmp = WalletInfo(userDid.removePrefix("did:abt:"),Base58Btc.decode(userPk), ByteArray(0))
    val tx = TransactionFactory.unsignPoke(forgeState.state.pokeConfig.address,app.chainId,tmp)
    val claim = SignatureClaim(MetaInfo("Poke",""),
      "",Base58Btc.encode(tx.toByteArray()),"")

    val content = DidAuthUtils.createDidAuthToken(arrayOf(claim),appInfo,System.currentTimeMillis()/1000,
      wallet,"$host:8081/did/poke/")
    return "{\"appPk\":\"${Base58Btc.encode(wallet.pk)}\",\"authInfo\":\"$content\"}"
  }

  @RequestMapping("/poke", method = [RequestMethod.POST])
  @ResponseBody
  fun pokePost(@RequestBody data:String):String{
    val body = Gson().fromJson(data, DidRequestBody::class.java)
    val claims =DidAuthUtils.parseJWT(body.userInfo).requestedClaims
    val claim = Gson().fromJson(claims[0],SignatureClaim::class.java)

    val tx = Type.Transaction.getDefaultInstance().toBuilder().mergeFrom(Base58Btc.decode(claim.origin))
      .setSignature(ByteString.copyFrom(Base58Btc.decode(claim.sig))).build()

    val rst = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).build())
    logger.info("hash:${rst.code}")
    return "{\"hash\":\"${rst.hash}\"}"
  }

}

class SwapClaim(override val meta: MetaInfo, var offerAssets: Array<String>,
                var offerChain:String, var demandToken: String, var demandChain: String, var swapAddr: String
): IClaim {
  val type = "swap"
}
