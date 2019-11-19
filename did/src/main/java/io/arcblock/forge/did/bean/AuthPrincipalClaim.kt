package io.arcblock.forge.did.bean

import com.google.gson.JsonObject

class AuthPrincipalClaim  @JvmOverloads constructor(override val meta: JsonObject? = null,target: String? = null, override val
typeUrl: String?) : IClaim {
  val type = ClaimType.AUTHPRINCIPAL.toString()

  override val description = "Please set the authentication principal."

}
