package com.user.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.CustomeLoanApply;
import com.user.entity.User;

public interface UserRepository extends JpaRepository <User, Integer>{
	User findByUserName(String username);

	User findByemail(String username);

//	Integer updateCustomer(User user, Integer id);

}
