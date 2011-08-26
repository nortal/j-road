package ee.webmedia.xtee.client.rmviki.database;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;

/**
 * <code>rmviki</code> X-tee database.
 */
public interface RmvikiXTeeDatabase {

  /**
   * <code>rmviki.Z_RKOVAR.v1</code> X-tee service.
   */
  ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse zRKOVARV1(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest input) throws XTeeServiceConsumptionException;

}
