package io.arcblock.forge;

import com.google.common.util.concurrent.ListenableFuture;
import forge_abi.ChainRpcGrpc;
import forge_abi.ChainRpcGrpc.ChainRpcBlockingStub;
import forge_abi.ChainRpcGrpc.ChainRpcFutureStub;
import forge_abi.ChainRpcGrpc.ChainRpcStub;
import forge_abi.EventRpcGrpc;
import forge_abi.EventRpcGrpc.EventRpcBlockingStub;
import forge_abi.EventRpcGrpc.EventRpcFutureStub;
import forge_abi.EventRpcGrpc.EventRpcStub;
import forge_abi.FileRpcGrpc;
import forge_abi.FileRpcGrpc.FileRpcBlockingStub;
import forge_abi.FileRpcGrpc.FileRpcFutureStub;
import forge_abi.FileRpcGrpc.FileRpcStub;
import forge_abi.Rpc.RequestCreateTx;
import forge_abi.Rpc.RequestCreateWallet;
import forge_abi.Rpc.RequestDeclareNode;
import forge_abi.Rpc.RequestGetAccountState;
import forge_abi.Rpc.RequestGetAssetState;
import forge_abi.Rpc.RequestGetBlock;
import forge_abi.Rpc.RequestGetBlocks;
import forge_abi.Rpc.RequestGetChainInfo;
import forge_abi.Rpc.RequestGetConfig;
import forge_abi.Rpc.RequestGetForgeState;
import forge_abi.Rpc.RequestGetForgeStats;
import forge_abi.Rpc.RequestGetHealthStatus;
import forge_abi.Rpc.RequestGetNetInfo;
import forge_abi.Rpc.RequestGetNodeInfo;
import forge_abi.Rpc.RequestGetProtocolState;
import forge_abi.Rpc.RequestGetStakeState;
import forge_abi.Rpc.RequestGetTetherState;
import forge_abi.Rpc.RequestGetTx;
import forge_abi.Rpc.RequestGetUnconfirmedTxs;
import forge_abi.Rpc.RequestGetValidatorsInfo;
import forge_abi.Rpc.RequestListAccount;
import forge_abi.Rpc.RequestListAssetTransactions;
import forge_abi.Rpc.RequestListAssets;
import forge_abi.Rpc.RequestListBlocks;
import forge_abi.Rpc.RequestListStakes;
import forge_abi.Rpc.RequestListTopAccounts;
import forge_abi.Rpc.RequestListTransactions;
import forge_abi.Rpc.RequestListWallet;
import forge_abi.Rpc.RequestLoadFile;
import forge_abi.Rpc.RequestLoadWallet;
import forge_abi.Rpc.RequestMultisig;
import forge_abi.Rpc.RequestPinFile;
import forge_abi.Rpc.RequestRecoverWallet;
import forge_abi.Rpc.RequestRemoveWallet;
import forge_abi.Rpc.RequestSearch;
import forge_abi.Rpc.RequestSendTx;
import forge_abi.Rpc.RequestStoreFile;
import forge_abi.Rpc.RequestSubscribe;
import forge_abi.Rpc.RequestUnsubscribe;
import forge_abi.Rpc.ResponseCreateTx;
import forge_abi.Rpc.ResponseCreateWallet;
import forge_abi.Rpc.ResponseDeclareNode;
import forge_abi.Rpc.ResponseGetAccountState;
import forge_abi.Rpc.ResponseGetAssetState;
import forge_abi.Rpc.ResponseGetBlock;
import forge_abi.Rpc.ResponseGetBlocks;
import forge_abi.Rpc.ResponseGetChainInfo;
import forge_abi.Rpc.ResponseGetConfig;
import forge_abi.Rpc.ResponseGetForgeState;
import forge_abi.Rpc.ResponseGetForgeStats;
import forge_abi.Rpc.ResponseGetHealthStatus;
import forge_abi.Rpc.ResponseGetNetInfo;
import forge_abi.Rpc.ResponseGetNodeInfo;
import forge_abi.Rpc.ResponseGetProtocolState;
import forge_abi.Rpc.ResponseGetStakeState;
import forge_abi.Rpc.ResponseGetTetherState;
import forge_abi.Rpc.ResponseGetTx;
import forge_abi.Rpc.ResponseGetUnconfirmedTxs;
import forge_abi.Rpc.ResponseGetValidatorsInfo;
import forge_abi.Rpc.ResponseListAccount;
import forge_abi.Rpc.ResponseListAssetTransactions;
import forge_abi.Rpc.ResponseListAssets;
import forge_abi.Rpc.ResponseListBlocks;
import forge_abi.Rpc.ResponseListStakes;
import forge_abi.Rpc.ResponseListTopAccounts;
import forge_abi.Rpc.ResponseListTransactions;
import forge_abi.Rpc.ResponseListWallet;
import forge_abi.Rpc.ResponseLoadFile;
import forge_abi.Rpc.ResponseLoadWallet;
import forge_abi.Rpc.ResponseMultisig;
import forge_abi.Rpc.ResponsePinFile;
import forge_abi.Rpc.ResponseRecoverWallet;
import forge_abi.Rpc.ResponseRemoveWallet;
import forge_abi.Rpc.ResponseSearch;
import forge_abi.Rpc.ResponseSendTx;
import forge_abi.Rpc.ResponseStoreFile;
import forge_abi.Rpc.ResponseSubscribe;
import forge_abi.Rpc.ResponseUnsubscribe;
import forge_abi.StateRpcGrpc;
import forge_abi.StateRpcGrpc.StateRpcBlockingStub;
import forge_abi.StateRpcGrpc.StateRpcFutureStub;
import forge_abi.StateRpcGrpc.StateRpcStub;
import forge_abi.StatsRpcGrpc;
import forge_abi.StatsRpcGrpc.StatsRpcBlockingStub;
import forge_abi.StatsRpcGrpc.StatsRpcFutureStub;
import forge_abi.StatsRpcGrpc.StatsRpcStub;
import forge_abi.WalletRpcGrpc;
import forge_abi.WalletRpcGrpc.WalletRpcBlockingStub;
import forge_abi.WalletRpcGrpc.WalletRpcFutureStub;
import forge_abi.WalletRpcGrpc.WalletRpcStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.lang.Integer;
import java.lang.InterruptedException;
import java.lang.String;
import java.util.concurrent.TimeUnit;

