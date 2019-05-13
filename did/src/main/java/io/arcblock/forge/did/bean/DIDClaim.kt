package io.arcblock.forge.did.bean


/**
 * DID type require user to provide an asset or an account DID to proof he match some case.
 * such as: proof his account has enough Token or he has a target asset.
 * @param target asset name you wanted
 * @param did_type account or asset
 */
class DIDClaim(override val meta: MetaInfo,var did_type: String,var target: String) :IClaim {
  val type = "did"
}
