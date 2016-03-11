package com.nortal.jroad.model.v4;

import java.util.List;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public interface XRoadMessage <T> {
  XRoadHeader getHeader();

  T getContent();

  void setContent(T content);

  List<XRoadAttachment> getAttachments();
}
