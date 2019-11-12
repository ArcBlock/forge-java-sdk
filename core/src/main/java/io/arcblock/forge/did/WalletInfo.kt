package io.arcblock.forge.did

import forge_abi.Rpc
import forge_abi.Type
import io.arcblock.forge.WalletUtils
import io.arcblock.forge.extension.address
import io.arcblock.forge.extension.toByteString
import io.arcblock.forge.utils.Base58Btc

data class WalletInfo(val address: String, val pk: ByteArray, val sk: ByteArray) {

  constructor(response: Rpc.ResponseCreateWallet) : this(response.wallet.address, response.wallet.pk.toByteArray()
    , response.wallet.sk.toByteArray())

  constructor(wallet: Type.WalletInfo) : this(wallet.address, wallet.pk.toByteArray()
    , wallet.sk.toByteArray())


  /**
   * get RoleType of this wallet. [RoleType]
   */
  fun getAccountType(): RoleType {
    return DidUtils.decodeDidRoleType(address)
  }

  /**
   * get [HashType] of this wallet.
   */
  fun getHashType(): HashType {
    return DidUtils.decodeDidHashType(address)
  }

  /**
   * get [KeyType] of this wallet.
   */
  fun getSignType(): KeyType {
    return DidUtils.decodeDidSignType(address)
  }

  fun pkBase58(): String = Base58Btc.encode(pk)

  fun toTypeWalletInfo(): Type.WalletInfo {
    return Type.WalletInfo.newBuilder()
      .setSk(sk.toByteString())
      .setPk(pk.toByteString())
      .setAddress(address)
      .build()
  }

  companion object {
    /**
     * generate wallet from private key
     */
    fun fromSk(sk: ByteArray, hashType: HashType, keyType: KeyType, roleType: RoleType): WalletInfo {
      val pk = WalletUtils.sk2pk(KeyType.ED25519, sk)
      val did = DIDGenerator.pk2did(roleType, hashType = hashType, keyType = keyType, pk = pk)
      return WalletInfo(did.address(), pk, sk)
    }

    /**
     * generate wallet from private key
     */
    fun fromSk(sk: ByteArray) = fromSk(sk, HashType.SHA3, KeyType.ED25519, RoleType.ACCOUNT)
  }

}
