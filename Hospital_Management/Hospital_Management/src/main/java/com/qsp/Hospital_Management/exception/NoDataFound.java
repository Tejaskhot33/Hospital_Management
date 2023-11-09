package com.qsp.Hospital_Management.exception;

public class NoDataFound extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public NoDataFound(String message) {
		super();
		this.message = message;

	}

}
