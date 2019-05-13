package io.arcblock.forge.did.bean

/**
 * Signature type provide a origin transaction, If user want to sent this transaction ,just need
 * signature this transaction and return result .
 * @sig signature user return
 * @origin : transaction origin binary to Base58
 * @data: transaction binary hash result to base58
 */
class SignatureClaim(override val meta: MetaInfo, var sig: String, var origin:String, var data: String) :IClaim {
  val type = ClaimType.SIGNATURE.toString()
}
