package ee.webmedia.xtee.client.exception;

import java.io.IOException;

/**
 * @author Roman Tekhov
 */
public class NonTechnicalFaultException extends IOException {

  private String faultCode;
  private String faultString;

  public NonTechnicalFaultException(String faultCode, String faultString) {
    this.faultCode = faultCode;
    this.faultString = faultString;
  }

  public String getFaultCode() {
    return faultCode;
  }

  public String getFaultString() {
    return faultString;
  }

}
