package abci_vendor;

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
    comments = "Source: vendor.proto")
public final class ABCIApplicationGrpc {

  private ABCIApplicationGrpc() {}

  public static final String SERVICE_NAME = "abci_vendor.ABCIApplication";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestEcho,
      abci_vendor.Vendor.ResponseEcho> METHOD_ECHO =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestEcho, abci_vendor.Vendor.ResponseEcho>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "Echo"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestEcho.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseEcho.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestFlush,
      abci_vendor.Vendor.ResponseFlush> METHOD_FLUSH =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestFlush, abci_vendor.Vendor.ResponseFlush>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "Flush"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestFlush.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseFlush.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestInfo,
      abci_vendor.Vendor.ResponseInfo> METHOD_INFO =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestInfo, abci_vendor.Vendor.ResponseInfo>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "Info"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestInfo.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseInfo.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestSetOption,
      abci_vendor.Vendor.ResponseSetOption> METHOD_SET_OPTION =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestSetOption, abci_vendor.Vendor.ResponseSetOption>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "SetOption"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestSetOption.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseSetOption.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestDeliverTx,
      abci_vendor.Vendor.ResponseDeliverTx> METHOD_DELIVER_TX =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestDeliverTx, abci_vendor.Vendor.ResponseDeliverTx>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "DeliverTx"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestDeliverTx.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseDeliverTx.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestCheckTx,
      abci_vendor.Vendor.ResponseCheckTx> METHOD_CHECK_TX =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestCheckTx, abci_vendor.Vendor.ResponseCheckTx>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "CheckTx"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestCheckTx.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseCheckTx.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestQuery,
      abci_vendor.Vendor.ResponseQuery> METHOD_QUERY =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestQuery, abci_vendor.Vendor.ResponseQuery>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "Query"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestQuery.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseQuery.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestCommit,
      abci_vendor.Vendor.ResponseCommit> METHOD_COMMIT =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestCommit, abci_vendor.Vendor.ResponseCommit>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "Commit"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestCommit.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseCommit.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestInitChain,
      abci_vendor.Vendor.ResponseInitChain> METHOD_INIT_CHAIN =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestInitChain, abci_vendor.Vendor.ResponseInitChain>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "InitChain"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestInitChain.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseInitChain.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestBeginBlock,
      abci_vendor.Vendor.ResponseBeginBlock> METHOD_BEGIN_BLOCK =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestBeginBlock, abci_vendor.Vendor.ResponseBeginBlock>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "BeginBlock"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestBeginBlock.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseBeginBlock.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<abci_vendor.Vendor.RequestEndBlock,
      abci_vendor.Vendor.ResponseEndBlock> METHOD_END_BLOCK =
      io.grpc.MethodDescriptor.<abci_vendor.Vendor.RequestEndBlock, abci_vendor.Vendor.ResponseEndBlock>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "abci_vendor.ABCIApplication", "EndBlock"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.RequestEndBlock.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              abci_vendor.Vendor.ResponseEndBlock.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ABCIApplicationStub newStub(io.grpc.Channel channel) {
    return new ABCIApplicationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ABCIApplicationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ABCIApplicationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ABCIApplicationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ABCIApplicationFutureStub(channel);
  }

  /**
   */
  public static abstract class ABCIApplicationImplBase implements io.grpc.BindableService {

    /**
     */
    public void echo(abci_vendor.Vendor.RequestEcho request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseEcho> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ECHO, responseObserver);
    }

