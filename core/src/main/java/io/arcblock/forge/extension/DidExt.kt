package io.arcblock.forge.extension

/**
 ** Author       : shan@arcblock.io
 * Time         : 2019-10-30
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/

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
