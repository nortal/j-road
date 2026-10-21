package com.nortal.jroad.wsdl;

import com.nortal.jroad.annotation.XTeeService;
import com.nortal.jroad.endpoint.AbstractXTeeBaseEndpoint;
import com.nortal.jroad.mapping.XTeeEndpointMapping;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.xml.xsd.SimpleXsdSchema;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Generates a provider WSDL through the Spring-WS WSDL4J provider chain inside a Spring application context.
 */
public class XTeeWsdlDefinitionTest {

    @XTeeService(name = "echo", version = "v2", title = "Echo service")
    public static class EchoEndpoint extends AbstractXTeeBaseEndpoint {
    }

    @Test
    public void testGenerateWsdl() throws Exception {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.registerBean("xteeDatabase", String.class, () -> "testdb");
            context.registerBean(XTeeEndpointMapping.class);
            context.registerBean(EchoEndpoint.class);
            context.registerBean("testdbSchema", SimpleXsdSchema.class,
                                 () -> new SimpleXsdSchema(new ClassPathResource("wsdl/testdb.xsd")));
            context.registerBean("testdb", XTeeWsdlDefinition.class, () -> {
                XTeeWsdlDefinition definition = new XTeeWsdlDefinition();
                definition.setSchema(context.getBean(SimpleXsdSchema.class));
                definition.setPortTypeName("testdbPortType");
                definition.setServiceName("testdbService");
                definition.setInputsWithIssue(List.of("echoRequest"));
                return definition;
            });
            context.refresh();

            assertEquals(List.of("testdb.echo.v2"),
                         List.copyOf(context.getBean(XTeeEndpointMapping.class).getMethods()));

            String wsdl = toString(context.getBean(XTeeWsdlDefinition.class));

            assertTrue(wsdl.contains("targetNamespace=\"http://testdb.x-road.eu\""), wsdl);
            assertTrue(wsdl.contains("<wsdl:operation name=\"echo\">"), wsdl);
            assertTrue(wsdl.contains("<wsdl:documentation><xrd:title>"), wsdl);
            assertTrue(wsdl.contains("<xrd:version>v2</xrd:version>"), wsdl);
            assertTrue(wsdl.contains("<wsdl:service name=\"testdbService\">"), wsdl);
            assertEquals(1, wsdl.split("part=\"issue\"", -1).length - 1, wsdl);
            assertTrue(wsdl.contains("producer=\"testdb\""), wsdl);
            assertTrue(wsdl.contains("schemaLocation=\"http://x-road.eu/xsd/xroad.xsd\""), wsdl);
            assertTrue(wsdl.contains("location=\"http://SECURITY_SERVER/cgi-bin/consumer_proxy\""), wsdl);
            for (String headerPart : List.of("client", "service", "id", "userId", "protocolVersion", "issue")) {
                assertTrue(wsdl.contains("name=\"" + headerPart + "\""), headerPart + " header part missing:\n" + wsdl);
            }
        }
    }

    private static String toString(XTeeWsdlDefinition definition) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(definition.getSource(), new StreamResult(writer));
        return writer.toString();
    }
}
