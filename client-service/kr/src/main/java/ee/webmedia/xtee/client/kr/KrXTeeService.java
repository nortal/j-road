package ee.webmedia.xtee.client.kr;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuDetailMaVastus;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuVastus;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KpijIsikType;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KpijVastus;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.PolitseiEhakVastus;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

/**
 * <code>kr</code> (Kinnisturegister) database X-tee service.
 *
 * @author Allar Saarnak
 */
public interface KrXTeeService {

  /**
   * <code>kr.kinnistu.v2</code> service.
   */
  KinnistuVastus findKinnistuV2(String katastritunnus) throws XTeeServiceConsumptionException, IllegalArgumentException;

  /**
   * <code>kr.kinnistu_paring_isiku_jargi.v2</code> service.
   */
  List<KpijIsikType> findKpijV2(String eesnimi, String perenimiJuriidilinenimi, String isikukood, Calendar synniaeg) throws XTeeServiceConsumptionException, IllegalArgumentException;

  /**
   * <code>kr.kinnistu_paring_isiku_jargi.v2</code> service.
   */
  KpijVastus findKpijVastusV2(String eesnimi, String perenimiJuriidilinenimi, String isikukood, Calendar synniaeg) throws XTeeServiceConsumptionException, IllegalArgumentException;

  /**
   * <code>kr.politsei_ehak.v2</code> service.
   * @param maakond EhakKood
   * @param vald EhakKood
   * @param kyla EhakKood
   * @param aadress
   * @param korter
   * @param koodaadress
   * @param adrId
   * @return
   */
  PolitseiEhakVastus findPolitseiEhakV2(Long maakond, Long vald, Long kyla, String aadress, String korter, String koodaadress, BigInteger adrId) throws XTeeServiceConsumptionException;

  /**
   * <code>kinnistu_detail_ma.v2</code>
   */
  KinnistuDetailMaVastus findKinnstuDetailMa(String registriosaNr, Boolean kehtivus) throws XTeeServiceConsumptionException;
}
