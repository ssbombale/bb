package com.user.entity;
import java.sql.Date;

import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "CustomerReg")
public class User {
	@Id
		private Integer id;
	
	@NotEmpty
	@Size(max=50)
		private String name;
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{8,20}$",
    message = "username must be of 8 to 20 length with no special characters")

		private String userName;
	
	@Size(max=20, min=8)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
    message = "password minimum length 8 chars , atleast  have one capital letter , one small letter, one special char,one number")

		private String password;
	
		@Size(max=200)
		private String address;
		@Size(max=50)
		private String state;
		@Size(max=100)
		private String country;
		
	
	@Email
		private String email;
	
	@Size(max=10,min=5, message="less than size")
		private String pan;
	
	@Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10) 	
		private String contactNumber;
	
	@DateTimeFormat
		private Date date;
	
		@Size(max=50)
		private String accountType;
		

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "ID")
		
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPan() {
			return pan;
		}
		public void setPan(String pan) {
			this.pan = pan;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		
		
		
		
		
		
		

	

}
