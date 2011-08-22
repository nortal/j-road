package ee.webmedia.xtee.client.ads;

import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifParingType.KlassifParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedParingType.MuudatusedParam;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;

public class AdsXTeeServiceImpl extends XTeeDatabaseService implements AdsXTeeService {

  private static final String ADS_KOMPKLASSIF = "ADSkompklassif";
  private static final String ADS_MUUDATUSED = "ADSmuudatused";

  public ADSkompklassifVastusType kompklassifV1(KlassifParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");

    ADSkompklassifParingType request = ADSkompklassifParingType.Factory.newInstance();
    KlassifParam kp = KlassifParam.Factory.newInstance();

    callback.populate(kp);
    request.setKlassifParam(kp);

    XTeeMessage<ADSkompklassifVastusType> response =
        send(new XmlBeansXTeeMessage<ADSkompklassifParingType>(request), ADS_KOMPKLASSIF, "v1");

    return response.getContent();
  }

  public ADSmuudatusedVastusType muudatusedV1(MuudatusedParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");

    ADSmuudatusedParingType request = ADSmuudatusedParingType.Factory.newInstance();
    MuudatusedParam mp = MuudatusedParam.Factory.newInstance();

    callback.populate(mp);
    request.setMuudatusedParam(mp);

    XTeeMessage<ADSmuudatusedVastusType> response =
        send(new XmlBeansXTeeMessage<ADSmuudatusedParingType>(request), ADS_MUUDATUSED, "v1");

    return response.getContent();
  }

}
