package io.arcblock.forge.did


import forge_abi.Enum
import forge_abi.Tx
import forge_abi.Type
import io.arcblock.forge.Hasher
import io.arcblock.forge.WalletUtils
import io.arcblock.forge.bip44.Bip44Utils
import io.arcblock.forge.did.HashType.SHA2
import io.arcblock.forge.did.HashType.SHA3
import io.arcblock.forge.did.KeyType.ED25519
import io.arcblock.forge.extension.address
import io.arcblock.forge.extension.hash
import io.arcblock.forge.hash.ArcSha2Hasher
import io.arcblock.forge.hash.ArcSha3Hasher
import io.arcblock.forge.utils.Base58Btc
import org.bitcoinj.crypto.ChildNumber
import org.bitcoinj.crypto.HDKeyDerivation
import java.math.BigInteger
import java.util.*

/**
 * [ABT-DID-Protocol]("https://github.com/ArcBlock/ABT-DID-Protocol")
 *
 * This util help you to generate all kinds of DID, it like everything's ID card.
 * it will generate different DID for different Application
 *
 **/
object DIDGenerator {

  /**
   * [ABT-DID-Protocol]("https://github.com/ArcBlock/ABT-DID-Protocol")
   *
   * Apply sha3 to the app_did
  Take the first 64 bits of the hash
  Split the these 64 bits into two 32-bits-long sections denoted as S1 and S2.
  Derive the HD secret key by using path m/44'/ABT'/S1'/S2'/address_index where ABT' is the coin type registered on SLIP44 and address_index is numbered from index 0 in sequentially increasing manner.
  Convert the HD secret key to user_did by using the rules described in DID section.
  From this point, the wallet should use this derived secret key, public key and DID for future processing.
   *
   */
  fun genAppDid(didKeyPair: DidKeyPair): String {
    // Convert the HD secret key to user_did by using the rules described in DID section.
    return sk2did(didKeyPair.privateKey)
  }

  /**
   * generate HD key pair for one Application
   * @param appid Application ID
   * @param index ID wallet index
   * @param seed user master seed
   * @param keyType ED25519 or SECP256K1
   * @return HD key pair
   */
  fun genAppKeyPair(appid: String, index: Int, seed: ByteArray, keyType: KeyType): DidKeyPair {
    // Apply sha3 to the app_did
    val sha3out = ArcSha3Hasher.sha256(appid.toByteArray(), 1)
    //    Take the first 64 bits of the hash
    //    Split the these 64 bits into two 32-bits-long sections denoted as S1 and S2.
    val S1 = BigInteger(sha3out.sliceArray(0..3)) // big-endian by default
    val S2 = BigInteger(sha3out.sliceArray(4..7)) // big-endian by default
    val S0 = 260 // ABT
    //    Derive the HD secret key by using path m/44'/ABT'/S1'/S2'/address_index where ABT' is the coin type registered on SLIP44 and address_index is numbered from index 0 in sequentially increasing manner.
    val derivePath = "m/44'/$S0'/$S1'/$S2'/$index"

    val pathArray = derivePath.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    var dkKey = HDKeyDerivation.createMasterPrivateKey(seed)
    for (i in 1 until pathArray.size) {
      val childNumber: ChildNumber
      if (pathArray[i].endsWith("'")) {
        val number = Integer.parseInt(pathArray[i].removeSuffix("'"))
        childNumber = ChildNumber(number.and(0x7FFFFFFF), true)
      } else {
        val number = Integer.parseInt(pathArray[i])
        childNumber = ChildNumber(number.and(0x7FFFFFFF), false)
      }
      dkKey = HDKeyDerivation.deriveChildKey(dkKey, childNumber)
    }

    return DidKeyPair(keyType, dkKey.privKeyBytes)
  }

  /**
   * generate DID by user secret Key.
   * and use default Wallet type: ACCOUNT ED25519 SHA3
   */
  fun sk2did(sk: ByteArray): String {
    return sk2did(RoleType.ACCOUNT, ED25519, SHA3, sk)
  }

