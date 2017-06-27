package com.nortal.jroad.client.emtav6;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.nortal.jroad.client.emtav6.types.eu.x_road.emta_v6.ArisApplicationType;
import com.nortal.jroad.client.emtav6.types.eu.x_road.emta_v6.PreRegCheckDocument.PreRegCheck;
import com.nortal.jroad.client.emtav6.types.eu.x_road.emta_v6.PreRegCheckRequestItemType;
import com.nortal.jroad.client.emtav6.types.eu.x_road.emta_v6.PreRegCheckResponseItemType;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

public class EmtaV6XRoadServiceImplTest extends BaseXRoadServiceImplTest {

	private static long arisId = 11111L;

	@Resource
	private EmtaV6XRoadServiceImpl emtav6xTeeServiceImpl;

	@Test
	public void preRegCheckV1() throws XRoadServiceConsumptionException {
		PreRegCheck preRegCheck = PreRegCheck.Factory.newInstance();
		PreRegCheckRequestItemType itemType = preRegCheck.addNewItem();
		ArisApplicationType applicationType = itemType.addNewApplication();
		applicationType.setArisId(arisId);
		applicationType.setApplicantEmail("test.wsdl@test.wsdl.ee");
		applicationType.setApplicantPhone("12335465");
		List<PreRegCheckResponseItemType> itemList = emtav6xTeeServiceImpl.preRegCheckV1(preRegCheck);
		Assert.assertEquals(arisId, itemList.get(0).getArisId());
	}

}
