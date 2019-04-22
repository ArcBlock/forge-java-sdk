package io.arcblock.walletkit.signer

import com.google.common.io.BaseEncoding
import io.arcblock.walletkit.did.KeyType
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SignerTest {
  lateinit var pk :ByteArray
  lateinit var sk :ByteArray
  lateinit var hash:String
  lateinit var sePk :ByteArray
  lateinit var seSk :ByteArray

  @Before
  fun setUp(){
    pk = BaseEncoding.base64Url().decode("LYQJbdHujpvsjxC9v7qh0GDRdiADv8ByP0m5xqjhrMg=")
    sk = BaseEncoding.base64Url().decode("W3Cgl4_YvG-h0g61LrhgWoXRW_RtWXKNKu7d-hZWtTAthAlt0e6Om-yPEL2_uqHQYNF2IAO_wHI_SbnGqOGsyA==")
    hash = "EBA4F1D7DA9164DB5A1B56EA0540AC29250DC746BE190042C1B4FD94410514B2"

    seSk = BaseEncoding.base64Url().decode("DMqjMnPSmsMVALcLYOYUjxoNUgRykrVrbiAqVBgr1YI=")
    sePk = BaseEncoding.base64Url().decode("BDo_VnoMOgTSfhiHjxgpd3avTncf5eYc-EzbKlMlySdFjdGmH-Fnr2z9CfOv8ro560JVC0JrJ172h_c1zaUjcWU=")

  }

  @Test
  fun sign() {
    val sig = BaseEncoding.base64Url().encode(Signer.sign(KeyType.ED25519, hash.toByteArray(), sk))
    Assert.assertEquals("An_vGha5Y5XYFUNX2B3IvVfO57lJHjVO5nLmanyWDWDz5GZsIgcvi-rfESgBVJZdkiFSDSm1d3NUkTLs60FJCA==",sig)

    val sigSecp = BaseEncoding.base64Url().encode(Signer.sign(KeyType.SECP256K1, hash.toByteArray(), seSk))
    Assert.assertEquals("MEQCIH_qbkbkPFEBejYUyaUujBJGajp1GNxKJ-oRnxUKl7kyAiBgxuxfCqFK8_Tem3Aw5cszOj5-K8dkKJZCTt7v5OGhWQ==",sigSecp)

  }

  @Test
  fun verify(){
    val sig =  BaseEncoding.base64Url().decode("An_vGha5Y5XYFUNX2B3IvVfO57lJHjVO5nLmanyWDWDz5GZsIgcvi-rfESgBVJZdkiFSDSm1d3NUkTLs60FJCA==")
    Assert.assertTrue(Signer.verify(KeyType.ED25519,hash.toByteArray(),pk,sig))

    val sigSecp = BaseEncoding.base64Url().decode("MEQCIH_qbkbkPFEBejYUyaUujBJGajp1GNxKJ-oRnxUKl7kyAiBgxuxfCqFK8_Tem3Aw5cszOj5-K8dkKJZCTt7v5OGhWQ==")
    Assert.assertTrue(Signer.verify(KeyType.SECP256K1,hash.toByteArray(),sePk,sigSecp))
  }


}
