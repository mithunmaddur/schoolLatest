package com.school.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.school.service.dao.model.UserCreditionals;
import com.school.service.repository.UserCreditionalsRepository;
import com.school.service.rest.model.LoginResponse;
import com.school.service.rest.model.UserRequest;
import com.school.service.service.UserLoginService;
import com.school.service.util.SecureTokenGenerator;
import com.school.service.util.ValidateUtil;




@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	private UserCreditionalsRepository userCreditioinalSRepository;
	
	@Override
	public  ResponseEntity<?> validateToken(String token){
		
		
		if(token == null ){
			return ValidateUtil.generateErrorRespose("Token ", " is empty");
			
		}
		UserCreditionals userInfo = userCreditioinalSRepository.findByToken(token);
		
		if(((userInfo != null) && !userInfo.getUserType().equals("Admin")) || userInfo == null){
			
			return ValidateUtil.generateErrorRespose("Token ", " is not a valid");
		}
		
		return null;
	}
	
	@Override
	public  ResponseEntity<?> validateTokenUser(String token){
		
		
		if(token == null ){
			return ValidateUtil.generateErrorRespose("Token ", " is empty");
			
		}
		UserCreditionals userInfo = userCreditioinalSRepository.findByToken(token);
		
		if(userInfo == null){
			
			return ValidateUtil.generateErrorRespose("Token ", " is not a valid");
		}
		
		return null;
	}

	@Override
	public LoginResponse login(String email, String password) {
		UserCreditionals userCreditionals=userCreditioinalSRepository.findByEmail(email);
		
		
		if(userCreditionals!= null && userCreditionals.getPassword().equals(password)){
			userCreditionals.setToken(SecureTokenGenerator.nextToken());
			userCreditioinalSRepository.save(userCreditionals);
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setCreatedAt(userCreditionals.getCreatedAt().toGMTString());
			loginResponse.setEmail(userCreditionals.getEmail());
			loginResponse.setId(userCreditionals.getUserId());
			loginResponse.setToken(userCreditionals.getToken());
			loginResponse.setUsername(userCreditionals.getName());
			loginResponse.setUserType(userCreditionals.getUserType());
			return loginResponse;
			
		}
		return null;
	}

	@Override
	public LoginResponse updateUser(UserRequest userRequest) {
		UserCreditionals userCreditionals = userCreditioinalSRepository.findByEmail(userRequest.getEmail());
		
		userCreditionals.setBio(userRequest.getBio());
		
		if(userRequest.getPassword() != null){
			userCreditionals.setPassword(userRequest.getPassword());
			
		}
		 userCreditioinalSRepository.save(userCreditionals);
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setCreatedAt(userCreditionals.getCreatedAt().toGMTString());
		loginResponse.setEmail(userCreditionals.getEmail());
		loginResponse.setId(userCreditionals.getUserId());
		loginResponse.setToken(userCreditionals.getToken());
		loginResponse.setUsername(userCreditionals.getName());
		loginResponse.setUserType(userCreditionals.getUserType());
		return loginResponse;

		
	}

	@Override
	public LoginResponse getUser(String token) {
    UserCreditionals userCreditionals = userCreditioinalSRepository.findByToken(token);
		
	LoginResponse loginResponse = new LoginResponse();
	loginResponse.setCreatedAt(userCreditionals.getCreatedAt().toGMTString());
	loginResponse.setEmail(userCreditionals.getEmail());
	loginResponse.setId(userCreditionals.getUserId());
	loginResponse.setToken(userCreditionals.getToken());
	loginResponse.setUsername(userCreditionals.getName());
	loginResponse.setUserType(userCreditionals.getUserType());
	return loginResponse;
	}

	

}
