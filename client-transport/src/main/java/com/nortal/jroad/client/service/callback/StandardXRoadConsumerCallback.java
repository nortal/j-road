package com.nortal.jroad.client.service.callback;

import static com.nortal.jroad.client.service.consumer.StandardXRoadConsumer.ROOT_NS;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.springframework.oxm.Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;
import com.nortal.jroad.model.XmlBeansXTeeMetadata;

/**
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class StandardXRoadConsumerCallback implements WebServiceMessageCallback {

  private final Object object;
  private final XRoadMessageCallback callback;
  private final Marshaller marshaller;
  private final XmlBeansXTeeMetadata metadata;
  private final boolean setEncodingStyle;

  public StandardXRoadConsumerCallback(Object object,
                                       XRoadMessageCallback callback,
                                       Marshaller marshaller,
                                       XmlBeansXTeeMetadata metadata,
                                       boolean setEncodingStyle) {
    this.object = object;
    this.callback = callback;
    this.marshaller = marshaller;
    this.metadata = metadata;
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

      if (serviceConfiguration.getForceDatabaseNamespace()) {
        mes.getSOAPPart().getEnvelope().addNamespaceDeclaration(ROOT_NS, metadata.getRequestElementNs());
        rootElement = factory.createElement(metadata.getRequestElementName(), ROOT_NS, metadata.getRequestElementNs());
        XmlCursor c = ((XmlObject) object).newCursor();
        c.toNextToken();
        while (c.hasNextToken()) {
          if ((c.isStart() || c.isAttr() || c.isNamespace())
              && metadata.getOperationNs().equals(c.getName().getNamespaceURI())) {
            c.setName(new QName(metadata.getRequestElementNs(), c.getName().getLocalPart()));
          }
          c.toNextToken();
        }
        c.dispose();
      } else {
        mes.getSOAPPart().getEnvelope().addNamespaceDeclaration(ROOT_NS, metadata.getRequestElementNs());
        rootElement = factory.createElement(metadata.getRequestElementName(), ROOT_NS, metadata.getRequestElementNs());
      }

      if (setEncodingStyle) {
        rootElement.setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");
      }

      marshaller.marshal(object, new DOMResult(rootElement));
      body.addChildElement(rootElement);
    } catch (SOAPException e) {
      throw new RuntimeException("Invalid SOAP message");
    }
    callback.doWithMessage(request);
  }

}