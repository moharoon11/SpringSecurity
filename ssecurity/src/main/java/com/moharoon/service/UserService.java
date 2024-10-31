package com.moharoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.moharoon.model.User;
import com.moharoon.repo.UserRepo;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepo userRepo;
	
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	
	public User registerUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

}
