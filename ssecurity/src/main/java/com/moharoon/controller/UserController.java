package com.moharoon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moharoon.model.User;
import com.moharoon.service.UserService;

@RestController
public class UserController {
	
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.registerUser(user));
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user) {
		System.out.println("coming to login controller....................");
		return ResponseEntity.ok(userService.verify(user));
	}

}
