package com.dashflow.API.Controllers.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CitizenAlreadyExistsException.class)
	public ResponseEntity<StandardError> citizenAlreadyExists(CitizenAlreadyExistsException exception, HttpServletRequest req) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), "Cliente já existe!", exception.getMessage(), req.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)	
	public ResponseEntity<StandardError> ObjectNotFoundException(ObjectNotFoundException exception, HttpServletRequest req) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Cliente não encontrado!", exception.getMessage(), req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
