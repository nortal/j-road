/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.model;

import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;

import org.springframework.core.io.InputStreamSource;
import org.springframework.util.FileCopyUtils;

import com.nortal.jroad.jaxb.ByteArrayDataSource;

/**
 * XTee messages are sometimes allowed to contain MIME attachments, which this class encapsulates. Each attachment has
 * MIME content-type, data (content) and unique ID. This class implements {@link InputStreamSource} for a nice fit into
 * Spring-WS and provides easy access to attachment content. Attachments are the preferred way of transporting large
 * amounts of data because transmitting attachments requires much less bandwidth and resources (base64 etc) than
 * transmitting the same data within SOAP messages without attachments.
 * 
 * @author Dmitri Danilkin
 */
// Should switch to X-road implementation
@Deprecated
public class XTeeAttachment implements InputStreamSource {
  private String cid;
  private DataHandler dataHandler;

  public XTeeAttachment(String cid, String contentType, byte[] data) {
    this.cid = cid;
    this.dataHandler = new DataHandler(new ByteArrayDataSource(contentType, data));
  }

  public XTeeAttachment(String cid, DataHandler dataHandler) {
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
