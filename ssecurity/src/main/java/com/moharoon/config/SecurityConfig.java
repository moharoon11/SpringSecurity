package com.moharoon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	
	
	@Autowired
	private UserDetailsService userDetailsService;

	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("Configuring Security Filter Chain.....................");
		return http.csrf(customizer -> customizer.disable())
		    .authorizeHttpRequests(request -> request
		    		                                 .requestMatchers("register", "login")
		    		                                 .permitAll()
		    		                                 .anyRequest()
		    		                                 .authenticated())
		    .httpBasic(Customizer.withDefaults())
		    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		    .build();    
	}
	
	

//	@Bean 
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails user1 = User
//				            .withDefaultPasswordEncoder()
//				            .username("haroon")
//				            .password("haroon11")
//				            .roles("USER")
//				            .build();
//		
//		
//		return new InMemoryUserDetailsManager(user1);
//	}
	
	
	

	
	@Bean
	public AuthenticationProvider authProvider() {
		
		System.out.println("COming into authenticatoin provider.....................");
		DaoAuthenticationProvider daoAuthProvider  = new DaoAuthenticationProvider();
		daoAuthProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		daoAuthProvider.setUserDetailsService(userDetailsService);
		System.out.println("returning the athenticatoin provider dao auth provider.........................");
		return daoAuthProvider;
	}
	
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
		System.out.println("Creting authentication manager object.....................");
		return config.getAuthenticationManager();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
