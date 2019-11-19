package io.arcblock.forge.did.bean

import com.google.gson.JsonObject

class ProfileClaim  @JvmOverloads constructor(override val meta: JsonObject? = null, var items: List<String>, override val description: String, override val typeUrl: String? = null) : IClaim {
  val type = ClaimType.PROFILE.toString()
}
