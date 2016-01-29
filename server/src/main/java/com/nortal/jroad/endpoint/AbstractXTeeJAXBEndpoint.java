/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.endpoint;

import com.nortal.jroad.enums.XRoadProtocolVersion;
import com.nortal.jroad.model.BeanXTeeMessage;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.util.AttachmentUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * X-Tee endpoint that provides request/response manipulation using Java objects via JAXB API. All extension classes
 * must implement the method method {@link AbstractXTeeJAXBEndpoint#invokeBean(T requestBean)}.
 * 
 * @author Dmitri Danilkin
 */
public abstract class AbstractXTeeJAXBEndpoint<T> extends AbstractXTeeBaseEndpoint {
  @Resource(name = "contextPath")
  private String contextPath;
  private ClassLoader jaxbClassLoader;

  /**
   * Sets the JAXB context package path.
   * 
   * @param pPath A colon separated path of package names where to look for "jaxb.properties" files. The package names
   *          must match the generated classes which you are going to be used in the application.
   */
  public void setContextPath(String pPath) {
    this.contextPath = pPath;
  }

  public ClassLoader getJaxbClassLoader() {
    return jaxbClassLoader;
  }

  /** Sets the classloader used by <code>JAXBContext</code>. Usually this is safe left unspecified. */
  public void setJaxbClassLoader(ClassLoader jaxbClassLoader) {
    this.jaxbClassLoader = jaxbClassLoader;
  }

  private Class<T> paringKehaClass;

  public void setParingKehaClass(Class<T> paringKehaClass) {
    this.paringKehaClass = paringKehaClass;
  }

  protected Class<T> getParingKehaClass() {
    return paringKehaClass;
  }

  @Override
  @SuppressWarnings("unchecked")
  protected void invokeInternal(XTeeMessage<Document> request, XTeeMessage<Element> response) throws Exception {
    if (getParingKehaClass() == null) {
      throw new IllegalStateException("Query body class ('paringKehaClass') is unset/unspecified!");
    }

    JAXBContext requestJc = newJAXBContextInstance();
    Unmarshaller requestUnmarshaller = requestJc.createUnmarshaller();
    requestUnmarshaller.setAttachmentUnmarshaller(new XteeAttachmentUnmarshaller(request));

    Document requestOnly = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    Node singleNode;
    if (XRoadProtocolVersion.V2_0 == version) {
      singleNode =
          (Node) XPathFactory.newInstance().newXPath().evaluate("//*[local-name()='keha']",
                                                                request.getContent(),
                                                                XPathConstants.NODE);
    } else {
      singleNode = request.getContent();
    }
    requestOnly.appendChild(requestOnly.importNode(singleNode, true));

    XTeeMessage<T> jaxbRequestMessage =
        new BeanXTeeMessage<T>(request.getHeader(),
                               requestUnmarshaller.unmarshal(requestOnly.getDocumentElement(), getParingKehaClass()).getValue(),
                               request.getAttachments());
    XTeeMessage<Object> jaxbResponseMessage =
        new BeanXTeeMessage<Object>(response.getHeader(), null, new ArrayList<XTeeAttachment>());

    invoke(jaxbRequestMessage, jaxbResponseMessage);
    Object bean = jaxbResponseMessage.getContent();
    if (bean != null) { // If you do not need to send an object as response, <keha /> is sufficient.
      Node parent = response.getContent().getParentNode();
      parent.removeChild(response.getContent());
      JAXBContext responseJc = newJAXBContextInstance();
      Marshaller responseMarshaller = responseJc.createMarshaller();
      responseMarshaller.setAttachmentMarshaller(new XteeAttachmentMarshaller(response));
      if (XRoadProtocolVersion.V2_0 == version) {
        responseMarshaller.marshal(new JAXBElement(new QName("keha"), bean.getClass(), bean), parent);
      } else {
        responseMarshaller.marshal(bean, parent);
      }
    }
  }

  private JAXBContext newJAXBContextInstance() throws JAXBException {
    return jaxbClassLoader == null ? JAXBContext.newInstance(contextPath) : JAXBContext.newInstance(contextPath,
                                                                                                    jaxbClassLoader);
  }

  private static class XteeAttachmentUnmarshaller extends AttachmentUnmarshaller {
    private final Map<String, XTeeAttachment> cidMap = new HashMap<String, XTeeAttachment>();

    XteeAttachmentUnmarshaller(XTeeMessage<?> message) {
      for (XTeeAttachment attachment : message.getAttachments()) {
        cidMap.put(attachment.getCid(), attachment);
      }
    }

    private XTeeAttachment getAttachment(String contentId) {
      if (contentId.startsWith("cid:")) {
        contentId = contentId.substring("cid:".length());
        try {
          contentId = URLDecoder.decode(contentId, "UTF-8");
        } catch (UnsupportedEncodingException e) {
          // ignore, because data was probably not UTF-8
        }
        contentId = '<' + contentId + '>';
      }
      return cidMap.get(contentId);
    }

    @Override
    public byte[] getAttachmentAsByteArray(String contentId) {
      try {
        return getAttachment(contentId).getData();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public DataHandler getAttachmentAsDataHandler(String cid) {
      XTeeAttachment attachment = getAttachment(cid);
      return attachment.getDataHandler();
    }

    // Currently MTOM will be disabled
    @Override
    public boolean isXOPPackage() {
      return false;
    }

  }

  private static class XteeAttachmentMarshaller extends AttachmentMarshaller {
    private final List<XTeeAttachment> attachments;
    private long salt = 0;

    public XteeAttachmentMarshaller(XTeeMessage<?> message) {
      this.attachments = message.getAttachments();
    }

    @Override
    public String addMtomAttachment(byte[] arg0, int arg1, int arg2, String arg3, String arg4, String arg5) {
      throw new UnsupportedOperationException("MTOM Support is disabled!");
    }

    @Override
    public String addMtomAttachment(DataHandler arg0, String arg1, String arg2) {
      throw new UnsupportedOperationException("MTOM Support is disabled!");
    }

    @Override
    public String addSwaRefAttachment(DataHandler handler) {
      salt++;
      String contentId = AttachmentUtil.getUniqueCid();
      attachments.add(new XTeeAttachment(contentId, handler));
      return "cid:" + contentId;
    }

    // Currently MTOM will be disabled
    @Override
    public boolean isXOPPackage() {
      return false;
    }

  }

  protected void invoke(XTeeMessage<T> request, XTeeMessage<Object> response) throws Exception {
    response.setContent(invokeBean(request.getContent()));
  }

  protected Object invokeBean(T requestBean) throws IOException {
    throw new IllegalStateException("You must override either the 'invokeBean' or the 'invoke' method!");
  }
}
