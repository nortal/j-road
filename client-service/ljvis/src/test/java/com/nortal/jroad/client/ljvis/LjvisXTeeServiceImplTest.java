package com.nortal.jroad.client.ljvis;

import jakarta.annotation.Resource;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYvConfirmRequestType;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYvConfirmResponseType;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYvQueryResponseType;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

import static org.junit.Assertions.*;

public class LjvisXTeeServiceImplTest extends BaseXRoadServiceImplTest {

	@Resource
	private LjvisXTeeServiceImpl ljvisXTeeServiceImpl;

	@Test
	public void erakorralineYlevaatused() {
		try {
			ErakorralineYvQueryResponseType response = ljvisXTeeServiceImpl.erakorralineYlevaatused();

			assertNotNull(response);
		}
		catch (XRoadServiceConsumptionException e) {
			//nothing
		}
	}

	@Test
	public void erakorralineConfirm() throws XRoadServiceConsumptionException {
		ErakorralineYvConfirmRequestType request = ErakorralineYvConfirmRequestType.Factory.newInstance();

		ErakorralineYvConfirmRequestType.Confirmed confirmed = request.addNewConfirmed();

		ErakorralineYvConfirmRequestType.Confirmed.Item item = confirmed.addNewItem();
		item.setInspectionId("1");
		item.setCode("00");
		item.setValue("Andmed salvestatud");

		confirmed.setItemArray(0, item);

		ErakorralineYvConfirmRequestType.Confirmed.Item item1 = confirmed.addNewItem();
		item1.setInspectionId("2");
		item1.setCode("01");
		item1.setValue("Sõiduk on juba erakorralisele suunatud");

		confirmed.setItemArray(1, item1);

		request.setConfirmed(confirmed);
		ErakorralineYvConfirmResponseType response = ljvisXTeeServiceImpl.erakorralineConfirm(request);

		assertNotNull(response);
		assertEquals(2 ,response.getConfirmed());

	}
}
