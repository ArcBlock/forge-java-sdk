package io.arcblock.forge

import com.google.common.util.concurrent.ListenableFuture
import com.google.protobuf.Any
import com.google.protobuf.ByteString
import com.jcabi.aspects.Loggable
import forge_abi.*
import forge_abi.Enum
import forge_abi.StatsRpcGrpc.StatsRpcStub
import io.arcblock.forge.did.DIDGenerator
import io.arcblock.forge.did.WalletInfo
import io.arcblock.forge.extension.*
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.stub.StreamObserver
import org.slf4j.LoggerFactory
import java.math.BigInteger
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * ForgeSDK is java/kotlin implement of Forge.
 * It help you connect with Forge core and communicate with chain
 * query chain info,  transactions, and assets.
 * Send transaction such as transfer, exchange and create asset.
 * manage wallets on this node: create wallet, load wallet, delete wallet
 *
 */
class ForgeSDK private constructor() {
  val pokeAddress = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"
  val logger = LoggerFactory.getLogger(ForgeSDK::class.java)
  private lateinit var channel: ManagedChannel

  private lateinit var chainRpcBlockingStub: ChainRpcGrpc.ChainRpcBlockingStub

  private lateinit var chainRpcStub: ChainRpcGrpc.ChainRpcStub

  private lateinit var chainRpcFutureStub: ChainRpcGrpc.ChainRpcFutureStub

  private lateinit var statsRpcBlockingStub: StatsRpcGrpc.StatsRpcBlockingStub

  private lateinit var statsRpcStub: StatsRpcStub

  private lateinit var statsRpcFutureStub: StatsRpcGrpc.StatsRpcFutureStub

  private lateinit var eventRpcBlockingStub: EventRpcGrpc.EventRpcBlockingStub

  private lateinit var eventRpcStub: EventRpcGrpc.EventRpcStub

  private lateinit var eventRpcFutureStub: EventRpcGrpc.EventRpcFutureStub

  private lateinit var stateRpcBlockingStub: StateRpcGrpc.StateRpcBlockingStub

  private lateinit var stateRpcStub: StateRpcGrpc.StateRpcStub

  private lateinit var stateRpcFutureStub: StateRpcGrpc.StateRpcFutureStub

  private lateinit var walletRpcBlockingStub: WalletRpcGrpc.WalletRpcBlockingStub

  private lateinit var walletRpcStub: WalletRpcGrpc.WalletRpcStub

  private lateinit var walletRpcFutureStub: WalletRpcGrpc.WalletRpcFutureStub

  private lateinit var fileRpcBlockingStub: FileRpcGrpc.FileRpcBlockingStub

  private lateinit var fileRpcStub: FileRpcGrpc.FileRpcStub

  private lateinit var fileRpcFutureStub: FileRpcGrpc.FileRpcFutureStub


  val chainInfo = lazy {
    chainRpcBlockingStub.getChainInfo(Rpc.RequestGetChainInfo.getDefaultInstance())
      .info
  }


//  /**
//   * gRpc call to build a complete transaction, including sender's pk and sender's signature. <br></br>
//   *
//   *
//   *  To sign a transaction successfully, either a wallet with private key or a token should
//   * be provided. However, this practice is not recommended for safety concern. Users should keep
//   * their own private keys and sign transactions locally.  <br></br>
//   *
//   *
//   * Example:
//   * ```
//   * forgeSdk.createTx(Rpc.RequestCreateTx.newBuilder()
//   * .setItx(Any.newBuilder().build())
//   * .setFrom("z")
//   * .setNonce(123L)
//   * .setWallet(wallet)//or set token
//   * .build())
//   *
//   * itx:Inner transaction that should be included in this transaction
//   * from: address of user responsible for sending this transactions
//   * wallet: user wallet
//   * token: token provided by forge for using wallets stored on forge
//   * nonce: optional, number of tx this account has sent
//   * ```
//   *
//   *
//   *
//   * @param request transaction request
//   * @return code: ok or reason, tx: transaction created by forge core
//   *
//   *
//   *
//   */
//  fun createTx(request: Rpc.RequestCreateTx): Rpc.ResponseCreateTx {
//    return chainRpcBlockingStub.createTx(request)
//  }
//
//  /**
//   * create transaction async interface, please read [createTx]
//   */
//  fun asyncCreateTx(request: Rpc.RequestCreateTx): ListenableFuture<Rpc.ResponseCreateTx> {
//    return chainRpcFutureStub.createTx(request)
//  }
//
//  /**
//   *
//   * gRPC call to get multi-signature of a transaction. When executing this transactions, Forge <br>
//   * will insert the address to signatures field as Multisig.sign, then create a signature of the <br>
//   * entire transaction <br>
//   *
//   *
//   * Example: <br></br>
//   * ```
//   *     val tx = createExchange()
//   *     val response = forgeSDK.multisig(Rpc.RequestMultisig.newBuilder()
//   *         .setTx(tx)
//   *         .setWallet(bob)
//   *         .build())
//   * ```
//   * <br></br>
//   *
//   * @param request itx: inner transaction,
//   * @return code: ok or error ,tx: transaction with multi sig
//   *
//   */
//
//
//
//  /**
//   * async gRPC call to get multi-signature of a transaction. When executing this transactions, Forge
//   * will insert the address to signatures field as Multisig.sign, then create a signature of the
//   * entire transaction ,please read [multisig]
//   *
//   */
//  fun asyncMultisig(request: Rpc.RequestMultisig): ListenableFuture<Rpc.ResponseMultisig> {
//    return chainRpcFutureStub.multisig(request)
//  }
//
  /**
   * gRPC call to send the included transaction, more information about forge transaction, please read [here](https://docs.arcblock.io/forge/latest/txs/)
   *
   * Example:
   *
   * ```
   *     val transfer = Transfer.TransferTx.newBuilder()
   *       .setTo(bob.address)
   *       .setValue(Type.BigUint.newBuilder().setValue(ByteString.copyFrom(BigInteger.ONE.toByteArray())).build())
   *       .build()
   *     val tx = TransactionFactory.createTransaction(chainInfo.network,alice.address,alice.pk.toByteArray(),transfer.toByteString(),TypeUrls.TRANSFER)
   *       .signTx(alice.sk.toByteArray())
   *     val response =  forgeSDK.sendTx(tx)
   * ```
   *
   * @param request request structure
   * @return code: ok or error. hash: transaction's hash
   */
  @Loggable
  fun sendTx(request: Rpc.RequestSendTx): Rpc.ResponseSendTx {
    logger.info("sendTx: ${request.tx.toByteArray().encodeB64Url()}")
    logger.debug("tx:\n${request.tx}")
    return chainRpcBlockingStub.sendTx(request)
  }

