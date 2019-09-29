package io.arcblock.forge

import com.google.common.io.BaseEncoding
import com.google.protobuf.Any
import com.google.protobuf.ByteString
import io.arcblock.forge.did.HashType
import io.arcblock.forge.utils.encodeB16
import io.arcblock.forge.utils.encodeB58
import org.junit.Test

class test {
  @Test
  fun testHash() {
    val x = Hasher.hash(HashType.KECCAK, "z11PnP94rPbDYSkgVbJndc8KsVGaUXgBpabY".toByteArray())
    val ed = BaseEncoding.base64().encode(x)
    println("xxx:$ed")
  }

  @Test
  fun calulateCode(){
    val p = "75CB8DA37D1FBE381AD7190ACE1C87E4D1312A689B2605F4C27A2C9E1CE63CC5".deBase16().encodeB58()
    val s = "B4C1FED5090DD64518C20EAF5F1636CB4C2A68456A945161192635EFB83C675275CB8DA37D1FBE381AD7190ACE1C87E4D1312A689B2605F4C27A2C9E1CE63CC5".deBase16().encodeB58()
    println("rst:$p")
    println("rst:$s")

  }

  @Test
  fun anyTest(){
    val data =Any.newBuilder().setTypeUrl("hello world").setValue(ByteString.copyFromUtf8("hello world")).build()
    println("bytes:")
    data.toByteArray().forEach {
      print("${it} ")
    }
    println("")
    println("bytes:end")
    println("any:${data.toByteArray().encodeB16()}")
  }

}
