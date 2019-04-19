package io.arcblock.walletkit.did

import io.arcblock.walletkit.bip44.Bip44Utils
import io.arcblock.walletkit.utils.Base58Btc
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class UtilTest {
  lateinit var kp: DidKeyPair
  lateinit var did: String
  @Before
  fun setUp() {
    kp= DidKeyPair(KeyType.ED25519,Bip44Utils.genSeed("abc","def","").seedBytes!!)
    did = IdGenerator.genAppDid(kp).removePrefix("did:abt:")
  }

  @Test
  fun decodeDidRoleType() {
    Assert.assertEquals(RoleType.ACCOUNT,Util.decodeDidRoleType(Base58Btc.decode(did)))
  }

  @Test
  fun decodeDidHashType() {
    Assert.assertEquals(HashType.SHA3,Util.decodeDidHashType(did))
  }

  @Test
  fun decodeDidSignType() {
    Assert.assertEquals(KeyType.ED25519,Util.decodeDidSignType(did))
  }
}
