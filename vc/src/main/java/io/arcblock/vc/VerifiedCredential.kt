package io.arcblock.vc

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.arcblock.forge.did.HashType
import io.arcblock.forge.extension.encodeB64Url
import io.arcblock.forge.extension.hash
import io.arcblock.forge.extension.sign
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class VerifiedCredential {
  var id: String = ""
  var type: Array<String> = arrayOf()
  var issuer: String = ""
  var issuanceDate: String = ""
  lateinit var credentialSubject: ICredentialSubject

  fun stringtifyVC(sig: String? = null): String {
    val map = hashMapOf<String, Any>(
      "@context" to "https://schema.arcblock.io/v0.1/context.jsonld",
      "id" to id,
      "type" to type,
      "issuer" to issuer,
      "issuanceDate" to issuanceDate,
      "credentialSubject" to credentialSubject.jsonMap()
    )
//    "proof": {
//      "type": "Ed25519Signature",
//      "created": "2017-06-18T21:19:10Z",
//      "proofPurpose": "assertionMethod",
//      "jws": "eyJhbGciOiJSUzI1NiIsImI2NCI6ZmFsc2UsImNyaXQiOlsiYjY0Il19..TCYt5X
//      sITJX1CxPCT8yAV-TVkIEq_PbChOMqsLfRoPsnsgw5WEuts01mq-pQy7UJiN5mgRxD-WUc
//      X16dUEMGlv50aqzpqh4Qktb3rk-BuQy72IFLOqV0G_zS245-kronKb78cPN25DGlcTwLtj
//      PAYuNzVBAh4vGHSrQyHUdBBPM"
//    }
    if (!sig.isNullOrBlank()) {
      map["proof"] = hashMapOf<String, Any>(
        "type" to "Ed25519Signature",
        "created" to SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(Date().time),
        "proofPurpose" to "assertionMethod",
        "jws" to sig
      )
    }
    val om = ObjectMapper()
    om.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
    return om.writeValueAsString(map)
  }


  companion object {
    @Throws(ParseVCException::class)
    fun parseVC(vc: String): VerifiedCredential {
      val om = ObjectMapper()
      val node = om.readTree(vc)
      return VerifiedCredential().apply {
        this.id = node["id"].asText()
        this.type = om.readValue(node["type"].toString(), object : TypeReference<Array<String>>() {})
        this.issuanceDate = node["issuanceDate"].asText()
        this.credentialSubject = when {
          this.type.contains(CredentialSubjectType.EMAIL_VERIFiED.toString())
          -> EmailVerifiedCredential(node["credentialSubject"]["id"].asText(), node["credentialSubject"]["emailVerifiedDigest"].asText())
          this.type.contains(CredentialSubjectType.RBAC_VERIFIEDCREDENTIAL.toString())
          -> RBACVerifiedCredential(node["credentialSubject"]["id"].asText(), node["credentialSubject"]["resource"].asText(), om.readValue(node["credentialSubject"]["scope"].toString(), object : TypeReference<MutableList<String>>() {}))
          this.type.contains(CredentialSubjectType.DID_CONNECT_AUTHORIZATION_VERIFIEDCREDENTIAL.toString())
          -> DIDConnectAuthorizationVerifiedCredential(node["credentialSubject"]["issuer"].asText(), om.readValue(node["credentialSubject"]["ops"].toString(), object : TypeReference<MutableList<String>>() {}))
          else -> throw ParseVCException(VCError.UNSUPPORT_CREDENTIAL, "un support type")
        }
      }
    }

    fun signVC(vc: VerifiedCredential, sk: ByteArray): String {
      val sig = vc.stringtifyVC().toByteArray().hash(HashType.SHA3).sign(sk).encodeB64Url()
      return vc.stringtifyVC(sig)
    }

  }
}
