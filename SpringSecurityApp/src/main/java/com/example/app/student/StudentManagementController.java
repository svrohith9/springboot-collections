package com.example.app.student;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
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

	private static Logger LOGGER = LoggerFactory.getLogger(StudentManagementController.class);

	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1, "ROHITH", Gender.MALE),
			new Student(2, "ABC", Gender.MALE),
			new Student(3, "XYZ", Gender.FEMALE),
			new Student(4, "ABCDXYZ", Gender.FEMALE),
			new Student(5, "cole", Gender.MALE));

	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public List<Student> getAllStudents() {
		LOGGER.info("getStudents");
		return STUDENTS;
	}

	@PostMapping
	@PreAuthorize("hasAuthority('student:write')")
	public void registerStudent(@RequestBody Student s) {
		LOGGER.info("registerStudent");
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('student:write')")
	public void deleteStudent(@PathVariable Integer id) {
		LOGGER.info("deleteStudent");
	}

	@PutMapping
	@PreAuthorize("hasAuthority('student:write')")
	public void updateStudent(@RequestBody Student s) {
		LOGGER.info("updateStudent");
	}

}
