package io.arcblock.forge.did

import org.web3j.crypto.Hash

/**
 * Author       :paperhuang
 * Time         :2019/2/15
 * Edited By    :
 * Edited Time  :
 **/
object HashUtils {

  fun keccak(input:ByteArray) :ByteArray{
    return Hash.sha3(input)
  }

  fun sha3(input:ByteArray) :ByteArray{
    return Hash.sha3(input)
  }

}
