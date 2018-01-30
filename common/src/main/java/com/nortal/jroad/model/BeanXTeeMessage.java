package com.nortal.jroad.model;

import java.util.List;

/**
 * DOM Based {@link XTeeMessage} implementation.
 * 
 * @author Dmitri Danilkin
 */
// Should switch to X-road implementation
@Deprecated
public class BeanXTeeMessage<T> implements XTeeMessage<T> {
  private List<XTeeAttachment> attachments;
  private XTeeHeader header;
  private T content;

  public BeanXTeeMessage(XTeeHeader header, T content, List<XTeeAttachment> attachments) {
    this.attachments = attachments;
    this.header = header;
    this.content = content;
  }

  public List<XTeeAttachment> getAttachments() {
    return attachments;
  }

  public XTeeHeader getHeader() {
    return header;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public void setAttachments(List<XTeeAttachment> attachments) {
    this.attachments = attachments;
  }

  public void setHeader(XTeeHeader header) {
    this.header = header;
  }
}
