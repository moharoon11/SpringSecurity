package com.moharoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.moharoon.model.User;
import com.moharoon.repo.UserRepo;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtService jwtService;
	
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	
	public User registerUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}


	public String verify(User user) {
		
		
		
		
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
		
		
		if(authentication.isAuthenticated()) {
			
			return jwtService.generateToken(user.getUsername());
		}
			
		
		
		
		return "Fails";
	}

}
