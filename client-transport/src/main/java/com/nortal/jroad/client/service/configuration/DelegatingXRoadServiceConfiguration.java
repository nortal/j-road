/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.client.service.configuration;

import com.nortal.jroad.client.enums.XroadObjectType;
import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * Delegates calls to embedded configuration.
 * 
 * @author Tanel Käär (tanelk@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class DelegatingXRoadServiceConfiguration implements XRoadServiceConfiguration {
  private static final long serialVersionUID = 1L;

  protected XRoadServiceConfiguration configuration;

  public DelegatingXRoadServiceConfiguration(XRoadServiceConfiguration configuration) {
    this.configuration = configuration;
  }

  @Override
  public String getDatabase() {
    return configuration.getDatabase();
  }

  @Override
  public String getFile() {
    return configuration.getFile();
  }

  @Override
  public String getIdCode() {
    return configuration.getIdCode();
  }

  @Override
  public String getMethod() {
    return configuration.getMethod();
  }

  @Override
  public String getSecurityServer() {
    return configuration.getSecurityServer();
  }

  @Override
  public String getVersion() {
    return configuration.getVersion();
  }

  @Override
  public String getWsdlDatabase() {
    return configuration.getWsdlDatabase();
  }

  @Override
  public XRoadProtocolVersion getProtocolVersion() {
    return configuration.getProtocolVersion();
  }

  @Override
  public String getClientXRoadInstance() {
    return configuration.getClientXRoadInstance();
  }

  @Override
  public String getClientMemberClass() {
    return configuration.getClientMemberClass();
  }

  @Override
  public String getClientMemberCode() {
    return configuration.getClientMemberCode();
  }

  @Override
  public String getClientSubsystemCode() {
    return configuration.getClientSubsystemCode();
  }

  @Override
  public XroadObjectType getClientObjectType() {
    return configuration.getClientObjectType();
  }

  @Override
  public String getServiceXRoadInstance() {
    return configuration.getServiceXRoadInstance();
  }

  @Override
  public String getServiceMemberClass() {
    return configuration.getServiceMemberClass();
  }

  @Override
  public String getServiceMemberCode() {
    return configuration.getServiceMemberCode();
  }

  @Override
  public String getServiceSubsystemCode() {
    return configuration.getServiceSubsystemCode();
  }

  @Override
  public XroadObjectType getServiceObjectType() {
    return configuration.getServiceObjectType();
  }
}
