package ee.webmedia.xtee.jaxb;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

/**
 * A {@link DataSource} implementation, that wraps a byte array. The idea is borrowed from Spring-WS.
 * 
 * @author Dmitri Danilkin
 */
public class ByteArrayDataSource implements DataSource {
  private byte[] data;
  private String contentType;

  public ByteArrayDataSource(String contentType, byte[] data) {
    this.contentType = contentType;
    this.data = data;
  }

  public InputStream getInputStream() throws IOException {
    return new ByteArrayInputStream(data);
  }

  public OutputStream getOutputStream() throws IOException {
    throw new UnsupportedOperationException();
  }

  public String getContentType() {
    return contentType;
  }

  public String getName() {
    return "ByteArrayDataSource";
  }
}