package com.springbootinterview.springbootinterview.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	

}
