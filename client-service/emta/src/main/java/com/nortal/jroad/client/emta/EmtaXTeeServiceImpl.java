package com.nortal.jroad.client.emta;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.emta.database.EmtaXTeeDatabase;
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
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * @author Roman Tekhov
 */
@Service("emtaXTeeService")
public class EmtaXTeeServiceImpl implements EmtaXTeeService {

  @Resource
  private EmtaXTeeDatabase emtaXTeeDatabase;


  public List<Periood> findXteeKindlustusV2(String isikukood, Date algkuup, Date loppkuup)
      throws XTeeServiceConsumptionException {

    EmtaKindlustusParing paring = EmtaKindlustusParing.Factory.newInstance();

    DateFormat monthYearDateFormatter = new SimpleDateFormat("MM.yyyy");

    paring.setIsikukood(isikukood);
    paring.setAlgkuup(monthYearDateFormatter.format(algkuup));
    paring.setLoppkuup(monthYearDateFormatter.format(loppkuup));

    return emtaXTeeDatabase.xteeKindlustusV2(paring).getPerioodJada().getPerioodJadaList();
  }

  public List<FieIsikAndmed> findXteeFieAndmed(String isikukood) throws XTeeServiceConsumptionException {

    EmtaFieAndmedParing request = EmtaFieAndmedParing.Factory.newInstance();

    request.setIsikukood(isikukood);

    return emtaXTeeDatabase.xteeFieAndmedV1(request).getFieJada().getItemList();
  }

  public SissetulekResponse findSissetulek(String isikukood, BigInteger aasta) throws XTeeServiceConsumptionException {
    SissetulekRequest request = SissetulekRequest.Factory.newInstance();
    request.setAasta(aasta);
    request.setIsikukood(isikukood);
    return emtaXTeeDatabase.paSissetulekV1(request);
  }

  public VptValjund findXteeVpt(String kood, Calendar millal) throws XTeeServiceConsumptionException {
	 VptSisend request = VptSisend.Factory.newInstance();
	 request.setKood(kood);
	 request.setMillal(millal);
	 return emtaXTeeDatabase.vptV1(request);
  }

  public EmtaFieTooandjadJaSotsmVastus findXteeFieTooandjadJaSotsm(String isikukood, Date algkuup, Date loppkuup) throws XTeeServiceConsumptionException {

    EmtaFieTooandjadJaSotsmParing request = EmtaFieTooandjadJaSotsmParing.Factory.newInstance();

    DateFormat monthYearDateFormatter = new SimpleDateFormat("MM.yyyy");

    request.setIsikukood(isikukood);
    request.setAlgkuup(monthYearDateFormatter.format(algkuup));
    request.setLoppkuup(monthYearDateFormatter.format(loppkuup));

    return emtaXTeeDatabase.xteeFieTooandjadJaSotsmV1(request);
  }

  public void setEmtaXTeeDatabase(EmtaXTeeDatabase emtaXTeeDatabase) {
    this.emtaXTeeDatabase = emtaXTeeDatabase;
  }
}
