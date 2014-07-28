/*
 * An XML document type.
 * Localname: address
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee;


/**
 * A document containing one address(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public interface AddressDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2EF6E704427A649A6A572A6306611BA6").resolveHandle("addressdcf3doctype");
    
    /**
     * Gets the "address" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address getAddress();
    
    /**
     * Sets the "address" element
     */
    void setAddress(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address address);
    
    /**
     * Appends and returns a new empty "address" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address addNewAddress();
    
    /**
     * An XML address(@http://x-tee.riik.ee/xsd/xtee.xsd).
     *
     * This is a complex type.
     */
    public interface Address extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Address.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2EF6E704427A649A6A572A6306611BA6").resolveHandle("address0553elemtype");
        
        /**
         * Gets the "producer" attribute
         */
        java.lang.String getProducer();
        
        /**
         * Gets (as xml) the "producer" attribute
         */
        org.apache.xmlbeans.XmlString xgetProducer();
        
        /**
         * True if has "producer" attribute
         */
        boolean isSetProducer();
        
        /**
         * Sets the "producer" attribute
         */
        void setProducer(java.lang.String producer);
        
        /**
         * Sets (as xml) the "producer" attribute
         */
        void xsetProducer(org.apache.xmlbeans.XmlString producer);
        
        /**
         * Unsets the "producer" attribute
         */
        void unsetProducer();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address newInstance() {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument newInstance() {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
