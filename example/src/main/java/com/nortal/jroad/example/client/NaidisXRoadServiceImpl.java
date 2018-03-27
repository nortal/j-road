package com.nortal.jroad.example.client;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.example.client.database.NaidisXRoadDatabase;
import com.nortal.jroad.example.client.types.eu.x_road.naidis.AttachmentEchoRequest;
import com.nortal.jroad.example.client.types.eu.x_road.naidis.AttachmentEchoResponse;
import com.nortal.jroad.example.client.types.eu.x_road.naidis.EchoRequest;
import com.nortal.jroad.example.client.types.eu.x_road.naidis.EchoResponse;
import com.nortal.jroad.jaxb.ByteArrayDataSource;
import com.nortal.jroad.model.BeanXRoadMessage;
import com.nortal.jroad.model.XRoadAttachment;
import com.nortal.jroad.model.XRoadMessage;
import java.util.Arrays;
import javax.activation.DataHandler;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com)
 */
@Service("naidisXRoadService")
public class NaidisXRoadServiceImpl extends XRoadDatabaseService implements NaidisXRoadService {
  @Resource
  private NaidisXRoadDatabase naidisXRoadDatabase;

  @Override
  public AttachmentEchoResponse sendAttachment(String contentType, byte[] content)
      throws XRoadServiceConsumptionException {
    DataHandler reqHandler = new DataHandler(new ByteArrayDataSource(contentType, content));
    AttachmentEchoRequest request = AttachmentEchoRequest.Factory.newInstance();
    request.addNewNest().setAttachmentHandler(reqHandler);
    return naidisXRoadDatabase.attachmentEchoV1(request);
  }

  @Override
  public String sendEcho(String text) throws XRoadServiceConsumptionException {
    EchoRequest req = EchoRequest.Factory.newInstance();
    req.setText(text);
    return naidisXRoadDatabase.echoV1(req).getText();
  }

  @Override
  public String sendEchoMime(String text) throws XRoadServiceConsumptionException {
    EchoRequest echoReq = EchoRequest.Factory.newInstance();
    echoReq.setText(text);
    BeanXRoadMessage<EchoRequest> req =
        new BeanXRoadMessage<EchoRequest>(null,
                                          echoReq,
                                          Arrays.asList(new XRoadAttachment("cid", "text/plain", text.getBytes())));
    XRoadMessage<EchoResponse> rsp = send(req, "Echo", "v1");
    return rsp.getContent().getText();
  }

  @Override
  public String sendAxisEcho(String text) throws XRoadServiceConsumptionException {
    EchoRequest req = EchoRequest.Factory.newInstance();
    req.setText(text);
    return naidisXRoadDatabase.axisEchoV1(req).getText();
  }
}
