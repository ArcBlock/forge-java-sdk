package io.arcblock.forge.hash

import com.google.common.io.BaseEncoding
import org.junit.Assert
import org.junit.Test

class ArcSha3HasherTest {

    @Test
    fun sha() {
        val rst = BaseEncoding.base64().encode(ArcSha3Hasher.sha("abc".toByteArray()))
        Assert.assertEquals("Ophdp0/iJbIEXBcta9OQvYVfCG4+nVJbRr/iRRFDFTI=", rst)
    }

    @Test
    fun sha384() {
        val rst = BaseEncoding.base64().encode(ArcSha3Hasher.sha384("abc".toByteArray()))
        Assert.assertEquals("7AFJgohRb8kmRZ9Y4satjfm0c8sPwIwlltp88OSb5LKY2IzqknrH9Tnx7fIoN20l", rst)
    }

    @Test
    fun sha512() {
        val rst = BaseEncoding.base64().encode(ArcSha3Hasher.sha512("abc".toByteArray()))
        Assert.assertEquals("t1GFCxpXFopWk82SS2sJbgj2IYJ0RPcNiE9dAkDScS4Q4RbpGSrzyRp+xXZH45NAVzQLTPQI1aVlkvgnTuxT8A==", rst)
    }

    @Test
    fun sha224() {
        val rst = BaseEncoding.base64().encode(ArcSha3Hasher.sha224("abc".toByteArray()))
        Assert.assertEquals("5kKCTD+M8krQkjTufTx2b8mjpRaNDJStc7Rv3w==", rst)
    }

    @Test
    fun sha256() {
        val rst = BaseEncoding.base64().encode(ArcSha3Hasher.sha256("abc".toByteArray()))
        Assert.assertEquals("Ophdp0/iJbIEXBcta9OQvYVfCG4+nVJbRr/iRRFDFTI=", rst)
    }
}