/**
 * Auto Generated ,Do not Edit ForgeSDK is tool to connect and 
 * communicate with forge node and provide blocking ,async and reactive 
 * method to handle hain method.
 * and the high level usage please to reference 
 * https://docs.arcblock.io/forge/latest/txs/#categories
 *   */
public final class ForgeSDK {
  private ManagedChannel channel;

  private ChainRpcBlockingStub chainRpcBlockingStub;

  private ChainRpcStub chainRpcStub;

  private ChainRpcFutureStub chainRpcFutureStub;

  private StatsRpcBlockingStub statsRpcBlockingStub;

  private StatsRpcStub statsRpcStub;

  private StatsRpcFutureStub statsRpcFutureStub;

  private EventRpcBlockingStub eventRpcBlockingStub;

  private EventRpcStub eventRpcStub;

  private EventRpcFutureStub eventRpcFutureStub;

  private StateRpcBlockingStub stateRpcBlockingStub;

  private StateRpcStub stateRpcStub;

  private StateRpcFutureStub stateRpcFutureStub;

  private WalletRpcBlockingStub walletRpcBlockingStub;

  private WalletRpcStub walletRpcStub;

  private WalletRpcFutureStub walletRpcFutureStub;

  private FileRpcBlockingStub fileRpcBlockingStub;

  private FileRpcStub fileRpcStub;

  private FileRpcFutureStub fileRpcFutureStub;

  public ResponseCreateTx createTx(RequestCreateTx request) {
    return chainRpcBlockingStub.createTx(request);
  }

  public ListenableFuture<ResponseCreateTx> asyncCreateTx(RequestCreateTx request) {
    return chainRpcFutureStub.createTx(request);
  }

  public void rxCreateTx(RequestCreateTx request, StreamObserver<ResponseCreateTx> observer) {
    chainRpcStub.createTx(request, observer);
  }

  public ResponseMultisig multisig(RequestMultisig request) {
    return chainRpcBlockingStub.multisig(request);
  }

  public ListenableFuture<ResponseMultisig> asyncMultisig(RequestMultisig request) {
    return chainRpcFutureStub.multisig(request);
  }

  public void rxMultisig(RequestMultisig request, StreamObserver<ResponseMultisig> observer) {
    chainRpcStub.multisig(request, observer);
  }

