package com.nortal.jroad.client.tarn;

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

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.tarn.database.TarnXRoadDatabase;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Aadress;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Ametnik;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Fail;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.FyysilineIsik;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Isik;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Kohustis;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Kontakt;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.MakseRekvisiidid;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Menetlus;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.NoudeOsa;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Noue;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Olek;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.OsaMakse;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.OsaNoue;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Osaline;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.SeaduseSate;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.TarnToiming;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.ToiminguOsaline;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Isik.Kontaktid;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Osaline.Esindajad;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.Alus;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.SeotudToimingud;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.StaatusedKL;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.ToiminguMenetlejad;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.Toiming.Toiminguosalised;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.etoimik.producers.producer.etoimik.ToiminguOsaline.OsaMaksed;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitemenetluseMuutmineTaSisend;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitemenetluseMuutmineTaVastus;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitmisavalduseEsitamineParing;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitmisavalduseEsitamineVastus;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.ToiminguTeavitus;
import com.nortal.jroad.client.tarn.types.org.xmlsoap.schemas.soap.encoding.Base64Binary;
import com.nortal.jroad.client.util.XmlBeansUtil;
import com.nortal.jroad.model.XRoadAttachment;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import com.nortal.jroad.util.AttachmentUtil;

/**
 * <code>TARN</code> X-tee service<br>
 * 
 * @author Romet Piho
 */
@Service("tarnXTeeService")
public class TarnXTeeServiceImpl extends XRoadDatabaseService implements TarnXTeeService {

  @Resource
  private TarnXRoadDatabase tarnXRoadDatabase;

  public TaitemenetluseMuutmineTaVastus taitemenetluseMuutmine(
      TaitemenetluseMuutmineTaSisend input)
      throws XRoadServiceConsumptionException {
    return tarnXRoadDatabase.taitemenetluseMuutmineTaV1(input);
  }

  public TaitmisavalduseEsitamineVastus taitmisavalduseEsitamine(
      TaitmisavalduseEsitamineParing input, DataHandler toimingudFail,
      DataHandler seotudToimingudFail) throws XRoadServiceConsumptionException {
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
    
    XmlBeansXRoadMessage<TaitmisavalduseEsitamineParing> XRoadMessage = new XmlBeansXRoadMessage<TaitmisavalduseEsitamineParing>(input);
    List<XRoadAttachment> attachments = XRoadMessage.getAttachments();
    
    String toimingudFailCid = AttachmentUtil.getUniqueCid();
    input.getTeavitus().getToiming().getPohiFail().getSisu().setHref("cid:"+toimingudFailCid);
    attachments.add(new XRoadAttachment(toimingudFailCid, toimingudFail));
    
    String seotudToimingudFailCid = AttachmentUtil.getUniqueCid();
    input.getTeavitus().getToiming().getSeotudToimingud().getItemArray(0).getPohiFail().getSisu().setHref("cid:"+seotudToimingudFailCid);
    attachments.add(new XRoadAttachment(seotudToimingudFailCid, seotudToimingudFail));
    
    XRoadMessage<TaitmisavalduseEsitamineVastus> response = 
        send(XRoadMessage,
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