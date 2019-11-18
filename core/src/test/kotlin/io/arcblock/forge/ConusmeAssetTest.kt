package io.arcblock.forge

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.LoggerContext
import com.google.protobuf.Any
import forge_abi.Enum
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.extension.toByteString
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.slf4j.LoggerFactory
import java.util.*
import kotlin.test.assertEquals

/**
 *
 *     █████╗ ██████╗  ██████╗██████╗ ██╗      ██████╗  ██████╗██╗  ██╗
 *    ██╔══██╗██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗██╔════╝██║ ██╔╝
 *    ███████║██████╔╝██║     ██████╔╝██║     ██║   ██║██║     █████╔╝
 *    ██╔══██║██╔══██╗██║     ██╔══██╗██║     ██║   ██║██║     ██╔═██╗
 *    ██║  ██║██║  ██║╚██████╗██████╔╝███████╗╚██████╔╝╚██████╗██║  ██╗
 *    ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝
 * Author       : shan@arcblock.io
 * Time         : 2019-11-18
 * Edited By    :
 * Edited Time  :
 * Description  : This script demonstrates the whole workflow of consume assets
 **/
@Ignore
class ConusmeAssetTest {

  private lateinit var consumer: WalletInfo
  private lateinit var issuer: WalletInfo
  private lateinit var gateKeeper: WalletInfo
  private lateinit var forge: ForgeSDK
  private lateinit var address: String
  @Before
  fun setUp() {
    (LoggerFactory.getILoggerFactory() as LoggerContext).getLogger("io.arcblock").level = Level.INFO
    (LoggerFactory.getILoggerFactory() as LoggerContext).getLogger("io.grpc").level = Level.OFF
    (LoggerFactory.getILoggerFactory() as LoggerContext).getLogger("io.netty").level = Level.OFF
    forge = ForgeSDK.connect("localhost", 28212)
    issuer = forge.createWallet()
    consumer = forge.createWallet()
    gateKeeper = forge.createWallet()
    forge.declare("Issuer",issuer)
    forge.declare("consumer",consumer)
    forge.poke(consumer)
    println("issuer:$issuer")
    println("consumer:$consumer")

    //Declare gate keeper as Issuer's child account
    forge.declare("GateKeeper", gateKeeper, issuer.address)
    //Issuer create a asset
    address =forge.createAsset("string", UUID.randomUUID().toString().toByteArray(), "Ticket", issuer).address
  }

  @Test
  fun testConusme(){
    //transfer asset to consumer
    val rspTransfer = forge.transfer(issuer, consumer.address, assets = listOf(address))
    println("rspTransfer:\n$rspTransfer")

    //create pre Tx for ticket owner to multiSign and consume asset
    val preTx = TransactionFactory.preConusmeAsset(forge.chainInfo.value.network, gateKeeper, issuer.address)

    //consume multiSig tx
    val finalTx = TransactionFactory.finalizeMultiSig(preTx, consumer, data = Any.newBuilder()
      .setValue(address.toByteArray().toByteString())
      .setTypeUrl(TypeUrls.CONSUME_ASSET_ADDRESS)
      .build())

    //send tx ,you can check it at
    val rsp = forge.sendTx(finalTx)
    println("consume asset:\n $rsp")
    assertEquals(Enum.StatusCode.ok, rsp.code)
  }

}
