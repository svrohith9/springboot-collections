package com.svrohith9.springbootmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.svrohith9.springbootmongodb.models.Users;
import com.svrohith9.springbootmongodb.repository.UserRepository;

@RestController
public class BaseController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/all-data")
	public List<Users> getAllData() {
		return userRepository.findAll();
	}

	@RequestMapping("/data-by-state/{state}")
	public List<Users> getAllDataByState(@PathVariable final String state) {
		return userRepository.findByState(state);
	}

}
