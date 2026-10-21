package com.nortal.jroad.typegen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Runs the whole generator (XMLBeans schema compilation, attachment post-processing, metadata serialization and
 * FreeMarker based database class rendering) against a minimal WSDL.
 */
public class TypeGenTest {

    private static final String TYPES_PACKAGE_DIR = "com/nortal/jroad/client/testdb/types/eu/x_road/testdb/producer";
    private static final String DATABASE_PACKAGE_DIR = "com/nortal/jroad/client/testdb/database";

    @TempDir
    Path tempDir;

    @Test
    public void testGenerate() throws Exception {
        Path wsdlDir = Path.of(TypeGenTest.class.getResource("/typegen-wsdl").toURI());
        Path sourceDir = tempDir.resolve("src");
        Path xsbDir = tempDir.resolve("classes");

        TypeGen.main(new String[] {
            "wsdldir=" + wsdlDir,
            "sourcedir=" + sourceDir,
            "xsbdir=" + xsbDir,
            "basepackage=com.nortal.jroad.client.testdb.types",
            "dbclassespackage=com.nortal.jroad.client.testdb.database" });

        List<String> sources = listFiles(sourceDir);
        String listing = String.join("\n", sources);

        // XMLBeans generated types
        assertTrue(sources.contains(TYPES_PACKAGE_DIR + "/EchoDocument.java"), listing);
        assertTrue(sources.contains(TYPES_PACKAGE_DIR + "/EchoResponseDocument.java"), listing);
        assertTrue(sources.contains(TYPES_PACKAGE_DIR + "/EchoInput.java"), listing);
        assertTrue(sources.contains(TYPES_PACKAGE_DIR + "/EchoOutput.java"), listing);

        String echoInput = Files.readString(sourceDir.resolve(TYPES_PACKAGE_DIR + "/EchoInput.java"));
        assertTrue(echoInput.contains("public interface EchoInput extends org.apache.xmlbeans.XmlObject"), echoInput);
        assertTrue(echoInput.contains("    @com.nortal.jroad.model.XRoadElement(title=\"Message\", sequence=1)\n"
                                      + "    java.lang.String getMessage();"), echoInput);
        assertTrue(echoInput.contains("    @com.nortal.jroad.model.XRoadElement(title=\"Repeat\", sequence=2)\n"
                                      + "    int getRepeat();"), echoInput);
        assertTrue(echoInput.contains("boolean isSetRepeat();"), echoInput);

        // compiled schema type system and serialized X-road metadata
        assertTrue(Files.isRegularFile(xsbDir.resolve("xroad.metadata")));
        assertTrue(listFiles(xsbDir).stream().anyMatch(f -> f.endsWith(".xsb")));

        // FreeMarker rendered database classes
        String inputClass = "com.nortal.jroad.client.testdb.types.eu.x_road.testdb.producer.EchoDocument.Echo";
        String outputClass =
            "com.nortal.jroad.client.testdb.types.eu.x_road.testdb.producer.EchoResponseDocument.EchoResponse";

        String database = Files.readString(sourceDir.resolve(DATABASE_PACKAGE_DIR + "/TestdbXRoadDatabase.java"));
        assertTrue(database.startsWith("package com.nortal.jroad.client.testdb.database;\n"), database);
        assertTrue(database.contains("public interface TestdbXRoadDatabase {"), database);
        assertTrue(database.contains("<code>testdb.echo.v1</code> X-road service."), database);
        assertTrue(database.contains("  " + outputClass + " echoV1(" + inputClass
                                     + " input) throws XRoadServiceConsumptionException;"), database);
        assertTrue(database.contains("  " + outputClass + " echoV2(" + inputClass
                                     + " input, String UserId) throws XRoadServiceConsumptionException;"), database);

        String databaseImpl =
            Files.readString(sourceDir.resolve(DATABASE_PACKAGE_DIR + "/TestdbXRoadDatabaseImpl.java"));
        assertTrue(databaseImpl.contains("@Service(\"testdbXRoadDatabase\")"), databaseImpl);
        assertTrue(databaseImpl.contains(
            "public class TestdbXRoadDatabaseImpl extends XRoadDatabaseService implements TestdbXRoadDatabase {"),
                   databaseImpl);
        assertTrue(databaseImpl.contains("XRoadMessage<" + outputClass + "> response = send(new XmlBeansXRoadMessage<"
                                         + inputClass + ">(input), \"echo\", \"v2\", userId);"), databaseImpl);
        assertEquals(2, countOccurrences(databaseImpl, "\"v1\""), databaseImpl);
    }

    private static List<String> listFiles(Path root) throws Exception {
        try (Stream<Path> files = Files.walk(root)) {
            return files.filter(Files::isRegularFile)
                        .map(p -> root.relativize(p).toString().replace('\\', '/'))
                        .sorted()
                        .collect(Collectors.toList());
        }
    }

    private static int countOccurrences(String text, String token) {
        int count = 0;
        for (int i = text.indexOf(token); i >= 0; i = text.indexOf(token, i + token.length())) {
            count++;
        }
        return count;
    }
}
