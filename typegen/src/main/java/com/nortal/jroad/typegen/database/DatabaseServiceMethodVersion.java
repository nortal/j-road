package com.nortal.jroad.typegen.database;

import org.apache.xmlbeans.impl.common.NameUtil;

import com.nortal.jroad.model.XmlBeansXRoadMetadata;

/**
 * @author Roman Tekhov
 */
public class DatabaseServiceMethodVersion {

  private String name;
  private Integer version;

  public DatabaseServiceMethodVersion(XmlBeansXRoadMetadata serviceMetadata) {
    this.name = NameUtil.lowerCamelCase(serviceMetadata.getOperationName());
  }

  public DatabaseServiceMethodVersion(XmlBeansXRoadMetadata serviceMetadata, int version) {
    this.version = version;
    this.name = NameUtil.lowerCamelCase(serviceMetadata.getOperationName() + "_v" + version);
  }


  public String getName() {
    return name;
  }

  public Integer getVersion() {
    return version;
  }
}