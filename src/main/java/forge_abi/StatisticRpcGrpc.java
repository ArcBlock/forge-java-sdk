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
public final class StatisticRpcGrpc {

  private StatisticRpcGrpc() {}

  public static final String SERVICE_NAME = "forge_abi.StatisticRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetForgeStatistics,
      forge_abi.Rpc.ResponseGetForgeStatistics> METHOD_GET_FORGE_STATISTICS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetForgeStatistics, forge_abi.Rpc.ResponseGetForgeStatistics>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatisticRpc", "get_forge_statistics"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetForgeStatistics.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetForgeStatistics.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListTransactions,
      forge_abi.Rpc.ResponseListTransactions> METHOD_LIST_TRANSACTIONS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListTransactions, forge_abi.Rpc.ResponseListTransactions>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatisticRpc", "list_transactions"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListTransactions.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListTransactions.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetAssets,
      forge_abi.Rpc.ResponseGetAssets> METHOD_GET_ASSETS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetAssets, forge_abi.Rpc.ResponseGetAssets>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatisticRpc", "get_assets"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetAssets.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetAssets.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetStakes,
      forge_abi.Rpc.ResponseGetStakes> METHOD_GET_STAKES =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetStakes, forge_abi.Rpc.ResponseGetStakes>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatisticRpc", "get_stakes"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetStakes.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetStakes.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetTopAccounts,
      forge_abi.Rpc.ResponseGetTopAccounts> METHOD_GET_TOP_ACCOUNTS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetTopAccounts, forge_abi.Rpc.ResponseGetTopAccounts>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatisticRpc", "get_top_accounts"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetTopAccounts.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetTopAccounts.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListAssetTransactions,
      forge_abi.Rpc.ResponseListAssetTransactions> METHOD_LIST_ASSET_TRANSACTIONS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListAssetTransactions, forge_abi.Rpc.ResponseListAssetTransactions>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatisticRpc", "list_asset_transactions"))
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
              "forge_abi.StatisticRpc", "list_blocks"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListBlocks.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListBlocks.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListAssets,
      forge_abi.Rpc.ResponseListAssets> METHOD_LIST_ASSETS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListAssets, forge_abi.Rpc.ResponseListAssets>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatisticRpc", "list_assets"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListAssets.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListAssets.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetHealthStatus,
      forge_abi.Rpc.ResponseGetHealthStatus> METHOD_GET_HEALTH_STATUS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetHealthStatus, forge_abi.Rpc.ResponseGetHealthStatus>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StatisticRpc", "get_health_status"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetHealthStatus.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetHealthStatus.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StatisticRpcStub newStub(io.grpc.Channel channel) {
    return new StatisticRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StatisticRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StatisticRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StatisticRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StatisticRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class StatisticRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void getForgeStatistics(forge_abi.Rpc.RequestGetForgeStatistics request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetForgeStatistics> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FORGE_STATISTICS, responseObserver);
    }

    /**
     */
    public void listTransactions(forge_abi.Rpc.RequestListTransactions request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListTransactions> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_TRANSACTIONS, responseObserver);
    }

    /**
     */
    public void getAssets(forge_abi.Rpc.RequestGetAssets request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAssets> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ASSETS, responseObserver);
    }

    /**
     */
    public void getStakes(forge_abi.Rpc.RequestGetStakes request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetStakes> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_STAKES, responseObserver);
    }

    /**
     */
    public void getTopAccounts(forge_abi.Rpc.RequestGetTopAccounts request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetTopAccounts> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_TOP_ACCOUNTS, responseObserver);
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
    public void listAssets(forge_abi.Rpc.RequestListAssets request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssets> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_ASSETS, responseObserver);
    }

    /**
     */
    public void getHealthStatus(forge_abi.Rpc.RequestGetHealthStatus request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetHealthStatus> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_HEALTH_STATUS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_FORGE_STATISTICS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetForgeStatistics,
                forge_abi.Rpc.ResponseGetForgeStatistics>(
                  this, METHODID_GET_FORGE_STATISTICS)))
          .addMethod(
            METHOD_LIST_TRANSACTIONS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListTransactions,
                forge_abi.Rpc.ResponseListTransactions>(
                  this, METHODID_LIST_TRANSACTIONS)))
          .addMethod(
            METHOD_GET_ASSETS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetAssets,
                forge_abi.Rpc.ResponseGetAssets>(
                  this, METHODID_GET_ASSETS)))
          .addMethod(
            METHOD_GET_STAKES,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetStakes,
                forge_abi.Rpc.ResponseGetStakes>(
                  this, METHODID_GET_STAKES)))
          .addMethod(
            METHOD_GET_TOP_ACCOUNTS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetTopAccounts,
                forge_abi.Rpc.ResponseGetTopAccounts>(
                  this, METHODID_GET_TOP_ACCOUNTS)))
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
            METHOD_LIST_ASSETS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListAssets,
                forge_abi.Rpc.ResponseListAssets>(
                  this, METHODID_LIST_ASSETS)))
          .addMethod(
            METHOD_GET_HEALTH_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetHealthStatus,
                forge_abi.Rpc.ResponseGetHealthStatus>(
                  this, METHODID_GET_HEALTH_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class StatisticRpcStub extends io.grpc.stub.AbstractStub<StatisticRpcStub> {
    private StatisticRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StatisticRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatisticRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StatisticRpcStub(channel, callOptions);
    }

    /**
     */
    public void getForgeStatistics(forge_abi.Rpc.RequestGetForgeStatistics request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetForgeStatistics> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FORGE_STATISTICS, getCallOptions()), request, responseObserver);
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
    public void getAssets(forge_abi.Rpc.RequestGetAssets request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAssets> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ASSETS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStakes(forge_abi.Rpc.RequestGetStakes request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetStakes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_STAKES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTopAccounts(forge_abi.Rpc.RequestGetTopAccounts request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetTopAccounts> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TOP_ACCOUNTS, getCallOptions()), request, responseObserver);
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
    public void listAssets(forge_abi.Rpc.RequestListAssets request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssets> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIST_ASSETS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getHealthStatus(forge_abi.Rpc.RequestGetHealthStatus request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetHealthStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_HEALTH_STATUS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StatisticRpcBlockingStub extends io.grpc.stub.AbstractStub<StatisticRpcBlockingStub> {
    private StatisticRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StatisticRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatisticRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StatisticRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetForgeStatistics getForgeStatistics(forge_abi.Rpc.RequestGetForgeStatistics request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FORGE_STATISTICS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseListTransactions listTransactions(forge_abi.Rpc.RequestListTransactions request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_TRANSACTIONS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetAssets getAssets(forge_abi.Rpc.RequestGetAssets request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ASSETS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetStakes getStakes(forge_abi.Rpc.RequestGetStakes request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_STAKES, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetTopAccounts getTopAccounts(forge_abi.Rpc.RequestGetTopAccounts request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_TOP_ACCOUNTS, getCallOptions(), request);
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
    public forge_abi.Rpc.ResponseListAssets listAssets(forge_abi.Rpc.RequestListAssets request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIST_ASSETS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetHealthStatus getHealthStatus(forge_abi.Rpc.RequestGetHealthStatus request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_HEALTH_STATUS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StatisticRpcFutureStub extends io.grpc.stub.AbstractStub<StatisticRpcFutureStub> {
    private StatisticRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StatisticRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatisticRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StatisticRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetForgeStatistics> getForgeStatistics(
        forge_abi.Rpc.RequestGetForgeStatistics request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FORGE_STATISTICS, getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetAssets> getAssets(
        forge_abi.Rpc.RequestGetAssets request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ASSETS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetStakes> getStakes(
        forge_abi.Rpc.RequestGetStakes request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_STAKES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetTopAccounts> getTopAccounts(
        forge_abi.Rpc.RequestGetTopAccounts request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TOP_ACCOUNTS, getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseListAssets> listAssets(
        forge_abi.Rpc.RequestListAssets request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIST_ASSETS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetHealthStatus> getHealthStatus(
        forge_abi.Rpc.RequestGetHealthStatus request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_HEALTH_STATUS, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FORGE_STATISTICS = 0;
  private static final int METHODID_LIST_TRANSACTIONS = 1;
  private static final int METHODID_GET_ASSETS = 2;
  private static final int METHODID_GET_STAKES = 3;
  private static final int METHODID_GET_TOP_ACCOUNTS = 4;
  private static final int METHODID_LIST_ASSET_TRANSACTIONS = 5;
  private static final int METHODID_LIST_BLOCKS = 6;
  private static final int METHODID_LIST_ASSETS = 7;
  private static final int METHODID_GET_HEALTH_STATUS = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StatisticRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StatisticRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FORGE_STATISTICS:
          serviceImpl.getForgeStatistics((forge_abi.Rpc.RequestGetForgeStatistics) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetForgeStatistics>) responseObserver);
          break;
        case METHODID_LIST_TRANSACTIONS:
          serviceImpl.listTransactions((forge_abi.Rpc.RequestListTransactions) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListTransactions>) responseObserver);
          break;
        case METHODID_GET_ASSETS:
          serviceImpl.getAssets((forge_abi.Rpc.RequestGetAssets) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAssets>) responseObserver);
          break;
        case METHODID_GET_STAKES:
          serviceImpl.getStakes((forge_abi.Rpc.RequestGetStakes) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetStakes>) responseObserver);
          break;
        case METHODID_GET_TOP_ACCOUNTS:
          serviceImpl.getTopAccounts((forge_abi.Rpc.RequestGetTopAccounts) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetTopAccounts>) responseObserver);
          break;
        case METHODID_LIST_ASSET_TRANSACTIONS:
          serviceImpl.listAssetTransactions((forge_abi.Rpc.RequestListAssetTransactions) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssetTransactions>) responseObserver);
          break;
        case METHODID_LIST_BLOCKS:
          serviceImpl.listBlocks((forge_abi.Rpc.RequestListBlocks) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListBlocks>) responseObserver);
          break;
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets((forge_abi.Rpc.RequestListAssets) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListAssets>) responseObserver);
          break;
        case METHODID_GET_HEALTH_STATUS:
          serviceImpl.getHealthStatus((forge_abi.Rpc.RequestGetHealthStatus) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetHealthStatus>) responseObserver);
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

  private static final class StatisticRpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return forge_abi.Service.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StatisticRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StatisticRpcDescriptorSupplier())
              .addMethod(METHOD_GET_FORGE_STATISTICS)
              .addMethod(METHOD_LIST_TRANSACTIONS)
              .addMethod(METHOD_GET_ASSETS)
              .addMethod(METHOD_GET_STAKES)
              .addMethod(METHOD_GET_TOP_ACCOUNTS)
              .addMethod(METHOD_LIST_ASSET_TRANSACTIONS)
              .addMethod(METHOD_LIST_BLOCKS)
              .addMethod(METHOD_LIST_ASSETS)
              .addMethod(METHOD_GET_HEALTH_STATUS)
              .build();
        }
      }
    }
    return result;
  }
}
