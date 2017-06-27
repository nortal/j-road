package com.nortal.jroad.client.jvis;

import java.util.Date;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.IsikuVedurijuhilubaVastusDocument.IsikuVedurijuhilubaVastus;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaTaotlusParingDocument.VedurijuhiloaTaotlusParing;

public interface Jvisv6XRoadService {

	IsikuVedurijuhilubaVastus getIsikuVedurijuhiluba(String isikukood) throws XRoadServiceConsumptionException;

	String sendIsikuVedurijuhilubaTaotlus(VedurijuhiloaTaotlusParing paring) throws XRoadServiceConsumptionException;

	String sendVedurijuhiloaEksam(String isikukood, long sooritatud, Date kuupaev) throws XRoadServiceConsumptionException;

	String sendVedurijuhiloaKatteandmine(String isikukood, String loaNumber, Date kattesaamiseKuupaev) throws XRoadServiceConsumptionException;

}
