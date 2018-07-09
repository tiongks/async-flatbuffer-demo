package org.nuhara.demos;

import static org.junit.Assert.*;

import org.junit.Test;
import org.nuhara.demos.ResponseBuilder;
import org.nuhara.demos.flatbuffer.Response;

public class MessageBuilderTest {
	
	@Test
	public void testMtiResponse() {
		assertEquals("0220", ResponseBuilder.mtiResponseFor("0200"));
		assertEquals("0110", ResponseBuilder.mtiResponseFor("0100"));
	}

	@Test
	public void testFinMessage() {
		
		String mti = "0200";
		String rrn = "234789";
//		String message = "hello flat world";
//		String responseCode = "";
		
		Response request = ResponseBuilder.build(mti, rrn);
		
		assertEquals("0220", request.mti());
		assertEquals(rrn, request.rrn());
		assertEquals("00", request.responseCode());
		assertNotNull(request.authorizationCode());
	}
	
	@Test
	public void testAuthRequest() {
		
		String mti = "0100";
		String rrn = "234789";
//		String message = "hello flat world";
//		String responseCode = "";
		
		Response request = ResponseBuilder.build(mti, rrn);
		
		assertEquals("0110", request.mti());
		assertEquals(rrn, request.rrn());
		assertEquals("00", request.responseCode());
		assertNotNull(request.authorizationCode());
	}

}
