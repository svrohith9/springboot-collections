package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/hello")
public class ConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public String helloWorld() {
		String url="http://ApplicationService/hello";
		return restTemplate.getForObject(url, String.class);
	}

}
