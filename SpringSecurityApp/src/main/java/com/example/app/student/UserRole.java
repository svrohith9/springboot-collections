package com.example.app.student;

import java.util.Set;

import com.google.common.collect.Sets;

public enum UserRole {

	ADMIN(Sets.newHashSet(UserPermission.COURSE_READ, UserPermission.COURSE_WRITE, UserPermission.STUDENT_READ,
			UserPermission.STUDENT_WRITE)),
	STUDENT(Sets.newHashSet());

	private final Set<UserPermission> permissions;

	private UserRole(Set<UserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<UserPermission> getPermissions() {
		return permissions;
	}
	
}
