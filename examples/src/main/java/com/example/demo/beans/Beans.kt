package com.example.demo.beans

import com.google.gson.Gson
import forge_abi.Rpc
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
  var wallet = WalletInfo("")
  var meta = MetaInfo("meta info", "what ?")

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
    return wallet
  }

  @Bean
  fun provideMetaInfo(): MetaInfo {
    return meta
  }
}
