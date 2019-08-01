package io.arcblock.forge

import com.google.protobuf.Any
import com.google.protobuf.ByteString
import forge_abi.Poke
import forge_abi.Type
import io.arcblock.forge.did.WalletInfo
import java.time.LocalDate

object TransactionFactory {
  fun unsignPoke(pokeAddress:String,chainID:String, wallet: WalletInfo): Type.Transaction{

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
}