  public ResponseSendTx sendTx(RequestSendTx request) {
    return chainRpcBlockingStub.sendTx(request);
  }

  public ListenableFuture<ResponseSendTx> asyncSendTx(RequestSendTx request) {
    return chainRpcFutureStub.sendTx(request);
  }

  public void rxSendTx(RequestSendTx request, StreamObserver<ResponseSendTx> observer) {
    chainRpcStub.sendTx(request, observer);
  }

  public StreamObserver<RequestGetTx> getTx(StreamObserver<ResponseGetTx> observer) {
    return chainRpcStub.getTx(observer);
  }

  public StreamObserver<RequestGetBlock> getBlock(StreamObserver<ResponseGetBlock> observer) {
    return chainRpcStub.getBlock(observer);
  }

  public ResponseGetBlocks getBlocks(RequestGetBlocks request) {
    return chainRpcBlockingStub.getBlocks(request);
  }

  public ListenableFuture<ResponseGetBlocks> asyncGetBlocks(RequestGetBlocks request) {
    return chainRpcFutureStub.getBlocks(request);
  }

  public void rxGetBlocks(RequestGetBlocks request, StreamObserver<ResponseGetBlocks> observer) {
    chainRpcStub.getBlocks(request, observer);
  }

  public ResponseGetUnconfirmedTxs getUnconfirmedTxs(RequestGetUnconfirmedTxs request) {
    return chainRpcBlockingStub.getUnconfirmedTxs(request);
  }

  public ListenableFuture<ResponseGetUnconfirmedTxs> asyncGetUnconfirmedTxs(
      RequestGetUnconfirmedTxs request) {
    return chainRpcFutureStub.getUnconfirmedTxs(request);
  }

  public void rxGetUnconfirmedTxs(RequestGetUnconfirmedTxs request,
      StreamObserver<ResponseGetUnconfirmedTxs> observer) {
    chainRpcStub.getUnconfirmedTxs(request, observer);
  }

  public ResponseGetChainInfo getChainInfo(RequestGetChainInfo request) {
    return chainRpcBlockingStub.getChainInfo(request);
  }

  public ListenableFuture<ResponseGetChainInfo> asyncGetChainInfo(RequestGetChainInfo request) {
    return chainRpcFutureStub.getChainInfo(request);
  }

  public void rxGetChainInfo(RequestGetChainInfo request,
      StreamObserver<ResponseGetChainInfo> observer) {
    chainRpcStub.getChainInfo(request, observer);
  }

  public ResponseGetNodeInfo getNodeInfo(RequestGetNodeInfo request) {
    return chainRpcBlockingStub.getNodeInfo(request);
  }

  public ListenableFuture<ResponseGetNodeInfo> asyncGetNodeInfo(RequestGetNodeInfo request) {
    return chainRpcFutureStub.getNodeInfo(request);
  }

  public void rxGetNodeInfo(RequestGetNodeInfo request,
      StreamObserver<ResponseGetNodeInfo> observer) {
    chainRpcStub.getNodeInfo(request, observer);
  }

  public ResponseSearch search(RequestSearch request) {
    return chainRpcBlockingStub.search(request);
  }

  public ListenableFuture<ResponseSearch> asyncSearch(RequestSearch request) {
    return chainRpcFutureStub.search(request);
  }

  public void rxSearch(RequestSearch request, StreamObserver<ResponseSearch> observer) {
    chainRpcStub.search(request, observer);
  }

  public ResponseGetNetInfo getNetInfo(RequestGetNetInfo request) {
    return chainRpcBlockingStub.getNetInfo(request);
  }

  public ListenableFuture<ResponseGetNetInfo> asyncGetNetInfo(RequestGetNetInfo request) {
    return chainRpcFutureStub.getNetInfo(request);
  }

  public void rxGetNetInfo(RequestGetNetInfo request, StreamObserver<ResponseGetNetInfo> observer) {
    chainRpcStub.getNetInfo(request, observer);
  }

  public ResponseGetValidatorsInfo getValidatorsInfo(RequestGetValidatorsInfo request) {
    return chainRpcBlockingStub.getValidatorsInfo(request);
  }

  public ListenableFuture<ResponseGetValidatorsInfo> asyncGetValidatorsInfo(
      RequestGetValidatorsInfo request) {
    return chainRpcFutureStub.getValidatorsInfo(request);
  }

