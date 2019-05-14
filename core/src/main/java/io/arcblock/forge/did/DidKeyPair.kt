package io.arcblock.forge.did

import io.arcblock.forge.WalletKit
import io.arcblock.forge.did.KeyType.ED25519
import io.arcblock.forge.did.KeyType.SECP256K1
import org.web3j.crypto.ECKeyPair

/**
 * Generate KeyPair for Forge
 * There are two types:  ED25519 and SECP256K1
 * You have to provide master Seed
 * Author       :paperHuang
 * Time         :2019/2/19
 * Edited By    :
 * Edited Time  :
 **/
class DidKeyPair(keyType: KeyType, seed: ByteArray) {

  var privateKey: ByteArray
  var publicKey: ByteArray

  init {
    when (keyType) {
      ED25519 -> {

        publicKey = WalletKit.sk2pk(keyType, seed)
        privateKey = seed + publicKey
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
