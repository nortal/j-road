package com.nortal.jroad.client.service.configuration.v4;

import com.nortal.jroad.client.service.configuration.v2.SimpleXTeeServiceConfiguration;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
@SuppressWarnings("serial")
public class SimpleXRoadServiceConfiguration extends SimpleXTeeServiceConfiguration implements
    XRoadServiceConfiguration {

  private String clientObjectType;
  private String clientXRoadInstance;
  private String clientMemberClass;
  private String clientMemberCode;
  private String clientSubsystemCode;

  private String serviceObjectType;
  private String serviceXRoadInstance;
  private String serviceMemberClass;
  private String serviceMemberCode;
  private String serviceSubsystemCode;

  public String getClientObjectType() {
    return clientObjectType;
  }

  public void setClientObjectType(String clientObjectType) {
    this.clientObjectType = clientObjectType;
  }

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

  public String getServiceObjectType() {
    return serviceObjectType;
  }

  public void setServiceObjectType(String serviceObjectType) {
    this.serviceObjectType = serviceObjectType;
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

  @Override
  public boolean useDeprecatedApi() {
    return false;
  }

  @Override
  public String getInstitution() {
    return getClientMemberCode();
  }
}
