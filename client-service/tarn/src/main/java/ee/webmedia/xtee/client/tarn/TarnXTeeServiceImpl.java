package ee.webmedia.xtee.client.tarn;

import java.io.IOException;
import java.util.List;

import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;

import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.client.service.callback.CustomCallback;
import ee.webmedia.xtee.client.tarn.database.TarnXTeeDatabase;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Aadress;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Ametnik;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Fail;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.FyysilineIsik;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Isik;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Isik.Kontaktid;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Kohustis;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Kontakt;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.MakseRekvisiidid;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Menetlus;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.NoudeOsa;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Noue;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Olek;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.OsaMakse;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.OsaNoue;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Osaline;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Osaline.Esindajad;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.SeaduseSate;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.TarnToiming;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.Alus;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.SeotudToimingud;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.StaatusedKL;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.ToiminguMenetlejad;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.Toiminguosalised;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.ToiminguOsaline;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.ToiminguOsaline.OsaMaksed;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitmisavalduseEsitamineParing;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitmisavalduseEsitamineVastus;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.ToiminguTeavitus;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitemenetluseMuutmineTaSisend;
import ee.webmedia.xtee.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitemenetluseMuutmineTaVastus;
import ee.webmedia.xtee.client.tarn.types.org.xmlsoap.schemas.soap.encoding.Base64Binary;
import ee.webmedia.xtee.client.util.XmlBeansUtil;
import ee.webmedia.xtee.model.XTeeAttachment;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;
import ee.webmedia.xtee.util.AttachmentUtil;

/**
 * <code>TARN</code> X-tee service<br>
 * 
 * @author Romet Piho
 */
@Service("tarnXTeeService")
public class TarnXTeeServiceImpl extends XTeeDatabaseService implements TarnXTeeService {

  @Resource
  private TarnXTeeDatabase tarnXTeeDatabase;

  public TaitemenetluseMuutmineTaVastus taitemenetluseMuutmine(
      TaitemenetluseMuutmineTaSisend input)
      throws XTeeServiceConsumptionException {
    return tarnXTeeDatabase.taitemenetluseMuutmineTaV1(input);
  }

