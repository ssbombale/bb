package com.admin.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entity.AdminDetail;

public interface UserRepository extends JpaRepository <AdminDetail, Integer>{
	AdminDetail findByUserName(String username);

	AdminDetail findByemail(String username);

}
