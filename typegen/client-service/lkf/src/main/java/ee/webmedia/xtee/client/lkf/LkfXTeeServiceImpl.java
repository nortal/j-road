package ee.webmedia.xtee.client.lkf;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.lkf.database.LkfXTeeDatabase;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.AadressParing;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.AadressVastus;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingParing;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingVastus;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskateParing;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskateVastus;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.RomudeOtsingParing;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.RomudeOtsingVastus;
import java.util.Calendar;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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
