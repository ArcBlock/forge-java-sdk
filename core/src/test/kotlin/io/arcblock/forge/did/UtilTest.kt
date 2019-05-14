package io.arcblock.forge.did

import io.arcblock.forge.bip44.Bip44Utils
import io.arcblock.forge.utils.Base58Btc
import org.junit.Assert
import org.junit.Test

import org.junit.Before

class UtilTest {
  lateinit var kp: DidKeyPair
  lateinit var did: String
  @Before
  fun setUp() {
    kp = DidKeyPair(KeyType.ED25519, Bip44Utils.genSeed("abc", "def", "").seedBytes!!)
    did = DIDGenerator.genAppDid(kp).removePrefix("did:abt:")
  }

  @Test
  fun decodeDidRoleType() {
    Assert.assertEquals(RoleType.ACCOUNT, DidUtils.decodeDidRoleType(Base58Btc.decode(did)))
  }

  @Test
  fun decodeDidHashType() {
    Assert.assertEquals(HashType.SHA3, DidUtils.decodeDidHashType(did))
  }

  @Test
  fun decodeDidSignType() {
    Assert.assertEquals(KeyType.ED25519, DidUtils.decodeDidSignType(did))
  }
}
