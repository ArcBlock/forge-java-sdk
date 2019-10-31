package io.arcblock.forge

import com.google.crypto.tink.subtle.Ed25519Sign
import forge_abi.Enum
import io.arcblock.forge.did.KeyType
import org.web3j.crypto.ECKeyPair

/**
 * This kit can help you to generate a Wallet with master Seed, private key and public key
 *
 */
object WalletUtils {

  /**
   * generate PK from SK.
   */
  fun sk2pk(keyType: KeyType = KeyType.ED25519, sk: ByteArray): ByteArray {
    return when (keyType) {
      KeyType.ED25519 -> {
        val signer = Ed25519Sign(sk.sliceArray(0..31))
        val pkField = signer.javaClass.getDeclaredField("publicKey")
        pkField.isAccessible = true
        pkField.get(signer) as ByteArray
      }
      KeyType.SECP256K1 -> {
        ECKeyPair.create(sk).getPK()
      }
    }
  }
  fun sk2pk(keyType: Enum.KeyType = Enum.KeyType.ed25519, sk: ByteArray): ByteArray {
    return when (keyType) {
      Enum.KeyType.secp256k1 -> {
        ECKeyPair.create(sk).getPK()
      }
    //Enum.KeyType.ed25519-> {
      else -> {
        val signer = Ed25519Sign(sk.sliceArray(0..31))
        val pkField = signer.javaClass.getDeclaredField("publicKey")
        pkField.isAccessible = true
        pkField.get(signer) as ByteArray
      }
    }
  }

}
