package io.arcblock.forge.did.bean

import com.google.gson.JsonObject

/**
 * Signature type provide a origin transaction, If user want to sent this transaction ,just need
 * signature this transaction and return result .
 * @sig signature user return
 * @origin : transaction origin binary to Base58
 * @data: transaction binary hash result to base58
 */
class SignatureClaim @JvmOverloads constructor(var sig: String, var origin: String, var data: String, override val description: String,
                                               override val typeUrl: String? = null, override val meta: JsonObject? = null) : IClaim {
  val type = ClaimType.SIGNATURE.toString()
}
