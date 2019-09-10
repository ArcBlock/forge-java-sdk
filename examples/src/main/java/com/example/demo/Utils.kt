package com.example.demo

import com.example.demo.beans.AppDid
import com.example.demo.components.ForgeSDKComponent
import com.google.common.io.BaseEncoding
import com.google.protobuf.ByteString
import forge_abi.Rpc
import forge_abi.Type
import io.arcblock.forge.Hasher
import io.arcblock.forge.did.DidUtils
import io.arcblock.forge.did.HashType
import io.arcblock.forge.sign.Signer
import io.arcblock.forge.utils.Base58Btc
import org.slf4j.LoggerFactory
import com.google.protobuf.Any

object Utils {

    var logger = LoggerFactory.getLogger(javaClass)

    fun createTx(itx: Any, appDid: AppDid): Type.Transaction {
        val unsignTx = Type.Transaction.newBuilder()
                .setFrom(appDid.address)
                .setItx(itx)
                .setNonce(123L)
                .setChainId(appDid.chainInfo?.network)
                .setPk(ByteString.copyFrom(appDid.pk))
                .build()

        val sig = Signer.sign(DidUtils.decodeDidSignType(appDid.address), Hasher.hash(DidUtils.decodeDidHashType(appDid.address), unsignTx.toByteArray()), appDid.sk)

        return unsignTx.toBuilder().setSignature(ByteString.copyFrom(sig)).build()
    }

    fun multiSig(
      tx: Type.Transaction,
      sk: ByteArray,
      pk: ByteArray,
      addr: String,
      appDid: AppDid,
      forgeSDKComponent: ForgeSDKComponent
    ): Rpc.ResponseSendTx {

        var multiSig = Type.Multisig.newBuilder().setPk(ByteString.copyFrom(pk)).setSigner(addr).build()
        var newTx = tx.toBuilder().addSignatures(multiSig).build()
        logger.info("ori: ============>\n${Base58Btc.encode(newTx.toByteArray())} =======\n\n\n")
        val sig = Signer.sign(DidUtils.decodeDidSignType(addr), Hasher.hash(HashType.KECCAK,
                newTx.toByteArray()), sk)
        logger.info("multisig: ============>\n${Base58Btc.encode(sig)} =======\n\n\n")
        val ms = newTx.getSignatures(0).toBuilder().setSignature(ByteString.copyFrom(sig)).build()
        logger.info(ms.toString())
        newTx = newTx.toBuilder().setSignatures(0, ms).build()
        logger.info(newTx.toString())
        logger.info("================\n${BaseEncoding.base16().encode(newTx.toByteArray())}========\n")
        return forgeSDKComponent.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder()
                .setTx(newTx)
                .setToken(appDid.token)
                .build())
    }
}
