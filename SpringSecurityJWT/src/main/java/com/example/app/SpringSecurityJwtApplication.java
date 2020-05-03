package com.example.app;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.entity.User;
import com.example.app.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@PostConstruct
	public void init() {
		userRepository.saveAll(Stream
				.of(
						new User(1, "Rohith", "yummy", "1@g.com"),
						new User(2, "Rohith2", "yummy", "2@g.com"),
						new User(3, "Rohith3", "yummy", "3@g.com"), 
						new User(4, "Rohith4", "yummy", "4@g.com"))
				.collect(Collectors.toList()));
	}

}
