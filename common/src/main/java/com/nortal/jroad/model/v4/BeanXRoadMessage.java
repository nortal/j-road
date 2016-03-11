package com.nortal.jroad.model.v4;

import java.util.List;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
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

  public void setAttachments(List<XRoadAttachment> attachments) {
    this.attachments = attachments;
  }

  public XRoadHeader getHeader() {
    return header;
  }

  public void setHeader(XRoadHeader header) {
    this.header = header;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

}
