/**
 * 
 */
package com.catalyst.utils;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Hannah
 * 
 */
@Component
public class Response {



  private List<String> errorList;
  private Object response;
  private String statusCode;

  public Response() {

  }



  /**
   * @return the response
   */
  public Object getResponse() {
    return response;
  }


  /**
   * @param response the response to set
   */
  public void setResponse(Object response) {
    this.response = response;
  }



  public List<String> getErrorList() {
    return errorList;
  }



  public void setErrorList(List<String> errorList) {
    this.errorList = errorList;
  }



  public String getStatusCode() {
    return statusCode;
  }



  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }



}
