package com.nortal.jroad.client.emtav5;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import jakarta.activation.DataHandler;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import javax.xml.namespace.QName;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;

import com.nortal.jroad.client.service.MetaserviceOperations;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import com.nortal.jroad.client.emtav5.database.Emtav5XRoadDatabase;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.DownloadMimeDocument;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.DownloadMimeDocument.DownloadMime;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.DownloadMimeResponseDocument.DownloadMimeResponse;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.DownloadMimeType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentDocument.SkaMitteresident;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentRequestType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentResponseDocument.SkaMitteresidentResponse;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentResponseType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SmMaksustatavadAndmedDocument.SmMaksustatavadAndmed;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SmMaksustatavadAndmedResponseDocument.SmMaksustatavadAndmedResponse;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SmMaksustatavadAndmedResponseType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SmMaksustatavadAndmedType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckCommonRequestType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckRequestType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response.Period;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.UploadMimeDocument;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.UploadMimeDocument.UploadMime;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.UploadMimeResponseDocument.UploadMimeResponse;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.UploadMimeType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.UploadMimeType.Props;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.UploadMimeType.Props.Prop;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.v3.XRoadDatabaseService;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import com.nortal.jroad.util.AttachmentUtil;

/**
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
@Service("emtav5XTeeService")
public class Emtav5XTeeServiceImpl extends XRoadDatabaseService implements Emtav5XTeeService {

  private static final String XTEE_FIEAK = "xteeFIEAK";
  private static final String SKA_MITTERESIDENT = "skaMitteresident";
  private static final String SM_MAKSUSTATAVAD_ANDMED = "smMaksustatavadAndmed";
  private static final String UPLOAD_ID = "UPLOAD_ID";
  private static final String UPLOAD_MIME = "uploadMime";
  private static final String DOWNLOAD_MIME = "downloadMime";
  private static final String V1 = "v1";

  @Resource
  private Emtav5XRoadDatabase emtav5XRoadDatabase;
  private MetaserviceOperations metaserviceOperations;

  @PostConstruct public void setUpCollaborators() {
    metaserviceOperations = new MetaserviceOperations(emtav5XRoadDatabase);
  }

  @Override
  public Integer getState() throws XTeeServiceConsumptionException {
    return metaserviceOperations.getState();
  }

  public List<Period> xteeFIEAKV1(String id, Date start, Date end) throws XTeeServiceConsumptionException {
    SpouseCheckRequestType request = SpouseCheckRequestType.Factory.newInstance();
    SpouseCheckCommonRequestType commonRequest = request.addNewRequest();
    commonRequest.setId(id);
    commonRequest.setStart(getCalendar(start));
    commonRequest.setEnd(getCalendar(end));

    XTeeMessage<SpouseCheckResponseType> xteeFIEAKV1 = send(new XmlBeansXTeeMessage<SpouseCheckRequestType>(request),
                                                            XTEE_FIEAK,
                                                            V1);

    Response response = xteeFIEAKV1.getContent().getResponse();
    return response.getPeriodList();
  }

  private Calendar getCalendar(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
  }

  public SkaMitteresidentResponseType skaMitteresident(String registreerimiskood)
      throws XTeeServiceConsumptionException {
    SkaMitteresident input = SkaMitteresident.Factory.newInstance();
    SkaMitteresidentRequestType request = input.addNewRequest();
    request.setRegistreerimiskood(registreerimiskood);

    XTeeMessage<SkaMitteresidentResponse> skaMitteresident = send(new XmlBeansXTeeMessage<SkaMitteresident>(input),
                                                                  SKA_MITTERESIDENT,
                                                                  V1,
                                                                  new Emtav5Callback(),
                                                                  null);
    return skaMitteresident.getContent().getResponse();
  }

  @Override
  public SmMaksustatavadAndmedResponseType smMaksustatavadAndmed(String isikukood,
                                                                 String perioodiAlgus,
                                                                 String perioodiLopp)
                                                                     throws XTeeServiceConsumptionException {
    SmMaksustatavadAndmed input = SmMaksustatavadAndmed.Factory.newInstance();
    SmMaksustatavadAndmedType request = input.addNewRequest();
    request.setIsikukood(isikukood);
    request.setPerioodiAlgus(perioodiAlgus);
    request.setPerioodiLopp(perioodiLopp);

    XTeeMessage<SmMaksustatavadAndmedResponse> skaMitteresident = send(new XmlBeansXTeeMessage<SmMaksustatavadAndmed>(input),
                                                                       SM_MAKSUSTATAVAD_ANDMED,
                                                                       V1,
                                                                       new Emtav5Callback(),
                                                                       null);
    return skaMitteresident.getContent().getResponse();
  }

  @Override
  public XTeeMessage<DownloadMimeResponse> downloadMime(String target) throws XTeeServiceConsumptionException {
    DownloadMime downloadMimeDocument = DownloadMimeDocument.DownloadMime.Factory.newInstance();

    DownloadMimeType request = downloadMimeDocument.addNewRequest();
    request.setTarget(target);

    XTeeMessage<DownloadMimeResponse> response = send(new XmlBeansXTeeMessage<DownloadMimeDocument.DownloadMime>(downloadMimeDocument),
                                                      DOWNLOAD_MIME,
                                                      V1,
                                                      new Emtav5Callback(),
                                                      null);
    return response;
  }

  @Override
  public UploadMimeResponse uploadMime(String target, String id, DataHandler fail)
      throws XTeeServiceConsumptionException {
    UploadMime uploadMimeDocument = UploadMimeDocument.UploadMime.Factory.newInstance();

    UploadMimeType request = uploadMimeDocument.addNewRequest();
    request.setTarget(target);
    Props props = request.addNewProps();
    Prop prop = props.addNewProp();
    prop.setKey(UPLOAD_ID);
    prop.setStringValue(id);

    XmlBeansXTeeMessage<UploadMimeDocument.UploadMime> xteeMessage = new XmlBeansXTeeMessage<UploadMimeDocument.UploadMime>(uploadMimeDocument);
    List<XTeeAttachment> attachments = xteeMessage.getAttachments();

    String failCid = AttachmentUtil.getUniqueCid();
    request.addNewFile().setHref("cid:" + failCid);
    attachments.add(new XTeeAttachment(failCid, fail));

    XTeeMessage<UploadMimeResponse> response = send(xteeMessage, UPLOAD_MIME, V1, new Emtav5Callback(), null);

    return response.getContent();
  }

  private static class Emtav5Callback extends CustomCallback {
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
