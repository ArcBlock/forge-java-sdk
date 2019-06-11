package io.arcblock.forge

import com.google.protobuf.ByteString
import forge_abi.Rpc
import forge_abi.Transfer
import forge_abi.Type
import io.arcblock.forge.did.WalletInfo
import java.math.BigInteger

class WalletKitTest {

  fun mostSimpleTest(){
    val forge =  ForgeSDK.connect("localhost",28210)

    val Bob = forge.createWallet(Rpc.RequestCreateWallet.newBuilder()
      .setMoniker("Briant")
      .setPassphrase("abc123QWE")
      .setType(Type.WalletType.getDefaultInstance())
      .build())


    val Alice = forge.createWallet(Rpc.RequestCreateWallet.newBuilder()
      .setMoniker("Alice")
      .setPassphrase("abc123QWE")
      .setType(Type.WalletType.getDefaultInstance())
      .build())

    val walletInfo = WalletInfo(Alice)


    val pokeTx = WalletUtils.poke(walletInfo, forge, "forge")
    val retPoke = forge.sendTx(pokeTx)

    val itx = Transfer.TransferTx.newBuilder()
      .setValue(Type.BigUint.newBuilder().setValue(ByteString.copyFrom(BigInteger.TEN.toByteArray())))
      .setTo(Bob.wallet.address).build();
    val tx = WalletUtils.createTranserTx(walletInfo,"forge",itx)
    val hash = forge.sendTx(tx)
    println("hash:$hash")

  }

}
