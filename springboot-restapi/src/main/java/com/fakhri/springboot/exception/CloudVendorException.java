package com.fakhri.springboot.exception;

import org.springframework.http.HttpStatus;

public class CloudVendorException {
	private final String message;
	private final Throwable thowable;
	private final HttpStatus httpStatus;
	
	public CloudVendorException(String message, Throwable thowable, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.thowable = thowable;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getThowable() {
		return thowable;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	
	
	

}
