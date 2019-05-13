package com.example.demo.services

import com.google.gson.Gson
import io.arcblock.forge.did.DidAuthUtils
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.did.bean.AppInfo
import io.arcblock.forge.did.bean.DidResponseBody
import io.arcblock.forge.did.bean.MetaInfo
import io.arcblock.forge.did.bean.ProfileClaim
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl : IAuthService {

  @Autowired
  lateinit var appInfo: AppInfo
  @Autowired lateinit var walletInfo: WalletInfo
  @Autowired lateinit var metaInfo: MetaInfo
  @Autowired lateinit var gson: Gson

  override fun requestAuth(jwt: String): String {
    val claim = ProfileClaim(metaInfo, listOf("Username", "email"))
    val token = DidAuthUtils.createDidAuthToken(appInfo = appInfo, authClaims = arrayOf(claim), currentTimestamp = System.currentTimeMillis(), wallet = walletInfo)
    return gson.toJson(DidResponseBody(appPk = walletInfo.pkBase58(), authInfo = token))
  }

  override fun handleAuth(token: String, jwt: String): String {
    return "ok"
  }
}
