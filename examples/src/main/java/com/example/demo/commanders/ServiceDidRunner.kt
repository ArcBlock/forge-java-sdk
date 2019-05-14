package com.example.demo.commanders

import com.example.demo.beans.AppDid
import com.example.demo.components.ForgeSDKComponent
import forge_abi.Rpc
import io.arcblock.forge.bip44.Bip44Utils
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.KeyType
import io.arcblock.forge.did.RoleType
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.did.bean.AppInfo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.annotation.Resource

@Component
class ServiceDidRunner : CommandLineRunner {

  var logger = LoggerFactory.getLogger(javaClass)

  @Resource(name = "a")
  lateinit var appDid: AppDid
  @Autowired
  lateinit var forgeSDKComponent: ForgeSDKComponent
  @Autowired
  lateinit var appInfo: AppInfo
  @Value("\${forge.host}")
  lateinit var host: String
  @Value("\${forge.port}")
  lateinit var port: String
  @Autowired lateinit var walletInfo: WalletInfo

  override fun run(vararg args: String?) {
    logger.info("Init Service Self DID")
    val seed = Bip44Utils.genSeed("abc", "ccd", "")
    val kp = Bip44Utils.genKeyPair(seed)
    val did = DIDGenerator.sk2did(RoleType.APPLICATION, KeyType.ED25519, HashType.SHA3, kp.privateKey.toByteArray())

    val response = forgeSDKComponent.forgeSDK.getChainInfo(Rpc.RequestGetChainInfo.getDefaultInstance())
    appDid.chainInfo = response.info
    val forgeState = forgeSDKComponent.forgeSDK.getForgeState(Rpc.RequestGetForgeState.getDefaultInstance())
    appInfo.chainHost = "http://$host:8210"
    appInfo.chainId = response.info.network
    appInfo.chainToken = forgeState.state.token.symbol
    appInfo.chainVersion = response.info.version
    appInfo.copyright = ""
    appInfo.decimals = forgeState.state.token.decimal
    appInfo.description = "Java sdk demo"
    appInfo.icon = ""
    appInfo.name = "Application name"
    appInfo.path = "https://abtwallet.io/i/"
    appInfo.publisher = did
    appInfo.subtitle = "Sub title"

    walletInfo.address = did.removePrefix("did:abt:")
    walletInfo.sk = kp.privateKey.toByteArray().sliceArray(0..31)
    walletInfo.pk = kp.publicKey.toByteArray()
  }
}
