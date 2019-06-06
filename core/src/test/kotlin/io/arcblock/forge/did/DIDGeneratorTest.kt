package io.arcblock.forge.did

import com.google.common.io.BaseEncoding
import com.google.protobuf.Any
import com.google.protobuf.ByteString
import forge_abi.CreateAsset
import io.arcblock.forge.Hasher
import io.arcblock.forge.WalletUtils
import io.arcblock.forge.bip44.Bip44Utils
import io.arcblock.forge.deBase16
import io.arcblock.forge.didToAddr
import io.arcblock.forge.getPK
import io.arcblock.forge.toHexString
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.web3j.crypto.ECKeyPair

class DIDGeneratorTest {
  lateinit var kp: DidKeyPair

  @Before
  fun setUp() {
    kp = DidKeyPair(KeyType.ED25519, Bip44Utils.genSeed("abc", "def", "").seedBytes!!)
    // val sk = BaseEncoding.base64Url().decode("-N-yXGUDgweNazW__NoPP8rhs6ohSVOAZJjum7nhFqU=")
    val sk = BaseEncoding.base64().decode("s+FRMiPMkiTYJBqsFpJYpIJ5Dhos5FvpJKrOL8CC3D6n2YqUrlbeO7X5/Vaynau/4utlSUUkQvyCAd7XclH3wg==")
    val pk = BaseEncoding.base64().decode("p9mKlK5W3ju1+f1Wsp2rv+LrZUlFJEL8ggHe13JR98I=")
    kp.publicKey = pk
    kp.privateKey = sk
  }

  @Test
  fun genAppDid() {
    val did = DIDGenerator.genAppDid(kp)
    Assert.assertTrue(did.startsWith("did:abt:z"))
    Assert.assertTrue(did.length == 43)
  }

  @Test
  fun genAppKeyPair() {
    val newKey = DidKeyPair(KeyType.ED25519, Bip44Utils.genSeed("abc", "def", "").seedBytes!!)
    Assert.assertTrue(newKey.privateKey.isNotEmpty())
    Assert.assertTrue(newKey.publicKey.isNotEmpty())
    val newKey1 = DidKeyPair(KeyType.SECP256K1, Bip44Utils.genSeed("abc", "def", "").seedBytes!!)
    Assert.assertTrue(newKey1.privateKey.isNotEmpty())
    Assert.assertTrue(newKey1.publicKey.isNotEmpty())
  }

  @Test
  fun sk2did() {
    val did = DIDGenerator.sk2did(RoleType.ACCOUNT, KeyType.ED25519, HashType.SHA3, kp.privateKey)
    Assert.assertEquals("did:abt:z1nVqvucZVv55nPGYuZ6YdNsL71ZHAEMMPg", did)
  }

  @Test
  fun sk2did1() {
    val sk = "26954E19E8781905E2CF91A18AE4F36A954C142176EE1BC27C2635520C49BC55".deBase16()
    val did = DIDGenerator.sk2did(RoleType.ACCOUNT, KeyType.SECP256K1, HashType.SHA3, sk)
    Assert.assertEquals("did:abt:z1Ee1H8g248HqroacmEnZzMYgbhjz1Z2WSvv", did)
  }

  @Test
  fun pk2did() {
    val sk = "26954E19E8781905E2CF91A18AE4F36A954C142176EE1BC27C2635520C49BC55".deBase16()
    val did = DIDGenerator.pk2did(RoleType.ACCOUNT, KeyType.SECP256K1, HashType.SHA3, WalletUtils.sk2pk(KeyType.SECP256K1, sk))
    Assert.assertEquals("did:abt:z1Ee1H8g248HqroacmEnZzMYgbhjz1Z2WSvv", did)
  }

  @Test
  fun preAppend() {
    var pre = DIDGenerator.preAppend(RoleType.ACCOUNT, KeyType.SECP256K1, HashType.SHA3)
    Assert.assertEquals("0021", pre.toHexString())

    pre = DIDGenerator.preAppend(RoleType.APPLICATION, KeyType.SECP256K1, HashType.SHA3)
    Assert.assertEquals("0C21", pre.toHexString().toUpperCase())

    pre = DIDGenerator.preAppend(RoleType.APPLICATION, KeyType.SECP256K1, HashType.KECCAK)
    Assert.assertEquals("0C20", pre.toHexString().toUpperCase())

    pre = DIDGenerator.preAppend(RoleType.APPLICATION, KeyType.SECP256K1, HashType.SHA3_512)
    Assert.assertEquals("0C25", pre.toHexString().toUpperCase())
  }

