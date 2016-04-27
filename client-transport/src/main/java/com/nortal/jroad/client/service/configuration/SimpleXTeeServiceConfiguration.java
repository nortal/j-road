/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.client.service.configuration;

import java.io.Serializable;

import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * A simple {@link BaseXRoadServiceConfiguration} implementation which acts in a JavaBean manner allowing to define all
 * required valus via setters.
 * 
 * @see BaseXRoadServiceConfiguration
 * @author Rando Mihkelsaar
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class SimpleXTeeServiceConfiguration implements BaseXRoadServiceConfiguration, Serializable {
  private static final long serialVersionUID = 1L;
  private String database;
  private String wsdlDatabase;
  private String securityServer;
  private String idCode;
  private String institution;
  private String file;
  private String version;
  private String method;
  private boolean forceDatabaseNamespace = false;
  private XRoadProtocolVersion protocolVersion;

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
  public String getInstitution() {
    return institution;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
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
    result = prime * result + ((institution == null) ? 0 : institution.hashCode());
    result = prime * result + ((method == null) ? 0 : method.hashCode());
    result = prime * result + ((securityServer == null) ? 0 : securityServer.hashCode());
    result = prime * result + ((file == null) ? 0 : file.hashCode());
    result = prime * result + ((version == null) ? 0 : version.hashCode());
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
    SimpleXTeeServiceConfiguration other = (SimpleXTeeServiceConfiguration) obj;
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
    if (institution == null) {
      if (other.institution != null)
        return false;
    } else if (!institution.equals(other.institution))
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
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SimpleXteeServiceConfigurator[");
    builder.append(" database = ").append(database);
    builder.append(" idCode = ").append(idCode);
    builder.append(" institution = ").append(institution);
    builder.append(" method = ").append(method);
    builder.append(" securityServer = ").append(securityServer);
    builder.append(" file = ").append(file);
    builder.append(" version = ").append(version);
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
  public void forceDatabaseNamespace() {
    this.forceDatabaseNamespace = true;
  }

  @Override
  public boolean getForceDatabaseNamespace() {
    return forceDatabaseNamespace;
  }

  @Override
  public XRoadProtocolVersion getProtocolVersion() {
    return protocolVersion;
  }

  public void setProtocolVersion(XRoadProtocolVersion protocolVersion) {
    this.protocolVersion = protocolVersion;
  }
}
