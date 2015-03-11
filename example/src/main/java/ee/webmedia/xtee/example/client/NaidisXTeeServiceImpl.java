package com.nortal.jroad.example.client;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.XTeeDatabaseService;
import com.nortal.jroad.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest;
import com.nortal.jroad.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoResponse;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import javax.activation.DataHandler;

public class NaidisXTeeServiceImpl extends XTeeDatabaseService implements NaidisXTeeService {
  private static String ATTACHMENT_ECHO = "attachmentecho";

  public DataHandler sendAttachment(DataHandler handler) throws XTeeServiceConsumptionException {
    AttachmentEchoRequest request = AttachmentEchoRequest.Factory.newInstance();
    request.addNewNest().setAttachmentHandler(handler);
    XTeeMessage<AttachmentEchoResponse> response =
        send(new XmlBeansXTeeMessage<AttachmentEchoRequest>(request), ATTACHMENT_ECHO);
    return response.getContent().getNest().getAttachmentHandler();
  }
}
