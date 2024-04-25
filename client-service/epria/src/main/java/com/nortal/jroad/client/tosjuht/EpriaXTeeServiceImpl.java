package com.nortal.jroad.client.tosjuht;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import jakarta.activation.DataHandler;
import jakarta.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlString;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.NonTechnicalFaultException;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.v2.XTeeDatabaseService;
import com.nortal.jroad.client.service.configuration.DelegatingXRoadServiceConfiguration;
import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;
import com.nortal.jroad.client.tosjuht.database.EpriaXTeeDatabase;
import com.nortal.jroad.client.tosjuht.model.ManusModel;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.BinaarfailNest;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsSaadaTaotlusRequest;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseDigiDokRequest;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseDigiDokResponse;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseManusRequest;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseManusResponse;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfRequest;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfResponse;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.EpriaManusegaRequest;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.EpriaManusegaResponse;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.Manus;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.VastuseKood;
import com.nortal.jroad.jaxb.ByteArrayDataSource;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;

/**
 * @author Lauri Lättemäe 
 * @date 10.09.2010
 */
@Service("epriaXTeeService")
public class EpriaXTeeServiceImpl extends XTeeDatabaseService implements EpriaXTeeService {

  @Resource
  private EpriaXTeeDatabase epriaXTeeDatabase;

  private <I, O> XTeeMessage<O> send(XTeeMessage<I> input,
                                     String method,
                                     String version,
                                     final String idCode,
                                     final String securityServer) throws XTeeServiceConsumptionException {
    final BaseXRoadServiceConfiguration xteeConfiguration =
        xRoadServiceConfigurationProvider.createConfiguration(getDatabase(), getDatabase(), method, version);

    DelegatingXRoadServiceConfiguration configuration = new DelegatingXRoadServiceConfiguration(xteeConfiguration) {
      @Override
      public String getIdCode() {
        return idCode != null ? idCode : super.getIdCode();
      }

      @Override
      public String getSecurityServer() {
        return securityServer != null ? securityServer : super.getSecurityServer();
      }
    };

    XTeeMessage<O> result = xTeeConsumer.sendRequest(input, configuration);
    return result;
  }

  @Override
  public String epria(String xml, String securityServer, String isikukood) throws XTeeServiceConsumptionException {
    try {
      XTeeMessage<XmlString> response =
          send(new XmlBeansXTeeMessage<XmlString>(XmlString.Factory.parse(xml)),
               "epria",
               "v1",
               isikukood,
               securityServer);
      return ((XmlString) response.getContent()).xmlText();
    } catch (XTeeServiceConsumptionException ex) {
      throw ex;
    } catch (XmlException ex) {
      throw new XTeeServiceConsumptionException(new NonTechnicalFaultException("1", "P2ring eba6nnestus"),
                                                "epria",
                                                "epria",
                                                "v1");
    }
  }

  @Override
  public String epriaParingManusega(String xml, String securityServer, String isikukood)
      throws XTeeServiceConsumptionException {
    try {
      XTeeMessage<EpriaManusegaRequest> request =
          new XmlBeansXTeeMessage<EpriaManusegaRequest>(EpriaManusegaRequest.Factory.newInstance());
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
    } catch (XTeeServiceConsumptionException ex) {
      ex.printStackTrace();
      throw ex;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new XTeeServiceConsumptionException(new NonTechnicalFaultException("1", "P2ring eba6nnestus"),
                                                "epria",
                                                "epriaParingManusega",
                                                "v1");
    }
  }

  @Override
  public DhsVaataTaotluseDigiDokResponse vaataTaotluseDigiDok(String kandeNumber)
      throws XTeeServiceConsumptionException {
    return vaataTaotluseDigiDok(null, kandeNumber);
  }

  @Override
  public DhsVaataTaotluseDigiDokResponse vaataTaotluseDigiDok(String securityServer, String kandeNumber)
      throws XTeeServiceConsumptionException {

    DhsVaataTaotluseDigiDokRequest request = DhsVaataTaotluseDigiDokRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);