  public TaitmisavalduseEsitamineVastus taitmisavalduseEsitamine(
      TaitmisavalduseEsitamineParing input, DataHandler toimingudFail,
      DataHandler seotudToimingudFail) throws XTeeServiceConsumptionException {
    XmlCursor cursor = input.newCursor();
    while (cursor.hasNextToken()) {
      cursor.toNextToken();
      XmlObject object = cursor.getObject();
      boolean isStart = cursor.isStart();
      if (isStart && object instanceof XmlString) {
        insertTypeAttribute(cursor, "xsd:string");
      }
      else if (isStart && object instanceof XmlLong) {
        insertTypeAttribute(cursor, "xsd:long");
      }
      else if (isStart && object instanceof XmlDateTime) {
        insertTypeAttribute(cursor, "xsd:dateTime");
      }
      else if (isStart && object instanceof XmlBoolean) {
        insertTypeAttribute(cursor, "xsd:boolean");
      }
      else if (isStart && object instanceof XmlDecimal) {
        insertTypeAttribute(cursor, "xsd:decimal");
      }
      else if (isStart && object instanceof Aadress) {
        insertTypeAttribute(cursor, "eto:Aadress");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Fail) {
        insertTypeAttribute(cursor, "eto:Fail");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof FyysilineIsik) {
        insertTypeAttribute(cursor, "eto:FyysilineIsik");
      }
      else if (isStart && object instanceof Ametnik) {
        insertTypeAttribute(cursor, "eto:Ametnik");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Isik) {
        insertTypeAttribute(cursor, "eto:JuriidilineIsik");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Kontaktid) {
        insertArrayTypeAttribute(cursor, "eto:Kontakt[]");
        insertTypeAttribute(cursor, "eto:Kontakt");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Kontakt) {
        insertTypeAttribute(cursor, "eto:Kontakt");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof MakseRekvisiidid) {
        cursor.toPrevToken();
        insertArrayTypeAttribute(cursor, "eto:MakseRekvisiidid[]");
        insertTypeAttribute(cursor, "eto:MakseRekvisiidid");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Menetlus) {
        insertTypeAttribute(cursor, "eto:Menetlus");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof NoudeOsa) {
        insertTypeAttribute(cursor, "eto:NoudeOsa");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Noue) {
        insertTypeAttribute(cursor, "eto:Noue");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Olek) {
        insertTypeAttribute(cursor, "eto:Olek");
      }
      else if (isStart && object instanceof OsaMakse) {
        insertTypeAttribute(cursor, "eto:OsaMakse");
      }
      else if (isStart && object instanceof OsaNoue) {
        insertTypeAttribute(cursor, "eto:OsaNoue");
      }
      else if (isStart && object instanceof Esindajad) {
        insertArrayTypeAttribute(cursor, "eto:ToiminguOsaline[]");
        insertTypeAttribute(cursor, "eto:ToiminguOsaline");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof SeaduseSate) {
        insertTypeAttribute(cursor, "eto:SeaduseSate");
      }
      else if (isStart && object instanceof TarnToiming) {
        insertTypeAttribute(cursor, "eto:TarnToiming");
      }
      else if (isStart && object instanceof Alus) {
        insertArrayTypeAttribute(cursor, "eto:SeaduseSate[]");
        insertTypeAttribute(cursor, "eto:SeaduseSate");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof StaatusedKL) {
        insertArrayTypeAttribute(cursor, "eto:Olek[]");
        insertTypeAttribute(cursor, "eto:Olek");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof ToiminguMenetlejad) {
        insertArrayTypeAttribute(cursor, "eto:ToiminguOsaline[]");
        insertTypeAttribute(cursor, "eto:ToiminguOsaline");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Toiminguosalised) {
        insertArrayTypeAttribute(cursor, "eto:ToiminguOsaline[]");
        insertTypeAttribute(cursor, "eto:ToiminguOsaline");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof ToiminguOsaline) {
        insertTypeAttribute(cursor, "eto:ToiminguOsaline");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof OsaMaksed) {
        insertArrayTypeAttribute(cursor, "eto:OsaMakse[]");
        insertTypeAttribute(cursor, "eto:OsaMakse");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Osaline) {
        insertTypeAttribute(cursor, "eto:Osaline");
      }
      else if (isStart && object instanceof Kohustis) {
        insertTypeAttribute(cursor, "eto:Kohustis");
      }
      else if (isStart && object instanceof Base64Binary) {
        insertTypeAttribute(cursor, "xsd:base64Binary");
      }
      else if (isStart && object instanceof ToiminguTeavitus) {
        insertTypeAttribute(cursor, "eto:ToiminguTeavitus");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof Toiming) {
        insertTypeAttribute(cursor, "eto:Toiming");
        cursor.toPrevToken();
      }
      else if (isStart && object instanceof SeotudToimingud) {
        insertArrayTypeAttribute(cursor, "eto:Toiming[]");
        insertTypeAttribute(cursor, "eto:Toiming");
        cursor.toPrevToken();
      }
    }
    cursor.dispose();
    
    XmlBeansXTeeMessage<TaitmisavalduseEsitamineParing> xteeMessage = new XmlBeansXTeeMessage<TaitmisavalduseEsitamineParing>(input);
    List<XTeeAttachment> attachments = xteeMessage.getAttachments();
    
    String toimingudFailCid = AttachmentUtil.getUniqueCid();
    input.getTeavitus().getToiming().getPohiFail().getSisu().setHref("cid:"+toimingudFailCid);
    attachments.add(new XTeeAttachment(toimingudFailCid, toimingudFail));
    
    String seotudToimingudFailCid = AttachmentUtil.getUniqueCid();
    input.getTeavitus().getToiming().getSeotudToimingud().getItemArray(0).getPohiFail().getSisu().setHref("cid:"+seotudToimingudFailCid);
    attachments.add(new XTeeAttachment(seotudToimingudFailCid, seotudToimingudFail));
    
    XTeeMessage<TaitmisavalduseEsitamineVastus> response = 
        send(xteeMessage,
             "TaitmisavalduseEsitamine",
             "v1",
             new TarnCallback(),
             null);

    return response.getContent();
  }

  private void insertArrayTypeAttribute(XmlCursor cursor, String type) {
    insertTypeAttribute(cursor, "SOAP-ENC:Array");
    insertTypeAttribute(cursor,
                        "http://schemas.xmlsoap.org/soap/encoding/",
                        "arrayType",
                        "SOAP-ENC",
                        type);
  }

  private void insertTypeAttribute(XmlCursor cursor, String type) {
    insertTypeAttribute(cursor, type, true);
  }

  private void insertTypeAttribute(XmlCursor cursor, String type, boolean toNext) {
    if (toNext) {
      cursor.toNextToken();
    }
    insertTypeAttribute(cursor, "http://www.w3.org/2001/XMLSchema-instance", "type", "xsi", type);
  }

  private void insertTypeAttribute(XmlCursor cursor, String uri, String localPart, String prefix, String type) {
    cursor.insertAttributeWithValue(new QName(uri, localPart, prefix), type);
  }
  
  private static class TarnCallback extends CustomCallback {
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
      try {
        SaajSoapMessage saajMessage = (SaajSoapMessage) message;
        SOAPMessage soapmess = saajMessage.getSaajMessage();
        SOAPEnvelope env = soapmess.getSOAPPart().getEnvelope();
        env.addNamespaceDeclaration("eto", "http://producers.etoimik.xtee.riik.ee/producer/etoimik");
      } catch (SOAPException e) {
        throw new RuntimeException(e);
      }
      callback.doWithMessage(message);
    }
  }

}