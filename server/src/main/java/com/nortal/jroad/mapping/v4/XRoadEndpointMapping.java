package com.nortal.jroad.mapping.v4;

import com.nortal.jroad.annotation.XRoadService;
import com.nortal.jroad.endpoint.AbstractXTeeBaseEndpoint;
import com.nortal.jroad.endpoint.v4.AbstractXRoadBaseEndpoint;
import com.nortal.jroad.endpoint.v4.XroadListMethodsEndpoint;
import com.nortal.jroad.util.SOAPUtil;
import com.nortal.jroad.wsdl.v4.XRoadWsdlDefinition;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.mapping.AbstractEndpointMapping;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jakarta.annotation.Resource;
import jakarta.xml.soap.SOAPMessage;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Finds all XRoad endpoints and maps incoming requests to them according to query name present in the XRoad header.
 * 
 * @author Dmitri Danilkin
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
@Component
public class XRoadEndpointMapping extends AbstractEndpointMapping implements InitializingBean {

  protected static final Logger log = Logger.getLogger(XRoadEndpointMapping.class);

  @Resource(name = "database")
  private String database;
  private Map<String, AbstractXTeeBaseEndpoint> methodMap;

  public void setDatabase(String database) {
    this.database = database;
  }

  // Lazy initialization
  public void afterPropertiesSet() throws Exception {
    log.debug("Initializing method map...");
    methodMap = new HashMap<String, AbstractXTeeBaseEndpoint>();
    String[] beans = getApplicationContext().getBeanNamesForType(AbstractXTeeBaseEndpoint.class);
    for (int i = 0; i < beans.length; i++) {
      AbstractXTeeBaseEndpoint endpoint = (AbstractXTeeBaseEndpoint) getApplicationContext().getBean(beans[i]);
      String meetod = getXRoadMethodName(endpoint.getClass(), database);
      if (methodMap.get(meetod) != null) {
        throw new IllegalStateException("Unresolvable: endpoints " + endpoint.getClass().getSimpleName() + " and "
            + methodMap.get(meetod).getClass().getSimpleName() + " have the same XRoad method identifier '" + meetod
            + "'!");
      }
      if (!(endpoint instanceof XroadListMethodsEndpoint)) {
        methodMap.put(meetod, endpoint);
      }
      if (log.isDebugEnabled()) {
        log.debug("Mapping XRoad method '" + meetod + "' to " + endpoint.getClass().getSimpleName());
      }
    }
    log.debug("Method mappings initialized.");
  }

  @Override
  protected Object getEndpointInternal(MessageContext messageCtx) throws Exception {
    SOAPMessage message = SOAPUtil.extractSoapMessage(messageCtx.getRequest());
    if (message.getSOAPHeader() != null) {
      NodeList nl = message.getSOAPHeader().getElementsByTagNameNS(XRoadWsdlDefinition.XROAD_NAMESPACE, "userId");
      for (int i = 0; i < nl.getLength(); i++) {
        Node node = nl.item(i);
        Object endpoint = methodMap.get(node.getFirstChild().getNodeValue());
        if (endpoint != null) {
          if (log.isDebugEnabled()) {
            log.debug("Matched " + node.getFirstChild().getNodeValue() + " to " + endpoint.getClass().getSimpleName());
          }
          return endpoint;
        }
      }
    }

    try {
      if (SOAPUtil.getNodeByXPath(message.getSOAPBody(), "/*/*/*[local-name()='listMethods']") != null) {
        log.debug("Matched headerless listMethods request.");
        return getApplicationContext().getBean(getApplicationContext().getBeanNamesForType(XroadListMethodsEndpoint.class)[0]);
      }
    } catch (NullPointerException e) {
      // ListMethods lookup failed
    }

    return null;
  }

  /**
   * Receives the string and returns it with first character set to lowercase and suffix "Endpoint" removed.
   * 
   * @param className unqualified class name
   * @return input string <code>className</code> with first character in lowercase and "Endpoint" suffix removed
   */
  private String getServiceName(String className) {
    String result;
    if (className.endsWith("Endpoint")) {
      result = className.substring(0, className.length() - 8);
    } else {
      result = className;
    }
    return result;
  }

  /**
   * Attempts to get the full XRoad method name for the given {@link AbstractXTeeBaseEndpoint}, by processing the
   * {@link XRoadService} annotation -- if this is not present the method name will be a concatenation of X-Tee database
   * name, unqualified class name of given {@link AbstractXRoadBaseEndpoint} (as service name) and "v1" (as version
   * number).
   * 
   * @param clazz XRoad service endpoint implementation class
   * @param databaseName name of the XRoad database
   * @return the XRoadService method name that was constructed according to aforementioned rules
   */
  private String getXRoadMethodName(Class<? extends AbstractXTeeBaseEndpoint> clazz, String databaseName) {
    String version = "v1";
    String serviceName = null;
    if (clazz.isAnnotationPresent(XRoadService.class)) {
      XRoadService serviceAnnotation = clazz.getAnnotation(XRoadService.class);
      version = serviceAnnotation.version();
      if (!serviceAnnotation.name().equals("") || !serviceAnnotation.value().equals("")) {
        serviceName = serviceAnnotation.name().equals("") ? serviceAnnotation.value() : serviceAnnotation.name();
      }

    }
    if (serviceName == null) {
      serviceName = getServiceName(clazz.getSimpleName());
    }

    StringBuilder sb = new StringBuilder(databaseName).append(".").append(serviceName).append(".").append(version);
    return sb.toString();
  }

  public Collection<String> getMethods() {
    return methodMap.keySet();
  }

  public Map<String, AbstractXTeeBaseEndpoint> getMethodMap() {
    return Collections.unmodifiableMap(methodMap);
  }
}
