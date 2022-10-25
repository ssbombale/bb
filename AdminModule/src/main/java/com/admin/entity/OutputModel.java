package com.admin.entity;

public class OutputModel {

		private boolean status;
		private String message;
		
		public OutputModel(boolean status, String message) {
			super();
			this.status = status;
			this.message = message;
		}
		public OutputModel() {
			super();
		}
		
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "OutputModel [status=" + status + ", message=" + message + "]";
		}
		
		
}
