package com.example.demo.services


interface IAuthService {

  fun requestAuth(jwt: String):String
  fun handleAuth(token: String, jwt: String): String

}
