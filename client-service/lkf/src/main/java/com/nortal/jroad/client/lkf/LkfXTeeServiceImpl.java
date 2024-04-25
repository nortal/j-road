package com.nortal.jroad.client.lkf;

import java.util.Calendar;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.lkf.database.LkfXTeeDatabase;
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
  private LkfXTeeDatabase lkfXTeeDatabase;


	public KindlustuskateVastus findKindlustuskate(String registrinumber, String tehasetahis) throws XTeeServiceConsumptionException {
		KindlustuskateParing paring = KindlustuskateParing.Factory.newInstance();

		if (registrinumber != null)
			paring.setRegistreerimismark(registrinumber);
		if (tehasetahis != null)
			paring.setTehasetahis(tehasetahis);

		return lkfXTeeDatabase.kindlustuskateV1(paring);
	}

	public AadressVastus findAadress(String isikukood) throws XTeeServiceConsumptionException  {

		AadressParing paring = AadressParing.Factory.newInstance();

		if (isikukood != null)
			paring.setIsikukood(isikukood);

		return lkfXTeeDatabase.aadressV1(paring);
	}

  public RomudeOtsingVastus romudeOtsing(Calendar startDate, Calendar endDate)	throws XTeeServiceConsumptionException {

	  RomudeOtsingParing paring = RomudeOtsingParing.Factory.newInstance();

	  paring.setStartDate(Parser.parseDateTime(startDate));
	  paring.setEndDate(Parser.parseDateTime(endDate));

	  return lkfXTeeDatabase.romudeOtsingV1(paring);
  }

  public KindlustuskaitseOtsingVastus kindlustusKaitseOtsing(KindlustuskaitseOtsingParing paring) throws XTeeServiceConsumptionException {
    return lkfXTeeDatabase.kindlustuskaitseOtsingV2(paring);
  }


  public void setLkfXTeeDatabase(LkfXTeeDatabase lkfXTeeDatabase) {
    this.lkfXTeeDatabase = lkfXTeeDatabase;
  }
}
