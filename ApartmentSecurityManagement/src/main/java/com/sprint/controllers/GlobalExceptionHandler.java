package com.sprint.controllers;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sprint.exceptions.RecordNotFoundException;
import com.sprint.exceptions.UserNotFoundException;
import com.sprint.util.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public ErrorMessage validationExceptionHandler(ValidationException e) {
		return new ErrorMessage("400", e.getMessage());
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserNotFoundException.class)
	public ErrorMessage userNotFoundExceptionHandler(UserNotFoundException e) {
		return new ErrorMessage("401", e.getMessage());
	}

	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorMessage MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		return new ErrorMessage("401", e.getMessage());
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RecordNotFoundException.class)
	public ErrorMessage RecordNotFoundExceptionHandler(RecordNotFoundException e) {
		return new ErrorMessage("401", e.getMessage());
	}

}
