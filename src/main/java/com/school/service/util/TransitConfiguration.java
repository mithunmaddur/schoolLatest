/**
 * 
 */
package com.school.service.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * << Add Comments Here >>
 *
 * @author
 * @date 08-Jun-2018 1:09:40 PM
 * @version 1.0
 */
@Configuration
@PropertySource({ "classpath:application.properties" })
@Component
public class TransitConfiguration {

	@Value("${default.api.version}")
	private String defaultApiVersion;

	// @Value(ErrorCode.SUCCESS.getMessage())
	private String successMessage;

	public String getDefaultApiVersion() {
		return defaultApiVersion;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

}
