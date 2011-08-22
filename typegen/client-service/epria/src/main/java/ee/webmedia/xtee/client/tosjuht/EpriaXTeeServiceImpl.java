package ee.webmedia.xtee.client.tosjuht;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.activation.DataHandler;

import ee.webmedia.xtee.client.tosjuht.model.ManusModel;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsSaadaTaotlusRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsSaadaTaotluseDigiDokRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseDigiDokRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseDigiDokResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseManusRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseManusResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfRequest;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.Manus;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.VastuseKood;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.model.XTeeAttachment;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;

/**
 * @author Lauri Lättemäe (lauri.lattemaw@webmedia.ee)
 * @date 10.09.2010
 */
public class EpriaXTeeServiceImpl extends XTeeDatabaseService implements EpriaXTeeService {
  @Override
  public VastuseKood saadaTaotluseDigiDok(String kandeNumber, ManusModel digiDok) throws XTeeServiceConsumptionException {
    DhsSaadaTaotluseDigiDokRequest request = DhsSaadaTaotluseDigiDokRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);
    XTeeMessage<VastuseKood> response = send(new XmlBeansXTeeMessage<DhsSaadaTaotluseDigiDokRequest>(request), "dhsSaadaTaotluseDigiDok");
    return response.getContent();
  }
  
  @Override
  public DhsVaataTaotluseDigiDokResponse vaataTaotluseDigiDok(String kandeNumber) throws XTeeServiceConsumptionException {
    DhsVaataTaotluseDigiDokRequest request = DhsVaataTaotluseDigiDokRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);
    XTeeMessage<DhsVaataTaotluseDigiDokResponse> response = send(new XmlBeansXTeeMessage<DhsVaataTaotluseDigiDokRequest>(request), "dhsVaataTaotluseDigiDok");
    return response.getContent();
  }
  
  @Override
  public DhsVaataTaotlusePdfResponse vaataTaotlusePdf(String kandeNumber) throws XTeeServiceConsumptionException {
	DhsVaataTaotlusePdfRequest request = DhsVaataTaotlusePdfRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);
    XTeeMessage<DhsVaataTaotlusePdfResponse> response = send(new XmlBeansXTeeMessage<DhsVaataTaotlusePdfRequest>(request), "dhsVaataTaotlusePdf");
    return response.getContent();
  }

  @Override
  public DhsVaataTaotluseManusResponse vaataTatoluseManus(Long portaaliId) throws XTeeServiceConsumptionException {
    DhsVaataTaotluseManusRequest request = DhsVaataTaotluseManusRequest.Factory.newInstance();
    request.setManuseId(String.valueOf(portaaliId));
    XTeeMessage<DhsVaataTaotluseManusResponse> response = send(new XmlBeansXTeeMessage<DhsVaataTaotluseManusRequest>(request), "dhsVaataTaotluseManus");
    return response.getContent();
  }
  
  @Override
  public VastuseKood saadaTaotlus(String kandeNumber, ManusModel pdf, List<ManusModel> manused) throws XTeeServiceConsumptionException {
    XTeeMessage<DhsSaadaTaotlusRequest> request = new XmlBeansXTeeMessage<DhsSaadaTaotlusRequest>(DhsSaadaTaotlusRequest.Factory.newInstance());
    request.getContent().setKandeNumber(kandeNumber);
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
}
