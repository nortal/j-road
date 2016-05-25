package com.nortal.jroad.model;

import java.util.List;

/**
 * Abstraction of a request or response message. Contains the header, body and attachments of a message.
 * 
 * @author Dmitri Danilkin
 * @param <T> type of body element
 */
public interface XRoadMessage<T> {
  XRoadHeader getHeader();

  T getContent();

  void setContent(T content);

  List<XRoadAttachment> getAttachments();
}
