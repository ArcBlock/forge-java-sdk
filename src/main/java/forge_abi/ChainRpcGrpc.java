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
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestCreateTx,
      forge_abi.Rpc.ResponseCreateTx> METHOD_CREATE_TX =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestCreateTx, forge_abi.Rpc.ResponseCreateTx>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "create_tx"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestCreateTx.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseCreateTx.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestMultisig,
      forge_abi.Rpc.ResponseMultisig> METHOD_MULTISIG =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestMultisig, forge_abi.Rpc.ResponseMultisig>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "multisig"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestMultisig.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseMultisig.getDefaultInstance()))
          .build();
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
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetAssetAddress,
      forge_abi.Rpc.ResponseGetAssetAddress> METHOD_GET_ASSET_ADDRESS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetAssetAddress, forge_abi.Rpc.ResponseGetAssetAddress>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_asset_address"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetAssetAddress.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetAssetAddress.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestSignData,
      forge_abi.Rpc.ResponseSignData> METHOD_SIGN_DATA =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestSignData, forge_abi.Rpc.ResponseSignData>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "sign_data"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestSignData.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseSignData.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestStartSimulator,
      forge_abi.Rpc.ResponseStartSimulator> METHOD_START_SIMULATOR =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestStartSimulator, forge_abi.Rpc.ResponseStartSimulator>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "start_simulator"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestStartSimulator.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseStartSimulator.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestStopSimulator,
      forge_abi.Rpc.ResponseStopSimulator> METHOD_STOP_SIMULATOR =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestStopSimulator, forge_abi.Rpc.ResponseStopSimulator>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "stop_simulator"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestStopSimulator.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseStopSimulator.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetSimulatorStatus,
      forge_abi.Rpc.ResponseGetSimulatorStatus> METHOD_GET_SIMULATOR_STATUS =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetSimulatorStatus, forge_abi.Rpc.ResponseGetSimulatorStatus>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ChainRpc", "get_simulator_status"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetSimulatorStatus.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetSimulatorStatus.getDefaultInstance()))
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
    public void createTx(forge_abi.Rpc.RequestCreateTx request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseCreateTx> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_TX, responseObserver);
    }

    /**
     */
    public void multisig(forge_abi.Rpc.RequestMultisig request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseMultisig> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MULTISIG, responseObserver);
    }

    /**
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

    /**
     */
    public void getAssetAddress(forge_abi.Rpc.RequestGetAssetAddress request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAssetAddress> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ASSET_ADDRESS, responseObserver);
    }

    /**
     */
    public void signData(forge_abi.Rpc.RequestSignData request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSignData> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SIGN_DATA, responseObserver);
    }

    /**
     */
    public void startSimulator(forge_abi.Rpc.RequestStartSimulator request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseStartSimulator> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_START_SIMULATOR, responseObserver);
    }

    /**
     */
    public void stopSimulator(forge_abi.Rpc.RequestStopSimulator request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseStopSimulator> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_STOP_SIMULATOR, responseObserver);
    }

    /**
     */
    public void getSimulatorStatus(forge_abi.Rpc.RequestGetSimulatorStatus request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetSimulatorStatus> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_SIMULATOR_STATUS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_TX,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestCreateTx,
                forge_abi.Rpc.ResponseCreateTx>(
                  this, METHODID_CREATE_TX)))
          .addMethod(
            METHOD_MULTISIG,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestMultisig,
                forge_abi.Rpc.ResponseMultisig>(
                  this, METHODID_MULTISIG)))
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
          .addMethod(
            METHOD_GET_ASSET_ADDRESS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetAssetAddress,
                forge_abi.Rpc.ResponseGetAssetAddress>(
                  this, METHODID_GET_ASSET_ADDRESS)))
          .addMethod(
            METHOD_SIGN_DATA,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestSignData,
                forge_abi.Rpc.ResponseSignData>(
                  this, METHODID_SIGN_DATA)))
          .addMethod(
            METHOD_START_SIMULATOR,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestStartSimulator,
                forge_abi.Rpc.ResponseStartSimulator>(
                  this, METHODID_START_SIMULATOR)))
          .addMethod(
            METHOD_STOP_SIMULATOR,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestStopSimulator,
                forge_abi.Rpc.ResponseStopSimulator>(
                  this, METHODID_STOP_SIMULATOR)))
          .addMethod(
            METHOD_GET_SIMULATOR_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetSimulatorStatus,
                forge_abi.Rpc.ResponseGetSimulatorStatus>(
                  this, METHODID_GET_SIMULATOR_STATUS)))
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
    public void createTx(forge_abi.Rpc.RequestCreateTx request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseCreateTx> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_TX, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void multisig(forge_abi.Rpc.RequestMultisig request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseMultisig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MULTISIG, getCallOptions()), request, responseObserver);
    }

    /**
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

    /**
     */
    public void getAssetAddress(forge_abi.Rpc.RequestGetAssetAddress request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAssetAddress> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ASSET_ADDRESS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void signData(forge_abi.Rpc.RequestSignData request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSignData> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SIGN_DATA, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startSimulator(forge_abi.Rpc.RequestStartSimulator request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseStartSimulator> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_START_SIMULATOR, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopSimulator(forge_abi.Rpc.RequestStopSimulator request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseStopSimulator> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_STOP_SIMULATOR, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSimulatorStatus(forge_abi.Rpc.RequestGetSimulatorStatus request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetSimulatorStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SIMULATOR_STATUS, getCallOptions()), request, responseObserver);
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
    public forge_abi.Rpc.ResponseCreateTx createTx(forge_abi.Rpc.RequestCreateTx request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_TX, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseMultisig multisig(forge_abi.Rpc.RequestMultisig request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MULTISIG, getCallOptions(), request);
    }

    /**
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

    /**
     */
    public forge_abi.Rpc.ResponseGetAssetAddress getAssetAddress(forge_abi.Rpc.RequestGetAssetAddress request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ASSET_ADDRESS, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseSignData signData(forge_abi.Rpc.RequestSignData request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SIGN_DATA, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseStartSimulator startSimulator(forge_abi.Rpc.RequestStartSimulator request) {
      return blockingUnaryCall(
          getChannel(), METHOD_START_SIMULATOR, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseStopSimulator stopSimulator(forge_abi.Rpc.RequestStopSimulator request) {
      return blockingUnaryCall(
          getChannel(), METHOD_STOP_SIMULATOR, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetSimulatorStatus getSimulatorStatus(forge_abi.Rpc.RequestGetSimulatorStatus request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_SIMULATOR_STATUS, getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseCreateTx> createTx(
        forge_abi.Rpc.RequestCreateTx request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_TX, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseMultisig> multisig(
        forge_abi.Rpc.RequestMultisig request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MULTISIG, getCallOptions()), request);
    }

    /**
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetAssetAddress> getAssetAddress(
        forge_abi.Rpc.RequestGetAssetAddress request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ASSET_ADDRESS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseSignData> signData(
        forge_abi.Rpc.RequestSignData request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SIGN_DATA, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseStartSimulator> startSimulator(
        forge_abi.Rpc.RequestStartSimulator request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_START_SIMULATOR, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseStopSimulator> stopSimulator(
        forge_abi.Rpc.RequestStopSimulator request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_STOP_SIMULATOR, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetSimulatorStatus> getSimulatorStatus(
        forge_abi.Rpc.RequestGetSimulatorStatus request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SIMULATOR_STATUS, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TX = 0;
  private static final int METHODID_MULTISIG = 1;
  private static final int METHODID_SEND_TX = 2;
  private static final int METHODID_GET_BLOCKS = 3;
  private static final int METHODID_GET_UNCONFIRMED_TXS = 4;
  private static final int METHODID_GET_CHAIN_INFO = 5;
  private static final int METHODID_GET_NODE_INFO = 6;
  private static final int METHODID_SEARCH = 7;
  private static final int METHODID_GET_NET_INFO = 8;
  private static final int METHODID_GET_VALIDATORS_INFO = 9;
  private static final int METHODID_GET_CONFIG = 10;
  private static final int METHODID_GET_ASSET_ADDRESS = 11;
  private static final int METHODID_SIGN_DATA = 12;
  private static final int METHODID_START_SIMULATOR = 13;
  private static final int METHODID_STOP_SIMULATOR = 14;
  private static final int METHODID_GET_SIMULATOR_STATUS = 15;
  private static final int METHODID_GET_TX = 16;
  private static final int METHODID_GET_BLOCK = 17;

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
        case METHODID_CREATE_TX:
          serviceImpl.createTx((forge_abi.Rpc.RequestCreateTx) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseCreateTx>) responseObserver);
          break;
        case METHODID_MULTISIG:
          serviceImpl.multisig((forge_abi.Rpc.RequestMultisig) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseMultisig>) responseObserver);
          break;
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
        case METHODID_GET_ASSET_ADDRESS:
          serviceImpl.getAssetAddress((forge_abi.Rpc.RequestGetAssetAddress) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAssetAddress>) responseObserver);
          break;
        case METHODID_SIGN_DATA:
          serviceImpl.signData((forge_abi.Rpc.RequestSignData) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSignData>) responseObserver);
          break;
        case METHODID_START_SIMULATOR:
          serviceImpl.startSimulator((forge_abi.Rpc.RequestStartSimulator) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseStartSimulator>) responseObserver);
          break;
        case METHODID_STOP_SIMULATOR:
          serviceImpl.stopSimulator((forge_abi.Rpc.RequestStopSimulator) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseStopSimulator>) responseObserver);
          break;
        case METHODID_GET_SIMULATOR_STATUS:
          serviceImpl.getSimulatorStatus((forge_abi.Rpc.RequestGetSimulatorStatus) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetSimulatorStatus>) responseObserver);
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
              .addMethod(METHOD_CREATE_TX)
              .addMethod(METHOD_MULTISIG)
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
              .addMethod(METHOD_GET_ASSET_ADDRESS)
              .addMethod(METHOD_SIGN_DATA)
              .addMethod(METHOD_START_SIMULATOR)
              .addMethod(METHOD_STOP_SIMULATOR)
              .addMethod(METHOD_GET_SIMULATOR_STATUS)
              .build();
        }
      }
    }
    return result;
  }
}
