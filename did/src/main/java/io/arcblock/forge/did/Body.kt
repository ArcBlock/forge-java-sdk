package io.arcblock.forge.did

import com.google.gson.JsonArray

data class Body(var iss: String, var iat: String, var nbf: String, var exp: String, var requestedClaims: JsonArray)
