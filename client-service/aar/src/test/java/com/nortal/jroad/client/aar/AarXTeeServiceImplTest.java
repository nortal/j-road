package com.nortal.jroad.client.aar;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.apache.xmlbeans.XmlException;
import org.junit.Test;

import com.nortal.jroad.client.aar.AarXTeeServiceImpl;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * Aar andmekogu xtee teenuste testid
 * 
 * @author Lauri Lättemäe 
 * @date 08.10.2010
 */
public class AarXTeeServiceImplTest extends BaseXTeeServiceImplTest {
	@Resource
	private AarXTeeServiceImpl aarXTeeServiceImpl;

	@Test
	public void dummyTest() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void asutusedParing() throws XRoadServiceConsumptionException {
		Assert.assertNotNull(aarXTeeServiceImpl.asutusedParingRegistriKoodiJargi("123", "10391131"));
	}

	@Test
	public void oigusedParing() throws XRoadServiceConsumptionException {
		// Pane siia õige isikukood
		//Assert.assertNotNull(aarXTeeServiceImpl.isikuRollidAsutuses(21134L, "123", RollEnum.ESFOS_TATOTLUSE_ESITAJA, RollEnum.GENERAL_ASUTUS_ESINDAJA));
		Assert.assertTrue(true);
	}
}
