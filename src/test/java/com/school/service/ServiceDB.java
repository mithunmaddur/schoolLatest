package com.school.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.school.service.dao.model.Student;
import com.school.service.repository.StudentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceDB {
	
	@Autowired
	private StudentRepository studentRepository;
	

	
	 @Before
	  public void setUp() {
		 
	 }


	 
	 @Test
	  public void testStudentsList() {
		List<Student> students = studentRepository.findAll();
		
		 Assert.notNull(students, "students list are not null");
	 }
}
