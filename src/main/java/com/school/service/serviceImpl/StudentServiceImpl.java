package com.school.service.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.service.dao.model.Student;
import com.school.service.dao.model.UserCreditionals;
import com.school.service.repository.StudentRepository;
import com.school.service.repository.UserCreditionalsRepository;
import com.school.service.rest.model.StudentRequest;
import com.school.service.service.StudentService;
import com.school.service.util.ValidateUtil;


@Service("studentService")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private UserCreditionalsRepository userCreditioinalSRepository;

	@Override
	public List<Student> getAllStudents() {
	
		return studentRepository.findAll();
	}


	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
		
	}
	
	private String generateUUID(){
		
		return UUID.randomUUID().toString();
	}

	@Override
	public ResponseEntity<?>  addStudent(StudentRequest studentRequest) {
		
		UserCreditionals userCreditionals= userCreditioinalSRepository.findByEmail(studentRequest.getUserEmail());
		
		if(userCreditionals != null ){
			return ValidateUtil.generateErrorRespose("User Email", " is already exist");
		}
		
		UserCreditionals creditionals = new UserCreditionals();
		creditionals.setName(studentRequest.getUserName());
		creditionals.setPassword("123456@999");
		creditionals.setEmail(studentRequest.getUserEmail());
		creditionals.setDateOfBirth(new Date());
		creditionals.setUserType("Parent");
		creditionals.setPhoneNum(studentRequest.getPhoneNum());
		creditionals.setSex(studentRequest.getUserSex());
		creditionals.setUUID(generateUUID());
		creditionals =	userCreditioinalSRepository.save(creditionals);
		
		Student student = new Student();
		student.setAddress(studentRequest.getAddress());
		student.setFirstName(studentRequest.getFirstName());
		student.setLastName(studentRequest.getLastName());
        student.setDateOfAdmission(studentRequest.getDateOfAdmission());
        student.setDateOfBirth(studentRequest.getDateOfBirth());
        student.setFatherName(studentRequest.getFatherName());
        student.setSex(studentRequest.getSex());
        student.setPhoneNum(studentRequest.getPhoneNum());
        student.setEmail(studentRequest.getEmail());
        student.setUserinfo(creditionals);
        student.setRegisterNumber(studentRequest.getRegisterNumber());
        
		studentRepository.save(student);
		return ResponseEntity.ok(studentService.getAllStudents());
	
	}

	@Override
	public Student getStudentById(long id) {
		
		return studentRepository.findById(id);
	}


	@Override
	public void deleteStudent(long id) {
		 studentRepository.deleteById(id);;
		
	}

}
