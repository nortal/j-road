package com.nortal.jroad.client.aar;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Assertions;

import org.apache.xmlbeans.XmlException;
import org.junit.jupiter.api.Test;

import com.nortal.jroad.client.aar.AarXTeeServiceImpl;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

/**
 * Aar andmekogu xtee teenuste testid
 *
 * @author Lauri Lättemäe
 * @date 08.10.2010
 */
public class AarXTeeServiceImplTest extends BaseXRoadServiceImplTest {
	@Resource
	private AarXTeeServiceImpl aarXTeeServiceImpl;

	@Test
	public void dummyTest() {
		Assertions.assertTrue(true);
	}

	@Test
	public void asutusedParing() throws XRoadServiceConsumptionException {
		Assertions.assertNotNull(aarXTeeServiceImpl.asutusedParingRegistriKoodiJargi("123", "10391131"));
	}

	@Test
	public void oigusedParing() throws XRoadServiceConsumptionException {
		// Pane siia õige isikukood
		//Assertions.assertNotNull(aarXTeeServiceImpl.isikuRollidAsutuses(21134L, "123", RollEnum.ESFOS_TATOTLUSE_ESITAJA, RollEnum.GENERAL_ASUTUS_ESINDAJA));
		Assertions.assertTrue(true);
	}
}
