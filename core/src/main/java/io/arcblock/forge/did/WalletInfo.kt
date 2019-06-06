package io.arcblock.forge.did

import forge_abi.Rpc
import io.arcblock.forge.utils.Base58Btc

class WalletInfo(val address: String, val pk: ByteArray,val sk: ByteArray) {

  constructor(response: Rpc.ResponseCreateWallet):this(response.wallet.address,response.wallet.pk.toByteArray()
    ,response.wallet.sk.toByteArray())

  fun getAccountType(): RoleType {
    return DidUtils.decodeDidRoleType(address)
  }

  fun getHashType(): HashType {
    return DidUtils.decodeDidHashType(address)
  }

  fun getSignType(): KeyType {
    return DidUtils.decodeDidSignType(address)
  }

  fun pkBase58(): String = Base58Btc.encode(pk)



}
