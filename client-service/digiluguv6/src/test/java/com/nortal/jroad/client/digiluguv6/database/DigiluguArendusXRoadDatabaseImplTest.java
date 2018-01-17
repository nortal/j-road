package com.nortal.jroad.client.digiluguv6.database;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.nortal.jroad.client.digiluguv6.DigiluguV6Service;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.CertificateRequestDocument;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.CertificateRequestRequestType;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.CertificateRequestResponseDocument;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.UpdatedCertificatesRequestDocument;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.UpdatedCertificatesRequestRequestType;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.UpdatedCertificatesRequestResponseDocument;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

@ContextConfiguration(locations = { "classpath:client-test-digiluguv6.xml" })
public class DigiluguArendusXRoadDatabaseImplTest extends AbstractJUnit4SpringContextTests {

	private static final String REPOSITORY_DATE_FORMAT = "yyyyMMddHHmmss";
	
	@Resource
	private DigiluguV6Service service;

	@Test
	public void certificateRequestV1Test() throws XRoadServiceConsumptionException {

		CertificateRequestResponseDocument.CertificateRequestResponse response = service.certificateRequestV1(createRequestByIdentityCode("48512159978"));
		Assert.assertEquals("MIRJAM", response.getResponse().getCertificate().getPersonNameGiven());
	}
	
	@Test
	public void updatedCertificatesRequesV1Test() throws XRoadServiceConsumptionException {
		UpdatedCertificatesRequestDocument.UpdatedCertificatesRequest requestByFromDate = createRequestByFromDate(new Date(), REPOSITORY_DATE_FORMAT);
		UpdatedCertificatesRequestResponseDocument.UpdatedCertificatesRequestResponse cr = service.updatedCertificatesRequestV1(requestByFromDate);
		Assert.assertEquals("AA", cr.getResponse().getAcknowledgement().getResponsetypeCode());
	}

	private CertificateRequestDocument.CertificateRequest createRequestByIdentityCode(String identityCode) {
		CertificateRequestDocument.CertificateRequest certificateRequest = CertificateRequestDocument.CertificateRequest.Factory.newInstance();
		CertificateRequestRequestType certificateRequestRequestType = CertificateRequestRequestType.Factory.newInstance();
		certificateRequestRequestType.setPersonId(identityCode);
		certificateRequestRequestType.setPersonIdOID("1.3.6.1.4.1.28284.6.2.2.1");
		certificateRequest.setRequest(certificateRequestRequestType);
		return certificateRequest;
	}

	public static UpdatedCertificatesRequestDocument.UpdatedCertificatesRequest createRequestByFromDate(Date fromDate, String format) {
		UpdatedCertificatesRequestDocument.UpdatedCertificatesRequest request = UpdatedCertificatesRequestDocument.UpdatedCertificatesRequest.Factory.newInstance();
		request.setRequest(UpdatedCertificatesRequestRequestType.Factory.newInstance());
		request.getRequest().setChangesFromTime(new SimpleDateFormat(format).format(fromDate));
		return request;
	}
}
