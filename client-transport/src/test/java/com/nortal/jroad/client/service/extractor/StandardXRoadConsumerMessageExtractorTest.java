package com.nortal.jroad.client.service.extractor;


import com.nortal.jroad.model.XmlBeansXRoadMetadata;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.IOException;
import java.io.InputStream;

public class StandardXRoadConsumerMessageExtractorTest {


    private SOAPMessage getMessageFromString(String filename) throws SOAPException, IOException {
        InputStream is = (new ClassPathResource(filename)).getInputStream();

        return MessageFactory.newInstance().createMessage(null, is);
    }


    @Test
    public void testExtractData() throws IOException, SOAPException {
        StandardXRoadConsumerMessageExtractor extractor =
                new StandardXRoadConsumerMessageExtractor(new XmlBeansXRoadMetadata("operation",
                        "b",
                        "request",
                        "d",
                        "response",
                        "f",
                        "1"));


        // xml elements in a single row, but base64binary part on different rows
        extractor.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail1.xml")));

        // manually formated file with whitespaces between elements without new row
        extractor.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail2.xml")));

        // menually formated file without whitespaces between elements and without new row
        extractor.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail3.xml")));

        // whole file in a single row
        extractor.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail4.xml")));

        // menually formated file with whitespaces between elements and without new row
        extractor.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail5.xml")));
    }
}
