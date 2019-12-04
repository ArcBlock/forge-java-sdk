package io.arcblock.forge.graphql

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import io.aexp.nodes.graphql.*

/**
 * Author       : shan@arcblock.io
 * Time         : 2019-12-02
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/

class GraphQLClient(val url: String) {
  private val gqlTemp = GraphQLTemplate(MF())
  private var queryBuilder: GraphQLRequestEntity.RequestBuilder = GraphQLRequestEntity.Builder()
    .url("http://localhost:8212/api")


  fun getAccountState(address: String): GraphQLResponseEntity<ResponseGetAccountState> {
    return gqlTemp.query(queryBuilder.request(ResponseGetAccountState::class.java)
      .arguments(Arguments("getAccountState", Argument("address", address)))
      .build(), ResponseGetAccountState::class.java)
  }

  fun getAssetState(address: String): GraphQLResponseEntity<ResponseGetAssetState> {
    return gqlTemp.query(queryBuilder.request(ResponseGetAssetState::class.java)
      .arguments(Arguments("getAssetState", Argument("address", address)))
      .build(), ResponseGetAssetState::class.java)
  }

  fun getBlock(height: Long): GraphQLResponseEntity<ResponseGetBlock> {
    return gqlTemp.query(queryBuilder.request(ResponseGetBlock::class.java)
      .arguments(Arguments("getBlock", Argument("height", height.toString()))).build()
      , ResponseGetBlock::class.java)
  }

  fun getBlocks(heightFilter: RangeFilter): GraphQLResponseEntity<ResponseGetBlocks> {
    return gqlTemp.query(queryBuilder.request(ResponseGetBlocks::class.java)
      .arguments(Arguments("getBlocks", Argument("heightFilter", heightFilter))).build()
      , ResponseGetBlocks::class.java)
  }

  fun getChainInfo(): GraphQLResponseEntity<ResponseGetChainInfo> =
    gqlTemp.query(queryBuilder.request(ResponseGetChainInfo::class.java).build(), ResponseGetChainInfo::class.java)

  fun getConfig(): GraphQLResponseEntity<ResponseGetConfig> =
    gqlTemp.query(queryBuilder.request(ResponseGetConfig::class.java).build(), ResponseGetConfig::class.java)

  fun getDelegationState(address: String, height: Long?= null): GraphQLResponseEntity<ResponseGetDelegateState> {
    val args = Arguments("getDelegateState", Argument("address", address))
    height?.apply { args.arguments.add(Argument("height", height)) }
    return gqlTemp.query(queryBuilder.request(ResponseGetDelegateState::class.java)
      .arguments(args)
      .build(), ResponseGetDelegateState::class.java)

  }

  //  fun getForgeState(): GraphQLResponseEntity<ResponseGetForgeState> =
//    gqlTemp.query(queryBuilder.request())
  fun getForgeState(): GraphQLResponseEntity<ResponseGetForgeState> =
    gqlTemp.query(queryBuilder.request(ResponseGetForgeState::class.java)
      //.arguments(Arguments("getForgeState", Argument("height", height)))
      .build(), ResponseGetForgeState::class.java)

  fun getForgeStats(): GraphQLResponseEntity<GetForgeStats> =
    gqlTemp.query(queryBuilder.request(GetForgeStats::class.java)
      .build(), GetForgeStats::class.java)

  fun getForgeStatsByDay(startDate: String, endDate: String): GraphQLResponseEntity<GetForgeStatsByDay> =
    gqlTemp.query(queryBuilder.request(GetForgeStatsByDay::class.java)
      .arguments(Arguments("getForgeStatsByDay", Argument("startDate", startDate), Argument("endDate", endDate)))
      .build(), GetForgeStatsByDay::class.java)

  fun getHealthStatus(): GraphQLResponseEntity<ResponseGetHealthStatus> =
    gqlTemp.query(queryBuilder.request(ResponseGetHealthStatus::class.java)
      .build(), ResponseGetHealthStatus::class.java)

  fun getNetInfo(): GraphQLResponseEntity<ResponseGetNetInfo> =
    gqlTemp.query(queryBuilder.request(ResponseGetNetInfo::class.java)
      .build(), ResponseGetNetInfo::class.java)

  fun getNodeInfo(): GraphQLResponseEntity<ResponseGetNodeInfo> =
    gqlTemp.query(queryBuilder.request(ResponseGetNodeInfo::class.java)
      .build(), ResponseGetNodeInfo::class.java)

  fun getProtocolState(address: String, height: Long?= null): GraphQLResponseEntity<ResponseGetProtocolState> =
    gqlTemp.query(queryBuilder.request(ResponseGetProtocolState::class.java)
      .arguments(Arguments("getProtocolState", Argument("address", address)))
      .build(), ResponseGetProtocolState::class.java)

  fun getProtocols(): GraphQLResponseEntity<ResponseGetProtocols> =
    gqlTemp.query(queryBuilder.request(ResponseGetProtocols::class.java)
      .build(), ResponseGetProtocols::class.java)

  fun getSimulatorStatus(): GraphQLResponseEntity<ResponseGetSimulatorStatus> =
    gqlTemp.query(queryBuilder.request(ResponseGetSimulatorStatus::class.java)
      .build(), ResponseGetSimulatorStatus::class.java)

  fun getStakeState(address: String): GraphQLResponseEntity<ResponseGetStakeState> =
    gqlTemp.query(queryBuilder.request(ResponseGetStakeState::class.java)
      .arguments(Arguments("getStakeState", Argument("address", address)))
      .build(), ResponseGetStakeState::class.java)

  fun getSwapState(address: String): GraphQLResponseEntity<ResponseGetSwapState> =
    gqlTemp.query(queryBuilder.request(ResponseGetSwapState::class.java)
      .arguments(Arguments("getSwapState", Argument("address", address)))
      .build(), ResponseGetSwapState::class.java)

  fun getTx(hash: String): GraphQLResponseEntity<ResponseGetTx> =
    gqlTemp.query(queryBuilder.request(ResponseGetTx::class.java)
      .arguments(Arguments("getTx", Argument("hash", hash)))
      .build(), ResponseGetTx::class.java)

  fun getUnconfirmedTxs(paging: PageInput?= null): GraphQLResponseEntity<ResponseGetUnconfirmedTxs>{
    val args = Arguments("getUnconfirmedTxs")
    paging?.apply { args.arguments.add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseGetUnconfirmedTxs::class.java)
      .arguments(args)
      .build(), ResponseGetUnconfirmedTxs::class.java)
  }
    

  fun getValidatorsInfo(): GraphQLResponseEntity<ResponseGetValidatorsInfo> =
    gqlTemp.query(queryBuilder.request(ResponseGetValidatorsInfo::class.java)
      .build(), ResponseGetValidatorsInfo::class.java)

  fun listAssetTransactions(address: String, paging: PageInput? = null): GraphQLResponseEntity<ResponseListAssetTransactions> {
    val args = Arguments("listAssetTransactions", Argument("address", address))
    paging?.apply { args.arguments.add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseListAssetTransactions::class.java)
      .arguments(args)
      .build(), ResponseListAssetTransactions::class.java)
  }

  @JvmOverloads
  fun listAssets(ownerAddress: String, paging: PageInput? = null): GraphQLResponseEntity<ResponseListAssets> {
    val args = Arguments("listAssets", Argument("ownerAddress", ownerAddress))
    paging?.apply { args.arguments.add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseListAssets::class.java)
      .arguments(args)
      .build(), ResponseListAssets::class.java)
  }

  @JvmOverloads
  fun listBlocks(heightFilter: RangeFilter, numInvalidTxsFilter: RangeFilter? = null, numTxsFilter: RangeFilter? = null, proposer: String? = null,
                 paging: PageInput? = null, timeFilter: TimeFilter? = null):
    GraphQLResponseEntity<ResponseListBlocks> {
    val args = Arguments("listBlocks", Argument("heightFilter", heightFilter))
    numInvalidTxsFilter?.apply { args.arguments.add(Argument("numInvalidTxsFilter", numInvalidTxsFilter)) }
    numTxsFilter?.apply { args.arguments.add(Argument("numTxsFilter", numTxsFilter)) }
    proposer?.apply { args.arguments.add(Argument("proposer", proposer)) }
    paging?.apply { args.arguments.add(Argument("paging", paging)) }
    timeFilter?.apply { args.arguments.add(Argument("timeFilter", timeFilter)) }
    return gqlTemp.query(queryBuilder.request(ResponseListBlocks::class.java)
      .arguments(args)
      .build().let {
        println("query:${it.request}")
        it
      }, ResponseListBlocks::class.java)
  }

  fun listStakes(addressFilter: AddressFilter, paging: PageInput? = null): GraphQLResponseEntity<ResponseListStakes> {
    val args = Arguments("listStakes", Argument("addressFilter", addressFilter))
    paging?.apply { args.arguments.add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseListStakes::class.java)
      .arguments(args)
      .build(), ResponseListStakes::class.java)
  }

  fun listSwap(available: Boolean? = null, paging: PageInput? = null, receiver: String? = null,
               sender: String? = null): GraphQLResponseEntity<ResponseListSwap> {
    val args = Arguments("listSwap")
    available?.apply { args.arguments.add(Argument("available", available)) }
    paging?.apply { args.arguments.add(Argument("paging", paging)) }
    receiver?.apply { args.arguments.add(Argument("receiver", receiver)) }
    sender?.apply { args.arguments.add(Argument("sender", sender)) }
    return gqlTemp.query(queryBuilder.request(ResponseListSwap::class.java)
      .arguments()
      .build(), ResponseListSwap::class.java)

  }

  fun listTopAccounts(paging: PageInput? = null): GraphQLResponseEntity<ResponseListTopAccounts> {
    val args = Arguments("listTopAccounts")
    paging?.apply { args.arguments.add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseListTopAccounts::class.java)
      .arguments()
      .build(), ResponseListTopAccounts::class.java)
  }


  fun listTransactions(addressFilter: AddressFilter? = null, paging: PageInput? = null, timeFilter: TimeFilter? = null,
                       typeFilter: TypeFilter? = null, validityFilter: ValidityFilter? = null):
    GraphQLResponseEntity<ResponseListTransactions> {
    val args = Arguments("listTransactions")
    addressFilter?.apply { args.arguments.add(Argument("addressFilter", addressFilter)) }
    paging?.apply { args.arguments.add(Argument("paging", paging)) }
    timeFilter?.apply { args.arguments.add(Argument("timeFilter", timeFilter)) }
    typeFilter?.apply { args.arguments.add(Argument("typeFilter", typeFilter)) }
    validityFilter?.apply { args.arguments.add(Argument("validityFilter", validityFilter)) }
    return gqlTemp.query(queryBuilder.request(ResponseListTransactions::class.java)
      .arguments(args)
      .build(), ResponseListTransactions::class.java)
  }

}


class MF : ObjectMapperFactory {
  override fun newSerializerMapper(): ObjectMapper {
    val mapper = ObjectMapper()
    mapper.registerModule(JavaTimeModule())
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    mapper.disable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID)
    mapper.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
    return mapper
  }

  override fun newDeserializerMapper(): ObjectMapper {
    val mapper = ObjectMapper()
    mapper.registerModule(JavaTimeModule())
    mapper.registerModule(JsonModule())
    mapper.disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)
    return mapper
  }
}

class JsonModule : SimpleModule() {
  init {
    addDeserializer(Transaction::class.java, CustomDeserialize())

  }
}

class CustomDeserialize : StdScalarDeserializer<Transaction>(Transaction::class.java) {
  override fun deserialize(jp: JsonParser?, ctxt: DeserializationContext?): Transaction {
    val node = jp!!.codec.readTree<JsonNode>(jp)
    val chainId = node.get("chainId")
      .asText()
    val delegator = node.get("delegator")
      .asText()
    val from = node.get("from")
      .asText()
    val itxJson = node.get("itxJson")
      .toString()
    println("itxJson node:" + node.get("itxJson").toString())
    val nonce = node.get("nonce")
      .asText()
    val pk = node.get("pk")
      .asText()
    val signature = node.get("signature")
      .asText()
    return Transaction(chainId, delegator, from, itxJson, nonce, pk, signature)
  }
}

//class NetInfoDeserialize : StdScalarDeserializer<Int>(Int::class.java) {
//  override fun deserialize(jp: JsonParser?, ctxt: DeserializationContext?): Int {
//    val node = jp!!.codec.readTree<JsonNode>(jp)
//    return node.asInt(0)
//  }
//}

