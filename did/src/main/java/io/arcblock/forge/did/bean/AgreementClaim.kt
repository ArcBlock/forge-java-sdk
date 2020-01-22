package io.arcblock.forge.did.bean

import com.google.gson.JsonObject

/**
 * agreement type sent a doc to user so user can signature it and return it.
 * @uri document uri
 * @hash document hash info
  */
class AgreementClaim @JvmOverloads constructor(var uri: String, var hash: AgreementHash, override val description: String, override
val typeUrl: String? = null,override val meta: JsonObject? = null) : IClaim {
  val type = ClaimType.AGREEMENT.toString()
}

class AgreementHash(var method: String, var digest: String)
