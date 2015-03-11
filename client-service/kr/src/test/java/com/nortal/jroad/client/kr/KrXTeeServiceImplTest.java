package com.nortal.jroad.client.kr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuDetailMaVastus;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuJadaItem;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuVastus;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KpijIsikType;
import com.nortal.jroad.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.PolitseiEhakVastus;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Allar Saarnak
 */
public class KrXTeeServiceImplTest extends BaseXTeeServiceImplTest {

	@Resource
	private KrXTeeServiceImpl krXTeeServiceImpl;

	@Test
	public void findKinnistuV2() throws XTeeServiceConsumptionException {

		String katastritunnus = "13402:002:0250";

		KinnistuVastus response = krXTeeServiceImpl.findKinnistuV2(katastritunnus);

		Assert.assertNotNull(response);
	}

	@Test
	public void findKpijV2() throws XTeeServiceConsumptionException {

		String eesnimi = "Teo";
		String perenimi_juriidilinenimi = "Niklus";
		String isikukood = null;
		Calendar synniaeg = Calendar.getInstance();
		synniaeg.set(1978, 3, 1);

		List<KpijIsikType> isikList = 
			krXTeeServiceImpl.findKpijV2(eesnimi,perenimi_juriidilinenimi, isikukood, synniaeg);

		Assert.assertNotNull(isikList);
	}

	 @Test
	public void findPolitseiEhakV2() throws XTeeServiceConsumptionException {

		PolitseiEhakVastus vastus = krXTeeServiceImpl.findPolitseiEhakV2(86L, 143L, 3214L, null, null, "8614332140000000079V7000000000000", null);
		
		List<KinnistuJadaItem> itemList = vastus.getKinnistuJada().getItemList();
		
		Assert.assertNotNull(vastus.getKinnistuJada());
		Assert.assertNotNull(itemList);
	}
	
	 @Test
	public void findKinnstuDetailMa() throws XTeeServiceConsumptionException {

		KinnistuDetailMaVastus vastus = krXTeeServiceImpl.findKinnstuDetailMa("1315141", true);
		Assert.assertNotNull(vastus.getNimi());
		Assert.assertEquals(vastus.getKinnistuLiik(), "Kinnisasi");
  }
	
}
