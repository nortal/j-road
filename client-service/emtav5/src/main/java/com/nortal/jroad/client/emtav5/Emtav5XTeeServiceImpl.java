package com.nortal.jroad.client.emtav5;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.emtav5.database.Emtav5XTeeDatabase;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresident;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentRequestType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentResponse;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentResponseType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckCommonRequestType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckRequestType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response.Period;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
@Service("emtav5XTeeService")
public class Emtav5XTeeServiceImpl implements Emtav5XTeeService {

	@Resource
	private Emtav5XTeeDatabase emtav5XTeeDatabase;

	public List<Period> xteeFIEAKV1(String id, Date start, Date end) throws XTeeServiceConsumptionException {
		SpouseCheckRequestType request = SpouseCheckRequestType.Factory.newInstance();
		SpouseCheckCommonRequestType commonRequest = request.addNewRequest();
		commonRequest.setId(id);
		commonRequest.setStart(getCalendar(start));
		commonRequest.setEnd(getCalendar(end));
		SpouseCheckResponseType xteeFIEAKV1 = emtav5XTeeDatabase.xteeFIEAKV1(request);
		Response response = xteeFIEAKV1.getResponse();
		return response.getPeriodList();
	}

	private Calendar getCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	@Override
	public SkaMitteresidentResponseType skaMitteresident(String registreerimiskood)
			throws XTeeServiceConsumptionException {
		SkaMitteresident input = SkaMitteresident.Factory.newInstance();
		SkaMitteresidentRequestType request = input.addNewRequest();
		request.setRegistreerimiskood(registreerimiskood);
		SkaMitteresidentResponse skaMitteresident = emtav5XTeeDatabase.skaMitteresidentV1(input);
		return skaMitteresident.getResponse();
	}

}
