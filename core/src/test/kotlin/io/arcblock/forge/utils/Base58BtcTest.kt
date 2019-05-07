package io.arcblock.forge.utils

import org.junit.Assert
import org.junit.Test

class Base58BtcTest {

    @Test
    fun decode() {
      var b58 = Base58Btc.encode("abc".toByteArray())
      Assert.assertEquals("zZiCa",b58)


      var pk = Base58Btc.decode("zExrfT2pXtVqdAqgZwjvdMBo5RpqSqn1fa43Wp93peuSR")
      Assert.assertEquals("zExrfT2pXtVqdAqgZwjvdMBo5RpqSqn1fa43Wp93peuSR",Base58Btc.encode(pk))

    }

    @Test
    fun encode() {
      var pk = Base58Btc.decode("zExrfT2pXtVqdAqgZwjvdMBo5RpqSqn1fa43Wp93peuSR")
      Assert.assertEquals("zExrfT2pXtVqdAqgZwjvdMBo5RpqSqn1fa43Wp93peuSR",Base58Btc.encode(pk))

    }
}
