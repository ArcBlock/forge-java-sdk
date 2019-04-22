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
    comments = "Source: abi.proto")
public final class ForgeAppRpcGrpc {

  private ForgeAppRpcGrpc() {}

  public static final String SERVICE_NAME = "forge_abi.ForgeAppRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Abi.Request,
      forge_abi.Abi.Response> METHOD_PROCESS_ONE =
      io.grpc.MethodDescriptor.<forge_abi.Abi.Request, forge_abi.Abi.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ForgeAppRpc", "process_one"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Abi.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Abi.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Abi.Request,
      forge_abi.Abi.Response> METHOD_PROCESS =
      io.grpc.MethodDescriptor.<forge_abi.Abi.Request, forge_abi.Abi.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.ForgeAppRpc", "process"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Abi.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Abi.Response.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ForgeAppRpcStub newStub(io.grpc.Channel channel) {
    return new ForgeAppRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ForgeAppRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ForgeAppRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ForgeAppRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ForgeAppRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class ForgeAppRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void processOne(forge_abi.Abi.Request request,
        io.grpc.stub.StreamObserver<forge_abi.Abi.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PROCESS_ONE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Abi.Request> process(
        io.grpc.stub.StreamObserver<forge_abi.Abi.Response> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_PROCESS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_PROCESS_ONE,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Abi.Request,
                forge_abi.Abi.Response>(
                  this, METHODID_PROCESS_ONE)))
          .addMethod(
            METHOD_PROCESS,
            asyncBidiStreamingCall(
              new MethodHandlers<
                forge_abi.Abi.Request,
                forge_abi.Abi.Response>(
                  this, METHODID_PROCESS)))
          .build();
    }
  }

  /**
   */
  public static final class ForgeAppRpcStub extends io.grpc.stub.AbstractStub<ForgeAppRpcStub> {
    private ForgeAppRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ForgeAppRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ForgeAppRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ForgeAppRpcStub(channel, callOptions);
    }

    /**
     */
    public void processOne(forge_abi.Abi.Request request,
        io.grpc.stub.StreamObserver<forge_abi.Abi.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PROCESS_ONE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<forge_abi.Abi.Request> process(
        io.grpc.stub.StreamObserver<forge_abi.Abi.Response> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_PROCESS, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ForgeAppRpcBlockingStub extends io.grpc.stub.AbstractStub<ForgeAppRpcBlockingStub> {
    private ForgeAppRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ForgeAppRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ForgeAppRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ForgeAppRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public forge_abi.Abi.Response processOne(forge_abi.Abi.Request request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PROCESS_ONE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ForgeAppRpcFutureStub extends io.grpc.stub.AbstractStub<ForgeAppRpcFutureStub> {
    private ForgeAppRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ForgeAppRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ForgeAppRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ForgeAppRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Abi.Response> processOne(
        forge_abi.Abi.Request request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PROCESS_ONE, getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_ONE = 0;
  private static final int METHODID_PROCESS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ForgeAppRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ForgeAppRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_ONE:
          serviceImpl.processOne((forge_abi.Abi.Request) request,
              (io.grpc.stub.StreamObserver<forge_abi.Abi.Response>) responseObserver);
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
        case METHODID_PROCESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.process(
              (io.grpc.stub.StreamObserver<forge_abi.Abi.Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ForgeAppRpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return forge_abi.Abi.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ForgeAppRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ForgeAppRpcDescriptorSupplier())
              .addMethod(METHOD_PROCESS_ONE)
              .addMethod(METHOD_PROCESS)
              .build();
        }
      }
    }
    return result;
  }
}
