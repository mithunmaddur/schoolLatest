package com.school.service.exception;

import java.io.Serializable;

import com.school.service.common.ErrorCode;
import com.school.service.util.StringUtil;

public class TransitApplicationException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5604913873826069798L;
	private  int status;
	private String message;
	private String code;
	private int errCode;

	public TransitApplicationException() {
		super();
	}

	public TransitApplicationException(int status, String message) {
		this.message = message;
		this.status = status;
	}

	public TransitApplicationException(int status, String message, String code) {
		this.message = message;
		this.status = status;
		this.code = code;
	}

	public TransitApplicationException(int status, ErrorCode errCode) {
		this.message = errCode.getMessage();
		this.status = status;
		this.code = errCode.getErrCode();
	}

	public TransitApplicationException(int status, ErrorCode errCode, String message) {
		if (null == message || StringUtil.isNullAndEmpty(message)) {
			message = errCode.getMessage();
		}
		this.message = message;
		this.status = status;
		this.code = errCode.getErrCode();
	}

	public TransitApplicationException(String message, int errCode) {
		this.message = message;
		this.errCode = errCode;
	}

	public TransitApplicationException(int status, String[] replaceMsg, ErrorCode errCode) {
		String errorMessage = errCode.getMessage();
		for (int i = 0; i < replaceMsg.length; i++) {
			errorMessage = errorMessage.replace("{" + i + "}", replaceMsg[i]);
		}
		this.message = errorMessage;
		this.status = status;
		this.code = errCode.getErrCode();
	}

	public TransitApplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TransitApplicationException(String message, Throwable cause) {
		super(message, cause);
		}

	public TransitApplicationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TransitApplicationException(Throwable cause) {
		super(cause);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

}
