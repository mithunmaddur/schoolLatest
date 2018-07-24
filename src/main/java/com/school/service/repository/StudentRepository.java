package com.school.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.service.dao.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findById(long id);



}
