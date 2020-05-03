package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.AuthReq;
import com.example.app.utils.JwtUtil;

@RestController
@RequestMapping("/api/v1/awt")
public class HomeController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping
	public String hello() {
		return "Hey hello";
	}
	
	@PostMapping("/auth")
	public String generateToken(@RequestBody AuthReq request) {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
				);
		
		return jwtUtil.generateToken(request.getUsername());
		
	}

}
