package com.nortal.jroad.client.jvis;

import static org.junit.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;

import org.junit.jupiter.api.Test;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.IsikuVedurijuhilubaVastusDocument.IsikuVedurijuhilubaVastus;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaTaotlusParingDocument.VedurijuhiloaTaotlusParing;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

public class JvisXTeeServiceImplTest extends BaseXRoadServiceImplTest {

	private static final String PICTURE_BASE_64 = "iVBORw0KGgoAAAANSUhEUgAAADAAAACRCAYAAACFQjvMAAAAAXNSR0IArs4c6QAAAARnQU1BAACx\n" +
		"jwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAhdEVYdENyZWF0aW9uIFRpbWUAMjAxNzowMzoy\n" +
		"OSAxNzoyNToyNKOHTGgAAADESURBVHhe7dPBCYBADADB0/4L9SFYgvq4EsThYOeTfBeS7X6Nhe1z\n" +
		"LqsAbfmAT574vI65/a8T0grQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK\n" +
		"0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQ\n" +
		"CtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAK0ArQCtAWDxjjAfZkC9xvXSyyAAAAAElF\n" +
		"TkSuQmCC";

	@Resource
	private Jvisv6XRoadServiceImpl jvisXTeeService;

	@Test
	public void getIsikuVedurijuhiluba() throws XRoadServiceConsumptionException {
		IsikuVedurijuhilubaVastus response = jvisXTeeService.getIsikuVedurijuhiluba("38104136519");
		assertEquals("test-luba", response.getLoaNumber());
	}

	@Test
	public void sendIsikuVedurijuhilubaTaotlus() throws XRoadServiceConsumptionException {
		VedurijuhiloaTaotlusParing paring = VedurijuhiloaTaotlusParing.Factory.newInstance();
		paring.setId("1233");
		paring.setIsikukood("36710010075");
		paring.setEesnimi("TEST");
		paring.setPerenimi("isik");
		paring.setSynniaeg(Calendar.getInstance());
		byte[] bytes = DatatypeConverter.parseBase64Binary(PICTURE_BASE_64);
		paring.setPilt(bytes);
		paring.setAllkiri(bytes);
		paring.setTaotlemisePohjus(BigInteger.ONE);
		String response = jvisXTeeService.sendIsikuVedurijuhilubaTaotlus(paring);
		assertEquals("VIGA:Sellise ID-ga taotlus on juba edastatud.", response);
	}

	@Test
	public void sendVedurijuhiloaEksam() throws XRoadServiceConsumptionException {
		String response = jvisXTeeService.sendVedurijuhiloaEksam("38104136519", 1, new Date());
		assertEquals("VIGA:Taotlust ei leitud.", response);
	}

	@Test
	public void sendVedurijuhiloaKatteandmine() throws XRoadServiceConsumptionException {
		String response = jvisXTeeService.sendVedurijuhiloaKatteandmine("36710010075", "123", new Date());
		assertEquals("VIGA:Luba ei leitud.", response);
	}

}
