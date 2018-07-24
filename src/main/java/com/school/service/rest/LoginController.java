package com.school.service.rest;

import javax.validation.Valid;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.service.rest.model.FinalLoginUserRs;
import com.school.service.rest.model.LoginRequest;
import com.school.service.rest.model.LoginResponse;
import com.school.service.rest.model.StudentRsList;
import com.school.service.rest.model.UserRequest;
import com.school.service.service.StudentService;
import com.school.service.service.UserLoginService;
import com.school.service.util.ValidateUtil;




@CrossOrigin(origins = "http://localhost:4100/*", maxAge = 3600)
@RestController
public class LoginController {
	
	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(path = "/v1/user", method = RequestMethod.PUT)
    public ResponseEntity<?> logintest(@Valid @RequestBody UserRequest userRequest, Errors errors
    		, @RequestHeader("Accept-Encoding") String encoding, @RequestHeader("token") String token) throws ApplicationException {
		
		ResponseEntity<?>  responseEntity =  userLoginService.validateTokenUser(token);
		 if(responseEntity != null) return responseEntity;
	   //If error, just return a 400 bad request, along with the error message 
              responseEntity =ValidateUtil.validateErrors(errors) ;
      if(responseEntity != null) return responseEntity;
      
      LoginResponse loginResponse = userLoginService.updateUser(userRequest);
    
   	   FinalLoginUserRs finalLoginUserRs =new FinalLoginUserRs();
   	   finalLoginUserRs.setUser(loginResponse);
   	   return ResponseEntity.ok(finalLoginUserRs);
   	   
    
}
	
	@RequestMapping(path = "/v1/usertest", method = RequestMethod.GET)
    public ResponseEntity<?> getUsertest(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader("token") String token) throws ApplicationException {
		
		ResponseEntity<?>  responseEntity =  userLoginService.validateToken(token);
		 if(responseEntity != null) return responseEntity;

		 LoginResponse loginResponse = userLoginService.getUser(token);
		    
	   	   FinalLoginUserRs finalLoginUserRs =new FinalLoginUserRs();
	   	   finalLoginUserRs.setUser(loginResponse);
		return ResponseEntity.ok(finalLoginUserRs);
}
	
	 @RequestMapping(path = "/v1/getalltest", method = RequestMethod.GET)
	    public ResponseEntity<?> getAlltest( @RequestHeader("token") String token) throws ApplicationException {
		ResponseEntity<?>  responseEntity =  userLoginService.validateToken(token);
		if(responseEntity != null) return responseEntity; 
		 
		 
		 StudentRsList studentRsList = new StudentRsList();
		 studentRsList.setStudentRsList(studentService.getAllStudents());
		 studentRsList.setStudentsCount("34");
		 return ResponseEntity.ok(studentRsList);

	    	   
	 }
	
	 @RequestMapping(path = "/v1/getallstudent", method = RequestMethod.GET)
	    public ResponseEntity<?> getallstudent( @RequestHeader("token") String token) throws ApplicationException {
		ResponseEntity<?>  responseEntity =  userLoginService.validateToken(token);
		 if(responseEntity != null) return responseEntity; 
		 
		 
		 StudentRsList studentRsList = new StudentRsList();
		 studentRsList.setStudentRsList(studentService.getAllStudents());
		 studentRsList.setStudentsCount("34");
		 studentRsList.setProfile(userLoginService.getUser(token));
		 return ResponseEntity.ok(studentRsList);

	    	   
	 }
	
	@RequestMapping(path = "/v1/user", method = RequestMethod.GET)
    public ResponseEntity<?> getUser( @RequestHeader("token") String token) throws ApplicationException {
		
		ResponseEntity<?>  responseEntity =  userLoginService.validateTokenUser(token);
		 if(responseEntity != null) return responseEntity;

		 LoginResponse loginResponse = userLoginService.getUser(token);
		    
	   	   FinalLoginUserRs finalLoginUserRs =new FinalLoginUserRs();
	   	   finalLoginUserRs.setUser(loginResponse);
		return ResponseEntity.ok(finalLoginUserRs);
}
	
	 @RequestMapping(path = "/v1/users/login", method = RequestMethod.POST)
	    public ResponseEntity<?> login(
			@Valid @RequestBody LoginRequest loginRequest, Errors errors) throws ApplicationException {
		 
		   //If error, just return a 400 bad request, along with the error message 
	        ResponseEntity<?> responseEntity =ValidateUtil.validateErrors(errors) ;
	       if(responseEntity != null) return responseEntity;
	       LoginResponse loginResponse = userLoginService.login(loginRequest.getEmail(), loginRequest.getPassword());
	       if( loginResponse != null){
	    	   FinalLoginUserRs finalLoginUserRs =new FinalLoginUserRs();
	    	   finalLoginUserRs.setUser(loginResponse);
	    	   return ResponseEntity.ok(finalLoginUserRs);
	    	   
	       }
	      
	      return ValidateUtil.generateErrorRespose("Email or Password", " combination is wrong");
	    	  
	 }
	

}