    /**
     */
    public void flush(abci_vendor.Vendor.RequestFlush request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseFlush> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FLUSH, responseObserver);
    }

    /**
     */
    public void info(abci_vendor.Vendor.RequestInfo request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseInfo> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INFO, responseObserver);
    }

    /**
     */
    public void setOption(abci_vendor.Vendor.RequestSetOption request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseSetOption> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_OPTION, responseObserver);
    }

    /**
     */
    public void deliverTx(abci_vendor.Vendor.RequestDeliverTx request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseDeliverTx> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELIVER_TX, responseObserver);
    }

    /**
     */
    public void checkTx(abci_vendor.Vendor.RequestCheckTx request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseCheckTx> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHECK_TX, responseObserver);
    }

    /**
     */
    public void query(abci_vendor.Vendor.RequestQuery request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseQuery> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_QUERY, responseObserver);
    }

    /**
     */
    public void commit(abci_vendor.Vendor.RequestCommit request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseCommit> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_COMMIT, responseObserver);
    }

    /**
     */
    public void initChain(abci_vendor.Vendor.RequestInitChain request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseInitChain> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_INIT_CHAIN, responseObserver);
    }

    /**
     */
    public void beginBlock(abci_vendor.Vendor.RequestBeginBlock request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseBeginBlock> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_BEGIN_BLOCK, responseObserver);
    }

    /**
     */
    public void endBlock(abci_vendor.Vendor.RequestEndBlock request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseEndBlock> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_END_BLOCK, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ECHO,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestEcho,
                abci_vendor.Vendor.ResponseEcho>(
                  this, METHODID_ECHO)))
          .addMethod(
            METHOD_FLUSH,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestFlush,
                abci_vendor.Vendor.ResponseFlush>(
                  this, METHODID_FLUSH)))
          .addMethod(
            METHOD_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestInfo,
                abci_vendor.Vendor.ResponseInfo>(
                  this, METHODID_INFO)))
          .addMethod(
            METHOD_SET_OPTION,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestSetOption,
                abci_vendor.Vendor.ResponseSetOption>(
                  this, METHODID_SET_OPTION)))
          .addMethod(
            METHOD_DELIVER_TX,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestDeliverTx,
                abci_vendor.Vendor.ResponseDeliverTx>(
                  this, METHODID_DELIVER_TX)))
          .addMethod(
            METHOD_CHECK_TX,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestCheckTx,
                abci_vendor.Vendor.ResponseCheckTx>(
                  this, METHODID_CHECK_TX)))
          .addMethod(
            METHOD_QUERY,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestQuery,
                abci_vendor.Vendor.ResponseQuery>(
                  this, METHODID_QUERY)))
          .addMethod(
            METHOD_COMMIT,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestCommit,
                abci_vendor.Vendor.ResponseCommit>(
                  this, METHODID_COMMIT)))
          .addMethod(
            METHOD_INIT_CHAIN,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestInitChain,
                abci_vendor.Vendor.ResponseInitChain>(
                  this, METHODID_INIT_CHAIN)))
          .addMethod(
            METHOD_BEGIN_BLOCK,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestBeginBlock,
                abci_vendor.Vendor.ResponseBeginBlock>(
                  this, METHODID_BEGIN_BLOCK)))
          .addMethod(
            METHOD_END_BLOCK,
            asyncUnaryCall(
              new MethodHandlers<
                abci_vendor.Vendor.RequestEndBlock,
                abci_vendor.Vendor.ResponseEndBlock>(
                  this, METHODID_END_BLOCK)))
          .build();
    }
  }

  /**
   */
  public static final class ABCIApplicationStub extends io.grpc.stub.AbstractStub<ABCIApplicationStub> {
    private ABCIApplicationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ABCIApplicationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ABCIApplicationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ABCIApplicationStub(channel, callOptions);
    }

    /**
     */
    public void echo(abci_vendor.Vendor.RequestEcho request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseEcho> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void flush(abci_vendor.Vendor.RequestFlush request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseFlush> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FLUSH, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void info(abci_vendor.Vendor.RequestInfo request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setOption(abci_vendor.Vendor.RequestSetOption request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseSetOption> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_OPTION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deliverTx(abci_vendor.Vendor.RequestDeliverTx request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseDeliverTx> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELIVER_TX, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkTx(abci_vendor.Vendor.RequestCheckTx request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseCheckTx> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHECK_TX, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void query(abci_vendor.Vendor.RequestQuery request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseQuery> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_QUERY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void commit(abci_vendor.Vendor.RequestCommit request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseCommit> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_COMMIT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void initChain(abci_vendor.Vendor.RequestInitChain request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseInitChain> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_INIT_CHAIN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void beginBlock(abci_vendor.Vendor.RequestBeginBlock request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseBeginBlock> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_BEGIN_BLOCK, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void endBlock(abci_vendor.Vendor.RequestEndBlock request,
        io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseEndBlock> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_END_BLOCK, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ABCIApplicationBlockingStub extends io.grpc.stub.AbstractStub<ABCIApplicationBlockingStub> {
    private ABCIApplicationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ABCIApplicationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ABCIApplicationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ABCIApplicationBlockingStub(channel, callOptions);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseEcho echo(abci_vendor.Vendor.RequestEcho request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ECHO, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseFlush flush(abci_vendor.Vendor.RequestFlush request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FLUSH, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseInfo info(abci_vendor.Vendor.RequestInfo request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INFO, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseSetOption setOption(abci_vendor.Vendor.RequestSetOption request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_OPTION, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseDeliverTx deliverTx(abci_vendor.Vendor.RequestDeliverTx request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELIVER_TX, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseCheckTx checkTx(abci_vendor.Vendor.RequestCheckTx request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHECK_TX, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseQuery query(abci_vendor.Vendor.RequestQuery request) {
      return blockingUnaryCall(
          getChannel(), METHOD_QUERY, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseCommit commit(abci_vendor.Vendor.RequestCommit request) {
      return blockingUnaryCall(
          getChannel(), METHOD_COMMIT, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseInitChain initChain(abci_vendor.Vendor.RequestInitChain request) {
      return blockingUnaryCall(
          getChannel(), METHOD_INIT_CHAIN, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseBeginBlock beginBlock(abci_vendor.Vendor.RequestBeginBlock request) {
      return blockingUnaryCall(
          getChannel(), METHOD_BEGIN_BLOCK, getCallOptions(), request);
    }

    /**
     */
    public abci_vendor.Vendor.ResponseEndBlock endBlock(abci_vendor.Vendor.RequestEndBlock request) {
      return blockingUnaryCall(
          getChannel(), METHOD_END_BLOCK, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ABCIApplicationFutureStub extends io.grpc.stub.AbstractStub<ABCIApplicationFutureStub> {
    private ABCIApplicationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ABCIApplicationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ABCIApplicationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ABCIApplicationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseEcho> echo(
        abci_vendor.Vendor.RequestEcho request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseFlush> flush(
        abci_vendor.Vendor.RequestFlush request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FLUSH, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseInfo> info(
        abci_vendor.Vendor.RequestInfo request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INFO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseSetOption> setOption(
        abci_vendor.Vendor.RequestSetOption request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_OPTION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseDeliverTx> deliverTx(
        abci_vendor.Vendor.RequestDeliverTx request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELIVER_TX, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseCheckTx> checkTx(
        abci_vendor.Vendor.RequestCheckTx request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHECK_TX, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseQuery> query(
        abci_vendor.Vendor.RequestQuery request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_QUERY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseCommit> commit(
        abci_vendor.Vendor.RequestCommit request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_COMMIT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseInitChain> initChain(
        abci_vendor.Vendor.RequestInitChain request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_INIT_CHAIN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseBeginBlock> beginBlock(
        abci_vendor.Vendor.RequestBeginBlock request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_BEGIN_BLOCK, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<abci_vendor.Vendor.ResponseEndBlock> endBlock(
        abci_vendor.Vendor.RequestEndBlock request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_END_BLOCK, getCallOptions()), request);
    }
  }

  private static final int METHODID_ECHO = 0;
  private static final int METHODID_FLUSH = 1;
  private static final int METHODID_INFO = 2;
  private static final int METHODID_SET_OPTION = 3;
  private static final int METHODID_DELIVER_TX = 4;
  private static final int METHODID_CHECK_TX = 5;
  private static final int METHODID_QUERY = 6;
  private static final int METHODID_COMMIT = 7;
  private static final int METHODID_INIT_CHAIN = 8;
  private static final int METHODID_BEGIN_BLOCK = 9;
  private static final int METHODID_END_BLOCK = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ABCIApplicationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ABCIApplicationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ECHO:
          serviceImpl.echo((abci_vendor.Vendor.RequestEcho) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseEcho>) responseObserver);
          break;
        case METHODID_FLUSH:
          serviceImpl.flush((abci_vendor.Vendor.RequestFlush) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseFlush>) responseObserver);
          break;
        case METHODID_INFO:
          serviceImpl.info((abci_vendor.Vendor.RequestInfo) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseInfo>) responseObserver);
          break;
        case METHODID_SET_OPTION:
          serviceImpl.setOption((abci_vendor.Vendor.RequestSetOption) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseSetOption>) responseObserver);
          break;
        case METHODID_DELIVER_TX:
          serviceImpl.deliverTx((abci_vendor.Vendor.RequestDeliverTx) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseDeliverTx>) responseObserver);
          break;
        case METHODID_CHECK_TX:
          serviceImpl.checkTx((abci_vendor.Vendor.RequestCheckTx) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseCheckTx>) responseObserver);
          break;
        case METHODID_QUERY:
          serviceImpl.query((abci_vendor.Vendor.RequestQuery) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseQuery>) responseObserver);
          break;
        case METHODID_COMMIT:
          serviceImpl.commit((abci_vendor.Vendor.RequestCommit) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseCommit>) responseObserver);
          break;
        case METHODID_INIT_CHAIN:
          serviceImpl.initChain((abci_vendor.Vendor.RequestInitChain) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseInitChain>) responseObserver);
          break;
        case METHODID_BEGIN_BLOCK:
          serviceImpl.beginBlock((abci_vendor.Vendor.RequestBeginBlock) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseBeginBlock>) responseObserver);
          break;
        case METHODID_END_BLOCK:
          serviceImpl.endBlock((abci_vendor.Vendor.RequestEndBlock) request,
              (io.grpc.stub.StreamObserver<abci_vendor.Vendor.ResponseEndBlock>) responseObserver);
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

  private static final class ABCIApplicationDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return abci_vendor.Vendor.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ABCIApplicationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ABCIApplicationDescriptorSupplier())
              .addMethod(METHOD_ECHO)
              .addMethod(METHOD_FLUSH)
              .addMethod(METHOD_INFO)
              .addMethod(METHOD_SET_OPTION)
              .addMethod(METHOD_DELIVER_TX)
              .addMethod(METHOD_CHECK_TX)
              .addMethod(METHOD_QUERY)
              .addMethod(METHOD_COMMIT)
              .addMethod(METHOD_INIT_CHAIN)
              .addMethod(METHOD_BEGIN_BLOCK)
              .addMethod(METHOD_END_BLOCK)
              .build();
        }
      }
    }
    return result;
  }
}