  fun sendTx(tx: Type.Transaction): Rpc.ResponseSendTx {
    return sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).build())
  }

  fun sendTx(wallet: WalletInfo,itx: ByteString, typeUrl: String): Rpc.ResponseSendTx {
    return sendTx(TransactionFactory.createTransaction(chainInfo.value.network,wallet.address,wallet.pk,itx,typeUrl).signTx(wallet.sk))
  }


  /**
   * async  gRPC call to send the included transaction, please read [sendTx]
   */
  fun asyncSendTx(tx: Type.Transaction): ListenableFuture<Rpc.ResponseSendTx> {
    return chainRpcFutureStub.sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).build())
  }

  /**
   * Declare your account on forge
   */
  fun declare(moniker: String, wallet: WalletInfo): Rpc.ResponseSendTx {
    return sendTx(TransactionFactory.declare(chainInfo.value.network, wallet, moniker).signTx(wallet.sk))
  }

  /**
   * Util to help developer to poke a account
   */
  fun poke(wallet: Type.WalletInfo): Rpc.ResponseSendTx = poke(WalletInfo(wallet))
  fun checkin(wallet: Type.WalletInfo): Rpc.ResponseSendTx = poke(WalletInfo(wallet))
  fun checkin(wallet: WalletInfo): Rpc.ResponseSendTx = poke(wallet)

  /**
   * Util to help developer to poke a account
   */
  fun poke(wallet: WalletInfo): Rpc.ResponseSendTx {
    val tx = TransactionFactory.unsignPoke(chainInfo.value.network, wallet = wallet)
      .signTx(wallet.sk)
    return chainRpcBlockingStub.sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).build())
  }

  fun transfer(from: WalletInfo, to: WalletInfo, assets: List<String>) = transfer(from, to, amount = null, assets = assets, delegatee = null)
  fun transfer(from: WalletInfo, to: WalletInfo, amount: BigInteger) = transfer(from, to, amount = amount, assets = null, delegatee = null)
  fun transfer(from: WalletInfo, to: WalletInfo, amount: BigInteger, assets: List<String>) = transfer(from, to, amount = amount, assets = assets,
    delegatee
    = null)

  /**
   * Util to help developer transfer money from a account to another
   * @param from: sender of transfer transaction
   * @param to: receiver of transfer transaction
   * @param amount: amount of transfer transaction
   * @param assets: assets of transfer transaction, nullable
   * @param delegatee: sender delegatee if have
   */
  fun transfer(from: WalletInfo, to: WalletInfo, amount: BigInteger? = null, assets: List<String>? = null, delegatee: String? = null): Rpc
  .ResponseSendTx {
    val builder = Transfer.TransferTx.newBuilder()
      .setTo(to.address)
    amount?.let { builder.setValue(Type.BigUint.newBuilder().setValue(ByteString.copyFrom(it.toByteArray())).build()) }
    assets?.forEach { builder.addAssets(it) }
    val transfer = builder.build()
    val tx = TransactionFactory.createTransaction(chainInfo.value.network, from.address, from.pk, transfer.toByteString(), TypeUrls.TRANSFER)
      .delegatee(delegatee)
      .signTx(from.sk)
    return sendTx(tx)
  }

  /**
   * Simple create a asset
   */
  fun createAsset(assetTypeUrl: String, assetData: ByteArray, assetMoniker: String, wallet: WalletInfo, delegatee: String? = null, ttl: Int = 0,
                  transferrable: Boolean = true, readOnly: Boolean = false): Result {
    val data = Any.newBuilder()
      .setTypeUrl(assetTypeUrl)
      .setValue(assetData.toByteString())
      .build()
    var itx = CreateAsset.CreateAssetTx.newBuilder()
      .setData(data)
      .setMoniker(assetMoniker)
      .setReadonly(readOnly)
      .setParent("")
      .setTransferrable(transferrable)
      .setTtl(ttl)
      .build()
    val address = DIDGenerator.genAssetDid(itx.toByteArray())
    itx = itx.toBuilder()
      .setAddress(address)
      .build()
    val tx = TransactionFactory.createTransaction(chainInfo.value.network, wallet.address, wallet.pk, itx.toByteString(), TypeUrls.CREATE_ASSET)
      .delegatee(delegatee)
      .signTx(wallet.sk)
    return Result(sendTx(tx), address)
  }

  /**
   * update asset (not readOnly) by address
   */
  fun updateAsset(assetAddress: String, moniker: String, typeUrl: String, assetData: ByteArray, wallet: WalletInfo,
                  delegatee: String? = null): Rpc.ResponseSendTx {
    val itx = UpdateAsset.UpdateAssetTx.newBuilder()
      .setAddress(assetAddress)
      .setMoniker(moniker)
      .setData(Any.newBuilder().setTypeUrl(typeUrl).setValue(assetData.toByteString()).build())
      .build()
    val tx = TransactionFactory.createTransaction(chainInfo.value.network, wallet.address, wallet.pk, itx.toByteString(), TypeUrls.UPDATE_ASSET)
      .delegatee(delegatee)
      .signTx(wallet.sk)
    return sendTx(tx)
  }

  /**
   * consume asset to make it can't be transfer
   */
  fun consumeAsset(assetAddress: String, wallet: WalletInfo, owner: WalletInfo, delegatee: String? = null): Rpc.ResponseSendTx {
    val itx = ConsumeAsset.ConsumeAssetTx.newBuilder()
      .setAddress("")
      .setIssuer(wallet.address)
      .build()
    val tx = TransactionFactory.createTransaction(chainInfo.value.network, wallet.address, wallet.pk, itx.toByteString(), TypeUrls.CONSUME_ASSET)
      .delegatee(delegatee)
      .signTx(wallet.sk)
    return sendTx(tx.multiSig(owner,Any.newBuilder().setTypeUrl(TypeUrls.CONSUME_ASSET_ADDRESS)
      .setValue(ByteString.copyFromUtf8(assetAddress)).build()))
  }

