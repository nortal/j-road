package com.nortal.jroad.model;

import java.util.List;

import org.w3c.dom.Node;

/**
 * DOM Based {@link XRoadMessage} implementation.
 * 
 * @author Dmitri Danilkin
 * @param <T extends {@link Node}>
 */
public class BeanXRoadMessage<T> implements XRoadMessage<T> {
  private List<XRoadAttachment> attachments;
  private XRoadHeader header;
  private T content;

  public BeanXRoadMessage(XRoadHeader header, T content, List<XRoadAttachment> attachments) {
    this.attachments = attachments;
    this.header = header;
    this.content = content;
  }

  public List<XRoadAttachment> getAttachments() {
    return attachments;
  }

  public XRoadHeader getHeader() {
    return header;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public void setAttachments(List<XRoadAttachment> attachments) {
    this.attachments = attachments;
  }

  public void setHeader(XRoadHeader header) {
    this.header = header;
  }
}
