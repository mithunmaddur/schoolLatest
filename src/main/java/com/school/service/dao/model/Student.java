package com.school.service.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Student {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long studentId;
	  
	  private String firstName;
	  private String lastName;
	  private String fatherName;
	  private String phoneNum;
	  private String address;
	  
	  private String sex;
	 
      private Date dateOfBirth;
      
	  private Date dateOfAdmission;
	  
	  private String email;
	  
	  private String imageURL;
	  
	  private String registerNumber;
		
		public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

		public String getEmail() {
		return email;
	}

	public String getImageURL() {
			return imageURL;
		}

		public void setImageURL(String imageURL) {
			this.imageURL = imageURL;
		}

	public void setEmail(String email) {
		this.email = email;
	}

		@ManyToOne
	    @JoinColumn(name = "user_Id")
		private UserCreditionals userinfo;
		
		
		 @Column(nullable = false, updatable = false)
		 @Temporal(TemporalType.TIMESTAMP)
		 @CreatedDate
		 private Date createdAt  = new Date(); ;

	     @Column(nullable = false)
	     @Temporal(TemporalType.TIMESTAMP)
	     @LastModifiedDate
	     private Date updatedAt = new Date(); ;

		public Long getStudentId() {
			return studentId;
		}

		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPhoneNum() {
			return phoneNum;
		}

		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
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

		public Date getDateOfAdmission() {
			return dateOfAdmission;
		}

		public void setDateOfAdmission(Date dateOfAdmission) {
			this.dateOfAdmission = dateOfAdmission;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = new Date(); ;
		}

		public String getFatherName() {
			return fatherName;
		}

		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public UserCreditionals getUserinfo() {
			return userinfo;
		}

		public void setUserinfo(UserCreditionals userinfo) {
			this.userinfo = userinfo;
		}	  

		
		
}
