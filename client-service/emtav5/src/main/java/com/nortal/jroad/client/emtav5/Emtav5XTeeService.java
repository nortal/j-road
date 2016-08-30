package com.nortal.jroad.client.emtav5;

import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;

import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.DownloadMimeResponseDocument.DownloadMimeResponse;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SkaMitteresidentResponseType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SmMaksustatavadAndmedResponseType;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.SpouseCheckResponseType.Response.Period;
import com.nortal.jroad.client.emtav5.types.net.x_rd.ee.emtav5.producer.UploadMimeResponseDocument.UploadMimeResponse;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.model.XTeeMessage;

/**
 * <code>emtav5</code> (Maksu- ja Tolliamet) database X-tee v5 service.
 *
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
public interface Emtav5XTeeService {

  Integer getState() throws XTeeServiceConsumptionException;

  /**
	 * <code>emtav5.xteeFIEAK.v1</code> service.
	 */
	List<Period> xteeFIEAKV1(String id, Date start, Date end) throws XTeeServiceConsumptionException;
	
	/**
	 * <code>emtav5.skaMitteresident.v1</code> service.
	 */
	SkaMitteresidentResponseType skaMitteresident(String registreerimiskood) throws XTeeServiceConsumptionException;

	/**
   * <code>emtav5.smMaksustatavadAndmed.v1</code> service.
   */
	SmMaksustatavadAndmedResponseType smMaksustatavadAndmed(String isikukood, String perioodiAlgus, String perioodiLopp)
      throws XTeeServiceConsumptionException;
	
	/**
   * <code>emtav5.downloadMime</code> service.
   */
  XTeeMessage<DownloadMimeResponse> downloadMime(String target) throws XTeeServiceConsumptionException;
  
  /**
   * <code>emtav5.uploadMime</code> service.
   */
  UploadMimeResponse uploadMime(String target, String id, DataHandler fail)
      throws XTeeServiceConsumptionException;
}
