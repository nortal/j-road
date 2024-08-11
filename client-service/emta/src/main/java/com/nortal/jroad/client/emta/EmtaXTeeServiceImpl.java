package com.nortal.jroad.client.emta;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.emta.database.EmtaXRoadDatabase;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.EmtaFieAndmedParing;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.EmtaFieTooandjadJaSotsmParing;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.EmtaFieTooandjadJaSotsmVastus;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.EmtaKindlustusParing;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.FieIsikAndmed;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.Periood;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.SissetulekRequest;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.SissetulekResponse;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.VptSisend;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.VptValjund;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

/**
 * @author Roman Tekhov
 */
@Service("emtaXTeeService")
public class EmtaXTeeServiceImpl implements EmtaXTeeService {

  @Resource
  private EmtaXRoadDatabase emtaXRoadDatabase;


  public List<Periood> findXteeKindlustusV2(String isikukood, Date algkuup, Date loppkuup)
      throws XRoadServiceConsumptionException {

    EmtaKindlustusParing paring = EmtaKindlustusParing.Factory.newInstance();

    DateFormat monthYearDateFormatter = new SimpleDateFormat("MM.yyyy");

    paring.setIsikukood(isikukood);
    paring.setAlgkuup(monthYearDateFormatter.format(algkuup));
    paring.setLoppkuup(monthYearDateFormatter.format(loppkuup));

    return emtaXRoadDatabase.xteeKindlustusV2(paring).getPerioodJada().getPerioodJadaList();
  }

  public List<FieIsikAndmed> findXteeFieAndmed(String isikukood) throws XRoadServiceConsumptionException {

    EmtaFieAndmedParing request = EmtaFieAndmedParing.Factory.newInstance();

    request.setIsikukood(isikukood);

    return emtaXRoadDatabase.xteeFieAndmedV1(request).getFieJada().getItemList();
  }

  public SissetulekResponse findSissetulek(String isikukood, BigInteger aasta) throws XRoadServiceConsumptionException {
    SissetulekRequest request = SissetulekRequest.Factory.newInstance();
    request.setAasta(aasta);
    request.setIsikukood(isikukood);
    return emtaXRoadDatabase.paSissetulekV1(request);
  }

  public VptValjund findXteeVpt(String kood, Calendar millal) throws XRoadServiceConsumptionException {
	 VptSisend request = VptSisend.Factory.newInstance();
	 request.setKood(kood);
	 request.setMillal(millal);
	 return emtaXRoadDatabase.vptV1(request);
  }

  public EmtaFieTooandjadJaSotsmVastus findXteeFieTooandjadJaSotsm(String isikukood, Date algkuup, Date loppkuup) throws XRoadServiceConsumptionException {

    EmtaFieTooandjadJaSotsmParing request = EmtaFieTooandjadJaSotsmParing.Factory.newInstance();

    DateFormat monthYearDateFormatter = new SimpleDateFormat("MM.yyyy");

    request.setIsikukood(isikukood);
    request.setAlgkuup(monthYearDateFormatter.format(algkuup));
    request.setLoppkuup(monthYearDateFormatter.format(loppkuup));

    return emtaXRoadDatabase.xteeFieTooandjadJaSotsmV1(request);
  }

  public void setEmtaXRoadDatabase(EmtaXRoadDatabase emtaXRoadDatabase) {
    this.emtaXRoadDatabase = emtaXRoadDatabase;
  }
}
