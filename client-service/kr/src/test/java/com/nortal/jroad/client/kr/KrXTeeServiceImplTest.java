package com.nortal.jroad.client.kr;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuDetailMaVastus;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuJadaItem;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuVastus;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KpijIsikType;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.PolitseiEhakVastus;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import java.util.Calendar;
import java.util.List;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Allar Saarnak
 */
public class KrXTeeServiceImplTest extends BaseXRoadServiceImplTest {

	@Resource
	private KrXTeeServiceImpl krXTeeServiceImpl;

	@Test
	public void findKinnistuV2() throws XRoadServiceConsumptionException {

		String katastritunnus = "13402:002:0250";

		KinnistuVastus response = krXTeeServiceImpl.findKinnistuV2(katastritunnus);

		Assertions.assertNotNull(response);
	}

	@Test
	public void findKpijV2() throws XRoadServiceConsumptionException {

		String eesnimi = "Teo";
		String perenimi_juriidilinenimi = "Niklus";
		String isikukood = null;
		Calendar synniaeg = Calendar.getInstance();
		synniaeg.set(1978, 3, 1);

		List<KpijIsikType> isikList = 
			krXTeeServiceImpl.findKpijV2(eesnimi,perenimi_juriidilinenimi, isikukood, synniaeg);

		Assertions.assertNotNull(isikList);
	}

	 @Test
	public void findPolitseiEhakV2() throws XRoadServiceConsumptionException {

		PolitseiEhakVastus vastus = krXTeeServiceImpl.findPolitseiEhakV2(86L, 143L, 3214L, null, null, "8614332140000000079V7000000000000", null);
		
		List<KinnistuJadaItem> itemList = vastus.getKinnistuJada().getItemList();
		
		Assertions.assertNotNull(vastus.getKinnistuJada());
		Assertions.assertNotNull(itemList);
	}
	
	 @Test
	public void findKinnstuDetailMa() throws XRoadServiceConsumptionException {

		KinnistuDetailMaVastus vastus = krXTeeServiceImpl.findKinnstuDetailMa("1315141", true);
		Assertions.assertNotNull(vastus.getNimi());
		Assertions.assertEquals(vastus.getKinnistuLiik(), "Kinnisasi");
  }
	
}
