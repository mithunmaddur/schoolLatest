package com.school.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.util.Assert;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolServiceMainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {
	

	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@LocalServerPort
	private int port;

	 @Before
	  public void setUp() {
		 
	 }
	 
	 @Test
	 public void testSample() {
		 headers.add("token", "oOQKobUjdbf0imGdfUPN9pWCUIoikK8nbNej5zqHeccD71XFnnLKjNmKX1dpcY0dmV8lnm4O4pVwE6rBsoj00Cr9cBeYoOTvYSwz2PghHVugC9bkx4HY8lDBek4P7OBWyvNbvpGvnVaGWDLy1HYcl3V9ptyR5uFWunLd9tZixKTSjbQJ0eGdPbagFiesPJeb5lO5j4iPrOrgS0HzEKwWxM1tCjHjULFAL4gB3ZpX6xYW96HHP3b2iImAmuw3li4O");
		 headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	
			ResponseEntity<?> response = restTemplate.exchange(
					createURLWithPort("/api/v1/getalltest"),
					HttpMethod.GET, entity, Object.class);
			Assert.notNull(response, "students list are not null");
		
			//String expected = "{id:Course1,name:Spring,description:10 Steps}";

			//JSONAssert.assertEquals(expected, response.getBody(), false);
		}
	 
	 

	 private String createURLWithPort(String uri) {
			return "http://localhost:" + port + uri;
		}

}
