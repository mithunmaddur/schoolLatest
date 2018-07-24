package com.school.service.service;





import org.springframework.http.ResponseEntity;

import com.school.service.rest.model.LoginResponse;
import com.school.service.rest.model.UserRequest;



public interface UserLoginService {
	
	LoginResponse login(String name, String password);


	ResponseEntity<?> validateToken(String token);
	
	ResponseEntity<?> validateTokenUser(String token);


	LoginResponse updateUser(UserRequest userRequest);


	LoginResponse getUser(String token);
	
	

}
