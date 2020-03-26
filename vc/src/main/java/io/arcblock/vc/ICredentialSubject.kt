package io.arcblock.vc

import com.fasterxml.jackson.databind.JsonNode
import java.util.HashMap

interface ICredentialSubject {
  fun jsonMap(): HashMap<String, Any>
}

enum class CredentialSubjectType {
  EMAIL_VERIFiED{
    override fun toString(): String {
      return "emailVerified"
    }
  },

  RBAC_VERIFIEDCREDENTIAL {
    override fun toString(): String {
      return "RBACVerifiedCredential"
    }
  },

  DID_CONNECT_AUTHORIZATION_VERIFIEDCREDENTIAL {
    override fun toString(): String {
      return "DIDConnectAuthorizationVerifiedCredential"
    }
  }


}

class EmailVerifiedCredential(var id: String, var emailVerifiedDigest: String) : ICredentialSubject {
  constructor() : this("", "")

  override fun jsonMap(): HashMap<String, Any> {
    return hashMapOf(CredentialSubjectType.EMAIL_VERIFiED.toString() to hashMapOf(
      "emailDigest" to emailVerifiedDigest,
      "method" to "SHA3"
    ))
  }
}

class RBACVerifiedCredential(var id: String = "", var resource: String = "", val scope: MutableList<String> = mutableListOf()) : ICredentialSubject {

  override fun jsonMap(): HashMap<String, Any> {
    return hashMapOf(CredentialSubjectType.RBAC_VERIFIEDCREDENTIAL.toString() to hashMapOf(
      "resource" to resource,
      "scope" to scope
    ))
  }

}

class DIDConnectAuthorizationVerifiedCredential(var issuer: String = "",
                                                val ops: MutableList<String> = mutableListOf()
) : ICredentialSubject {
  override fun jsonMap(): HashMap<String, Any> {
    return hashMapOf(CredentialSubjectType.DID_CONNECT_AUTHORIZATION_VERIFIEDCREDENTIAL.toString() to hashMapOf(
      "issuer" to issuer,
      "ops" to ops
    ))
  }

}
