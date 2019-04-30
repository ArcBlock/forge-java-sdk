package io.arcblock.forge.did

import io.arcblock.forge.utils.Base58Btc


/**
 * Decode Wallet type from a did address
 * and tools to generate prefix bytes for did binary
 *
 **/

object Util{

  /**
   * decodeDidRoleType
   * @param did DID address no matter did:abt:xxx or zXXXXXX
   * @return RoleType
   */
  fun decodeDidRoleType(did: String):RoleType{
    return Util.decodeDidRoleType(Base58Btc.decode(did.removePrefix("did:abt:")))
  }

  /**
   * get HashType from your DID address
   * @param did DID address no matter did:abt:xxx or zXXXXXX
   */
  fun decodeDidHashType(did: String):HashType{
    return Util.decodeDidHashType(Base58Btc.decode(did.removePrefix("did:abt:")))
  }

  /**
   * get SignatureType from your DID address
   * @param did DID address no matter did:abt:xxx or zXXXXXX
   */
  fun decodeDidSignType(did: String):KeyType {
    return Util.decodeDidSignType(Base58Btc.decode(did.removePrefix("did:abt:")))
  }

  /**
   * get RoleType from your DID address
   * @param did DID binary :base58Btc decode from zXXXXXX
   */
  fun decodeDidRoleType(did: ByteArray):RoleType{
    val type =  did.sliceArray(0..1)
    val x = type[0].toInt().shl(8)+type[1].toInt()
    return RoleType.values()[x.and(0b1111110000000000).shr(10)]

  }

  /**
   * get Hash type from your DID address
   * @param did DID binary :base58Btc decode from zXXXXXX
   *
   */
  fun decodeDidHashType(did: ByteArray):HashType{
    val type =  did.sliceArray(0..1)
    val x = type[0].toInt().shl(8)+type[1].toInt()
    return HashType.values()[x.and(0b11111)]
  }

  /**
   * get SignatureType from your DID address
   * @param did DID binary :base58Btc decode from zXXXXXX
   *
   */
  fun decodeDidSignType(did: ByteArray):KeyType {
    val type =  did.sliceArray(0..1)
    val x = type[0].toInt().shl(8)+type[1].toInt()
    return KeyType.values()[x.and(0b0000001111100000).shr(5)]
  }

}



