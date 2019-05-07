package io.arcblock.forge

import com.google.common.io.BaseEncoding
import io.arcblock.forge.did.*
import org.junit.*


class test {
  @Test
  fun testHash() {
    val x = Hasher.hash(HashType.KECCAK, "z11PnP94rPbDYSkgVbJndc8KsVGaUXgBpabY".toByteArray())
    val ed = BaseEncoding.base64().encode(x)
    println("xxx:$ed")
  }
}
