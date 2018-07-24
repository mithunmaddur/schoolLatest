/**
 * 
 */
package com.school.service.rest.validation;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import com.school.service.common.ErrorCode;
import com.school.service.exception.TransitApplicationException;

/**
 * @author
 *
 */
public interface ValidationHandler {
	
	
	/**
	 * @param header
	 * @throws TransitApplicationException
	 */
	public default void validateHeader(String header) throws TransitApplicationException {
		if (StringUtils.isEmpty(header)) {
			throw new TransitApplicationException(HttpStatus.BAD_REQUEST.value(), ErrorCode.UUID_MISSING_ERR);
		}
		
	}
	

}
