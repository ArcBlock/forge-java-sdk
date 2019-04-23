package io.arcblock.forge

import com.google.common.io.BaseEncoding
import org.spongycastle.asn1.ASN1Integer
import org.spongycastle.asn1.DERSequenceGenerator
import org.web3j.crypto.ECDSASignature
import org.web3j.crypto.ECKeyPair
import java.io.ByteArrayOutputStream
import org.spongycastle.crypto.params.ECDomainParameters
import org.spongycastle.crypto.ec.CustomNamedCurves


private val CURVE_PARAMS = CustomNamedCurves.getByName("secp256k1")
val CURVE = ECDomainParameters(CURVE_PARAMS.curve, CURVE_PARAMS.g, CURVE_PARAMS.n, CURVE_PARAMS.h)


fun ByteArray.toHexString() = asUByteArray().joinToString("") { it.toString(16).padStart(2, '0') }

fun String.deBase16() = BaseEncoding.base16().decode(this)



fun ECDSASignature.encodeToDER(): ByteArray {
  val bos = ByteArrayOutputStream(72)
  val seq = DERSequenceGenerator(bos)
  seq.addObject(ASN1Integer(r))
  seq.addObject(ASN1Integer(s))
  seq.close()
  return bos.toByteArray()
}

//compress 66 uncompressed 130
fun ECKeyPair.getPK(): ByteArray {
//  return publicKey.toByteArray()
  var ret = publicKey.toByteArray()
  if (ret[0].toInt() == 0)
    ret = ret.sliceArray(1 until ret.size)
  return BaseEncoding.base16().decode("04") + ret
}

