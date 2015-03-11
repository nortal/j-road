package com.nortal.jroad.client.rets;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.nortal.jroad.client.rets.RetsXTeeServiceImpl;
import com.nortal.jroad.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.VeadType;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Tanel Käär (tanelk@nortal.com)
 */
public class RetsXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private RetsXTeeServiceImpl retsXTeeServiceImpl;

  @Test
  public void testSendHl7Document() throws IOException {
    String message = getFileFromClasspath("PORX_IN010380UV_soodustuse_kysimine.xml");
    List<VeadType> veadOut = new ArrayList<VeadType>();
    String response = retsXTeeServiceImpl.sendHl7Document(message, "10101010101", veadOut);
    Assert.assertNotNull(response);
    Assert.assertFalse(veadOut.isEmpty());
  }

  private String getFileFromClasspath(String filePath) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
    if (is == null) {
      throw new FileNotFoundException("Resource not found in classpath: " + filePath);
    }
    byte[] buf = new byte[1024];
    int numRead = 0;
    while ((numRead = is.read(buf)) != -1) {
      out.write(buf, 0, numRead);
    }
    is.close();
    return out.toString("UTF-8");
  }
}
