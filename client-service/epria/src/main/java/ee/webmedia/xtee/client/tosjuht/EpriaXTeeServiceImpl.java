package ee.webmedia.xtee.client.tosjuht;

import ee.webmedia.xtee.client.exception.NonTechnicalFaultException;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.client.tosjuht.database.EpriaXTeeDatabase;
import ee.webmedia.xtee.client.tosjuht.model.ManusModel;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.BinaarfailNest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsSaadaTaotlusRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseDigiDokRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseDigiDokResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseManusRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseManusResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.EpriaManusegaRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.EpriaManusegaResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.Manus;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.VastuseKood;
import ee.webmedia.xtee.jaxb.ByteArrayDataSource;
import ee.webmedia.xtee.model.XTeeAttachment;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.annotation.Resource;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlString;
import org.springframework.stereotype.Service;

/**
 * @author Lauri Lättemäe (lauri.lattemaw@webmedia.ee)
 * @date 10.09.2010
 */
@Service("epriaXTeeService")
public class EpriaXTeeServiceImpl extends EpriaXTeeDatabaseService implements EpriaXTeeService {

  @Resource
  private EpriaXTeeDatabase epriaXTeeDatabase;

  @Override
  public String epria(String xml, String securityServer, String isikukood) throws XTeeServiceConsumptionException {
    try {
      XTeeMessage<XmlString> response = send(new XmlBeansXTeeMessage<XmlString>(XmlString.Factory.parse(xml)), "epria", "v1", isikukood, securityServer);
      return ((XmlString) response.getContent()).xmlText();
    } catch(XTeeServiceConsumptionException ex) {
      throw ex;
    } catch(XmlException ex) {
      throw new XTeeServiceConsumptionException(new NonTechnicalFaultException("1", "P2ring eba6nnestus"), "epria", "epria", "v1");
    }
  }
  
  @Override
  public String epriaParingManusega(String xml, String securityServer, String isikukood) throws XTeeServiceConsumptionException {
    try {
      XTeeMessage<EpriaManusegaRequest> request = new XmlBeansXTeeMessage<EpriaManusegaRequest>(EpriaManusegaRequest.Factory.newInstance());
      BinaarfailNest xmlManus = request.getContent().addNewParingXml();
      xmlManus.setAttachmentHandler(new DataHandler(new ByteArrayDataSource("text/xml", xml.getBytes("UTF-8"))));
      
      XTeeMessage<EpriaManusegaResponse> response = send(request, "epriaManusega", "v1", isikukood, securityServer);
      InputStream in = response.getContent().getVastusXml().getAttachmentHandler().getInputStream();
      
      int read = 0;
      byte[] bytes = new byte[1024];
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      while ((read = in.read(bytes)) != -1) {
        out.write(bytes, 0, read);
      }
      out.flush();
      in.close();
  
      return new String(out.toByteArray(), "UTF-8");
    } catch(XTeeServiceConsumptionException ex) {
      ex.printStackTrace();
      throw ex;
    } catch(Exception ex) {
      ex.printStackTrace();
      throw new XTeeServiceConsumptionException(new NonTechnicalFaultException("1", "P2ring eba6nnestus"), "epria", "epriaParingManusega", "v1");
    }
  }

  @Override
  public DhsVaataTaotluseDigiDokResponse vaataTaotluseDigiDok(String kandeNumber) throws XTeeServiceConsumptionException {
    DhsVaataTaotluseDigiDokRequest request = DhsVaataTaotluseDigiDokRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);
    return epriaXTeeDatabase.dhsVaataTaotluseDigiDokV1(request);
  }

  @Override
  public DhsVaataTaotlusePdfResponse vaataTaotlusePdf(String kandeNumber) throws XTeeServiceConsumptionException {
    DhsVaataTaotlusePdfRequest request = DhsVaataTaotlusePdfRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);
    return epriaXTeeDatabase.dhsVaataTaotlusePdfV1(request);
  }

  @Override
  public DhsVaataTaotluseManusResponse vaataTatoluseManus(String kandeNumber, String portaaliId, String sisuFailId, String vaataja, Integer priaRoll) throws XTeeServiceConsumptionException {
    DhsVaataTaotluseManusRequest request = DhsVaataTaotluseManusRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);
    request.setManuseId(portaaliId != null ? portaaliId : "");
    request.setSisuFailId(sisuFailId != null ? sisuFailId : "");
    request.setVaataja(vaataja != null ? vaataja : "");
    request.setPriaRoll(priaRoll != null ? priaRoll.toString() : "");
    return epriaXTeeDatabase.dhsVaataTaotluseManusV1(request);
  }

  @Override
  public VastuseKood saadaTaotlus(String kandeNumber, ManusModel digiDoc, ManusModel pdf, List<ManusModel> manused) throws XTeeServiceConsumptionException {
    XTeeMessage<DhsSaadaTaotlusRequest> request = new XmlBeansXTeeMessage<DhsSaadaTaotlusRequest>(DhsSaadaTaotlusRequest.Factory.newInstance());
    request.getContent().setKandeNumber(kandeNumber);
    
    if (digiDoc != null) {
      XTeeAttachment digiDocAttach = new XTeeAttachment(UUID.randomUUID().toString(), digiDoc.getSisu());
      request.getAttachments().add(digiDocAttach);
      Manus digiDocManus = request.getContent().addNewTaotluseDigiDoc();
      digiDocManus.setManuseId(digiDoc.getPortaaliId());
      digiDocManus.setManuseNimi(digiDoc.getNimi());
      digiDocManus.addNewSisu().setAttachment("cid:" + digiDocAttach.getCid());
    }
    
    XTeeAttachment pdfAttach = new XTeeAttachment(UUID.randomUUID().toString(), pdf.getSisu());
    request.getAttachments().add(pdfAttach);
    Manus pdfManus = request.getContent().addNewTaotlusePdf();
    pdfManus.setManuseId(pdf.getPortaaliId());
    pdfManus.setManuseNimi(pdf.getNimi());
    pdfManus.addNewSisu().setAttachment("cid:" + pdfAttach.getCid());

    for (ManusModel manus : manused) {
        XTeeAttachment attach = new XTeeAttachment(manus.getPortaaliId(), manus.getSisu());
        request.getAttachments().add(attach);
        Manus taotluseManus = request.getContent().addNewManus();
        taotluseManus.setManuseId(manus.getPortaaliId());
        taotluseManus.setManuseNimi(manus.getNimi());
        taotluseManus.addNewSisu().setAttachment("cid:" + attach.getCid());
    }
    XTeeMessage<VastuseKood> response = send(request, "dhsSaadaTaotlus");
    return response.getContent();
  }


  public void setEpriaXTeeDatabase(EpriaXTeeDatabase epriaXTeeDatabase) {
    this.epriaXTeeDatabase = epriaXTeeDatabase;
  }
}
