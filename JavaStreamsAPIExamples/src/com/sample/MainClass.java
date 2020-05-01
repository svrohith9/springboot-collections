package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainClass {
	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(101, "A", "1", Gender.MALE));
		emp.add(new Employee(102, "B", "12", Gender.FEMALE));
		emp.add(new Employee(103, "C", "123", Gender.FEMALE));
		
	}

}
