package io.arcblock.forge.graphql

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
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
    .url(url)

  /**
   * query account state
   */
  fun getAccountState(address: String): GraphQLResponseEntity<ResponseGetAccountState> {
    return gqlTemp.query(queryBuilder.request(ResponseGetAccountState::class.java)
      .arguments(Arguments("getAccountState", Argument("address", address)))
      .build(), ResponseGetAccountState::class.java)
  }

  /**
   * query asset state
   */
  fun getAssetState(address: String): GraphQLResponseEntity<ResponseGetAssetState> {
    return gqlTemp.query(queryBuilder.request(ResponseGetAssetState::class.java)
      .arguments(Arguments("getAssetState", Argument("address", address)))
      .build(), ResponseGetAssetState::class.java)
  }

  /**
   * get block info at height
   */
  fun getBlock(height: Long): GraphQLResponseEntity<ResponseGetBlock> {
    return gqlTemp.query(queryBuilder.request(ResponseGetBlock::class.java)
      .arguments(Arguments("getBlock", Argument("height", height.toString()))).build()
      , ResponseGetBlock::class.java)
  }

  /**
   * get blocks info from one height to another height
   */
  fun getBlocks(heightFilter: RangeFilter): GraphQLResponseEntity<ResponseGetBlocks> {
    return gqlTemp.query(queryBuilder.request(ResponseGetBlocks::class.java)
      .arguments(Arguments("getBlocks", Argument("heightFilter", heightFilter))).build()
      , ResponseGetBlocks::class.java)
  }

  /**
   * get chain info
   */
  fun getChainInfo(): GraphQLResponseEntity<ResponseGetChainInfo> =
    gqlTemp.query(queryBuilder.request(ResponseGetChainInfo::class.java).build(), ResponseGetChainInfo::class.java)

  /**
   * get chain and node config
   */
  fun getConfig(): GraphQLResponseEntity<ResponseGetConfig> =
    gqlTemp.query(queryBuilder.request(ResponseGetConfig::class.java).build(), ResponseGetConfig::class.java)

  /**
   * get delegation info
   * @param address deletation address, DIDGenerator.INSTANCE.genDelegateAddress(sender,receiver);
   */
  @JvmOverloads
  fun getDelegationState(address: String, height: Long?= null): GraphQLResponseEntity<ResponseGetDelegateState> {
    val args = Arguments("getDelegateState", Argument("address", address))
    height?.apply {args.arguments.toMutableList().add(Argument("height", height)) }
    return gqlTemp.query(queryBuilder.request(ResponseGetDelegateState::class.java)
      .arguments(args)
      .build(), ResponseGetDelegateState::class.java)

  }


  /**
   * get forge state include: token info and protocol info
   */
  fun getForgeState(): GraphQLResponseEntity<ResponseGetForgeState> =
    gqlTemp.query(queryBuilder.request(ResponseGetForgeState::class.java)
      //.arguments(Arguments("getForgeState", Argument("height", height)))
      .build(), ResponseGetForgeState::class.java)

  /**
   * get statistics info
   */
  fun getForgeStats(): GraphQLResponseEntity<GetForgeStats> =
    gqlTemp.query(queryBuilder.request(GetForgeStats::class.java)
      .build(), GetForgeStats::class.java)

  /**
   * get statistics info by day
   */
  fun getForgeStatsByDay(startDate: String, endDate: String): GraphQLResponseEntity<GetForgeStatsByDay> =
    gqlTemp.query(queryBuilder.request(GetForgeStatsByDay::class.java)
      .arguments(Arguments("getForgeStatsByDay", Argument("startDate", startDate), Argument("endDate", endDate)))
      .build(), GetForgeStatsByDay::class.java)

  /**
   * check node health info
   */
  fun getHealthStatus(): GraphQLResponseEntity<ResponseGetHealthStatus> =
    gqlTemp.query(queryBuilder.request(ResponseGetHealthStatus::class.java)
      .build(), ResponseGetHealthStatus::class.java)

  /**
   * get chain net info, number of peers
   */
  fun getNetInfo(): GraphQLResponseEntity<ResponseGetNetInfo> =
    gqlTemp.query(queryBuilder.request(ResponseGetNetInfo::class.java)
      .build(), ResponseGetNetInfo::class.java)

  /**
   * get node info
   */
  fun getNodeInfo(): GraphQLResponseEntity<ResponseGetNodeInfo> =
    gqlTemp.query(queryBuilder.request(ResponseGetNodeInfo::class.java)
      .build(), ResponseGetNodeInfo::class.java)

  /**
   * get protocal state
   */
  fun getProtocolState(address: String): GraphQLResponseEntity<ResponseGetProtocolState> =
    gqlTemp.query(queryBuilder.request(ResponseGetProtocolState::class.java)
      .arguments(Arguments("getProtocolState", Argument("address", address)))
      .build(), ResponseGetProtocolState::class.java)

  /**
   * get all protocols have deployed
   */
  fun getProtocols(): GraphQLResponseEntity<ResponseGetProtocols> =
    gqlTemp.query(queryBuilder.request(ResponseGetProtocols::class.java)
      .build(), ResponseGetProtocols::class.java)


  fun getSimulatorStatus(): GraphQLResponseEntity<ResponseGetSimulatorStatus> =
    gqlTemp.query(queryBuilder.request(ResponseGetSimulatorStatus::class.java)
      .build(), ResponseGetSimulatorStatus::class.java)

  /**
   * get account stake info
   */
  fun getStakeState(address: String): GraphQLResponseEntity<ResponseGetStakeState> =
    gqlTemp.query(queryBuilder.request(ResponseGetStakeState::class.java)
      .arguments(Arguments("getStakeState", Argument("address", address)))
      .build(), ResponseGetStakeState::class.java)

  /**
   * get a swap state after setup a swap
   * @param address swap address , DIDGenerator.INSTANCE.toSwapAddress(hash)
   */
  fun getSwapState(address: String): GraphQLResponseEntity<ResponseGetSwapState> =
    gqlTemp.query(queryBuilder.request(ResponseGetSwapState::class.java)
      .arguments(Arguments("getSwapState", Argument("address", address)))
      .build(), ResponseGetSwapState::class.java)

  /**
   * get a transaction info
   */
  fun getTx(hash: String): GraphQLResponseEntity<ResponseGetTx> =
    gqlTemp.query(queryBuilder.request(ResponseGetTx::class.java)
      .arguments(Arguments("getTx", Argument("hash", hash)))
      .build(), ResponseGetTx::class.java)

  /**
   * get unconfirmed transactions
   */
  @JvmOverloads
  fun getUnconfirmedTxs(paging: PageInput?= null): GraphQLResponseEntity<ResponseGetUnconfirmedTxs>{
    val args = Arguments("getUnconfirmedTxs")
    paging?.apply {args.arguments.toMutableList().add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseGetUnconfirmedTxs::class.java)
      .arguments(args)
      .build(), ResponseGetUnconfirmedTxs::class.java)
  }

  /**
   * get validators
   */
  fun getValidatorsInfo(): GraphQLResponseEntity<ResponseGetValidatorsInfo> =
    gqlTemp.query(queryBuilder.request(ResponseGetValidatorsInfo::class.java)
      .build(), ResponseGetValidatorsInfo::class.java)

  /**
   * get asset related transactions
   * @param address asset address
   */
  @JvmOverloads
  fun listAssetTransactions(address: String, paging: PageInput? = null): GraphQLResponseEntity<ResponseListAssetTransactions> {
    val args = Arguments("listAssetTransactions", Argument("address", address))
    paging?.apply {args.arguments.toMutableList().add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseListAssetTransactions::class.java)
      .arguments(args)
      .build(), ResponseListAssetTransactions::class.java)
  }

  /**
   * list assets
   */
  @JvmOverloads
  fun listAssets(ownerAddress: String, paging: PageInput? = null): GraphQLResponseEntity<ResponseListAssets> {
    val args = Arguments("listAssets", Argument("ownerAddress", ownerAddress))
    paging?.apply {args.arguments.toMutableList().add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseListAssets::class.java)
      .arguments(args)
      .build(), ResponseListAssets::class.java)
  }

  /**
   * list blocks with many filter
   */
  @JvmOverloads
  fun listBlocks(heightFilter: RangeFilter, numInvalidTxsFilter: RangeFilter? = null, numTxsFilter: RangeFilter? = null, proposer: String? = null,
                 paging: PageInput? = null, timeFilter: TimeFilter? = null):
    GraphQLResponseEntity<ResponseListBlocks> {
    val args = Arguments("listBlocks", Argument("heightFilter",heightFilter))
    numInvalidTxsFilter?.apply {args.arguments.toMutableList().add(Argument("numInvalidTxsFilter", numInvalidTxsFilter)) }
    numTxsFilter?.apply {args.arguments.toMutableList().add(Argument("numTxsFilter", numTxsFilter)) }
    proposer?.apply {args.arguments.toMutableList().add(Argument("proposer", proposer)) }
    paging?.apply {args.arguments.toMutableList().add(Argument("paging", paging)) }
    timeFilter?.apply {args.arguments.toMutableList().add(Argument("timeFilter", timeFilter)) }
    return gqlTemp.query(queryBuilder.request(ResponseListBlocks::class.java)
      .arguments(args)
      .build(), ResponseListBlocks::class.java)
  }

  /**
   * list stake
   */
  @JvmOverloads
  fun listStakes(addressFilter: AddressFilter, paging: PageInput? = null): GraphQLResponseEntity<ResponseListStakes> {
    val args = Arguments("listStakes", Argument("addressFilter", addressFilter))
    paging?.apply {args.arguments.toMutableList().add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseListStakes::class.java)
      .arguments(args)
      .build(), ResponseListStakes::class.java)
  }

  /**
   * list swaps
   */
  @JvmOverloads
  fun listSwap(available: Boolean? = null, paging: PageInput? = null, receiver: String? = null,
               sender: String? = null): GraphQLResponseEntity<ResponseListSwap> {
    val args = Arguments("listSwap")
    available?.apply {args.arguments.toMutableList().add(Argument("available", available)) }
    paging?.apply {args.arguments.toMutableList().add(Argument("paging", paging)) }
    receiver?.apply {args.arguments.toMutableList().add(Argument("receiver", receiver)) }
    sender?.apply {args.arguments.toMutableList().add(Argument("sender", sender)) }
    return gqlTemp.query(queryBuilder.request(ResponseListSwap::class.java)
      .arguments()
      .build(), ResponseListSwap::class.java)

  }

  /**
   * list top accounts
   */
  @JvmOverloads
  fun listTopAccounts(paging: PageInput? = null): GraphQLResponseEntity<ResponseListTopAccounts> {
    val args = Arguments("listTopAccounts")
    paging?.apply {args.arguments.toMutableList().add(Argument("paging", paging)) }
    return gqlTemp.query(queryBuilder.request(ResponseListTopAccounts::class.java)
      .arguments()
      .build(), ResponseListTopAccounts::class.java)
  }

  /**
   * list transactions with many filter
   */
  @JvmOverloads
  fun listTransactions(addressFilter : AddressFilter? = null, paging: PageInput? = null, timeFilter: TimeFilter? = null,
                       typeFilter: TypeFilter? = null, validityFilter: ValidityFilter? = null):
    GraphQLResponseEntity<ResponseListTransactions> {
    val args = Arguments("listTransactions")
    addressFilter?.apply { args.arguments.toMutableList().add(Argument("addressFilter", addressFilter)) }
    paging?.apply { args.arguments.toMutableList().add(Argument("paging", paging)) }
    timeFilter?.apply { args.arguments.toMutableList().add(Argument("timeFilter", timeFilter)) }
    typeFilter?.apply { args.arguments.toMutableList().add(Argument("typeFilter", typeFilter)) }
    validityFilter?.apply { args.arguments.toMutableList().add(Argument("validityFilter", validityFilter)) }
    return gqlTemp.query(queryBuilder.request(ResponseListTransactions::class.java)
      .arguments(args)
      .build(), ResponseListTransactions::class.java)
  }

}