//  /**
//   * create a unSign exchange transaction, you have to sign it by from and multisig by to.
//   */
//  fun createUnsignExchange(from: WalletInfo, to: WalletInfo, fromToken: BigInteger, assetAddress: String,
//                           delegatee: String? = null): Type.Transaction {
//    val exchange = Exchange.ExchangeTx.newBuilder()
//      .setSender(Exchange.ExchangeInfo.newBuilder()
//        .setValue(Type.BigUint.newBuilder()
//          .setValue(fromToken.toByteArray().toByteString())
//          .build())
//        .build())
//      .setReceiver(Exchange.ExchangeInfo.newBuilder()
//        .addAssets(assetAddress)
//        .build())
//      .setTo(to.address)
//      .build()
//    return TransactionFactory.createTransaction(chainInfo.value.network, from.address, from.pk, exchange.toByteString(), TypeUrls.EXCHANGE)
//  }

  /**
   * Simple exchange from A to B, pay fromToken and get Asset
   */
  fun exchange(from: WalletInfo, to: WalletInfo, fromToken: BigInteger, assetAddress: String, delegateeFrom: String? = null,
               delegateeTo: String? = null): Rpc.ResponseSendTx {
    val exchange = Exchange.ExchangeTx.newBuilder()
      .setSender(Exchange.ExchangeInfo.newBuilder()
        .setValue(Type.BigUint.newBuilder()
          .setValue(fromToken.toByteArray().toByteString())
          .build())
        .build())
      .setReceiver(Exchange.ExchangeInfo.newBuilder()
        .addAssets(assetAddress)
        .build())
      .setTo(delegateeTo ?: to.address)
      .build()
    logger.debug("exchange:\n$exchange")
    val tx = TransactionFactory.createTransaction(chainInfo.value.network, from.address, from.pk, exchange.toByteString(), TypeUrls.EXCHANGE)
      .delegatee(delegateeFrom)
      .signTx(from.sk)
    return sendTx(tx.multiSig(to, delegator = delegateeTo))
  }

  /**
   * delegate rules from to
   */
  fun createDelegate(from: WalletInfo, to: WalletInfo, rules: List<String>, typeUrl: String? = null): Rpc.ResponseSendTx {
    return sendTx(
      TransactionFactory.unsignDelegate(from.address, to.address, chainInfo.value.network, from, rules, typeUrl).signTx(from.sk))
  }


  /**
   * setup a swap for atomic swap, it can exchange asset or token with other chain build by forge
   */
  fun setupSwap(from: WalletInfo,receiver: String, amount: BigInteger, blockHeight: Int, hashKey: ByteArray): Rpc.ResponseSendTx{
    return sendTx(TransactionFactory.setup_swap(chainInfo.value.network, from, receiver, blockHeight, hashKey, amount).signTx(from.sk))
  }

  fun setupSwap(from: WalletInfo,receiver: String, assets: List<String>, blockHeight: Int, hashKey: ByteArray): Rpc.ResponseSendTx{
    return sendTx(TransactionFactory.setup_swap(chainInfo.value.network, from, receiver, blockHeight, hashKey, assets).signTx(from.sk))
  }

  fun revokeSwap(wallet: WalletInfo, swapAddress: String): Rpc.ResponseSendTx{
    return sendTx(TransactionFactory.revoke_swap(chainInfo.value.network, wallet, swapAddress).signTx(wallet.sk))
  }

  fun retrieveSwap(wallet: WalletInfo, swapAddress: String, hashKey: ByteArray): Rpc.ResponseSendTx{
    return sendTx(TransactionFactory.retrieve_swap(chainInfo.value.network, wallet, swapAddress, hashKey).signTx(wallet.sk))
  }

  /**
   * Get transaction stream, it will receive transaction once forge commit a transaction <br>
   *
   * Example: <br>
   *
   * ```
   * forgeSDK.getTx(object : StreamObserver<Rpc.ResponseGetTx> {
   *       override fun onCompleted() {
   *       }
   *
   *       override fun onError(t: Throwable?) {
   *       }
   *
   *       override fun onNext(value: Rpc.ResponseGetTx?) {
   *         Assert.assertEquals("get a transaction info", Enum.StatusCode.ok, value?.code)
   *       }
   *     })
   * sendTx()
   * ```
   *
   */
  fun getTx(observer: StreamObserver<Rpc.ResponseGetTx>): StreamObserver<Rpc.RequestGetTx> {
    return chainRpcStub.getTx(observer)
  }

  /**
   * Get block stream, it will receive block information if you request a block height <br>
   *
   * Example: <br>
   * ```
   *    val observer = forgeSDK.getBlock(object : StreamObserver<Rpc.ResponseGetBlock> {
   *      override fun onCompleted() {
   *      }
   *
   *      override fun onError(t: Throwable?) {
   *      }
   *
   *      override fun onNext(value: Rpc.ResponseGetBlock?) {b
   *        Assert.assertEquals("get a block info", Enum.StatusCode.ok, value?.code)
   *        called.set(true)
   *      }
   *    })
   *    observer.onNext(Rpc.RequestGetBlock.newBuilder()
   *      .setHeight(10)
   *      .build())
   * ```
   *
   */

  fun getBlock(observer: StreamObserver<Rpc.ResponseGetBlock>): StreamObserver<Rpc.RequestGetBlock> {
    return chainRpcStub.getBlock(observer)
  }

  /**
   * gRpc call to get information of blocks
   *
   * Parameters
   * height_filter (RangeFilter) -- range filter for blocks
   * empty_excluded (bool) -- whether to include empty blocks or not
   * paging (PageInput) -- optional, paging preference
   *
   * Example: <br>
   *
   * ```
   * forgeSDK.getBlocks(Rpc.RequestGetBlocks.newBuilder()
   *       .setHeightFilter(TraceType.RangeFilter.newBuilder().setFrom(10).setTo(30).build())
   *       .setPaging(TraceType.PageInput.newBuilder().setSize(5))
   *       .setEmptyExcluded(true)
   *       .build())
   * ```
   *
   */
  fun getBlocks(request: Rpc.RequestGetBlocks): Rpc.ResponseGetBlocks {
    return chainRpcBlockingStub.getBlocks(request)
  }

  /**
   * async gRpc call to get information of blocks ,please read [getBlocks]
   *
   */
  fun asyncGetBlocks(request: Rpc.RequestGetBlocks): ListenableFuture<Rpc.ResponseGetBlocks> {
    return chainRpcFutureStub.getBlocks(request)
  }

  /**
   * gRpc call to get currently unconfirmed transactions
   *
   * Param: paging (PageInput) -- optional, paging preference
   *
   * Example:
   * ```
   * forgeSDK.getUnconfirmedTxs(Rpc.RequestGetUnconfirmedTxs.newBuilder().setPaging(page).build())
   * ```
   *
   */
  fun getUnconfirmedTxs(request: Rpc.RequestGetUnconfirmedTxs): Rpc.ResponseGetUnconfirmedTxs {
    return chainRpcBlockingStub.getUnconfirmedTxs(request)
  }

  /**
   * async gRpc call to get currently unconfirmed transactions, please read [getUnconfirmedTxs]
   */
  fun asyncGetUnconfirmedTxs(request: Rpc.RequestGetUnconfirmedTxs): ListenableFuture<Rpc.ResponseGetUnconfirmedTxs> {
    return chainRpcFutureStub.getUnconfirmedTxs(request)
  }

  /**
   * gRPC call to get information about current chain <br>
   *
   * Example:
   * ```
   * forgeSDK.getChainInfo(Rpc.RequestGetChainInfo.getDefaultInstance())
   *
   * ```
   * id: "fc7df9d10a320124e8a1dde021552579faf60f0a"
   * network: "forge"
   * moniker: "forge"
   * consensus_version: "0.32.1"
   * synced: true
   * app_hash: "\321\335\312L \254\274\nz\000\277m\035Z\0221\225\\\372u\363\271\321/\267\367\t\244\373\361o%"
   * block_hash: "\203S\n9lJ&\026G\375\306\356\376\016\342\310=aPp\375\363\032\2714\332\306\006\277\257C|"
   * block_height: 26907
   * block_time {
   *   seconds: 1567671089
   * }
   * address: "zyt483kobYRZcYqNGF3wGH4BYp4MDNsVPwMp"
   * voting_power: 10
   * total_txs: 95
   * version: "0.36.5"
   * supported_txs: "fg:t:create_asset"
   *
   */
  fun getChainInfo(): Rpc.ResponseGetChainInfo {
    return chainRpcBlockingStub.getChainInfo(Rpc.RequestGetChainInfo.getDefaultInstance())
  }

  /**
   * async  gRPC call to get information about current chain, please read [getChainInfo]
   */
  fun asyncGetChainInfo(): ListenableFuture<Rpc.ResponseGetChainInfo> {
    return chainRpcFutureStub.getChainInfo(Rpc.RequestGetChainInfo.getDefaultInstance())
  }

  /**
   * gRPC call to get information of current node
   */
  fun getNodeInfo(): Rpc.ResponseGetNodeInfo {
    return chainRpcBlockingStub.getNodeInfo(Rpc.RequestGetNodeInfo.getDefaultInstance())
  }

  /**
   * async gRPC call to get information of current node, please read [getNetInfo]
   *
   */
  fun asyncGetNodeInfo(): ListenableFuture<Rpc.ResponseGetNodeInfo> {
    return chainRpcFutureStub.getNodeInfo(Rpc.RequestGetNodeInfo.getDefaultInstance())
  }

  /**
   * gRPC call to search for specific key-value pair
   *
   * Parameters:
   * key (string) -- key
   *
   * value (string) -- value
   * @return
   * ResponseSearch
   */
  fun search(request: Rpc.RequestSearch): Rpc.ResponseSearch {
    return chainRpcBlockingStub.search(request)
  }

  /**
   * async gRPC call to search for specific key-value pair, please read [search]
   *
   */
  fun asyncSearch(request: Rpc.RequestSearch): ListenableFuture<Rpc.ResponseSearch> {
    return chainRpcFutureStub.search(request)
  }

  /**
   * gRPC call to get information of the net
   *
   */
  fun getNetInfo(): Rpc.ResponseGetNetInfo {
    return chainRpcBlockingStub.getNetInfo(Rpc.RequestGetNetInfo.getDefaultInstance())
  }

  /**
   * gRPC call to get information of the net， please read [getNetInfo]
   **
   */
  fun asyncGetNetInfo(): ListenableFuture<Rpc.ResponseGetNetInfo> {
    return chainRpcFutureStub.getNetInfo(Rpc.RequestGetNetInfo.getDefaultInstance())
  }

  /**
   * gRPC call to get information about at current chain
   *
   * ```
   * Validator Info:
   * block_height: 27036
   * validators {
   *   address: "zyt483kobYRZcYqNG**********"
   *   pub_key {
   *     type: ""
   *     data: ""
   *   }
   *   voting_power: 10
   *   proposer_priority: "0"
   *   geo_info {
   *     city: "Columbus"
   *     country: "United States"
   *     latitude: 39.9653
   *     longitude: -83.0235
   *   }
   * }
   * ```
   */
  fun getValidatorsInfo(): Rpc.ResponseGetValidatorsInfo {
    return chainRpcBlockingStub.getValidatorsInfo(Rpc.RequestGetValidatorsInfo.getDefaultInstance())
  }

  /**
   * gRPC call to get information about al current validators
   */
  fun asyncGetValidatorsInfo(): ListenableFuture<Rpc.ResponseGetValidatorsInfo> {
    return chainRpcFutureStub.getValidatorsInfo(Rpc.RequestGetValidatorsInfo.getDefaultInstance())
  }

  /**
   * gRPC call to get detailed configuration current chain is using
   *
   * ```
   *  [forge]
   *  proto_version = 1
   *  path = "/Users/paperhuang/.forge_chains/forge_default/forge_release/core"
   *  logpath = "logs"
   *  sock_grpc = "tcp://127.0.0.1:28210"
   *  pub_sub_key = "ABTTOTHEMOON"
   *
   *  [forge.stake.timeout]
   *  general = 10
   *  stake_for_node = 60
   *  ...
   * ```
   *
   *
   */
  fun getConfig(request: Rpc.RequestGetConfig): Rpc.ResponseGetConfig {
    return chainRpcBlockingStub.getConfig(request)
  }

  /**
   * gRPC call to get detailed configuration current chain is using
   *
   * ```
   *  [forge]
   *  proto_version = 1
   *  path = "/Users/paperhuang/.forge_chains/forge_default/forge_release/core"
   *  logpath = "logs"
   *  sock_grpc = "tcp://127.0.0.1:28210"
   *  pub_sub_key = "ABTTOTHEMOON"
   *
   *  [forge.stake.timeout]
   *  general = 10
   *  stake_for_node = 60
   *  ...
   * ```
   */
  fun getConfig(): Rpc.ResponseGetConfig {
    return chainRpcBlockingStub.getConfig(Rpc.RequestGetConfig.getDefaultInstance())
  }


  /**
   * async gRPC call to get detailed configuration current chain is using
   *
   */
  fun asyncGetConfig(): ListenableFuture<Rpc.ResponseGetConfig> {
    return chainRpcFutureStub.getConfig(Rpc.RequestGetConfig.getDefaultInstance())
  }

  /**
   * gRpc call to get analyze information
   *
   * day_info (ByDay) -- optional, date filter for information
   * date (ByHour) -- optional, information returned by hour in specific day
   *
   * ```
   * num_blocks: 27097
   * num_txs: 115
   * num_stakes {
   *   value: "\000"
   * }
   * num_validators: 1
   * num_account_migrate_txs: 0
   * num_create_asset_txs: 0
   * num_consensus_upgrade_txs: 0
   * num_declare_txs: 67
   * num_declare_file_txs: 0
   * num_exchange_txs: 1
   * num_stake_txs: 0
   * num_sys_upgrade_txs: 0
   * num_transfer_txs: 3
   * num_update_asset_txs: 0
   * num_consume_asset_txs: 0
   * num_poke_txs: 40
   * tps: 0
   * avg_block_time: 5.0
   * ```
   */
  fun getForgeStats(): Rpc.ResponseGetForgeStats {
    return statsRpcBlockingStub.getForgeStats(Rpc.RequestGetForgeStats.getDefaultInstance())
  }

  private fun Date.toForgeDateString() = SimpleDateFormat("yyyy-MM-dd").format(this)

  /**
   * gRpc call to get analyze information ,more to see [getForgeStats]
   *
   * @param startDate start date of analyze
   * @param endDate edn date of analyze
   *
   */
  fun getForgeStats(startDate: Date, endDate: Date): Rpc.ResponseGetForgeStats {
    return statsRpcBlockingStub.getForgeStats(Rpc.RequestGetForgeStats.newBuilder()
      .setDayInfo(Rpc.ByDay.newBuilder().setStartDate(startDate.toForgeDateString()).setEndDate(endDate.toForgeDateString()).build())
      .build())
  }

  /**
   * gRpc call to get analyze information ,more to see [getForgeStats]
   *
   * @param someDay set target day of your want analyze by hours
   */
  fun getForgeStats(someDay: Date): Rpc.ResponseGetForgeStats {
    return statsRpcBlockingStub.getForgeStats(Rpc.RequestGetForgeStats.newBuilder()
      .setDate(Rpc.ByHour.newBuilder().setDate(someDay.toForgeDateString()).build())
      .build())
  }

  /**
   * gRpc call to get analyze information ,please read [getForgeStats]
   */
  fun asyncGetForgeStats(request: Rpc.RequestGetForgeStats): ListenableFuture<Rpc.ResponseGetForgeStats> {
    return statsRpcFutureStub.getForgeStats(request)
  }

  /**
   * gRPC call to list transactions
   *
   * Parameters
   * address_filter (string) -- address filter
   * time_filter (TimeFilter) -- time filter
   * type_filter (TypeFilter) -- type filter
   * validity_filter (ValidityFilter) -- validity filter
   * paging (PagingInput) -- paging preference
   *
   */
  fun listTransactions(request: Rpc.RequestListTransactions): Rpc.ResponseListTransactions {
    return statsRpcBlockingStub.listTransactions(request)
  }

  /**
   * async gRPC call to list transactions, please read [listTransactions]
   *
   */
  fun asyncListTransactions(
    request: Rpc.RequestListTransactions): ListenableFuture<Rpc.ResponseListTransactions> {
    return statsRpcFutureStub.listTransactions(request)
  }

  /**
   * gRpc call to list all assets under the given account address
   * owner_address (string) -- target account address
   * paging (PageInput) -- optional, paging preference
   *
   */
  fun listAssets(request: Rpc.RequestListAssets): Rpc.ResponseListAssets {
    return statsRpcBlockingStub.listAssets(request)
  }

  /**
   * async gRpc call to list all assets under the given account address, please read [listAssets]
   */
  fun asyncListAssets(request: Rpc.RequestListAssets): ListenableFuture<Rpc.ResponseListAssets> {
    return statsRpcFutureStub.listAssets(request)
  }

  /**
   * list stakes at current chain
   */
  fun listStakes(request: Rpc.RequestListStakes): Rpc.ResponseListStakes {
    return statsRpcBlockingStub.listStakes(request)
  }

  /**
   * async list stakes at current chain
   */
  fun asyncListStakes(request: Rpc.RequestListStakes): ListenableFuture<Rpc.ResponseListStakes> {
    return statsRpcFutureStub.listStakes(request)
  }

  /**
   * list not account information
   *
   * ```
   * forgeSDK.listAccount(Rpc.RequestListAccount.newBuilder()
   *       .setOwnerAddress(nodeInfo.address)```
   *       .build())
   * ```
   */
  fun listAccount(request: Rpc.RequestListAccount): Rpc.ResponseListAccount {
    return statsRpcBlockingStub.listAccount(request)
  }

  /**
   * async list not account information
   */
  fun asyncListAccount(request: Rpc.RequestListAccount): ListenableFuture<Rpc.ResponseListAccount> {
    return statsRpcFutureStub.listAccount(request)
  }

  /**
   * list top accounts of current chain
   * Param:
   *      Page
   */
  fun listTopAccounts(request: Rpc.RequestListTopAccounts): Rpc.ResponseListTopAccounts {
    return statsRpcBlockingStub.listTopAccounts(request)
  }

  /**
   * async list top accounts of current chain
   */
  fun asyncListTopAccounts(
    request: Rpc.RequestListTopAccounts): ListenableFuture<Rpc.ResponseListTopAccounts> {
    return statsRpcFutureStub.listTopAccounts(request)
  }

  /**
   * list transaction related to asset
   * Params:
   *  address: asset address
   *  paging: page input
   *
   * Example:
   *
   * ```
   *     val address = createAssset(alice)
   *     forgeSDK.listAssetTransactions(Rpc.RequestListAssetTransactions.newBuilder()
   *       .setAddress(address)
   *       .build())
   * ```
   */
  fun listAssetTransactions(request: Rpc.RequestListAssetTransactions): Rpc.ResponseListAssetTransactions {
    return statsRpcBlockingStub.listAssetTransactions(request)
  }

  /**
   * async list transaction related to asset, see [listAssetTransactions]
   */
  fun asyncListAssetTransactions(
    request: Rpc.RequestListAssetTransactions): ListenableFuture<Rpc.ResponseListAssetTransactions> {
    return statsRpcFutureStub.listAssetTransactions(request)
  }

  /**
   * gRPC call to get information of blocks
   * Params:
   *  height_filter: range filter for blocks
   *  empty_excluded: whether to include empty blocks
   *  paging: page input
   *
   */
  fun listBlocks(request: Rpc.RequestListBlocks): Rpc.ResponseListBlocks {
    return statsRpcBlockingStub.listBlocks(request)
  }

  /**
   * async gRPC call to get information of blocks, see [listBlocks]
   */
  fun asyncListBlocks(request: Rpc.RequestListBlocks): ListenableFuture<Rpc.ResponseListBlocks> {
    return statsRpcFutureStub.listBlocks(request)
  }

  /**
   * gRPC call to get Forge health status
   */
  fun getHealthStatus(request: Rpc.RequestGetHealthStatus): Rpc.ResponseGetHealthStatus {
    return statsRpcBlockingStub.getHealthStatus(request)
  }

  /**
   * async gRPC call to get Forge health status
   */
  fun asyncGetHealthStatus(
    request: Rpc.RequestGetHealthStatus): ListenableFuture<Rpc.ResponseGetHealthStatus> {
    return statsRpcFutureStub.getHealthStatus(request)
  }

  /**
   * gRPC request to subscribe to specific type of transactions
   * Params:
   *  topic_type: type of topic to subscribe
   *  tx_filter: filter for target transactions
   */
  fun subscribe(request: Rpc.RequestSubscribe, observer: StreamObserver<Rpc.ResponseSubscribe>) {
    eventRpcStub.subscribe(request, observer)
  }

  /**
   * gRPC call to stop previously subscribed transactions
   * Params:
   *  topic: topic id return by subscribe
   */
  fun unsubscribe(request: Rpc.RequestUnsubscribe): Rpc.ResponseUnsubscribe {
    return eventRpcBlockingStub.unsubscribe(request)
  }

  /**
   * async gRPC call to stop previously subscribed transactions
   * Params:
   *  topic: topic id return by subscribe
   */
  fun asyncUnsubscribe(request: Rpc.RequestUnsubscribe): ListenableFuture<Rpc.ResponseUnsubscribe> {
    return eventRpcFutureStub.unsubscribe(request)
  }

  /**
   * gRPC call to get detailed of account
   */
  fun getAccountState(
    observer: StreamObserver<Rpc.ResponseGetAccountState>): StreamObserver<Rpc.RequestGetAccountState> {
    return stateRpcStub.getAccountState(observer)
  }

  /**
   * gRPC call to get detailed of asset
   */
  fun getAssetState(
    observer: StreamObserver<Rpc.ResponseGetAssetState>): StreamObserver<Rpc.RequestGetAssetState> {
    return stateRpcStub.getAssetState(observer)
  }

  /**
   * gRPC to get forge state
   *
   */
  fun getForgeState(request: Rpc.RequestGetForgeState): Rpc.ResponseGetForgeState {
    return stateRpcBlockingStub.getForgeState(request)
  }

  /**
   * gRPC to get forge state
   */
  fun getForgeState(): Rpc.ResponseGetForgeState {
    return stateRpcBlockingStub.getForgeState(Rpc.RequestGetForgeState.getDefaultInstance())
  }

  /**
   * async gRPC to get forge state
   */
  fun asyncGetForgeState(request: Rpc.RequestGetForgeState): ListenableFuture<Rpc.ResponseGetForgeState> {
    return stateRpcFutureStub.getForgeState(request)
  }

