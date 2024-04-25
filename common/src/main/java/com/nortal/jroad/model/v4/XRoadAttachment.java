package com.nortal.jroad.model.v4;

import com.nortal.jroad.jaxb.ByteArrayDataSource;
import java.io.IOException;
import java.io.InputStream;
import jakarta.activation.DataHandler;
import org.springframework.core.io.InputStreamSource;
import org.springframework.util.FileCopyUtils;

/**
 * XRoad messages are sometimes allowed to contain MIME attachments, which this class encapsulates. Each attachment has
 * MIME content-type, data (content) and unique ID. This class implements {@link InputStreamSource} for a nice fit into
 * Spring-WS and provides easy access to attachment content. Attachments are the preferred way of transporting large
 * amounts of data because transmitting attachments requires much less bandwidth and resources (base64 etc) than
 * transmitting the same data within SOAP messages without attachments.
 *
 * @author Dmitri Danilkin
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class XRoadAttachment implements InputStreamSource {
  private String cid;
  private DataHandler dataHandler;

  public XRoadAttachment(String cid, String contentType, byte[] data) {
    this.cid = cid;
    this.dataHandler = new DataHandler(new ByteArrayDataSource(contentType, data));
  }

  public XRoadAttachment(String cid, DataHandler dataHandler) {
    this.cid = cid;
    this.dataHandler = dataHandler;
  }

  public InputStream getInputStream() throws IOException {
    return dataHandler.getInputStream();
  }

  @Override
  public String toString() {
    return "cid:" + cid;
  }

  public String getCid() {
    return cid;
  }

  public byte[] getData() throws IOException {
    return FileCopyUtils.copyToByteArray(dataHandler.getInputStream());
  }

  public String getContentType() {
    return dataHandler.getContentType();
  }

  public DataHandler getDataHandler() {
    return dataHandler;
  }

}
