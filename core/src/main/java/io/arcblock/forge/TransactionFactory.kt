package io.arcblock.forge

import com.google.protobuf.Any
import com.google.protobuf.ByteString
import forge_abi.*
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.utils.address
import java.time.LocalDate
import java.util.*

object TransactionFactory {

  private fun generateNonce(): Long {
    return System.currentTimeMillis()
  }


  /**
   * create a declare transaction without signature
   */
  fun declare(chainID: String, wallet: WalletInfo, moniker: String? = null): Type.Transaction {
    val itx = Declare.DeclareTx.newBuilder()
      .setMoniker(moniker
        ?: UUID.randomUUID().toString().replace("-", "")).setIssuer(wallet.address.address()).build()
    return createTransaction(chainID, wallet.address, wallet.pk, itx.toByteString(), TypeUrls.DECLARE)
  }


  /**
   * create a poke transaction without signature
   */
  fun unsignPoke(pokeAddress: String, chainID: String, wallet: WalletInfo): Type.Transaction {
    val itx = Poke.PokeTx.newBuilder()
      .setAddress(pokeAddress)
      .setDate(LocalDate.now().toString())
      .build()
    return Type.Transaction.newBuilder()
      .setChainId(chainID).setFrom(wallet.address)
      .setPk(ByteString.copyFrom(wallet.pk))
      .setNonce(0L)
      .setItx(Any.getDefaultInstance().toBuilder().setTypeUrl(TypeUrls.POKE)
        .setValue(itx.toByteString())
        .build())
      .build()
  }

  /**
   * create a delegate transaction without signature
   */
  fun unsignDelegate(from: String, to: String, chainID: String, wallet: WalletInfo, rules: List<String>, typeUrl: String? = null): Type.Transaction {
    val itx = Delegate.DelegateTx.newBuilder()
      .setAddress(DIDGenerator.genDelegateAddress(from, to))
      .addOps(Delegate.DelegateOp.newBuilder()
        .setTypeUrl(typeUrl ?: TypeUrls.TRANSFER)
        .addAllRules(rules)
        .build())
      .setTo(to)
      .build()
    return createTransaction(chainID, wallet.address, wallet.pk, itx.toByteString(), TypeUrls.DELEGATE)
  }

  /**
   * create a revoke delegate transaction without signature
   */
  fun unsignRevokeDelegate(from: String, to: String, chainID: String, wallet: WalletInfo, typeUrls: List<String>): Type.Transaction {
    val itx = RevokeDelegate.RevokeDelegationTx.newBuilder()
      .setAddress(DIDGenerator.genDelegateAddress(from, to))
      .addAllTypeUrls(typeUrls)
      .setTo(to)
      .build()
    return createTransaction(chainID, wallet.address, wallet.pk, itx.toByteString(), TypeUrls.REVOKE_DELEGATE)
  }

  /**
   * create a transaction structure
   */
  fun createTransaction(chanId: String, from: String, pk: ByteArray, itx: ByteString, typeUrl: String): Type.Transaction {
    return Type.Transaction.newBuilder()
      .setChainId(chanId)
      .setFrom(from)
      .setPk(ByteString.copyFrom(pk))
      .setNonce(generateNonce())
      .setItx(Any.getDefaultInstance().toBuilder().setTypeUrl(typeUrl)
        .setValue(itx)
        .build())
      .build()

  }


}



