package io.arcblock.forge.utils

import org.bitcoinj.core.Base58

/**
 * Author       :paperhuang
 * Time         :2019/3/5
 * Edited By    :
 * Edited Time  :
 **/
object Base58Btc {
  fun decode(data: String):ByteArray{
    return Base58.decode(data.removePrefix("z"))
  }

  fun encode(data: ByteArray):String{
    return "z".plus(Base58.encode(data))
  }
}
