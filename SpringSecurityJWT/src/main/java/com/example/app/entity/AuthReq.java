package com.example.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuthReq {
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public AuthReq(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public AuthReq() {
		
	}
	

}
