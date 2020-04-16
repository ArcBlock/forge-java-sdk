package io.arcblock.forge.graphql

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.arcblock.forge.TransactionFactory
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.extension.signTx
import org.junit.Ignore
import org.junit.Test


/**
 * Author       : shan@arcblock.io
 * Time         : 2019-12-04
 * Edited By    :
 * Edited Time  :
 * Description  :
 */
class GraphQLClientTest {
  val gql = GraphQLClient("https://zinc.network.arcblockio.cn/api")
  @Test
  fun getAccountState() {
    val response = gql.getAccountState("z1iwLst1QLP9t3TRZxaiytk4T4CA3Wzgdde")
    println("response:$response")
    assert(response.errors.isNullOrEmpty())
  }

  @Test
  fun getAssetState() {
    val response = gql.getAssetState("zjdtB2HKERWu8zGQPobwZvHEYHXsubuWKk3E")
    println("response:$response")
    assert(response.errors.isNullOrEmpty())
  }

  @Test
  fun getBlock() {
    val response = gql.getBlock(height = 123L)
    println("response:$response")
    assert(response.errors.isNullOrEmpty())
  }

  @Test
  fun getBlocks() {
//    val response = gql.getBlocks(RangeFilter("1","4"))
//    println("response:$response")
//    assert(response.errors.isNullOrEmpty())
  }

  @Test
  fun getChainInfo() {
    val response = gql.getChainInfo()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun getConfig() {
    val response = gql.getConfig()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun getDelegationState() {
    val response = gql.getDelegationState("z2bN8ZZpEmPRsN4tt2thxzYiqhCL7UpkH7MuK")
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun getForgeState() {
    val response = gql.getForgeState()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun getForgeStats() {
    val response = gql.getForgeStats()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())
  }

  @Test
  fun getForgeStatsByDay() {
    val response = gql.getForgeStatsByDay("2019-10-01","2019-10-27")
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun getHealthStatus() {
    val response = gql.getHealthStatus()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun getNetInfo() {
    val response = gql.getNetInfo()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())
  }

  @Test
  fun getNodeInfo() {
    val response = gql.getNodeInfo()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

//  @Test
//  fun getProtocolState() {
//    val response = gql.getProtocolState(address = "z2E455MbtPs136zBnDpANSBDPr83mQrFyWxLk")
//    println("response:$response")
////    assert(response.errors.isNullOrEmpty())
//
//  }

//  @Test
//  fun getProtocols() {
//    val response = gql.getProtocols()
//    println("response:$response")
//    assert(response.errors.isNullOrEmpty())
//
//  }

  @Test
  fun getSimulatorStatus() {
    val response = gql.getSimulatorStatus()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun getStakeState() {
    //val response = gql.getStakeState("")
  }

  @Test
  fun getSwapState() {
//    val response = gql.getSwapState("")
//    println("response:$response")
//    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun getTx() {
    val response = gql.getTx("A88975EF7B03A75512380C94E5A0706670835D2F6B784145E912D988C3626B01")
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun getUnconfirmedTxs() {
    val response = gql.getUnconfirmedTxs()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())
  }

  @Test
  fun getValidatorsInfo() {
    val response = gql.getValidatorsInfo()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun listAssetTransactions() {
    val response = gql.listAssetTransactions("zjdkr12yakjBD6qbyUZZTMvbKqaU7KnByfEn")
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun listAssets() {
    val response = gql.listAssets(ownerAddress = "z1iQgZWLMZRE8nTNVr82My53xETtaxEnKJE")
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun listBlocks() {
    val response = gql.listBlocks(RangeFilter(1,2))
    println("response:$response")
    assert(response.errors.isNullOrEmpty())
  }

  @Test
  fun listStakes() {

  }

  @Test
  fun listSwap() {
    val response = gql.listSwap()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun listTopAccounts() {
    val response = gql.listTopAccounts()
    println("response:$response")
    assert(response.errors.isNullOrEmpty())
  }

  @Test
  fun listTransactions() {
    val response = gql.listTransactions(AddressFilter(sender = "z1TpSH9n6JfJto3hx1z7wJQ8zSMZvU9xFWa"),typeFilter = TypeFilter(listOf("transfer","poke")))
    println("response:$response")
    assert(response.errors.isNullOrEmpty())

  }

  @Test
  fun testCustomQuery(){
    val x = gql.customQuery("{\n" +
      "  getBlocks(heightFilter: {from: \"1\", to: \"2\"}) {\n" +
      "    code\n" +
      "    blocks {\n" +
      "      appHash\n" +
      "      consensusHash\n" +
      "      numTxs\n" +
      "    }\n" +
      "  }\n" +
      "}")
    println("response:${x.response.toPrettyString()}")
  }

  @Test
  fun testSendTx(){
    val wallet = DIDGenerator.randomWallet()
    val tx = TransactionFactory.unsignPoke("zinc-2019-05-17",wallet.address, wallet.pk).signTx(wallet.sk)
    val rsp = gql.sendTx(tx)
    println("rsp:$rsp")
    Thread.sleep(5000)
    val txHash = rsp.response.hash ?:""
    val txDetail = gql.getTx(txHash)
    val pretty = ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writerWithDefaultPrettyPrinter().writeValueAsString(txDetail.response.info)
    println("tx:\n ${pretty}")
  }
}