    DhsVaataTaotluseDigiDokResponse result = null;
    if (StringUtils.isEmpty(securityServer)) {
      result = epriaXTeeDatabase.dhsVaataTaotluseDigiDokV1(request);
    } else {
      result =
          (DhsVaataTaotluseDigiDokResponse) send(new XmlBeansXTeeMessage<DhsVaataTaotluseDigiDokRequest>(request),
                                                 "dhsVaataTaotluseDigiDok",
                                                 "v1",
                                                 null,
                                                 securityServer).getContent();
    }
    return result;
  }

  @Override
  public DhsVaataTaotlusePdfResponse vaataTaotlusePdf(String kandeNumber) throws XTeeServiceConsumptionException {
    DhsVaataTaotlusePdfRequest request = DhsVaataTaotlusePdfRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);
    return epriaXTeeDatabase.dhsVaataTaotlusePdfV1(request);
  }

  @Override
  public DhsVaataTaotlusePdfResponse vaataTaotlusePdf(String securityServer, String kandeNumber)
      throws XTeeServiceConsumptionException {
    DhsVaataTaotlusePdfRequest request = DhsVaataTaotlusePdfRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);

    DhsVaataTaotlusePdfResponse result = null;
    if (StringUtils.isEmpty(securityServer)) {
      result = epriaXTeeDatabase.dhsVaataTaotlusePdfV1(request);
    } else {
      result =
          (DhsVaataTaotlusePdfResponse) send(new XmlBeansXTeeMessage<DhsVaataTaotlusePdfRequest>(request),
                                             "dhsVaataTaotlusePdf",
                                             "v1",
                                             null,
                                             securityServer).getContent();
    }
    return result;
  }

  @Override
  public DhsVaataTaotluseManusResponse vaataTatoluseManus(String kandeNumber,
                                                          String portaaliId,
                                                          String sisuFailId,
                                                          String vaataja,
                                                          Integer priaRoll) throws XTeeServiceConsumptionException {
    return vaataTatoluseManus(null, kandeNumber, portaaliId, sisuFailId, vaataja, priaRoll);
  }

  @Override
  public DhsVaataTaotluseManusResponse vaataTatoluseManus(String securityServer,
                                                          String kandeNumber,
                                                          String portaaliId,
                                                          String sisuFailId,
                                                          String vaataja,
                                                          Integer priaRoll) throws XTeeServiceConsumptionException {
    DhsVaataTaotluseManusRequest request = DhsVaataTaotluseManusRequest.Factory.newInstance();
    request.setKandeNumber(kandeNumber);
    request.setManuseId(portaaliId != null ? portaaliId : "");
    request.setSisuFailId(sisuFailId != null ? sisuFailId : "");
    request.setVaataja(vaataja != null ? vaataja : "");
    request.setPriaRoll(priaRoll != null ? priaRoll.toString() : "");

    DhsVaataTaotluseManusResponse result = null;
    if (StringUtils.isEmpty(securityServer)) {
      result = epriaXTeeDatabase.dhsVaataTaotluseManusV1(request);
    } else {
      result =
          (DhsVaataTaotluseManusResponse) send(new XmlBeansXTeeMessage<DhsVaataTaotluseManusRequest>(request),
                                               "dhsVaataTaotluseManus",
                                               "v1",
                                               null,
                                               securityServer).getContent();
    }
    return result;
  }

  @Override
  public VastuseKood saadaTaotlus(String kandeNumber, ManusModel digiDoc, ManusModel pdf, List<ManusModel> manused)
      throws XTeeServiceConsumptionException {
    return saadaTaotlus(null, kandeNumber, digiDoc, pdf, manused);
  }

  @Override
  public VastuseKood saadaTaotlus(String securityServer,
                                  String kandeNumber,
                                  ManusModel digiDoc,
                                  ManusModel pdf,
                                  List<ManusModel> manused) throws XTeeServiceConsumptionException {
    XTeeMessage<DhsSaadaTaotlusRequest> request =
        new XmlBeansXTeeMessage<DhsSaadaTaotlusRequest>(DhsSaadaTaotlusRequest.Factory.newInstance());
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

    XTeeMessage<VastuseKood> response = null;
    if (StringUtils.isBlank(securityServer)) {
      response = send(request, "dhsSaadaTaotlus");
    } else {
      response = send(request, "dhsSaadaTaotlus", "v1", null, securityServer);
    }
    return response.getContent();
  }

  public void setEpriaXTeeDatabase(EpriaXTeeDatabase epriaXTeeDatabase) {
    this.epriaXTeeDatabase = epriaXTeeDatabase;
  }
}
