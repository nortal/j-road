package com.nortal.jroad.client.kirst;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.KindlustusalusRequestType.KanneJada;
import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.KindlustusalusResponseType;
import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.Kindlustused2Document.Kindlustused2;
import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.Kindlustused2ResponseDocument.Kindlustused2Response;
import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.KindlustusedResponseDocument.KindlustusedResponse;
import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.KindlustusedResponseType.Kindlustused;
import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.TvlLoetelu2ResponseType;

import java.util.Date;
import java.util.Set;

/**
 * <code>kirst</code> (Kindlustatud Isikute Register) database X-tee service.
 * 
 * @author Roman Tekhov
 */
public interface KirstXTeeService {

  /**
   * <code>kirst.tvl_loetelu2.v1</code> service.
   */
  TvlLoetelu2ResponseType findTvlLoetelu2V1(Set<String> isikukoodid, Date alates, Date kuni)
      throws XTeeServiceConsumptionException;

  /**
   * <code>kirst.kindlustusalus.v2</code> service.
   */
  KindlustusalusResponseType findKindlustusalusV2(KindlustusalusKanneJadaCallback callback)
      throws XTeeServiceConsumptionException;

  /**
   * <code>kirst.kindlustused.v1</code> service.
   */
  KindlustusedResponse findKindlustusV1(XTParingKindlustusedCallback callback) throws XTeeServiceConsumptionException;

  /**
   * Callback for populating the <code>Kindlustusalus.Keha.KanneJada</code> of
   * the {@link #findKindlustusalusV2} request object.
   * 
   * @author Roman Tekhov
   */
  public interface KindlustusalusKanneJadaCallback {

    void populate(KanneJada kanneJada);

  }

  /**
   * Callback for populating the <code>XTParingKindlustused</code> of the
   * {@link #findKindlustusV1} request object.
   */
  public interface XTParingKindlustusedCallback {
    void populate(Kindlustused paringKindlustused);
  }

  Kindlustused2Response findKindlustus2(Kindlustused2 paring) throws XTeeServiceConsumptionException;
}
