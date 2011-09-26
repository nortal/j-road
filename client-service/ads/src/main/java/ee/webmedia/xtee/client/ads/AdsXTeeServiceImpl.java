package ee.webmedia.xtee.client.ads;

import ee.webmedia.xtee.client.ads.database.AdsXTeeDatabase;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifParingType.KlassifParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedParingType.MuudatusedParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedVastusType;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("adsXTeeService")
public class AdsXTeeServiceImpl extends XTeeDatabaseService implements AdsXTeeService {

  @Resource
  private AdsXTeeDatabase adsXTeeDatabase;

  public ADSkompklassifVastusType kompklassifV1(KlassifParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");

    ADSkompklassifParingType request = ADSkompklassifParingType.Factory.newInstance();
    KlassifParam kp = KlassifParam.Factory.newInstance();

    callback.populate(kp);
    request.setKlassifParam(kp);

    return adsXTeeDatabase.adSkompklassifV1(request);
  }

  public ADSmuudatusedVastusType muudatusedV1(MuudatusedParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");

    ADSmuudatusedParingType request = ADSmuudatusedParingType.Factory.newInstance();
    MuudatusedParam mp = MuudatusedParam.Factory.newInstance();

    callback.populate(mp);
    request.setMuudatusedParam(mp);

    return adsXTeeDatabase.adSmuudatusedV1(request);
  }


  public void setAdsXTeeDatabase(AdsXTeeDatabase adsXTeeDatabase) {
    this.adsXTeeDatabase = adsXTeeDatabase;
  }

}
