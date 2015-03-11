package com.nortal.jroad.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeHeader;
import com.nortal.jroad.model.XTeeMessage;

/**
 * XmlBeans based {@link XTeeMessage} implementation. Header should be retrieved using getParing() command from the
 * content itself.
 * 
 * @author Dmitri Danilkin
 * @param <T>
 */
public class XmlBeansXTeeMessage<T extends XmlObject> implements XTeeMessage<T> {
  private List<XTeeAttachment> attachments = new ArrayList<XTeeAttachment>();
  private T content;

  public XmlBeansXTeeMessage(T content, List<XTeeAttachment> attachments) {
    if (attachments != null) {
      this.attachments = attachments;
    }
    this.content = content;
  }

  public XmlBeansXTeeMessage(T content) {
    this(content, null);
  }

  public List<XTeeAttachment> getAttachments() {
    return attachments;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public XTeeHeader getHeader() {
    throw new UnsupportedOperationException("Get header from content instead of using this method.");
  }

}