class RangeFilter(val from: Long, val to: Long){

  override fun toString(): String {
    val ret = StringBuilder("{")
    from?.let { ret.append("from:\"$from\",") }
    to?.let { ret.append("to:\"$to\",") }
    return ret.append("}").toString()
  }
}

class PageOrder (
  val field: String? = null,
  val type: String? = null
){
  override fun toString(): String {
    val ret = StringBuilder("{")
    field?.let { ret.append("field:\"$field\",") }
    type?.let { ret.append("type: $type") }
    return ret.append("}").toString()
  }
}



class PageInput(
  val cursor: String? = null,
  val order: PageOrder? = null,
  val size: Int? = null
){
  override fun toString(): String {
    val ret = StringBuilder("{")
    cursor?.let { ret.append("curosr:\"$cursor\",") }
    order?.let { ret.append("order: $order") }
    size?.let { ret.append("size: $size") }
    return ret.append("}").toString()

  }
}


data class TimeFilter(val endDateTime: String? = null, val startDateTime: String? = null) {
  override fun toString(): String {
    val ret = StringBuilder("{")
    endDateTime?.let { ret.append("endDateTime:\"$endDateTime\",") }
    startDateTime?.let { ret.append("startDateTime:\"$startDateTime\",") }
    return ret.append("}").toString()
  }
}

