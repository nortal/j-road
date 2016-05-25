/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

/**
 * Encapsulates X-Tee query header object.
 * 
 * @author Roman Tekhov
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
// TODO Lauri: see tuleks veel üle vaadata. Hetkel ei ole piisav protokoll 4 päiste mappimiseks ja endpointid peavad
// teatud perioodil ka protokoll 2 päistest aru saama. Küsimus on tegelt, kas seda on üldse vaja ja kui siis mida
// täpsemalt - ilmselt päringu sooritaja id võib vaja minna
// Should switch to X-road implementation
@Deprecated
public class XTeeHeader implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String XROAD_NS_URI = "http://x-road.eu/xsd/xroad.xsd";

  public static final QName CLIENT = new QName(XROAD_NS_URI, "client");
  public static final QName SERVICE = new QName(XROAD_NS_URI, "service");
  public static final QName USER_ID = new QName(XROAD_NS_URI, "userId");
  public static final QName ID = new QName(XROAD_NS_URI, "id");
  public static final QName PROTOCOL_VERSION = new QName(XROAD_NS_URI, "protocolVersion");

  private Map<QName, String> elemendid;

  public Map<QName, String> getElemendid() {
    return elemendid;
  }

  public void setElemendid(Map<QName, String> elemendid) {
    this.elemendid = elemendid;
  }

  public void addElement(QName nimi, String vaartus) {
    if (elemendid == null) {
      elemendid = new HashMap<QName, String>();
    }

    elemendid.put(nimi, vaartus);
  }
}
