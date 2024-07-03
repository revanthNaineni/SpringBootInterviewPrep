package com.springbootinterview.springbootinterview.models;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class User {

	private String userName;
	private Integer userAge;
	private Integer userId;

	public User(String userName, Integer userAge, Integer userId) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
