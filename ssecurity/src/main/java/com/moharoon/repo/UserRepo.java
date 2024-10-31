package com.moharoon.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moharoon.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	
	User findUserByUsername(String username);
}
