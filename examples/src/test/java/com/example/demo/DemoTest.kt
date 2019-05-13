package com.example.demo

import com.google.protobuf.ByteString
import forge_abi.Type
import io.arcblock.forge.Hasher
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.KeyType
import io.arcblock.forge.signer.Signer
import io.arcblock.forge.utils.Base58Btc
import org.junit.Test

class DemoTest {

    @Test
    fun test() {
        val ori = Base58Btc.decode("z2CJHBxJMkg6dPVQx4v2c7XHbV8NoDndcin3H76SraCQqLiqDMrcX5AfodK8Ax7QbkM46eg14cj2wExLBUKxqZGbBSJgXN5GLnNcLxDn1AXP1LbQsFGRAkoLL9bjXsiNe9ZCTjMbFF8LGGWTr4WNPkpuP32WVWThnW7YEWAsXhZuQcnwzeyoSvzCbbi42G7WcyuabUS7wyHn6apaRzGXCaYdLMKjvwDCnJ6ZCE1TMEaokfViA5i5H5xbv24UNLSQRVHTcqcJKK7pw42AuKZ3XVBwEXwTiaZExZuj7wjahd8D7fEjvab1JyvYfmUW6cPqSMEAGf9G1kNfs6EW8GUgRzRp8eENRuRsRCNcVPY14bG4cTFgdEc4GYAue1ZHQeSUhhanhjMB8r47PG64WndFLbRY7QmKGFBNyGLHdosBRdvuHjD5BBhy9ykHScc39")
        val hash = Hasher.hash(HashType.KECCAK, ori)
        val sig = Signer.sign(KeyType.ED25519, hash, Base58Btc.decode("z3KiejcE6nqEYhqMsmDLZCjjzPpSuEGNhvULwvgKNrfzX2VqSAVQnG3iSQKrc5JRVrEvo5ni4dLVpEUBkyxkB7xnq"))
        val multi = Type.Multisig.newBuilder().setSignature(ByteString.copyFrom(sig)).build()
        println("sig:${Base58Btc.encode(sig)}")
    }
}
