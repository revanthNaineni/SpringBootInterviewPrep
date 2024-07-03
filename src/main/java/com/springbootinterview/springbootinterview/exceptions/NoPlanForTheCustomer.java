package com.springbootinterview.springbootinterview.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoPlanForTheCustomer extends Exception {
	
	public NoPlanForTheCustomer(String message){
		super(message);
	}

}
