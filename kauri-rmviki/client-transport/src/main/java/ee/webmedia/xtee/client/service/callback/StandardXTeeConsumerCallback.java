package ee.webmedia.xtee.client.service.callback;

import static ee.webmedia.xtee.client.service.consumer.StandardXTeeConsumer.ROOT_NS;

import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlCursor;

import org.apache.xmlbeans.XmlObject;

import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;

import java.io.IOException;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;

import org.springframework.oxm.Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import ee.webmedia.xtee.model.XmlBeansXTeeMetadata;

/**
 * @author Dmitri Danilkin
 */
public class StandardXTeeConsumerCallback implements WebServiceMessageCallback {

  private final Object object;
  private final XTeeMessageCallback callback;
  private final Marshaller marshaller;
  private final XmlBeansXTeeMetadata metadata;

  public StandardXTeeConsumerCallback(Object object,
                                      XTeeMessageCallback callback,
                                      Marshaller marshaller,
                                      XmlBeansXTeeMetadata metadata) {
    this.object = object;
    this.callback = callback;
    this.marshaller = marshaller;
    this.metadata = metadata;
  }

  public void doWithMessage(WebServiceMessage request) throws IOException, TransformerException {
    SaajSoapMessage message = (SaajSoapMessage) request;
    SOAPMessage mes = message.getSaajMessage();

    try {
      SOAPBody body = mes.getSOAPBody();
      SOAPFactory factory = SOAPFactory.newInstance();
      SOAPElement rootElement;
      
      XTeeServiceConfiguration serviceConfiguration = callback.getServiceConfiguration();
      String databaseBasedNs = String.format("http://producers.%s.xtee.riik.ee/producer/%s", serviceConfiguration.getDatabase(), serviceConfiguration.getDatabase());
      if (serviceConfiguration.getForceDatabaseNamespace() && !metadata.getOperationNs().equals(databaseBasedNs)) {
        mes.getSOAPPart().getEnvelope().addNamespaceDeclaration(ROOT_NS, databaseBasedNs);
        rootElement = factory.createElement(metadata.getOperationName(), ROOT_NS, databaseBasedNs);
        XmlCursor c = ((XmlObject)object).newCursor();
        c.toNextToken();
        while (c.hasNextToken()) {
          if ((c.isStart() || c.isAttr() || c.isNamespace()) && metadata.getOperationNs().equals(c.getName().getNamespaceURI())) {
            c.setName(new QName(databaseBasedNs, c.getName().getLocalPart()));
          }
          c.toNextToken();
        }
        c.dispose();
      } else {
        mes.getSOAPPart().getEnvelope().addNamespaceDeclaration(ROOT_NS, metadata.getOperationNs());
        rootElement = factory.createElement(metadata.getOperationName(), ROOT_NS, metadata.getOperationNs());
      }
      rootElement.setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");

      marshaller.marshal(object, new DOMResult(rootElement));
      body.addChildElement(rootElement);
    } catch (SOAPException e) {
      throw new RuntimeException("Invalid SOAP message");
    }
    callback.doWithMessage(request);
  }

}