//
//  fun getProtocolState(
//    observer: StreamObserver<ResponseGetProtocolState>): StreamObserver<RequestGetProtocolState> {
//    return stateRpcStub.getProtocolState(observer)
//  }


  /**
   * gRPC call to get detailed of stake
   */
  fun getStakeState(
    observer: StreamObserver<Rpc.ResponseGetStakeState>): StreamObserver<Rpc.RequestGetStakeState> {
    return stateRpcStub.getStakeState(observer)
  }


  fun getTetherState(
    observer: StreamObserver<Rpc.ResponseGetTetherState>): StreamObserver<Rpc.RequestGetTetherState> {
    return stateRpcStub.getTetherState(observer)
  }

  /**
   * create a wallet on local
   * Example:
   * ```
   * ForgeSDK.createWallet();
   * or
   * ForgeSDK.createWallet(Type.WalletType.newBuilder().setHash(Enum.HashType.sha3).setPk(Enum.KeyType.ed25519).setRole(Enum.RoleType
   * .role_account).build());
   * ```
   */
  fun createWallet(type: Type.WalletType? = Type.WalletType.newBuilder().setHash(Enum.HashType.sha3).setPk(Enum.KeyType.ed25519).setRole(Enum.RoleType
    .role_account).build()): WalletInfo {
    return DIDGenerator.randomWallet(type)
  }


  /**
   * gRPC call to create a wallet on Forge, this wallet managed by chain node,
   * you can reload it by address and password
   *
   * @param moniker user name
   * @param password password
   */
