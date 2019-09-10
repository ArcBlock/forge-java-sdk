package com.example.demo.controllers

import com.example.demo.components.ForgeSDKComponent
import com.google.common.io.BaseEncoding
import com.google.gson.Gson
import forge_abi.Rpc
import io.arcblock.forge.TransactionFactory
import io.arcblock.forge.TypeUrls
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.DidAuthUtils
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.did.bean.AppInfo
import io.arcblock.forge.did.bean.MetaInfo
import io.arcblock.forge.did.bean.SignatureClaim
import io.arcblock.forge.signTx
import io.arcblock.forge.utils.Base58Btc
import io.arcblock.forge.utils.address
import io.arcblock.forge.utils.encodeB58
import io.arcblock.forge.utils.hash
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress

/**
 *
 *     █████╗ ██████╗  ██████╗██████╗ ██╗      ██████╗  ██████╗██╗  ██╗
 *    ██╔══██╗██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗██╔════╝██║ ██╔╝
 *    ███████║██████╔╝██║     ██████╔╝██║     ██║   ██║██║     █████╔╝
 *    ██╔══██║██╔══██╗██║     ██╔══██╗██║     ██║   ██║██║     ██╔═██╗
 *    ██║  ██║██║  ██║╚██████╗██████╔╝███████╗╚██████╔╝╚██████╗██║  ██╗
 *    ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝
 * Author       : shan@arcblock.io
 * Time         : 2019-08-07
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
@RestController
@RequestMapping("/delegate")
class DelegateControler {

  final var logger = LoggerFactory.getLogger(javaClass)
  val gson = Gson()
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
  var ip = InetAddress.getLocalHost().hostAddress

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


  @RequestMapping("/", method = [RequestMethod.GET])
  @ResponseBody
  fun delegate():String {
    val w = DIDGenerator.randomWallet()
    val declare = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(TransactionFactory.declare(app.chainId,w).signTx(w.sk)).build())
    logger.info("declare======>\n ${declare.toString()}")
    val tx=  TransactionFactory.unsignDelegate(addr,w.address.address(),app.chainId,wallet, listOf("itx.value <= 100000000000000")).signTx(wallet.sk)
    logger.info("delegate========>\n${tx.itx}")
    val rst = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).setCommit(true).build())
    logger.info("delegate ->>>>>>> \n $rst")
    return "{" +
      "\"SECRET_KEY\":\"${Base58Btc.encode(w.sk)}\"" +
      "\"APP_KEY\":\"${Base58Btc.encode(wallet.pk)}\""+
      "}"
  }



  @RequestMapping("/sign/delegate", method = [RequestMethod.GET])
  @ResponseBody
  fun signDelegate(from: String):String {
    val w = DIDGenerator.randomWallet()
    val declare = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(TransactionFactory.declare(app.chainId,w).signTx(w.sk)).build())
    logger.info("declare======>\n ${declare.toString()}")
    val tx=  TransactionFactory.unsignDelegate(from,w.address.address(),app.chainId,wallet, listOf("itx.value <= 100000000000000"))

    val claim = SignatureClaim(MetaInfo("Mock data",""),sig = "",origin = tx.toByteArray().encodeB58(),data = tx.toByteArray().hash(HashType.SHA3).encodeB58())

    val content = DidAuthUtils.createDidAuthToken(arrayOf(claim),appInfo,System.currentTimeMillis()/1000,
      wallet,"$host:8081/sign/delegate")
    return "{\"appPk\":\"${Base58Btc.encode(wallet.pk)}\",\"authInfo\":\"$content\"}"
  }





  @RequestMapping("/revoke", method = [RequestMethod.GET])
  @ResponseBody
  fun revokeDelegate(to: String):String {
    val tx=  TransactionFactory.unsignRevokeDelegate(addr,to,app.chainId,wallet, listOf(TypeUrls.TRANSFER)).signTx(wallet.sk)
    logger.debug("undelegate========>\n${tx.itx}")
    val rst = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).setCommit(true).build())
    logger.debug("undelegate ->>>>>>> \n $rst")
    return "rst : $rst"
  }


}
