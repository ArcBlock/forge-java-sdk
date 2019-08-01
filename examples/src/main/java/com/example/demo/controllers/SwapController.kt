package com.example.demo.controllers

import com.example.demo.components.ForgeSDKComponent
import com.google.common.io.BaseEncoding
import com.google.gson.Gson
import com.google.protobuf.ByteString
import forge_abi.Rpc
import forge_abi.Type
import io.arcblock.forge.TransactionFactory
import io.arcblock.forge.did.DidAuthUtils
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.did.bean.AppInfo
import io.arcblock.forge.did.bean.DidRequestBody
import io.arcblock.forge.did.bean.IClaim
import io.arcblock.forge.did.bean.MetaInfo
import io.arcblock.forge.did.bean.ProfileClaim
import io.arcblock.forge.did.bean.SignatureClaim
import io.arcblock.forge.utils.Base58Btc
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController






@RestController
@RequestMapping("/did")
class SwapController {
  var logger = LoggerFactory.getLogger(javaClass)

  @Autowired
  lateinit var forge: ForgeSDKComponent
  @Autowired
  lateinit var app: AppInfo

//  val sk = BaseEncoding.base64().decode("dxX9ASBY+BTNayyTnIRC4A8QadAFi3F+GuE3+It8ltcM0h56H8xeJqTHn2w03uEfKJ801fjmeaygaIt0rHBaNg==")
//  val pk = BaseEncoding.base64().decode("DNIeeh/MXiakx59sNN7hHyifNNX45nmsoGiLdKxwWjY=")
//  val addr = DIDGenerator.pk2did(RoleType.ACCOUNT, KeyType.ED25519, HashType.SHA3, pk).removePrefix("did:abt:")


  val sk = BaseEncoding.base16().decode("B4C1FED5090DD64518C20EAF5F1636CB4C2A68456A945161192635EFB83C675275CB8DA37D1FBE381AD7190ACE1C87E4D1312A689B2605F4C27A2C9E1CE63CC5")
  val pk = BaseEncoding.base16().decode("75CB8DA37D1FBE381AD7190ACE1C87E4D1312A689B2605F4C27A2C9E1CE63CC5")
  val addr = "z1ewYeWM7cLamiB6qy6mDHnzw1U5wEZCoj7"

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
    val hash = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).build()).hash
    return "{\"hash\":\"$hash\"}"
  }

}

class SwapClaim(override val meta: MetaInfo, var offerAssets: Array<String>,
                var offerChain:String, var demandToken: String, var demandChain: String, var swapAddr: String
): IClaim {
  val type = "swap"
}
