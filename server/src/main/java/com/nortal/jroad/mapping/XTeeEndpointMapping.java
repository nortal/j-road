/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
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
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.mapping.AbstractEndpointMapping;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.nortal.jroad.annotation.XTeeService;
import com.nortal.jroad.endpoint.AbstractXTeeBaseEndpoint;
import com.nortal.jroad.endpoint.ListMethodsEndpoint;
import com.nortal.jroad.util.SOAPUtil;

/**
 * Finds all X-Tee endpoints and maps incoming requests to them according to query name present in the X-Tee header.
 * 
 * @author Dmitri Danilkin
 */
@Component
public class XTeeEndpointMapping extends AbstractEndpointMapping implements InitializingBean {

  protected static final Logger log = Logger.getLogger(XTeeEndpointMapping.class);

  @Resource(name = "xteeDatabase")
  private String xteeDatabase;
  private Map<String, AbstractXTeeBaseEndpoint> methodMap;

  /** Sets the name of Xtee database */
  public void setXteeDatabase(String xteeDatabase) {
    this.xteeDatabase = xteeDatabase;
  }

  // Lazy initialization
  public void afterPropertiesSet() throws Exception {
    log.debug("Initializing method map...");
    methodMap = new HashMap<String, AbstractXTeeBaseEndpoint>();
    String[] beans = getApplicationContext().getBeanNamesForType(AbstractXTeeBaseEndpoint.class);
    for (int i = 0; i < beans.length; i++) {
      AbstractXTeeBaseEndpoint endpoint = (AbstractXTeeBaseEndpoint) getApplicationContext().getBean(beans[i]);
      String meetod = getXTeeMethodName(endpoint.getClass(), xteeDatabase);
      if (methodMap.get(meetod) != null) {
        throw new IllegalStateException("Unresolvable: endpoints " + endpoint.getClass().getSimpleName() + " and "
            + methodMap.get(meetod).getClass().getSimpleName() + " have the same X-Tee method identifier '" + meetod
            + "'!");
      }
      if (!(endpoint instanceof ListMethodsEndpoint)) {
        methodMap.put(meetod, endpoint);
      }
      if (log.isDebugEnabled()) {
        log.debug("Mapping X-Tee method '" + meetod + "' to " + endpoint.getClass().getSimpleName());
      }
    }
    log.debug("Method mappings initialized.");
  }

  @Override
  protected Object getEndpointInternal(MessageContext messageCtx) throws Exception {
    SOAPMessage message = SOAPUtil.extractSoapMessage(messageCtx.getRequest());
    if (message.getSOAPHeader() != null) {
      NodeList nl = message.getSOAPHeader().getElementsByTagNameNS("http://x-tee.riik.ee/xsd/xtee.xsd", "nimi");
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
        return getApplicationContext().getBean(getApplicationContext().getBeanNamesForType(ListMethodsEndpoint.class)[0]);
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
   * Attempts to get the full X-Tee method name for the given {@link AbstractXTeeBaseEndpoint}, by processing the
   * {@link XTeeService} annotation -- if this is not present the method name will be a concatenation of X-Tee database
   * name, unqualified class name of given {@link AbstractXTeeBaseEndpoint} (as service name) and "v1" (as version
   * number).
   * 
   * @param clazz X-Tee service endpoint implementation class
   * @param databaseName name of the X-Tee database("andmekogu")
   * @return the X-Tee method name that was constructed according to aforementioned rules
   */
  private String getXTeeMethodName(Class<? extends AbstractXTeeBaseEndpoint> clazz, String databaseName) {
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
