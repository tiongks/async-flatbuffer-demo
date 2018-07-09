package org.nuhara.demos;

import java.util.logging.Logger;

import org.nuhara.demos.flatbuffer.ISOServiceGrpc.ISOServiceImplBase;
import org.nuhara.demos.flatbuffer.Request;
import org.nuhara.demos.flatbuffer.Response;

import io.grpc.stub.StreamObserver;
import io.opentracing.Span;
import io.opentracing.contrib.OpenTracingContextKey;

public class ISOServiceImpl extends ISOServiceImplBase {
	
	private static final Logger logger = Logger.getLogger(ISOServiceImpl.class.getCanonicalName());
	
	@Override
	public void process(Request request, StreamObserver<Response> responseObserver) {
		
		logger.info("Received: " + request.mti() + "-" + request.rrn());
		
		Span span = OpenTracingContextKey.activeSpan();
		span.log("server-process");
		span.setTag("rrn", request.rrn());
		span.setTag("span.kind", "server");
		
		Response response = MessageBuilder.buildResponse(request);
		
		responseObserver.onNext(response);
		
		responseObserver.onCompleted();
		
	}


}
