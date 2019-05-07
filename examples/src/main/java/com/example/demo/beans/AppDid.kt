package com.example.demo.beans

import forge_abi.*

open class AppDid {
    //var did: String = ""

    var sk: ByteArray = ByteArray(0)
    var pk: ByteArray = ByteArray(0)
    var token: String = ""
    var address: String = ""
    var chainInfo: Type.ChainInfo? = null
}