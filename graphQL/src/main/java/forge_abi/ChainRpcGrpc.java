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
public final class ChainRpcGrpc {

  private ChainRpcGrpc() {}

  public static final String SERVICE_NAME = "forge_abi.ChainRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestSendTx,
      forge_abi.Rpc.ResponseSendTx> METHOD_SEND_TX =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestSendTx, forge_abi.Rpc.ResponseSendTx>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "send_tx"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestSendTx.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseSendTx.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetTx,
      forge_abi.Rpc.ResponseGetTx> METHOD_GET_TX =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetTx, forge_abi.Rpc.ResponseGetTx>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_tx"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetTx.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetTx.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetBlock,
      forge_abi.Rpc.ResponseGetBlock> METHOD_GET_BLOCK =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetBlock, forge_abi.Rpc.ResponseGetBlock>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_block"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetBlock.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetBlock.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetBlocks,
      forge_abi.Rpc.ResponseGetBlocks> METHOD_GET_BLOCKS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetBlocks, forge_abi.Rpc.ResponseGetBlocks>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_blocks"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetBlocks.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetBlocks.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetUnconfirmedTxs,
      forge_abi.Rpc.ResponseGetUnconfirmedTxs> METHOD_GET_UNCONFIRMED_TXS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetUnconfirmedTxs, forge_abi.Rpc.ResponseGetUnconfirmedTxs>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_unconfirmed_txs"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetUnconfirmedTxs.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetUnconfirmedTxs.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetChainInfo,
      forge_abi.Rpc.ResponseGetChainInfo> METHOD_GET_CHAIN_INFO =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetChainInfo, forge_abi.Rpc.ResponseGetChainInfo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_chain_info"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetChainInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetChainInfo.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetNodeInfo,
      forge_abi.Rpc.ResponseGetNodeInfo> METHOD_GET_NODE_INFO =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetNodeInfo, forge_abi.Rpc.ResponseGetNodeInfo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_node_info"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetNodeInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetNodeInfo.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestSearch,
      forge_abi.Rpc.ResponseSearch> METHOD_SEARCH =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestSearch, forge_abi.Rpc.ResponseSearch>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "search"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestSearch.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseSearch.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetNetInfo,
      forge_abi.Rpc.ResponseGetNetInfo> METHOD_GET_NET_INFO =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetNetInfo, forge_abi.Rpc.ResponseGetNetInfo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_net_info"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetNetInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetNetInfo.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetValidatorsInfo,
      forge_abi.Rpc.ResponseGetValidatorsInfo> METHOD_GET_VALIDATORS_INFO =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetValidatorsInfo, forge_abi.Rpc.ResponseGetValidatorsInfo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_validators_info"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetValidatorsInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetValidatorsInfo.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetConfig,
      forge_abi.Rpc.ResponseGetConfig> METHOD_GET_CONFIG =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetConfig, forge_abi.Rpc.ResponseGetConfig>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_config"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetConfig.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetConfig.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChainRpcStub newStub(io.grpc.Channel channel) {
    return new ChainRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChainRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChainRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChainRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChainRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class ChainRpcImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * tx related
     * </pre>
     */
    public void sendTx(forge_abi.Rpc.RequestSendTx request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSendTx> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_TX, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetTx> getTx(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetTx> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_TX, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetBlock> getBlock(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetBlock> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_BLOCK, responseObserver);
    }

    /**
     */
    public void getBlocks(forge_abi.Rpc.RequestGetBlocks request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetBlocks> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_BLOCKS, responseObserver);
    }

