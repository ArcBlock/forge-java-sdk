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

  @Before
  fun setUp(){
    pk = BaseEncoding.base64Url().decode("LYQJbdHujpvsjxC9v7qh0GDRdiADv8ByP0m5xqjhrMg=")
    sk = BaseEncoding.base64Url().decode("W3Cgl4_YvG-h0g61LrhgWoXRW_RtWXKNKu7d-hZWtTAthAlt0e6Om-yPEL2_uqHQYNF2IAO_wHI_SbnGqOGsyA==")
    hash = "EBA4F1D7DA9164DB5A1B56EA0540AC29250DC746BE190042C1B4FD94410514B2"


  }

  @Test
  fun sign() {
    val sig = BaseEncoding.base64Url().encode(Signer.sign(KeyType.ED25519, hash.toByteArray(), sk))
    Assert.assertEquals("An_vGha5Y5XYFUNX2B3IvVfO57lJHjVO5nLmanyWDWDz5GZsIgcvi-rfESgBVJZdkiFSDSm1d3NUkTLs60FJCA==",sig)
  }

  @Test
  fun verify(){
    val sig =  BaseEncoding.base64Url().decode("An_vGha5Y5XYFUNX2B3IvVfO57lJHjVO5nLmanyWDWDz5GZsIgcvi-rfESgBVJZdkiFSDSm1d3NUkTLs60FJCA==")
    Assert.assertTrue(Signer.verify(KeyType.ED25519,hash.toByteArray(),pk,sig))
  }


}
