/**
 * 
 */
package com.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * << Add Comments Here >>
 *
 * @author 
 * @date 08-Jun-2018 10:15:39 AM
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.school"})
@EnableWebMvc
public class SchoolServiceMainApplication {
  
  private static Logger logger = LoggerFactory.getLogger(SchoolServiceMainApplication.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  logger.info("Staring Spring Boot App...");
	  SpringApplication.run(SchoolServiceMainApplication.class, args);
	  logger.info("Started Spring Boot App...");
	}

}
