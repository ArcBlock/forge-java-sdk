package com.example.demo.controllers

import com.example.demo.services.*
import com.google.gson.*
import forge_abi.*
import io.arcblock.forge.did.*
import io.arcblock.forge.did.bean.*
import org.springframework.beans.factory.annotation.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ApiController {

  @Autowired lateinit var authService: AuthServiceImpl

  @RequestMapping("/auth/",method = [RequestMethod.GET])
  @ResponseBody
  fun getAuth(jwt: String):String{
    return authService.requestAuth(jwt)
  }

  @RequestMapping("/auth/",method = [RequestMethod.POST])
  @ResponseBody
  fun postAuth(token: String,jwt: String):String{
    return authService.handleAuth(token,jwt)
  }


  fun requestPoke(jwt: String):String{
    return ""
  }

  fun createProduct(jwt: String){

  }





}
