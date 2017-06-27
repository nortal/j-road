package com.nortal.jroad.client.emtav6;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.emtav6.database.EmtaV6XRoadDatabase;
import com.nortal.jroad.client.emtav6.types.eu.x_road.emta_v6.PreRegCheckDocument.PreRegCheck;
import com.nortal.jroad.client.emtav6.types.eu.x_road.emta_v6.PreRegCheckResponseItemType;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;

@Service("emtav6XTeeService")
public class EmtaV6XRoadServiceImpl extends XRoadDatabaseService implements EmtaV6XRoadService {

	@Resource
	private EmtaV6XRoadDatabase emtaV6XRoadDatabase;

	@Override
	public List<PreRegCheckResponseItemType> preRegCheckV1(PreRegCheck preRegCheck) throws XRoadServiceConsumptionException {
		return emtaV6XRoadDatabase.preRegCheckV1(preRegCheck).getItemList();
	}
}
