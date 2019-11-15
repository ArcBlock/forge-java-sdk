package forge_abi;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: service.proto")
public final class StatsRpcGrpc {

  private StatsRpcGrpc() {}

  public static final String SERVICE_NAME = "forge_abi.StatsRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetForgeStats,
      forge_abi.Rpc.ResponseGetForgeStats> METHOD_GET_FORGE_STATS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetForgeStats, forge_abi.Rpc.ResponseGetForgeStats>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "get_forge_stats"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetForgeStats.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetForgeStats.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListTransactions,
      forge_abi.Rpc.ResponseListTransactions> METHOD_LIST_TRANSACTIONS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListTransactions, forge_abi.Rpc.ResponseListTransactions>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "list_transactions"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListTransactions.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListTransactions.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListAssets,
      forge_abi.Rpc.ResponseListAssets> METHOD_LIST_ASSETS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListAssets, forge_abi.Rpc.ResponseListAssets>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "list_assets"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListAssets.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListAssets.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListStakes,
      forge_abi.Rpc.ResponseListStakes> METHOD_LIST_STAKES =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListStakes, forge_abi.Rpc.ResponseListStakes>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "list_stakes"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListStakes.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListStakes.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListAccount,
      forge_abi.Rpc.ResponseListAccount> METHOD_LIST_ACCOUNT =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListAccount, forge_abi.Rpc.ResponseListAccount>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "list_account"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListAccount.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListAccount.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListTopAccounts,
      forge_abi.Rpc.ResponseListTopAccounts> METHOD_LIST_TOP_ACCOUNTS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListTopAccounts, forge_abi.Rpc.ResponseListTopAccounts>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "list_top_accounts"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListTopAccounts.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListTopAccounts.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListAssetTransactions,
      forge_abi.Rpc.ResponseListAssetTransactions> METHOD_LIST_ASSET_TRANSACTIONS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListAssetTransactions, forge_abi.Rpc.ResponseListAssetTransactions>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "list_asset_transactions"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListAssetTransactions.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListAssetTransactions.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListBlocks,
      forge_abi.Rpc.ResponseListBlocks> METHOD_LIST_BLOCKS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListBlocks, forge_abi.Rpc.ResponseListBlocks>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "list_blocks"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListBlocks.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListBlocks.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetHealthStatus,
      forge_abi.Rpc.ResponseGetHealthStatus> METHOD_GET_HEALTH_STATUS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetHealthStatus, forge_abi.Rpc.ResponseGetHealthStatus>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "get_health_status"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetHealthStatus.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetHealthStatus.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListSwap,
      forge_abi.Rpc.ResponseListSwap> METHOD_LIST_SWAP =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListSwap, forge_abi.Rpc.ResponseListSwap>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatsRpc", "list_swap"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListSwap.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListSwap.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StatsRpcStub newStub(io.grpc.Channel channel) {
    return new StatsRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StatsRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StatsRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StatsRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StatsRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class StatsRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void getForgeStats(forge_abi.Rpc.RequestGetForgeStats request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetForgeStats> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FORGE_STATS, responseObserver);
    }

    /**
     */
    public void listTransactions(forge_abi.Rpc.RequestListTransactions request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListTransactions> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_TRANSACTIONS, responseObserver);
    }

    /**
     */
    public void listAssets(forge_abi.Rpc.RequestListAssets request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssets> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_ASSETS, responseObserver);
    }

    /**
     */
    public void listStakes(forge_abi.Rpc.RequestListStakes request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListStakes> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_STAKES, responseObserver);
    }

    /**
     */
    public void listAccount(forge_abi.Rpc.RequestListAccount request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAccount> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_ACCOUNT, responseObserver);
    }

    /**
     */
    public void listTopAccounts(forge_abi.Rpc.RequestListTopAccounts request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListTopAccounts> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_TOP_ACCOUNTS, responseObserver);
    }

    /**
     */
    public void listAssetTransactions(forge_abi.Rpc.RequestListAssetTransactions request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssetTransactions> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_ASSET_TRANSACTIONS, responseObserver);
    }

    /**
     */
    public void listBlocks(forge_abi.Rpc.RequestListBlocks request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListBlocks> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_BLOCKS, responseObserver);
    }

    /**
     */
    public void getHealthStatus(forge_abi.Rpc.RequestGetHealthStatus request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetHealthStatus> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_HEALTH_STATUS, responseObserver);
    }

    /**
     */
    public void listSwap(forge_abi.Rpc.RequestListSwap request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListSwap> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_SWAP, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_FORGE_STATS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetForgeStats,
                forge_abi.Rpc.ResponseGetForgeStats>(
                  this, METHODID_GET_FORGE_STATS)))
          .addMethod(
            METHOD_LIST_TRANSACTIONS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListTransactions,
                forge_abi.Rpc.ResponseListTransactions>(
                  this, METHODID_LIST_TRANSACTIONS)))
          .addMethod(
            METHOD_LIST_ASSETS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListAssets,
                forge_abi.Rpc.ResponseListAssets>(
                  this, METHODID_LIST_ASSETS)))
          .addMethod(
            METHOD_LIST_STAKES,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListStakes,
                forge_abi.Rpc.ResponseListStakes>(
                  this, METHODID_LIST_STAKES)))
          .addMethod(
            METHOD_LIST_ACCOUNT,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListAccount,
                forge_abi.Rpc.ResponseListAccount>(
                  this, METHODID_LIST_ACCOUNT)))
          .addMethod(
            METHOD_LIST_TOP_ACCOUNTS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListTopAccounts,
                forge_abi.Rpc.ResponseListTopAccounts>(
                  this, METHODID_LIST_TOP_ACCOUNTS)))
          .addMethod(
            METHOD_LIST_ASSET_TRANSACTIONS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListAssetTransactions,
                forge_abi.Rpc.ResponseListAssetTransactions>(
                  this, METHODID_LIST_ASSET_TRANSACTIONS)))
          .addMethod(
            METHOD_LIST_BLOCKS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListBlocks,
                forge_abi.Rpc.ResponseListBlocks>(
                  this, METHODID_LIST_BLOCKS)))
          .addMethod(
            METHOD_GET_HEALTH_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetHealthStatus,
                forge_abi.Rpc.ResponseGetHealthStatus>(
                  this, METHODID_GET_HEALTH_STATUS)))
          .addMethod(
            METHOD_LIST_SWAP,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListSwap,
                forge_abi.Rpc.ResponseListSwap>(
                  this, METHODID_LIST_SWAP)))
          .build();
    }
  }

  /**
   */
  public static final class StatsRpcStub extends io.grpc.stub.AbstractStub<StatsRpcStub> {
    private StatsRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StatsRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatsRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StatsRpcStub(channel, callOptions);
    }

    /**
     */
    public void getForgeStats(forge_abi.Rpc.RequestGetForgeStats request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetForgeStats> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FORGE_STATS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listTransactions(forge_abi.Rpc.RequestListTransactions request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListTransactions> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_TRANSACTIONS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAssets(forge_abi.Rpc.RequestListAssets request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssets> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_ASSETS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listStakes(forge_abi.Rpc.RequestListStakes request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListStakes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_STAKES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAccount(forge_abi.Rpc.RequestListAccount request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAccount> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_ACCOUNT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listTopAccounts(forge_abi.Rpc.RequestListTopAccounts request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListTopAccounts> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_TOP_ACCOUNTS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAssetTransactions(forge_abi.Rpc.RequestListAssetTransactions request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssetTransactions> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_ASSET_TRANSACTIONS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listBlocks(forge_abi.Rpc.RequestListBlocks request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListBlocks> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_BLOCKS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHealthStatus(forge_abi.Rpc.RequestGetHealthStatus request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetHealthStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_HEALTH_STATUS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listSwap(forge_abi.Rpc.RequestListSwap request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListSwap> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_SWAP, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StatsRpcBlockingStub extends io.grpc.stub.AbstractStub<StatsRpcBlockingStub> {
    private StatsRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StatsRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatsRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StatsRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetForgeStats getForgeStats(forge_abi.Rpc.RequestGetForgeStats request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FORGE_STATS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseListTransactions listTransactions(forge_abi.Rpc.RequestListTransactions request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_TRANSACTIONS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseListAssets listAssets(forge_abi.Rpc.RequestListAssets request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_ASSETS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseListStakes listStakes(forge_abi.Rpc.RequestListStakes request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_STAKES, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseListAccount listAccount(forge_abi.Rpc.RequestListAccount request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_ACCOUNT, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseListTopAccounts listTopAccounts(forge_abi.Rpc.RequestListTopAccounts request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_TOP_ACCOUNTS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseListAssetTransactions listAssetTransactions(forge_abi.Rpc.RequestListAssetTransactions request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_ASSET_TRANSACTIONS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseListBlocks listBlocks(forge_abi.Rpc.RequestListBlocks request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_BLOCKS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetHealthStatus getHealthStatus(forge_abi.Rpc.RequestGetHealthStatus request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_HEALTH_STATUS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseListSwap listSwap(forge_abi.Rpc.RequestListSwap request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_SWAP, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StatsRpcFutureStub extends io.grpc.stub.AbstractStub<StatsRpcFutureStub> {
    private StatsRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StatsRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatsRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StatsRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetForgeStats> getForgeStats(
        forge_abi.Rpc.RequestGetForgeStats request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FORGE_STATS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseListTransactions> listTransactions(
        forge_abi.Rpc.RequestListTransactions request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_TRANSACTIONS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseListAssets> listAssets(
        forge_abi.Rpc.RequestListAssets request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_ASSETS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseListStakes> listStakes(
        forge_abi.Rpc.RequestListStakes request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_STAKES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseListAccount> listAccount(
        forge_abi.Rpc.RequestListAccount request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_ACCOUNT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseListTopAccounts> listTopAccounts(
        forge_abi.Rpc.RequestListTopAccounts request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_TOP_ACCOUNTS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseListAssetTransactions> listAssetTransactions(
        forge_abi.Rpc.RequestListAssetTransactions request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_ASSET_TRANSACTIONS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseListBlocks> listBlocks(
        forge_abi.Rpc.RequestListBlocks request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_BLOCKS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetHealthStatus> getHealthStatus(
        forge_abi.Rpc.RequestGetHealthStatus request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_HEALTH_STATUS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseListSwap> listSwap(
        forge_abi.Rpc.RequestListSwap request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_SWAP, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FORGE_STATS = 0;
  private static final int METHODID_LIST_TRANSACTIONS = 1;
  private static final int METHODID_LIST_ASSETS = 2;
  private static final int METHODID_LIST_STAKES = 3;
  private static final int METHODID_LIST_ACCOUNT = 4;
  private static final int METHODID_LIST_TOP_ACCOUNTS = 5;
  private static final int METHODID_LIST_ASSET_TRANSACTIONS = 6;
  private static final int METHODID_LIST_BLOCKS = 7;
  private static final int METHODID_GET_HEALTH_STATUS = 8;
  private static final int METHODID_LIST_SWAP = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StatsRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StatsRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FORGE_STATS:
          serviceImpl.getForgeStats((forge_abi.Rpc.RequestGetForgeStats) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetForgeStats>) responseObserver);
          break;
        case METHODID_LIST_TRANSACTIONS:
          serviceImpl.listTransactions((forge_abi.Rpc.RequestListTransactions) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListTransactions>) responseObserver);
          break;
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets((forge_abi.Rpc.RequestListAssets) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssets>) responseObserver);
          break;
        case METHODID_LIST_STAKES:
          serviceImpl.listStakes((forge_abi.Rpc.RequestListStakes) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListStakes>) responseObserver);
          break;
        case METHODID_LIST_ACCOUNT:
          serviceImpl.listAccount((forge_abi.Rpc.RequestListAccount) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAccount>) responseObserver);
          break;
        case METHODID_LIST_TOP_ACCOUNTS:
          serviceImpl.listTopAccounts((forge_abi.Rpc.RequestListTopAccounts) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListTopAccounts>) responseObserver);
          break;
        case METHODID_LIST_ASSET_TRANSACTIONS:
          serviceImpl.listAssetTransactions((forge_abi.Rpc.RequestListAssetTransactions) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssetTransactions>) responseObserver);
          break;
        case METHODID_LIST_BLOCKS:
          serviceImpl.listBlocks((forge_abi.Rpc.RequestListBlocks) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListBlocks>) responseObserver);
          break;
        case METHODID_GET_HEALTH_STATUS:
          serviceImpl.getHealthStatus((forge_abi.Rpc.RequestGetHealthStatus) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetHealthStatus>) responseObserver);
          break;
        case METHODID_LIST_SWAP:
          serviceImpl.listSwap((forge_abi.Rpc.RequestListSwap) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListSwap>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class StatsRpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return forge_abi.Service.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StatsRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StatsRpcDescriptorSupplier())
              .addMethod(METHOD_GET_FORGE_STATS)
              .addMethod(METHOD_LIST_TRANSACTIONS)
              .addMethod(METHOD_LIST_ASSETS)
              .addMethod(METHOD_LIST_STAKES)
              .addMethod(METHOD_LIST_ACCOUNT)
              .addMethod(METHOD_LIST_TOP_ACCOUNTS)
              .addMethod(METHOD_LIST_ASSET_TRANSACTIONS)
              .addMethod(METHOD_LIST_BLOCKS)
              .addMethod(METHOD_GET_HEALTH_STATUS)
              .addMethod(METHOD_LIST_SWAP)
              .build();
        }
      }
    }
    return result;
  }
}
