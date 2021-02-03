package com.crudapp.crudapp;

import org.mapstruct.BeforeMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crudapp.crudapp.repository.UsersRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CrudappApplication {

	@Autowired
	UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}

	@BeforeMapping
	private static void loadData() {

	}
}
