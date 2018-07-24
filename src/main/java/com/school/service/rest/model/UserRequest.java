package com.school.service.rest.model;

import javax.validation.constraints.NotBlank;

public class UserRequest {
	

	private String password;
	
	@NotBlank(message = " can't empty!")
	private String email;
	
	private String bio;
	
	@NotBlank(message = " can't empty!")
	private String userName;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
	

}
