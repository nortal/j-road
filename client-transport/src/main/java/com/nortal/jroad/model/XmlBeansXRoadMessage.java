package com.nortal.jroad.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

/**
 * XmlBeans based {@link XTeeMessage} implementation. Header should be retrieved using getParing() command from the
 * content itself.
 * 
 * @author Dmitri Danilkin
 * @param <T>
 */
public class XmlBeansXRoadMessage<T extends XmlObject> implements XRoadMessage<T> {
  private List<XRoadAttachment> attachments = new ArrayList<XRoadAttachment>();
  private T content;

  public XmlBeansXRoadMessage(T content, List<XRoadAttachment> attachments) {
    if (attachments != null) {
      this.attachments = attachments;
    }
    this.content = content;
  }

  public XmlBeansXRoadMessage(T content) {
    this(content, null);
  }

  public List<XRoadAttachment> getAttachments() {
    return attachments;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public XRoadHeader getHeader() {
    throw new UnsupportedOperationException("Get header from content instead of using this method.");
  }

}
