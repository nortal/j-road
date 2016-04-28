package com.nortal.jroad.client.ljvis;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.ljvis.database.LjvisXRoadDatabase;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Response;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVqueryV1Request;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVqueryV1Response;

/**
 * @author Tatjana Kulikova
 */
@Service("ljvisXTeeService")
public class LjvisXTeeServiceImpl implements LjvisXTeeService {

  @Resource
  private LjvisXRoadDatabase ljvisXRoadDatabase;

  public ErakorralineYVqueryV1Response erakorralineYlevaatused() throws XRoadServiceConsumptionException {

    ErakorralineYVqueryV1Request request = ErakorralineYVqueryV1Request.Factory.newInstance();

    return ljvisXRoadDatabase.erakorralineYVqueryV1(request);
  }

  public ErakorralineYVconfirmV1Response erakorralineConfirm(ErakorralineYVconfirmV1Request request)
      throws XRoadServiceConsumptionException {

    return ljvisXRoadDatabase.erakorralineYVconfirmV1(request);
  }


  public void setLjvisXRoadDatabase(LjvisXRoadDatabase ljvisXRoadDatabase) {
    this.ljvisXRoadDatabase = ljvisXRoadDatabase;
  }

}
