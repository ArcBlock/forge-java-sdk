package io.arcblock.forge.extension

import java.math.BigInteger

/**
 *
 *     █████╗ ██████╗  ██████╗██████╗ ██╗      ██████╗  ██████╗██╗  ██╗
 *    ██╔══██╗██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗██╔════╝██║ ██╔╝
 *    ███████║██████╔╝██║     ██████╔╝██║     ██║   ██║██║     █████╔╝
 *    ██╔══██║██╔══██╗██║     ██╔══██╗██║     ██║   ██║██║     ██╔═██╗
 *    ██║  ██║██║  ██║╚██████╗██████╔╝███████╗╚██████╔╝╚██████╗██║  ██╗
 *    ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝
 * Author       : shan@arcblock.io
 * Time         : 2019-10-30
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/

fun BigInteger.unSign(): BigInteger {
  if (this.signum() >= 0) {
    return this
  }
  val a1 = this.toByteArray()
  val a2 = ByteArray(a1.size + 1)
  a2[0] = 0
  System.arraycopy(a1, 0, a2, 1, a1.size)
  return BigInteger(a2)
}
