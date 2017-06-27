package com.nortal.jroad.client.digiluguv6;

import javax.annotation.Resource;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.digiluguv6.database.DigiluguXRoadDatabase;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.CertificateRequestDocument;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.CertificateRequestResponseDocument;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.UpdatedCertificatesRequestDocument;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.UpdatedCertificatesRequestResponseDocument;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

@ImportResource("classpath:client-digiluguv6.xml")
@Service("digiluguXTeeV6ServiceImpl")
public class DigiluguV6ServiceImpl implements DigiluguV6Service {

	@Resource(name = "digiluguXRoadDatabase")
	private DigiluguXRoadDatabase digiluguXRoadDatabase;

	@Override
	public CertificateRequestResponseDocument.CertificateRequestResponse certificateRequestV1(CertificateRequestDocument.CertificateRequest input)
		throws XRoadServiceConsumptionException {
		return digiluguXRoadDatabase.certificateRequestV1(input);
	}

	@Override
	public UpdatedCertificatesRequestResponseDocument.UpdatedCertificatesRequestResponse updatedCertificatesRequestV1(
		UpdatedCertificatesRequestDocument.UpdatedCertificatesRequest input) throws XRoadServiceConsumptionException {
		return digiluguXRoadDatabase.updatedCertificatesRequestV1(input);
	}
}
