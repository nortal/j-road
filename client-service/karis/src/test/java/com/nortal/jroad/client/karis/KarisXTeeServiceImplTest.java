package com.nortal.jroad.client.karis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.Assert;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.karis.KarisXTeeServiceImpl;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudVastus;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

public class KarisXTeeServiceImplTest extends BaseXTeeServiceImplTest{

	@Resource
	private KarisXTeeServiceImpl karisXTeeServiceImpl;
	
	
	@Test
	public void findKrIsikId() throws XRoadServiceConsumptionException{
		
		KrIsikIdVastus vastus = karisXTeeServiceImpl.findKrIsikId("11");
		Assert.assertNotNull(vastus);
		Assert.assertNotNull(vastus.getIsik().getIsikList());
		Assert.assertEquals("ARVO", vastus.getIsik().getIsikList().get(0).getTtIsikCEes());
		Assert.assertEquals("WEEBER", vastus.getIsik().getIsikList().get(0).getTtIsikCPere());
		Assert.assertNotNull(vastus.getIsik().getIsikList().get(0).getKaristus().getKaristusList().get(0));
		Assert.assertNotNull(vastus.getIsik().getIsikList().get(0).getKaristus().getKaristusList().get(0).getTtKokkuCAsjaNr());
	}
	
	@Test
	public void findKrIsik() throws XRoadServiceConsumptionException{
		
		KrIsikVastus vastus = karisXTeeServiceImpl.findKrIsik("35401130242");
		Assert.assertNotNull(vastus);
		Assert.assertNotNull(vastus.getIsik().getIsikList());
		Assert.assertEquals("ARVO", vastus.getIsik().getIsikList().get(0).getTtIsikCEes());
		Assert.assertEquals("WEEBER", vastus.getIsik().getIsikList().get(0).getTtIsikCPere());
		Assert.assertNotNull(vastus.getIsik().getIsikList().get(0).getKaristus().getKaristusList().get(0));
		Assert.assertNotNull(vastus.getIsik().getIsikList().get(0).getKaristus().getKaristusList().get(0).getTtKokkuCAsjaNr());
	}
	
	@Test
	public void findKrIsikud() throws XRoadServiceConsumptionException{
		
		KrIsikudVastus vastus = karisXTeeServiceImpl.findKrIsikud("", "Arvo", "Weeber", "");
		Assert.assertNotNull(vastus);
		Assert.assertNotNull(vastus.getTtIsik().getTtIsikList());
		Assert.assertEquals("EESTI  HARJU MAAKOND  TALLINN", vastus.getTtIsik().getTtIsikList().get(0).getTtIsikCSynnikohtLisa());
		Assert.assertEquals("35401130242", vastus.getTtIsik().getTtIsikList().get(0).getTtIsikCIkood());
		
	}
	
	
	
	
	
	
}
