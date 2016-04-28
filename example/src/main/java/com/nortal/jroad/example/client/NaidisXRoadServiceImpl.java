package com.nortal.jroad.example.client;

import javax.activation.DataHandler;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.example.client.database.NaidisXRoadDatabase;
import com.nortal.jroad.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest;
import com.nortal.jroad.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoResponse;
import com.nortal.jroad.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.EchoRequest;
import com.nortal.jroad.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.EchoResponse;
import com.nortal.jroad.jaxb.ByteArrayDataSource;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
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
  public EchoResponse sendEcho(String text) throws XRoadServiceConsumptionException {
    EchoRequest req = EchoRequest.Factory.newInstance();
    req.setText(text);
    return naidisXRoadDatabase.echoV1(req);
  }

  @Override
  public EchoResponse sendAxisEcho(String text) throws XRoadServiceConsumptionException {
    EchoRequest req = EchoRequest.Factory.newInstance();
    req.setText(text);
    return naidisXRoadDatabase.axisEchoV1(req);
  }
}
