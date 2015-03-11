package com.nortal.jroad.client.emtav5;

import java.util.Date;
import java.util.List;

import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response.Period;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * <code>emtav5</code> (Maksu- ja Tolliamet) database X-tee v5 service.
 *
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
public interface Emtav5XTeeService {

	/**
	 * <code>emta.xteeFIEAK.v1</code> service.
	 */
	List<Period> xteeFIEAKV1(String id, Date start, Date end) throws XTeeServiceConsumptionException;

}
