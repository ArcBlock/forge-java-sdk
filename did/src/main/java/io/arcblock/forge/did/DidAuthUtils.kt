package io.arcblock.forge.did

import com.google.common.io.BaseEncoding
import com.google.gson.Gson
import io.arcblock.forge.did.bean.AppInfo
import io.arcblock.forge.did.bean.DIDTokenBody
import io.arcblock.forge.did.bean.DIDTokenResponse
import io.arcblock.forge.did.bean.IClaim
import io.arcblock.forge.sign.Signer
import org.apache.commons.lang3.StringEscapeUtils
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
  fun createDidAuthToken(authClaims: Array<IClaim>, appInfo: AppInfo, currentTimestamp: Long, wallet: WalletInfo,url :String= ""): String {
    val exp = (currentTimestamp + 60 * 1000).toString()
    val body = DIDTokenBody(action = "responseAuth", appInfo = appInfo, requestedClaims = authClaims, url = url, exp = exp,
      iat = currentTimestamp.toString(), iss = appInfo.publisher, nbf = currentTimestamp.toString()
    )

    val jsonHeader = Header(wallet.getSignType().toString().toUpperCase(), "JWT")
    val content = BaseEncoding.base64Url().encode(gs.toJson(jsonHeader).toByteArray()).replace("=", "")
      .plus(".")
      .plus(BaseEncoding.base64Url().encode(gs.toJson(body).toByteArray()).replace("=", ""))

    val signature = Signer.sign(KeyType.ED25519, content.toByteArray(), wallet.sk)
    return content.plus(".").plus(StringEscapeUtils.unescapeJava(BaseEncoding.base64Url().encode(signature)))
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
