package com.nortal.jroad.util.header;

import org.springframework.util.CollectionUtils;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class XRoadHeaderElement {
  private QName qName;
  private List<XRoadHeaderElement> children;
  private String value;

  public XRoadHeaderElement() {
  }

  public XRoadHeaderElement(QName qName, String value) {
    this.qName = qName;
    this.value = value;
  }

  public QName getQName() {
    return qName;
  }

  public void setQName(QName qName) {
    this.qName = qName;
  }

  public List<XRoadHeaderElement> getChildren() {
    return children;
  }

  public void setChildren(List<XRoadHeaderElement> children) {
    this.children = children;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void addChild(XRoadHeaderElement child) {
    if (this.children == null) {
      this.children = new ArrayList<XRoadHeaderElement>();
    }
    this.children.add(child);
  }

  public boolean hasChildren() {
    return !CollectionUtils.isEmpty(children);
  }
}