  /**
   * generate DID by user secret Key.
  Step 1: Choose the RoleType, KeyType and Hash from above, let's use application, ed25519 and sha3 in this example.
  Step 2: Choose a secret key randomly, e.g.
  D67C071B6F51D2B61180B9B1AA9BE0DD0704619F0E30453AB4A592B036EDE644E4852B7091317E3622068E62A5127D1FB0D4AE2FC50213295E10652D2F0ABFC7
  Step 3: Generate the public key of this secret key by using the KeyType. So we can get public key
  E4852B7091317E3622068E62A5127D1FB0D4AE2FC50213295E10652D2F0ABFC7
  Step 4: Get the Hash of the public key
  EC8E681514753FE5955D3E8B57DAEC9D123E3DB146BDDFC3787163F77F057C27
  Step 5: Take the first 20 bytes of the public key hash
  EC8E681514753FE5955D3E8B57DAEC9D123E3DB1
  Step 6: Add the DID type bytes 0x0C01 in front of the hash of Step 4
  0C01EC8E681514753FE5955D3E8B57DAEC9D123E3DB1
  Step 7: Get the hash of the extended hash in Step 6
  42CD815145538F8003586C880AF94418341F9C4B8FA0394876553F8A952C7D03
  Step 8: Take the first 4 bytes in step 7
  42CD8151
  Step 9: Append the 4 bytes in step 8 to the extended hash in step 6. This is the binary DID string
  0C01EC8E681514753FE5955D3E8B57DAEC9D123E3DB142CD8151
  Step 10: Encode the binary value by using the Bitcoin Base58 method.
  zNKtCNqYWLYWYW3gWRA1vnRykfCBZYHZvzKr
  Step 11: Assemble the parts and get the full DID
  did:abt:zNKtCNqYWLYWYW3gWRA1vnRykfCBZYHZvzKr
   */
  fun sk2did(roleType: RoleType, keyType: KeyType, hashType: HashType, sk: ByteArray): String {
    val pk = WalletUtils.sk2pk(keyType, sk)
    return pk2did(roleType, keyType, hashType, pk)
  }


  /**
   * Generate Asset Address for CreateAssetTX
   * @param senderAddress Assert Creator 's address ,like :z1cserc3KL1cL..
   * @param itx CreateAssetTx encode with Asset_address is empty
   * @return Asset address
   */
  fun genAssetDid(senderAddress: String, itx: ByteArray): String {
//    val hashType = DidUtils.decodeDidHashType(senderAddress)
//    val keyType = DidUtils.decodeDidSignType(senderAddress)
    val itxNoAddress = Tx.CreateAssetTx.newBuilder().mergeFrom(itx).clearAddress().build().toByteArray()
    return hashToAddress(RoleType.ASSET, ED25519, SHA3, ArcSha3Hasher.sha(itxNoAddress))
  }

  /**
   * Generate Asset Address for CreateAssetTX
   */
  fun genAssetDid(itx: ByteArray): String {
    val itxNoAddress = Tx.CreateAssetTx.newBuilder().mergeFrom(itx).clearAddress().build().toByteArray()
    return hashToAddress(RoleType.ASSET, ED25519, SHA3, ArcSha3Hasher.sha(itxNoAddress))
  }

  /**
   * Generate address by user publicKey
   * @param roleType use enum RoleType, such as ACCOUNT or APPLICATION
   * @param keyType publicKey type ED25519 or SECP256K1
   * @param hashType enum HashType, such as SHA3 or KECCAK
   */
  fun pk2Address(roleType: RoleType, keyType: KeyType, hashType: HashType, pk: ByteArray): String {
    val pkHash = if (hashType == SHA2) ArcSha2Hasher.sha256(pk, 1) else Hasher.hash(hashType, pk)
    return hashToAddress(roleType, keyType, hashType, pkHash)
  }

