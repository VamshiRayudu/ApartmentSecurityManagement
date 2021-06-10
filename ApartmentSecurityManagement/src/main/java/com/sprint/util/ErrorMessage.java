package com.sprint.util;

public class ErrorMessage {
	
	private String status;
	private String message;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorMessage(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ErrorMessage [status=" + status + ", message=" + message + "]";
	}
}