  public void rxGetValidatorsInfo(RequestGetValidatorsInfo request,
      StreamObserver<ResponseGetValidatorsInfo> observer) {
    chainRpcStub.getValidatorsInfo(request, observer);
  }

  public ResponseGetConfig getConfig(RequestGetConfig request) {
    return chainRpcBlockingStub.getConfig(request);
  }

  public ListenableFuture<ResponseGetConfig> asyncGetConfig(RequestGetConfig request) {
    return chainRpcFutureStub.getConfig(request);
  }

  public void rxGetConfig(RequestGetConfig request, StreamObserver<ResponseGetConfig> observer) {
    chainRpcStub.getConfig(request, observer);
  }

  public ResponseGetForgeStats getForgeStats(RequestGetForgeStats request) {
    return statsRpcBlockingStub.getForgeStats(request);
  }

  public ListenableFuture<ResponseGetForgeStats> asyncGetForgeStats(RequestGetForgeStats request) {
    return statsRpcFutureStub.getForgeStats(request);
  }

  public void rxGetForgeStats(RequestGetForgeStats request,
      StreamObserver<ResponseGetForgeStats> observer) {
    statsRpcStub.getForgeStats(request, observer);
  }

  public ResponseListTransactions listTransactions(RequestListTransactions request) {
    return statsRpcBlockingStub.listTransactions(request);
  }

  public ListenableFuture<ResponseListTransactions> asyncListTransactions(
      RequestListTransactions request) {
    return statsRpcFutureStub.listTransactions(request);
  }

  public void rxListTransactions(RequestListTransactions request,
      StreamObserver<ResponseListTransactions> observer) {
    statsRpcStub.listTransactions(request, observer);
  }

  public ResponseListAssets listAssets(RequestListAssets request) {
    return statsRpcBlockingStub.listAssets(request);
  }

  public ListenableFuture<ResponseListAssets> asyncListAssets(RequestListAssets request) {
    return statsRpcFutureStub.listAssets(request);
  }

  public void rxListAssets(RequestListAssets request, StreamObserver<ResponseListAssets> observer) {
    statsRpcStub.listAssets(request, observer);
  }

  public ResponseListStakes listStakes(RequestListStakes request) {
    return statsRpcBlockingStub.listStakes(request);
  }

  public ListenableFuture<ResponseListStakes> asyncListStakes(RequestListStakes request) {
    return statsRpcFutureStub.listStakes(request);
  }

  public void rxListStakes(RequestListStakes request, StreamObserver<ResponseListStakes> observer) {
    statsRpcStub.listStakes(request, observer);
  }

  public ResponseListAccount listAccount(RequestListAccount request) {
    return statsRpcBlockingStub.listAccount(request);
  }

  public ListenableFuture<ResponseListAccount> asyncListAccount(RequestListAccount request) {
    return statsRpcFutureStub.listAccount(request);
  }

  public void rxListAccount(RequestListAccount request,
      StreamObserver<ResponseListAccount> observer) {
    statsRpcStub.listAccount(request, observer);
  }

  public ResponseListTopAccounts listTopAccounts(RequestListTopAccounts request) {
    return statsRpcBlockingStub.listTopAccounts(request);
  }

  public ListenableFuture<ResponseListTopAccounts> asyncListTopAccounts(
      RequestListTopAccounts request) {
    return statsRpcFutureStub.listTopAccounts(request);
  }

  public void rxListTopAccounts(RequestListTopAccounts request,
      StreamObserver<ResponseListTopAccounts> observer) {
    statsRpcStub.listTopAccounts(request, observer);
  }

  public ResponseListAssetTransactions listAssetTransactions(RequestListAssetTransactions request) {
    return statsRpcBlockingStub.listAssetTransactions(request);
  }

  public ListenableFuture<ResponseListAssetTransactions> asyncListAssetTransactions(
      RequestListAssetTransactions request) {
    return statsRpcFutureStub.listAssetTransactions(request);
  }

  public void rxListAssetTransactions(RequestListAssetTransactions request,
      StreamObserver<ResponseListAssetTransactions> observer) {
    statsRpcStub.listAssetTransactions(request, observer);
  }

  public ResponseListBlocks listBlocks(RequestListBlocks request) {
    return statsRpcBlockingStub.listBlocks(request);
  }

