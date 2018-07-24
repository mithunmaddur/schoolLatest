package com.school.service.rest.model;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank(message = " can't empty!")
	private String password;
	
	@NotBlank(message = " can't empty!")
	private String email;

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

	
	
	
	

}
