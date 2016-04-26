/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.client.service.configuration;

import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * Interface representing the information about X-Road service and the client that wishes to access it -- both are
 * needed when actual service invocation is performed, as X-Road services need certain information about invoker to be
 * present.
 * 
 * @author Alrik Peets
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public interface BaseXRoadServiceConfiguration {
  /**
   * Returns an URL of institutions security server, typically in form of
   * <code>http://minu_turvaserver/cgi-bin/consumer_proxy</code>.
   */
  String getSecurityServer();

  /**
   * Returns name/prefix of the X-Tee database where the service-to-be-invoked resides.
   */
  String getDatabase();

  /**
   * Returns name/prefix of the X-Tee database, which is actually specified in the WSDL of the service.
   */
  String getWsdlDatabase();

  /** Returns identifier of the person/entity who will be invoking the service */
  String getIdCode();

  /** Returns institution identifier. */
  String getInstitution();

  /** Returns name of file (or document) related to the service invokation. */
  String getFile();

  /** Returns the service-to-be-invoked version. */
  String getVersion();

  /** Returns the name of the (service's) <code>method<code> that will be called. */
  String getMethod();

  /** Returns whether the namespace should be forced to match the called database namespace **/
  boolean getForceDatabaseNamespace();

  /**
   * Forced the database namespace to match the called database namespace. Make sure you /really/ know what you are
   * doing when calling this. It is not needed by default.
   **/
  void forceDatabaseNamespace();

  /**
   * Returns database xroad protocol version - by default v4
   */
  XRoadProtocolVersion getProtocolVersion();
}
