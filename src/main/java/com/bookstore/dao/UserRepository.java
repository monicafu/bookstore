package com.bookstore.dao;

import org.springframework.stereotype.Repository;

import com.bookstore.domain.security.User;

@Repository
public class UserRepository {
	
	public User findByUsername( String userName){
		return new User();
	}
}
