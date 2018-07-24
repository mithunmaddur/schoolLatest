package com.school.service.rest;

import javax.validation.Valid;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.service.rest.model.StudentRequest;
import com.school.service.service.StudentService;
import com.school.service.service.UserLoginService;
import com.school.service.util.ValidateUtil;



@CrossOrigin(origins = "http://localhost:4100/*", maxAge = 3600)
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private UserLoginService userLoginService;
	
	 @RequestMapping(path = "/v1/createstudent", method = RequestMethod.POST)
	    public ResponseEntity<?> createStudent(
			@Valid @RequestBody StudentRequest studentRequest, Errors errors, @RequestHeader("Accept-Encoding") String encoding, @RequestHeader("token") String token) throws ApplicationException {
		 
			 ResponseEntity<?>  responseEntity =  userLoginService.validateTokenUser(token);
			 if(responseEntity != null) return responseEntity;
		   //If error, just return a 400 bad request, along with the error message 
	               responseEntity =ValidateUtil.validateErrors(errors) ;
	       if(responseEntity != null) return responseEntity;
	       
	       return studentService.addStudent(studentRequest);
	       
	    	   
	 }
	 
	 
	 @RequestMapping(path = "/v1/updateStudent", method = RequestMethod.POST)
	    public ResponseEntity<?> UpdateStudent(
			@Valid @RequestBody StudentRequest studentRequest, Errors errors, @RequestHeader("Accept-Encoding") String encoding, @RequestHeader("token") String token) throws ApplicationException {
		 
		   //If error, just return a 400 bad request, along with the error message 
	        ResponseEntity<?> responseEntity =ValidateUtil.validateErrors(errors) ;
	       if(responseEntity != null) return responseEntity;
	       
	       
	       return null;
	    	   
	 }
	    	

}
