package com.nortal.jroad.client.marshaller;

import org.apache.xmlbeans.XmlObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.oxm.XmlMappingException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class XmlBeansMarshallerTest {

    private static final String DOCUMENT =
            "<echo xmlns=\"http://testdb.x-road.eu/producer/\"><request><message>hello</message></request></echo>";

    private static final String EXTERNAL_ENTITY_CONTENT = "external-entity-content";

    private static String recursiveEntityDocument() {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\"?>\n<!DOCTYPE lolz [\n<!ENTITY lol0 \"lol\">\n");
        for (int i = 1; i <= 5; i++) {
            sb.append("<!ENTITY lol").append(i).append(" \"");
            for (int j = 0; j < 10; j++) {
                sb.append("&lol").append(i - 1).append(';');
            }
            sb.append("\">\n");
        }
        return sb.append("]>\n<lolz>&lol5;</lolz>").toString();
    }

    private static InputStream toStream(String document) {
        return new ByteArrayInputStream(document.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void testUnmarshalAndMarshalRoundTrip() throws Exception {
        XmlBeansMarshaller marshaller = new XmlBeansMarshaller();

        Object unmarshalled = marshaller.unmarshal(new StreamSource(new StringReader(DOCUMENT)));
        assertInstanceOf(XmlObject.class, unmarshalled);

        StringWriter writer = new StringWriter();
        marshaller.marshal(unmarshalled, new StreamResult(writer));
        assertEquals("<prod:echo xmlns:prod=\"http://testdb.x-road.eu/producer/\"><prod:request>"
                     + "<prod:message>hello</prod:message></prod:request></prod:echo>",
                     writer.toString());
    }

    @Test
    public void testOptionsFactoryBeanOptionsAreUsedForMarshalling() throws Exception {
        XmlOptionsFactoryBean optionsFactoryBean = new XmlOptionsFactoryBean();
        // keys by name, as in Spring XML config; XMLBeans 5 dropped the String constants in XmlOptions
        optionsFactoryBean.setOptions(Map.of("SAVE_PRETTY_PRINT", Boolean.TRUE));

        XmlBeansMarshaller marshaller = new XmlBeansMarshaller();
        marshaller.setXmlOptions(optionsFactoryBean.getObject());

        StringWriter writer = new StringWriter();
        marshaller.marshal(marshaller.unmarshalInputStream(toStream(DOCUMENT)), new StreamResult(writer));
        assertEquals("<echo xmlns=\"http://testdb.x-road.eu/producer/\">\n"
                     + "  <request>\n"
                     + "    <message>hello</message>\n"
                     + "  </request>\n"
                     + "</echo>",
                     writer.toString());
    }

    @Test
    public void testUnmarshalRejectsRecursiveEntityExpansion() {
        // CVE-2021-23926: XMLBeans before 3.0.0 expanded nested entities without any limit
        XmlBeansMarshaller marshaller = new XmlBeansMarshaller();
        String document = recursiveEntityDocument();

        assertTimeoutPreemptively(Duration.ofSeconds(30), () -> {
            // parsed by XMLBeans itself
            assertThrows(XmlMappingException.class, () -> marshaller.unmarshalInputStream(toStream(document)));
            // parsed through the Spring OXM entry point
            assertThrows(XmlMappingException.class,
                         () -> marshaller.unmarshal(new StreamSource(new StringReader(document))));
        });
    }

    @Test
    public void testUnmarshalDoesNotResolveExternalEntities(@TempDir Path tempDir) throws Exception {
        Path external = tempDir.resolve("external.txt");
        Files.writeString(external, EXTERNAL_ENTITY_CONTENT);
        String document = "<?xml version=\"1.0\"?>\n"
                          + "<!DOCTYPE foo [<!ENTITY xxe SYSTEM \"" + external.toUri() + "\">]>\n"
                          + "<foo>&xxe;</foo>";

        XmlBeansMarshaller marshaller = new XmlBeansMarshaller();
        try {
            Object unmarshalled = marshaller.unmarshalInputStream(toStream(document));
            assertFalse(((XmlObject) unmarshalled).xmlText().contains(EXTERNAL_ENTITY_CONTENT),
                        "External entity must not be resolved");
        } catch (XmlMappingException e) {
            // Rejecting the document altogether is also acceptable
        }
    }
}
