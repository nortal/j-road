package com.nortal.jroad.client.liiklusregister;

import java.util.Date;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.MuuDokV2Vastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.MuuDokVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolIsikudVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolJuhtoigusVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolSoidukParing;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolSoidukVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolYlevVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.TootukassaParingResponse;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevResponse;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevTunnVastus;

/**
 * <code>liiklusregister</code> (ARK teenused) database X-tee service.
 */
public interface LiiklusregisterXRoadService {

  /**
   * <code>liiklusregister.pol_soiduk.v1</code> service.
   */
  PolSoidukVastus findPolSoiduk(PolSoidukParingCallback callback) throws XRoadServiceConsumptionException;

  /**
   * <code>liiklusregister.pol_juhtoigus.v1</code> service.
   */
  PolJuhtoigusVastus findPolJuhtoigus(String isikukood, Long identifikaator) throws XRoadServiceConsumptionException;

  /**
   * <code>liiklusregister.pol_ylev.v1</code> service.
   */
  PolYlevVastus findPolYlev(Long identifikaator, String vin) throws XRoadServiceConsumptionException;

  /**
   * <code>liiklusregister.pol_isikud.v1</code> service.
   */
  PolIsikudVastus findPolIsiku(String isikukood, String eesnimi, String perenimi, Date synniaeg)
      throws XRoadServiceConsumptionException;

  MuuDokVastus findMuuDok(String eesnimi, String perenimi, String kood, String loaNr) throws XRoadServiceConsumptionException;

  MuuDokV2Vastus findMuuDokV2(String eesnimi, String perenimi, String kood, String loaNr) throws XRoadServiceConsumptionException;

  /**
   * <code>liiklusregister.vlaev.v1</code>
   */
  VlaevResponse findVLaevAndmed(String regNr, String hinKood, String omaKood, String omaNimi, String omaEesnimi) throws XRoadServiceConsumptionException;

  VlaevTunnVastus findVlaevTunnistused(String tunnistusNr, String isikukood, String eesnimi, String perenimi) throws XRoadServiceConsumptionException;

  /**
   * <code>liiklusregister.pol_juhtoigus.v1</code> X-tee service implementation.
   */
  PolJuhtoigusVastus polJuhtoigus(String isikukood) throws XRoadServiceConsumptionException;

  public interface PolSoidukParingCallback {
    void populate(PolSoidukParing paring);
  }

  /**
   * <code>liiklusregister.tootukassaParing.v1</code> X-tee service implementation.
   */
  TootukassaParingResponse tootukassaParing(String isikukood, String taotluseNr, Date alates, Date kuni) throws XRoadServiceConsumptionException;
}
