package com.nortal.jroad.client.service.configuration;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
@SuppressWarnings("serial")
public class SimpleXRoadServiceConfiguration extends SimpleXTeeServiceConfiguration
    implements XRoadServiceConfiguration {

  private String clientXRoadInstance;
  private String clientMemberClass;
  private String clientMemberCode;
  private String clientSubsystemCode;

  private String serviceXRoadInstance;
  private String serviceMemberClass;
  private String serviceMemberCode;
  // TODO Lauri: if this is actually xroad "andmekogu" then we can assign it by database property
  private String serviceSubsystemCode;

  public String getClientXRoadInstance() {
    return clientXRoadInstance;
  }

  public void setClientXRoadInstance(String clientXRoadInstance) {
    this.clientXRoadInstance = clientXRoadInstance;
  }

  public String getClientMemberClass() {
    return clientMemberClass;
  }

  public void setClientMemberClass(String clientMemberClass) {
    this.clientMemberClass = clientMemberClass;
  }

  public String getClientMemberCode() {
    return clientMemberCode;
  }

  public void setClientMemberCode(String clientMemberCode) {
    this.clientMemberCode = clientMemberCode;
  }

  public String getClientSubsystemCode() {
    return clientSubsystemCode;
  }

  public void setClientSubsystemCode(String clientSubsystemCode) {
    this.clientSubsystemCode = clientSubsystemCode;
  }

  public String getServiceXRoadInstance() {
    return serviceXRoadInstance;
  }

  public void setServiceXRoadInstance(String serviceXRoadInstance) {
    this.serviceXRoadInstance = serviceXRoadInstance;
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