  private fun hashToAddress(roleType: RoleType, keyType: KeyType = ED25519, hashType: HashType = SHA3, hash: ByteArray): String {
    val appendPk = preAppend(roleType, keyType, hashType) + hash.sliceArray(0..19)
    val suffix = appendPk + Hasher.hash(hashType, appendPk).sliceArray(0..3)
    return Base58Btc.encode(suffix)
  }

  /**
   * Generate DID by user publicKey
   * @param roleType use enum RoleType, such as ACCOUNT or APPLICATION
   * @param keyType publicKey type ED25519 or SECP256K1
   * @param hashType enum HashType, such as SHA3 or KECCAK
   */
  fun pk2did(roleType: RoleType, keyType: KeyType, hashType: HashType, pk: ByteArray): String {
    return "did:abt:".plus(pk2Address(roleType, keyType, hashType, pk))
  }

  /**
   * generate prefix of did
   */
  fun preAppend(roleType: RoleType, keyType: KeyType, hashType: HashType): ByteArray {
    val append = (roleType.value.shl(10).and(0b1111110000000000)).or(keyType.value.shl(5).and(0b1111100000)).or(hashType.value.and(0b11111))
    var ret = ByteArray(2)
    ret[1] = append.and(0b11111111).toByte()
    ret[0] = append.shr(8).and(0b11111111).toByte()
    return ret
  }

  /**
   * random wallet
   */
  @JvmOverloads
  fun randomWallet(walletType: Type.WalletType? = Type.WalletType.newBuilder().setHash(Enum.HashType.sha3).setPk(Enum.KeyType.ed25519).setRole(Enum.RoleType
    .role_account).build()):
    WalletInfo {
    val type = if (walletType == null) Type.WalletType.newBuilder().setHash(Enum.HashType.sha3).setPk(Enum.KeyType.ed25519).setRole(Enum.RoleType
      .role_account).build() else walletType
    var sk :ByteArray = ByteArray(0)
    while (sk.size < 32){
      val seed =Bip44Utils.genSeed(UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString())
      sk= Bip44Utils.genKeyPair(seed).privateKey.toByteArray()
    }
    return WalletInfo(sk=sk,pk = WalletUtils.sk2pk(sk= sk, keyType = type.pk),address = sk2did( RoleType.fromInt(type.roleValue),KeyType.fromInt(type.pkValue),
      HashType.fromInt(type.hashValue),sk).address())
  }

  /**
   * generate tether address
   */
  fun toTetherAddress(hash: ByteArray): String {

    return hashToAddress(RoleType.TETHER, ED25519, SHA2, hash)
  }

  /**
   * generate validator address
   */
  fun toValidatorAddress(hash: ByteArray): String {
    return hashToAddress(RoleType.VALIDATOR, ED25519, SHA2, hash)
  }

  /**
   * generate node address
   */
  fun toNodeAddress(hash: ByteArray): String {
    return hashToAddress(RoleType.NODE, ED25519, SHA2, hash)
  }

  /**
   * Generate stake address. Use sender's address + receiver's address as pseudo public key.
   * Use `ed25519` as pseudo key type. Use sha3 and base58 by default.
   */
  fun toStakeAddress(addr1: String, addr2: String): String {
    val data = (if (addr1.compareTo(addr2) < 0) {
      addr1 + addr2
    } else addr2 + addr1).toByteArray()
    return pk2Address(RoleType.STAKE, ED25519, SHA3, data)
  }

  /**
   *   Generate address for tx.
   */
  fun toTxAddress(itx: ByteArray): String {
    val data = Hasher.hash(SHA3, itx)
    return hashToAddress(RoleType.TX, ED25519, SHA3, data)
  }

  /**
   * Generate delegateDID
   */
  fun genDelegateAddress(sender: String, receiver: String): String {
    val data = sender.toByteArray() + receiver.toByteArray()
    return hashToAddress(RoleType.DELEGATE, hash = data.hash(SHA3))
  }

  fun toSwapAddress(hash: ByteArray): String {
    return hashToAddress(RoleType.SWAP,ED25519, SHA2,hash = hash)
  }


}
