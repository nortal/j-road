package com.nortal.jroad.client.karis;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.karis.KarisXTeeServiceImpl;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudVastus;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

public class KarisXTeeServiceImplTest extends BaseXRoadServiceImplTest{

	@Resource
	private KarisXTeeServiceImpl karisXTeeServiceImpl;


	@Test
	public void findKrIsikId() throws XRoadServiceConsumptionException{

		KrIsikIdVastus vastus = karisXTeeServiceImpl.findKrIsikId("11");
		Assertions.assertNotNull(vastus);
		Assertions.assertNotNull(vastus.getIsik().getIsikList());
		Assertions.assertEquals("ARVO", vastus.getIsik().getIsikList().get(0).getTtIsikCEes());
		Assertions.assertEquals("WEEBER", vastus.getIsik().getIsikList().get(0).getTtIsikCPere());
		Assertions.assertNotNull(vastus.getIsik().getIsikList().get(0).getKaristus().getKaristusList().get(0));
		Assertions.assertNotNull(vastus.getIsik().getIsikList().get(0).getKaristus().getKaristusList().get(0).getTtKokkuCAsjaNr());
	}

	@Test
	public void findKrIsik() throws XRoadServiceConsumptionException{

		KrIsikVastus vastus = karisXTeeServiceImpl.findKrIsik("35401130242");
		Assertions.assertNotNull(vastus);
		Assertions.assertNotNull(vastus.getIsik().getIsikList());
		Assertions.assertEquals("ARVO", vastus.getIsik().getIsikList().get(0).getTtIsikCEes());
		Assertions.assertEquals("WEEBER", vastus.getIsik().getIsikList().get(0).getTtIsikCPere());
		Assertions.assertNotNull(vastus.getIsik().getIsikList().get(0).getKaristus().getKaristusList().get(0));
		Assertions.assertNotNull(vastus.getIsik().getIsikList().get(0).getKaristus().getKaristusList().get(0).getTtKokkuCAsjaNr());
	}

	@Test
	public void findKrIsikud() throws XRoadServiceConsumptionException{

		KrIsikudVastus vastus = karisXTeeServiceImpl.findKrIsikud("", "Arvo", "Weeber", "");
		Assertions.assertNotNull(vastus);
		Assertions.assertNotNull(vastus.getTtIsik().getTtIsikList());
		Assertions.assertEquals("EESTI  HARJU MAAKOND  TALLINN", vastus.getTtIsik().getTtIsikList().get(0).getTtIsikCSynnikohtLisa());
		Assertions.assertEquals("35401130242", vastus.getTtIsik().getTtIsikList().get(0).getTtIsikCIkood());

	}






}
