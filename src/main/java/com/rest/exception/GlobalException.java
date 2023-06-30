package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nullPointerEceptionHandler(NullPointerException ex) {
		return new ResponseEntity<String>("No customer found with the given "+ex.getMessage(), HttpStatus.ACCEPTED);
	}
	
//	@ExceptionHandler(NullPointerException.class)
//	public String nullPointerEceptionHandler(NullPointerException ex) {
//		return "No Customer found "+ex.getMessage();
//	}
}
