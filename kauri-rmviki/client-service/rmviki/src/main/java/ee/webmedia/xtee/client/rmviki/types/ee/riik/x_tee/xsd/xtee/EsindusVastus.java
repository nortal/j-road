/*
 * XML Type:  esindus_vastus
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee;


/**
 * An XML esindus_vastus(@http://x-tee.riik.ee/xsd/xtee.xsd).
 *
 * This is a complex type.
 */
public interface EsindusVastus extends ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Array
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EsindusVastus.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sECB862A04A055A0DA9480D72543BD8FC").resolveHandle("esindusvastus7d9btype");
    
    /**
     * Gets a List of "item" elements
     */
    @ee.webmedia.xtee.model.XteeElement(title="Esindatavad üksused", sequence=1)
    java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item> getItemList();
    
    /**
     * Gets array of all "item" elements
     * @deprecated
     */
    @ee.webmedia.xtee.model.XteeElement(title="Esindatavad üksused", sequence=1)
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item[] getItemArray();
    
    /**
     * Gets ith "item" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item getItemArray(int i);
    
    /**
     * Returns number of "item" element
     */
    int sizeOfItemArray();
    
    /**
     * Sets array of all "item" element
     */
    void setItemArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item[] itemArray);
    
    /**
     * Sets ith "item" element
     */
    void setItemArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item item);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "item" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item insertNewItem(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "item" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item addNewItem();
    
    /**
     * Removes the ith "item" element
     */
    void removeItem(int i);
    
    /**
     * An XML item(@).
     *
     * This is a complex type.
     */
    public interface Item extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Item.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sECB862A04A055A0DA9480D72543BD8FC").resolveHandle("itembd9celemtype");
        
        /**
         * Gets the "kood" element
         */
        @ee.webmedia.xtee.model.XteeElement(title="üksuse kood", sequence=1)
        java.lang.String getKood();
        
        /**
         * Gets (as xml) the "kood" element
         */
        org.apache.xmlbeans.XmlString xgetKood();
        
        /**
         * Sets the "kood" element
         */
        void setKood(java.lang.String kood);
        
        /**
         * Sets (as xml) the "kood" element
         */
        void xsetKood(org.apache.xmlbeans.XmlString kood);
        
        /**
         * Gets the "nimetus" element
         */
        @ee.webmedia.xtee.model.XteeElement(title="üksuse nimetus", sequence=2)
        java.lang.String getNimetus();
        
        /**
         * Gets (as xml) the "nimetus" element
         */
        org.apache.xmlbeans.XmlString xgetNimetus();
        
        /**
         * Sets the "nimetus" element
         */
        void setNimetus(java.lang.String nimetus);
        
        /**
         * Sets (as xml) the "nimetus" element
         */
        void xsetNimetus(org.apache.xmlbeans.XmlString nimetus);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item newInstance() {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus newInstance() {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
