package io.arcblock.forge.did.bean

import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.DidAuthUtils
import io.arcblock.forge.did.DidUtils
import io.arcblock.forge.utils.Base58Btc

class DIDTokenBody(
  var action: String,
  var appInfo: AppInfo,
  var requestedClaims: Array<IClaim>,
  var url: String,
  var exp: String,
  var iat: String,
  var iss: String,
  var nbf: String
) {
  /**
   * verify JWT issuer is no difference
   * @param pk user's PK base58btc
   */
  fun verifyJWTDID(token: String, pk: String): Boolean {
    return verifyJWTDID(token, Base58Btc.decode(pk))
  }

  /**
   * check pk is matched with iss and signature is correct
   */
  fun verifyJWTDID(token: String, pk: ByteArray): Boolean {
    val did = Base58Btc.decode(iss)
    return (DIDGenerator.pk2did(DidUtils.decodeDidRoleType(did), DidUtils.decodeDidSignType(did), DidUtils.decodeDidHashType(did),
        pk) != iss) && DidAuthUtils.verifyJWTSig(token, pk, DidUtils.decodeDidSignType(pk).name)
  }

  /**
   * verify JWT is not be expired
   * @param currentTimestamp TimeUnit is TimeUnit.MILLISECONDS
   */
  fun verifyJWTExpired(currentTimestamp: Long): Boolean {
    try {
      return currentTimestamp <= exp.toLong() && currentTimestamp >= nbf.toLong()
    } catch (e: Exception) {
      e.printStackTrace()
      return false
    }
    return true
  }
}
