package com.nortal.jroad.client.mteenus;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.mteenus.database.MteenusXRoadDatabase;
import com.nortal.jroad.client.mteenus.types.ee.riik.xtee.mteenus.producers.producer.mteenus.TeavitusSisu;
import com.nortal.jroad.client.mteenus.types.ee.riik.xtee.mteenus.producers.producer.mteenus.TeavitusVastus;
import com.nortal.jroad.client.service.XRoadDatabaseService;

/**
 * @author Aleksandr.Koltakov
 */
@Service("mteenusXTeeService")
public class MteenusXTeeServiceImpl extends XRoadDatabaseService implements MteenusXTeeService {

  @Resource
  private MteenusXRoadDatabase mteenusXRoadDatabase;

  public TeavitusVastus send(Sms sms) throws XRoadServiceConsumptionException {

    TeavitusSisu sisu = TeavitusSisu.Factory.newInstance();
    sisu.setTeenusId(sms.getTeenusId());
    sisu.setIsikukood(sms.getIsikukood());
    sisu.setSaatjaNumber(sms.getSaatjaNumber());
    sisu.setSisu(sms.getSisu());
    sisu.setKinnitus(sms.isKinnitus());
    sisu.setSaadaWap(sms.isSaadaWap());

    return mteenusXRoadDatabase.smSteavitusV1(sisu);
  }

  public void setMteenusXRoadDatabase(MteenusXRoadDatabase mteenusXRoadDatabase) {
    this.mteenusXRoadDatabase = mteenusXRoadDatabase;
  }
}
