package io.arcblock.forge

import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.HashUtils
import io.arcblock.forge.hash.ArcKeccakf1600Hasher
import io.arcblock.forge.hash.ArcSha2Hasher
import io.arcblock.forge.hash.ArcSha3Hasher

/**
 *  Calculate Hash
 */
object Hasher {

  /**
   * Calculate Hash
   * @param hashType enum class HashType
   * @param contents hash content
   * @return result
   */
  fun hash(hashType: HashType, contents: ByteArray): ByteArray {
    return when (hashType) {
      HashType.SHA3 -> {
        ArcSha3Hasher.sha256(contents, 1)
      }
      HashType.KECCAK -> {
        ArcKeccakf1600Hasher.sha(contents)
      }
      HashType.KECCAK_384 -> {
        ArcKeccakf1600Hasher.sha384(contents)
      }
      HashType.KECCAK_512 -> {
        ArcKeccakf1600Hasher.sha512(contents)
      }
      HashType.SHA3_384 -> {
        ArcKeccakf1600Hasher.sha384(contents)
      }
      HashType.SHA3_512 -> {
        ArcKeccakf1600Hasher.sha512(contents)
      }
      HashType.SHA2 ->{
        ArcSha2Hasher.sha(contents)
      }
      else -> {
        HashUtils.sha3(contents)
      }
    }
  }
}
