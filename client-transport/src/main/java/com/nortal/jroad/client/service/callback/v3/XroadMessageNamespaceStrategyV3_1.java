package com.nortal.jroad.client.service.callback.v3;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;

public class XroadMessageNamespaceStrategyV3_1 extends XRoadMessageCallbackNamespaceStrategy {

  @Override
  public void addNamespaces(SOAPEnvelope env) throws SOAPException {
    env.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
    env.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
    env.addNamespaceDeclaration("xro", "http://x-road.ee/xsd/x-road.xsd");
  }

}
