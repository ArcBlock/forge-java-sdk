package io.arcblock.forge.did

class WalletInfo (var address: String){
  lateinit var pk: ByteArray
  lateinit var sk: ByteArray
  var token: String?= null

  fun getAccountType():RoleType{
    return DidUtils.decodeDidRoleType(address)
  }

  fun getHashType(): HashType{
    return DidUtils.decodeDidHashType(address)
  }

  fun getSignType(): KeyType{
    return DidUtils.decodeDidSignType(address)
  }
}
