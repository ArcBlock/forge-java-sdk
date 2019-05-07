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
public final class WalletRpcGrpc {

  private WalletRpcGrpc() {}

  public static final String SERVICE_NAME = "forge_abi.WalletRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestCreateWallet,
      forge_abi.Rpc.ResponseCreateWallet> METHOD_CREATE_WALLET =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestCreateWallet, forge_abi.Rpc.ResponseCreateWallet>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.WalletRpc", "create_wallet"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestCreateWallet.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseCreateWallet.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestLoadWallet,
      forge_abi.Rpc.ResponseLoadWallet> METHOD_LOAD_WALLET =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestLoadWallet, forge_abi.Rpc.ResponseLoadWallet>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.WalletRpc", "load_wallet"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestLoadWallet.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseLoadWallet.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestRecoverWallet,
      forge_abi.Rpc.ResponseRecoverWallet> METHOD_RECOVER_WALLET =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestRecoverWallet, forge_abi.Rpc.ResponseRecoverWallet>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.WalletRpc", "recover_wallet"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestRecoverWallet.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseRecoverWallet.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestListWallet,
      forge_abi.Rpc.ResponseListWallet> METHOD_LIST_WALLET =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestListWallet, forge_abi.Rpc.ResponseListWallet>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.WalletRpc", "list_wallet"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestListWallet.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseListWallet.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestRemoveWallet,
      forge_abi.Rpc.ResponseRemoveWallet> METHOD_REMOVE_WALLET =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestRemoveWallet, forge_abi.Rpc.ResponseRemoveWallet>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.WalletRpc", "remove_wallet"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestRemoveWallet.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseRemoveWallet.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestDeclareNode,
      forge_abi.Rpc.ResponseDeclareNode> METHOD_DECLARE_NODE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestDeclareNode, forge_abi.Rpc.ResponseDeclareNode>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.WalletRpc", "declare_node"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestDeclareNode.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseDeclareNode.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WalletRpcStub newStub(io.grpc.Channel channel) {
    return new WalletRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WalletRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WalletRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WalletRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WalletRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class WalletRpcImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * wallet related
     * </pre>
     */
    public void createWallet(forge_abi.Rpc.RequestCreateWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseCreateWallet> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_WALLET, responseObserver);
    }

    /**
     */
    public void loadWallet(forge_abi.Rpc.RequestLoadWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseLoadWallet> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOAD_WALLET, responseObserver);
    }

    /**
     */
    public void recoverWallet(forge_abi.Rpc.RequestRecoverWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseRecoverWallet> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_RECOVER_WALLET, responseObserver);
    }

    /**
     */
    public void listWallet(forge_abi.Rpc.RequestListWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListWallet> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIST_WALLET, responseObserver);
    }

    /**
     */
    public void removeWallet(forge_abi.Rpc.RequestRemoveWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseRemoveWallet> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REMOVE_WALLET, responseObserver);
    }

    /**
     */
    public void declareNode(forge_abi.Rpc.RequestDeclareNode request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseDeclareNode> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DECLARE_NODE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_WALLET,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestCreateWallet,
                forge_abi.Rpc.ResponseCreateWallet>(
                  this, METHODID_CREATE_WALLET)))
          .addMethod(
            METHOD_LOAD_WALLET,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestLoadWallet,
                forge_abi.Rpc.ResponseLoadWallet>(
                  this, METHODID_LOAD_WALLET)))
          .addMethod(
            METHOD_RECOVER_WALLET,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestRecoverWallet,
                forge_abi.Rpc.ResponseRecoverWallet>(
                  this, METHODID_RECOVER_WALLET)))
          .addMethod(
            METHOD_LIST_WALLET,
            asyncServerStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestListWallet,
                forge_abi.Rpc.ResponseListWallet>(
                  this, METHODID_LIST_WALLET)))
          .addMethod(
            METHOD_REMOVE_WALLET,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestRemoveWallet,
                forge_abi.Rpc.ResponseRemoveWallet>(
                  this, METHODID_REMOVE_WALLET)))
          .addMethod(
            METHOD_DECLARE_NODE,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestDeclareNode,
                forge_abi.Rpc.ResponseDeclareNode>(
                  this, METHODID_DECLARE_NODE)))
          .build();
    }
  }

  /**
   */
  public static final class WalletRpcStub extends io.grpc.stub.AbstractStub<WalletRpcStub> {
    private WalletRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletRpcStub(channel, callOptions);
    }

    /**
     * <pre>
     * wallet related
     * </pre>
     */
    public void createWallet(forge_abi.Rpc.RequestCreateWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseCreateWallet> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_WALLET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void loadWallet(forge_abi.Rpc.RequestLoadWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseLoadWallet> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOAD_WALLET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void recoverWallet(forge_abi.Rpc.RequestRecoverWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseRecoverWallet> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_RECOVER_WALLET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listWallet(forge_abi.Rpc.RequestListWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListWallet> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LIST_WALLET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeWallet(forge_abi.Rpc.RequestRemoveWallet request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseRemoveWallet> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REMOVE_WALLET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void declareNode(forge_abi.Rpc.RequestDeclareNode request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseDeclareNode> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DECLARE_NODE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WalletRpcBlockingStub extends io.grpc.stub.AbstractStub<WalletRpcBlockingStub> {
    private WalletRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletRpcBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * wallet related
     * </pre>
     */
    public forge_abi.Rpc.ResponseCreateWallet createWallet(forge_abi.Rpc.RequestCreateWallet request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_WALLET, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseLoadWallet loadWallet(forge_abi.Rpc.RequestLoadWallet request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOAD_WALLET, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseRecoverWallet recoverWallet(forge_abi.Rpc.RequestRecoverWallet request) {
      return blockingUnaryCall(
          getChannel(), METHOD_RECOVER_WALLET, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<forge_abi.Rpc.ResponseListWallet> listWallet(
        forge_abi.Rpc.RequestListWallet request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LIST_WALLET, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseRemoveWallet removeWallet(forge_abi.Rpc.RequestRemoveWallet request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REMOVE_WALLET, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseDeclareNode declareNode(forge_abi.Rpc.RequestDeclareNode request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DECLARE_NODE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WalletRpcFutureStub extends io.grpc.stub.AbstractStub<WalletRpcFutureStub> {
    private WalletRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletRpcFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * wallet related
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseCreateWallet> createWallet(
        forge_abi.Rpc.RequestCreateWallet request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_WALLET, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseLoadWallet> loadWallet(
        forge_abi.Rpc.RequestLoadWallet request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOAD_WALLET, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseRecoverWallet> recoverWallet(
        forge_abi.Rpc.RequestRecoverWallet request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_RECOVER_WALLET, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseRemoveWallet> removeWallet(
        forge_abi.Rpc.RequestRemoveWallet request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REMOVE_WALLET, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseDeclareNode> declareNode(
        forge_abi.Rpc.RequestDeclareNode request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DECLARE_NODE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_WALLET = 0;
  private static final int METHODID_LOAD_WALLET = 1;
  private static final int METHODID_RECOVER_WALLET = 2;
  private static final int METHODID_LIST_WALLET = 3;
  private static final int METHODID_REMOVE_WALLET = 4;
  private static final int METHODID_DECLARE_NODE = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WalletRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WalletRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_WALLET:
          serviceImpl.createWallet((forge_abi.Rpc.RequestCreateWallet) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseCreateWallet>) responseObserver);
          break;
        case METHODID_LOAD_WALLET:
          serviceImpl.loadWallet((forge_abi.Rpc.RequestLoadWallet) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseLoadWallet>) responseObserver);
          break;
        case METHODID_RECOVER_WALLET:
          serviceImpl.recoverWallet((forge_abi.Rpc.RequestRecoverWallet) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseRecoverWallet>) responseObserver);
          break;
        case METHODID_LIST_WALLET:
          serviceImpl.listWallet((forge_abi.Rpc.RequestListWallet) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseListWallet>) responseObserver);
          break;
        case METHODID_REMOVE_WALLET:
          serviceImpl.removeWallet((forge_abi.Rpc.RequestRemoveWallet) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseRemoveWallet>) responseObserver);
          break;
        case METHODID_DECLARE_NODE:
          serviceImpl.declareNode((forge_abi.Rpc.RequestDeclareNode) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseDeclareNode>) responseObserver);
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

  private static final class WalletRpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return forge_abi.Service.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WalletRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WalletRpcDescriptorSupplier())
              .addMethod(METHOD_CREATE_WALLET)
              .addMethod(METHOD_LOAD_WALLET)
              .addMethod(METHOD_RECOVER_WALLET)
              .addMethod(METHOD_LIST_WALLET)
              .addMethod(METHOD_REMOVE_WALLET)
              .addMethod(METHOD_DECLARE_NODE)
              .build();
        }
      }
    }
    return result;
  }
}
