package com.nortal.jroad.client.jvis;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.jvis.database.Jvisv6XRoadDatabase;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.IsikuVedurijuhilubaParingDocument.IsikuVedurijuhilubaParing;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.IsikuVedurijuhilubaVastusDocument.IsikuVedurijuhilubaVastus;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaEksamParingDocument.VedurijuhiloaEksamParing;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaEksamVastusDocument.VedurijuhiloaEksamVastus;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaKatteandmineParingDocument.VedurijuhiloaKatteandmineParing;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaKatteandmineVastusDocument.VedurijuhiloaKatteandmineVastus;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaTaotlusParingDocument.VedurijuhiloaTaotlusParing;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaTaotlusVastusDocument.VedurijuhiloaTaotlusVastus;

@Service("jvisv6XRoadService")
public class Jvisv6XRoadServiceImpl implements Jvisv6XRoadService {

	@Resource
	private Jvisv6XRoadDatabase jvisv6XRoadDatabase;

	public IsikuVedurijuhilubaVastus getIsikuVedurijuhiluba(String isikukood) throws XRoadServiceConsumptionException {
		IsikuVedurijuhilubaParing paring = IsikuVedurijuhilubaParing.Factory.newInstance();
		paring.setIsikukood(isikukood);
		return jvisv6XRoadDatabase.isikuVedurijuhilubaV1(paring);
	}

	public String sendIsikuVedurijuhilubaTaotlus(VedurijuhiloaTaotlusParing paring) throws XRoadServiceConsumptionException {
		VedurijuhiloaTaotlusVastus vastus = jvisv6XRoadDatabase.vedurijuhiloaTaotlusV1(paring);
		return vastus.getVastuskood();
	}

	public String sendVedurijuhiloaEksam(String isikukood, long sooritatud, Date kuupaev) throws XRoadServiceConsumptionException {
		VedurijuhiloaEksamParing paring = getVedurijuhiloaEksamParing(isikukood, sooritatud, kuupaev);
		VedurijuhiloaEksamVastus vastus = jvisv6XRoadDatabase.vedurijuhiloaEksamV1(paring);
		return vastus.getVastuskood();
	}

	private VedurijuhiloaEksamParing getVedurijuhiloaEksamParing(String isikukood, long sooritatud, Date kuupaev) {
		VedurijuhiloaEksamParing paring = VedurijuhiloaEksamParing.Factory.newInstance();
		paring.setIsikukood(isikukood);
		paring.setSooritatud(BigInteger.valueOf(sooritatud));
		paring.setKuupaev(getCalendarFromDate(kuupaev));
		return paring;
	}

	private Calendar getCalendarFromDate(Date kuupaev) {
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(kuupaev);
		return calDate;
	}

	public String sendVedurijuhiloaKatteandmine(String isikukood, String loaNumber, Date kattesaamiseKuupaev) throws XRoadServiceConsumptionException {
		VedurijuhiloaKatteandmineParing paring = VedurijuhiloaKatteandmineParing.Factory.newInstance();
		paring.setIsikukood(isikukood);
		paring.setLoaNumber(loaNumber);
		paring.setKatteandmiseKuupaev(getCalendarFromDate(kattesaamiseKuupaev));
		VedurijuhiloaKatteandmineVastus vastus = jvisv6XRoadDatabase.vedurijuhiloaKatteandmineV1(paring);
		return vastus.getVastuskood();
	}

}
