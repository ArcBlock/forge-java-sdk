//package io.arcblock.forge
//
//import com.google.protobuf.Any
//import com.google.protobuf.ByteString
//import forge_abi.*
//import forge_abi.Enum
//import io.arcblock.forge.did.DIDGenerator
//import io.arcblock.forge.did.WalletInfo
//import io.grpc.stub.StreamObserver
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Ignore
//import org.junit.Test
//import java.math.BigInteger
//import java.util.*
//import java.util.concurrent.atomic.AtomicBoolean
//
//@Ignore
//class ForgeSDKTest {
//
//  lateinit var forgeSDK: ForgeSDK
//  lateinit var alice: Type.WalletInfo
//  lateinit var aliceToken: String
//  lateinit var bob: Type.WalletInfo
//  lateinit var chainInfo: Type.ChainInfo
//  val walletType = Type.WalletType.newBuilder().setHashValue(Enum.HashType.sha3_VALUE)
//    .setRole(Enum.RoleType.role_account)
//    .setPkValue(Enum.KeyType.ed25519_VALUE)
//
//  @Before
//  fun setup() {
//    forgeSDK = ForgeSDK.connect("localhost", 28210)
//    forgeSDK.createWallet(Rpc.RequestCreateWallet.newBuilder()
//      .setMoniker("Alice").setPassphrase("abc123")
//      .setType(walletType)
//      .build()).let {
//      alice = it.wallet
//      aliceToken = it.token
//    }
//    bob = forgeSDK.createWallet(Rpc.RequestCreateWallet.newBuilder().setMoniker("BBBBob").setPassphrase("abc123")
//      .setType(walletType)
//      .build()).wallet
//    chainInfo = forgeSDK.getChainInfo(Rpc.RequestGetChainInfo.getDefaultInstance()).info
//    val pokeConfig = forgeSDK.getForgeState(Rpc.RequestGetForgeState.getDefaultInstance()).state
//    poke( alice)
//    poke( bob)
//
//  }
//
//
//  private fun poke( who: Type.WalletInfo) {
//    val tx = TransactionFactory.unsignPoke(chainInfo.network, wallet = WalletInfo(who))
//      .signTx(who.sk.toByteArray())
//    val response = forgeSDK.sendTx(Rpc.RequestSendTx.newBuilder().setTx(tx).build())
//    Assert.assertEquals("poke transaction:", Enum.StatusCode.ok, response.code)
//  }
//
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
//   * .setNonce("abc")
//   * .setWallet(wallet)//or set token
//   * .build())
//   *```
//   *
//   * @param  request  transaction request
//   * @return  result
//   */
//
//  @Test
//  fun createTx() {
//    val response = forgeSDK.createTx(Rpc.RequestCreateTx.newBuilder()
//      .setFrom(alice.address)
//      .setItx(Any.newBuilder()
//        .setValue(Declare.DeclareTx.newBuilder()
//          .setIssuer(alice.address)
//          .setMoniker("Aliccce").build().toByteString())
//        .setTypeUrl(TypeUrls.DECLARE)
//        .build())
//      .setNonce(System.currentTimeMillis())
//      .setWallet(alice)
//      .build())
//    Assert.assertEquals("create declare transaction:", Enum.StatusCode.ok, response.code)
//  }
//
//  @Test
//  fun multisig() {
//    val tx = createExchange()
//    val response = forgeSDK.multisig(Rpc.RequestMultisig.newBuilder()
//      .setTx(tx)
//      .setWallet(bob)
//      .build())
//    Assert.assertEquals("multi sig transaction:", Enum.StatusCode.ok, response.code)
//    val sendResponse = forgeSDK.sendTx(response.tx)
//    Assert.assertEquals(" send multi sig transaction:", Enum.StatusCode.ok, sendResponse.code)
//  }
//
//  private fun createExchange(): Type.Transaction {
//    val exchange = Exchange.ExchangeTx.newBuilder()
//      .setReceiver(Exchange.ExchangeInfo.newBuilder()
//        .setValue(Type.BigUint.newBuilder()
//          .setValue(ByteString.copyFrom("1".toByteArray()))
//          .build())
//        .build())
//      .setSender(Exchange.ExchangeInfo.newBuilder()
//        .setValue(Type.BigUint.newBuilder()
//          .setValue(ByteString.copyFrom("1".toByteArray()))
//          .build())
//        .build())
//      .setTo(bob.address)
//      .build()
//    return TransactionFactory.createTransaction(chainInfo.network, alice.address, alice.pk.toByteArray(), exchange.toByteString(), TypeUrls.EXCHANGE).signTx(alice.sk.toByteArray())
//  }
//
//  @Test
//  fun sendTx() {
//    sendTransfer()
//  }
//
//  private fun sendTransfer(): String {
//    val transfer = Transfer.TransferTx.newBuilder()
//      .setTo(bob.address)
//      .setValue(Type.BigUint.newBuilder().setValue(ByteString.copyFrom(BigInteger.ONE.toByteArray())).build())
//      .build()
//    val tx = TransactionFactory.createTransaction(chainInfo.network, alice.address, alice.pk.toByteArray(), transfer.toByteString(), TypeUrls.TRANSFER)
//      .signTx(alice.sk.toByteArray())
//    val response = forgeSDK.sendTx(tx)
//    Assert.assertEquals("Send a transfer", Enum.StatusCode.ok, response.code)
//    return response.hash
//  }
//
//
//  @Test
//  fun getTx() {
//    val called = AtomicBoolean(false)
//    val observer = forgeSDK.getTx(object : StreamObserver<Rpc.ResponseGetTx> {
//      override fun onCompleted() {
//      }
//
//      override fun onError(t: Throwable?) {
//      }
//
//      override fun onNext(value: Rpc.ResponseGetTx?) {
//        Assert.assertEquals("get a transaction info", Enum.StatusCode.ok, value?.code)
//        called.set(true)
//      }
//    })
//    val hash = sendTransfer()
//    observer.onNext(Rpc.RequestGetTx.newBuilder()
//      .setHash(hash)
//      .build())
//    Thread.sleep(1000)
//    Assert.assertEquals("get any transaction info", true, called.get())
//  }
//
//  @Test
//  fun getBlock() {
//    val called = AtomicBoolean(false)
//    val observer = forgeSDK.getBlock(object : StreamObserver<Rpc.ResponseGetBlock> {
//      override fun onCompleted() {
//      }
//
//      override fun onError(t: Throwable?) {
//      }
//
//      override fun onNext(value: Rpc.ResponseGetBlock?) {
//        Assert.assertEquals("get a block info", Enum.StatusCode.ok, value?.code)
//        called.set(true)
//      }
//    })
//    observer.onNext(Rpc.RequestGetBlock.newBuilder()
//      .setHeight(10)
//      .build())
//    Thread.sleep(1000)
//    Assert.assertEquals("get block info at height 10", true, called.get())
//  }
//
//  @Test
//  fun getBlocks() {
//    val blocks = forgeSDK.getBlocks(Rpc.RequestGetBlocks.newBuilder()
//      .setHeightFilter(TraceType.RangeFilter.newBuilder().setFrom(10).setTo(30).build())
//      .setPaging(TraceType.PageInput.newBuilder().setSize(5))
//      .setEmptyExcluded(true)
//      .build())
//    Assert.assertEquals("get blocks info", Enum.StatusCode.ok, blocks.code)
//  }
//
//  @Test
//  fun getUnconfirmedTxs() {
//    val response = forgeSDK.getUnconfirmedTxs(Rpc.RequestGetUnconfirmedTxs.newBuilder()
//      .build())
//    Assert.assertEquals("get uncomfirmed transactions", Enum.StatusCode.ok, response.code)
//  }
//
//  @Test
//  fun getChainInfo() {
//    val response = forgeSDK.getChainInfo(Rpc.RequestGetChainInfo.getDefaultInstance())
//    Assert.assertEquals("get chain info", Enum.StatusCode.ok, response.code)
//    println("ChainInfo:\n${response.info}")
//  }
//
//  @Test
//  fun getNodeInfo() {
//    val response = forgeSDK.getNodeInfo(Rpc.RequestGetNodeInfo.getDefaultInstance())
//    Assert.assertEquals("get Node info", Enum.StatusCode.ok, response.code)
//    println("NodeInfo:\n${response.info}")
//  }
//
//  @Test
//  fun search() {
////    forgeSDK.search(Rpc.RequestSearch.newBuilder()
////      .build())
//  }
//
//  @Test
//  fun getNetInfo() {
//    val response = forgeSDK.getNetInfo(Rpc.RequestGetNetInfo.getDefaultInstance())
//    Assert.assertEquals("get Net info", Enum.StatusCode.ok, response.code)
//    println("NetInfo:\n${response.netInfo}")
//  }
//
//  @Test
//  fun getValidatorsInfo() {
//    val response = forgeSDK.getValidatorsInfo(Rpc.RequestGetValidatorsInfo.getDefaultInstance())
//    Assert.assertEquals("get validators info", Enum.StatusCode.ok, response.code)
//    println("Validator Info:\n${response.validatorsInfo}")
//  }
//
//  @Test
//  fun getConfig() {
//    val response = forgeSDK.getConfig(Rpc.RequestGetConfig.getDefaultInstance())
//    Assert.assertEquals("get Net info", Enum.StatusCode.ok, response.code)
//    println("Config:\n${response.config}")
//  }
//
//  @Test
//  fun getForgeStats() {
//    val response = forgeSDK.getForgeStats(Rpc.RequestGetForgeStats.getDefaultInstance())
//    Assert.assertEquals("get Forge stats", Enum.StatusCode.ok, response.code)
//    println("Stats:\n${response.forgeStats}")
//  }
//
//  @Test
//  fun listTransactions() {
//    val response = forgeSDK.listTransactions(Rpc.RequestListTransactions.newBuilder()
//      .setPaging(TraceType.PageInput.newBuilder().setSize(11).build())
//      .build())
//    Assert.assertEquals("get transaction list", Enum.StatusCode.ok, response.code)
//    Assert.assertEquals("get transaction list size is 11", 11, response.transactionsList.size)
//  }
//
//  private fun createAssset(who: Type.WalletInfo): String {
//    val data = Any.newBuilder().setTypeUrl("test_asset").setValue(ByteString.copyFromUtf8(UUID.randomUUID().toString())).build()
//    var itx = CreateAsset.CreateAssetTx.newBuilder().setData(data)
//      .setMoniker("abcdef")
//      .setReadonly(false)
//      .setParent("")
//      .setTransferrable(false)
//      .setTtl(0)
//      .build()
//    val address = DIDGenerator.genAssetDid(who.address, itx.toByteArray())
//    itx = itx.toBuilder().setAddress(address).build()
//    val tx = TransactionFactory.createTransaction(chainInfo.network, alice.address, alice.pk.toByteArray(), itx.toByteString(), TypeUrls.CREATE_ASSET).signTx(who.sk.toByteArray())
//    val response = forgeSDK.sendTx(tx)
//    Assert.assertEquals("create an asset", Enum.StatusCode.ok, response.code)
//    return address
//  }
//
//  @Test
//  fun listAssets() {
//    createAssset(alice)
//    Thread.sleep(5000)
//    val response = forgeSDK.listAssets(Rpc.RequestListAssets.newBuilder()
//      .setOwnerAddress(alice.address)
//      .build())
//    Assert.assertEquals("list Asset", Enum.StatusCode.ok, response.code)
//    println("list Asset:${response.assetsList}")
//  }
//
//  private fun createStake() {
////    var itx = Stake.StakeTx.newBuilder().setAddress(bob.address).setValue(BigInteger.ONE).
//  }
//
//  @Test
//  fun listStakes() {
//
//  }
//
//  @Test
//  fun listAccount() {
//    val response = forgeSDK.listAccount(Rpc.RequestListAccount.newBuilder()
//      .setOwnerAddress(chainInfo.address)
//      .build())
//    Assert.assertEquals("list Account", Enum.StatusCode.ok, response.code)
//    println("list accounts:${response.account}")
//  }
//
//  @Test
//  fun listTopAccounts() {
//    val queryCount = 4
//    val response = forgeSDK.listTopAccounts(Rpc.RequestListTopAccounts.newBuilder()
//      .setPaging(TraceType.PageInput.newBuilder().setSize(queryCount).build())
//      .build())
//    Assert.assertEquals("list top Account", Enum.StatusCode.ok, response.code)
//    Assert.assertEquals("list top Account", queryCount, response.accountsCount)
//    println("list accounts:${response.accountsCount}")
//
//  }
//
//  @Test
//  fun listAssetTransactions() {
//    val address = createAssset(alice)
//    val response = forgeSDK.listAssetTransactions(Rpc.RequestListAssetTransactions.newBuilder()
//      .setAddress(address)
//      .build())
//    Assert.assertEquals("list asset Account", Enum.StatusCode.ok, response.code)
//    println("list Asset Account:${response.transactionsCount}")
//  }
//
//  @Test
//  fun listBlocks() {
//    val response = forgeSDK.listBlocks(Rpc.RequestListBlocks.newBuilder()
//      .setHeightFilter(TraceType.RangeFilter.newBuilder()
//        .setFrom(10)
//        .setTo(14)
//        .build())
//      .build())
//    Assert.assertEquals("list blocks", Enum.StatusCode.ok, response.code)
//    Assert.assertEquals("list asset Account", 5, response.blocksCount)
//  }
//
//  /**
//   * forge {
//   *   health: true
//   *   abi_server: "ok"
//   *   forge_web: "ok"
//   *   abci_server {
//   *     abci_consensus: "ok"
//   *     abci_info: "ok"
//   *   }
//   * }
//   */
//  @Test
//  fun getHealthStatus() {
//    val response = forgeSDK.getHealthStatus(Rpc.RequestGetHealthStatus.getDefaultInstance())
//    Assert.assertEquals("get health status", Enum.StatusCode.ok, response.code)
//    println("Health status:${response.healthStatus}")
//  }
//
//  @Test
//  fun getAccountState() {
//    Thread.sleep(3000)
//    val called = AtomicBoolean(false)
//    val observer = forgeSDK.getAccountState(object : StreamObserver<Rpc.ResponseGetAccountState> {
//      override fun onNext(value: Rpc.ResponseGetAccountState?) {
//        Assert.assertEquals("get account state", Enum.StatusCode.ok, value?.code)
//        println("value:\n$value")
//        called.set(true)
//      }
//
//      override fun onError(t: Throwable?) {
//      }
//
//      override fun onCompleted() {
//      }
//    })
//    observer.onNext(Rpc.RequestGetAccountState.newBuilder()
//      .setAddress(alice.address)
//      .build())
//    Thread.sleep(500)
//    Assert.assertEquals("get account state", true, called.get())
//  }
//
//  @Test
//  fun getAssetState() {
//    val called = AtomicBoolean(false)
//    val address = createAssset(alice)
//    Thread.sleep(3000)
//    val observer = forgeSDK.getAssetState(object : StreamObserver<Rpc.ResponseGetAssetState> {
//      override fun onCompleted() {
//      }
//      override fun onError(t: Throwable?) {
//      }
//      override fun onNext(value: Rpc.ResponseGetAssetState?) {
//        Assert.assertEquals("get account state", Enum.StatusCode.ok, value?.code)
//        println("value:\n$value")
//        called.set(true)
//      }
//    })
//    observer.onNext(Rpc.RequestGetAssetState.newBuilder().setAddress(address).build())
//    Thread.sleep(500)
//    Assert.assertEquals("get account state", true, called.get())
//  }
//
//  @Test
//  fun testGetForgeState() {
//    val resposne = forgeSDK.getForgeState(Rpc.RequestGetForgeState.getDefaultInstance())
//    Assert.assertEquals("get forge state", Enum.StatusCode.ok, resposne.code)
//    println("ForgeState:\n$resposne")
//  }
//
//  @Test
//  fun getProtocolState() {
//
////    val observer = forgeSDK.getProtocolState(object :StreamObserver<Rpc.ResponseGetProtocolState>{
////      override fun onNext(value: Rpc.ResponseGetProtocolState?) {
////        println("value:\n$value")
////      }
////      override fun onError(t: Throwable?) {}
////      override fun onCompleted() {}
////    })
////    observer.onNext(Rpc.RequestGetProtocolState.newBuilder().setAddress().build())
//
//  }
//
//  @Test
//  fun getStakeState() {
//  }
//
//  @Test
//  fun getTetherState() {
//  }
//
//  @Test
//  fun createWallet() {
//    val resposne = forgeSDK.createWallet(Rpc.RequestCreateWallet.newBuilder()
//      .setMoniker("Cappuccino").setPassphrase("abc123")
//      .setType(walletType)
//      .build())
//    Assert.assertEquals("Create wallet", Enum.StatusCode.ok, resposne.code)
//  }
//
//  @Test
//  fun loadWallet() {
//    val w = forgeSDK.createWallet(Rpc.RequestCreateWallet.newBuilder()
//      .setMoniker("Cappuccino").setPassphrase("abc123")
//      .setType(walletType)
//      .build()).wallet
//
//    val response = forgeSDK.loadWallet(Rpc.RequestLoadWallet.newBuilder()
//      .setAddress(w.address)
//      .setPassphrase("abc123")
//      .build())
//    Assert.assertEquals("load wallet", Enum.StatusCode.ok, response.code)
//    Assert.assertEquals("load wallet", 0, response.wallet.sk.size())
//
//  }
//
//  //data is sk
//  @Test
//  fun recoverWallet() {
//    val w = forgeSDK.createWallet(Rpc.RequestCreateWallet.newBuilder()
//      .setMoniker("Cappuccino").setPassphrase("abc123")
//      .setType(walletType)
//      .build()).wallet
//
//    val response = forgeSDK.recoverWallet(Rpc.RequestRecoverWallet.newBuilder().setPassphrase("abc123").setData(w.sk)
//      .setType(Type.WalletType.newBuilder().setHash(Enum.HashType.sha3).setRole(Enum.RoleType.role_account).setPk(Enum.KeyType.ed25519))
//      .setMoniker("Cappuc")
//      .build())
//
//    Assert.assertEquals("recover wallet", Enum.StatusCode.ok, response.code)
//    println("wallet:\n${response.wallet}")
//  }
//
//  @Test
//  fun listWallet() {
//    forgeSDK.listWallet(Rpc.RequestListWallet.newBuilder().build(), object : StreamObserver<Rpc.ResponseListWallet> {
//      override fun onNext(value: Rpc.ResponseListWallet?) {
//        println("List Wallet:\n$value")
//      }
//
//      override fun onError(t: Throwable?) {}
//      override fun onCompleted() {}
//    })
//    Thread.sleep(5000)
//  }
//
//  @Test
//  fun removeWallet() {
//    val w = forgeSDK.createWallet(Rpc.RequestCreateWallet.newBuilder()
//      .setMoniker("Cappuccino").setPassphrase("abc123")
//      .setType(walletType)
//      .build()).wallet
//    val loadBefore = forgeSDK.loadWallet(Rpc.RequestLoadWallet.newBuilder()
//      .setPassphrase("abc123")
//      .setAddress(w.address)
//      .build())
//    Assert.assertEquals("remove wallet", Enum.StatusCode.ok, loadBefore.code)
//
//    val response = forgeSDK.removeWallet(Rpc.RequestRemoveWallet.newBuilder()
//      .setAddress(w.address)
//      .build())
//    Assert.assertEquals("remove wallet", Enum.StatusCode.ok, response.code)
//    val load = forgeSDK.loadWallet(Rpc.RequestLoadWallet.newBuilder()
//      .setPassphrase("abc123")
//      .setAddress(w.address)
//      .build())
//    Assert.assertEquals("remove wallet", Enum.StatusCode.invalid_wallet, load.code)
//  }
//
//  @Test
//  fun declareNode() {
//  }
//
//  @Test
//  fun storeFile() {
//  }
//
//  @Test
//  fun loadFile() {
//  }
//
//  @Test
//  fun pinFile() {
//
//  }
//
//
//}
