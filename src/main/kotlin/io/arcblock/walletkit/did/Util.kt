package io.arcblock.walletkit.did

import io.arcblock.walletkit.utils.Base58Btc


/**
 * Author       :paperhuang
 * Time         :2019/2/14
 * Edited By    :
 * Edited Time  :
 **/

object Util{


  fun decodeDidRoleType(did: String):RoleType{
    return Util.decodeDidRoleType(Base58Btc.decode(did.removePrefix("did:abt:")))
  }

  fun decodeDidHashType(did: String):HashType{
    return Util.decodeDidHashType(Base58Btc.decode(did.removePrefix("did:abt:")))
  }

  fun decodeDidSignType(did: String):KeyType {
    return Util.decodeDidSignType(Base58Btc.decode(did.removePrefix("did:abt:")))
  }

  fun decodeDidRoleType(did: ByteArray):RoleType{
    val type =  did.sliceArray(0..1)
    val x = type[0].toInt().shl(8)+type[1].toInt()
    return RoleType.values()[x.and(0b1111110000000000).shr(10)]

  }

  fun decodeDidHashType(did: ByteArray):HashType{
    val type =  did.sliceArray(0..1)
    val x = type[0].toInt().shl(8)+type[1].toInt()
    return HashType.values()[x.and(0b11111)]
  }


  fun decodeDidSignType(did: ByteArray):KeyType {
    val type =  did.sliceArray(0..1)
    val x = type[0].toInt().shl(8)+type[1].toInt()
    return KeyType.values()[x.and(0b0000001111100000).shr(5)]
  }

}



