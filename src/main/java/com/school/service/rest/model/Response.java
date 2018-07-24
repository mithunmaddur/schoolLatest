/**
 * 
 */
package com.school.service.rest.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * << Add Comments Here >>
 *
 * @author 
 * @date 08-Jun-2018 1:33:27 PM
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 4843687168546847239L;
  
  private String requestId;
  
  private String code;
  
  private String message;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

}
