package com.moharoon.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	
	
	@GetMapping("/")
	public String greet(HttpServletRequest request) {
		return "Welcome to spring security" + request.getSession().getId();
	}
	
	
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return  (CsrfToken) request.getAttribute("_csrf");
	}
	

}
