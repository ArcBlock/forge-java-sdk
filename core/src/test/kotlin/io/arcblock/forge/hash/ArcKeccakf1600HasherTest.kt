package io.arcblock.forge.hash

import com.google.common.io.BaseEncoding
import org.junit.Assert
import org.junit.Test

class ArcKeccakf1600HasherTest {

  @Test
  fun sha() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha("abc".toByteArray()))
    Assert.assertEquals(rst, "TgNleupFqU/H1HuoJsjWZ8DR5uM6ZKA27ET1j6EtbEU=")
  }

  @Test
  fun sha224() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha224("abc".toByteArray()))
    Assert.assertEquals(rst, "wwQRdoUG6+HChxse4uh9ON80IxcwCpuXqV7GqA==")
  }

  @Test
  fun sha2241() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha224("abc".toByteArray(), 2))
    Assert.assertEquals(rst, "J0tBFymHKDZkw49EST9+3vp5otWdX2sBz40Suw==")
  }

  @Test
  fun sha256() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha256("abc".toByteArray()))
    Assert.assertEquals(rst, "TgNleupFqU/H1HuoJsjWZ8DR5uM6ZKA27ET1j6EtbEU=")
  }

  @Test
  fun sha2561() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha256("abc".toByteArray(), 2))
    Assert.assertEquals(rst, "uOEu7btg5TIdtH9aO/647A/2rprxACDMYbuMgq4Le2Y=")
  }

  @Test
  fun sha384() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha384("abc".toByteArray()))
    Assert.assertEquals(rst, "998RZfAzM3vgmOfSiK1qL3RAnXpgtJw2ZCIY3hYbH5n4xoHkr68xo02yn7dj48KO")
  }

  @Test
  fun sha3841() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha384("abc".toByteArray(), 2))
    Assert.assertEquals(rst, "BhFFkitc1Jt1MvdoK4orgq4DO/h02JQyKV91Vyzi8JjijGY80JIPbpvwH3etiiVf")
  }

  @Test
  fun sha512() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha512("abc".toByteArray()))
    Assert.assertEquals(rst, "GFh9wuoQa5oVY+MrMxJCHKFkx/Hwe8kiqcg9d86joeXQxpkQc5AlNy3BSslkJik3lUDBfiplsZ13qlEanQC7lg==")
  }

  @Test
  fun sha5121() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha512("abc".toByteArray(), 2))
    Assert.assertEquals(rst, "si4/zzihvlsOxYIZL7J8pK/UERPhAAo5vyhxQeBPpuE2JWA/LGPzPxx65pZ6qvMj7X86OzPnx08SlOyrDvPyzA==")
  }
}
