package com.sprint.exceptions;

import java.util.Date;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)  
	//Override method of ExceptionMessage class  
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {  

		//creating exception response structure  
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));

		//returning exception structure and specific status   
		return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);  
	}

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<Object> validationExceptionHandler(ValidationException ex, WebRequest request) {
		//creating exception response structure  
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));

		//returning exception structure and specific status   
		return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST); 
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundExceptionHandler(UserNotFoundException ex, WebRequest request) {
		//creating exception response structure  
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));

		//returning exception structure and specific status   
		return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST); 
	}


	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex, WebRequest request) {
		//creating exception response structure  
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));

		//returning exception structure and specific status   
		return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST); 
	}


	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<Object> RecordNotFoundExceptionHandler(RecordNotFoundException ex, WebRequest request) {
		//creating exception response structure  
		ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(), request.getDescription(false));

		//returning exception structure and specific status   
		return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST); 
	}

}
