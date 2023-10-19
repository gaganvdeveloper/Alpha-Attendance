package com.tyss.alphaattendanceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.alphaattendanceapp.dto.User;
import com.tyss.alphaattendanceapp.responsestructure.ResponseStructure;
import com.tyss.alphaattendanceapp.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id) {
		return userService.findUserById(id);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable int id) {
		return userService.deleteUserById(id);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers() {
		return userService.findAllUsers();
	}

}
