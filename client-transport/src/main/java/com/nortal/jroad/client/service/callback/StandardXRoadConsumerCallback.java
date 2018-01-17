package com.nortal.jroad.client.service.callback;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;

import org.apache.xmlbeans.XmlOptions;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import com.nortal.jroad.client.service.consumer.StandardXRoadConsumer;
import com.nortal.jroad.model.XmlBeansXRoadMetadata;

/**
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class StandardXRoadConsumerCallback implements WebServiceMessageCallback {
  private final Object object;
  private final XRoadMessageCallback callback;
  private final XmlBeansXRoadMetadata metadata;

  public StandardXRoadConsumerCallback(Object object, XRoadMessageCallback callback, XmlBeansXRoadMetadata metadata) {
    this.object = object;
    this.callback = callback;
    this.metadata = metadata;
  }

  @Override
  public void doWithMessage(WebServiceMessage request) throws IOException, TransformerException {
    SaajSoapMessage message = (SaajSoapMessage) request;
    SOAPMessage mes = message.getSaajMessage();

    try {
      mes.getSOAPPart().getEnvelope().addNamespaceDeclaration(StandardXRoadConsumer.ROOT_NS,
                                                              metadata.getRequestElementNs());
      getMarshaller().marshal(object, new DOMResult(mes.getSOAPBody()));
    } catch (SOAPException e) {
      throw new RuntimeException("Invalid SOAP message");
    }
    callback.doWithMessage(request);
  }

  protected Marshaller getMarshaller() {
    XmlBeansMarshaller marshaller = new XmlBeansMarshaller();
    marshaller.setXmlOptions(new XmlOptions().setSaveSyntheticDocumentElement(new QName(metadata.getRequestElementNs(),
                                                                                        metadata.getRequestElementName(),
                                                                                        StandardXRoadConsumer.ROOT_NS)));
    return marshaller;
  }
}