package com.sprint.exceptions;

import java.util.Date;

/**
 * @author SAI VAMSI KRISHNA
 *
 */
public class ExceptionMessage {

	private Date timestamp;
	private String message;
	private String details;

	// Default constructor
	public ExceptionMessage() {
		super();
	}

	// Parameterized constructor
	/**
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ExceptionMessage(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	// Getters Setters
	/**
	 * @return
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 */
	public void setDetails(String details) {
		this.details = details;
	}
}