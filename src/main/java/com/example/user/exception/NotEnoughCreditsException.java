package com.example.user.exception;

public class NotEnoughCreditsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotEnoughCreditsException() {
		super();
	}

	public NotEnoughCreditsException(String message, Throwable cause) {
		super(message, cause);		
	}

	public NotEnoughCreditsException(String message) {
		super(message);		
	}

	public NotEnoughCreditsException(Throwable cause) {
		super(cause);		
	}
}
