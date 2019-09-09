package com.example.demo.handlers

import com.example.demo.beans.AppDid
import com.google.gson.Gson
import com.google.protobuf.Any
import com.google.protobuf.ByteString
import forge_abi.CreateAsset
import forge_abi.Exchange
import forge_abi.Rpc
import forge_abi.TraceType
import forge_abi.Type
import io.arcblock.forge.TypeUrls
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.KeyType
import io.arcblock.forge.sign.Signer
import org.slf4j.LoggerFactory

object ProductHandler {

    var logger = LoggerFactory.getLogger(javaClass)

    fun createTx(assetData: String, moniker: String, did: String, pk: ByteArray, appDid: AppDid): Rpc.RequestSendTx {
        // createAssetTx
        val itx = CreateAsset.CreateAssetTx.newBuilder()
                .setData(Any.newBuilder().setTypeUrl("json")
                        .setValue(ByteString.copyFrom(assetData.toByteArray()))
                        .build())
                .setTransferrable(true)
                .setMoniker(moniker)
                .setReadonly(false)
                .build()
        logger.info("==appDid===\n${Gson().toJson(appDid)} \n\n\n=====End====")
        val assetAddress = DIDGenerator.genAssetDid(appDid.address, itx.toByteArray()).removePrefix("did:abt:")

        val newItx = itx.toBuilder().setAddress(assetAddress).build()
        logger.info(itx.toString())
        val tx = Type.Transaction.newBuilder()
                .setChainId(appDid.chainInfo!!.network)
                .setItx(Any.newBuilder()
                        .setValue(newItx.toByteString())
                        .setTypeUrl(TypeUrls.CREATE_ASSET)
                )
                .setNonce(System.currentTimeMillis())
                .setFrom(appDid.address)
                .setPk(ByteString.copyFrom(appDid.pk))
                .build()
        val sig = Signer.sign(KeyType.ED25519, tx.toByteArray(), appDid.sk)

        val sigTx = tx.toBuilder().setSignature(ByteString.copyFrom(sig)).build()
        return Rpc.RequestSendTx.newBuilder()
                .setToken(appDid.token)
                .setTx(sigTx)
                .build()
    }

    fun listAssets(cursor: String?, ownerDid: String): Rpc.RequestListAssets {
        return Rpc.RequestListAssets.newBuilder()
                .setOwnerAddress(ownerDid)
                .setPaging(TraceType.PageInput.newBuilder().setCursor(cursor))
                .build()
    }

    fun exchange(otherAddress: String, asset: String): Exchange.ExchangeTx {
        return Exchange.ExchangeTx.newBuilder()
                .setReceiver(Exchange.ExchangeInfo.newBuilder()
                        .setValue(Type.BigUint.newBuilder()
                                .setValue(ByteString.copyFrom("1".toByteArray()))
                                .build())
                        .build())
                .setSender(Exchange.ExchangeInfo.newBuilder()
                        .addAssets(asset)
                        .build())
                .setTo(otherAddress)
                .build()
    }
}
