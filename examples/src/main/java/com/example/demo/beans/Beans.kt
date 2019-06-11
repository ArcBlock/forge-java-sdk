package com.example.demo.beans

import com.google.gson.Gson
import forge_abi.Rpc
import io.arcblock.forge.bip44.Bip44Utils
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.KeyType
import io.arcblock.forge.did.RoleType
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.did.bean.AppInfo
import io.arcblock.forge.did.bean.MetaInfo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class Beans {
  var appDidA = AppDid()
  var appDidB = AppDid()
  var appInfo = AppInfo()

  var meta = MetaInfo("meta info", "what ?")
  val seed = Bip44Utils.genSeed("abc", "ccd", "")
  val kp = Bip44Utils.genKeyPair(seed)
  val did = DIDGenerator.sk2did(RoleType.APPLICATION, KeyType.ED25519, HashType.SHA3, kp.privateKey.toByteArray())

  @Bean(name = ["a"])
  open fun provideAppDid(): AppDid {
    return appDidA
  }

  @Bean(name = ["b"])
  open fun provideAppDidB(): AppDid {
    return appDidB
  }

  @Bean
  open fun provideGson(): Gson {
    return Gson()
  }

  @Bean(name = ["token"])
  fun provideWallet(): Rpc.ResponseCreateWallet {
    return Rpc.ResponseCreateWallet.getDefaultInstance()
  }

  @Bean
  fun provideAppInfo(): AppInfo {
    return appInfo
  }

  @Bean
  fun provideWalletInfo(): WalletInfo {
    return WalletInfo(did.removePrefix("did:abt:"),kp.publicKey.toByteArray(),kp.privateKey.toByteArray().sliceArray(0..31))
  }



  @Bean
  fun provideMetaInfo(): MetaInfo {
    return meta
  }
}
