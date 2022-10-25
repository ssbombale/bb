package com.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.user.exception.ResourceNotFoundException;
import com.user.entity.User;
@Service
public class UserImplementation implements UserDetailsService {
	
	@Autowired
	UserRepository customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = customerRepo.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());
	}
	
	public User getUseraccountByUsername(String username) {
		return customerRepo.findByUserName(username);
		
	}
	
	
	public Integer updateCustomer(User user, Integer id) {
		
		return null;
	}
	
//	@Override
//	public Integer saveUser(User user) {
//		User savedUser = customerRepo.save(user);
//		return  savedUser.getId();
//	}
//	

}
