package io.arcblock.forge.did.bean

class AuthPrincipalClaim(override val meta: MetaInfo, target: String? = null) : IClaim {
  val type = ClaimType.AUTHPRINCIPAL.toString()
  val description = "Please set the authentication principal."

}
