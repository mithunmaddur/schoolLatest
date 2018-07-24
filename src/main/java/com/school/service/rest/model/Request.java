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
 * @date 08-Jun-2018 1:27:55 PM
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 3899044654037352511L;
  
  private String requestId;

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

}
