package com.example.demo.service;

import org.springframework.http.HttpStatus;


public class ApiResponse {
	
	private String message;
	
	private HttpStatus status;
	private Object data;
	
	public ApiResponse() {
		
	}

	public ApiResponse(String message, HttpStatus status, Object data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ApiResponse(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}

	
	
}
