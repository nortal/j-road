package com.nortal.jroad.client.service.callback;

import static com.nortal.jroad.client.service.consumer.v2.StandardXTeeConsumer.ROOT_NS;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;

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
import com.nortal.jroad.model.XmlBeansXTeeMetadata;

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

      String requestElementName = getRequestElementName(metadata);
      String requestElementNs = getRequestElementNs(metadata);

      if (serviceConfiguration.getForceDatabaseNamespace() && !requestElementNs.equals(namespace)) {
        mes.getSOAPPart().getEnvelope().addNamespaceDeclaration(ROOT_NS, namespace);
        rootElement = factory.createElement(requestElementName, ROOT_NS, namespace);
        XmlCursor c = ((XmlObject) object).newCursor();
        c.toNextToken();
        while (c.hasNextToken()) {
          if ((c.isStart() || c.isAttr() || c.isNamespace())
              && requestElementNs.equals(c.getName().getNamespaceURI())) {
            c.setName(new QName(namespace, c.getName().getLocalPart()));
          }
          c.toNextToken();
        }
        c.dispose();
      } else {
        mes.getSOAPPart().getEnvelope().addNamespaceDeclaration(ROOT_NS, requestElementNs);
        rootElement = factory.createElement(requestElementName, ROOT_NS, requestElementNs);
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

  public XTeeMessageCallback getCallback() {
    return callback;
  }

  protected String getRequestElementName(XmlBeansXTeeMetadata metadata) {
    return metadata.getOperationName();
  }

  protected String getRequestElementNs(XmlBeansXTeeMetadata metadata) {
    return metadata.getOperationNs();
  }

}