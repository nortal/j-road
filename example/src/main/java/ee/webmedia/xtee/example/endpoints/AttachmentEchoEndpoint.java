/**
 * Copyright 2009 Webmedia Group Ltd. Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package ee.webmedia.xtee.example.endpoints;

import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import ee.webmedia.xtee.endpoint.AbstractXTeeJAXBEndpoint;
import ee.webmedia.xtee.example.model.AttachmentEchoNest;
import ee.webmedia.xtee.example.model.AttachmentEchoRequest;
import ee.webmedia.xtee.example.model.AttachmentEchoResponse;
import ee.webmedia.xtee.jaxb.ByteArrayDataSource;

/**
 * Sample service endpoint, which supports binary attachments. Please refer to the PDF documentation on how to create
 * valid Schema (xsd) files. These attachments are sent as binary and are never converted to Base64. If you need Base64
 * conversion for legacy purposes, then you have to implement it yourself. This is not fully compliant with the X-tee
 * specification, but encoding large files to Base64 is a huge waste of resources. If you want to use Base64 encoding,
 * you can always send your attachments inline, since MTOM is disabled. It is however heavily detrimental to
 * performance.
 * 
 * @author Dmitri Danilkin
 */
@Component
public class AttachmentEchoEndpoint extends AbstractXTeeJAXBEndpoint<AttachmentEchoRequest> {
  private static Logger log = Logger.getLogger(AttachmentEchoEndpoint.class);

  @Override
  protected Class<AttachmentEchoRequest> getParingKehaClass() {
    // As incoming object's Element name is "keha", the query class must be
    // shown
    return AttachmentEchoRequest.class;
  }

  @Override
  protected AttachmentEchoResponse invokeBean(AttachmentEchoRequest requestBean) throws IOException {
    // Creation of a response object -- must correspond to
    // response type defined in XML Schema definition.
    AttachmentEchoResponse response = new AttachmentEchoResponse();

    // Create a temporary object to store our data
    byte[] data = null;

    // Logging
    log.info("Received attachment, type: " + requestBean.getNest().getAttachment().getContentType() + ", size: "
        + requestBean.getNest().getAttachment().getInputStream().available());
    // Using a Spring helper class we read an InputStream to a byte array.
    // In real situations you probably want to pass the InputStream around.
    data = FileCopyUtils.copyToByteArray(requestBean.getNest().getAttachment().getInputStream());

    /*
     * JAXB generates DataHandler type setters for attachments, so you need to find a way to get your data into a
     * DataHandler. The easiest way to accomplish this, is to create a DataSource. A DataSource used here only needs to
     * provide an InputStream and a content type. A simple DataSource, which takes a byte array and content-type in
     * string form is included. Usually you would use something like FileDataSource, UrlDataSource or you can easily
     * implement your own. All a DataSource basically does in this context is give an InputStream and a content type for
     * that InputStream. An alternative way is to define a DataContentHandler and pass an object+content type when
     * creating a DataHandler. This way you will have to implement a DataContentHandler and DataContentHandlerFactory,
     * however.
     */
    DataSource ds = new ByteArrayDataSource(requestBean.getNest().getAttachment().getContentType(), data);

    // Now we can easily construct a DataHandler and pass it to JAXB.
    // Converting it to an attachment is handled by the library.
    DataHandler dh = new DataHandler(ds);
    AttachmentEchoNest nest = new AttachmentEchoNest();
    nest.setAttachment(dh);
    response.setNest(nest);

    // Finally, we return the response object.
    return response;
  }
}
