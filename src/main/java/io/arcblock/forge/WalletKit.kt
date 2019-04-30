package io.arcblock.forge


import com.google.crypto.tink.subtle.*
import io.arcblock.forge.bip44.Bip44Utils
import io.arcblock.forge.did.*
import java.util.Collections
import org.bitcoinj.wallet.DeterministicSeed
import org.web3j.crypto.ECKeyPair

/**
 * This kit can help you to generate a Wallet with master Seed, private key and public key
 *
 *
 * Author       :paperhuang
 * Time         :2019/1/3
 * Edited By    :
 * Edited Time  :
 */
object WalletKit {

  /**
   *
   *
   *
   */
  fun sk2pk(keyType: KeyType, sk: ByteArray): ByteArray {
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


  private var seed: DeterministicSeed? = null


  fun genMnimonics(): List<String>? {
        if (seed == null)
            throw RuntimeException("You have't create a wallet")
        return if (seed == null) emptyList() else seed!!.mnemonicCode
    }

    fun createWallet(secretCode: String, recoverCode: String): ECKeyPair {
        seed = Bip44Utils.genSeed(secretCode, recoverCode, "")

        return Bip44Utils.genKeyPair(seed)
    }

    fun recoverWallet(secretCode: String, recoverCode: String): ECKeyPair {
        seed = Bip44Utils.genSeed(secretCode, recoverCode, "")
        return Bip44Utils.genKeyPair(seed)
    }

//    fun getSeed(): DeterministicSeed {
//        if (seed == null)
//            throw RuntimeException("You have't create a wallet")
//        return seed
//    }

}
