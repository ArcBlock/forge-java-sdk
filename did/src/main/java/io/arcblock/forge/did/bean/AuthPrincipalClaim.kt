package io.arcblock.forge.did.bean

import com.google.gson.JsonObject

class AuthPrincipalClaim  @JvmOverloads constructor(target: String? = null, override val meta: JsonObject? = null,override val
typeUrl: String? = null) : IClaim {


  val type = ClaimType.AUTHPRINCIPAL.toString()
  override val description = "Please set the authentication principal."

}
