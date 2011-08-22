package ee.webmedia.xtee.client.liiklusregister;

import java.util.Date;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.MuuDokVastus;
import ee.webmedia.xtee.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolIsikudVastus;
import ee.webmedia.xtee.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolJuhtoigusVastus;
import ee.webmedia.xtee.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolSoidukParing;
import ee.webmedia.xtee.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolSoidukVastus;
import ee.webmedia.xtee.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolYlevVastus;
import ee.webmedia.xtee.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.VlaevResponse;
import ee.webmedia.xtee.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.VlaevTunnVastus;

/**
 * <code>liiklusregister</code> (ARK teenused) database X-tee service.
 */
public interface LiiklusregisterXTeeService {

  /**
   * <code>liiklusregister.pol_soiduk.v1</code> service.
   */
  PolSoidukVastus findPolSoiduk(PolSoidukParingCallback callback) throws XTeeServiceConsumptionException;

  /**
   * <code>liiklusregister.pol_juhtoigus.v1</code> service.
   */
  PolJuhtoigusVastus findPolJuhtoigus(String isikukood, Long identifikaator) throws XTeeServiceConsumptionException;

  /**
   * <code>liiklusregister.pol_ylev.v1</code> service.
   */
  PolYlevVastus findPolYlev(Long identifikaator, String vin) throws XTeeServiceConsumptionException;

  /**
   * <code>liiklusregister.pol_isikud.v1</code> service.
   */
  PolIsikudVastus findPolIsiku(String isikukood, String eesnimi, String perenimi, Date synniaeg)
      throws XTeeServiceConsumptionException;
  
  MuuDokVastus findMuuDok(String eesnimi, String perenimi, String kood, String loaNr) throws XTeeServiceConsumptionException;
  
  /**
   * <code>liiklusregister.vlaev.v1</code>
   */
  VlaevResponse findVLaevAndmed(String regNr, String hinKood, String omaKood, String omaNimi, String omaEesnimi) throws XTeeServiceConsumptionException;

  VlaevTunnVastus findVlaevTunnistused(String tunnistusNr, String isikukood, String eesnimi, String perenimi) throws XTeeServiceConsumptionException;
  
  
  public interface PolSoidukParingCallback {
    void populate(PolSoidukParing paring);
  }
}
