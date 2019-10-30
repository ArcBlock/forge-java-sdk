package io.arcblock.forge.extension

import com.google.protobuf.ByteString
import io.arcblock.forge.Hasher
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.KeyType
import io.arcblock.forge.sign.Signer
import java.math.BigDecimal
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

/**
 * Hash extension for bytes
 */
fun ByteArray.hash(type: HashType) = Hasher.hash(type, this)

/**
 * ED25519 Sign extension for bytes
 */
fun ByteArray.sign(sk: ByteArray) = Signer.sign(KeyType.ED25519, this, sk)

/**
 * Sign extension for bytes
 */
fun ByteArray.sign(sk: ByteArray, type: KeyType) = Signer.sign(type, this, sk)

/**
 * Bytes to byteString extension
 */
fun ByteArray.toByteString() = ByteString.copyFrom(this)

/**
 * binary to hex string
 */
fun ByteArray.toHexString() = asUByteArray().joinToString("") { it.toString(16).padStart(2, '0') }


/**
 * Divide by decimal to reserve 4 decimal places
 */
fun ByteArray.token(decimals: Int) =  BigInteger(this).unSign().toBigDecimal()
  .setScale(4, BigDecimal.ROUND_HALF_UP)
  .div(BigDecimal("1E$decimals"))
  .balance()


