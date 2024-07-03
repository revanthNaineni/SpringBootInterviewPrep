package com.springbootinterview.springbootinterview.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootinterview.springbootinterview.exceptions.UserNotFoundException;
import com.springbootinterview.springbootinterview.models.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	static List<User> users=new ArrayList<User>();
	
	static {
		User user1=new User("Dembele",26,1);
		User user2=new User("Reus",31,2);
		User user3=new User("Gavi",19,3);
		User user4=new User("Xavi",20,4);
		User user5=new User("Messi",10,5);
		User user6=new User("Neymar",11,6);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
	}
	
	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<User> getuser(@PathVariable int id) {
		logger.info("Hello Dembele");
		logger.info("Hello Messi");
		logger.error("Hello Reus");
		User user = users.get(id);
		if (user == null) {
			throw new UserNotFoundException("user with id "+id +" doesn't exists");
		} else {
			ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
			return responseEntity;
		}
	}
	
	@PostMapping(value = "/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user){
		users.add(user);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("User added", HttpStatus.CREATED);
		return responseEntity;
		
	}

}
