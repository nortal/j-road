package ee.webmedia.xtee.client.viisaregister;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.StruktIsikSuguMK;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedIsikReisidokSisend;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedVastus;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotlusteNimistuVastus;

public class ViisaregisterXTeeServiceImplTest extends BaseXTeeServiceImplTest {

	@Resource
	private ViisaregisterXTeeServiceImpl viisaregisterXTeeServiceImpl;
	
	@Test
	public void taotluseAndmedIsikReisidokumentParing() throws XTeeServiceConsumptionException {
		TaotlusteNimistuVastus result = viisaregisterXTeeServiceImpl.taotluseAndmedIsikReisidokumentParing("FANNY", "JALKA", null, null, null, null, null, null);
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getTaotluseAndmed());
		Assert.assertNotNull(result.getTaotluseAndmed().getItemList());
		Assert.assertNotNull(result.getTaotluseAndmed().getItemList().get(0));
	}
	
	@Test
	public void taotluseAndmedNrLiikParing() throws XTeeServiceConsumptionException {
		TaotluseAndmedVastus result = viisaregisterXTeeServiceImpl.taotluseAndmedNrLiikParing("viisataotlus", "2010/700/15");
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getTaotlAndmed());
		Assert.assertNotNull(result.getTaotlAndmed().getViisaTaotlus());
		Assert.assertNotNull(result.getTaotlAndmed().getViisaTaotlus().getViisaTaotleja());
		Assert.assertEquals(result.getTaotlAndmed().getViisaTaotlus().getViisaTaotleja().getPerekonnanimi(), "JALKA");
	}
}
