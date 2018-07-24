package com.school.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.school.service.dao.model.UserCreditionals;



public interface UserCreditionalsRepository extends JpaRepository<UserCreditionals, Long>{
	
	UserCreditionals findById(long id);

	UserCreditionals findByName(String name);
	
	UserCreditionals findByEmail(String email);

	UserCreditionals findByToken(String token);

}
