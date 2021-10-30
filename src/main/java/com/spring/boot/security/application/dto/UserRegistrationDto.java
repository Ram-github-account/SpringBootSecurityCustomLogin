package com.spring.boot.security.application.dto;

public class UserRegistrationDto {

	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRegistrationDto(String firstName, String lastName, String email, String password) {
		super();
		System.out.println(
				"UserRegistrationDto class : UserRegistrationDto(-,-,-,-) 4 - args constructor >>>>>>>>>>>>>>>>>");
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public UserRegistrationDto() {
		System.out.println("UserRegistrationDto class : default constructor >>>>>>>>>>>>>>>>> ");
	}

}
