package com.cg.spring.exception;

import java.time.LocalDateTime;

public class ErroDetails extends Exception{

	private LocalDateTime timeStamp;
	private String message;
	private String details;
	/**
	 * @param timeStamp
	 * @param message
	 * @param details
	 */
	public ErroDetails(LocalDateTime timeStamp, String message, String description) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = description;
	}
	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	
	
}
