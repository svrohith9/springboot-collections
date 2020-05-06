package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MainClass {
	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(101, "A", "1", Gender.MALE));
		emp.add(new Employee(102, "B", "12", Gender.FEMALE));
		emp.add(new Employee(103, "C", "123", Gender.FEMALE));

		// stream filter collect

		System.out.println(emp.stream()
				.filter(Employee -> Gender.FEMALE.equals(Employee.getGender()))
				.collect(Collectors.toList())
				.toString());
		
		// functions
		
		System.out.println(numberByTwo.apply("10"));

		System.out.println(numberByTwo.andThen(evenOrOdd).apply("12"));
		
		System.out.println(lengthOfString.apply("hello", 2));
		
		System.out.println(getURL.get());

	}
	
	
	static Function<String, Integer> numberByTwo = number -> Integer.parseInt(number) / 2;

	static Function<Integer, Boolean> evenOrOdd = number -> (number % 2 == 0) ? true : false;

	static BiFunction<String, Integer, Boolean> lengthOfString = (str, num) -> (str.length() == num) ? true : false;

	static Supplier<String> getURL = () -> "locolhost:8080";

}
