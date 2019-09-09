package io.arcblock.forge

import com.google.common.util.concurrent.ListenableFuture
import forge_abi.*
import forge_abi.StatsRpcGrpc.StatsRpcStub
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.stub.StreamObserver
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
  private var channel: ManagedChannel? = null

  private var chainRpcBlockingStub: ChainRpcGrpc.ChainRpcBlockingStub? = null

  private var chainRpcStub: ChainRpcGrpc.ChainRpcStub? = null

  private var chainRpcFutureStub: ChainRpcGrpc.ChainRpcFutureStub? = null

  private var statsRpcBlockingStub: StatsRpcGrpc.StatsRpcBlockingStub? = null

  private var statsRpcStub: StatsRpcStub? = null

  private var statsRpcFutureStub: StatsRpcGrpc.StatsRpcFutureStub? = null

  private var eventRpcBlockingStub: EventRpcGrpc.EventRpcBlockingStub? = null

  private var eventRpcStub: EventRpcGrpc.EventRpcStub? = null

  private var eventRpcFutureStub: EventRpcGrpc.EventRpcFutureStub? = null

  private var stateRpcBlockingStub: StateRpcGrpc.StateRpcBlockingStub? = null

  private var stateRpcStub: StateRpcGrpc.StateRpcStub? = null

  private var stateRpcFutureStub: StateRpcGrpc.StateRpcFutureStub? = null

  private var walletRpcBlockingStub: WalletRpcGrpc.WalletRpcBlockingStub? = null

  private var walletRpcStub: WalletRpcGrpc.WalletRpcStub? = null

  private var walletRpcFutureStub: WalletRpcGrpc.WalletRpcFutureStub? = null

  private var fileRpcBlockingStub: FileRpcGrpc.FileRpcBlockingStub? = null

  private var fileRpcStub: FileRpcGrpc.FileRpcStub? = null

  private var fileRpcFutureStub: FileRpcGrpc.FileRpcFutureStub? = null

  /**
   * gRpc call to build a complete transaction, including sender's pk and sender's signature. <br></br>
   *
   *
   *  To sign a transaction successfully, either a wallet with private key or a token should
   * be provided. However, this practice is not recommended for safety concern. Users should keep
   * their own private keys and sign transactions locally.  <br></br>
   *
   *
   * Example:
   * ```
   * forgeSdk.createTx(Rpc.RequestCreateTx.newBuilder()
   * .setItx(Any.newBuilder().build())
   * .setFrom("z")
   * .setNonce(123L)
   * .setWallet(wallet)//or set token
   * .build())
   *
   * itx:Inner transaction that should be included in this transaction
   * from: address of user responsible for sending this transactions
   * wallet: user wallet
   * token: token provided by forge for using wallets stored on forge
   * nonce: optional, number of tx this account has sent
   * ```
   *
   *
   *
   * @param request transaction request
   * @return code: ok or reason, tx: transaction created by forge core
   *
   *
   *
   */
  fun createTx(request: Rpc.RequestCreateTx): Rpc.ResponseCreateTx {
    return chainRpcBlockingStub!!.createTx(request)
  }

  /**
   * create transaction async interface, please read [createTx]
   */
  fun asyncCreateTx(request: Rpc.RequestCreateTx): ListenableFuture<Rpc.ResponseCreateTx> {
    return chainRpcFutureStub!!.createTx(request)
  }

  /**
   *
   * gRPC call to get multi-signature of a transaction. When executing this transactions, Forge <br>
   * will insert the address to signatures field as Multisig.sign, then create a signature of the <br>
   * entire transaction <br>
   *
   *
   * Example: <br></br>
   * ```
   *     val tx = createExchange()
   *     val response = forgeSDK.multisig(Rpc.RequestMultisig.newBuilder()
   *         .setTx(tx)
   *         .setWallet(bob)
   *         .build())
   * ```
   * <br></br>
   *
   * @param request itx: inner transaction,
   * @return code: ok or error ,tx: transaction with multi sig
   *
   */
  fun multisig(request: Rpc.RequestMultisig): Rpc.ResponseMultisig {
    return chainRpcBlockingStub!!.multisig(request)
  }

  /**
   * async gRPC call to get multi-signature of a transaction. When executing this transactions, Forge
   * will insert the address to signatures field as Multisig.sign, then create a signature of the
   * entire transaction ,please read [multisig]
   *
   */
  fun asyncMultisig(request: Rpc.RequestMultisig): ListenableFuture<Rpc.ResponseMultisig> {
    return chainRpcFutureStub!!.multisig(request)
  }

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
  fun sendTx(request: Rpc.RequestSendTx): Rpc.ResponseSendTx {
    return chainRpcBlockingStub!!.sendTx(request)
  }

  /**
   * async  gRPC call to send the included transaction, please read [sendTx]
   */
  fun asyncSendTx(request: Rpc.RequestSendTx): ListenableFuture<Rpc.ResponseSendTx> {
    return chainRpcFutureStub!!.sendTx(request)
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
    return chainRpcStub!!.getTx(observer)
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
   *      override fun onNext(value: Rpc.ResponseGetBlock?) {
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
    return chainRpcStub!!.getBlock(observer)
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
   *
   */
  fun getBlocks(request: Rpc.RequestGetBlocks): Rpc.ResponseGetBlocks {
    return chainRpcBlockingStub!!.getBlocks(request)
  }

  /**
   * async gRpc call to get information of blocks ,please read [getBlocks]
   *
   */
  fun asyncGetBlocks(request: Rpc.RequestGetBlocks): ListenableFuture<Rpc.ResponseGetBlocks> {
    return chainRpcFutureStub!!.getBlocks(request)
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
    return chainRpcBlockingStub!!.getUnconfirmedTxs(request)
  }

  /**
   * async gRpc call to get currently unconfirmed transactions, please read [getUnconfirmedTxs]
   */
  fun asyncGetUnconfirmedTxs(request: Rpc.RequestGetUnconfirmedTxs): ListenableFuture<Rpc.ResponseGetUnconfirmedTxs> {
    return chainRpcFutureStub!!.getUnconfirmedTxs(request)
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
  fun getChainInfo(request: Rpc.RequestGetChainInfo): Rpc.ResponseGetChainInfo {
    return chainRpcBlockingStub!!.getChainInfo(request)
  }

  /**
   * async  gRPC call to get information about current chain, please read [getChainInfo]
   */
  fun asyncGetChainInfo(request: Rpc.RequestGetChainInfo): ListenableFuture<Rpc.ResponseGetChainInfo> {
    return chainRpcFutureStub!!.getChainInfo(request)
  }

  /**
   * gRPC call to get information of current node
   */
  fun getNodeInfo(request: Rpc.RequestGetNodeInfo): Rpc.ResponseGetNodeInfo {
    return chainRpcBlockingStub!!.getNodeInfo(request)
  }

  /**
   * async gRPC call to get information of current node, please read [getNetInfo]
   *
   */
  fun asyncGetNodeInfo(request: Rpc.RequestGetNodeInfo): ListenableFuture<Rpc.ResponseGetNodeInfo> {
    return chainRpcFutureStub!!.getNodeInfo(request)
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
   *
   *
   */
  fun search(request: Rpc.RequestSearch): Rpc.ResponseSearch {
    return chainRpcBlockingStub!!.search(request)
  }

  /**
   * async gRPC call to search for specific key-value pair, please read [search]
   *
   */
  fun asyncSearch(request: Rpc.RequestSearch): ListenableFuture<Rpc.ResponseSearch> {
    return chainRpcFutureStub!!.search(request)
  }

  /**
   * gRPC call to get information of the net
   *
   */
  fun getNetInfo(request: Rpc.RequestGetNetInfo): Rpc.ResponseGetNetInfo {
    return chainRpcBlockingStub!!.getNetInfo(request)
  }

  /**
   * gRPC call to get information of the net， please read [getNetInfo]
   **
   */
  fun asyncGetNetInfo(request: Rpc.RequestGetNetInfo): ListenableFuture<Rpc.ResponseGetNetInfo> {
    return chainRpcFutureStub!!.getNetInfo(request)
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
  fun getValidatorsInfo(request: Rpc.RequestGetValidatorsInfo): Rpc.ResponseGetValidatorsInfo {
    return chainRpcBlockingStub!!.getValidatorsInfo(request)
  }

  /**
   * gRPC call to get information about al current validators
   */
  fun asyncGetValidatorsInfo(request: Rpc.RequestGetValidatorsInfo): ListenableFuture<Rpc.ResponseGetValidatorsInfo> {
    return chainRpcFutureStub!!.getValidatorsInfo(request)
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
    return chainRpcBlockingStub!!.getConfig(request)
  }

  /**
   * async gRPC call to get detailed configuration current chain is using
   *
   */
  fun asyncGetConfig(request: Rpc.RequestGetConfig): ListenableFuture<Rpc.ResponseGetConfig> {
    return chainRpcFutureStub!!.getConfig(request)
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
  fun getForgeStats(request: Rpc.RequestGetForgeStats): Rpc.ResponseGetForgeStats {
    return statsRpcBlockingStub!!.getForgeStats(request)
  }

  /**
   * gRpc call to get analyze information ,please read [getForgeStats]
   */

  fun asyncGetForgeStats(request: Rpc.RequestGetForgeStats): ListenableFuture<Rpc.ResponseGetForgeStats> {
    return statsRpcFutureStub!!.getForgeStats(request)
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
    return statsRpcBlockingStub!!.listTransactions(request)
  }

  /**
   * async gRPC call to list transactions, please read [listTransactions]
   *
   */
  fun asyncListTransactions(
    request: Rpc.RequestListTransactions): ListenableFuture<Rpc.ResponseListTransactions> {
    return statsRpcFutureStub!!.listTransactions(request)
  }

  /**
   * gRpc call to list all assets under the given account address
   * owner_address (string) -- target account address
   * paging (PageInput) -- optional, paging preference
   *
   */
  fun listAssets(request: Rpc.RequestListAssets): Rpc.ResponseListAssets {
    return statsRpcBlockingStub!!.listAssets(request)
  }

  /**
   * async gRpc call to list all assets under the given account address, please read [listAssets]
   */
  fun asyncListAssets(request: Rpc.RequestListAssets): ListenableFuture<Rpc.ResponseListAssets> {
    return statsRpcFutureStub!!.listAssets(request)
  }

  /**
   * list stakes at current chain
   */
  fun listStakes(request: Rpc.RequestListStakes): Rpc.ResponseListStakes {
    return statsRpcBlockingStub!!.listStakes(request)
  }

  /**
   * async list stakes at current chain
   */
  fun asyncListStakes(request: Rpc.RequestListStakes): ListenableFuture<Rpc.ResponseListStakes> {
    return statsRpcFutureStub!!.listStakes(request)
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
    return statsRpcBlockingStub!!.listAccount(request)
  }

  /**
   * async list not account information
   */
  fun asyncListAccount(request: Rpc.RequestListAccount): ListenableFuture<Rpc.ResponseListAccount> {
    return statsRpcFutureStub!!.listAccount(request)
  }

  /**
   * list top accounts of current chain
   * Param:
   *      Page
   */
  fun listTopAccounts(request: Rpc.RequestListTopAccounts): Rpc.ResponseListTopAccounts {
    return statsRpcBlockingStub!!.listTopAccounts(request)
  }

  /**
   * async list top accounts of current chain
   */
  fun asyncListTopAccounts(
    request: Rpc.RequestListTopAccounts): ListenableFuture<Rpc.ResponseListTopAccounts> {
    return statsRpcFutureStub!!.listTopAccounts(request)
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
    return statsRpcBlockingStub!!.listAssetTransactions(request)
  }

  /**
   * async list transaction related to asset, see [listAssetTransactions]
   */
  fun asyncListAssetTransactions(
    request: Rpc.RequestListAssetTransactions): ListenableFuture<Rpc.ResponseListAssetTransactions> {
    return statsRpcFutureStub!!.listAssetTransactions(request)
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
    return statsRpcBlockingStub!!.listBlocks(request)
  }

  /**
   * async gRPC call to get information of blocks, see [listBlocks]
   */
  fun asyncListBlocks(request: Rpc.RequestListBlocks): ListenableFuture<Rpc.ResponseListBlocks> {
    return statsRpcFutureStub!!.listBlocks(request)
  }

  /**
   * gRPC call to get Forge health status
   */
  fun getHealthStatus(request: Rpc.RequestGetHealthStatus): Rpc.ResponseGetHealthStatus {
    return statsRpcBlockingStub!!.getHealthStatus(request)
  }

  /**
   * async gRPC call to get Forge health status
   */
  fun asyncGetHealthStatus(
    request: Rpc.RequestGetHealthStatus): ListenableFuture<Rpc.ResponseGetHealthStatus> {
    return statsRpcFutureStub!!.getHealthStatus(request)
  }

  /**
   * gRPC request to subscribe to specific type of transactions
   * Params:
   *  topic_type: type of topic to subscribe
   *  tx_filter: filter for target transactions
   */
  fun subscribe(request: Rpc.RequestSubscribe, observer: StreamObserver<Rpc.ResponseSubscribe>) {
    eventRpcStub!!.subscribe(request, observer)
  }

  /**
   * gRPC call to stop previously subscribed transactions
   * Params:
   *  topic: topic id return by subscribe
   */
  fun unsubscribe(request: Rpc.RequestUnsubscribe): Rpc.ResponseUnsubscribe {
    return eventRpcBlockingStub!!.unsubscribe(request)
  }

  /**
   * async gRPC call to stop previously subscribed transactions
   * Params:
   *  topic: topic id return by subscribe
   */
  fun asyncUnsubscribe(request: Rpc.RequestUnsubscribe): ListenableFuture<Rpc.ResponseUnsubscribe> {
    return eventRpcFutureStub!!.unsubscribe(request)
  }

  /**
   * gRPC call to get detailed of account
   */
  fun getAccountState(
    observer: StreamObserver<Rpc.ResponseGetAccountState>): StreamObserver<Rpc.RequestGetAccountState> {
    return stateRpcStub!!.getAccountState(observer)
  }

  /**
   * gRPC call to get detailed of asset
   */
  fun getAssetState(
    observer: StreamObserver<Rpc.ResponseGetAssetState>): StreamObserver<Rpc.RequestGetAssetState> {
    return stateRpcStub!!.getAssetState(observer)
  }

  /**
   * gRPC to get forge state
   *
   */
  fun getForgeState(request: Rpc.RequestGetForgeState): Rpc.ResponseGetForgeState {
    return stateRpcBlockingStub!!.getForgeState(request)
  }

  /**
   * async gRPC to get forge state
   */
  fun asyncGetForgeState(request: Rpc.RequestGetForgeState): ListenableFuture<Rpc.ResponseGetForgeState> {
    return stateRpcFutureStub!!.getForgeState(request)
  }

//
//  fun getProtocolState(
//    observer: StreamObserver<ResponseGetProtocolState>): StreamObserver<RequestGetProtocolState> {
//    return stateRpcStub!!.getProtocolState(observer)
//  }


  /**
   * gRPC call to get detailed of stake
   */
  fun getStakeState(
    observer: StreamObserver<Rpc.ResponseGetStakeState>): StreamObserver<Rpc.RequestGetStakeState> {
    return stateRpcStub!!.getStakeState(observer)
  }


  fun getTetherState(
    observer: StreamObserver<Rpc.ResponseGetTetherState>): StreamObserver<Rpc.RequestGetTetherState> {
    return stateRpcStub!!.getTetherState(observer)
  }

  /**
   * gRPC call to create a wallet on Forge
   * Example:
   * ```
   * orgeSDK.createWallet(Rpc.RequestCreateWallet.newBuilder()
   *       .setMoniker("Cappuccino").setPassphrase("abc123")
   *       .setType(walletType)
   *       .build())
   * ```
   */
  fun createWallet(request: Rpc.RequestCreateWallet): Rpc.ResponseCreateWallet {
    return walletRpcBlockingStub!!.createWallet(request)
  }

  /**
   * async gRPC call to create a wallet on Forge, please read [createWallet]
   */
  fun asyncCreateWallet(request: Rpc.RequestCreateWallet): ListenableFuture<Rpc.ResponseCreateWallet> {
    return walletRpcFutureStub!!.createWallet(request)
  }

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
  fun loadWallet(request: Rpc.RequestLoadWallet): Rpc.ResponseLoadWallet {
    return walletRpcBlockingStub!!.loadWallet(request)
  }

  /**
   * async gRPC call to load your wallet managed by current node. please read [loadWallet]
   */
  fun asyncLoadWallet(request: Rpc.RequestLoadWallet): ListenableFuture<Rpc.ResponseLoadWallet> {
    return walletRpcFutureStub!!.loadWallet(request)
  }

  /**
   * gRPC call to recover a wallet on forge
   * Params:
   *  address: wallet address
   *  passphrase: password you create wallet
   *  data: wallet sk
   *
   */
  fun recoverWallet(request: Rpc.RequestRecoverWallet): Rpc.ResponseRecoverWallet {
    return walletRpcBlockingStub!!.recoverWallet(request)
  }

  /**
   * async gRPC call to recover a wallet on forge
   *
   */
  fun asyncRecoverWallet(request: Rpc.RequestRecoverWallet): ListenableFuture<Rpc.ResponseRecoverWallet> {
    return walletRpcFutureStub!!.recoverWallet(request)
  }

  /**
   * gRPC call to list al wallets on current Forge Node
   */
  fun listWallet(request: Rpc.RequestListWallet, observer: StreamObserver<Rpc.ResponseListWallet>) {
    walletRpcStub!!.listWallet(request, observer)
  }

  /**
   * gRPC call to remove wallet with given address
   *
   */
  fun removeWallet(request: Rpc.RequestRemoveWallet): Rpc.ResponseRemoveWallet {
    return walletRpcBlockingStub!!.removeWallet(request)
  }

  /**
   * async gRPC call to remove wallet with given address
   *
   */
  fun asyncRemoveWallet(request: Rpc.RequestRemoveWallet): ListenableFuture<Rpc.ResponseRemoveWallet> {
    return walletRpcFutureStub!!.removeWallet(request)
  }

  /**
   * gRPC call to declare current node
   *
   */
  fun declareNode(request: Rpc.RequestDeclareNode): Rpc.ResponseDeclareNode {
    return walletRpcBlockingStub!!.declareNode(request)
  }

  /**
   * gRPC call to declare current node
   *
   */
  fun asyncDeclareNode(request: Rpc.RequestDeclareNode): ListenableFuture<Rpc.ResponseDeclareNode> {
    return walletRpcFutureStub!!.declareNode(request)
  }

  /**
   * gRPC call to store file on forge
   * Params:
   *  chunk: file bytes to store
   */
  fun storeFile(observer: StreamObserver<Rpc.ResponseStoreFile>): StreamObserver<Rpc.RequestStoreFile> {
    return fileRpcStub!!.storeFile(observer)
  }

  /**
   * gRPC call to get file on forge
   * Params:
   *  file_hash: hash of stored file
   */
  fun loadFile(request: Rpc.RequestLoadFile, observer: StreamObserver<Rpc.ResponseLoadFile>) {
    fileRpcStub!!.loadFile(request, observer)
  }

  /**
   * gRPC call to pin file so Forge will keep the file
   * Params:
   *  file_hash: hash of file to pin
   */
  fun pinFile(request: Rpc.RequestPinFile): Rpc.ResponsePinFile {
    return fileRpcBlockingStub!!.pinFile(request)
  }

  /** async gRPC call to pin file so Forge will keep the file, please read [pinFile]    */
  fun asyncPinFile(request: Rpc.RequestPinFile): ListenableFuture<Rpc.ResponsePinFile> {
    return fileRpcFutureStub!!.pinFile(request)
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
  private fun init(host: String, port: Int?) {
    init(ManagedChannelBuilder.forAddress(host, port!!).usePlaintext(true))
  }

  /**
   * shutdown your connection
   */
  @Throws(InterruptedException::class)
  fun shutdown() {
    channel!!.awaitTermination(6, TimeUnit.SECONDS)
  }

  companion object {
    /**
     * connect to forge node, and get a forge client instance
     */
    fun connect(host: String, port: Int?): ForgeSDK {
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
