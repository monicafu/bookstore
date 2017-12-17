package com.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domain.User;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.UserService;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	//spring security and database access

	@Override
	public void run(String... arg0) throws Exception {
		User user1 = new User();
		user1.setFirstName("Jing");
		user1.setLastName("Fu");
		user1.setEmail("fujing0815@gmailc.com");
		user1.setUsername("fujing");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("123"));
		
		Role role1 = new Role();
		role1.setName("user");
		role1.setRoleId(1);
		
		Set<UserRole> userRoles = new HashSet<UserRole>();
		userRoles.add( new UserRole(user1, role1) );
		
		userService.createUser(user1,userRoles);
		userRoles.clear();
		
		//create user
		User user2 = new User();
		user2.setFirstName("Yuhao");
		user2.setLastName("Yang");
		user2.setUsername("yyh");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("123"));
		user2.setEmail("yangyuhao830@yahoo.com");
		
		Role role2 = new Role();
		role2.setRoleId(2);
		role2.setName("admin");
		userRoles.add(new UserRole(user2,role2));
		
		userService.createUser(user2, userRoles);
		
	}
	
}
