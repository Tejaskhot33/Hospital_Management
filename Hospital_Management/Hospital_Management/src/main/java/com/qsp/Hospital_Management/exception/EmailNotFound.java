package com.qsp.Hospital_Management.exception;

public class EmailNotFound extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;

	}

	public EmailNotFound(String message) {
		super();
		this.message = message;
	}

}
