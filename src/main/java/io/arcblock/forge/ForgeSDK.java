// !!!! auto Generated ,Do not Edit !!!!
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
import forge_abi.Rpc.RequestGetAssetAddress;
import forge_abi.Rpc.RequestGetAssetState;
import forge_abi.Rpc.RequestGetAssets;
import forge_abi.Rpc.RequestGetBlock;
import forge_abi.Rpc.RequestGetBlocks;
import forge_abi.Rpc.RequestGetChainInfo;
import forge_abi.Rpc.RequestGetConfig;
import forge_abi.Rpc.RequestGetForgeState;
import forge_abi.Rpc.RequestGetForgeStatistics;
import forge_abi.Rpc.RequestGetHealthStatus;
import forge_abi.Rpc.RequestGetNetInfo;
import forge_abi.Rpc.RequestGetNodeInfo;
import forge_abi.Rpc.RequestGetSimulatorStatus;
import forge_abi.Rpc.RequestGetStakeState;
import forge_abi.Rpc.RequestGetStakes;
import forge_abi.Rpc.RequestGetTopAccounts;
import forge_abi.Rpc.RequestGetTx;
import forge_abi.Rpc.RequestGetUnconfirmedTxs;
import forge_abi.Rpc.RequestGetValidatorsInfo;
import forge_abi.Rpc.RequestListAssetTransactions;
import forge_abi.Rpc.RequestListAssets;
import forge_abi.Rpc.RequestListBlocks;
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
import forge_abi.Rpc.RequestSignData;
import forge_abi.Rpc.RequestStartSimulator;
import forge_abi.Rpc.RequestStopSimulator;
import forge_abi.Rpc.RequestStoreFile;
import forge_abi.Rpc.RequestSubscribe;
import forge_abi.Rpc.RequestUnsubscribe;
import forge_abi.Rpc.ResponseCreateTx;
import forge_abi.Rpc.ResponseCreateWallet;
import forge_abi.Rpc.ResponseDeclareNode;
import forge_abi.Rpc.ResponseGetAccountState;
import forge_abi.Rpc.ResponseGetAssetAddress;
import forge_abi.Rpc.ResponseGetAssetState;
import forge_abi.Rpc.ResponseGetAssets;
import forge_abi.Rpc.ResponseGetBlock;
import forge_abi.Rpc.ResponseGetBlocks;
import forge_abi.Rpc.ResponseGetChainInfo;
import forge_abi.Rpc.ResponseGetConfig;
import forge_abi.Rpc.ResponseGetForgeState;
import forge_abi.Rpc.ResponseGetForgeStatistics;
import forge_abi.Rpc.ResponseGetHealthStatus;
import forge_abi.Rpc.ResponseGetNetInfo;
import forge_abi.Rpc.ResponseGetNodeInfo;
import forge_abi.Rpc.ResponseGetSimulatorStatus;
import forge_abi.Rpc.ResponseGetStakeState;
import forge_abi.Rpc.ResponseGetStakes;
import forge_abi.Rpc.ResponseGetTopAccounts;
import forge_abi.Rpc.ResponseGetTx;
import forge_abi.Rpc.ResponseGetUnconfirmedTxs;
import forge_abi.Rpc.ResponseGetValidatorsInfo;
import forge_abi.Rpc.ResponseListAssetTransactions;
import forge_abi.Rpc.ResponseListAssets;
import forge_abi.Rpc.ResponseListBlocks;
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
import forge_abi.Rpc.ResponseSignData;
import forge_abi.Rpc.ResponseStartSimulator;
import forge_abi.Rpc.ResponseStopSimulator;
import forge_abi.Rpc.ResponseStoreFile;
import forge_abi.Rpc.ResponseSubscribe;
import forge_abi.Rpc.ResponseUnsubscribe;
import forge_abi.StateRpcGrpc;
import forge_abi.StateRpcGrpc.StateRpcBlockingStub;
import forge_abi.StateRpcGrpc.StateRpcFutureStub;
import forge_abi.StateRpcGrpc.StateRpcStub;
import forge_abi.StatisticRpcGrpc;
import forge_abi.StatisticRpcGrpc.StatisticRpcBlockingStub;
import forge_abi.StatisticRpcGrpc.StatisticRpcFutureStub;
import forge_abi.StatisticRpcGrpc.StatisticRpcStub;
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

public final class ForgeSDK {
  private ManagedChannel channel;

  private ChainRpcBlockingStub chainRpcBlockingStub;

