/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.endpoint;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.activation.DataHandler;
import jakarta.annotation.Resource;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.attachment.AttachmentMarshaller;
import jakarta.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.nortal.jroad.enums.XRoadProtocolVersion;
import com.nortal.jroad.model.BeanXTeeMessage;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.util.AttachmentUtil;
import com.nortal.jroad.util.SOAPUtil;

/**
 * X-Tee endpoint that provides request/response manipulation using Java objects via JAXB API. All extension classes
 * must implement the method method {@link AbstractXTeeJAXBEndpoint#invokeBean(T requestBean)}.
 *
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public abstract class AbstractXTeeJAXBEndpoint<T> extends AbstractXTeeBaseEndpoint {
  private static final class JaxbContextKey {
    private final String contextPath;
    private final ClassLoader classLoader;

    public JaxbContextKey(final String contextPath, final ClassLoader classLoader) {
      this.contextPath = contextPath;
      this.classLoader = classLoader;
    }

    @Override
    public boolean equals(final Object other) {
      if (this == other) {
        return true;
      }
      if (other == null || !getClass().equals(other.getClass())) {
        return false;
      }
      JaxbContextKey otherKey = (JaxbContextKey) other;
      return ((contextPath == null) ? (otherKey.contextPath == null) : (contextPath.equals(otherKey.contextPath)))
          && ((classLoader == null) ? (otherKey.classLoader == null) : (classLoader.equals(otherKey.classLoader)));
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((classLoader == null) ? 0 : classLoader.hashCode());
      result = prime * result + ((contextPath == null) ? 0 : contextPath.hashCode());
      return result;
    }
  }

  private static final HashMap<JaxbContextKey, JAXBContext> jaxbContexts = new HashMap<JaxbContextKey, JAXBContext>();

  @Resource(name = "contextPath")
  private String contextPath;
  private ClassLoader jaxbClassLoader;

  /**
   * Sets the JAXB context package path.
   *
   * @param pPath A colon separated path of package names where to look for "jaxb.properties" files. The package names
   *          must match the generated classes which you are going to be used in the application.
   */
  public void setContextPath(final String pPath) {
    this.contextPath = pPath;
  }

  public ClassLoader getJaxbClassLoader() {
    return jaxbClassLoader;
  }

  /** Sets the classloader used by <code>JAXBContext</code>. Usually this is safe left unspecified. */
  public void setJaxbClassLoader(final ClassLoader jaxbClassLoader) {
    this.jaxbClassLoader = jaxbClassLoader;
  }

  private Class<T> paringKehaClass;

  public void setParingKehaClass(final Class<T> paringKehaClass) {
    this.paringKehaClass = paringKehaClass;
  }

  protected Class<T> getParingKehaClass() {
    return paringKehaClass;
  }

  @Override
  @SuppressWarnings({ "unchecked", "rawtypes" })
  protected void invokeInternal(final XTeeMessage<Document> request, final XTeeMessage<Element> response)
      throws Exception {
    if (getParingKehaClass() == null) {
      throw new IllegalStateException("Query body class ('requestClass') is unset/unspecified!");
    }

    JAXBContext requestJc = getJAXBContextInstance();
    Unmarshaller requestUnmarshaller = requestJc.createUnmarshaller();
    requestUnmarshaller.setAttachmentUnmarshaller(new XTeeAttachmentUnmarshaller(request));

    Document requestOnly = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    if (XRoadProtocolVersion.V2_0 == version) {
      requestOnly.appendChild(requestOnly.importNode((Node) XPathFactory.newInstance().newXPath().evaluate("//*[local-name()='keha']",
                                                                                                           request.getContent(),
                                                                                                           XPathConstants.NODE),
                                                     true));
    } else {
      requestOnly.appendChild(requestOnly.importNode(SOAPUtil.getFirstNonTextChild(request.getContent()), true));
    }

    XTeeMessage<T> jaxbRequestMessage = new BeanXTeeMessage<T>(request.getHeader(),
                                                               requestUnmarshaller.unmarshal(requestOnly.getDocumentElement(),
                                                                                             getParingKehaClass()).getValue(),
                                                               request.getAttachments());
    XTeeMessage<Object> jaxbResponseMessage =
        new BeanXTeeMessage<Object>(response.getHeader(), null, new ArrayList<XTeeAttachment>());

    invoke(jaxbRequestMessage, jaxbResponseMessage);
    Object bean = jaxbResponseMessage.getContent();
    if (bean != null) { // If you do not need to send an object as response, <keha /> is sufficient.
      Node parent = response.getContent().getParentNode();
      Node child = parent.removeChild(response.getContent());
      JAXBContext responseJc = getJAXBContextInstance();
      Marshaller responseMarshaller = responseJc.createMarshaller();
      responseMarshaller.setAttachmentMarshaller(new XTeeAttachmentMarshaller(response));
      // TODO Lauri: some namespace hacking might be needed if existing service schema is changed according to new
      // standard while upgrading. J-road clients do not mind tho :)
      if (XRoadProtocolVersion.V2_0 == version) {
        responseMarshaller.marshal(new JAXBElement(new QName("keha"), bean.getClass(), bean), parent);
      } else {
        responseMarshaller.marshal(new JAXBElement(new QName(response.getContent().getNamespaceURI(),
                                                             child.getLocalName(),
                                                             response.getContent().getPrefix()),
                                                   bean.getClass(),
                                                   bean),
                                   parent);
      }
    }
  }

  private JAXBContext getJAXBContextInstance() throws JAXBException {
    synchronized (AbstractXTeeJAXBEndpoint.jaxbContexts) {
      JaxbContextKey key = new JaxbContextKey(contextPath, jaxbClassLoader);
      JAXBContext ctx = AbstractXTeeJAXBEndpoint.jaxbContexts.get(key);
      if (ctx == null) {
        ctx = (jaxbClassLoader == null)
                                        ? JAXBContext.newInstance(contextPath)
                                        : JAXBContext.newInstance(contextPath, jaxbClassLoader);
        AbstractXTeeJAXBEndpoint.jaxbContexts.put(key, ctx);
      }
      return ctx;
    }
  }

  private static class XTeeAttachmentUnmarshaller extends AttachmentUnmarshaller {
    private final Map<String, XTeeAttachment> cidMap = new HashMap<String, XTeeAttachment>();

    XTeeAttachmentUnmarshaller(final XTeeMessage<?> message) {
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
    public byte[] getAttachmentAsByteArray(final String contentId) {
      try {
        return getAttachment(contentId).getData();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public DataHandler getAttachmentAsDataHandler(final String cid) {
      XTeeAttachment attachment = getAttachment(cid);
      return attachment.getDataHandler();
    }

    // Currently MTOM will be disabled
    @Override
    public boolean isXOPPackage() {
      return false;
    }

  }

  private static class XTeeAttachmentMarshaller extends AttachmentMarshaller {
    private final List<XTeeAttachment> attachments;
    private long salt = 0;

    public XTeeAttachmentMarshaller(final XTeeMessage<?> message) {
      this.attachments = message.getAttachments();
    }

    @Override
    public String addMtomAttachment(final byte[] arg0,
                                    final int arg1,
                                    final int arg2,
                                    final String arg3,
                                    final String arg4,
                                    final String arg5) {
      throw new UnsupportedOperationException("MTOM Support is disabled!");
    }

    @Override
    public String addMtomAttachment(final DataHandler arg0, final String arg1, final String arg2) {
      throw new UnsupportedOperationException("MTOM Support is disabled!");
    }

    @Override
    public String addSwaRefAttachment(final DataHandler handler) {
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

  protected void invoke(final XTeeMessage<T> request, final XTeeMessage<Object> response) throws Exception {
    response.setContent(invokeBean(request.getContent()));
  }

  protected Object invokeBean(final T requestBean) throws IOException {
    throw new IllegalStateException("You must override either the 'invokeBean' or the 'invoke' method!");
  }
}
