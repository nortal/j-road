package com.nortal.jroad.client.util;


public class ServiceVersion {

  public static final String _METASERVICE = "_METASERVICE";

  private String val;

  public ServiceVersion(String val) {
    this.val = val;
  }

  public boolean isVersionedMethod() {
    return (val != null && !_METASERVICE.equals(val));
  }

  public String asString() {
    return val;
  }
}
