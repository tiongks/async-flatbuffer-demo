package org.nuhara.demos;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.opentracing.Tracer;
import io.opentracing.contrib.ServerTracingInterceptor;

public class FlatServer {
	
	private static final Logger logger = Logger.getLogger(FlatServer.class.getCanonicalName());
	private static final Tracer tracer = Tracing.initTracer(Tracing.APP_NAME);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ServerTracingInterceptor tracingInterceptor = new ServerTracingInterceptor(tracer);
		
		Server server = ServerBuilder.forPort(7171)
				.addService(tracingInterceptor.intercept(new ISOServiceImpl()))
//				.addService(new ISOServiceImpl())
				.build();
		
		server.start();
		
		logger.info("FlatBuffer gRPC Server Started.");
		
		server.awaitTermination();
	}

}
