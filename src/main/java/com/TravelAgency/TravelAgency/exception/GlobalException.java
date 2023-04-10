package com.TravelAgency.TravelAgency.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<String> customExceptionHandler(CustomException e){
		String message = e.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}
}
