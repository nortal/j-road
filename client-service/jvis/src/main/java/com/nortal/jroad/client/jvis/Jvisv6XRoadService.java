package com.nortal.jroad.client.jvis;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.InstallationChangeListResponseDocument;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.InstallationListResponseDocument;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.IsikuVedurijuhilubaVastusDocument.IsikuVedurijuhilubaVastus;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaTaotlusParingDocument.VedurijuhiloaTaotlusParing;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface Jvisv6XRoadService {

	IsikuVedurijuhilubaVastus getIsikuVedurijuhiluba(String isikukood) throws XRoadServiceConsumptionException;

	String sendIsikuVedurijuhilubaTaotlus(VedurijuhiloaTaotlusParing paring) throws XRoadServiceConsumptionException;

	String sendVedurijuhiloaEksam(String isikukood, long sooritatud, Date kuupaev) throws XRoadServiceConsumptionException;

	String sendVedurijuhiloaKatteandmine(String isikukood, String loaNumber, Date kattesaamiseKuupaev) throws XRoadServiceConsumptionException;

	InstallationListResponseDocument.InstallationListResponse getInstallationList(List<Long> groups, List<Long> ids, List<String> statuses, final Integer limit, Long offset, String userName) throws XRoadServiceConsumptionException;

	InstallationChangeListResponseDocument.InstallationChangeListResponse getInstallationChangeList(Calendar start, Calendar end, Integer limit, Long offset, String userName) throws XRoadServiceConsumptionException;
}
