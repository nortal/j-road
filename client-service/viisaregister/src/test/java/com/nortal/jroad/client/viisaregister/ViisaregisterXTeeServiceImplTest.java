package com.nortal.jroad.client.viisaregister;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import com.nortal.jroad.client.viisaregister.ViisaregisterXTeeServiceImpl;
import com.nortal.jroad.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.StruktIsikSuguMK;
import com.nortal.jroad.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedIsikReisidokSisend;
import com.nortal.jroad.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedVastus;
import com.nortal.jroad.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotlusteNimistuVastus;

public class ViisaregisterXTeeServiceImplTest extends BaseXRoadServiceImplTest {

	@Resource
	private ViisaregisterXTeeServiceImpl viisaregisterXTeeServiceImpl;

	@Test
	public void taotluseAndmedIsikReisidokumentParing() throws XRoadServiceConsumptionException {
		TaotlusteNimistuVastus result = viisaregisterXTeeServiceImpl.taotluseAndmedIsikReisidokumentParing("FANNY", "JALKA", null, null, null, null, null, null);
		Assertions.assertNotNull(result);
		Assertions.assertNotNull(result.getTaotluseAndmed());
		Assertions.assertNotNull(result.getTaotluseAndmed().getItemList());
		Assertions.assertNotNull(result.getTaotluseAndmed().getItemList().get(0));
	}

	@Test
	public void taotluseAndmedNrLiikParing() throws XRoadServiceConsumptionException {
		TaotluseAndmedVastus result = viisaregisterXTeeServiceImpl.taotluseAndmedNrLiikParing("viisataotlus", "2010/700/15");
		Assertions.assertNotNull(result);
		Assertions.assertNotNull(result.getTaotlAndmed());
		Assertions.assertNotNull(result.getTaotlAndmed().getViisaTaotlus());
		Assertions.assertNotNull(result.getTaotlAndmed().getViisaTaotlus().getViisaTaotleja());
		Assertions.assertEquals(result.getTaotlAndmed().getViisaTaotlus().getViisaTaotleja().getPerekonnanimi(), "JALKA");
	}
}
