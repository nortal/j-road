package ee.webmedia.xtee.client.mteenus;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.mteenus.database.MteenusXTeeDatabase;
import ee.webmedia.xtee.client.mteenus.types.ee.riik.xtee.mteenus.producers.producer.mteenus.TeavitusSisu;
import ee.webmedia.xtee.client.mteenus.types.ee.riik.xtee.mteenus.producers.producer.mteenus.TeavitusVastus;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Aleksandr.Koltakov
 */
@Service("mteenusXTeeService")
public class MteenusXTeeServiceImpl extends XTeeDatabaseService implements MteenusXTeeService {

  @Resource
  private MteenusXTeeDatabase mteenusXTeeDatabase;

  public TeavitusVastus send(Sms sms) throws XTeeServiceConsumptionException {

    TeavitusSisu sisu = TeavitusSisu.Factory.newInstance();
    sisu.setTeenusId(sms.getTeenusId());
    sisu.setIsikukood(sms.getIsikukood());
    sisu.setSaatjaNumber(sms.getSaatjaNumber());
    sisu.setSisu(sms.getSisu());
    sisu.setKinnitus(sms.isKinnitus());
    sisu.setSaadaWap(sms.isSaadaWap());

    return mteenusXTeeDatabase.smSteavitusV1(sisu);
  }

  public void setMteenusXTeeDatabase(MteenusXTeeDatabase mteenusXTeeDatabase) {
    this.mteenusXTeeDatabase = mteenusXTeeDatabase;
  }
}
