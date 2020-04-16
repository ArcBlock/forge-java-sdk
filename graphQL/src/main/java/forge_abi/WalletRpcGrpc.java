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
    public void declareNode(forge_abi.Rpc.RequestDeclareNode request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseDeclareNode> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DECLARE_NODE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
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
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseDeclareNode> declareNode(
        forge_abi.Rpc.RequestDeclareNode request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DECLARE_NODE, getCallOptions()), request);
    }
  }

  private static final int METHODID_DECLARE_NODE = 0;

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
              .addMethod(METHOD_DECLARE_NODE)
              .build();
        }
      }
    }
    return result;
  }
}
