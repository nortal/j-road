package com.nortal.jroad.client.liiklusregister;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.liiklusregister.database.LiiklusregisterXTeeDatabase;
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
  private LiiklusregisterXTeeDatabase liiklusregisterXTeeDatabase;


  public PolJuhtoigusVastus polJuhtoigus(String isikukood) throws XTeeServiceConsumptionException {
    PolJuhtoigusParing paring = PolJuhtoigusParing.Factory.newInstance();
    paring.setIsikukood(isikukood);
    return liiklusregisterXTeeDatabase.polJuhtoigusV1(paring);
  }

  public PolSoidukVastus findPolSoiduk(PolSoidukParingCallback callback) throws XTeeServiceConsumptionException {

    PolSoidukParing request = PolSoidukParing.Factory.newInstance();
    callback.populate(request);

    return liiklusregisterXTeeDatabase.polSoidukV1(request);
  }

  public PolJuhtoigusVastus findPolJuhtoigus(String isikukood, Long identifikaator)
      throws XTeeServiceConsumptionException {
    PolJuhtoigusParing paring = PolJuhtoigusParing.Factory.newInstance();

    if (isikukood != null)
      paring.setIsikukood(isikukood);
    if (identifikaator != null)
      paring.setId(BigInteger.valueOf(identifikaator));

    return liiklusregisterXTeeDatabase.polJuhtoigusV1(paring);
  }

  public PolYlevVastus findPolYlev(Long identifikaator, String vin) throws XTeeServiceConsumptionException {
    PolYlevParing paring = PolYlevParing.Factory.newInstance();

    if (identifikaator != null)
      paring.setId(BigInteger.valueOf(identifikaator));
    if (vin != null)
      paring.setVinkood(vin);

    return liiklusregisterXTeeDatabase.polYlevV1(paring);
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
      Calendar cal = Calendar.getInstance();
      cal.setTime(synniaeg);
      paring.setSynniaeg(cal);
    }

    return liiklusregisterXTeeDatabase.polIsikudV1(paring);
  }

  public VlaevResponse findVLaevAndmed(String regNr, String hinKood, String omaKood, String omaNimi, String omaEesnimi) throws XTeeServiceConsumptionException {
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

	  return liiklusregisterXTeeDatabase.vlaevV1(paring);
  }

  public VlaevTunnVastus findVlaevTunnistused(String tunnistusNr, String isikukood, String eesnimi, String perenimi) throws XTeeServiceConsumptionException {
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

	  return liiklusregisterXTeeDatabase.vlaevTunnV1(paring);
  }

  public MuuDokVastus findMuuDok(String eesnimi, String perenimi, String kood, String loaNr) throws XTeeServiceConsumptionException {
    MuuDokParing paring = MuuDokParing.Factory.newInstance();
    paring.setEesnimi(eesnimi);
    paring.setNimi(perenimi);
    paring.setKood(kood);
    paring.setLoaNr(loaNr);

    return liiklusregisterXTeeDatabase.muuDokV1(paring);
  }


  public void setLiiklusregisterXTeeDatabase(LiiklusregisterXTeeDatabase liiklusregisterXTeeService) {
    this.liiklusregisterXTeeDatabase = liiklusregisterXTeeService;
  }
}
