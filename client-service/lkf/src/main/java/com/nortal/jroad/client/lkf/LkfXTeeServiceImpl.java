package com.nortal.jroad.client.lkf;

import java.util.Calendar;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.lkf.database.LkfXRoadDatabase;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.AadressParing;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.AadressVastus;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingParing;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingVastus;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskateParing;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskateVastus;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.RomudeOtsingParing;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.RomudeOtsingVastus;

@Service("lkfXTeeService")
public class LkfXTeeServiceImpl implements LkfXTeeService {

	@Resource
  private LkfXRoadDatabase lkfXRoadDatabase;


	public KindlustuskateVastus findKindlustuskate(String registrinumber, String tehasetahis) throws XRoadServiceConsumptionException {
		KindlustuskateParing paring = KindlustuskateParing.Factory.newInstance();

		if (registrinumber != null)
			paring.setRegistreerimismark(registrinumber);
		if (tehasetahis != null)
			paring.setTehasetahis(tehasetahis);

		return lkfXRoadDatabase.kindlustuskateV1(paring);
	}

	public AadressVastus findAadress(String isikukood) throws XRoadServiceConsumptionException  {

		AadressParing paring = AadressParing.Factory.newInstance();

		if (isikukood != null)
			paring.setIsikukood(isikukood);

		return lkfXRoadDatabase.aadressV1(paring);
	}

  public RomudeOtsingVastus romudeOtsing(Calendar startDate, Calendar endDate)	throws XRoadServiceConsumptionException {

	  RomudeOtsingParing paring = RomudeOtsingParing.Factory.newInstance();

	  paring.setStartDate(Parser.parseDateTime(startDate));
	  paring.setEndDate(Parser.parseDateTime(endDate));

	  return lkfXRoadDatabase.romudeOtsingV1(paring);
  }

  public KindlustuskaitseOtsingVastus kindlustusKaitseOtsing(KindlustuskaitseOtsingParing paring) throws XRoadServiceConsumptionException {
    return lkfXRoadDatabase.kindlustuskaitseOtsingV2(paring);
  }


  public void setLkfXRoadDatabase(LkfXRoadDatabase lkfXRoadDatabase) {
    this.lkfXRoadDatabase = lkfXRoadDatabase;
  }
}
