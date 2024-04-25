package com.nortal.jroad.client.service.callback;

import static com.nortal.jroad.client.service.consumer.v2.StandardXTeeConsumer.ROOT_NS;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;

import java.io.IOException;
import javax.xml.namespace.QName;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPFactory;
import jakarta.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.springframework.oxm.Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import com.nortal.jroad.model.XmlBeansXTeeMetadata;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Dmitri Danilkin
 */
public class StandardXTeeConsumerCallback implements WebServiceMessageCallback {

  private final Object object;
  private final XTeeMessageCallback callback;
  private final Marshaller marshaller;
  private final XmlBeansXTeeMetadata metadata;
  private final String namespace;
  private final boolean setEncodingStyle;

  public StandardXTeeConsumerCallback(Object object,
                                      XTeeMessageCallback callback,
                                      Marshaller marshaller,
                                      XmlBeansXTeeMetadata metadata,
                                      String namespace,
                                      boolean setEncodingStyle) {
    this.object = object;
    this.callback = callback;
    this.marshaller = marshaller;
    this.metadata = metadata;
    this.namespace = namespace;
    this.setEncodingStyle = setEncodingStyle;
  }

  public void doWithMessage(WebServiceMessage request) throws IOException, TransformerException {
    SaajSoapMessage message = (SaajSoapMessage) request;
    SOAPMessage mes = message.getSaajMessage();

    try {
      SOAPBody body = mes.getSOAPBody();
      SOAPFactory factory = SOAPFactory.newInstance();
      SOAPElement rootElement;

      BaseXRoadServiceConfiguration serviceConfiguration = callback.getServiceConfiguration();

      if (serviceConfiguration.getForceDatabaseNamespace() && !metadata.getOperationNs().equals(namespace)) {
        mes.getSOAPPart().getEnvelope().addNamespaceDeclaration(ROOT_NS, namespace);
        rootElement = factory.createElement(metadata.getOperationName(), ROOT_NS, namespace);
        XmlCursor c = ((XmlObject) object).newCursor();
        c.toNextToken();
        while (c.hasNextToken()) {
          if ((c.isStart() || c.isAttr() || c.isNamespace())
              && metadata.getOperationNs().equals(c.getName().getNamespaceURI())) {
            c.setName(new QName(namespace, c.getName().getLocalPart()));
          }
          c.toNextToken();
        }
        c.dispose();
      } else {
        mes.getSOAPPart().getEnvelope().addNamespaceDeclaration(ROOT_NS, metadata.getOperationNs());
        rootElement = factory.createElement(metadata.getOperationName(), ROOT_NS, metadata.getOperationNs());
      }

      if (setEncodingStyle) {
        rootElement.setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");
      }

      marshaller.marshal(object, new DOMResult(rootElement));

      if (rootElement.getFirstChild() != null && ("xml-fragment".equals(rootElement.getFirstChild().getLocalName())
          || metadata.getOperationName().equals(rootElement.getFirstChild().getLocalName()))) {
        NodeList childNodes = rootElement.getFirstChild().getChildNodes();
        rootElement.removeContents();

        while (childNodes.getLength() > 0) {
          Node child = childNodes.item(0);
          if (child != null) {
            rootElement.appendChild(child);
          }
        }
      }

      body.addChildElement(rootElement);
    } catch (SOAPException e) {
      throw new RuntimeException("Invalid SOAP message");
    }
    callback.doWithMessage(request);
  }

  public XTeeMessageCallback getCallback() {
    return callback;
  }

}
