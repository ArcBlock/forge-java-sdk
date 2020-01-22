package io.arcblock.forge.did.bean

import com.google.gson.JsonObject

/**
 * DID type require user to provide an asset or an account DID to proof he match some case.
 * such as: proof his account has enough Token or he has a target asset.
 * @param target asset name you wanted
 * @param did_type account or asset
 */
class DIDClaim  @JvmOverloads constructor(var did_type: String, var target: String, override val description: String, override val typeUrl: String? =
  null,override val meta: JsonObject? = null) : IClaim {
  val type = "did"
}
