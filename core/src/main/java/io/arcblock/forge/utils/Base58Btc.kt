package io.arcblock.forge.utils

import org.bitcoinj.core.Base58

/**
 * Base58 Btc DidUtils
 *
 **/
object Base58Btc {
  /**
   * decode Any Base58 string
   * @param data base58 string
   * @return binary
   */
  fun decode(data: String):ByteArray{
    return Base58.decode(data.removePrefix("z"))
  }

  /**
   * encode binary to base58 BTC string, and with prefix 'z'
   * @param data binary
   * @return base58 string
   */
  fun encode(data: ByteArray):String{
    return "z".plus(Base58.encode(data))
  }
}
