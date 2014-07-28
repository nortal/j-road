/*
 * An XML document type.
 * Localname: notes
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee;


/**
 * A document containing one notes(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public interface NotesDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(NotesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2EF6E704427A649A6A572A6306611BA6").resolveHandle("notes5a40doctype");
    
    /**
     * Gets the "notes" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes getNotes();
    
    /**
     * Sets the "notes" element
     */
    void setNotes(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes notes);
    
    /**
     * Appends and returns a new empty "notes" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes addNewNotes();
    
    /**
     * An XML notes(@http://x-tee.riik.ee/xsd/xtee.xsd).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument$Notes.
     */
    public interface Notes extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Notes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s2EF6E704427A649A6A572A6306611BA6").resolveHandle("notes772delemtype");
        
        /**
         * Gets the "lang" attribute
         */
        java.lang.String getLang();
        
        /**
         * Gets (as xml) the "lang" attribute
         */
        org.apache.xmlbeans.XmlLanguage xgetLang();
        
        /**
         * True if has "lang" attribute
         */
        boolean isSetLang();
        
        /**
         * Sets the "lang" attribute
         */
        void setLang(java.lang.String lang);
        
        /**
         * Sets (as xml) the "lang" attribute
         */
        void xsetLang(org.apache.xmlbeans.XmlLanguage lang);
        
        /**
         * Unsets the "lang" attribute
         */
        void unsetLang();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes newInstance() {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument newInstance() {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
