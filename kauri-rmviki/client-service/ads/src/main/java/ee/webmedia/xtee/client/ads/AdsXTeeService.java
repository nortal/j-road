package ee.webmedia.xtee.client.ads;

import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifParingType.KlassifParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedParingType.MuudatusedParam;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;

/**
 * <code>ads</code> (Maaameti teenused) database X-tee service.
 */
public interface AdsXTeeService {

  /**
   * <code>ads.kompklassif.v1</code> service.
   */
  ADSkompklassifVastusType kompklassifV1(KlassifParamCallback callback) throws XTeeServiceConsumptionException;

  /**
   * <code>ads.muudatused.v1</code> service.
   */
  ADSmuudatusedVastusType muudatusedV1(MuudatusedParamCallback callback) throws XTeeServiceConsumptionException;

  interface KlassifParamCallback {
    void populate(KlassifParam klassifParam);
  }

  interface MuudatusedParamCallback {
    void populate(MuudatusedParam muudatusedParam);
  }
}
