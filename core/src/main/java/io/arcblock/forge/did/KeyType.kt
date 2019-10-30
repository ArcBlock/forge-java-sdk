package io.arcblock.forge.did

/**
 * Signature type:
 * ED25519
 * SECP256K1
 *
 **/
enum class KeyType(val value:Int) {
  ED25519(0), SECP256K1(1);
  companion object {
    private val values = values()
    fun fromInt(value: Int) = values.firstOrNull { it.value == value } ?: ED25519
  }

}
