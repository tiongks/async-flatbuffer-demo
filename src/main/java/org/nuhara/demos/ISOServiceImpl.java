package org.nuhara.demos;

import java.util.logging.Logger;

import org.nuhara.demos.flatbuffer.ISOServiceGrpc.ISOServiceImplBase;
import org.nuhara.demos.flatbuffer.Request;
import org.nuhara.demos.flatbuffer.Response;

import io.grpc.stub.StreamObserver;

public class ISOServiceImpl extends ISOServiceImplBase {
	
	@Override
	public void process(Request request, StreamObserver<Response> responseObserver) {
		// TODO Auto-generated method stub
		super.process(request, responseObserver);
	}

	private static final Logger logger = Logger.getAnonymousLogger();

	
	

}
