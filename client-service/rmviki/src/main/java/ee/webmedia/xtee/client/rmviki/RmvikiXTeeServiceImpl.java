package ee.webmedia.xtee.client.rmviki;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.rmviki.database.RmvikiXTeeDatabase;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaRequestType;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaResponseType;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Kauri Kägo (kauri@webmedia.ee)
 */
@Service("rmvikiXTeeService")
public class RmvikiXTeeServiceImpl implements RmvikiXTeeService {

  @Resource
  private RmvikiXTeeDatabase rmvikiXTeeDatabase;

  public void setRmvikiXTeeDatabase(RmvikiXTeeDatabase rmvikiXTeeDatabase) {
    this.rmvikiXTeeDatabase = rmvikiXTeeDatabase;
  }

  public ZRKOVARResponse zRKOVARV1(String kood) throws XTeeServiceConsumptionException {
    ZRKOVARRequest req = ZRKOVARRequest.Factory.newInstance();
    req.setKOOD(kood);
    return rmvikiXTeeDatabase.zRKOVARV1(req);
  }

  public ZRKOVAR getZrkovarFromResponse(ZRKOVARResponse response) {
    for (ZRKOVAR zrkovar : response.getISIKUD().getItemList()) {
      if (!StringUtils.isEmpty(zrkovar.getKOOD())) {
        return zrkovar;
      }
    }
    return null;
  }
  
  public RarVtaResponseType rarVtaV1(String kood) throws XTeeServiceConsumptionException {
    RarVtaRequestType req = RarVtaRequestType.Factory.newInstance();
    req.setKood(kood);
    return rmvikiXTeeDatabase.rarVtaV1(req);
  }
}
