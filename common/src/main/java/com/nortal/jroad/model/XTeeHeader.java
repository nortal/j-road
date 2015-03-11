/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
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

import com.nortal.jroad.util.XTeeUtil;

/**
 * Encapsulates X-Tee query header object.
 * 
 * @author Roman Tekhov
 */
public class XTeeHeader implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final QName ASUTUS = new QName(XTeeUtil.XTEE_NS_URI, "asutus");
  public static final QName ANDMEKOGU = new QName(XTeeUtil.XTEE_NS_URI, "andmekogu");
  public static final QName ISIKUKOOD = new QName(XTeeUtil.XTEE_NS_URI, "isikukood");
  public static final QName ID = new QName(XTeeUtil.XTEE_NS_URI, "id");
  public static final QName NIMI = new QName(XTeeUtil.XTEE_NS_URI, "nimi");
  public static final QName AMET = new QName(XTeeUtil.XTEE_NS_URI, "amet");
  public static final QName AMETNIK = new QName(XTeeUtil.XTEE_NS_URI, "ametnik");
  public static final QName AMETNIKNIMI = new QName(XTeeUtil.XTEE_NS_URI, "ametniknimi");
  public static final QName ALLASUTUS = new QName(XTeeUtil.XTEE_NS_URI, "allasutus");

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

  public String getAsutus() {
    return elemendid.get(ASUTUS);
  }

  /**
   * Return's Xtee database, equivalent to {@link XTeeHeader#getXteeDatabase()} call.
   */
  public String getAndmekogu() {
    return elemendid.get(ANDMEKOGU);
  }

  /**
   * Return's Xtee database, equivalent to {@link XTeeHeader#getAndmekogu()} call.
   */
  public String getXteeDatabase() {
    return elemendid.get(ANDMEKOGU);
  }

  public String getIsikukood() {
    return elemendid.get(ISIKUKOOD);
  }

  public String getId() {
    return elemendid.get(ID);
  }

  public String getNimi() {
    return elemendid.get(NIMI);
  }

  public String getAmet() {
    return elemendid.get(AMET);
  }

  public String getAmetniknimi() {
    return elemendid.get(AMETNIKNIMI);
  }

  public String getAllasutus() {
    return elemendid.get(ALLASUTUS);
  }
}
