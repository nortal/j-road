package com.nortal.jroad.client.emtav5;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import com.nortal.jroad.client.emtav5.database.Emtav5XTeeDatabase;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentDocument.SkaMitteresident;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentRequestType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentResponseDocument.SkaMitteresidentResponse;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentResponseType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckCommonRequestType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckRequestType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response.Period;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;

/**
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
@Service("emtav5XTeeService")
public class Emtav5XTeeServiceImpl extends XRoadDatabaseService implements Emtav5XTeeService {

  private static final String XTEE_FIEAK = "xteeFIEAK";
  private static final String SKA_MITTERESIDENT = "skaMitteresident";

  @Resource
  private Emtav5XTeeDatabase emtav5XTeeDatabase;

  public List<Period> xteeFIEAKV1(String id, Date start, Date end) throws XTeeServiceConsumptionException {
    SpouseCheckRequestType request = SpouseCheckRequestType.Factory.newInstance();
    SpouseCheckCommonRequestType commonRequest = request.addNewRequest();
    commonRequest.setId(id);
    commonRequest.setStart(getCalendar(start));
    commonRequest.setEnd(getCalendar(end));

    XTeeMessage<SpouseCheckResponseType> xteeFIEAKV1 = send(new XmlBeansXTeeMessage<SpouseCheckRequestType>(request),
                                                            XTEE_FIEAK,
                                                            "v1");

    Response response = xteeFIEAKV1.getContent().getResponse();
    return response.getPeriodList();
  }

  private Calendar getCalendar(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
  }

  @Override
  public SkaMitteresidentResponseType skaMitteresident(String registreerimiskood)
      throws XTeeServiceConsumptionException {
    SkaMitteresident input = SkaMitteresident.Factory.newInstance();
    SkaMitteresidentRequestType request = input.addNewRequest();
    request.setRegistreerimiskood(registreerimiskood);

    XTeeMessage<SkaMitteresidentResponse> skaMitteresident = send(new XmlBeansXTeeMessage<SkaMitteresident>(input),
                                                                  SKA_MITTERESIDENT,
                                                                  "v1",
                                                                  new SkaMitteresidentCallback(),
                                                                  null);
    return skaMitteresident.getContent().getResponse();
  }

  private static class SkaMitteresidentCallback extends CustomCallback {
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
      callback.doWithMessage(message);
      try {
        SaajSoapMessage saajMessage = (SaajSoapMessage) message;
        SOAPMessage soapmess = saajMessage.getSaajMessage();
        SOAPEnvelope env = soapmess.getSOAPPart().getEnvelope();
        env.addNamespaceDeclaration("ns5", "http://emtav5.x-road.ee/producer/");
        env.addNamespaceDeclaration("xro", "http://x-road.ee/xsd/x-road.xsd");
        Iterator elements = env.getBody().getChildElements();
        while (elements.hasNext()) {
          SOAPElement element = (SOAPElement) elements.next();
          if (element.getNamespaceURI().equalsIgnoreCase("http://emtav5.ee.x-rd.net/producer/")) {
            String localHeaderName = element.getLocalName();
            QName qName = new QName("http://emtav5.x-road.ee/producer/", localHeaderName, "ns5");
            element.setElementQName(qName);
          }
        }
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
