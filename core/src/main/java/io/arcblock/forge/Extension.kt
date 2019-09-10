package io.arcblock.forge

import com.google.common.io.BaseEncoding
import com.google.protobuf.ByteString
import forge_abi.Rpc
import forge_abi.Type
import io.arcblock.forge.did.HashType
import io.arcblock.forge.did.KeyType
import io.arcblock.forge.sign.Signer
import org.spongycastle.asn1.ASN1Integer
import org.spongycastle.asn1.DERSequenceGenerator
import org.spongycastle.crypto.ec.CustomNamedCurves
import org.web3j.crypto.ECDSASignature
import org.web3j.crypto.ECKeyPair
import java.io.ByteArrayOutputStream

private val CURVE_PARAMS = CustomNamedCurves.getByName("secp256k1")

/**
 * binary to hex string
 */
fun ByteArray.toHexString() = asUByteArray().joinToString("") { it.toString(16).padStart(2, '0') }

/**
 * base16 string to binary
 */
fun String.deBase16() = BaseEncoding.base16().decode(this)

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
fun ForgeSDK.sendTx(tx: Type.Transaction): Rpc.ResponseSendTx {
  return sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).build())
}

/**
 * base58btc address to DID
 */
fun String.addrToDID(): String {
  if (this.startsWith("did:abt:z")) {
    return this
  } else return "did:abt:".plus(this)
}

/**
 * DID to base58btc address
 */
fun String.didToAddr(): String {
  return this.removePrefix("did:abt:")
}

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
 * Extension of transaction for signature
 */
fun Type.Transaction.signTx(sk: ByteArray): Type.Transaction {
  val sig = this.toBuilder().clearSignature().build().toByteArray().hash(HashType.SHA3).sign(sk)
  return this.toBuilder().setSignature(sig.toByteString()).build()
}
