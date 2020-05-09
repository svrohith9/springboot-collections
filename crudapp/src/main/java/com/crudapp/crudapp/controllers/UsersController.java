package com.crudapp.crudapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.crudapp.beans.Users;
import com.crudapp.crudapp.repository.UsersRepository;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@GetMapping("/users/{name}")
	public Users getUser(@PathVariable final String name) {
		return usersRepository.findByName(name);
	}

	@PostMapping("/load")
	public Users AddorUpdateUser(@RequestBody final Users user) {
		usersRepository.save(user);
		return user;
	}

	@GetMapping("/delete/{name}")
	public void DeleteUser(@PathVariable final String name) {
		 usersRepository.deleteById(getUser(name).getId());
	}

}
