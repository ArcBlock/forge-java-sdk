package io.arcblock.forge

import com.google.protobuf.Any
import com.google.protobuf.ByteString
import forge_abi.*
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.extension.delegatee
import io.arcblock.forge.extension.multiSig
import io.arcblock.forge.extension.toByteString
import java.math.BigInteger
import java.time.LocalDate
import java.util.*

object TransactionFactory {

  private fun generateNonce(): Long {
    return System.currentTimeMillis()
  }

  const val POKE_ADDRESS = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"

  /**
   * create a declare transaction without signature
   */
  @JvmOverloads
  fun declare(chainID: String, address: String, pk: ByteArray, moniker: String? = null, issuer: String? = null): Type.Transaction {
    val itx = Declare.DeclareTx.newBuilder()
      .setMoniker(moniker
        ?: UUID.randomUUID().toString().replace("-", ""))
      .setIssuer(issuer ?: address)
      .build()
    return createTransaction(chainID, address, pk, itx.toByteString(), TypeUrls.DECLARE)
  }


  /**
   * create a poke transaction without signature
   */
  fun unsignPoke(chainID: String, address: String, pk: ByteArray): Type.Transaction {
    val itx = Poke.PokeTx.newBuilder()
      .setAddress(POKE_ADDRESS)
      .setDate(LocalDate.now().toString())
      .build()
    return Type.Transaction.newBuilder()
      .setChainId(chainID)
      .setFrom(address)
      .setPk(ByteString.copyFrom(pk))
      .setNonce(0L)
      .setItx(Any.getDefaultInstance().toBuilder().setTypeUrl(TypeUrls.POKE)
        .setValue(itx.toByteString())
        .build())
      .build()
  }


  /**
   * create a unsigned transfer transaction
   * @param chainID forge chain info network
   * @param from sender address
   * @param fromPk sender Pk
   * @param to receiver address
   * @param token send amount
   * @param assets send asset addresses
   *
   * @return Transaction
   */
  @JvmOverloads
  fun unsignTransfer(chainID: String, from: String, fromPk: ByteArray, to: String, token: BigInteger? = null, assets: List<String>? = null): Type.Transaction {
    val builder = Transfer.TransferTx.newBuilder()
      .setTo(to)
    token?.apply { builder.setValue(Type.BigUint.newBuilder().setValue(this.toByteArray().toByteString())) }
    assets?.apply { builder.addAllAssets(this) }
    return createTransaction(chainID, from, fromPk, builder.build().toByteString(), TypeUrls.TRANSFER)
  }


  /**
   * create a pre exchange
   * @param chainID forge chain info network
   * @param from sender wallet
   * @param to receiver address
   * @param fromToken sender pay token
   * @param assetAddress receiver provide asset address
   *
   * @return Transaction
   */
  @JvmOverloads
  fun preExchange(chainId: String, fromAddress: String, fromPk: ByteArray , to: String, fromToken: BigInteger, assetAddress: String, delegateeFrom: String? =
    null, delegateeTo: String? = null): Type.Transaction {
    val exchange = Exchange.ExchangeTx.newBuilder()
      .setSender(Exchange.ExchangeInfo.newBuilder()
        .setValue(Type.BigUint.newBuilder()
          .setValue(fromToken.toByteArray().toByteString())
          .build())
        .build())
      .setReceiver(Exchange.ExchangeInfo.newBuilder()
        .addAssets(assetAddress)
        .build())
      .setTo(delegateeTo ?: to)
      .build()
    return createTransaction(chainId, fromAddress, fromPk, exchange.toByteString(), TypeUrls.EXCHANGE)
      .delegatee(delegateeFrom)
  }


  /**
   * create a pre exchange
   * @param chainID forge chain info network
   * @param from sender wallet
   * @param to receiver address
   * @param fromToken sender pay token
   * @param assetAddress receiver provide asset address
   *
   * @return Transaction
   */
  @JvmOverloads
  fun preUnsignConusmeAsset(chainId: String, checkerAddress: String, checkerPk: ByteArray, issuer: String? = null, delegatee: String? = null): Type
  .Transaction {
    val consumeAsset = ConsumeAsset.ConsumeAssetTx.newBuilder()
      .setIssuer(issuer ?: checkerAddress)
      .build()
    return createTransaction(chainId, checkerAddress, checkerPk, consumeAsset.toByteString(), TypeUrls.CONSUME_ASSET)
      .delegatee(delegatee)
  }


