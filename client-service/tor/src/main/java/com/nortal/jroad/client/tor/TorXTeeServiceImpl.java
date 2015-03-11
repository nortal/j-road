package com.nortal.jroad.client.tor;

import javax.xml.namespace.QName;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKDocument;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKResponseDocument;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TorikRequestType;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKResponseDocument.TORIKResponse;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TorikRequestType.ParinguLiik;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;

/**
 * <code>TOR</code> database X-tee service implementation<br>
 * 
 * @author Eneli Reimets
 */
@Service("torXTeeServiceImpl")
public class TorXTeeServiceImpl extends XRoadDatabaseService implements TorXTeeService {

  private static final String TORIK = "TORIK";

  @Override
  public void init() {
    super.init();
    setDatabase("emtav5");
  }

  @Override
  public TORIKResponse findTorik(String paringuLiik, Date tootAlgusKp, Date tootLoppKp, String isikukood)
      throws XTeeServiceConsumptionException {
    TORIKDocument.TORIK torikDocument = TORIKDocument.TORIK.Factory.newInstance();

    TorikRequestType request = torikDocument.addNewRequest();
    request.setParinguLiik(ParinguLiik.Enum.forString(paringuLiik));
    request.setTootAlgus(getCalendar(tootAlgusKp));
    request.setTootLopp(getCalendar(tootLoppKp));

    if (ParinguLiik.Enum.forString(paringuLiik).equals(ParinguLiik.PM)) {
      request.setMuutAlg(getCalendar(tootAlgusKp));
      Calendar loppCal = getCalendar(new Date());
      loppCal.add(Calendar.DATE, 1);
      request.setMuutLopp(loppCal);
    }
    request.setIsikukoodid(isikukood);

    XTeeMessage<TORIKResponseDocument.TORIKResponse> vastus =
        send(new XmlBeansXTeeMessage<TORIKDocument.TORIK>(torikDocument), TORIK, "v1", new TorCallback(), null);

    return vastus.getContent();

  }

  private Calendar getCalendar(Date kuup) {
    if (kuup == null) {
      return null;
    }
    Calendar cal = Calendar.getInstance();
    cal.setTime(kuup);
    return cal;
  }

  private static class TorCallback extends CustomCallback {
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
