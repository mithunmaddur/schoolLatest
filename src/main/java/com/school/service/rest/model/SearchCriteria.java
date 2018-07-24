package com.school.service.rest.model;

import javax.validation.constraints.NotBlank;



public class SearchCriteria {
	
	@NotBlank(message = "username can't empty!")
    String username;
	
	@NotBlank(message = "age can't empty!")
	String age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