//  fun createWallet(moniker: String, password: String): Rpc.ResponseCreateWallet {
//    return walletRpcBlockingStub.createWallet(Rpc.RequestCreateWallet.newBuilder()
//      .setMoniker(moniker)
//      .setPassphrase(password)
//      .setType(Type.WalletType.newBuilder().setPk(Enum.KeyType.ed25519)
//        .setHash(Enum.HashType.sha3)
//        .setRole(Enum.RoleType.role_account).build())
//      .build())
//  }

  /**
   * async gRPC call to create a wallet on Forge, please read [createWallet]
   */
//  fun asyncCreateWallet(request: Rpc.RequestCreateWallet): ListenableFuture<Rpc.ResponseCreateWallet> {
//    return walletRpcFutureStub.createWallet(request)
//  }

  /**
   * gRPC call to load your wallet managed by current node.
   * Params:
   *  PassPhrase: your pass phrase when you create your wallet
   *  address: your wallet address
   *
   * Example:
   * ```
   * forgeSDK.loadWallet(Rpc.RequestLoadWallet.newBuilder()
   *       .setAddress(w.address)
   *       .setPassphrase("abc123")
   *       .build())
   * ```
   */
//  fun loadWallet(request: Rpc.RequestLoadWallet): Rpc.ResponseLoadWallet {
//    return walletRpcBlockingStub.loadWallet(request)
//  }

  /**
   * async gRPC call to load your wallet managed by current node. please read [loadWallet]
   */
