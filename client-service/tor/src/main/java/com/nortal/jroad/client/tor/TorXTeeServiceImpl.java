package com.nortal.jroad.client.tor;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.v3.XRoadDatabaseService;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.DownloadMimeDocument;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.DownloadMimeDocument.DownloadMime;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.DownloadMimeResponseDocument.DownloadMimeResponse;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKDocument.TORIK;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.DownloadMimeType;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKDocument;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKResponseDocument;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKResponseDocument.TORIKResponse;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TorikRequestType;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TorikRequestType.ParinguLiik;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.UploadMimeDocument;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.UploadMimeDocument.UploadMime;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.UploadMimeResponseDocument.UploadMimeResponse;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.UploadMimeType;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.UploadMimeType.Props;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.UploadMimeType.Props.Prop;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import com.nortal.jroad.util.AttachmentUtil;

/**
 * <code>TOR</code> database X-tee service implementation<br>
 * 
 * @author Eneli Reimets
 */
@Service("torXTeeServiceImpl")
public class TorXTeeServiceImpl extends XRoadDatabaseService implements TorXTeeService {

  private static final String UPLOAD_ID = "UPLOAD_ID";
  private static final String METHOD_TORIK = "TORIK";
  private static final String METHOD_UPLOAD_MIME = "uploadMime";
  private static final String METHOD_DOWNLOAD_MIME = "downloadMime";
  private static final String V1 = "v1";

  @Override
  public void init() {
    super.init();
    setDatabase("emtav5");
  }
  
  @Override
  public XTeeMessage<DownloadMimeResponse> downloadMime(String target) throws XTeeServiceConsumptionException {
    DownloadMime downloadMimeDocument = DownloadMimeDocument.DownloadMime.Factory.newInstance();

    DownloadMimeType request = downloadMimeDocument.addNewRequest();
    request.setTarget(target);

    XTeeMessage<DownloadMimeResponse> response = send(new XmlBeansXTeeMessage<DownloadMimeDocument.DownloadMime>(downloadMimeDocument),
                                                      METHOD_DOWNLOAD_MIME,
                                                      V1,
                                                      new TorCallback(),
                                                      null);
    return response;
  }
  
  @Override
  public UploadMimeResponse uploadMime(String target, String operation, String id, DataHandler fail)
      throws XTeeServiceConsumptionException {
    UploadMime uploadMimeDocument = UploadMimeDocument.UploadMime.Factory.newInstance();

    UploadMimeType request = uploadMimeDocument.addNewRequest();
    request.setTarget(target);
    request.setOperation(operation);
    Props props = request.addNewProps();
    Prop prop = props.addNewProp();
    prop.setKey(UPLOAD_ID);
    prop.setStringValue(id);

    XmlBeansXTeeMessage<UploadMimeDocument.UploadMime> xteeMessage = new XmlBeansXTeeMessage<UploadMimeDocument.UploadMime>(uploadMimeDocument);
    List<XTeeAttachment> attachments = xteeMessage.getAttachments();

    String failCid = AttachmentUtil.getUniqueCid();
    request.addNewFile().setHref("cid:" + failCid);
    attachments.add(new XTeeAttachment(failCid, fail));

    XTeeMessage<UploadMimeResponse> response = send(xteeMessage, METHOD_UPLOAD_MIME, V1, new TorCallback(), null);

    return response.getContent();
  }

  @Override
  public TORIKResponse findTorik(String paringuLiik, Date tootAlgusKp, Date tootLoppKp, String isikukood)
      throws XTeeServiceConsumptionException {
    TorikRequestType torik = getTorikRequest(paringuLiik, tootAlgusKp, tootLoppKp, isikukood).getTORIK().getRequest();

    XTeeMessage<TORIKResponseDocument.TORIKResponse> vastus =
        send(new XmlBeansXTeeMessage<TorikRequestType>(torik), METHOD_TORIK, V1, new TorCallback(), null);

    return vastus.getContent();

  }

  @Override
  public TORIKDocument getTorikRequest(String paringuLiik, Date tootAlgusKp, Date tootLoppKp, String isikukood) {
    TORIKDocument torikDocument = TORIKDocument.Factory.newInstance();
    TORIK torik = torikDocument.addNewTORIK();

    TorikRequestType request = torik.addNewRequest();
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
    return torikDocument;
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
