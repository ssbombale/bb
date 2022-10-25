package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.AdminDetail;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository customerRepo;
	@Override
	public Integer saveUser(AdminDetail user) {
		AdminDetail savedUser = customerRepo.save(user);
		return  savedUser.getUserId();
	}
	
//	@Override
//	public Integer saveUser(User user) {
//		User savedUser = customerRepo.save(user);
//		return  savedUser.getId();
//	}
//	

	@Override
	public AdminDetail loadUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
