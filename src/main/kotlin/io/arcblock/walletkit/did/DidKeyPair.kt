package io.arcblock.walletkit.did

import com.google.crypto.tink.subtle.Ed25519Sign
import io.arcblock.walletkit.did.KeyType.ED25519
import io.arcblock.walletkit.did.KeyType.SECP256K1
import org.web3j.crypto.ECKeyPair

/**
 * Author       :paperhuang
 * Time         :2019/2/19
 * Edited By    :
 * Edited Time  :
 **/
class DidKeyPair( keyType: KeyType,seed:ByteArray) {

  var privateKey:ByteArray
  var publicKey:ByteArray

  init {
    when(keyType){
      ED25519 ->{

        publicKey = IdGenerator.sk2pk(keyType,seed)
        privateKey = seed+publicKey
      }
      SECP256K1 -> {
        ECKeyPair.create(seed).let {
          privateKey = it.privateKey.toByteArray()
          publicKey = it.publicKey.toByteArray()
        }
      }
    }
  }
}