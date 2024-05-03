package com.nortal.jroad.client.vangis;

import java.util.Calendar;

import jakarta.annotation.Resource;






import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import com.nortal.jroad.client.vangis.VangisXTeeServiceImpl;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.KaristuseKohtVastus;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring16Vastus;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring2Vastus;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring5Vastus;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring8Vastus;

public class VangisXTeeServiceImplTest extends BaseXRoadServiceImplTest{

	@Resource
	private VangisXTeeServiceImpl vangisXTeeServiceImpl;


	@Test
	public void karistuse_koht() throws XRoadServiceConsumptionException {
		Calendar synniKp = Calendar.getInstance();
		synniKp.set(1988, 5, 4);
		KaristuseKohtVastus vastus = vangisXTeeServiceImpl.karistuse_koht(null, "Markko", "Kapp", synniKp);
		Assertions.assertEquals("Markko",vastus.getEesnimi());

	}

	@Test
	public void paring2() throws XRoadServiceConsumptionException {
		Paring2Vastus vastus = vangisXTeeServiceImpl.paring2(null, "Markko", "Kapp", null);
		Assertions.assertNotNull(vastus.getKinnipeetavadJada().getItemList().get(0));

	}

	@Test
	public void paring5() throws XRoadServiceConsumptionException {
		Calendar algus =  Calendar.getInstance();
		algus.set(2011, 0, 11);
		Calendar lopp =  Calendar.getInstance();
		lopp.set(2011, 0, 12);
		Paring5Vastus vastus = vangisXTeeServiceImpl.paring5(algus, lopp, null);
		Assertions.assertNotNull(vastus.getKinnipeetavadJada().getItemList().get(0));

	}

	@Test
	public void paring8() throws XRoadServiceConsumptionException {
		Calendar algus =  Calendar.getInstance();
		algus.set(2011, 0, 1);
		Calendar lopp =  Calendar.getInstance();
		lopp.set(2011, 0, 11);
		Paring8Vastus vastus = vangisXTeeServiceImpl.paring8("V", algus, lopp, null,null,null,null);
		Assertions.assertNotNull(vastus.getKinnipeetavadJada().getItemList().get(0));

	}

	@Test
	public void paring16() throws XRoadServiceConsumptionException {
		Paring16Vastus vastus = vangisXTeeServiceImpl.paring16(null, "Markko", "Kapp");
		Assertions.assertNotNull(vastus.getKinnipeetavJada().getItemList().get(0));

	}




}
