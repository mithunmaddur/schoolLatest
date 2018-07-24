package com.school.service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.school.service.dao.model.Student;
import com.school.service.rest.model.StudentRequest;




public interface StudentService {
	
	 List<Student> getAllStudents();
	 
	 void updateStudent(Student student);
	 
	 ResponseEntity<?> addStudent(StudentRequest student);
	 
	 void deleteStudent(long id);
	 
	 Student getStudentById(long id);
	
}
