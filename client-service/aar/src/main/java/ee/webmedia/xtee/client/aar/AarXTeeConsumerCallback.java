package ee.webmedia.xtee.client.aar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import ee.webmedia.xtee.client.service.callback.CustomCallback;

/**
 * @author lauril
 *
 */
@SuppressWarnings("rawtypes")
public class AarXTeeConsumerCallback extends CustomCallback {
	
	private Map<String, Attribute> eleAttrs;
	
	public AarXTeeConsumerCallback() {
		eleAttrs = new HashMap<String, Attribute>();
	}
	
	private void addType(SOAPElement ele) {
		if (eleAttrs.containsKey(ele.getElementName().getLocalName())) {
			Attribute attr = eleAttrs.get(ele.getElementName().getLocalName());
			ele.setAttribute(attr.getAttrName(), attr.getAttrValue());
		}
		java.util.Iterator eleChilds = ele.getChildElements();
		while (eleChilds.hasNext()) {
			Object nextEle = eleChilds.next();
			if (nextEle instanceof SOAPElement) {
				addType((SOAPElement) nextEle);
			}
		}
	}
	
	public void addElementAttribute(String eleName, String attrName, String attrValue) {
		eleAttrs.put(eleName, new Attribute(attrName, attrValue));
	}
	
	@Override
	public void doWithMessage(WebServiceMessage request) throws IOException, TransformerException {
		callback.doWithMessage(request);
		
		SaajSoapMessage message = (SaajSoapMessage) request;
		SOAPMessage mes = message.getSaajMessage();
		
		try {
			SOAPBody body = mes.getSOAPBody();
			
			SOAPElement queryEle = (SOAPElement) body.getChildElements().next();
			SOAPElement kehaEle = (SOAPElement) queryEle.getChildElements().next();

			java.util.Iterator kehaChilds = kehaEle.getChildElements();
			while (kehaChilds.hasNext()) {
				Object nextEle = kehaChilds.next();
				if (nextEle instanceof SOAPElement) {
					addType((SOAPElement) nextEle);
				}				
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private class Attribute {
		private String attrName;
		private String attrValue;
		
		public Attribute(String attrName, String attrValue) {
			this.attrName = attrName;
			this.attrValue = attrValue;
		}

		public String getAttrName() {
			return attrName;
		}

		public String getAttrValue() {
			return attrValue;
		}
	}
}