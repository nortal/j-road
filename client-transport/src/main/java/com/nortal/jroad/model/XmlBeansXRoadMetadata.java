package com.nortal.jroad.model;

import java.io.Serializable;

/**
 * Holds metadata needed for the client.
 *
 * @author Dmitri Danilkin
 */
public class XmlBeansXRoadMetadata implements Serializable {
  private static final long serialVersionUID = 1L;

  private String operationName;
  private String operationNs;

  private String requestElementName;
  private String requestElementNs;

  private String responseElementName;
  private String responseElementNs;

  private String version;

  public XmlBeansXRoadMetadata(String operationName,
                              String operationNs,
                              String requestElementName,
                              String requestElementNs,
                              String responseElementName,
                              String responseElementNs,
                              String version) {
    this.operationName = operationName;
    this.operationNs = operationNs;
    this.requestElementName = requestElementName;
    this.requestElementNs = requestElementNs;
    this.responseElementName = responseElementName;
    this.responseElementNs = responseElementNs;
    this.version = version;
  }

  public String getOperationName() {
    return operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public String getOperationNs() {
    return operationNs;
  }

  public void setOperationNs(String operationNs) {
    this.operationNs = operationNs;
  }

  public String getResponseElementName() {
    return responseElementName;
  }

  public void setResponseElementName(String responseElementName) {
    this.responseElementName = responseElementName;
  }

  public String getRequestElementName() {
    return requestElementName;
  }

  public String getRequestElementNs() {
    return requestElementNs;
  }

  public String getResponseElementNs() {
    return responseElementNs;
  }

  public void setResponseElementNs(String responseElementNs) {
    this.responseElementNs = responseElementNs;
  }

  public String getVersion() {
    return version;
  }

}
