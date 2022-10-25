package com.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.AuthResponse;
import com.user.entity.CustomeLoanApply;
import com.user.entity.Login;
import com.user.entity.OutputModel;
import com.user.entity.User;
import com.user.security.jwt.JwtUtils;
import com.user.service.UserImplementation;
import com.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService customerService;
	
	@GetMapping(value = "/welcome")
	public String test() {
		return "Hello !!!!";
	} 
	
	@PostMapping("User/registration")
	Integer createUser(@Valid @RequestBody User user) {
		Integer id = customerService.saveUser(user);
		return id;
	}
	
	@PostMapping("User/applyLoan")
	public Integer applyloan( @RequestBody CustomeLoanApply user) {
		Integer id = customerService.saveLoanApply(user);
		return id;
	}
	
	@PutMapping("User/{id}")
	public ResponseEntity<User> updateCustomer(@PathVariable Integer id, @RequestBody User user){
		System.out.println(id);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			
			customerService.updateCustomer(user, id);
		}
		catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			
		}
		return responseEntity;
	}
	
	
	
	@Autowired
	private JwtUtils jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserImplementation useraccountServiceImpl;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody Login login) throws Exception {

		try { 

			User useraccount = useraccountServiceImpl.getUseraccountByUsername(login.getUsername());
			if (useraccount != null) {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

				String jwt = jwtUtil.generateToken(login.getUsername());
				AuthResponse auth = new AuthResponse(jwt, useraccount.getId(), useraccount.getUserName(), "",
						useraccount.getName(), useraccount.getEmail(),true,"Login Successfully");
				return ResponseEntity.ok(auth);

			} else {
				OutputModel outputModel = new OutputModel(false, "username or password invalid");
				return ResponseEntity.ok(outputModel);
			}

		} catch (Exception e) {
			System.err.println(e);
			OutputModel outputModel = new OutputModel(false, "username or password invalid");
			return ResponseEntity.ok(outputModel);
			
		}
	}
	
	
	
}
