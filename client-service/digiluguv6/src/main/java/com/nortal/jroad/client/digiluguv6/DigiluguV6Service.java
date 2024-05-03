package com.nortal.jroad.client.digiluguv6;

import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.CertificateRequestDocument;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.CertificateRequestResponseDocument;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.UpdatedCertificatesRequestDocument;
import com.nortal.jroad.client.digiluguv6.types.net.x_rd.ee.digilugu.producer.UpdatedCertificatesRequestResponseDocument;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

public interface DigiluguV6Service {

	CertificateRequestResponseDocument.CertificateRequestResponse certificateRequestV1(CertificateRequestDocument.CertificateRequest input)
		throws XRoadServiceConsumptionException;

	UpdatedCertificatesRequestResponseDocument.UpdatedCertificatesRequestResponse updatedCertificatesRequestV1(
		UpdatedCertificatesRequestDocument.UpdatedCertificatesRequest input) throws XRoadServiceConsumptionException;
}
