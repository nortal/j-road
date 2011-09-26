package ee.webmedia.xtee.client.emta;

import ee.webmedia.xtee.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.FieIsikAndmed;
import ee.webmedia.xtee.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.Periood;
import ee.webmedia.xtee.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.SissetulekResponse;
import ee.webmedia.xtee.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.VptValjund;
import java.util.Calendar;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * <code>emta</code> (Maksu- ja Tolliamet) database X-tee service.
 * 
 * @author Roman Tekhov
 * @author Dmitri Danilkin
 */
public interface EmtaXTeeService {

  /**
   * <code>emta.xteeKindlustus.v2</code> service.
   */
  List<Periood> findXteeKindlustusV2(String isikukood, Date algkuup, Date loppkuup)
      throws XTeeServiceConsumptionException;

  /**
   * <code>emta.xteeFieAndmed.v1</code> service.
   */
  List<FieIsikAndmed> findXteeFieAndmed(String isikukood) throws XTeeServiceConsumptionException;
  
  /**
   * <code>emta.xteeFieAndmed.v1</code> service.
   */
  SissetulekResponse findSissetulek(String isikukood, BigInteger aasta) throws XTeeServiceConsumptionException;
  
  /**
   * <code>emta.vpt.v1</code> service.
   */
  VptValjund findXteeVpt(String kood, Calendar millal) throws XTeeServiceConsumptionException;
}
