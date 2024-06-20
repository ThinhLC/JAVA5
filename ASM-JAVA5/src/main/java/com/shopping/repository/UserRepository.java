package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
	
	  UserDtls findByEmail(String email);
}
