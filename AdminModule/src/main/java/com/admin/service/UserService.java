package com.admin.service;

import org.springframework.stereotype.Service;

import com.admin.entity.AdminDetail;

@Service
public interface UserService {
	
	
	
	Integer saveUser (AdminDetail user);

	AdminDetail loadUserByUsername(String userName);
}
