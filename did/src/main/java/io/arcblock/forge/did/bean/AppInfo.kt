package io.arcblock.forge.did.bean

/**
 * Application Info return to Client
 */
class AppInfo() {
  var chainHost:String = ""
  var copyright: String = ""
  var icon: String = ""
  var name: String = ""
  var path: String = ""
  var description: String = ""
  var publisher: String = ""
  var subtitle: String = ""

  constructor(chainHost:String,name: String, logo: String, desc: String, pk: String ): this(){
    this.chainHost = chainHost
    this.icon = logo
    this.description = desc
    this.name = name
    this.publisher= pk
  }
}


