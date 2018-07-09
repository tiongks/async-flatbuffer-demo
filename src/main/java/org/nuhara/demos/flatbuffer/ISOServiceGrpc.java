//Generated by flatc compiler (version 1.9.0)
//If you make any local changes, they will be lost
//source: iso_processor.fbs

package org.nuhara.demos.flatbuffer;

import com.google.flatbuffers.grpc.FlatbuffersUtils;

import java.nio.ByteBuffer;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: iso_processor.fbs")
public final class ISOServiceGrpc {

  private ISOServiceGrpc() {}
  
  public static final String SERVICE_NAME = "org.nuhara.demos.flatbuffer.ISOService";
  
  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getProcessMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.nuhara.demos.flatbuffer.Request,
      org.nuhara.demos.flatbuffer.Response> METHOD_PROCESS = getProcessMethod();
  
  private static volatile io.grpc.MethodDescriptor<org.nuhara.demos.flatbuffer.Request,
      org.nuhara.demos.flatbuffer.Response> getProcessMethod;
  
  private static volatile FlatbuffersUtils.FBExtactor<org.nuhara.demos.flatbuffer.Request> extractorOfRequest;
  private static FlatbuffersUtils.FBExtactor<org.nuhara.demos.flatbuffer.Request> getExtractorOfRequest() {
      if (extractorOfRequest != null) return extractorOfRequest;
      synchronized (ISOServiceGrpc.class) {
          if (extractorOfRequest != null) return extractorOfRequest;
          extractorOfRequest = new FlatbuffersUtils.FBExtactor<org.nuhara.demos.flatbuffer.Request>() {
              public org.nuhara.demos.flatbuffer.Request extract (ByteBuffer buffer) {
                  return org.nuhara.demos.flatbuffer.Request.getRootAsRequest(buffer);
              }
          };
          return extractorOfRequest;
      }
  }
  
  private static volatile FlatbuffersUtils.FBExtactor<org.nuhara.demos.flatbuffer.Response> extractorOfResponse;
  private static FlatbuffersUtils.FBExtactor<org.nuhara.demos.flatbuffer.Response> getExtractorOfResponse() {
      if (extractorOfResponse != null) return extractorOfResponse;
      synchronized (ISOServiceGrpc.class) {
          if (extractorOfResponse != null) return extractorOfResponse;
          extractorOfResponse = new FlatbuffersUtils.FBExtactor<org.nuhara.demos.flatbuffer.Response>() {
              public org.nuhara.demos.flatbuffer.Response extract (ByteBuffer buffer) {
                  return org.nuhara.demos.flatbuffer.Response.getRootAsResponse(buffer);
              }
          };
          return extractorOfResponse;
      }
  }
  
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.nuhara.demos.flatbuffer.Request,
      org.nuhara.demos.flatbuffer.Response> getProcessMethod() {
    io.grpc.MethodDescriptor<org.nuhara.demos.flatbuffer.Request, org.nuhara.demos.flatbuffer.Response> getProcessMethod;
    if ((getProcessMethod = ISOServiceGrpc.getProcessMethod) == null) {
      synchronized (ISOServiceGrpc.class) {
        if ((getProcessMethod = ISOServiceGrpc.getProcessMethod) == null) {
          ISOServiceGrpc.getProcessMethod = getProcessMethod = 
              io.grpc.MethodDescriptor.<org.nuhara.demos.flatbuffer.Request, org.nuhara.demos.flatbuffer.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "org.nuhara.demos.flatbuffer.ISOService", "Process"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(FlatbuffersUtils.marshaller(
                  org.nuhara.demos.flatbuffer.Request.class, getExtractorOfRequest()))
              .setResponseMarshaller(FlatbuffersUtils.marshaller(
                  org.nuhara.demos.flatbuffer.Response.class, getExtractorOfResponse()))
                  .setSchemaDescriptor(null)
                  .build();
          }
        }
     }
     return getProcessMethod;
  }
  
  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ISOServiceStub newStub(io.grpc.Channel channel) {
    return new ISOServiceStub(channel);
  }
  
  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ISOServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ISOServiceBlockingStub(channel);
  }
  
  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ISOServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ISOServiceFutureStub(channel);
  }
  
  /**
   */
  public static abstract class ISOServiceImplBase implements io.grpc.BindableService {
    
    /**
     */
    public     void process(org.nuhara.demos.flatbuffer.Request request,
        io.grpc.stub.StreamObserver<org.nuhara.demos.flatbuffer.Response> responseObserver)     {
      asyncUnimplementedUnaryCall(getProcessMethod(), responseObserver);
    }
    
    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.nuhara.demos.flatbuffer.Request,
                org.nuhara.demos.flatbuffer.Response>(
                  this, METHODID_PROCESS)))
          .build();
    }
  }
  
  /**
   */
  public static final class ISOServiceStub extends io.grpc.stub.AbstractStub<ISOServiceStub> {
    private ISOServiceStub(io.grpc.Channel channel) {
      super(channel);
    }
    
    private ISOServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }
    
    @java.lang.Override
    protected ISOServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ISOServiceStub(channel, callOptions);
    }
    
    /**
     */
    public     void process(org.nuhara.demos.flatbuffer.Request request,
        io.grpc.stub.StreamObserver<org.nuhara.demos.flatbuffer.Response> responseObserver)     {
      asyncServerStreamingCall(
          getChannel().newCall(getProcessMethod(), getCallOptions()), request, responseObserver);
    }
  }
  
  /**
   */
  public static final class ISOServiceBlockingStub extends io.grpc.stub.AbstractStub<ISOServiceBlockingStub> {
    private ISOServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }
    
    private ISOServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }
    
    @java.lang.Override
    protected ISOServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ISOServiceBlockingStub(channel, callOptions);
    }
    
    /**
     */
    public     java.util.Iterator<org.nuhara.demos.flatbuffer.Response> process(
        org.nuhara.demos.flatbuffer.Request request)     {
      return blockingServerStreamingCall(
          getChannel(), getProcessMethod(), getCallOptions(), request);
    }
  }
  
  /**
   */
  public static final class ISOServiceFutureStub extends io.grpc.stub.AbstractStub<ISOServiceFutureStub> {
    private ISOServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }
    
    private ISOServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }
    
    @java.lang.Override
    protected ISOServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ISOServiceFutureStub(channel, callOptions);
    }
  }
  
  private static final int METHODID_PROCESS = 0;
  
  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ISOServiceImplBase serviceImpl;
    private final int methodId;
  
    MethodHandlers(ISOServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }
  
    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS:
          serviceImpl.process((org.nuhara.demos.flatbuffer.Request) request,
              (io.grpc.stub.StreamObserver<org.nuhara.demos.flatbuffer.Response>) responseObserver);
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
  
  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;
  
  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ISOServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)              
              .setSchemaDescriptor(null)              
              .addMethod(getProcessMethod())              
              .build();
        }
      }
    }
    return result;
  }
}