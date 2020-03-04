package io.arcblock.forge.did

import com.google.common.io.BaseEncoding
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.arcblock.forge.did.bean.*
import io.arcblock.forge.extension.did
import io.arcblock.forge.extension.encodeB64Url
import io.arcblock.forge.sign.Signer
import org.apache.commons.text.StringEscapeUtils
import org.slf4j.LoggerFactory

object DidAuthUtils {
  var logger = LoggerFactory.getLogger(javaClass)
  val gs = Gson()

  /**
   * create a JWT token to response client query and to require some information from client
   * @param authClaims: Claims you require
   * @param appInfo: current Application information provide to client
   * @param currentTimestamp: current time .
   * @param wallet: application key info .
   */
  @JvmOverloads
  fun createDidAuthToken(authClaims: Array<out IClaim>, appInfo: AppInfo, chainInfo: ChainInfo, currentTimestamp: Long, wallet: WalletInfo, url: String =
    "",
                         others: JsonObject? = null): String {
    val exp = (currentTimestamp + 60).toString()
    val body = gs.toJsonTree(DIDTokenBody(action = "responseAuth", appInfo = appInfo, requestedClaims = authClaims, url = url, exp = exp,
      iat = currentTimestamp.toString(), iss = wallet.address.did(), nbf = currentTimestamp.toString()
    ))
      .asJsonObject
    body.add("chainInfo", gs.toJsonTree(chainInfo))
    others?.keySet()
      ?.forEach { body.add(it, others[it]) }
    val jsonHeader = Header(wallet.getSignType().toString().toUpperCase(), "JWT")
    val content = gs.toJson(jsonHeader)
      .toByteArray()
      .encodeB64Url()
      .replace("=", "")
      .plus(".")
      .plus(StringEscapeUtils.unescapeJson(body.toString()).toByteArray().encodeB64Url().replace("=", ""))

    val signature = Signer.sign(KeyType.ED25519, content.toByteArray(), wallet.sk)
    return content.plus(".")
      .plus(StringEscapeUtils.unescapeJava(signature.encodeB64Url()))
      .replace("=", "")

  }

  fun parseJWT(token: String): DIDTokenResponse {
    val jwt = token.split(".")
    val body = String(BaseEncoding.base64Url().decode(jwt[1]))
    return gs.fromJson(body, DIDTokenResponse::class.java)
  }

  /**
   * verify JWT signature
   */
  fun verifyJWTSig(token: String, pk: ByteArray, type: String): Boolean {
    val sig = token.substringAfterLast(".")
    val content = token.substringBeforeLast(".")

    return if (KeyType.ED25519.toString().toLowerCase() == type.toLowerCase()) {
      Signer.verify(KeyType.ED25519, content.toByteArray(), pk, BaseEncoding.base64Url().decode(sig))
    } else {
      Signer.verify(KeyType.SECP256K1, content.toByteArray(), pk, BaseEncoding.base64Url().decode(sig))
    }
  }
}
