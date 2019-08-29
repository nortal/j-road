package com.nortal.jroad.client.liiklusregister;

import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.MuuDokV2Vastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.TootukassaParingRequest;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.TootukassaParingResponse;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.liiklusregister.database.LiiklusregisterXRoadDatabase;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.MuuDokParing;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.MuuDokVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolIsikudParing;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolIsikudVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolJuhtoigusParing;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolJuhtoigusVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolSoidukParing;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolSoidukVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolYlevParing;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolYlevVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevRequest;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevResponse;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevTunnParing;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevTunnVastus;

/**
 * @author Dmitri Danilkin
 */
@Service("liiklusregisterXRoadService")
public class LiiklusregisterXRoadServiceImpl implements LiiklusregisterXRoadService {

  @Resource
  private LiiklusregisterXRoadDatabase liiklusregisterXRoadDatabase;

  public PolJuhtoigusVastus polJuhtoigus(String isikukood) throws XTeeServiceConsumptionException {
    PolJuhtoigusParing paring = PolJuhtoigusParing.Factory.newInstance();
    paring.setIsikukood(isikukood);
    return liiklusregisterXRoadDatabase.polJuhtoigusV1(paring);
  }

  public PolSoidukVastus findPolSoiduk(PolSoidukParingCallback callback) throws XTeeServiceConsumptionException {

    PolSoidukParing request = PolSoidukParing.Factory.newInstance();
    callback.populate(request);

    return liiklusregisterXRoadDatabase.polSoidukV1(request);
  }

  public PolJuhtoigusVastus findPolJuhtoigus(String isikukood, Long identifikaator)
      throws XTeeServiceConsumptionException {
    PolJuhtoigusParing paring = PolJuhtoigusParing.Factory.newInstance();

    if (isikukood != null)
      paring.setIsikukood(isikukood);
    if (identifikaator != null)
      paring.setId(BigInteger.valueOf(identifikaator));

    return liiklusregisterXRoadDatabase.polJuhtoigusV1(paring);
  }

  public PolYlevVastus findPolYlev(Long identifikaator, String vin) throws XTeeServiceConsumptionException {
    PolYlevParing paring = PolYlevParing.Factory.newInstance();

    if (identifikaator != null)
      paring.setId(BigInteger.valueOf(identifikaator));
    if (vin != null)
      paring.setVinkood(vin);

    return liiklusregisterXRoadDatabase.polYlevV1(paring);
  }

  public PolIsikudVastus findPolIsiku(String isikukood, String eesnimi, String perenimi, Date synniaeg)
      throws XTeeServiceConsumptionException {
    PolIsikudParing paring = PolIsikudParing.Factory.newInstance();

    if (isikukood != null)
      paring.setIsikukood(isikukood);
    if (eesnimi != null)
      paring.setEesnimi(eesnimi);
    if (perenimi != null)
      paring.setPerenimi(perenimi);
    if (synniaeg != null) {
      paring.setSynniaeg(DateFormatUtils.format(synniaeg, "dd.MM.yyyy"));
    }

    return liiklusregisterXRoadDatabase.polIsikudV1(paring);
  }

  public VlaevResponse findVLaevAndmed(String regNr, String hinKood, String omaKood, String omaNimi, String omaEesnimi)
      throws XTeeServiceConsumptionException {
    VlaevRequest paring = VlaevRequest.Factory.newInstance();
    if (regNr != null)
      paring.setLaevaRegnr(regNr);
    if (hinKood != null)
      paring.setHinKood(hinKood);
    if (omaKood != null || omaNimi != null || omaEesnimi != null) {
      VlaevRequest.OmaAndmed oma = paring.addNewOmaAndmed();
      if (omaKood != null)
        oma.setOmaKood(omaKood);
      if (omaNimi != null)
        oma.setOmaNimi(omaNimi);
      if (omaEesnimi != null)
        oma.setOmaEesnimi(omaEesnimi);
    }

    return liiklusregisterXRoadDatabase.vlaevV1(paring);
  }

  public VlaevTunnVastus findVlaevTunnistused(String tunnistusNr, String isikukood, String eesnimi, String perenimi)
      throws XTeeServiceConsumptionException {
    VlaevTunnParing paring = VlaevTunnParing.Factory.newInstance();
    if (tunnistusNr != null) {
      try {
        BigInteger nr = new BigInteger(tunnistusNr);
        paring.setTunnistusNr(nr);
      } catch (NumberFormatException e) {
        //Ignore it
      }
    }
    if (isikukood != null)
      paring.setIsikukood(isikukood);
    if (eesnimi != null)
      paring.setEesnimi(eesnimi);
    if (perenimi != null)
      paring.setPerenimi(perenimi);

    return liiklusregisterXRoadDatabase.vlaevTunnV1(paring);
  }

  public MuuDokVastus findMuuDok(String eesnimi, String perenimi, String kood, String loaNr)
      throws XTeeServiceConsumptionException {
    MuuDokParing paring = MuuDokParing.Factory.newInstance();

    paring.setEesnimi(eesnimi);
    paring.setNimi(perenimi);
    paring.setKood(kood);
    paring.setLoaNr(loaNr);

    return liiklusregisterXRoadDatabase.muuDokV1(paring);
  }

  @Override
  public MuuDokV2Vastus findMuuDokV2(String eesnimi, String perenimi, String kood, String loaNr) throws XTeeServiceConsumptionException {
    MuuDokParing paring = MuuDokParing.Factory.newInstance();

    paring.setEesnimi(eesnimi);
    paring.setNimi(perenimi);
    paring.setKood(kood);
    paring.setLoaNr(loaNr);

    return liiklusregisterXRoadDatabase.muuDokV2V1(paring);
  }

  public TootukassaParingResponse tootukassaParing(String isikukood, String taotluseNr, Date alates, Date kuni)
      throws XTeeServiceConsumptionException {
    TootukassaParingRequest paring = TootukassaParingRequest.Factory.newInstance();

    paring.setKood(isikukood);
    paring.setTaotluseNr(taotluseNr);
    if (alates != null) {
      Calendar calAlates = Calendar.getInstance();
      calAlates.setTime(alates);
      paring.setAlates(calAlates);
    }
    if (kuni != null) {
      Calendar calKuni = Calendar.getInstance();
      calKuni.setTime(kuni);
      paring.setKuni(calKuni);
    }

    return liiklusregisterXRoadDatabase.tootukassaParingV1(paring);
  }

  public void setLiiklusregisterXTeeDatabase(LiiklusregisterXRoadDatabase liiklusregisterXTeeService) {
    this.liiklusregisterXRoadDatabase = liiklusregisterXTeeService;
  }

}