  public ListenableFuture<ResponseListBlocks> asyncListBlocks(RequestListBlocks request) {
    return statsRpcFutureStub.listBlocks(request);
  }

  public void rxListBlocks(RequestListBlocks request, StreamObserver<ResponseListBlocks> observer) {
    statsRpcStub.listBlocks(request, observer);
  }

  public ResponseGetHealthStatus getHealthStatus(RequestGetHealthStatus request) {
    return statsRpcBlockingStub.getHealthStatus(request);
  }

  public ListenableFuture<ResponseGetHealthStatus> asyncGetHealthStatus(
      RequestGetHealthStatus request) {
    return statsRpcFutureStub.getHealthStatus(request);
  }

  public void rxGetHealthStatus(RequestGetHealthStatus request,
      StreamObserver<ResponseGetHealthStatus> observer) {
    statsRpcStub.getHealthStatus(request, observer);
  }

  public void subscribe(RequestSubscribe request, StreamObserver<ResponseSubscribe> observer) {
    eventRpcStub.subscribe(request, observer);
  }

  public ResponseUnsubscribe unsubscribe(RequestUnsubscribe request) {
    return eventRpcBlockingStub.unsubscribe(request);
  }

  public ListenableFuture<ResponseUnsubscribe> asyncUnsubscribe(RequestUnsubscribe request) {
    return eventRpcFutureStub.unsubscribe(request);
  }

  public void rxUnsubscribe(RequestUnsubscribe request,
      StreamObserver<ResponseUnsubscribe> observer) {
    eventRpcStub.unsubscribe(request, observer);
  }

  public StreamObserver<RequestGetAccountState> getAccountState(
      StreamObserver<ResponseGetAccountState> observer) {
    return stateRpcStub.getAccountState(observer);
  }

  public StreamObserver<RequestGetAssetState> getAssetState(
      StreamObserver<ResponseGetAssetState> observer) {
    return stateRpcStub.getAssetState(observer);
  }

  public ResponseGetForgeState getForgeState(RequestGetForgeState request) {
    return stateRpcBlockingStub.getForgeState(request);
  }

  public ListenableFuture<ResponseGetForgeState> asyncGetForgeState(RequestGetForgeState request) {
    return stateRpcFutureStub.getForgeState(request);
  }

  public void rxGetForgeState(RequestGetForgeState request,
      StreamObserver<ResponseGetForgeState> observer) {
    stateRpcStub.getForgeState(request, observer);
  }

  public StreamObserver<RequestGetProtocolState> getProtocolState(
      StreamObserver<ResponseGetProtocolState> observer) {
    return stateRpcStub.getProtocolState(observer);
  }

  public StreamObserver<RequestGetStakeState> getStakeState(
      StreamObserver<ResponseGetStakeState> observer) {
    return stateRpcStub.getStakeState(observer);
  }

  public StreamObserver<RequestGetTetherState> getTetherState(
      StreamObserver<ResponseGetTetherState> observer) {
    return stateRpcStub.getTetherState(observer);
  }

  public ResponseCreateWallet createWallet(RequestCreateWallet request) {
    return walletRpcBlockingStub.createWallet(request);
  }

  public ListenableFuture<ResponseCreateWallet> asyncCreateWallet(RequestCreateWallet request) {
    return walletRpcFutureStub.createWallet(request);
  }

  public void rxCreateWallet(RequestCreateWallet request,
      StreamObserver<ResponseCreateWallet> observer) {
    walletRpcStub.createWallet(request, observer);
  }

  public ResponseLoadWallet loadWallet(RequestLoadWallet request) {
    return walletRpcBlockingStub.loadWallet(request);
  }

  public ListenableFuture<ResponseLoadWallet> asyncLoadWallet(RequestLoadWallet request) {
    return walletRpcFutureStub.loadWallet(request);
  }

  public void rxLoadWallet(RequestLoadWallet request, StreamObserver<ResponseLoadWallet> observer) {
    walletRpcStub.loadWallet(request, observer);
  }

  public ResponseRecoverWallet recoverWallet(RequestRecoverWallet request) {
    return walletRpcBlockingStub.recoverWallet(request);
  }

  public ListenableFuture<ResponseRecoverWallet> asyncRecoverWallet(RequestRecoverWallet request) {
    return walletRpcFutureStub.recoverWallet(request);
  }