  @Test
  fun hash() {
    Hasher.hash(HashType.SHA3, "abc".toByteArray())
    Hasher.hash(HashType.SHA3_384, "abc".toByteArray())
    Hasher.hash(HashType.SHA3_512, "abc".toByteArray())

    Hasher.hash(HashType.KECCAK, "abc".toByteArray())
    Hasher.hash(HashType.KECCAK_384, "abc".toByteArray())
    Hasher.hash(HashType.KECCAK_512, "abc".toByteArray())
  }

  @Test
  fun sk2pk() {
    // test seck256k1
    var sk = BaseEncoding.base16().decode("26954E19E8781905E2CF91A18AE4F36A954C142176EE1BC27C2635520C49BC55")
    var pk = WalletUtils.sk2pk(KeyType.SECP256K1, sk)
    Assert.assertEquals("049AA8F402BB1A355F2FB2D0BE5CB1581668D5C2408E53932D517B58C41577F6C8558DDA51A1DCBE375DE0F097D1A0A99222EAD0D5BACCBE602DECC5A2F2504E30",
      pk.toHexString().toUpperCase())
    sk = BaseEncoding.base16().decode("18E14A7B6A307F426A94F8114701E7C8E774E7F9A47E2C2035DB29A206321725")
    val kp = ECKeyPair.create(sk)
    Assert.assertEquals("0450863AD64A87AE8A2FE83C1AF1A8403CB53F53E486D8511DAD8A04887E5B23522CD470243453A299FA9E77237716103ABC11A1DF38855ED6F2EE187E9C582BA6",
      BaseEncoding.base16().encode(kp.getPK()))
    Assert.assertEquals("0450863AD64A87AE8A2FE83C1AF1A8403CB53F53E486D8511DAD8A04887E5B23522CD470243453A299FA9E77237716103ABC11A1DF38855ED6F2EE187E9C582BA6",
      WalletUtils.sk2pk(KeyType.SECP256K1, sk).toHexString().toUpperCase())
  }

  @Test
  fun genAssetDid(){
    val data =Any.newBuilder().setTypeUrl("test_asset").setValue(ByteString.copyFromUtf8("hello world")).build()
    val itx = CreateAsset.CreateAssetTx.newBuilder().setData(data)
      .setMoniker("")
      .setReadonly(false)
      .setParent("")
      .setTransferrable(false)
      .setTtl(0)
      .build()
    println("itx:$itx")
    val address = DIDGenerator.genAssetDid("z1fAiQRmNDFSoFAFTq4R5UsaYpL6y4s8XSx",itx.toByteArray())
    Assert.assertEquals("zjdmmAWQDGgb68y6GAcoSx3n8exZC1hvxQ4H",address.didToAddr())
  }
  @Test
  fun genTxaddr(){
    val data =Any.newBuilder().setTypeUrl("test_asset").setValue(ByteString.copyFromUtf8("hello world")).build()
    val itx = CreateAsset.CreateAssetTx.newBuilder().setData(data)
      .setMoniker("")
      .setReadonly(false)
      .setParent("")
      .setTransferrable(false)
      .setTtl(0)
      .build()
    println("itx:$itx")
    val address = DIDGenerator.toTxAddress(itx.toByteArray())
    Assert.assertEquals("z2E3v9oZB7LsX6vkTLzsDkNHM12vkVjhvavMS",address.didToAddr())
  }

  @Test
  fun toStakeAddr(){
    val w1="z1Y2f7cwqSyR4c9azZLNAHimtbjLR3cxPnX"
    val rst="zrjq3G7UjWJ3etFjtP6LDjk3Aqabz3eh3n5w"
    val w2="z1fAiQRmNDFSoFAFTq4R5UsaYpL6y4s8XSx"
    Assert.assertEquals(rst, DIDGenerator.toStakeAddress(w1,w2))
  }

  @Test
  fun toTether(){
        //val rst = DIDGenerator.toTetherAddress(BaseEncoding.base16().decode("5D9394E3BBFF052548876A7420E6F5B32C3855995511DEC7A5539CD2C56BD396"))
// do not work now
    //Assert.assertEquals("z2MBxdfRmeozARcnPvPi42fndxmhn7rLi9D7g",rst)

//    val rst = DIDGenerator.toTetherAddress(BaseEncoding.base16().decode("CE922DEDAA0E2C141B040BB8034AF17BF9962266F1EF179E05B46FC5FAD43258"))
  //  Assert.assertEquals("z2MC8w872CYeZ3zZSERMkaKSmiDrHHr7vDxYE",rst)

  }
}
