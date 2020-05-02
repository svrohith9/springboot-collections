package com.example.app.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
	private static final List<Student> STUDENTS=Arrays.asList(
			new Student(1, "ROHITH", Gender.MALE),
			new Student(2, "ABC", Gender.MALE),
			new Student(3, "XYZ", Gender.FEMALE),
			new Student(4, "ABCDXYZ", Gender.FEMALE),
			new Student(5, "cole", Gender.MALE)
			);
	
	@GetMapping
	public List<Student> getAllStudents(){
		return STUDENTS;
	}
	@PostMapping
	public void registerStudent(@RequestBody Student s) {
		System.out.println(s);
	}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		System.out.println(id );
	}
	@PutMapping
	public void updateStudent(@RequestBody Student s) {
		System.out.println(s);
	}

}
