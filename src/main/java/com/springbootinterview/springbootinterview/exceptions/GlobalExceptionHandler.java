package com.springbootinterview.springbootinterview.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(Exception ex) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> CustomerNotFoundException(Exception ex) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(PlanNotFoundException.class)
	public ResponseEntity<String> PlanNotFoundException(Exception ex) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(NoActivePlansException.class)
	public ResponseEntity<String> NoActivePlansException(Exception ex) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(NoPlanHistoryException.class)
	public ResponseEntity<String> NoPlanHistoryException(Exception ex) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

}
