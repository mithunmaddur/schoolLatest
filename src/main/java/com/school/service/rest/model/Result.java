package com.school.service.rest.model;

import java.util.ArrayList;

import java.util.Map;


public class Result {

    private Map<String, ArrayList<String>>  errors;
    

	public Map<String, ArrayList<String>> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, ArrayList<String>> errors) {
		this.errors = errors;
	}
}
