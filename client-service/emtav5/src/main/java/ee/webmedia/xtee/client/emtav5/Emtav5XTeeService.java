package ee.webmedia.xtee.client.emtav5;

import java.util.Calendar;
import java.util.List;

import ee.webmedia.xtee.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response.Period;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;

/**
 * <code>emtav5</code> (Maksu- ja Tolliamet) database X-tee v5 service.
 *
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
public interface Emtav5XTeeService {

	/**
	 * <code>emta.xteeFIEAK.v1</code> service.
	 */
	List<Period> xteeFIEAKV1(String id, Calendar start, Calendar end) throws XTeeServiceConsumptionException;

}
