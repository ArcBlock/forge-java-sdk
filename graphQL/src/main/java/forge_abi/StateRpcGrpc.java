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
public final class StateRpcGrpc {

  private StateRpcGrpc() {}

  public static final String SERVICE_NAME = "forge_abi.StateRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetAccountState,
      forge_abi.Rpc.ResponseGetAccountState> METHOD_GET_ACCOUNT_STATE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetAccountState, forge_abi.Rpc.ResponseGetAccountState>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StateRpc", "get_account_state"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetAccountState.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetAccountState.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetAssetState,
      forge_abi.Rpc.ResponseGetAssetState> METHOD_GET_ASSET_STATE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetAssetState, forge_abi.Rpc.ResponseGetAssetState>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StateRpc", "get_asset_state"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetAssetState.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetAssetState.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetForgeState,
      forge_abi.Rpc.ResponseGetForgeState> METHOD_GET_FORGE_STATE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetForgeState, forge_abi.Rpc.ResponseGetForgeState>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StateRpc", "get_forge_state"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetForgeState.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetForgeState.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetSwapState,
      forge_abi.Rpc.ResponseGetSwapState> METHOD_GET_SWAP_STATE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetSwapState, forge_abi.Rpc.ResponseGetSwapState>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StateRpc", "get_swap_state"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetSwapState.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetSwapState.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestGetDelegateState,
      forge_abi.Rpc.ResponseGetDelegateState> METHOD_GET_DELEGATE_STATE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestGetDelegateState, forge_abi.Rpc.ResponseGetDelegateState>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.StateRpc", "get_delegate_state"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestGetDelegateState.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseGetDelegateState.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StateRpcStub newStub(io.grpc.Channel channel) {
    return new StateRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StateRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StateRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StateRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StateRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class StateRpcImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * state related
     * </pre>
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetAccountState> getAccountState(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAccountState> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_ACCOUNT_STATE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetAssetState> getAssetState(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAssetState> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_ASSET_STATE, responseObserver);
    }

    /**
     */
    public void getForgeState(forge_abi.Rpc.RequestGetForgeState request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetForgeState> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FORGE_STATE, responseObserver);
    }

    /**
     * <pre>
     * rpc get_protocol_state(stream RequestGetProtocolState) returns (stream
     * ResponseGetProtocolState);
     * rpc get_stake_state(stream RequestGetStakeState)
     * returns (stream ResponseGetStakeState);
     * </pre>
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetSwapState> getSwapState(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetSwapState> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_SWAP_STATE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetDelegateState> getDelegateState(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetDelegateState> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_DELEGATE_STATE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_ACCOUNT_STATE,
            asyncBidiStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetAccountState,
                forge_abi.Rpc.ResponseGetAccountState>(
                  this, METHODID_GET_ACCOUNT_STATE)))
          .addMethod(
            METHOD_GET_ASSET_STATE,
            asyncBidiStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetAssetState,
                forge_abi.Rpc.ResponseGetAssetState>(
                  this, METHODID_GET_ASSET_STATE)))
          .addMethod(
            METHOD_GET_FORGE_STATE,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetForgeState,
                forge_abi.Rpc.ResponseGetForgeState>(
                  this, METHODID_GET_FORGE_STATE)))
          .addMethod(
            METHOD_GET_SWAP_STATE,
            asyncBidiStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetSwapState,
                forge_abi.Rpc.ResponseGetSwapState>(
                  this, METHODID_GET_SWAP_STATE)))
          .addMethod(
            METHOD_GET_DELEGATE_STATE,
            asyncBidiStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestGetDelegateState,
                forge_abi.Rpc.ResponseGetDelegateState>(
                  this, METHODID_GET_DELEGATE_STATE)))
          .build();
    }
  }

  /**
   */
  public static final class StateRpcStub extends io.grpc.stub.AbstractStub<StateRpcStub> {
    private StateRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StateRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StateRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StateRpcStub(channel, callOptions);
    }

    /**
     * <pre>
     * state related
     * </pre>
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetAccountState> getAccountState(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAccountState> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_ACCOUNT_STATE, getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetAssetState> getAssetState(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAssetState> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_ASSET_STATE, getCallOptions()), responseObserver);
    }

    /**
     */
    public void getForgeState(forge_abi.Rpc.RequestGetForgeState request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetForgeState> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FORGE_STATE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * rpc get_protocol_state(stream RequestGetProtocolState) returns (stream
     * ResponseGetProtocolState);
     * rpc get_stake_state(stream RequestGetStakeState)
     * returns (stream ResponseGetStakeState);
     * </pre>
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetSwapState> getSwapState(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetSwapState> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_SWAP_STATE, getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestGetDelegateState> getDelegateState(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetDelegateState> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_DELEGATE_STATE, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StateRpcBlockingStub extends io.grpc.stub.AbstractStub<StateRpcBlockingStub> {
    private StateRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StateRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StateRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StateRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public forge_abi.Rpc.ResponseGetForgeState getForgeState(forge_abi.Rpc.RequestGetForgeState request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FORGE_STATE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StateRpcFutureStub extends io.grpc.stub.AbstractStub<StateRpcFutureStub> {
    private StateRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StateRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StateRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StateRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseGetForgeState> getForgeState(
        forge_abi.Rpc.RequestGetForgeState request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FORGE_STATE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FORGE_STATE = 0;
  private static final int METHODID_GET_ACCOUNT_STATE = 1;
  private static final int METHODID_GET_ASSET_STATE = 2;
  private static final int METHODID_GET_SWAP_STATE = 3;
  private static final int METHODID_GET_DELEGATE_STATE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StateRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StateRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FORGE_STATE:
          serviceImpl.getForgeState((forge_abi.Rpc.RequestGetForgeState) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetForgeState>) responseObserver);
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
        case METHODID_GET_ACCOUNT_STATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getAccountState(
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAccountState>) responseObserver);
        case METHODID_GET_ASSET_STATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getAssetState(
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetAssetState>) responseObserver);
        case METHODID_GET_SWAP_STATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getSwapState(
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetSwapState>) responseObserver);
        case METHODID_GET_DELEGATE_STATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getDelegateState(
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseGetDelegateState>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class StateRpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return forge_abi.Service.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StateRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StateRpcDescriptorSupplier())
              .addMethod(METHOD_GET_ACCOUNT_STATE)
              .addMethod(METHOD_GET_ASSET_STATE)
              .addMethod(METHOD_GET_FORGE_STATE)
              .addMethod(METHOD_GET_SWAP_STATE)
              .addMethod(METHOD_GET_DELEGATE_STATE)
              .build();
        }
      }
    }
    return result;
  }
}
