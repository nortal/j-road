package com.nortal.jroad.client.service.configuration;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
@SuppressWarnings("serial")
public class SimpleXRoadServiceConfiguration extends SimpleXTeeServiceConfiguration
    implements XRoadServiceConfiguration {

  // TODO Lauri: this should be sufficient assuming dev/test/live environments cannot exchange messages
  private String xRoadInstance;

  private String clientMemberClass;
  private String clientSubsystemCode;

  private String serviceMemberClass;
  private String serviceMemberCode;
  // TODO Lauri: if this is actually xroad "andmekogu" then we can assign it by database property
  private String serviceSubsystemCode;

  public String getXRoadInstance() {
    return xRoadInstance;
  }

  public void setXRoadInstance(String xRoadInstance) {
    this.xRoadInstance = xRoadInstance;
  }

  public String getClientMemberClass() {
    return clientMemberClass;
  }

  public void setClientMemberClass(String clientMemberClass) {
    this.clientMemberClass = clientMemberClass;
  }

  public String getClientSubsystemCode() {
    return clientSubsystemCode;
  }

  public void setClientSubsystemCode(String clientSubsystemCode) {
    this.clientSubsystemCode = clientSubsystemCode;
  }

  public String getServiceMemberClass() {
    return serviceMemberClass;
  }

  public void setServiceMemberClass(String serviceMemberClass) {
    this.serviceMemberClass = serviceMemberClass;
  }

  public String getServiceMemberCode() {
    return serviceMemberCode;
  }

  public void setServiceMemberCode(String serviceMemberCode) {
    this.serviceMemberCode = serviceMemberCode;
  }

  public String getServiceSubsystemCode() {
    return serviceSubsystemCode;
  }

  public void setServiceSubsystemCode(String serviceSubsystemCode) {
    this.serviceSubsystemCode = serviceSubsystemCode;
  }
}
