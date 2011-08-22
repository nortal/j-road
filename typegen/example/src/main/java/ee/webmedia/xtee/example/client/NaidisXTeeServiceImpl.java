package ee.webmedia.xtee.example.client;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoRequest;
import ee.webmedia.xtee.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoResponse;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;
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
