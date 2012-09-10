package ee.webmedia.xtee.client.service.callback;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;

import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;

/**
 * Adds XTee query header elements ('asutus',
 * 'andmekogu', 'isikukood', etc -- as specified by
 * {@link XTeeServiceConfiguration}) and adds the attachments to message.
 *
 * @author Kait Kasak (kait.kasak@nortal.com)
 *
 */
public class XteeMessageCallbackNamespaceStrategy extends MessageCallbackNamespaceStrategy {

	@Override
    public void addNamespaces(SOAPEnvelope env) throws SOAPException {
		env.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		env.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		env.addNamespaceDeclaration("SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
		env.addNamespaceDeclaration("ns4", "http://x-tee.riik.ee/xsd/xtee.xsd");
		env.setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");
	}

	@Override
    public void addXTeeHeaderElements(SOAPEnvelope env, XTeeServiceConfiguration serviceConfiguration)
	        throws SOAPException {
		SOAPHeader header = env.getHeader();
		SOAPElement pasutus = header.addChildElement("asutus", "ns4");
		SOAPElement pandmekogu = header.addChildElement("andmekogu", "ns4");
		SOAPElement ikood = header.addChildElement("isikukood", "ns4");
		SOAPElement id = header.addChildElement("id", "ns4");
		SOAPElement pnimi = header.addChildElement("nimi", "ns4");
		String toimik = serviceConfiguration.getFile();
		if (toimik != null) {
			SOAPElement toimikEl = header.addChildElement("toimik", "ns4");
			toimikEl.addTextNode(toimik);
		}

		pasutus.addAttribute(env.createName("xsi:type"), "xsd:string");
		pandmekogu.addAttribute(env.createName("xsi:type"), "xsd:string");
		ikood.addAttribute(env.createName("xsi:type"), "xsd:string");
		id.addAttribute(env.createName("xsi:type"), "xsd:string");
		pnimi.addAttribute(env.createName("xsi:type"), "xsd:string");
		pasutus.addTextNode(serviceConfiguration.getInstitution());
		pandmekogu.addTextNode(serviceConfiguration.getDatabase());
		ikood.addTextNode(serviceConfiguration.getIdCode());
		id.addTextNode(generateUniqueMessageId(serviceConfiguration));
		StringBuilder sb = new StringBuilder(serviceConfiguration.getDatabase());
		sb.append(".");
		sb.append(serviceConfiguration.getMethod());
		sb.append(".");
		sb.append(serviceConfiguration.getVersion() == null ? "v1" : serviceConfiguration.getVersion());
		pnimi.addTextNode(sb.toString());

		// deprecated:
		// http://ftp.ria.ee/pub/x-tee/doc/nouded_infosysteemidele.pdf
		if (serviceConfiguration.useDeprecatedApi()) {
			SOAPElement pametnik = header.addChildElement("ametnik", "ns4");
			pametnik.addAttribute(env.createName("xsi:type"), "xsd:string");
			pametnik.addTextNode(serviceConfiguration.getIdCode());
		}
	}

}
