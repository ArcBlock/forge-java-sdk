package com.example.demo.controllers

import com.example.demo.beans.AppDid
import com.nimbusds.jose.JWSAlgorithm
import com.nimbusds.jose.JWSHeader
import com.nimbusds.jose.crypto.MACSigner
import com.nimbusds.jwt.JWTClaimsSet
import com.nimbusds.jwt.SignedJWT
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.Date
import java.util.UUID
import javax.annotation.Resource

@RestController
class LoginController : BaseController() {

    @Resource(name = "a") open lateinit var appDid: AppDid

    @RequestMapping("/login", method = [RequestMethod.POST])
    @ResponseBody
    fun login(@RequestParam("did") did: String): String {
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
        val jwt = SignedJWT(JWSHeader(JWSAlgorithm.HS256), jwtClaims)

        // Create HMAC sign
        val signer = MACSigner(appDid.sk)
        jwt.sign(signer)
        return "{token: \"${jwt.serialize()}\"}"
    }
}
