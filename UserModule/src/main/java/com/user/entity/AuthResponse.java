package com.user.entity;

public class AuthResponse {

		private String token;
		private String type = "Bearer";
		private Integer id;
		private String username;
		private String firstName;
		private String lastName;
		private String message;
		private boolean status;
		
		
		public AuthResponse(String accessToken, Integer id, String username, String email, String firstName, String lastName,boolean status,String message) {
			this.token = accessToken;
			this.id = id;
			this.username = username;
			this.firstName = firstName;
			this.lastName = lastName;
			this.message = message;
			this.status = status;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

}
