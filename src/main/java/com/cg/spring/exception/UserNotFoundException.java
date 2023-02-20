package com.cg.spring.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	*/
	public UserNotFoundException(String message) {
		super(message);
		
	}
	

}
