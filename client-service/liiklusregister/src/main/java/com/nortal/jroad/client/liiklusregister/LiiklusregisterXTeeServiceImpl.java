package com.nortal.jroad.client.liiklusregister;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.liiklusregister.database.LiiklusregisterXRoadDatabase;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.MuuDokParing;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.MuuDokVastus;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolIsikudParing;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolIsikudVastus;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolJuhtoigusParing;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolJuhtoigusVastus;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolSoidukParing;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolSoidukVastus;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolYlevParing;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.PolYlevVastus;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.VlaevRequest;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.VlaevResponse;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.VlaevTunnParing;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.VlaevTunnVastus;
import com.nortal.jroad.client.liiklusregister.types.ee.riik.xtee.liiklusregister.producers.producer.liiklusregister.VlaevRequest.OmaAndmed;

/**
 * @author Dmitri Danilkin
 */
@Service("liiklusregisterXTeeService")
public class LiiklusregisterXTeeServiceImpl implements LiiklusregisterXTeeService {

  @Resource
  private LiiklusregisterXRoadDatabase liiklusregisterXRoadDatabase;


  public PolJuhtoigusVastus polJuhtoigus(String isikukood) throws XRoadServiceConsumptionException {
    PolJuhtoigusParing paring = PolJuhtoigusParing.Factory.newInstance();
    paring.setIsikukood(isikukood);
    return liiklusregisterXRoadDatabase.polJuhtoigusV1(paring);
  }

  public PolSoidukVastus findPolSoiduk(PolSoidukParingCallback callback) throws XRoadServiceConsumptionException {

    PolSoidukParing request = PolSoidukParing.Factory.newInstance();
    callback.populate(request);

    return liiklusregisterXRoadDatabase.polSoidukV1(request);
  }

  public PolJuhtoigusVastus findPolJuhtoigus(String isikukood, Long identifikaator)
      throws XRoadServiceConsumptionException {
    PolJuhtoigusParing paring = PolJuhtoigusParing.Factory.newInstance();

    if (isikukood != null)
      paring.setIsikukood(isikukood);
    if (identifikaator != null)
      paring.setId(BigInteger.valueOf(identifikaator));

    return liiklusregisterXRoadDatabase.polJuhtoigusV1(paring);
  }

  public PolYlevVastus findPolYlev(Long identifikaator, String vin) throws XRoadServiceConsumptionException {
    PolYlevParing paring = PolYlevParing.Factory.newInstance();

    if (identifikaator != null)
      paring.setId(BigInteger.valueOf(identifikaator));
    if (vin != null)
      paring.setVinkood(vin);

    return liiklusregisterXRoadDatabase.polYlevV1(paring);
  }

  public PolIsikudVastus findPolIsiku(String isikukood, String eesnimi, String perenimi, Date synniaeg)
      throws XRoadServiceConsumptionException {
    PolIsikudParing paring = PolIsikudParing.Factory.newInstance();

    if (isikukood != null)
      paring.setIsikukood(isikukood);
    if (eesnimi != null)
      paring.setEesnimi(eesnimi);
    if (perenimi != null)
      paring.setPerenimi(perenimi);
    if (synniaeg != null) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(synniaeg);
      paring.setSynniaeg(cal);
    }

    return liiklusregisterXRoadDatabase.polIsikudV1(paring);
  }

  public VlaevResponse findVLaevAndmed(String regNr, String hinKood, String omaKood, String omaNimi, String omaEesnimi) throws XRoadServiceConsumptionException {
	  VlaevRequest paring = VlaevRequest.Factory.newInstance();
	  if (regNr != null)
		  paring.setLaevaRegnr(regNr);
	  if (hinKood != null)
		  paring.setHinKood(hinKood);
	  if (omaKood != null || omaNimi != null || omaEesnimi != null) {
		  OmaAndmed oma = paring.addNewOmaAndmed();
		  if (omaKood != null)
			  oma.setOmaKood(omaKood);
		  if (omaNimi != null)
			  oma.setOmaNimi(omaNimi);
		  if (omaEesnimi != null)
			  oma.setOmaEesnimi(omaEesnimi);
	  }

	  return liiklusregisterXRoadDatabase.vlaevV1(paring);
  }

  public VlaevTunnVastus findVlaevTunnistused(String tunnistusNr, String isikukood, String eesnimi, String perenimi) throws XRoadServiceConsumptionException {
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

  public MuuDokVastus findMuuDok(String eesnimi, String perenimi, String kood, String loaNr) throws XRoadServiceConsumptionException {
    MuuDokParing paring = MuuDokParing.Factory.newInstance();
    paring.setEesnimi(eesnimi);
    paring.setNimi(perenimi);
    paring.setKood(kood);
    paring.setLoaNr(loaNr);

    return liiklusregisterXRoadDatabase.muuDokV1(paring);
  }


  public void setLiiklusregisterXRoadDatabase(LiiklusregisterXRoadDatabase liiklusregisterXTeeService) {
    this.liiklusregisterXRoadDatabase = liiklusregisterXTeeService;
  }
}
