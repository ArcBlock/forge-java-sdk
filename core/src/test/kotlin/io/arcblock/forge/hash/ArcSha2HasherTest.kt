package io.arcblock.forge.hash

import com.google.common.io.BaseEncoding
import io.arcblock.forge.extension.toHexString
import org.junit.Assert
import org.junit.Test

class ArcSha2HasherTest {

  @Test
  fun sha() {
    val rst = BaseEncoding.base64().encode(ArcSha2Hasher.sha("abc".toByteArray()))
    Assert.assertEquals("T4tCwi3TcptRm6b2jS2nzFstYG0F2u1a1RKMwD5sY1g=", rst)
  }

//  @Test
//  fun sha224() {
//    val rst = BaseEncoding.base64().encode(ArcSha2Hasher.sha224("abc".toByteArray()))
//    Assert.assertEquals("L2Jo3othAXVp1oWTwAp7RC+dy4mHQ/QmK+TURA==", rst)
//  }
//
//  @Test
//  fun sha2241() {
//    val rst = BaseEncoding.base64().encode(ArcSha2Hasher.sha224("abc".toByteArray(), 1))
//    Assert.assertEquals("Iwl9IjQF2CKGQqR3vaJVsyqtvOS9oLP342ydpw==", rst)
//  }

  @Test
  fun sha256() {
    val rst = BaseEncoding.base64().encode(ArcSha2Hasher.sha256("abc".toByteArray()))
    Assert.assertEquals("T4tCwi3TcptRm6b2jS2nzFstYG0F2u1a1RKMwD5sY1g=", rst)
  }

  @Test
  fun sha2561() {
    var rst = BaseEncoding.base64().encode(ArcSha2Hasher.sha256("abc".toByteArray(), 1))
    Assert.assertEquals("ungWv48Bz+pBQUDeXa4iI7ADYaOWF3qctBD/YfIAFa0=", rst)

     rst = ArcSha2Hasher.sha256("2c06ce922dedaa0e2c141b040bb8034af17bf9962266".toByteArray(), 1).toHexString()
    //Assert.assertEquals("ungWv48Bz+pBQUDeXa4iI7ADYaOWF3qctBD/YfIAFa0=", rst)
    println("rst:$rst")

  }

  @Test
  fun sha384() {
    val rst = BaseEncoding.base64().encode(ArcSha2Hasher.sha384("abc".toByteArray()))
    Assert.assertEquals("cxAPAc8lh2aQbDSjD5pIbwclnGJ+oGltl8RYJWBEf1mm30p8+WBwgnGjAySxSB70", rst)
  }

  @Test
  fun sha3841() {
    val rst = BaseEncoding.base64().encode(ArcSha2Hasher.sha384("abc".toByteArray(), 1))
    Assert.assertEquals("ywB1P0WjXou1oD1pmsZQBycsMqsO3tFjGotgWkP/W+2AhgcroefMI1i67KE0yCWn", rst)
  }

  @Test
  fun sha512() {
    val rst = BaseEncoding.base64().encode(ArcSha2Hasher.sha512("abc".toByteArray()))
    Assert.assertEquals("NzqfOpAs9WEAO1E8lMUWS6SvE1y8TrTYVriepWCVI/Ewu+XkU+bGRbJ2WiZarrE5DILJExMIcGNs0Mjs+YDYUQ==", rst)
  }

  @Test
  fun sha5121() {
    val rst = BaseEncoding.base64().encode(ArcSha2Hasher.sha512("abc".toByteArray(), 1))
    Assert.assertEquals("3a81oZNherrMQXNJriBBMRLm+k6JqX6iCp7u5ktV05ohkpkqJ0/BqDa6PCOj/uu9RU1EI2Q86A4qmslPpUyknw==", rst)
  }
}
