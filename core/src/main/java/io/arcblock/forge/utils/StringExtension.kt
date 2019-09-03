package io.arcblock.forge.utils


import com.google.common.io.BaseEncoding
import com.google.protobuf.ByteString
import io.arcblock.forge.Hasher
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.KeyType
import io.arcblock.forge.signer.Signer
import java.math.BigDecimal
import java.math.BigInteger
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

fun String.decodeB58() = Base58Btc.decode(this)
fun String.decodeB64() = BaseEncoding.base64().decode(this)
fun String.decodeB64Url() = BaseEncoding.base64Url().decode(this)
fun String.decodeB16() = BaseEncoding.base16().decode(this)
fun String.address() = this.removePrefix("did:abt:")
fun String.did() =  if (this.startsWith("did:abt:")) this else "did:abt:".plus(this)
fun ByteArray.toByteString() = ByteString.copyFrom(this)


fun ByteArray.encodeB58() = Base58Btc.encode(this)
fun ByteArray.encodeB64() = BaseEncoding.base64().encode(this)
fun ByteArray.encodeB64Url() = BaseEncoding.base64Url().encode(this)
fun ByteArray.encodeB16() = BaseEncoding.base16().encode(this)
fun ByteArray.hash(type: HashType) = Hasher.hash(type, this)
fun ByteArray.sign(sk: ByteArray) = Signer.sign(KeyType.ED25519, this, sk)
fun ByteArray.sign(sk: ByteArray, type: KeyType) = Signer.sign(type, this, sk)

/**
 * bigInteger to  unsign num
 */
fun BigInteger.unSign() = if (this.signum() >= 0 ) this else {
  val a1 = this.toByteArray()
  val a2 = ByteArray(a1.size + 1)
  a2[0] = 0
  System.arraycopy(a1, 0, a2, 1, a1.size)
  BigInteger(a2)
}
fun BigDecimal.balance() = DecimalFormat("#,###.####").format(this.toDouble())

fun ByteArray.token(decimals: Int) =  BigInteger(this).unSign().toBigDecimal()
  .setScale(4,BigDecimal.ROUND_HALF_UP)
  .div(BigDecimal("1E$decimals"))
  .balance()

