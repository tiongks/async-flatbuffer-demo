package org.nuhara.demos;

import java.nio.ByteBuffer;

import org.nuhara.demos.flatbuffer.Request;
import org.nuhara.demos.flatbuffer.Response;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.protobuf.Message;

public class ResponseBuilder {
	
	public static Response build(Request request) {
		
		FlatBufferBuilder builder = new FlatBufferBuilder();
		int mti = builder.createString(mtiResponseFor(request.mti()));
		int rrn = builder.createString(request.rrn());
		int responseCode = builder.createString("00");
		int authCode = builder.createString("AB67EF");
		
		Response.startResponse(builder);
		Response.addMti(builder, mti);
		Response.addRrn(builder, rrn);
		Response.addResponseCode(builder, responseCode);
		Response.addAuthorizationCode(builder, authCode);
		int messageRoot = Response.endResponse(builder);
		builder.finish(messageRoot);
		
		ByteBuffer bb = builder.dataBuffer();
		
		Response response = Response.getRootAsResponse(bb);
		
		return response;
	}
	
public static Response build(String mtiRequest, String rrnRequest) {
		
		FlatBufferBuilder builder = new FlatBufferBuilder();
		int mti = builder.createString(mtiResponseFor(mtiRequest));
		int rrn = builder.createString(rrnRequest);
		int responseCode = builder.createString("00");
		int authCode = builder.createString("AB67EF");
		
		Response.startResponse(builder);
		Response.addMti(builder, mti);
		Response.addRrn(builder, rrn);
		Response.addResponseCode(builder, responseCode);
		Response.addAuthorizationCode(builder, authCode);
		int messageRoot = Response.endResponse(builder);
		builder.finish(messageRoot);
		
		ByteBuffer bb = builder.dataBuffer();
		
		Response response = Response.getRootAsResponse(bb);
		
		return response;
	}

protected static String mtiResponseFor(String mti) {
	char c = mti.charAt(1);
	return mti.substring(0, 2) + c + "0";
}

}
