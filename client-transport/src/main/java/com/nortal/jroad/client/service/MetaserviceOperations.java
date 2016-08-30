package com.nortal.jroad.client.service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.callback.MessageCallbackNamespaceStrategy;
import com.nortal.jroad.client.service.callback.StandardXTeeConsumerCallback;
import com.nortal.jroad.client.util.ServiceVersion;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.springframework.ws.WebServiceMessage;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public class MetaserviceOperations {

  private final XroadDatabaseClient xRoadDatabaseService;

  public MetaserviceOperations(XroadDatabaseClient xRoadDatabaseService) {
    this.xRoadDatabaseService = xRoadDatabaseService;
  }

  public Integer getState() throws XTeeServiceConsumptionException {
    return getState(null);
  }

  public Integer getState(final MessageCallbackNamespaceStrategy namespaceStrategy) throws XTeeServiceConsumptionException {
    String operationName = "getState";
    XmlObject reqContent;
    try {
      reqContent = XmlObject.Factory.parse("<m:getState xmlns:m=\"http://x-road.ee/xsd/x-road.xsd\" />");
    } catch (XmlException e) {
      throw new IllegalArgumentException("Error creating request content", e);
    }

    XTeeMessage input = new XmlBeansXTeeMessage<XmlObject>(reqContent);
    XTeeMessage responseMessage;

    if (namespaceStrategy != null) {
      responseMessage =
          xRoadDatabaseService.send(input, operationName, ServiceVersion._METASERVICE, new CustomCallback() {
            @Override
            public void doWithMessage(WebServiceMessage webServiceMessage)
                throws IOException, TransformerException {
              callback.doWithMessage(webServiceMessage);
            }

            @Override
            public void modifyConsumerCallback(StandardXTeeConsumerCallback originalCallback) {
              originalCallback.getCallback().setNamespaceStrategy(namespaceStrategy);
            }
          }, null);
    } else {
      responseMessage = xRoadDatabaseService.send(input, operationName, ServiceVersion._METASERVICE);
    }

    XmlObject respContent = (XmlObject) responseMessage.getContent();
    return readStateResponseCode(respContent);
  }

  private Integer readStateResponseCode(XmlObject respContent) {
    XmlObject getStateResponseElement = findChildByLocalName(respContent, "getStateResponse");
    if (getStateResponseElement == null) {
      return null;
    }
    XmlObject responseElement = findChildByLocalName(getStateResponseElement, "response");
    if (responseElement == null) {
      return null;
    }
    if (responseElement instanceof XmlAnyTypeImpl) {
      String s =((XmlAnyTypeImpl) responseElement).getStringValue();
        try {
          return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
          // skip
        }
    }
    return null;
  }

  private XmlObject findChildByLocalName(XmlObject element, String localname) {
    for (XmlObject child : element.selectChildren(QNameSet.ALL)) {
      if (localname.equals(child.getDomNode().getLocalName())) {
        return child;
      }
    }
    return null;
  }

}
