package com.nortal.jroad.typegen.database;

import org.apache.xmlbeans.impl.common.NameUtil;

import com.nortal.jroad.model.XmlBeansXRoadMetadata;

/**
 * @author Roman Tekhov
 */
public class DatabaseServiceMethodVersion {

  private String name;
  private int version;


  public DatabaseServiceMethodVersion(XmlBeansXRoadMetadata serviceMetadata, int version) {
    this.version = version;
    name = NameUtil.lowerCamelCase(serviceMetadata.getOperationName() + "_v" + version);
  }


  public String getName() {
    return name;
  }

  public int getVersion() {
    return version;
  }
}