package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.CustomeLoanApply;
import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository customerRepo;
	
	@Autowired
	CustLoanRepository custLoanRepository;
	
	@Override
	public Integer saveUser(User user) {
		User savedUser = customerRepo.save(user);
		return  savedUser.getId();
	}
	
	public Integer updateCustomer(User user, Integer id) {
		User existing = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer","id",id));
		existing.setCountry(user.getCountry());
		existing.setPassword(user.getPassword());
		existing.setAddress(user.getAddress());
		existing.setAccountType(user.getAccountType());
		existing.setContactNumber(user.getContactNumber());
		existing.setEmail(user.getEmail());
		existing.setPan(user.getPan());
		existing.setState(user.getState());
		existing.setUserName(user.getUserName());

		customerRepo.save(existing);
		return existing.getId();
	}


	@Override
	public User loadUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveLoanApply(CustomeLoanApply user) {
		CustomeLoanApply savedUser = custLoanRepository.save(user);
		return  savedUser.getLoanId();
	}
	
	

	 
	

}
