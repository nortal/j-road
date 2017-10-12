package com.nortal.jroad.client.service.extractor;


import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMetadata;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class StandardXRoadConsumerMessageExtractorTest {

    private final static String RESULT_PEM_FORMAT = "<response xmlns:era=\"http://earest.x-road.eu/\" xmlns=\"f\">\n" +
            "  <request xmlns=\"\">\n" +
            "    <ParinguKoostamiseAeg>2017-10-06T15:51:00</ParinguKoostamiseAeg>\n" +
            "  </request>\n" +
            "  <response xmlns=\"\">\n" +
            "    <ArestiVastused>\n" +
            "      <Vastus>\n" +
            "        <IsikuOigusedKohustused>\n" +
            "          <Akt>\n" +
            "            <AlgParinguUnikaalneID>A801201702209240</AlgParinguUnikaalneID>\n" +
            "            <VolitatudKasutajad>\n" +
            "              <VolitatudKasutaja>\n" +
            "                <VolituseLaad/>\n" +
            "                <VolituseFailiNimi>jyritamm</VolituseFailiNimi>\n" +
            "                <VolituseFail>JVBERi0xLjUNCiW1tbW1DQoxIDAgb2JqDQo8PC9UeXBlL0NhdGFsb2cvUGFnZXMgMiAwIFIvTGFu\n" +
            "ZyhldC1FRSkgL1N0cnVjdFRyZWVSb290IDE1IDAgUi9NYXJrSW5mbzw8L01hcmtlZCB0cnVlPj4+\n" +
            "CjE1MDc2Nw0KJSVFT0YNCnhyZWYNCjAgMA0KdHJhaWxlcg0KPDwvU2l6ZSAyNy9Sb290IDEgMCBS\n" +
            "L0luZm8gMTQgMCBSL0lEWzxBNDQzRkEyNkVCQzM3RTRDODczOUFEQkYxNUEyRTZDRj48QTQ0M0ZB\n" +
            "MjZFQkMzN0U0Qzg3MzlBREJGMTVBMkU2Q0Y+XSAvUHJldiAxNTA3NjcvWFJlZlN0bSAxNTA0NjM+\n" +
            "Pg0Kc3RhcnR4cmVmDQoxNTE0NjUNCiUlRU9G</VolituseFail>\n" +
            "              </VolitatudKasutaja>\n" +
            "            </VolitatudKasutajad>\n" +
            "          </Akt>\n" +
            "        </IsikuOigusedKohustused>\n" +
            "      </Vastus>\n" +
            "    </ArestiVastused>\n" +
            "  </response>\n" +
            "</response>";


    private final static String RESULT_SINGLE_ROW_FORMAT = "<response xmlns:era=\"http://earest.x-road.eu/\" xmlns=\"f\">\n" +
            "  <request xmlns=\"\">\n" +
            "    <ParinguKoostamiseAeg>2017-10-06T15:51:00</ParinguKoostamiseAeg>\n" +
            "  </request>\n" +
            "  <response xmlns=\"\">\n" +
            "    <ArestiVastused>\n" +
            "      <Vastus>\n" +
            "        <IsikuOigusedKohustused>\n" +
            "          <Akt>\n" +
            "            <AlgParinguUnikaalneID>A801201702209240</AlgParinguUnikaalneID>\n" +
            "            <VolitatudKasutajad>\n" +
            "              <VolitatudKasutaja>\n" +
            "                <VolituseLaad/>\n" +
            "                <VolituseFailiNimi>jyritamm</VolituseFailiNimi>\n" +
            "                <VolituseFail>JVBERi0xLjUNCiW1tbW1DQoxIDAgb2JqDQo8PC9UeXBlL0NhdGFsb" +
            "2cvUGFnZXMgMiAwIFIvTGFuZyhldC1FRSkgL1N0cnVjdFRyZWVSb290IDE1IDAgUi9NYXJrSW5mbzw8L01h" +
            "cmtlZCB0cnVlPj4+CjE1MDc2Nw0KJSVFT0YNCnhyZWYNCjAgMA0KdHJhaWxlcg0KPDwvU2l6ZSAyNy9Sb29" +
            "0IDEgMCBSL0luZm8gMTQgMCBSL0lEWzxBNDQzRkEyNkVCQzM3RTRDODczOUFEQkYxNUEyRTZDRj48QTQ0M0" +
            "ZBMjZFQkMzN0U0Qzg3MzlBREJGMTVBMkU2Q0YXSAvUHJldiAxNTA3NjcvWFJlZlN0bSAxNTA0NjM+Pg0Kc3" +
            "RhcnR4cmVmDQoxNTE0NjUNCiUlRU9G</VolituseFail>\n" +
            "              </VolitatudKasutaja>\n" +
            "            </VolitatudKasutajad>\n" +
            "          </Akt>\n" +
            "        </IsikuOigusedKohustused>\n" +
            "      </Vastus>\n" +
            "    </ArestiVastused>\n" +
            "  </response>\n" +
            "</response>";

    public static final StandardXRoadConsumerMessageExtractor EXTRACTOR =
            new StandardXRoadConsumerMessageExtractor(new XmlBeansXRoadMetadata("operation",
            "b",
            "request",
            "d",
            "response",
            "f",
            "1"));


    private SOAPMessage getMessageFromString(String filename) throws SOAPException, IOException {
        InputStream is = (new ClassPathResource(filename)).getInputStream();

        return MessageFactory.newInstance().createMessage(null, is);
    }

    @Test
    public void testExtractDataWithComment() throws IOException, SOAPException {
        // with comment
        XRoadMessage message = EXTRACTOR.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail6.xml")));
        assertEquals(RESULT_PEM_FORMAT, message.getContent().toString());
    }


    @Test
    public void testExtractDataBase64SingleRow() throws IOException, SOAPException {
        // whole file in a single row (base64binary in a single row)
        XRoadMessage message = EXTRACTOR.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail4.xml")));
        assertEquals(RESULT_SINGLE_ROW_FORMAT, message.getContent().toString());
    }

    @Test
    public void testExtractDataBase64PEMFormat() throws IOException, SOAPException {
        // xml elements in a single row, but base64binary part on different rows (PEM format)
        XRoadMessage message1 = EXTRACTOR.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail1.xml")));
        assertEquals(RESULT_PEM_FORMAT, message1.getContent().toString());

        // manually formated file with whitespaces between elements without new row (base64binary in PEM format)
        XRoadMessage message2 = EXTRACTOR.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail2.xml")));
        assertEquals(RESULT_PEM_FORMAT, message2.getContent().toString());

        // menually formated file without whitespaces between elements and without new row (base64binary in PEM format)
        XRoadMessage message3 = EXTRACTOR.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail3.xml")));
        assertEquals(RESULT_PEM_FORMAT, message3.getContent().toString());

        // menually formated file with whitespaces between elements and without new row (base64binary in PEM format)
        XRoadMessage message5 = EXTRACTOR.extractData(new SaajSoapMessage(getMessageFromString("extractor/EarestFail5.xml")));
        assertEquals(RESULT_PEM_FORMAT, message5.getContent().toString());
    }
}