  public void rxRecoverWallet(RequestRecoverWallet request,
      StreamObserver<ResponseRecoverWallet> observer) {
    walletRpcStub.recoverWallet(request, observer);
  }

  public void listWallet(RequestListWallet request, StreamObserver<ResponseListWallet> observer) {
    walletRpcStub.listWallet(request, observer);
  }

  public ResponseRemoveWallet removeWallet(RequestRemoveWallet request) {
    return walletRpcBlockingStub.removeWallet(request);
  }

  public ListenableFuture<ResponseRemoveWallet> asyncRemoveWallet(RequestRemoveWallet request) {
    return walletRpcFutureStub.removeWallet(request);
  }

  public void rxRemoveWallet(RequestRemoveWallet request,
      StreamObserver<ResponseRemoveWallet> observer) {
    walletRpcStub.removeWallet(request, observer);
  }

  public ResponseDeclareNode declareNode(RequestDeclareNode request) {
    return walletRpcBlockingStub.declareNode(request);
  }

  public ListenableFuture<ResponseDeclareNode> asyncDeclareNode(RequestDeclareNode request) {
    return walletRpcFutureStub.declareNode(request);
  }

  public void rxDeclareNode(RequestDeclareNode request,
      StreamObserver<ResponseDeclareNode> observer) {
    walletRpcStub.declareNode(request, observer);
  }

  public StreamObserver<RequestStoreFile> storeFile(StreamObserver<ResponseStoreFile> observer) {
    return fileRpcStub.storeFile(observer);
  }

  public void loadFile(RequestLoadFile request, StreamObserver<ResponseLoadFile> observer) {
    fileRpcStub.loadFile(request, observer);
  }

  public ResponsePinFile pinFile(RequestPinFile request) {
    return fileRpcBlockingStub.pinFile(request);
  }

  public ListenableFuture<ResponsePinFile> asyncPinFile(RequestPinFile request) {
    return fileRpcFutureStub.pinFile(request);
  }

  public void rxPinFile(RequestPinFile request, StreamObserver<ResponsePinFile> observer) {
    fileRpcStub.pinFile(request, observer);
  }

  public void init(ManagedChannelBuilder builder) {
    channel =  builder.build();chainRpcBlockingStub = ChainRpcGrpc.newBlockingStub(channel);
    chainRpcStub = ChainRpcGrpc.newStub(channel);
    chainRpcFutureStub = ChainRpcGrpc.newFutureStub(channel);
    statsRpcBlockingStub = StatsRpcGrpc.newBlockingStub(channel);
    statsRpcStub = StatsRpcGrpc.newStub(channel);
    statsRpcFutureStub = StatsRpcGrpc.newFutureStub(channel);
    eventRpcBlockingStub = EventRpcGrpc.newBlockingStub(channel);
    eventRpcStub = EventRpcGrpc.newStub(channel);
    eventRpcFutureStub = EventRpcGrpc.newFutureStub(channel);
    stateRpcBlockingStub = StateRpcGrpc.newBlockingStub(channel);
    stateRpcStub = StateRpcGrpc.newStub(channel);
    stateRpcFutureStub = StateRpcGrpc.newFutureStub(channel);
    walletRpcBlockingStub = WalletRpcGrpc.newBlockingStub(channel);
    walletRpcStub = WalletRpcGrpc.newStub(channel);
    walletRpcFutureStub = WalletRpcGrpc.newFutureStub(channel);
    fileRpcBlockingStub = FileRpcGrpc.newBlockingStub(channel);
    fileRpcStub = FileRpcGrpc.newStub(channel);
    fileRpcFutureStub = FileRpcGrpc.newFutureStub(channel);
  }

  private void init(String host, Integer port) {
    init(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true));
  }

  public static ForgeSDK connect(String host, Integer port) {
    Holder.INSTANCE.init(host, port);
    return Holder.INSTANCE;
  }

  public static ForgeSDK connect(ManagedChannelBuilder builder) {
    Holder.INSTANCE.init(builder);
    return Holder.INSTANCE;
  }

  public void shutdown() throws InterruptedException {
    channel.awaitTermination(6, TimeUnit.SECONDS);
  }

  private static class Holder {
    private static final ForgeSDK INSTANCE = new ForgeSDK();
  }
}
