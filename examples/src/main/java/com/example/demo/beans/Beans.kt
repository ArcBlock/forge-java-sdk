package com.example.demo.beans

import com.google.gson.*
import forge_abi.*
import org.springframework.context.annotation.*

@Configuration
open class Beans {
    var appDidA = AppDid()
    var appDidB = AppDid()

    @Bean(name = ["a"]) open fun provideAppDid():AppDid {
        return appDidA;
    }

    @Bean(name = ["b"]) open fun provideAppDidB():AppDid {
        return appDidB
    }


    @Bean open fun provideGson(): Gson{
        return Gson()
    }
    @Bean(name = ["token"]) fun provideWallet():Rpc.ResponseCreateWallet{
        return Rpc.ResponseCreateWallet.getDefaultInstance()
    }


}