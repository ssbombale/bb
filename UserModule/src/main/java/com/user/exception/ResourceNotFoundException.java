package com.user.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID =1L;
	private String resourseName;
	private String fieldName;
	private Object fieldValue;
	
	
	public ResourceNotFoundException(String resourseName, String fieldName, Object fieldValue) {
		super( String.format("%S not found with: %S",resourseName,fieldName,  fieldValue ));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourseName() {
		return resourseName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	
}
