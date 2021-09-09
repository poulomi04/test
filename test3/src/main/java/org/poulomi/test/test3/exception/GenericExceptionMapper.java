package org.poulomi.test.test3.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/*
 * @Provider public class GenericExceptionMapper implements
 * ExceptionMapper<Exception>{
 * 
 * @Override public Response toResponse(Exception exception) { //ErrorMessage
 * em=new ErrorMessage(400,exception.getMessage(),"www.google.com");
 * 
 * return Response.status(Status.NOT_IMPLEMENTED). entity("Generic Exception" +
 * exception.getMessage()).build();
 * 
 * //return Response.status(400). entity(em).build(); }
 * 
 * 
 * }
 */
public class GenericExceptionMapper{
	
}