package io.arcblock.forge.did.bean

import com.google.gson.JsonArray

class DidResponseBody(var appPk: String, var authInfo: String)
class DidRequestBody(var userPk: String?, var userInfo: String)
class DIDTokenResponse(
  var action: String,
  var appInfo: AppInfo,
  var requestedClaims: JsonArray,
  var url: String,
  var exp: String,
  var iat: String,
  var iss: String,
  var nbf: String
)
