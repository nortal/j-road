package ee.webmedia.xtee.client.emtav5;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.webmedia.xtee.client.emtav5.database.Emtav5XTeeDatabase;
import ee.webmedia.xtee.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckCommonRequestType;
import ee.webmedia.xtee.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckRequestType;
import ee.webmedia.xtee.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType;
import ee.webmedia.xtee.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response;
import ee.webmedia.xtee.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response.Period;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;

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

}
