/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.util;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

/**
 * Utility methods for deducing canonical service names and XML namespaces,
 *
 * @author Roman Tekhov
 * @author Dmitri Danilkin
 */
@Deprecated
public class XTeeUtil {

  public static final String XTEE_NS_PREFIX = "xtee";
  public static final String XTEE_NS_URI = "http://x-tee.riik.ee/xsd/xtee.xsd";

  /**
   * Returns the input string with &quot;/cgi-bin/consumer_proxy&quot; concatenated to it.
   */
  public static String toSecurityServerAddress(String aadress) {
    return new StringBuilder(aadress).append("/cgi-bin/consumer_proxy").toString();
  }

  /**
   * Returns the input string with &quot;/cgi-bin/uriproxy&quot; concatenated to it.
   */
  public static String toSecurityServerUri(String aadress) {
    return new StringBuilder(aadress).append("/cgi-bin/uriproxy").toString();
  }

  /**
   * Returns namespace for database -- that is, returns namespace in the form
   * <code>http://producers.database.xtee.riik.ee/producer/database</code>.
   *
   * @param dbName database ("andmekogu") name
   * @return namespace for data services in a database, in the form
   *         <code>http://producers.dbName.xtee.riik.ee/producer/dbName</code>
   */
  public static String getDatabaseNamespace(String dbName) {
    return new StringBuilder("http://producers.").append(dbName).append(".xtee.riik.ee/producer/").append(dbName).toString();
  }

  /**
   * Adds a X-Tee header element with given value and using correct namespace, element type is set to
   * <code>xsd:string</code>.
   *
   * @param header Header of the <code>SOAPMessage</code>
   * @param name Header element name
   * @param value Header element value
   */
  public static void addHeaderElement(SOAPHeader header, String name, String value, String nsPrefix)
      throws SOAPException {
    SOAPElement element = header.addChildElement(name, nsPrefix);
    SOAPUtil.addTypeAttribute(element, "xsd:string");
    if (value != null) {
      element.addTextNode(value);
    }
  }

  /**
   * Adds X-Tee namespace to a <code>SOAPMessage</code>.
   *
   * @param message Message to add the namespace to.
   */
  public static void addXteeNamespace(SOAPMessage message, String nsPrefix, String nsUri) throws SOAPException {
    SOAPUtil.addNamespace(message, nsPrefix, nsUri);
  }
}
