package com.user.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.entity.CustomeLoanApply;
import com.user.entity.User;

public interface CustLoanRepository extends JpaRepository <CustomeLoanApply, Integer>{

	CustomeLoanApply save(CustomeLoanApply user);
	

}
