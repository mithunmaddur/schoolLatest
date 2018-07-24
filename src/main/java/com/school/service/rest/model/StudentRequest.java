package com.school.service.rest.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;


public class StudentRequest {
	
	
	@NotBlank(message = " can't empty!")
	private String firstName;
	
	@NotBlank(message = " can't empty!")
	private String lastName;

	@NotBlank(message = " can't empty!")
	private String address;
	
	@NotBlank(message = " can't empty!")
	private String sex;
	
	@NotBlank(message = " can't empty!")
	private String email;
	
	@NotBlank(message = " can't empty!")
	private String phoneNum;
	
	
	private Date dateOfBirth;
	
	@NotBlank(message = " can't empty!")
	private String fatherName;
	    

    private Date dateOfAdmission;
	
	@NotBlank(message = " can't empty!")
    private String registerNumber;
	
	@NotBlank(message = " can't empty!")
    private String userName;
	
	@NotBlank(message = " can't empty!")
    private String userEmail;
    
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserImageURL() {
		return userImageURL;
	}

	public void setUserImageURL(String userImageURL) {
		this.userImageURL = userImageURL;
	}

	private String userSex;
	
	private String userImageURL;
	
	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}
