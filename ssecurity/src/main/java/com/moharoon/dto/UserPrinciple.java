package com.moharoon.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.moharoon.model.User;

public class UserPrinciple implements UserDetails {
	
	
	private User user;
	
	
	public UserPrinciple(User user) {
		System.out.println("Injecting the user with the details provided by user...............");
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("setting user authoriteies.............");
	    return new ArrayList<>(List.of(new SimpleGrantedAuthority("USER")));
	}

	@Override
	public String getPassword() {
		System.out.println("giving the passwrod from user priciple...............");
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("giving the username from user principle...................");
		return user.getUsername();
	}

}
