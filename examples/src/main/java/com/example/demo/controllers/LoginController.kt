package com.example.demo.controllers

import com.example.demo.beans.*
import com.nimbusds.jose.*
import com.nimbusds.jwt.*
import org.springframework.web.bind.annotation.*
import com.nimbusds.jwt.JWTClaimsSet
import java.util.*
import com.nimbusds.jose.crypto.MACSigner
import org.springframework.beans.factory.annotation.*
import javax.annotation.*


@RestController
class LoginController : BaseController() {

    @Resource(name = "a") open lateinit var appDid: AppDid

    @RequestMapping("/login",method = [RequestMethod.POST])
    @ResponseBody
    fun login(@RequestParam("did") did: String):String{
        logger.info("did:$did")
        val now = Date()
        val jwtClaims = JWTClaimsSet.Builder()
                .issuer("https://arcblock.io")
                .subject("abt")
                .audience(did)
                .expirationTime(Date(now.time + 1000 * 60 * 10)) // expires in 10 minutes
                .notBeforeTime(now)
                .issueTime(now)
                .jwtID(UUID.randomUUID().toString())
                .build()
        val jwt = SignedJWT( JWSHeader(JWSAlgorithm.HS256),jwtClaims)

        // Create HMAC signer
        val signer = MACSigner(appDid.sk)
        jwt.sign(signer)
        return "{token: \"${jwt.serialize()}\"}"
    }

}