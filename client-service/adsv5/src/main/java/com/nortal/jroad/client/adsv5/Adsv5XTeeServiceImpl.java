package com.nortal.jroad.client.adsv5;

import com.nortal.jroad.client.service.v3.XRoadDatabaseService;

import java.io.IOException;
import java.util.Iterator;
import javax.xml.namespace.QName;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalDocument;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalRequestType;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalRequestType.NormalParam;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalResponseDocument;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalVastusType;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;

@Service("adsv5XTeeService")
public class Adsv5XTeeServiceImpl extends XRoadDatabaseService implements Adsv5XTeeService {
	  
  public ADSnormalVastusType adsNormal(NormalParamCallback callback) throws XTeeServiceConsumptionException {
  	ADSnormalDocument.ADSnormal dok = ADSnormalDocument.ADSnormal.Factory.newInstance();
  	ADSnormalRequestType request = dok.addNewRequest();
  	NormalParam normalParam = request.addNewNormalParam();
  	
  	callback.populate(normalParam);
  	  	
    XTeeMessage<ADSnormalResponseDocument.ADSnormalResponse> vastus =
        send(new XmlBeansXTeeMessage<ADSnormalDocument.ADSnormal>(dok), "ADSnormal", "v2", new NamespaceReplaceCallback(), null);
    
    ADSnormalVastusType v = vastus.getContent().getResponse().getADSnormalResult();
    return v;
  }
  
  // FIXME: Check {@link XRoadMessageCallbackNamespaceStrategy}. It currently uses deprecated namespace. Probably XRoad namespace strategy can be updated and this callback abandoned.
  private static class NamespaceReplaceCallback extends CustomCallback {
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
      callback.doWithMessage(message);
      try {
        SaajSoapMessage saajMessage = (SaajSoapMessage) message;
        SOAPMessage soapmess = saajMessage.getSaajMessage();
        SOAPEnvelope env = soapmess.getSOAPPart().getEnvelope();
        env.addNamespaceDeclaration("xro", "http://x-road.ee/xsd/x-road.xsd");
        Iterator headers = env.getHeader().getChildElements();
        while (headers.hasNext()) {
          SOAPElement header = (SOAPElement) headers.next();
          if (header.getNamespaceURI().equalsIgnoreCase("http://x-rd.net/xsd/xroad.xsd")) {
            String localHeaderName = header.getLocalName();
            QName qName = new QName("http://x-road.ee/xsd/x-road.xsd", localHeaderName, "xro");
            header.setElementQName(qName);
          }
        }
      } catch (SOAPException e) {
        throw new RuntimeException(e);
      }

    }
  }
}