class TypeFilter (val types: List<String>? = null){
  override fun toString(): String {
    val ret = StringBuilder("{ types: [")
    types?.forEach {
      ret.append("\"it\",")
    }
    return ret.append("]}").toString()
  }
}

class AddressFilter (
  val direction: Direction? = null,
  val receiver: String? = null,
  val sender: String? = null
){

  override fun toString(): String {
    val ret = StringBuilder("{")
    receiver?.let { ret.append("receiver:\"$receiver\",") }
    sender?.let { ret.append("sender: $sender") }
    direction?.let { ret.append("direction: ${direction.name}") }
    return ret.append("}").toString()
  }
}

class ValidityFilter (
  val validity: Validity? = null
){
  override fun toString(): String {
    val ret = StringBuilder("{")
    validity?.let { ret.append("validity:${validity.name},") }
    return ret.append("}").toString()

  }
}





class MF : ObjectMapperFactory {
  override fun newSerializerMapper(): ObjectMapper {
    val mapper = ObjectMapper()
    mapper.registerModule(JavaTimeModule())
    mapper.registerModule(KotlinModule())
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    mapper.disable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID)
    mapper.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
    return mapper
  }

  override fun newDeserializerMapper(): ObjectMapper {
    val mapper = ObjectMapper()
    mapper.writerWithDefaultPrettyPrinter()
    mapper.registerModule(JavaTimeModule())
    mapper.registerModule(KotlinModule())
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

