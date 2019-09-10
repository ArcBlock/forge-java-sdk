package io.arcblock.forge.did

/**
 * Signature type:
 * ED25519
 * SECP256K1
 *
 **/
enum class KeyType(val value:Int) {
  ED25519(0), SECP256K1(1)
}
