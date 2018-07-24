/**
 * 
 */
package com.school.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.school.service.exception.TransitApplicationException;
import com.school.service.rest.model.Response;


@ControllerAdvice
public class RestResponseEntityExceptionHandler {

	@ExceptionHandler({ javax.servlet.ServletException.class })
	public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
		HttpStatus httpStatus = null;

		if (ex instanceof HttpMediaTypeNotSupportedException) {
			httpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		} else {
			httpStatus = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<>(getResponse(String.valueOf(httpStatus.value()), httpStatus.getReasonPhrase()),
				new HttpHeaders(), httpStatus);
	}

	@ExceptionHandler({ TransitApplicationException.class })
	public ResponseEntity<Object> handleException(TransitApplicationException ex, WebRequest request) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		return new ResponseEntity<>(getResponse(ex.getCode(), ex.getMessage()), new HttpHeaders(), httpStatus);
	}

	/**
	 * Method to get Response with code and message
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	private Response getResponse(String code, String msg) {
		Response response = new Response();
		response.setCode("0" + code);
		response.setMessage(msg);
		return response;
	}
}
