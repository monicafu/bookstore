package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.domain.User;
import com.bookstore.domain.UserBilling;
import com.bookstore.domain.UserPayment;
import com.bookstore.domain.security.UserRole;
import com.bookstore.repository.RoleRepository;
import com.bookstore.repository.UserBillingRepository;
import com.bookstore.repository.UserPaymentRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final static Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private UserBillingRepository userBillingRepository;
	
	@Autowired
	private UserPaymentRepository userPaymentRepository;
	
	@Override
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		
		User localUser = userRepository.findByUsername( user.getUsername() );
		if(localUser!=null){
			LOG.info(" User with user name {} has been used. Nothing will be done", user.getUsername());
		}else{
			if( userRoles!=null ){
				for(UserRole userRole: userRoles){
					roleRepository.save( userRole.getRole() );
				}
			}
			
			user.getUserRoles().addAll(userRoles);
			user.setUserPaymentList(new ArrayList<UserPayment>());
			
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}
	
	@Override
	public User save(User user)  {
		return userRepository.save(user);
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user) {
		save(user);
		userBillingRepository.save(userBilling);
		userPaymentRepository.save(userPayment);
	}
	
	@Override
	public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user) {
		userPayment.setUser(user);
		userPayment.setUserBilling(userBilling);
		userPayment.setDefaultPayment(true);
		userBilling.setUserPayment(userPayment);
		user.getUserPaymentList().add(userPayment);
		save(user);
	}
	
	@Override
	public void setUserDefaultPayment(Long userPaymentId, User user) {
		List<UserPayment> userPaymentList = (List<UserPayment>) userPaymentRepository.findAll();
		
		for (UserPayment userPayment : userPaymentList) {
			if(userPayment.getId() == userPaymentId) {
				userPayment.setDefaultPayment(true);
				userPaymentRepository.save(userPayment);
			} else {
				userPayment.setDefaultPayment(false);
				userPaymentRepository.save(userPayment);
			}
		}
	}
}
