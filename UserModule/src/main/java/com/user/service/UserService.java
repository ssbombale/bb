package com.user.service;

import org.springframework.stereotype.Service;

import com.user.entity.CustomeLoanApply;
import com.user.entity.User;

@Service
public interface UserService {
	
	
	
	Integer saveUser (User user);

	User loadUserByUsername(String userName);

	Integer saveLoanApply(CustomeLoanApply user);
	
	Integer updateCustomer (User user, Integer id);
	
	
}
