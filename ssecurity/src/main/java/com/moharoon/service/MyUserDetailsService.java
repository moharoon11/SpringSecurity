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
        User user = userRepo.findUserByUsername(username);
        
        
        if(user == null) {
        	throw new UsernameNotFoundException("User not found!");
        }
        
        
		return new UserPrinciple(user);
	}

}
