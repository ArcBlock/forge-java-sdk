package io.arcblock.walletkit.utils

import com.google.common.io.BaseEncoding
import io.arcblock.walletkit.toHexString
import org.bitcoinj.core.Base58
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

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
