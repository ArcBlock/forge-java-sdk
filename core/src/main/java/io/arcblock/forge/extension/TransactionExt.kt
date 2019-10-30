package io.arcblock.forge.extension


import com.google.protobuf.Any
import forge_abi.Type
import io.arcblock.forge.Hasher
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.sign.Signer

/**
 *
 *     █████╗ ██████╗  ██████╗██████╗ ██╗      ██████╗  ██████╗██╗  ██╗
 *    ██╔══██╗██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗██╔════╝██║ ██╔╝
 *    ███████║██████╔╝██║     ██████╔╝██║     ██║   ██║██║     █████╔╝
 *    ██╔══██║██╔══██╗██║     ██╔══██╗██║     ██║   ██║██║     ██╔═██╗
 *    ██║  ██║██║  ██║╚██████╗██████╔╝███████╗╚██████╔╝╚██████╗██║  ██╗
 *    ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝
 * Author       : shan@arcblock.io
 * Time         : 2019-10-30
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/

/**
 * Extension of transaction for signature
 */
fun Type.Transaction.signTx(sk: ByteArray): Type.Transaction {
  val sig = this.toBuilder()
    .clearSignature()
    .build()
    .toByteArray()
    .hash(HashType.SHA3)
    .sign(sk)
  return this.toBuilder()
    .setSignature(sig.toByteString())
    .build()
}

/**
 * add delegatee ,must before sign
 */
fun Type.Transaction.delegatee(delegatee: String?) = delegatee?.let {
  val from = this.from
  this.toBuilder()
    .setFrom(delegatee)
    .setDelegator(from)
    .clearSignature()
    .build()
} ?: this

fun Type.Transaction.multiSig(wallet: WalletInfo) = multiSig(wallet, data = null, delegator = null)
fun Type.Transaction.multiSig(wallet: WalletInfo, delegator: String) = multiSig(wallet, data = null, delegator = delegator)
fun Type.Transaction.multiSig(wallet: WalletInfo, data: Any) = multiSig(wallet, data = data, delegator = null)

fun Type.Transaction.multiSig(wallet: WalletInfo, data: Any? = null, delegator: String? = null): Type.Transaction {
  val mulsigBuilder = Type.Multisig.newBuilder()
    .setPk(wallet.pk.toByteString())
    .setSigner(wallet.address)
    .setData(data ?: Any.getDefaultInstance())
  delegator?.let {
    mulsigBuilder.setDelegator(wallet.address)
      .setSigner(it)
  }

  val newTx = this.toBuilder()
    .clearSignatures()
    .addSignatures(mulsigBuilder.build())
    .build()

  val sig = Signer.sign(wallet.getSignType(), Hasher.hash(wallet.getHashType(), newTx.toByteArray()), wallet.sk)
  val multiSig = newTx.toBuilder()
    .getSignatures(0)
    .toBuilder()
    .setSignature(sig.toByteString())
    .build()
  return this.toBuilder()
    .addSignatures(multiSig)
    .build()
}


