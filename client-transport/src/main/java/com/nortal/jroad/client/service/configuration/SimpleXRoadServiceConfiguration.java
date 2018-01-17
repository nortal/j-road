package com.nortal.jroad.client.service.configuration;

import com.nortal.jroad.client.enums.XroadObjectType;
import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
@SuppressWarnings("serial")
public class SimpleXRoadServiceConfiguration implements XRoadServiceConfiguration {
  private String database;
  private String wsdlDatabase;
  private String securityServer;
  private String idCode;
  private String file;
  private String version;
  private String method;
  private XRoadProtocolVersion protocolVersion;

  private String clientXRoadInstance;
  private String clientMemberClass;
  private String clientMemberCode;
  private String clientSubsystemCode;
  private XroadObjectType clientObjectType = XroadObjectType.SUBSYSTEM;

  private String serviceXRoadInstance;
  private String serviceMemberClass;
  private String serviceMemberCode;
  private String serviceSubsystemCode;
  private XroadObjectType serviceObjectType = XroadObjectType.SERVICE;

  @Override
  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  @Override
  public String getSecurityServer() {
    return securityServer;
  }

  public void setSecurityServer(String securityServer) {
    this.securityServer = securityServer;
  }

  @Override
  public String getIdCode() {
    return idCode;
  }

  public void setIdCode(String idCode) {
    this.idCode = idCode;
  }

  @Override
  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  @Override
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((database == null) ? 0 : database.hashCode());
    result = prime * result + ((idCode == null) ? 0 : idCode.hashCode());
    result = prime * result + ((method == null) ? 0 : method.hashCode());
    result = prime * result + ((securityServer == null) ? 0 : securityServer.hashCode());
    result = prime * result + ((file == null) ? 0 : file.hashCode());
    result = prime * result + ((version == null) ? 0 : version.hashCode());
    result = prime * result + ((protocolVersion == null) ? 0 : protocolVersion.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SimpleXRoadServiceConfiguration other = (SimpleXRoadServiceConfiguration) obj;
    if (database == null) {
      if (other.database != null)
        return false;
    } else if (!database.equals(other.database))
      return false;
    if (idCode == null) {
      if (other.idCode != null)
        return false;
    } else if (!idCode.equals(other.idCode))
      return false;
    if (method == null) {
      if (other.method != null)
        return false;
    } else if (!method.equals(other.method))
      return false;
    if (securityServer == null) {
      if (other.securityServer != null)
        return false;
    } else if (!securityServer.equals(other.securityServer))
      return false;
    if (file == null) {
      if (other.file != null)
        return false;
    } else if (!file.equals(other.file))
      return false;
    if (version == null) {
      if (other.version != null)
        return false;
    } else if (!version.equals(other.version))
      return false;
    if (protocolVersion == null) {
      if (other.protocolVersion != null)
        return false;
    } else if (!protocolVersion.equals(other.protocolVersion))
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SimpleXteeServiceConfigurator[");
    builder.append(" database = ").append(database);
    builder.append(" idCode = ").append(idCode);
    builder.append(" method = ").append(method);
    builder.append(" securityServer = ").append(securityServer);
    builder.append(" file = ").append(file);
    builder.append(" version = ").append(version);
    builder.append(" protocolVersion = ").append(protocolVersion);
    builder.append("]");
    return builder.toString();
  }

  @Override
  public String getWsdlDatabase() {
    return wsdlDatabase;
  }

  public void setWsdlDatabase(String wsdlDatabase) {
    this.wsdlDatabase = wsdlDatabase;
  }

  @Override
  public XRoadProtocolVersion getProtocolVersion() {
    return protocolVersion;
  }

  public void setProtocolVersion(XRoadProtocolVersion protocolVersion) {
    this.protocolVersion = protocolVersion;
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

  @Override
  public XroadObjectType getClientObjectType() {
    return clientObjectType;
  }

  public void setClientObjectType(XroadObjectType clientObjectType) {
    this.clientObjectType = clientObjectType;
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

  public XroadObjectType getServiceObjectType() {
    return serviceObjectType;
  }

  public void setServiceObjectType(XroadObjectType serviceObjectType) {
    this.serviceObjectType = serviceObjectType;
  }
}
