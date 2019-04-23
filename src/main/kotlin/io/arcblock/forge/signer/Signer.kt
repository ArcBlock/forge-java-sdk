package io.arcblock.forge.signer

import com.google.crypto.tink.subtle.Ed25519Sign
import com.google.crypto.tink.subtle.Ed25519Verify
import io.arcblock.forge.did.KeyType
import io.arcblock.forge.did.KeyType.ED25519
import io.arcblock.forge.did.KeyType.SECP256K1
import io.arcblock.forge.encodeToDER
import org.bitcoinj.core.ECKey.CURVE
import org.spongycastle.crypto.signers.ECDSASigner
import org.web3j.crypto.ECKeyPair
import java.lang.Exception
import org.spongycastle.crypto.ec.CustomNamedCurves
import org.spongycastle.crypto.params.ECDomainParameters
import org.web3j.crypto.ECDSASignature
import org.spongycastle.asn1.ASN1Integer
import org.spongycastle.asn1.DLSequence
import org.spongycastle.asn1.ASN1InputStream
import java.io.IOException
import org.spongycastle.crypto.params.ECPublicKeyParameters

/**
 * Author       :paperhuang
 * Time         :2019/2/19
 * Edited By    :
 * Edited Time  :
 **/
object Signer {
  val CURVE_PARAMS = CustomNamedCurves.getByName("secp256k1")
  val curve = ECDomainParameters(
  CURVE_PARAMS.curve, CURVE_PARAMS.g, CURVE_PARAMS.n, CURVE_PARAMS.h)
  fun sign(keyType: KeyType,content:ByteArray,sk: ByteArray):ByteArray{
    return when(keyType){
      ED25519 -> {
        return Ed25519Sign(sk.sliceArray(0..31)).sign(content)
      }
      SECP256K1 -> {
        return ECKeyPair.create(sk).sign(content).encodeToDER()
      }
    }
  }

  fun verify(keyType: KeyType,content:ByteArray,pk: ByteArray,signature: ByteArray):Boolean{
    try {
       return when(keyType){
        ED25519 -> {
           Ed25519Verify(pk).verify(signature,content)
          true
        }
        SECP256K1 -> {
          return verify(content, signature,pk)
        }
      }

    }catch (e:Exception){
      return false
    }
  }

  /**
   * SECP256K1 verify
   */
  private fun verify(data:ByteArray, signature:ByteArray,pk:ByteArray):Boolean{
    val signer = ECDSASigner()
    val params = ECPublicKeyParameters(CURVE.curve.decodePoint(pk), CURVE)
    signer.init(false, params)
    val sig = decodeFromDER(signature)
    return signer.verifySignature(data,sig.r,sig.s)
  }

  private fun decodeFromDER(bytes:ByteArray):ECDSASignature{
    var decoder: ASN1InputStream? = null
    try {
      decoder = ASN1InputStream(bytes)
      val seq = decoder.readObject() as DLSequence ?: throw RuntimeException("Reached past end of ASN.1 stream.")
      val r: ASN1Integer
      val s: ASN1Integer
      try {
        r = seq.getObjectAt(0) as ASN1Integer
        s = seq.getObjectAt(1) as ASN1Integer
      } catch (e: ClassCastException) {
        throw IllegalArgumentException(e)
      }
      // OpenSSL deviates from the DER spec by interpreting these values as unsigned, though they should not be
      // Thus, we always use the positive versions. See: http://r6.ca/blog/20111119T211504Z.html
      return ECDSASignature(r.positiveValue, s.positiveValue)
    } catch (e: IOException) {
      throw RuntimeException(e)
    } finally {
      if (decoder != null) try {
        decoder.close()
      } catch (x: IOException) {
      }

    }
  }


}
