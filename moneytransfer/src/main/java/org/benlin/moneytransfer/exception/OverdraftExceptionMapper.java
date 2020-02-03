package org.benlin.moneytransfer.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.benlin.moneytransfer.model.ErrorMessage;

@Provider
public class OverdraftExceptionMapper implements ExceptionMapper<OverdraftException>{

	@Override
	public Response toResponse(OverdraftException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 400);
		return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
	}
	

}