    /**
     */
    public void getUnconfirmedTxs(forge_abi.Rpc.RequestGetUnconfirmedTxs request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetUnconfirmedTxs> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_UNCONFIRMED_TXS, responseObserver);
    }

    /**
     * <pre>
     * utility
     * </pre>
     */
    public void getChainInfo(forge_abi.Rpc.RequestGetChainInfo request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetChainInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CHAIN_INFO, responseObserver);
    }

    /**
     */
    public void getNodeInfo(forge_abi.Rpc.RequestGetNodeInfo request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetNodeInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_NODE_INFO, responseObserver);
    }

    /**
     */
    public void search(forge_abi.Rpc.RequestSearch request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSearch> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH, responseObserver);
    }

    /**
     */
    public void getNetInfo(forge_abi.Rpc.RequestGetNetInfo request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetNetInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_NET_INFO, responseObserver);
    }

    /**
     */
    public void getValidatorsInfo(forge_abi.Rpc.RequestGetValidatorsInfo request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetValidatorsInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_VALIDATORS_INFO, responseObserver);
    }

    /**
     */
    public void getConfig(forge_abi.Rpc.RequestGetConfig request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetConfig> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CONFIG, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND_TX,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestSendTx,
                forge_abi.Rpc.ResponseSendTx>(
                  this, METHODID_SEND_TX)))
          .addMethod(
            METHOD_GET_TX,
            asyncBidiStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetTx,
                forge_abi.Rpc.ResponseGetTx>(
                  this, METHODID_GET_TX)))
          .addMethod(
            METHOD_GET_BLOCK,
            asyncBidiStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetBlock,
                forge_abi.Rpc.ResponseGetBlock>(
                  this, METHODID_GET_BLOCK)))
          .addMethod(
            METHOD_GET_BLOCKS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetBlocks,
                forge_abi.Rpc.ResponseGetBlocks>(
                  this, METHODID_GET_BLOCKS)))
          .addMethod(
            METHOD_GET_UNCONFIRMED_TXS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetUnconfirmedTxs,
                forge_abi.Rpc.ResponseGetUnconfirmedTxs>(
                  this, METHODID_GET_UNCONFIRMED_TXS)))
          .addMethod(
            METHOD_GET_CHAIN_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetChainInfo,
                forge_abi.Rpc.ResponseGetChainInfo>(
                  this, METHODID_GET_CHAIN_INFO)))
          .addMethod(
            METHOD_GET_NODE_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetNodeInfo,
                forge_abi.Rpc.ResponseGetNodeInfo>(
                  this, METHODID_GET_NODE_INFO)))
          .addMethod(
            METHOD_SEARCH,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestSearch,
                forge_abi.Rpc.ResponseSearch>(
                  this, METHODID_SEARCH)))
          .addMethod(
            METHOD_GET_NET_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetNetInfo,
                forge_abi.Rpc.ResponseGetNetInfo>(
                  this, METHODID_GET_NET_INFO)))
          .addMethod(
            METHOD_GET_VALIDATORS_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetValidatorsInfo,
                forge_abi.Rpc.ResponseGetValidatorsInfo>(
                  this, METHODID_GET_VALIDATORS_INFO)))
          .addMethod(
            METHOD_GET_CONFIG,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetConfig,
                forge_abi.Rpc.ResponseGetConfig>(
                  this, METHODID_GET_CONFIG)))
          .build();
    }
  }

  /**
   */
  public static final class ChainRpcStub extends io.grpc.stub.AbstractStub<ChainRpcStub> {
    private ChainRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChainRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChainRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChainRpcStub(channel, callOptions);
    }

    /**
     * <pre>
     * tx related
     * </pre>
     */
    public void sendTx(forge_abi.Rpc.RequestSendTx request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSendTx> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_TX, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetTx> getTx(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetTx> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_TX, getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetBlock> getBlock(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetBlock> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_BLOCK, getCallOptions()), responseObserver);
    }

    /**
     */
    public void getBlocks(forge_abi.Rpc.RequestGetBlocks request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetBlocks> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_BLOCKS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUnconfirmedTxs(forge_abi.Rpc.RequestGetUnconfirmedTxs request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetUnconfirmedTxs> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_UNCONFIRMED_TXS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * utility
     * </pre>
     */
    public void getChainInfo(forge_abi.Rpc.RequestGetChainInfo request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetChainInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CHAIN_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNodeInfo(forge_abi.Rpc.RequestGetNodeInfo request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetNodeInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_NODE_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void search(forge_abi.Rpc.RequestSearch request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSearch> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEARCH, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNetInfo(forge_abi.Rpc.RequestGetNetInfo request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetNetInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_NET_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getValidatorsInfo(forge_abi.Rpc.RequestGetValidatorsInfo request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetValidatorsInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_VALIDATORS_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getConfig(forge_abi.Rpc.RequestGetConfig request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_CONFIG, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChainRpcBlockingStub extends io.grpc.stub.AbstractStub<ChainRpcBlockingStub> {
    private ChainRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChainRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChainRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChainRpcBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * tx related
     * </pre>
     */
    public forge_abi.Rpc.ResponseSendTx sendTx(forge_abi.Rpc.RequestSendTx request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_TX, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetBlocks getBlocks(forge_abi.Rpc.RequestGetBlocks request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_BLOCKS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetUnconfirmedTxs getUnconfirmedTxs(forge_abi.Rpc.RequestGetUnconfirmedTxs request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_UNCONFIRMED_TXS, getCallOptions(), request);
    }

    /**
     * <pre>
     * utility
     * </pre>
     */
    public forge_abi.Rpc.ResponseGetChainInfo getChainInfo(forge_abi.Rpc.RequestGetChainInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CHAIN_INFO, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetNodeInfo getNodeInfo(forge_abi.Rpc.RequestGetNodeInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_NODE_INFO, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseSearch search(forge_abi.Rpc.RequestSearch request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEARCH, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetNetInfo getNetInfo(forge_abi.Rpc.RequestGetNetInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_NET_INFO, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetValidatorsInfo getValidatorsInfo(forge_abi.Rpc.RequestGetValidatorsInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_VALIDATORS_INFO, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetConfig getConfig(forge_abi.Rpc.RequestGetConfig request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_CONFIG, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChainRpcFutureStub extends io.grpc.stub.AbstractStub<ChainRpcFutureStub> {
    private ChainRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChainRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChainRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChainRpcFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * tx related
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseSendTx> sendTx(
        forge_abi.Rpc.RequestSendTx request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_TX, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetBlocks> getBlocks(
        forge_abi.Rpc.RequestGetBlocks request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_BLOCKS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetUnconfirmedTxs> getUnconfirmedTxs(
        forge_abi.Rpc.RequestGetUnconfirmedTxs request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_UNCONFIRMED_TXS, getCallOptions()), request);
    }

    /**
     * <pre>
     * utility
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetChainInfo> getChainInfo(
        forge_abi.Rpc.RequestGetChainInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CHAIN_INFO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetNodeInfo> getNodeInfo(
        forge_abi.Rpc.RequestGetNodeInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_NODE_INFO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseSearch> search(
        forge_abi.Rpc.RequestSearch request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEARCH, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetNetInfo> getNetInfo(
        forge_abi.Rpc.RequestGetNetInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_NET_INFO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetValidatorsInfo> getValidatorsInfo(
        forge_abi.Rpc.RequestGetValidatorsInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_VALIDATORS_INFO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetConfig> getConfig(
        forge_abi.Rpc.RequestGetConfig request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_CONFIG, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_TX = 0;
  private static final int METHODID_GET_BLOCKS = 1;
  private static final int METHODID_GET_UNCONFIRMED_TXS = 2;
  private static final int METHODID_GET_CHAIN_INFO = 3;
  private static final int METHODID_GET_NODE_INFO = 4;
  private static final int METHODID_SEARCH = 5;
  private static final int METHODID_GET_NET_INFO = 6;
  private static final int METHODID_GET_VALIDATORS_INFO = 7;
  private static final int METHODID_GET_CONFIG = 8;
  private static final int METHODID_GET_TX = 9;
  private static final int METHODID_GET_BLOCK = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChainRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChainRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_TX:
          serviceImpl.sendTx((forge_abi.Rpc.RequestSendTx) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSendTx>) responseObserver);
          break;
        case METHODID_GET_BLOCKS:
          serviceImpl.getBlocks((forge_abi.Rpc.RequestGetBlocks) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetBlocks>) responseObserver);
          break;
        case METHODID_GET_UNCONFIRMED_TXS:
          serviceImpl.getUnconfirmedTxs((forge_abi.Rpc.RequestGetUnconfirmedTxs) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetUnconfirmedTxs>) responseObserver);
          break;
        case METHODID_GET_CHAIN_INFO:
          serviceImpl.getChainInfo((forge_abi.Rpc.RequestGetChainInfo) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetChainInfo>) responseObserver);
          break;
        case METHODID_GET_NODE_INFO:
          serviceImpl.getNodeInfo((forge_abi.Rpc.RequestGetNodeInfo) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetNodeInfo>) responseObserver);
          break;
        case METHODID_SEARCH:
          serviceImpl.search((forge_abi.Rpc.RequestSearch) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSearch>) responseObserver);
          break;
        case METHODID_GET_NET_INFO:
          serviceImpl.getNetInfo((forge_abi.Rpc.RequestGetNetInfo) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetNetInfo>) responseObserver);
          break;
        case METHODID_GET_VALIDATORS_INFO:
          serviceImpl.getValidatorsInfo((forge_abi.Rpc.RequestGetValidatorsInfo) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetValidatorsInfo>) responseObserver);
          break;
        case METHODID_GET_CONFIG:
          serviceImpl.getConfig((forge_abi.Rpc.RequestGetConfig) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetConfig>) responseObserver);
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
        case METHODID_GET_TX:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getTx(
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetTx>) responseObserver);
        case METHODID_GET_BLOCK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getBlock(
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetBlock>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ChainRpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return forge_abi.Service.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChainRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChainRpcDescriptorSupplier())
              .addMethod(METHOD_SEND_TX)
              .addMethod(METHOD_GET_TX)
              .addMethod(METHOD_GET_BLOCK)
              .addMethod(METHOD_GET_BLOCKS)
              .addMethod(METHOD_GET_UNCONFIRMED_TXS)
              .addMethod(METHOD_GET_CHAIN_INFO)
              .addMethod(METHOD_GET_NODE_INFO)
              .addMethod(METHOD_SEARCH)
              .addMethod(METHOD_GET_NET_INFO)
              .addMethod(METHOD_GET_VALIDATORS_INFO)
              .addMethod(METHOD_GET_CONFIG)
              .build();
        }
      }
    }
    return result;
  }
}
