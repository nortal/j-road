package com.nortal.jroad.client.rmviki;

import jakarta.annotation.Resource;

import com.nortal.jroad.client.rmviki.database.RmvikiXRoadDatabase;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaRequestType;
import com.nortal.jroad.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaResponseType;
import com.nortal.jroad.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR;
import com.nortal.jroad.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest;
import com.nortal.jroad.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse;

/**
 * @author Kauri Kägo (kauri@nortal.com)
 */
@Service("rmvikiXTeeService")
public class RmvikiXTeeServiceImpl implements RmvikiXTeeService {

  @Resource
  private RmvikiXRoadDatabase rmvikiXTeeDatabase;

  public void setRmvikiXTeeDatabase(RmvikiXRoadDatabase rmvikiXTeeDatabase) {
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
