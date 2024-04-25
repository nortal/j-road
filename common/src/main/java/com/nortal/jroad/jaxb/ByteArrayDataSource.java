package com.nortal.jroad.jaxb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.activation.DataSource;

/**
 * A {@link DataSource} implementation, that wraps a byte array. The idea is borrowed from Spring-WS.
 *
 * @author Dmitri Danilkin
 */
public class ByteArrayDataSource implements DataSource {
  private final byte[] data;
  private final String contentType;

  public ByteArrayDataSource(String contentType, byte[] data) {
    this.contentType = contentType;
    this.data = data;
  }

  @Override
  public InputStream getInputStream() {
    return new ByteArrayInputStream(data);
  }

  @Override
  public OutputStream getOutputStream() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getContentType() {
    return contentType;
  }

  @Override
  public String getName() {
    return "ByteArrayDataSource";
  }
}
