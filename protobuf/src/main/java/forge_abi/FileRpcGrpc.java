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
public final class FileRpcGrpc {

  private FileRpcGrpc() {}

  public static final String SERVICE_NAME = "forge_abi.FileRpc";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestStoreFile,
      forge_abi.Rpc.ResponseStoreFile> METHOD_STORE_FILE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestStoreFile, forge_abi.Rpc.ResponseStoreFile>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.FileRpc", "store_file"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestStoreFile.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseStoreFile.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestLoadFile,
      forge_abi.Rpc.ResponseLoadFile> METHOD_LOAD_FILE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestLoadFile, forge_abi.Rpc.ResponseLoadFile>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.FileRpc", "load_file"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestLoadFile.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponseLoadFile.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<forge_abi.Rpc.RequestPinFile,
      forge_abi.Rpc.ResponsePinFile> METHOD_PIN_FILE =
      io.grpc.MethodDescriptor.<forge_abi.Rpc.RequestPinFile, forge_abi.Rpc.ResponsePinFile>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "forge_abi.FileRpc", "pin_file"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.RequestPinFile.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              forge_abi.Rpc.ResponsePinFile.getDefaultInstance()))
          .build();

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
   */
  public static abstract class FileRpcImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * filesystem related
     * </pre>
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestStoreFile> storeFile(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseStoreFile> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_STORE_FILE, responseObserver);
    }

    /**
     */
    public void loadFile(forge_abi.Rpc.RequestLoadFile request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseLoadFile> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOAD_FILE, responseObserver);
    }

    /**
     */
    public void pinFile(forge_abi.Rpc.RequestPinFile request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponsePinFile> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PIN_FILE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_STORE_FILE,
            asyncClientStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestStoreFile,
                forge_abi.Rpc.ResponseStoreFile>(
                  this, METHODID_STORE_FILE)))
          .addMethod(
            METHOD_LOAD_FILE,
            asyncServerStreamingCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestLoadFile,
                forge_abi.Rpc.ResponseLoadFile>(
                  this, METHODID_LOAD_FILE)))
          .addMethod(
            METHOD_PIN_FILE,
            asyncUnaryCall(
              new MethodHandlers<
                forge_abi.Rpc.RequestPinFile,
                forge_abi.Rpc.ResponsePinFile>(
                  this, METHODID_PIN_FILE)))
          .build();
    }
  }

  /**
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

    /**
     * <pre>
     * filesystem related
     * </pre>
     */
    public io.grpc.stub.StreamObserver<forge_abi.Rpc.RequestStoreFile> storeFile(
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseStoreFile> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_STORE_FILE, getCallOptions()), responseObserver);
    }

    /**
     */
    public void loadFile(forge_abi.Rpc.RequestLoadFile request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseLoadFile> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_LOAD_FILE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pinFile(forge_abi.Rpc.RequestPinFile request,
        io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponsePinFile> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PIN_FILE, getCallOptions()), request, responseObserver);
    }
  }

  /**
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

    /**
     */
    public java.util.Iterator<forge_abi.Rpc.ResponseLoadFile> loadFile(
        forge_abi.Rpc.RequestLoadFile request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_LOAD_FILE, getCallOptions(), request);
    }

    /**
     */
    public forge_abi.Rpc.ResponsePinFile pinFile(forge_abi.Rpc.RequestPinFile request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PIN_FILE, getCallOptions(), request);
    }
  }

  /**
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<forge_abi.Rpc.ResponsePinFile> pinFile(
        forge_abi.Rpc.RequestPinFile request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PIN_FILE, getCallOptions()), request);
    }
  }

  private static final int METHODID_LOAD_FILE = 0;
  private static final int METHODID_PIN_FILE = 1;
  private static final int METHODID_STORE_FILE = 2;

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
        case METHODID_LOAD_FILE:
          serviceImpl.loadFile((forge_abi.Rpc.RequestLoadFile) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseLoadFile>) responseObserver);
          break;
        case METHODID_PIN_FILE:
          serviceImpl.pinFile((forge_abi.Rpc.RequestPinFile) request,
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponsePinFile>) responseObserver);
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
        case METHODID_STORE_FILE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.storeFile(
              (io.grpc.stub.StreamObserver<forge_abi.Rpc.ResponseStoreFile>) responseObserver);
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
              .addMethod(METHOD_STORE_FILE)
              .addMethod(METHOD_LOAD_FILE)
              .addMethod(METHOD_PIN_FILE)
              .build();
        }
      }
    }
    return result;
  }
}
