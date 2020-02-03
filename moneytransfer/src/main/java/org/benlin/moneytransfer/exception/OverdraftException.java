package org.benlin.moneytransfer.exception;

public class OverdraftException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 795323488545727029L;
	
	public OverdraftException(String message) {
		super(message);
	}

}
