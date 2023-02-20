package com.cg.spring.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public  ResponseEntity<ErroDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		ErroDetails details = new ErroDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErroDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
}
	
	@ExceptionHandler(UserNotFoundException.class)
	public  ResponseEntity<ErroDetails> userNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErroDetails details = new ErroDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErroDetails>(details, HttpStatus.NOT_FOUND);
		
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErroDetails details = new ErroDetails(LocalDateTime.now(), "total errors:" + ex.getErrorCount() + ", first Error: "+ ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		return new ResponseEntity(details,HttpStatus.BAD_REQUEST);
	}
}
