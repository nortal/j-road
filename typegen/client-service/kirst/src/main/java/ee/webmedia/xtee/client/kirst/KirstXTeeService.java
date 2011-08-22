package ee.webmedia.xtee.client.kirst;

import ee.webmedia.xtee.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTKehaKindlustused2;
import ee.webmedia.xtee.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTParingKindlustused2;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTKehaKindlustusalus;
import ee.webmedia.xtee.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTKehaKindlustused;
import ee.webmedia.xtee.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTParingKindlustusalus;
import ee.webmedia.xtee.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTParingKindlustused;

/**
 * <code>kirst</code> (Kindlustatud Isikute Register) database X-tee service.
 * 
 * @author Roman Tekhov
 */
public interface KirstXTeeService {

  /**
   * <code>kirst.kindlustusalus.v2</code> service.
   */
  XTKehaKindlustusalus findKindlustusalusV2(KindlustusalusKanneJadaCallback callback)
      throws XTeeServiceConsumptionException;

  /**
   * <code>kirst.kindlustused.v1</code> service.
   */
  XTKehaKindlustused findKindlustusV1(XTParingKindlustusedCallback callback) throws XTeeServiceConsumptionException;

  /**
   * Callback for populating the <code>Kindlustusalus.Keha.KanneJada</code> of the {@link #findKindlustusalusV2} request
   * object.
   * 
   * @author Roman Tekhov
   */
  public interface KindlustusalusKanneJadaCallback {

    void populate(XTParingKindlustusalus.KanneJada kanneJada);

  }

  /**
   * Callback for populating the <code>XTParingKindlustused</code> of the {@link #findKindlustusV1} request object.
   */
  public interface XTParingKindlustusedCallback {
    void populate(XTParingKindlustused paringKindlustused);
  }
  
  XTKehaKindlustused2 findKindlustus2(XTParingKindlustused2 paring) throws XTeeServiceConsumptionException;

}
