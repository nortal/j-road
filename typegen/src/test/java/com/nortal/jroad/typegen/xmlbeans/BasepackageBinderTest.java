package com.nortal.jroad.typegen.xmlbeans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasepackageBinderTest {

    @Test
    public void testLookupPackageForNamespace() {
        BasepackageBinder binder = new BasepackageBinder("com.nortal.jroad.client.test.types");

        assertEquals("com.nortal.jroad.client.test.types.eu.x_road.testdb.producer",
                     binder.lookupPackageForNamespace("http://testdb.x-road.eu/producer/"));
        assertEquals("com.nortal.jroad.client.test.types.eu.x_road.xsd.xroad",
                     binder.lookupPackageForNamespace("http://x-road.eu/xsd/xroad.xsd"));
        assertEquals("com.nortal.jroad.client.test.types.ee.x_tee.my_db_2.producer",
                     binder.lookupPackageForNamespace("http://my-db-2.x-tee.ee/producer"));
    }

    @Test
    public void testLookupPackageForNamespaceWithoutBasePackage() {
        assertEquals("eu.x_road.testdb.producer",
                     new BasepackageBinder(null).lookupPackageForNamespace("http://testdb.x-road.eu/producer/"));
    }
}
