package io.arcblock.forge

import com.google.crypto.tink.subtle.Ed25519Sign
import com.google.protobuf.Any
import com.google.protobuf.ByteString
import forge_abi.Poke
import forge_abi.Rpc
import forge_abi.Transfer
import forge_abi.Type
import io.arcblock.forge.did.KeyType
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.signer.Signer
import org.web3j.crypto.ECKeyPair
import java.time.LocalDate

/**
 * This kit can help you to generate a Wallet with master Seed, private key and public key
 *
 */
object WalletUtils {

  /**
   * generate PK from SK.
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



  fun createTranserTx(wallet: WalletInfo,  chainID: String, itx: Transfer.TransferTx): Type.Transaction {
    return WalletUtils.createTx(wallet,System.currentTimeMillis(),chainID, Any.newBuilder()
      .setTypeUrl(TypeUrls.TRANSFER)
      .setValue(itx.toByteString())
      .build()
    )
  }

  /**
   * create transaction by wallet and itx: TransferTx, ExchangeTx, CreateTx...
   */
  fun createTx(wallet: WalletInfo, nonce: Long, chainID: String, itx: Any): Type.Transaction {
    val unTx = Type.Transaction.newBuilder()
      .setChainId(chainID).setFrom(wallet.address)
      .setPk(ByteString.copyFrom(wallet.pk))
      .setNonce(nonce)
      .setItx(itx)
      .build()
    return sign(wallet, unTx)
  }

  /**
   * create a PokeTx to get some token
   */
  fun poke(wallet: WalletInfo, forge: ForgeSDK, chainID: String): Type.Transaction {
    return WalletUtils.poke(wallet,forge, System.currentTimeMillis(),chainID)
  }

  fun poke(wallet: WalletInfo, forge: ForgeSDK, nonce: Long, chainID: String): Type.Transaction {
    val forgeState = forge
      .getForgeState(Rpc.RequestGetForgeState.newBuilder()
        .build())

    val itx = Poke.PokeTx.newBuilder()
      .setAddress(forgeState.getState().getPokeConfig().getAddress())
      .setDate(LocalDate.now().toString())
      .build()
    return createTx(wallet,nonce,chainID,Any.newBuilder().setTypeUrl(TypeUrls.POKE)
      .setValue(itx.toByteString())
      .build())
  }

  /**
   *  signature a transaction by a wallet
   */
  fun sign(wallet: WalletInfo, tx: Type.Transaction): Type.Transaction {
    val unSigTx = tx.toBuilder().setFrom(wallet.address)
            .setPk(ByteString.copyFrom(wallet.pk))
      .setSignature(ByteString.EMPTY).build()
    val sig = Signer.sign(wallet.getSignType(),
      Hasher.hash(wallet.getHashType(), unSigTx.toByteArray()), wallet.sk)
    return unSigTx.toBuilder().setSignature(ByteString.copyFrom(sig)).build()
  }

  /**
   * multi sign when make Exchange
   */
  fun multiSigExchange(wallet: WalletInfo, tx: Type.Transaction): Type.Transaction {
    val multiSig = Type.Multisig.newBuilder().setSigner(wallet.address)
      .setPk(ByteString.copyFrom(wallet.pk)).build()
    val unSigTx = tx.toBuilder().addSignatures(multiSig).build()
    val sig = Signer.sign(wallet.getSignType(),
      Hasher.hash(wallet.getHashType(), unSigTx.toByteArray()), wallet.sk)
    return tx.toBuilder().setSignatures(0, multiSig.toBuilder().setSignature(ByteString.copyFrom(sig)).build())
      .build()
  }
}
