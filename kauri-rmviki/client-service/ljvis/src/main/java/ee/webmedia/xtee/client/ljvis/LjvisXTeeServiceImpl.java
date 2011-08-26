package ee.webmedia.xtee.client.ljvis;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.ljvis.database.LjvisXTeeDatabase;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Response;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVqueryV1Request;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVqueryV1Response;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Tatjana Kulikova
 */
@Service("ljvisXTeeService")
public class LjvisXTeeServiceImpl implements LjvisXTeeService {

  @Resource
  private LjvisXTeeDatabase ljvisXTeeDatabase;

  public ErakorralineYVqueryV1Response erakorralineYlevaatused() throws XTeeServiceConsumptionException {

    ErakorralineYVqueryV1Request request = ErakorralineYVqueryV1Request.Factory.newInstance();

    return ljvisXTeeDatabase.erakorralineYVqueryV1(request);
  }

  public ErakorralineYVconfirmV1Response erakorralineConfirm(ErakorralineYVconfirmV1Request request)
      throws XTeeServiceConsumptionException {

    return ljvisXTeeDatabase.erakorralineYVconfirmV1(request);
  }


  public void setLjvisXTeeDatabase(LjvisXTeeDatabase ljvisXTeeDatabase) {
    this.ljvisXTeeDatabase = ljvisXTeeDatabase;
  }

}
