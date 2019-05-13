package io.arcblock.forge.did

import io.arcblock.forge.did.bean.AppInfo
import io.arcblock.forge.did.bean.MetaInfo
import io.arcblock.forge.did.bean.ProfileClaim
import org.junit.Test

class DidAuthUtilsTest {
  @Test
  fun createClaimToken() {
    // declare your application app info
    val appInfo = AppInfo()
    // declare a claim
    val claim1 = ProfileClaim(MetaInfo("profile info", ""), arrayListOf("username", "email"))
    val wallet = WalletInfo("zXXXXXXXX")
    // DidAuthUtils.createDidAuthToken(arrayOf(claim1),appInfo,System.currentTimeMillis(),wallet)
  }
}
