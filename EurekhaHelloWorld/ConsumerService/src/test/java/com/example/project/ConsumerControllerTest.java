package com.example.project;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.awt.PageAttributes.MediaType;

import org.apache.http.entity.ContentType;
import org.aspectj.lang.annotation.Before;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestGatewaySupport;
import org.springframework.web.context.WebApplicationContext;

import net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record.ForDefinedMethod.WithBody;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerControllerTest {

	@Autowired
	RestTemplate restTemplate;
	
	 
	@Test
	public void testGetMessage() {
	        String message = restTemplate.getForObject("http://ApplicationService/hello" , String.class);

	        Assert.assertEquals("hello world", message);
	    }
	
	
	
	
	    
	
	    
	
}
