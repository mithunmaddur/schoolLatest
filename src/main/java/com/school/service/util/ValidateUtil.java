package com.school.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.school.service.rest.model.Result;




public class ValidateUtil {
	
	
	public static ResponseEntity<?>  validateErrors(Errors errors) {
		
		
		if(errors.hasErrors()){
			 Map<String, ArrayList<String>>  FinalError = 	errors
			        	.getAllErrors()
			        	.stream()
			        	.filter(error -> error instanceof FieldError)
			        	.collect(Collectors.toMap((ObjectError e) -> {
			        		FieldError fe = (FieldError)e;
			        		return fe.getField();
			        	}, (ObjectError e) ->{
			        		 ArrayList<String> defaultMessage = new ArrayList<>();
			        		 defaultMessage.add(e.getDefaultMessage());
			        		 return defaultMessage;
			        	}));
			 
			 Result result = new Result();
			 result.setErrors(FinalError);
			 return ResponseEntity.badRequest().body(result);
		
		}
		return null;
		 
	}
	
	public static  ResponseEntity<?>  generateErrorRespose(String key ,  String errorMessage){
		
		ArrayList<String> defaultMessage = new ArrayList<>();
		 defaultMessage.add(errorMessage);
		 Map<String, ArrayList<String>>  errorRes = new HashMap<String, ArrayList<String>>();
		 errorRes.put(key, defaultMessage);
		 Result result = new Result();
		 result.setErrors(errorRes);
		 return ResponseEntity.badRequest().body(result);
		
	}

}
