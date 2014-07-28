/*
 * XML Type:  Z_RKOVAR.Response
 * Namespace: http://producers.rmviki.xtee.riik.ee/producer/rmviki
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki;


/**
 * An XML Z_RKOVAR.Response(@http://producers.rmviki.xtee.riik.ee/producer/rmviki).
 *
 * This is a complex type.
 */
public interface ZRKOVARResponse extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ZRKOVARResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2EF6E704427A649A6A572A6306611BA6").resolveHandle("zrkovarresponse0630type");
    
    /**
     * Gets the "EKSPORDIAEG" element
     */
    @ee.webmedia.xtee.model.XteeElement(title="EKSPORDIAEG", sequence=1)
    long getEKSPORDIAEG();
    
    /**
     * Gets (as xml) the "EKSPORDIAEG" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG xgetEKSPORDIAEG();
    
    /**
     * Sets the "EKSPORDIAEG" element
     */
    void setEKSPORDIAEG(long ekspordiaeg);
    
    /**
     * Sets (as xml) the "EKSPORDIAEG" element
     */
    void xsetEKSPORDIAEG(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG ekspordiaeg);
    
    /**
     * Gets the "ISIKUD" element
     */
    @ee.webmedia.xtee.model.XteeElement(title="ISIKUD", sequence=2)
    ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD getISIKUD();
    
    /**
     * Sets the "ISIKUD" element
     */
    void setISIKUD(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD isikud);
    
    /**
     * Appends and returns a new empty "ISIKUD" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD addNewISIKUD();
    
    /**
     * An XML EKSPORDIAEG(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse$EKSPORDIAEG.
     */
    public interface EKSPORDIAEG extends org.apache.xmlbeans.XmlDecimal
    {
        long getLongValue();
        void setLongValue(long l);
        /** @deprecated */
        long longValue();
        /** @deprecated */
        void set(long l);
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EKSPORDIAEG.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2EF6E704427A649A6A572A6306611BA6").resolveHandle("ekspordiaeg711celemtype");
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG newValue(java.lang.Object obj) {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG) type.newValue( obj ); }
            
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG newInstance() {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * An XML ISIKUD(@).
     *
     * This is a complex type.
     */
    public interface ISIKUD extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ISIKUD.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2EF6E704427A649A6A572A6306611BA6").resolveHandle("isikud7629elemtype");
        
        /**
         * Gets a List of "item" elements
         */
        @ee.webmedia.xtee.model.XteeElement(title="ISIKUD", sequence=1)
        java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR> getItemList();
        
        /**
         * Gets array of all "item" elements
         * @deprecated
         */
        @ee.webmedia.xtee.model.XteeElement(title="ISIKUD", sequence=1)
        ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR[] getItemArray();
        
        /**
         * Gets ith "item" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR getItemArray(int i);
        
        /**
         * Returns number of "item" element
         */
        int sizeOfItemArray();
        
        /**
         * Sets array of all "item" element
         */
        void setItemArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR[] itemArray);
        
        /**
         * Sets ith "item" element
         */
        void setItemArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR item);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "item" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR insertNewItem(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "item" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR addNewItem();
        
        /**
         * Removes the ith "item" element
         */
        void removeItem(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD newInstance() {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse newInstance() {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
