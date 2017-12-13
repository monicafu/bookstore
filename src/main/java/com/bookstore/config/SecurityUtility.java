package com.bookstore.config;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
	
	private static final String SALT="awjiosdfklsdjfdklsgjdfl";
	
	public static BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(12, new SecureRandom( SALT.getBytes()));
	}
	
	public static String randomPassword(){
		String SALTCHAR="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		
		while(salt.length()<18){
			int index = (int)(rnd.nextFloat()*SALTCHAR.length());
			salt.append(SALTCHAR.indexOf(index));
		}
		
		return salt.toString();
	}
}
