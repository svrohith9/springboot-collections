package com.example.app.student;

public enum UserPermission {
	
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");
	
	private final String permission;
	
	UserPermission(String pString) {
		this.permission=pString;
	}
	
	public String getPermission() {
		return permission;
	}
		
}
