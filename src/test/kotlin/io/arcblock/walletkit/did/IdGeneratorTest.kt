package io.arcblock.walletkit.did

import com.google.common.io.BaseEncoding
import io.arcblock.walletkit.bip44.Bip44Utils
import io.arcblock.walletkit.deBase16
import io.arcblock.walletkit.getPK
import io.arcblock.walletkit.hash.HasherTest
import io.arcblock.walletkit.toHexString
import org.junit.Assert
import org.junit.Test

import org.junit.Before
import org.web3j.crypto.ECKeyPair

class IdGeneratorTest {
  lateinit var kp: DidKeyPair

  @Before
  fun setUp() {
    kp= DidKeyPair(KeyType.ED25519, Bip44Utils.genSeed("abc","def","").seedBytes!!)
   // val sk = BaseEncoding.base64Url().decode("-N-yXGUDgweNazW__NoPP8rhs6ohSVOAZJjum7nhFqU=")
    val sk = BaseEncoding.base64().decode("s+FRMiPMkiTYJBqsFpJYpIJ5Dhos5FvpJKrOL8CC3D6n2YqUrlbeO7X5/Vaynau/4utlSUUkQvyCAd7XclH3wg==")
    val pk = BaseEncoding.base64().decode("p9mKlK5W3ju1+f1Wsp2rv+LrZUlFJEL8ggHe13JR98I=")
    kp.publicKey = pk
    kp.privateKey = sk
  }

    @Test
    fun genAppDid() {
      val did = IdGenerator.genAppDid(kp)
      Assert.assertTrue(did.startsWith("did:abt:z"))
      Assert.assertTrue(did.length== 43)
    }

    @Test
    fun genAppKeyPair() {
      val newKey= DidKeyPair(KeyType.ED25519, Bip44Utils.genSeed("abc","def","").seedBytes!!)
      Assert.assertTrue(newKey.privateKey.isNotEmpty())
      Assert.assertTrue(newKey.publicKey.isNotEmpty())
      val newKey1= DidKeyPair(KeyType.SECP256K1, Bip44Utils.genSeed("abc","def","").seedBytes!!)
      Assert.assertTrue(newKey1.privateKey.isNotEmpty())
      Assert.assertTrue(newKey1.publicKey.isNotEmpty())
    }

    @Test
    fun sk2did() {
      val did = IdGenerator.sk2did(RoleType.ACCOUNT,KeyType.ED25519,HashType.SHA3,kp.privateKey)
      Assert.assertEquals("did:abt:z1nVqvucZVv55nPGYuZ6YdNsL71ZHAEMMPg",did)
    }

    @Test
    fun sk2did1() {
      val sk = "26954E19E8781905E2CF91A18AE4F36A954C142176EE1BC27C2635520C49BC55".deBase16()
      val did = IdGenerator.sk2did(RoleType.ACCOUNT,KeyType.SECP256K1,HashType.SHA3,sk)
      Assert.assertEquals("did:abt:z1Ee1H8g248HqroacmEnZzMYgbhjz1Z2WSvv",did)

    }

    @Test
    fun pk2did() {
      val sk = "26954E19E8781905E2CF91A18AE4F36A954C142176EE1BC27C2635520C49BC55".deBase16()
      val did = IdGenerator.pk2did(RoleType.ACCOUNT,KeyType.SECP256K1,HashType.SHA3,IdGenerator.sk2pk(KeyType.SECP256K1, sk))
      Assert.assertEquals("did:abt:z1Ee1H8g248HqroacmEnZzMYgbhjz1Z2WSvv",did)
    }

    @Test
    fun preAppend() {
      var pre = IdGenerator.preAppend(RoleType.ACCOUNT,KeyType.SECP256K1,HashType.SHA3)
      Assert.assertEquals("0021",pre.toHexString())

      pre = IdGenerator.preAppend(RoleType.APPLICATION,KeyType.SECP256K1,HashType.SHA3)
      Assert.assertEquals("0C21",pre.toHexString().toUpperCase())

      pre = IdGenerator.preAppend(RoleType.APPLICATION,KeyType.SECP256K1,HashType.KECCAK)
      Assert.assertEquals("0C20",pre.toHexString().toUpperCase())

      pre = IdGenerator.preAppend(RoleType.APPLICATION,KeyType.SECP256K1,HashType.SHA3_512)
      Assert.assertEquals("0C25",pre.toHexString().toUpperCase())

    }

    @Test
    fun hash() {
      IdGenerator.hash(HashType.SHA3, "abc".toByteArray())
      IdGenerator.hash(HashType.SHA3_384, "abc".toByteArray())
      IdGenerator.hash(HashType.SHA3_512, "abc".toByteArray())

      IdGenerator.hash(HashType.KECCAK, "abc".toByteArray())
      IdGenerator.hash(HashType.KECCAK_384, "abc".toByteArray())
      IdGenerator.hash(HashType.KECCAK_512, "abc".toByteArray())
    }

    @Test
    fun sk2pk() {
      // test seck256k1
      var sk = BaseEncoding.base16().decode("26954E19E8781905E2CF91A18AE4F36A954C142176EE1BC27C2635520C49BC55")
      var pk = IdGenerator.sk2pk(KeyType.SECP256K1, sk)
      Assert.assertEquals("049AA8F402BB1A355F2FB2D0BE5CB1581668D5C2408E53932D517B58C41577F6C8558DDA51A1DCBE375DE0F097D1A0A99222EAD0D5BACCBE602DECC5A2F2504E30",pk.toHexString().toUpperCase())
      sk = BaseEncoding.base16().decode( "18E14A7B6A307F426A94F8114701E7C8E774E7F9A47E2C2035DB29A206321725")
      val kp = ECKeyPair.create(sk)
      Assert.assertEquals( "0450863AD64A87AE8A2FE83C1AF1A8403CB53F53E486D8511DAD8A04887E5B23522CD470243453A299FA9E77237716103ABC11A1DF38855ED6F2EE187E9C582BA6",BaseEncoding.base16().encode(kp.getPK()))
      Assert.assertEquals( "0450863AD64A87AE8A2FE83C1AF1A8403CB53F53E486D8511DAD8A04887E5B23522CD470243453A299FA9E77237716103ABC11A1DF38855ED6F2EE187E9C582BA6",IdGenerator.sk2pk(KeyType.SECP256K1, sk).toHexString().toUpperCase())

    }
}
