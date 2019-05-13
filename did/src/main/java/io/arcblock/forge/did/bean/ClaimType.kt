package io.arcblock.forge.did.bean

/**
 * Current support Claim Types
 */
enum class ClaimType {

  /**
   * profile type can require client return user's profile such as: username, phone or avatar
   */
  PROFILE{
    override fun toString(): String {
      return "profile"
    }
  },

  /**
   * agreement type sent a doc to user so user can signature it and return it.
   */
  AGREEMENT{
    override fun toString(): String {
      return "agreement"
    }
  },




  /**
   * Signature type provide a origin transaction, If user want to sent this transaction ,just need
   * signature this transaction and return result .
   */
  SIGNATURE{
    override fun toString(): String {
      return "signature"
    }
  },

  /**
   * DID type require user to provide an asset or an account DID to proof he match some case.
   * such as: proof his account has enough Token or he has a target asset.
   */
  DID{
    override fun toString(): String {
      return "did"
    }
  }

}
