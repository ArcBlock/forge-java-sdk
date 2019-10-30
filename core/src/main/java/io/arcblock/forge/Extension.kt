package io.arcblock.forge

import com.google.common.io.BaseEncoding
import forge_abi.Rpc
import org.spongycastle.asn1.ASN1Integer
import org.spongycastle.asn1.DERSequenceGenerator
import org.spongycastle.crypto.ec.CustomNamedCurves
import org.web3j.crypto.ECDSASignature
import org.web3j.crypto.ECKeyPair
import java.io.ByteArrayOutputStream

private val CURVE_PARAMS = CustomNamedCurves.getByName("secp256k1")


/**
 * ECDSAs signature to DER
 */
fun ECDSASignature.encodeToDER(): ByteArray {
  val bos = ByteArrayOutputStream(72)
  val seq = DERSequenceGenerator(bos)
  seq.addObject(ASN1Integer(r))
  seq.addObject(ASN1Integer(s))
  seq.close()
  return bos.toByteArray()
}

/**
 * compress 66 uncompressed 130
 * append 04 in ECKey public key.
 */
fun ECKeyPair.getPK(): ByteArray {
  var ret = publicKey.toByteArray()
  if (ret[0].toInt() == 0)
    ret = ret.sliceArray(1 until ret.size)
  return BaseEncoding.base16().decode("04") + ret
}

/**
 * Simple way to sent a transaction.
 * avoid to send by a token.
 */




data class Result(val response: Rpc.ResponseSendTx, val address: String)



