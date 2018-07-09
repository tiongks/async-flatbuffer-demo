package org.nuhara.demos;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.nuhara.demos.flatbuffer.ISOServiceGrpc;
import org.nuhara.demos.flatbuffer.Request;
import org.nuhara.demos.flatbuffer.Response;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.contrib.ClientTracingInterceptor;
import io.opentracing.contrib.OpenTracingContextKey;

public class FlatClient {
	
	final static Logger logger = Logger.getAnonymousLogger();
	
	public static void main(String[] args) {
		final ManagedChannel channel = ManagedChannelBuilder
				.forTarget("localhost:7171")
				.usePlaintext()
				.build();
		
		Tracer tracer = Tracing.initTracer(Tracing.APP_NAME);
		ClientTracingInterceptor tracingInterceptor = new ClientTracingInterceptor(tracer);
		
		ISOServiceGrpc.ISOServiceStub stub = ISOServiceGrpc.newStub(tracingInterceptor.intercept(channel));
		
		ArrayList<Request> requestList = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			Request request = MessageBuilder.buildRequest("0200", Integer.toString(i * 100), "Client Request.");
			requestList.add(request);
		}
		
		for (Request request: requestList) {
			logger.info("Sending: " + request.rrn());
			Span span = tracer.buildSpan(request.rrn()).start();
			span.log("client-start");
			stub.process(request, new StreamObserver<Response>() {

				@Override
				public void onNext(Response value) {
					span.log("client-next");
					logger.info("Response: " + value.mti() + "-" + value.rrn());
				}

				@Override
				public void onError(Throwable t) {
					logger.warning(t.getMessage());
				}

				@Override
				public void onCompleted() {
					span.log("client-complete");
					span.finish();
					channel.shutdown();	
				}
			});
		}
	}

}
