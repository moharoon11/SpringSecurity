package com.moharoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.moharoon.dto.UserPrinciple;
import com.moharoon.model.User;
import com.moharoon.repo.UserRepo;


@Component
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Loading the user by username..................");
        User user = userRepo.findUserByUsername(username);
        
        
        if(user == null) {
        	System.out.println("user is not found user is nullllllllll.....................");
        	throw new UsernameNotFoundException("User not found!");
        }
        
        
        
        System.out.println("User is found............so returning the user principle.................");
		return new UserPrinciple(user);
	}

}
