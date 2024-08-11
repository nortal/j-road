package com.nortal.jroad.client.jvis;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.jvis.database.Jvisv6XRoadDatabase;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.*;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.IsikuVedurijuhilubaParingDocument.IsikuVedurijuhilubaParing;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.IsikuVedurijuhilubaVastusDocument.IsikuVedurijuhilubaVastus;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaEksamParingDocument.VedurijuhiloaEksamParing;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaEksamVastusDocument.VedurijuhiloaEksamVastus;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaKatteandmineParingDocument.VedurijuhiloaKatteandmineParing;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaKatteandmineVastusDocument.VedurijuhiloaKatteandmineVastus;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaTaotlusParingDocument.VedurijuhiloaTaotlusParing;
import com.nortal.jroad.client.jvis.types.eu.x_road.jvisv6.producer.VedurijuhiloaTaotlusVastusDocument.VedurijuhiloaTaotlusVastus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("jvisv6XTeeService")
public class Jvisv6XRoadServiceImpl implements Jvisv6XRoadService {

	@Resource
	private Jvisv6XRoadDatabase jvisv6XRoadDatabase;

	public IsikuVedurijuhilubaVastus getIsikuVedurijuhiluba(String isikukood) throws XRoadServiceConsumptionException {
		IsikuVedurijuhilubaParing paring = IsikuVedurijuhilubaParing.Factory.newInstance();
		paring.setIsikukood(isikukood);
		return jvisv6XRoadDatabase.isikuVedurijuhilubaV1(paring);
	}

	public InstallationListResponseDocument.InstallationListResponse getInstallationList(List<Long> groups, List<Long> ids,
			List<String> statuses, final Integer limit, Long offset, String userName) throws XRoadServiceConsumptionException {
		InstallationListRequestDocument.InstallationListRequest request = InstallationListRequestDocument.InstallationListRequest.Factory.newInstance();
		if (groups != null) {
			BigInteger[] groupsArray = new BigInteger[groups.size()];
			for (int i = 0; i < groups.size(); i++) {
				groupsArray[i] = new BigInteger(groups.get(i).toString());
			}
			request.setGroupArray(groupsArray);
		}
		if (ids != null) {
			BigInteger[] idsArray = new BigInteger[ids.size()];
			for (int i = 0; i < ids.size(); i++) {
				idsArray[i] = new BigInteger(ids.get(i).toString());
			}
			request.setIdArray(idsArray);
		}
		if (statuses != null) {
			InstallationStatus.Enum[] statusArray = new InstallationStatus.Enum[statuses.size()];
			for (int i = 0; i < statuses.size(); i++) {
				statusArray[i] = InstallationStatus.Enum.forString(statuses.get(i));
			}
			request.setStatusArray(statusArray);
		}
		if (limit != null) {
			request.setLimit(limit);
		}
		if (offset != null) {
			request.setOffset(new BigInteger(offset.toString()));
		}
		return jvisv6XRoadDatabase.installationListV1(request, userName);
	}

	public InstallationChangeListResponseDocument.InstallationChangeListResponse getInstallationChangeList(Calendar start, Calendar end, Integer limit, Long offset, String userName) throws XRoadServiceConsumptionException {
		InstallationChangeListRequestDocument.InstallationChangeListRequest request = InstallationChangeListRequestDocument.InstallationChangeListRequest.Factory.newInstance();

		request.setStart(start);
		request.setEnd(end);

		if (limit != null) {
			request.setLimit(limit);
		}
		if (offset != null) {
			request.setOffset(new BigInteger(offset.toString()));
		}
		return jvisv6XRoadDatabase.installationChangeListV1(request, userName);
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
