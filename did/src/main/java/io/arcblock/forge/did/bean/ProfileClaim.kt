package io.arcblock.forge.did.bean

class ProfileClaim(override val meta: MetaInfo, var items: List<String>) : IClaim {
  val type = ClaimType.PROFILE.toString()
}