//  fun asyncLoadWallet(request: Rpc.RequestLoadWallet): ListenableFuture<Rpc.ResponseLoadWallet> {
//    return walletRpcFutureStub.loadWallet(request)
//  }

  /**
   * gRPC call to recover a wallet on forge
   * Params:
   *  address: wallet address
   *  passphrase: password you create wallet
   *  data: wallet sk
   *
   */
//  fun recoverWallet(request: Rpc.RequestRecoverWallet): Rpc.ResponseRecoverWallet {
//    return walletRpcBlockingStub.recoverWallet(request)
//  }

  /**
   * async gRPC call to recover a wallet on forge
   *
   */
//  fun asyncRecoverWallet(request: Rpc.RequestRecoverWallet): ListenableFuture<Rpc.ResponseRecoverWallet> {
//    return walletRpcFutureStub.recoverWallet(request)
//  }

  /**
   * gRPC call to list al wallets on current Forge Node
   */
//  fun listWallet(request: Rpc.RequestListWallet, observer: StreamObserver<Rpc.ResponseListWallet>) {
//    walletRpcStub.listWallet(request, observer)
//  }
//
//  /**
//   * gRPC call to remove wallet with given address
//   *
//   */
//  fun removeWallet(request: Rpc.RequestRemoveWallet): Rpc.ResponseRemoveWallet {
//    return walletRpcBlockingStub.removeWallet(request)
//  }
//
//  /**
//   * async gRPC call to remove wallet with given address
//   *
//   */
//  fun asyncRemoveWallet(request: Rpc.RequestRemoveWallet): ListenableFuture<Rpc.ResponseRemoveWallet> {
//    return walletRpcFutureStub.removeWallet(request)
//  }

  /**
   * gRPC call to declare current node
   *
   */
  fun declareNode(request: Rpc.RequestDeclareNode): Rpc.ResponseDeclareNode {
    return walletRpcBlockingStub.declareNode(request)
  }

  /**
   * gRPC call to declare current node
   *
   */
  fun asyncDeclareNode(request: Rpc.RequestDeclareNode): ListenableFuture<Rpc.ResponseDeclareNode> {
    return walletRpcFutureStub.declareNode(request)
  }

  /**
   * gRPC call to store file on forge
   * Params:
   *  chunk: file bytes to store
   */
  fun storeFile(observer: StreamObserver<Rpc.ResponseStoreFile>): StreamObserver<Rpc.RequestStoreFile> {
    return fileRpcStub.storeFile(observer)
  }

  /**
   * gRPC call to get file on forge
   * Params:
   *  file_hash: hash of stored file
   */
  fun loadFile(request: Rpc.RequestLoadFile, observer: StreamObserver<Rpc.ResponseLoadFile>) {
    fileRpcStub.loadFile(request, observer)
  }

  /**
   * gRPC call to pin file so Forge will keep the file
   * Params:
   *  file_hash: hash of file to pin
   */
  fun pinFile(request: Rpc.RequestPinFile): Rpc.ResponsePinFile {
    return fileRpcBlockingStub.pinFile(request)
  }

  /** async gRPC call to pin file so Forge will keep the file, please read [pinFile]    */
  fun asyncPinFile(request: Rpc.RequestPinFile): ListenableFuture<Rpc.ResponsePinFile> {
    return fileRpcFutureStub.pinFile(request)
  }

  /**
   * init a rpc client instance
   */
  fun init(builder: ManagedChannelBuilder<*>) {
    channel = builder.build()
    chainRpcBlockingStub = ChainRpcGrpc.newBlockingStub(channel)
    chainRpcStub = ChainRpcGrpc.newStub(channel)
    chainRpcFutureStub = ChainRpcGrpc.newFutureStub(channel)
    statsRpcBlockingStub = StatsRpcGrpc.newBlockingStub(channel)
    statsRpcStub = StatsRpcGrpc.newStub(channel)
    statsRpcFutureStub = StatsRpcGrpc.newFutureStub(channel)
    eventRpcBlockingStub = EventRpcGrpc.newBlockingStub(channel)
    eventRpcStub = EventRpcGrpc.newStub(channel)
    eventRpcFutureStub = EventRpcGrpc.newFutureStub(channel)
    stateRpcBlockingStub = StateRpcGrpc.newBlockingStub(channel)
    stateRpcStub = StateRpcGrpc.newStub(channel)
    stateRpcFutureStub = StateRpcGrpc.newFutureStub(channel)
    walletRpcBlockingStub = WalletRpcGrpc.newBlockingStub(channel)
    walletRpcStub = WalletRpcGrpc.newStub(channel)
    walletRpcFutureStub = WalletRpcGrpc.newFutureStub(channel)
    fileRpcBlockingStub = FileRpcGrpc.newBlockingStub(channel)
    fileRpcStub = FileRpcGrpc.newStub(channel)
    fileRpcFutureStub = FileRpcGrpc.newFutureStub(channel)
  }

  /**
   * init a rpc client instance
   * @param host forge node host
   * @param port forge node rpc port
   */
  private fun init(host: String, port: Int) {
    init(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true))
  }

  /**
   * shutdown your connection
   */
  @Throws(InterruptedException::class)
  fun shutdown() {
    channel.awaitTermination(6, TimeUnit.SECONDS)
  }

  companion object {
    /**
     * connect to forge node, and get a forge client instance
     */
    fun connect(host: String, port: Int): ForgeSDK {
      val forge = ForgeSDK().apply { this.init(host, port) }
      return forge
    }

    /**
     * connect to forge node, and get a forge client instance
     */
    fun connect(builder: ManagedChannelBuilder<*>): ForgeSDK {
      val forge = ForgeSDK().apply { this.init(builder) }
      return forge
    }
  }
}
