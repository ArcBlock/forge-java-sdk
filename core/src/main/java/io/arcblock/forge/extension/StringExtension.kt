package io.arcblock.forge.extension


import com.google.common.io.BaseEncoding
import io.arcblock.forge.utils.Base58Btc
import java.math.BigDecimal
import java.text.DecimalFormat

/**
 *
 *     █████╗ ██████╗  ██████╗██████╗ ██╗      ██████╗  ██████╗██╗  ██╗
 *    ██╔══██╗██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗██╔════╝██║ ██╔╝
 *    ███████║██████╔╝██║     ██████╔╝██║     ██║   ██║██║     █████╔╝
 *    ██╔══██║██╔══██╗██║     ██╔══██╗██║     ██║   ██║██║     ██╔═██╗
 *    ██║  ██║██║  ██║╚██████╗██████╔╝███████╗╚██████╔╝╚██████╗██║  ██╗
 *    ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝
 * Author       : ${EMAIL}
 * Time         : 2019-06-14
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/


/**
 * base16 string to binary
 */

fun String.decodeB58() = Base58Btc.decode(this)
fun String.decodeB64() = BaseEncoding.base64().decode(this)
fun String.decodeB64Url() = BaseEncoding.base64Url().decode(this)
fun String.decodeB16() = BaseEncoding.base16().decode(this)
fun String.address() = this.removePrefix("did:abt:")
fun String.did() =  if (this.startsWith("did:abt:")) this else "did:abt:".plus(this)



fun ByteArray.encodeB58() = Base58Btc.encode(this)
fun ByteArray.encodeB64() = BaseEncoding.base64().encode(this)
fun ByteArray.encodeB64Url() = BaseEncoding.base64Url().encode(this)
fun ByteArray.encodeB16() = BaseEncoding.base16().encode(this)


fun BigDecimal.balance() = DecimalFormat("#,###.####").format(this.toDouble())


