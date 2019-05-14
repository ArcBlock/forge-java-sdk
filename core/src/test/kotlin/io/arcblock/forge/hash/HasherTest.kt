package io.arcblock.forge.hash

import com.google.common.io.BaseEncoding
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class HasherTest {

  @Test
  fun testKECCAK() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha("abc".toByteArray()))
    Assert.assertEquals(rst, "TgNleupFqU/H1HuoJsjWZ8DR5uM6ZKA27ET1j6EtbEU=")
  }

  @Test
  fun testKECCAK_384() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha384("abc".toByteArray(), 1))
    Assert.assertEquals(rst, "998RZfAzM3vgmOfSiK1qL3RAnXpgtJw2ZCIY3hYbH5n4xoHkr68xo02yn7dj48KO")
  }

  @Test
  fun testKECCAK_512() {
    val rst = BaseEncoding.base64().encode(ArcKeccakf1600Hasher.sha512("abc".toByteArray(), 1))
    Assert.assertEquals(rst, "GFh9wuoQa5oVY+MrMxJCHKFkx/Hwe8kiqcg9d86joeXQxpkQc5AlNy3BSslkJik3lUDBfiplsZ13qlEanQC7lg==")
  }

  @Test
  fun testSHA3() {
  }

  @Test
  fun testSHA3_384() {
  }

  @Test
  fun testSHA3_512() {
  }

  @Test
  fun testSHA2() {
  }
}
