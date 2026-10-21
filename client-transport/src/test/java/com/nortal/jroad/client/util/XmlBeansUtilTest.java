package com.nortal.jroad.client.util;

import org.apache.xmlbeans.XmlString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XmlBeansUtilTest {

    @Test
    public void testGetAttributedXmlString() {
        XmlString xmlString = XmlBeansUtil.getAttributedXmlString("value");

        assertEquals("value", xmlString.getStringValue());
        String xml = xmlString.xmlText();
        assertTrue(xml.contains("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""), xml);
        assertTrue(xml.contains("xsi:type=\"xsd:string\""), xml);
        assertTrue(xml.contains("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""), xml);
    }
}
