package com.qsp.Hospital_Management.exception;

public class IdNotFound extends RuntimeException{

	private String message;
	
	public String getMessage() {
		return message;
	}
	public IdNotFound(String message) {
		super();
		this.message=message;
	}
}
