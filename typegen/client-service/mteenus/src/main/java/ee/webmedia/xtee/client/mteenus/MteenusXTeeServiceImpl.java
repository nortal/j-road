package ee.webmedia.xtee.client.mteenus;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.mteenus.types.ee.riik.xtee.mteenus.producers.producer.mteenus.TeavitusSisu;
import ee.webmedia.xtee.client.mteenus.types.ee.riik.xtee.mteenus.producers.producer.mteenus.TeavitusVastus;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;

/**
 * @author Aleksandr.Koltakov
 */
public class MteenusXTeeServiceImpl extends XTeeDatabaseService implements MteenusXTeeService {

  public TeavitusVastus send(Sms sms) throws XTeeServiceConsumptionException {

    TeavitusSisu sisu = TeavitusSisu.Factory.newInstance();
    sisu.setTeenusId(sms.getTeenusId());
    sisu.setIsikukood(sms.getIsikukood());
    sisu.setSaatjaNumber(sms.getSaatjaNumber());
    sisu.setSisu(sms.getSisu());
    sisu.setKinnitus(sms.isKinnitus());
    sisu.setSaadaWap(sms.isSaadaWap());

    XTeeMessage<TeavitusVastus> response = send(new XmlBeansXTeeMessage<TeavitusSisu>(sisu), "SMSteavitus");
    return response.getContent();
  }
}
