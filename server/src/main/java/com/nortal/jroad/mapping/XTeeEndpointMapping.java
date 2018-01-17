/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.mapping;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.mapping.AbstractEndpointMapping;
import org.w3c.dom.Element;

import com.nortal.jroad.annotation.XTeeService;
import com.nortal.jroad.endpoint.AbstractXTeeBaseEndpoint;
import com.nortal.jroad.endpoint.ListMethodsEndpoint;
import com.nortal.jroad.enums.XRoadProtocolVersion;
import com.nortal.jroad.util.SOAPUtil;
import com.nortal.jroad.wsdl.XTeeWsdlDefinition;

/**
 * Finds all X-Road endpoints and maps incoming requests to them according to query name present in the X-Road header.
 * 
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
@Component
public class XTeeEndpointMapping extends AbstractEndpointMapping implements InitializingBean {
  protected static final Logger log = Logger.getLogger(XTeeEndpointMapping.class);

  @Resource(name = "xteeDatabase")
  private String xRoadDatabase;
  private Map<String, AbstractXTeeBaseEndpoint> methodMap;

  public void setXteeDatabase(String xRoadDatabase) {
    this.xRoadDatabase = xRoadDatabase;
  }

  // Lazy initialization
  public void afterPropertiesSet() throws Exception {
    log.debug("Initializing method map...");
    methodMap = new HashMap<String, AbstractXTeeBaseEndpoint>();
    String[] beans = getApplicationContext().getBeanNamesForType(AbstractXTeeBaseEndpoint.class);
    for (int i = 0; i < beans.length; i++) {
      AbstractXTeeBaseEndpoint endpoint = (AbstractXTeeBaseEndpoint) getApplicationContext().getBean(beans[i]);
      String meetod = getXRoadMethodName(endpoint.getClass(), xRoadDatabase);
      if (methodMap.get(meetod) != null) {
        throw new IllegalStateException("Unresolvable: endpoints " + endpoint.getClass().getSimpleName() + " and "
            + methodMap.get(meetod).getClass().getSimpleName() + " have the same XRoad method identifier '" + meetod
            + "'!");
      }
      if (!(endpoint instanceof ListMethodsEndpoint)) {
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
      AbstractXTeeBaseEndpoint endpoint = methodMap.get(getRequestMethod(message.getSOAPHeader()));
      if (endpoint != null) {
        if (log.isDebugEnabled()) {
          log.debug("Matched " + endpoint + " to " + endpoint.getClass().getSimpleName());
        }
        return endpoint;
      }
    }

    try {
      if (SOAPUtil.getNodeByXPath(message.getSOAPBody(), "/*/*/*[local-name()='listMethods']") != null) {
        log.debug("Matched headerless listMethods request.");
        return getApplicationContext().getBean(getApplicationContext().getBeanNamesForType(ListMethodsEndpoint.class)[0]);
      }
    } catch (NullPointerException e) {
      // ListMethods lookup failed
    }
    return null;
  }

  protected String getRequestMethod(SOAPHeader header) {
    if (header == null) {
      return null;
    }
    // Try to extract v2 protocol headers
    Element nimi = SOAPUtil.getNsElement(header, "nimi", XRoadProtocolVersion.V2_0.getNamespaceUri());
    if (nimi != null) {
      return SOAPUtil.getTextContent(nimi);
    }

    // Try to extract v4 protocol headers
    Element service = SOAPUtil.getNsElement(header, "service", XTeeWsdlDefinition.XROAD_NAMESPACE);
    if (service == null) {
      return null;
    }
    String serviceCode = SOAPUtil.getNsElementValue(service, "serviceCode", XTeeWsdlDefinition.XROAD_IDEN_NAMESPACE);
    String serviceVersion =
        SOAPUtil.getNsElementValue(service, "serviceVersion", XTeeWsdlDefinition.XROAD_IDEN_NAMESPACE);

    StringBuilder method = new StringBuilder();
    method.append(xRoadDatabase).append(".");
    method.append(serviceCode).append(".");
    method.append(serviceVersion != null ? serviceVersion : "v1");
    return method.toString();
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
   * name, unqualified class name of given {@link AbstractXTeeBaseEndpoint} (as service name) and "v1" (as version
   * number).
   * 
   * @param clazz XRoad service endpoint implementation class
   * @param databaseName name of the XRoad database
   * @return the XRoadService method name that was constructed according to aforementioned rules
   */
  private String getXRoadMethodName(Class<? extends AbstractXTeeBaseEndpoint> clazz, String databaseName) {
    String version = "v1";
    String serviceName = null;
    if (clazz.isAnnotationPresent(XTeeService.class)) {
      XTeeService serviceAnnotation = clazz.getAnnotation(XTeeService.class);
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
