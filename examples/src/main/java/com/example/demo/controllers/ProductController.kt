package com.example.demo.controllers

import com.example.demo.*
import com.example.demo.beans.*
import com.example.demo.components.*
import com.example.demo.handlers.*
import com.google.common.io.*
import com.google.gson.*
import com.google.protobuf.*
import com.google.protobuf.Any
import com.nimbusds.jwt.*
import forge_abi.*
import forge_abi.Enum
import forge_abi.Type
import io.arcblock.forge.*
import io.arcblock.forge.utils.*
import org.springframework.beans.factory.annotation.*
import org.springframework.web.bind.annotation.*
import java.math.*
import javax.annotation.*
import kotlin.math.*

@RestController
@RequestMapping("/product")
class ProductController :BaseController(){

    @Autowired lateinit var forge: ForgeSDKComponent
    @Resource(name = "a") lateinit var appDid: AppDid
    @Resource(name = "b") lateinit var other: AppDid
    @RequestMapping("/create",method = [RequestMethod.POST])
    @ResponseBody
    open fun createProduct(@RequestParam("token",required = true) token: String
    ,@RequestParam("pk") pkB58: String,@RequestParam("moniker") moniker: String ): String{
        val jwt = JWTParser.parse(token)
        val did = jwt.jwtClaimsSet.audience.first()
        val pk = Base58Btc.decode(pkB58)

        val request =
                ProductHandler.createTx(moniker,moniker,did,appDid.pk,appDid)

        logger.info(request.toString())
        val response = forge.forgeSDK.sendTx(request)
        if (response.code == Enum.StatusCode.ok)
            return "hash:\"${response.hash}\""
        else return "{\"error\":\"${response.code.name}\"}"
    }

    @RequestMapping("/{id}/buy")
    @ResponseBody
    fun buyProduct(@PathVariable id: String,address: String,sk: String,pk: String): String{

        val itx = ProductHandler.exchange(address,id)
        logger.info("address:$address")
        val tx = Utils.createTx(Any.newBuilder().setTypeUrl(TypeUrls.EXCHANGE)
                .setValue(itx.toByteString()).build(),appDid)
        val response = Utils.multiSig(tx,Base58Btc.decode(sk),Base58Btc.decode(pk),address
        ,appDid,forge)
        return if (response.code == Enum.StatusCode.ok)
            "error:\"${response.hash}\""
        else "{\"error\":\"${response}\"}"
    }

    @RequestMapping("/send")
    @ResponseBody
    fun sendToken(address: String,token: String): String{

        val itx = Transfer.TransferTx.newBuilder()
                .setValue(Type.BigUint.newBuilder().setValue(ByteString.copyFrom(BigInteger.valueOf(1L).abs().toByteArray())).build())
                .setTo(address)
                .build()

        logger.info("address:$address")
        val ctx= Rpc.RequestCreateTx.newBuilder().setToken(appDid.token)
                .setItx(Any.newBuilder().setTypeUrl(TypeUrls.TRANSFER)
                        .setValue(itx.toByteString()).build()
                ).setNonce(123L).setFrom(appDid.address).build();
        val rtx = forge.forgeSDK.createTx(ctx)
        val response = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder()
                .setToken(appDid.token)
                .setTx(rtx.tx)
                .build())
        return if (response.code == Enum.StatusCode.ok)
            "hash:\"${response.hash}\""
        else "{\"error\":\"${response}\"}"
    }


    @RequestMapping("/{id}/buy1")
    @ResponseBody
    fun buyProduct1(@PathVariable id: String): String{
        //create itx
        val itx = ProductHandler.exchange(other.address,id)

        logger.info("\n===token== ${appDid.token}" +
                "pk:${Base58Btc.encode(appDid.pk)}" +
                "sk:${Base58Btc.encode(appDid.sk)}" +
                "\n\n")
        logger.info("\n===token== ${other.token}" +
                "pk:${Base58Btc.encode(other.pk)}" +
                "sk:${Base58Btc.encode(other.sk)}" +
                "\n\n")
        //create tx
        val ctx= Rpc.RequestCreateTx.newBuilder().setToken(appDid.token)
                .setItx(Any.newBuilder().setTypeUrl(TypeUrls.EXCHANGE)
                        .setValue(itx.toByteString()).build()
                ).setNonce(123L).setFrom(appDid.address)
                .build()
        val rctx =forge.forgeSDK.createTx(ctx)

        logger.info(rctx.tx.toString())


        //multisig
        val mult =  Rpc.RequestMultisig.newBuilder()
                .setTx(rctx.tx)
                .setToken(other.token)
                .build()
        val rs = forge.forgeSDK.multisig(mult)


        val multiSigTx = rs.tx
        logger.info("\ntx: ============>\n${rs.tx} =======\n\n\n")
        logger.info("\ntx base16url: ============>\n${BaseEncoding.base16().encode(rs.tx.toByteArray())} =======\n\n\n")
        val msig= multiSigTx.getSignatures(0).toBuilder().setSignature(ByteString.EMPTY).build();
        val n = multiSigTx.toBuilder().setSignatures(0,msig).build();
        logger.info("ori: ============>\n${Base58Btc.encode(n.toByteArray())} =======\n\n\n")

        val response = forge.forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder()
                .setTx(rs.tx)
                .setToken(appDid.token)
                .build())
        return if (response.code == Enum.StatusCode.ok)
            "hash:\"${response.hash}\""
        else "{\"error\":\"${response}\"}"
    }


    @RequestMapping("/list")
    @ResponseBody
    fun listProduct(cursor :String? = "",did: String): String{
        val request =  ProductHandler.listAssets(cursor?:"",did)
        val response = forge.forgeSDK.listAssets(request)
        return response.toString()
    }


    @RequestMapping("/{id}/vote")
    @ResponseBody
    fun voteProduct(@PathVariable id: String): String{
        return "{\"status\":0}"
    }

    @RequestMapping("/{id}/down")
    @ResponseBody
    fun downProduct(@PathVariable id: String): String{
        return "{\"status\":0}"
    }

    @RequestMapping("/{id}/complain")
    @ResponseBody
    fun complain(@PathVariable id: String){

    }




    @RequestMapping("/new")
    @ResponseBody
    fun index(): String{
        return "hello products"
    }



}