package com.qsp.Hospital_Management.exception;

public class PinCodeNotFound extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public PinCodeNotFound(String message) {
		super();
		this.message = message;

	}

}
