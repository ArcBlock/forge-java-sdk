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
 * <pre>
 * filesystem related
 * rpc store_file(stream RequestStoreFile) returns (ResponseStoreFile);
 * rpc load_file(RequestLoadFile) returns (stream ResponseLoadFile);
 * rpc pin_file(RequestPinFile) returns (ResponsePinFile);
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: service.proto")
public final class FileRpcGrpc {

  private FileRpcGrpc() {}

  public static final String SERVICE_NAME = "forge_abi.FileRpc";

  // Static method descriptors that strictly reflect the proto.

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileRpcStub newStub(io.grpc.Channel channel) {
    return new FileRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FileRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FileRpcFutureStub(channel);
  }

  /**
   * <pre>
   * filesystem related
   * rpc store_file(stream RequestStoreFile) returns (ResponseStoreFile);
   * rpc load_file(RequestLoadFile) returns (stream ResponseLoadFile);
   * rpc pin_file(RequestPinFile) returns (ResponsePinFile);
   * </pre>
   */
  public static abstract class FileRpcImplBase implements io.grpc.BindableService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .build();
    }
  }

  /**
   * <pre>
   * filesystem related
   * rpc store_file(stream RequestStoreFile) returns (ResponseStoreFile);
   * rpc load_file(RequestLoadFile) returns (stream ResponseLoadFile);
   * rpc pin_file(RequestPinFile) returns (ResponsePinFile);
   * </pre>
   */
  public static final class FileRpcStub extends io.grpc.stub.AbstractStub<FileRpcStub> {
    private FileRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileRpcStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * filesystem related
   * rpc store_file(stream RequestStoreFile) returns (ResponseStoreFile);
   * rpc load_file(RequestLoadFile) returns (stream ResponseLoadFile);
   * rpc pin_file(RequestPinFile) returns (ResponsePinFile);
   * </pre>
   */
  public static final class FileRpcBlockingStub extends io.grpc.stub.AbstractStub<FileRpcBlockingStub> {
    private FileRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileRpcBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * filesystem related
   * rpc store_file(stream RequestStoreFile) returns (ResponseStoreFile);
   * rpc load_file(RequestLoadFile) returns (stream ResponseLoadFile);
   * rpc pin_file(RequestPinFile) returns (ResponsePinFile);
   * </pre>
   */
  public static final class FileRpcFutureStub extends io.grpc.stub.AbstractStub<FileRpcFutureStub> {
    private FileRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileRpcFutureStub(channel, callOptions);
    }
  }


  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
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

  private static final class FileRpcDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return forge_abi.Service.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FileRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileRpcDescriptorSupplier())
              .build();
        }
      }
    }
    return result;
  }
}
