package com.nortal.jroad.client.exception;

import java.io.IOException;

import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.client.SoapFaultClientException;

/**
 * An exception thrown to indicate that a transport error has occured during X-tee service invocation or that X-tee
 * service has returned a fault result.
 * 
 * @author Roman Tekhov
 */
public class XRoadServiceConsumptionException extends IOException {

  private static final long serialVersionUID = 1L;
  private static final String SERVER_PREFIX = "Server";
  private static final String CLIENT_PREFIX = "Client";

  private SoapFaultClientException soapFaultClientException;
  private WebServiceIOException webServiceIOException;
  private NonTechnicalFaultException nonTechnicalFaultException;

  private String database;
  private String method;
  private String version;

  public XRoadServiceConsumptionException(SoapFaultClientException soapFaultClientException,
                                         String database,
                                         String method,
                                         String version) {

    this((Exception) soapFaultClientException, database, method, version);
    this.soapFaultClientException = soapFaultClientException;
  }

  public XRoadServiceConsumptionException(WebServiceIOException webServiceIOException,
                                         String database,
                                         String method,
                                         String version) {

    this((Exception) webServiceIOException, database, method, version);
    this.webServiceIOException = webServiceIOException;
  }

  public XRoadServiceConsumptionException(NonTechnicalFaultException nonTechnicalFaultException,
                                         String database,
                                         String method,
                                         String version) {

    this((Exception) nonTechnicalFaultException, database, method, version);
    this.nonTechnicalFaultException = nonTechnicalFaultException;
  }

  private XRoadServiceConsumptionException(Exception cause, String database, String method, String version) {
    if (cause == null) {
      throw new IllegalArgumentException("Cause can not be null!");
    }

    initCause(cause);

    this.database = database;
    this.method = method;
    this.version = version;
  }

  public SoapFaultClientException getSoapFaultClientException() {
    return soapFaultClientException;
  }

  public WebServiceIOException getWebServiceIOException() {
    return webServiceIOException;
  }

  public boolean isFault() {
    return getSoapFaultClientException() != null;
  }

  public boolean isIOError() {
    return getWebServiceIOException() != null;
  }

  public String getFaultCode() {
    return isFault() ? getSoapFaultClientException().getFaultCode().getLocalPart() : null;
  }

  public String getFaultString() {
    return isFault() ? getSoapFaultClientException().getFaultStringOrReason() : null;
  }

  public String getFaultActor() {
    return isFault() ? getSoapFaultClientException().getSoapFault().getFaultActorOrRole() : null;
  }

  public SoapFaultDetail getFaultDetail() {
    return isFault() ? getSoapFaultClientException().getSoapFault().getFaultDetail() : null;
  }

  public boolean isServerFault() {
    return isFaultOfType(SERVER_PREFIX);
  }

  public boolean isClientFault() {
    return isFaultOfType(CLIENT_PREFIX);
  }

  private boolean isFaultOfType(String type) {
    String faultCode = getFaultCode();
    return faultCode != null && faultCode.startsWith(type);
  }

  public boolean isNonTechnicalFault() {
    return nonTechnicalFaultException != null;
  }

  public String getNonTechnicalFaultCode() {
    return isNonTechnicalFault() ? nonTechnicalFaultException.getFaultCode() : null;
  }

  public String getNonTechnicalFaultString() {
    return isNonTechnicalFault() ? nonTechnicalFaultException.getFaultString() : null;
  }

  public String getDatabase() {
    return database;
  }

  public String getMethod() {
    return method;
  }

  public String getVersion() {
    return version;
  }

  public String getFullServiceName() {
    return getDatabase() + "." + getMethod() + "." + getVersion();
  }

}
