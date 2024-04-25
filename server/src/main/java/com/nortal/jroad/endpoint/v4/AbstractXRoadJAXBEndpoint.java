package com.nortal.jroad.endpoint.v4;

import com.nortal.jroad.model.v4.BeanXRoadMessage;
import com.nortal.jroad.model.v4.XRoadAttachment;
import com.nortal.jroad.model.v4.XRoadMessage;
import com.nortal.jroad.util.AttachmentUtil;
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
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.attachment.AttachmentMarshaller;
import jakarta.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public abstract class AbstractXRoadJAXBEndpoint<T> extends AbstractXRoadBaseEndpoint {

  private Class<T> requestClass;

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

  private static final HashMap<JaxbContextKey, JAXBContext> jaxbContexts = new HashMap<>();

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

  @Override
  protected void invokeInternal(final XRoadMessage<Document> request, final XRoadMessage<Element> response)
      throws Exception {
    if (getRequestClass() == null) {
      throw new IllegalStateException("Query body class ('requestClass') is unset/unspecified!");
    }

    JAXBContext requestJc = getJAXBContextInstance();
    Unmarshaller requestUnmarshaller = requestJc.createUnmarshaller();
    requestUnmarshaller.setAttachmentUnmarshaller(new XRoadAttachmentUnmarshaller(request));

    Document requestOnly = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    Node singleNode = request.getContent();
    requestOnly.appendChild(requestOnly.importNode(singleNode, true));

    XRoadMessage<T> jaxbRequestMessage =
        new BeanXRoadMessage<T>(request.getHeader(),
                                requestUnmarshaller.unmarshal(requestOnly.getDocumentElement(), getRequestClass()).getValue(),
                                request.getAttachments());
    XRoadMessage<Object> jaxbResponseMessage =
        new BeanXRoadMessage<Object>(response.getHeader(), null, new ArrayList<XRoadAttachment>());

    invoke(jaxbRequestMessage, jaxbResponseMessage);
    Object bean = jaxbResponseMessage.getContent();
    if (bean != null) { // If you do not need to send an object as response, <keha /> is sufficient.
      Node parent = response.getContent().getParentNode();
      parent.removeChild(response.getContent());
      JAXBContext responseJc = getJAXBContextInstance();
      Marshaller responseMarshaller = responseJc.createMarshaller();
      responseMarshaller.setAttachmentMarshaller(new XRoadAttachmentMarshaller(response));
      responseMarshaller.marshal(bean, parent);
    }
  }

  private JAXBContext getJAXBContextInstance() throws JAXBException {
    synchronized (AbstractXRoadJAXBEndpoint.jaxbContexts) {
      JaxbContextKey key = new JaxbContextKey(contextPath, jaxbClassLoader);
      JAXBContext ctx = AbstractXRoadJAXBEndpoint.jaxbContexts.get(key);
      if (ctx == null) {
        ctx =
            (jaxbClassLoader == null) ? JAXBContext.newInstance(contextPath) : JAXBContext.newInstance(contextPath,
                                                                                                       jaxbClassLoader);
        AbstractXRoadJAXBEndpoint.jaxbContexts.put(key, ctx);
      }
      return ctx;
    }
  }

  private static class XRoadAttachmentUnmarshaller extends AttachmentUnmarshaller {
    private final Map<String, XRoadAttachment> cidMap = new HashMap<String, XRoadAttachment>();

    XRoadAttachmentUnmarshaller(final XRoadMessage<?> message) {
      for (XRoadAttachment attachment : message.getAttachments()) {
        cidMap.put(attachment.getCid(), attachment);
      }
    }

    private XRoadAttachment getAttachment(String contentId) {
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
      XRoadAttachment attachment = getAttachment(cid);
      return attachment.getDataHandler();
    }

    // Currently MTOM will be disabled
    @Override
    public boolean isXOPPackage() {
      return false;
    }

  }

  private static class XRoadAttachmentMarshaller extends AttachmentMarshaller {
    private final List<XRoadAttachment> attachments;
    private long salt = 0;

    public XRoadAttachmentMarshaller(final XRoadMessage<?> message) {
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
      attachments.add(new XRoadAttachment(contentId, handler));
      return "cid:" + contentId;
    }

    // Currently MTOM will be disabled
    @Override
    public boolean isXOPPackage() {
      return false;
    }

  }

  public void setRequestClass(final Class<T> requestClass) {
    this.requestClass = requestClass;
  }

  protected Class<T> getRequestClass() {
    return requestClass;
  }

  protected void invoke(final XRoadMessage<T> request, final XRoadMessage<Object> response) throws Exception {
    response.setContent(invokeBean(request.getContent()));
  }

  protected Object invokeBean(final T requestBean) throws IOException {
    throw new IllegalStateException("You must override either the 'invokeBean' or the 'invoke' method!");
  }
}
