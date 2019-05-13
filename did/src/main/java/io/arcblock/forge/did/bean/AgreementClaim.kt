package io.arcblock.forge.did.bean

/**
 * agreement type sent a doc to user so user can signature it and return it.
 * @uri document uri
 * @hash document hash info
  */
class AgreementClaim(override val meta: MetaInfo, var uri: String, var hash: AgreementClaim) :IClaim {
  val  type = ClaimType.AGREEMENT.toString()
}

class AgreementHash(var method:String, var digest: String)
