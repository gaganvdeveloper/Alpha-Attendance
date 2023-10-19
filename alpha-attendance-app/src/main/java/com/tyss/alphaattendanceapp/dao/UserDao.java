package com.tyss.alphaattendanceapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.alphaattendanceapp.dto.User;
import com.tyss.alphaattendanceapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public Optional<User> findUserById(int id) {
		return repository.findById(id);
	}

	public void deleteUserById(int id) {
		repository.deleteById(id);
	}

	public List<User> findAllUsers() {
		return repository.findAll();
	}
	
	public User findUserByPhoneNumber(long phone) {
		return repository.findByPhone(phone);
	}
	
	public User findUserByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	
	

}
