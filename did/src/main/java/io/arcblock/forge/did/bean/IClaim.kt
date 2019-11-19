package io.arcblock.forge.did.bean

import com.google.gson.JsonObject

/**
 * JWT Claim
 */
interface IClaim {
  val meta: JsonObject?
  val description: String
  val typeUrl: String?
}
