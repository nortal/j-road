package ee.webmedia.xtee.client.emtav5;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import ee.webmedia.xtee.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response.Period;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;

/**
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
public class Emtav5XTeeServiceImplTest extends BaseXTeeServiceImplTest {

	private static final String CODE = "45906134717";
	private static final String SPOUSE_CODE = "35508274726";

	private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	@Resource
	private Emtav5XTeeServiceImpl emtav5xTeeServiceImpl;

	@Test
	public void xteeFIEAKV1() throws ParseException, XTeeServiceConsumptionException {
		List<Period> periodList = emtav5xTeeServiceImpl.xteeFIEAKV1(CODE, getCalendar("01.08.2012"),
		        getCalendar("05.09.2012"));
		Assert.assertNotNull(periodList);
		Assert.assertTrue(periodList.size() == 1);
		Period period = periodList.get(0);
		assertCalendars(getCalendar("20.08.2012"), period.getStart());
		assertCalendars(getCalendar("02.09.2012"), period.getEnd());
		Assert.assertEquals(SPOUSE_CODE, period.getCode());
		Assert.assertEquals("REIN PEEK", period.getName());
	}

	private void assertCalendars(Calendar cal1, Calendar cal2) throws ParseException {
	    Assert.assertEquals(cal1.getTime(), cal2.getTime());
    }

	private Calendar getCalendar(String dateStr) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFormat.parse(dateStr));
		return cal;
	}

}