  /**
   * finalize  MultiSig
   */
  @JvmOverloads
  fun finalizeMultiSig(tx: Type.Transaction, to: WalletInfo, delegateeTo: String? = null, data: Any? = null): Type.Transaction {
    return tx.multiSig(to, delegator = delegateeTo, data = data)
  }


  /**
   * create a delegate transaction without signature
   */
  @JvmOverloads
  fun unsignDelegate(from: String, to: String, chainID: String, fromPk: ByteArray, rules: List<String>, typeUrl: String? = null): Type.Transaction {
    val itx = Delegate.DelegateTx.newBuilder()
      .setAddress(DIDGenerator.genDelegateAddress(from, to))
      .addOps(Delegate.DelegateOp.newBuilder()
        .setTypeUrl(typeUrl ?: TypeUrls.TRANSFER)
        .addAllRules(rules)
        .build())
      .setTo(to)
      .build()
    return createTransaction(chainID, from, fromPk, itx.toByteString(), TypeUrls.DELEGATE)
  }

  /**
   * create a revoke delegate transaction without signature
   */
  fun unsignRevokeDelegate(from: String, to: String, chainID: String, fromPk: ByteArray, typeUrls: List<String>): Type.Transaction {
    val itx = RevokeDelegate.RevokeDelegateTx.newBuilder()
      .setAddress(DIDGenerator.genDelegateAddress(from, to))
      .addAllTypeUrls(typeUrls)
      .setTo(to)
      .build()
    return createTransaction(chainID, from, fromPk, itx.toByteString(), TypeUrls.REVOKE_DELEGATE)
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

  fun setupSwap(chainId: String, fromAddress:String, fromPk: ByteArray, receiver: String, blockHeight: Int, hashKey: ByteArray, demandToken: BigInteger) =
    setupSwap(chainId, fromAddress, fromPk, receiver, blockHeight, hashKey, demandToken = demandToken, assets = listOf())

  fun setupSwap(chainId: String, fromAddress:String, fromPk: ByteArray, receiver: String, blockHeight: Int, hashKey: ByteArray, assets: List<String>) =
    setupSwap(chainId, fromAddress, fromPk, receiver, blockHeight, hashKey, demandToken = null, assets = assets)

  fun setupSwap(chainId: String, fromAddress:String, fromPk: ByteArray, receiver: String, blockHeight: Int, hashKey: ByteArray, demandToken: BigInteger? = BigInteger.ZERO,
                assets:
  List<String>? = listOf())
    : Type.Transaction {
    val itx = SetupSwap.SetupSwapTx.newBuilder()
      .setValue(Type.BigUint.getDefaultInstance().toBuilder()
        .setValue((demandToken ?: BigInteger.ZERO).toByteArray().toByteString())
        .build())
      .addAllAssets(assets ?: listOf())
      .setLocktime(blockHeight)
      .setHashlock(Hasher.hash(HashType.SHA3, hashKey).toByteString())
      .setReceiver(receiver)
      .build()
    return createTransaction(chainId, fromAddress, fromPk, itx.toByteString(), TypeUrls.SETUP_SWAP)
  }

  fun revokeSwap(chainId: String, fromAddress:String, fromPk: ByteArray, swapAddr: String): Type.Transaction {
    val itx = RevokeSwap.RevokeSwapTx.newBuilder()
      .setAddress(swapAddr)
      .build()
    return createTransaction(chainId, fromAddress, fromPk, itx.toByteString(), TypeUrls.REVOKE_SWAP)
  }

  fun retrieve_swap(chainId: String, fromAddress:String, fromPk: ByteArray, swapAddr: String, hashKey: ByteArray): Type.Transaction {
    val itx = RetrieveSwap.RetrieveSwapTx.newBuilder()
      .setAddress(swapAddr)
      .setHashkey(hashKey.toByteString())
      .build()
    return createTransaction(chainId, fromAddress, fromPk, itx.toByteString(), TypeUrls.RETRIEVE_SWAP)
  }

}



