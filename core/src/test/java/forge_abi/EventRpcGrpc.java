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
public final class EventRpcGrpc {

  private EventRpcGrpc() {}

  public static final String SERVICE_NAME = "forge_abi.EventRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestSubscribe,
      forge_abi.Rpc.ResponseSubscribe> METHOD_SUBSCRIBE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestSubscribe, forge_abi.Rpc.ResponseSubscribe>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.EventRpc", "subscribe"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestSubscribe.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseSubscribe.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestUnsubscribe,
      forge_abi.Rpc.ResponseUnsubscribe> METHOD_UNSUBSCRIBE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestUnsubscribe, forge_abi.Rpc.ResponseUnsubscribe>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.EventRpc", "unsubscribe"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestUnsubscribe.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseUnsubscribe.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventRpcStub newStub(io.grpc.Channel channel) {
    return new EventRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EventRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EventRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class EventRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void subscribe(forge_abi.Rpc.RequestSubscribe request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSubscribe> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SUBSCRIBE, responseObserver);
    }

    /**
     */
    public void unsubscribe(forge_abi.Rpc.RequestUnsubscribe request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseUnsubscribe> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UNSUBSCRIBE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SUBSCRIBE,
            asyncServerStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestSubscribe,
                forge_abi.Rpc.ResponseSubscribe>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            METHOD_UNSUBSCRIBE,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestUnsubscribe,
                forge_abi.Rpc.ResponseUnsubscribe>(
                  this, METHODID_UNSUBSCRIBE)))
          .build();
    }
  }

  /**
   */
  public static final class EventRpcStub extends io.grpc.stub.AbstractStub<EventRpcStub> {
    private EventRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventRpcStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(forge_abi.Rpc.RequestSubscribe request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSubscribe> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SUBSCRIBE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unsubscribe(forge_abi.Rpc.RequestUnsubscribe request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseUnsubscribe> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UNSUBSCRIBE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EventRpcBlockingStub extends io.grpc.stub.AbstractStub<EventRpcBlockingStub> {
    private EventRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<forge_abi.Rpc.ResponseSubscribe> subscribe(
        forge_abi.Rpc.RequestSubscribe request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SUBSCRIBE, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponseUnsubscribe unsubscribe(forge_abi.Rpc.RequestUnsubscribe request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UNSUBSCRIBE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EventRpcFutureStub extends io.grpc.stub.AbstractStub<EventRpcFutureStub> {
    private EventRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EventRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EventRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponseUnsubscribe> unsubscribe(
        forge_abi.Rpc.RequestUnsubscribe request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UNSUBSCRIBE, getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_UNSUBSCRIBE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((forge_abi.Rpc.RequestSubscribe) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseSubscribe>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((forge_abi.Rpc.RequestUnsubscribe) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseUnsubscribe>) responseObserver);
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

  private static final class EventRpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return forge_abi.Service.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EventRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventRpcDescriptorSupplier())
              .addMethod(METHOD_SUBSCRIBE)
              .addMethod(METHOD_UNSUBSCRIBE)
              .build();
        }
      }
    }
    return result;
  }
}
