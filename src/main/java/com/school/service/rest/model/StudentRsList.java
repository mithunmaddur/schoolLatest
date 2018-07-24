package com.school.service.rest.model;

import java.util.List;

import com.school.service.dao.model.Student;



public class StudentRsList {
	
	private List<Student> students;
	
	private String studentsCount;
	
	private LoginResponse profile;
	

	public LoginResponse getProfile() {
		return profile;
	}

	public void setProfile(LoginResponse profile) {
		this.profile = profile;
	}

	public List<Student> getStudentRsList() {
		return students;
	}

	public void setStudentRsList(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getStudentsCount() {
		return studentsCount;
	}

	public void setStudentsCount(String studentsCount) {
		this.studentsCount = studentsCount;
	}

	
	
	
}
