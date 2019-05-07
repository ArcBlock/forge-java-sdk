package com.example.demo.commanders

import com.example.demo.beans.*
import com.example.demo.components.*
import forge_abi.*
import io.arcblock.forge.bip44.*
import io.arcblock.forge.did.*
import org.slf4j.*

import org.springframework.beans.factory.annotation.*
import org.springframework.boot.*
import org.springframework.stereotype.*
import javax.annotation.*


@Component
class ServiceDidRunner :CommandLineRunner{
    var logger = LoggerFactory.getLogger(javaClass)
    @Resource(name = "a") lateinit var appDid:AppDid
    @Autowired lateinit var forgeSDKComponent: ForgeSDKComponent

    override fun run(vararg args: String?) {
        logger.info("Init Service Self DID")
        val seed =Bip44Utils.genSeed("abc","ccd","")
        val kp = Bip44Utils.genKeyPair(seed)
//        appDid.did = DIDGenerator.sk2did(RoleType.APPLICATION,KeyType.ED25519,HashType.SHA3,kp.privateKey.toByteArray())
      //  appDid.sk = kp.privateKey.toByteArray().sliceArray(0..31)
        val response = forgeSDKComponent.forgeSDK.getChainInfo(Rpc.RequestGetChainInfo.getDefaultInstance())
        appDid.chainInfo = response.info

    }
}
