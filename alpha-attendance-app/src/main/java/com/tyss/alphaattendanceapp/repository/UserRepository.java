package com.tyss.alphaattendanceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.alphaattendanceapp.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByPhone(long phone);
	User findByEmail(String email);
	
}