  private ChainRpcStub chainRpcStub;

  private ChainRpcFutureStub chainRpcFutureStub;

  private EventRpcBlockingStub eventRpcBlockingStub;

  private EventRpcStub eventRpcStub;

  private EventRpcFutureStub eventRpcFutureStub;

  private StateRpcBlockingStub stateRpcBlockingStub;

  private StateRpcStub stateRpcStub;

  private StateRpcFutureStub stateRpcFutureStub;

  private WalletRpcBlockingStub walletRpcBlockingStub;

  private WalletRpcStub walletRpcStub;

  private WalletRpcFutureStub walletRpcFutureStub;

  private StatisticRpcBlockingStub statisticRpcBlockingStub;

  private StatisticRpcStub statisticRpcStub;

  private StatisticRpcFutureStub statisticRpcFutureStub;

  private FileRpcBlockingStub fileRpcBlockingStub;

  private FileRpcStub fileRpcStub;

  private FileRpcFutureStub fileRpcFutureStub;

  public ResponseCreateTx createTx(RequestCreateTx request) {
    return chainRpcBlockingStub.createTx(request);
  }

  public ListenableFuture<ResponseCreateTx> asyncCreatetx(RequestCreateTx request) {
    return chainRpcFutureStub.createTx(request);
  }

  public void rxCreatetx(RequestCreateTx request, StreamObserver<ResponseCreateTx> observer) {
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

  public ListenableFuture<ResponseSendTx> asyncSendtx(RequestSendTx request) {
    return chainRpcFutureStub.sendTx(request);
  }

  public void rxSendtx(RequestSendTx request, StreamObserver<ResponseSendTx> observer) {
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

  public ListenableFuture<ResponseGetBlocks> asyncGetblocks(RequestGetBlocks request) {
    return chainRpcFutureStub.getBlocks(request);
  }

  public void rxGetblocks(RequestGetBlocks request, StreamObserver<ResponseGetBlocks> observer) {
    chainRpcStub.getBlocks(request, observer);
  }

  public ResponseGetUnconfirmedTxs getUnconfirmedTxs(RequestGetUnconfirmedTxs request) {
    return chainRpcBlockingStub.getUnconfirmedTxs(request);
  }

  public ListenableFuture<ResponseGetUnconfirmedTxs> asyncGetunconfirmedtxs(
      RequestGetUnconfirmedTxs request) {
    return chainRpcFutureStub.getUnconfirmedTxs(request);
  }

  public void rxGetunconfirmedtxs(RequestGetUnconfirmedTxs request,
      StreamObserver<ResponseGetUnconfirmedTxs> observer) {
    chainRpcStub.getUnconfirmedTxs(request, observer);
  }

  public ResponseGetChainInfo getChainInfo(RequestGetChainInfo request) {
    return chainRpcBlockingStub.getChainInfo(request);
  }

  public ListenableFuture<ResponseGetChainInfo> asyncGetchaininfo(RequestGetChainInfo request) {
    return chainRpcFutureStub.getChainInfo(request);
  }

  public void rxGetchaininfo(RequestGetChainInfo request,
      StreamObserver<ResponseGetChainInfo> observer) {
    chainRpcStub.getChainInfo(request, observer);
  }

  public ResponseGetNodeInfo getNodeInfo(RequestGetNodeInfo request) {
    return chainRpcBlockingStub.getNodeInfo(request);
  }

  public ListenableFuture<ResponseGetNodeInfo> asyncGetnodeinfo(RequestGetNodeInfo request) {
    return chainRpcFutureStub.getNodeInfo(request);
  }

  public void rxGetnodeinfo(RequestGetNodeInfo request,
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

  public ListenableFuture<ResponseGetNetInfo> asyncGetnetinfo(RequestGetNetInfo request) {
    return chainRpcFutureStub.getNetInfo(request);
  }

  public void rxGetnetinfo(RequestGetNetInfo request, StreamObserver<ResponseGetNetInfo> observer) {
    chainRpcStub.getNetInfo(request, observer);
  }

  public ResponseGetValidatorsInfo getValidatorsInfo(RequestGetValidatorsInfo request) {
    return chainRpcBlockingStub.getValidatorsInfo(request);
  }

  public ListenableFuture<ResponseGetValidatorsInfo> asyncGetvalidatorsinfo(
      RequestGetValidatorsInfo request) {
    return chainRpcFutureStub.getValidatorsInfo(request);
  }

  public void rxGetvalidatorsinfo(RequestGetValidatorsInfo request,
      StreamObserver<ResponseGetValidatorsInfo> observer) {
    chainRpcStub.getValidatorsInfo(request, observer);
  }

  public ResponseGetConfig getConfig(RequestGetConfig request) {
    return chainRpcBlockingStub.getConfig(request);
  }

  public ListenableFuture<ResponseGetConfig> asyncGetconfig(RequestGetConfig request) {
    return chainRpcFutureStub.getConfig(request);
  }

  public void rxGetconfig(RequestGetConfig request, StreamObserver<ResponseGetConfig> observer) {
    chainRpcStub.getConfig(request, observer);
  }

  public ResponseGetAssetAddress getAssetAddress(RequestGetAssetAddress request) {
    return chainRpcBlockingStub.getAssetAddress(request);
  }

  public ListenableFuture<ResponseGetAssetAddress> asyncGetassetaddress(
      RequestGetAssetAddress request) {
    return chainRpcFutureStub.getAssetAddress(request);
  }

  public void rxGetassetaddress(RequestGetAssetAddress request,
      StreamObserver<ResponseGetAssetAddress> observer) {
    chainRpcStub.getAssetAddress(request, observer);
  }

  public ResponseSignData signData(RequestSignData request) {
    return chainRpcBlockingStub.signData(request);
  }

  public ListenableFuture<ResponseSignData> asyncSigndata(RequestSignData request) {
    return chainRpcFutureStub.signData(request);
  }

  public void rxSigndata(RequestSignData request, StreamObserver<ResponseSignData> observer) {
    chainRpcStub.signData(request, observer);
  }

  public ResponseStartSimulator startSimulator(RequestStartSimulator request) {
    return chainRpcBlockingStub.startSimulator(request);
  }

  public ListenableFuture<ResponseStartSimulator> asyncStartsimulator(
      RequestStartSimulator request) {
    return chainRpcFutureStub.startSimulator(request);
  }

  public void rxStartsimulator(RequestStartSimulator request,
      StreamObserver<ResponseStartSimulator> observer) {
    chainRpcStub.startSimulator(request, observer);
  }

  public ResponseStopSimulator stopSimulator(RequestStopSimulator request) {
    return chainRpcBlockingStub.stopSimulator(request);
  }

  public ListenableFuture<ResponseStopSimulator> asyncStopsimulator(RequestStopSimulator request) {
    return chainRpcFutureStub.stopSimulator(request);
  }

  public void rxStopsimulator(RequestStopSimulator request,
      StreamObserver<ResponseStopSimulator> observer) {
    chainRpcStub.stopSimulator(request, observer);
  }

  public ResponseGetSimulatorStatus getSimulatorStatus(RequestGetSimulatorStatus request) {
    return chainRpcBlockingStub.getSimulatorStatus(request);
  }

  public ListenableFuture<ResponseGetSimulatorStatus> asyncGetsimulatorstatus(
      RequestGetSimulatorStatus request) {
    return chainRpcFutureStub.getSimulatorStatus(request);
  }

  public void rxGetsimulatorstatus(RequestGetSimulatorStatus request,
      StreamObserver<ResponseGetSimulatorStatus> observer) {
    chainRpcStub.getSimulatorStatus(request, observer);
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

  public StreamObserver<RequestGetStakeState> getStakeState(
      StreamObserver<ResponseGetStakeState> observer) {
    return stateRpcStub.getStakeState(observer);
  }

  public ResponseGetForgeState getForgeState(RequestGetForgeState request) {
    return stateRpcBlockingStub.getForgeState(request);
  }

  public ListenableFuture<ResponseGetForgeState> asyncGetforgestate(RequestGetForgeState request) {
    return stateRpcFutureStub.getForgeState(request);
  }

  public void rxGetforgestate(RequestGetForgeState request,
      StreamObserver<ResponseGetForgeState> observer) {
    stateRpcStub.getForgeState(request, observer);
  }

  public ResponseCreateWallet createWallet(RequestCreateWallet request) {
    return walletRpcBlockingStub.createWallet(request);
  }

  public ListenableFuture<ResponseCreateWallet> asyncCreatewallet(RequestCreateWallet request) {
    return walletRpcFutureStub.createWallet(request);
  }

  public void rxCreatewallet(RequestCreateWallet request,
      StreamObserver<ResponseCreateWallet> observer) {
    walletRpcStub.createWallet(request, observer);
  }

  public ResponseLoadWallet loadWallet(RequestLoadWallet request) {
    return walletRpcBlockingStub.loadWallet(request);
  }

  public ListenableFuture<ResponseLoadWallet> asyncLoadwallet(RequestLoadWallet request) {
    return walletRpcFutureStub.loadWallet(request);
  }

  public void rxLoadwallet(RequestLoadWallet request, StreamObserver<ResponseLoadWallet> observer) {
    walletRpcStub.loadWallet(request, observer);
  }

  public ResponseRecoverWallet recoverWallet(RequestRecoverWallet request) {
    return walletRpcBlockingStub.recoverWallet(request);
  }

  public ListenableFuture<ResponseRecoverWallet> asyncRecoverwallet(RequestRecoverWallet request) {
    return walletRpcFutureStub.recoverWallet(request);
  }

  public void rxRecoverwallet(RequestRecoverWallet request,
      StreamObserver<ResponseRecoverWallet> observer) {
    walletRpcStub.recoverWallet(request, observer);
  }

  public void listWallet(RequestListWallet request, StreamObserver<ResponseListWallet> observer) {
    walletRpcStub.listWallet(request, observer);
  }

  public ResponseRemoveWallet removeWallet(RequestRemoveWallet request) {
    return walletRpcBlockingStub.removeWallet(request);
  }

  public ListenableFuture<ResponseRemoveWallet> asyncRemovewallet(RequestRemoveWallet request) {
    return walletRpcFutureStub.removeWallet(request);
  }

  public void rxRemovewallet(RequestRemoveWallet request,
      StreamObserver<ResponseRemoveWallet> observer) {
    walletRpcStub.removeWallet(request, observer);
  }

  public ResponseDeclareNode declareNode(RequestDeclareNode request) {
    return walletRpcBlockingStub.declareNode(request);
  }

  public ListenableFuture<ResponseDeclareNode> asyncDeclarenode(RequestDeclareNode request) {
    return walletRpcFutureStub.declareNode(request);
  }

  public void rxDeclarenode(RequestDeclareNode request,
      StreamObserver<ResponseDeclareNode> observer) {
    walletRpcStub.declareNode(request, observer);
  }

  public ResponseGetForgeStatistics getForgeStatistics(RequestGetForgeStatistics request) {
    return statisticRpcBlockingStub.getForgeStatistics(request);
  }

  public ListenableFuture<ResponseGetForgeStatistics> asyncGetforgestatistics(
      RequestGetForgeStatistics request) {
    return statisticRpcFutureStub.getForgeStatistics(request);
  }

  public void rxGetforgestatistics(RequestGetForgeStatistics request,
      StreamObserver<ResponseGetForgeStatistics> observer) {
    statisticRpcStub.getForgeStatistics(request, observer);
  }

  public ResponseListTransactions listTransactions(RequestListTransactions request) {
    return statisticRpcBlockingStub.listTransactions(request);
  }

  public ListenableFuture<ResponseListTransactions> asyncListtransactions(
      RequestListTransactions request) {
    return statisticRpcFutureStub.listTransactions(request);
  }

  public void rxListtransactions(RequestListTransactions request,
      StreamObserver<ResponseListTransactions> observer) {
    statisticRpcStub.listTransactions(request, observer);
  }

  public ResponseGetAssets getAssets(RequestGetAssets request) {
    return statisticRpcBlockingStub.getAssets(request);
  }

  public ListenableFuture<ResponseGetAssets> asyncGetassets(RequestGetAssets request) {
    return statisticRpcFutureStub.getAssets(request);
  }

  public void rxGetassets(RequestGetAssets request, StreamObserver<ResponseGetAssets> observer) {
    statisticRpcStub.getAssets(request, observer);
  }

  public ResponseGetStakes getStakes(RequestGetStakes request) {
    return statisticRpcBlockingStub.getStakes(request);
  }

  public ListenableFuture<ResponseGetStakes> asyncGetstakes(RequestGetStakes request) {
    return statisticRpcFutureStub.getStakes(request);
  }

  public void rxGetstakes(RequestGetStakes request, StreamObserver<ResponseGetStakes> observer) {
    statisticRpcStub.getStakes(request, observer);
  }

  public ResponseGetTopAccounts getTopAccounts(RequestGetTopAccounts request) {
    return statisticRpcBlockingStub.getTopAccounts(request);
  }

  public ListenableFuture<ResponseGetTopAccounts> asyncGettopaccounts(
      RequestGetTopAccounts request) {
    return statisticRpcFutureStub.getTopAccounts(request);
  }

  public void rxGettopaccounts(RequestGetTopAccounts request,
      StreamObserver<ResponseGetTopAccounts> observer) {
    statisticRpcStub.getTopAccounts(request, observer);
  }

  public ResponseListAssetTransactions listAssetTransactions(RequestListAssetTransactions request) {
    return statisticRpcBlockingStub.listAssetTransactions(request);
  }

  public ListenableFuture<ResponseListAssetTransactions> asyncListassettransactions(
      RequestListAssetTransactions request) {
    return statisticRpcFutureStub.listAssetTransactions(request);
  }

  public void rxListassettransactions(RequestListAssetTransactions request,
      StreamObserver<ResponseListAssetTransactions> observer) {
    statisticRpcStub.listAssetTransactions(request, observer);
  }

  public ResponseListBlocks listBlocks(RequestListBlocks request) {
    return statisticRpcBlockingStub.listBlocks(request);
  }

  public ListenableFuture<ResponseListBlocks> asyncListblocks(RequestListBlocks request) {
    return statisticRpcFutureStub.listBlocks(request);
  }

  public void rxListblocks(RequestListBlocks request, StreamObserver<ResponseListBlocks> observer) {
    statisticRpcStub.listBlocks(request, observer);
  }

  public ResponseListAssets listAssets(RequestListAssets request) {
    return statisticRpcBlockingStub.listAssets(request);
  }

  public ListenableFuture<ResponseListAssets> asyncListassets(RequestListAssets request) {
    return statisticRpcFutureStub.listAssets(request);
  }

  public void rxListassets(RequestListAssets request, StreamObserver<ResponseListAssets> observer) {
    statisticRpcStub.listAssets(request, observer);
  }

  public ResponseGetHealthStatus getHealthStatus(RequestGetHealthStatus request) {
    return statisticRpcBlockingStub.getHealthStatus(request);
  }

  public ListenableFuture<ResponseGetHealthStatus> asyncGethealthstatus(
      RequestGetHealthStatus request) {
    return statisticRpcFutureStub.getHealthStatus(request);
  }

  public void rxGethealthstatus(RequestGetHealthStatus request,
      StreamObserver<ResponseGetHealthStatus> observer) {
    statisticRpcStub.getHealthStatus(request, observer);
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

  public ListenableFuture<ResponsePinFile> asyncPinfile(RequestPinFile request) {
    return fileRpcFutureStub.pinFile(request);
  }

  public void rxPinfile(RequestPinFile request, StreamObserver<ResponsePinFile> observer) {
    fileRpcStub.pinFile(request, observer);
  }

  public void init(ManagedChannelBuilder builder) {
    channel =  builder.build();chainRpcBlockingStub = ChainRpcGrpc.newBlockingStub(channel);
    chainRpcStub = ChainRpcGrpc.newStub(channel);
    chainRpcFutureStub = ChainRpcGrpc.newFutureStub(channel);
    eventRpcBlockingStub = EventRpcGrpc.newBlockingStub(channel);
    eventRpcStub = EventRpcGrpc.newStub(channel);
    eventRpcFutureStub = EventRpcGrpc.newFutureStub(channel);
    stateRpcBlockingStub = StateRpcGrpc.newBlockingStub(channel);
    stateRpcStub = StateRpcGrpc.newStub(channel);
    stateRpcFutureStub = StateRpcGrpc.newFutureStub(channel);
    walletRpcBlockingStub = WalletRpcGrpc.newBlockingStub(channel);
    walletRpcStub = WalletRpcGrpc.newStub(channel);
    walletRpcFutureStub = WalletRpcGrpc.newFutureStub(channel);
    statisticRpcBlockingStub = StatisticRpcGrpc.newBlockingStub(channel);
    statisticRpcStub = StatisticRpcGrpc.newStub(channel);
    statisticRpcFutureStub = StatisticRpcGrpc.newFutureStub(channel);
    fileRpcBlockingStub = FileRpcGrpc.newBlockingStub(channel);
    fileRpcStub = FileRpcGrpc.newStub(channel);
    fileRpcFutureStub = FileRpcGrpc.newFutureStub(channel);
  }

  private void init(String host, Integer port) {
    init(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true));
  }

  public static ForgeSDK getInstance(String host, Integer port) {
    Holder.INSTANCE.init(host, port);
    return Holder.INSTANCE;
  }

  public static ForgeSDK getInstance(ManagedChannelBuilder builder) {
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
