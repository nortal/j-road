/*
 * An XML attribute type.
 * Localname: show
 * Namespace: http://www.w3.org/1999/xlink
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink;


/**
 * A document containing one show(@http://www.w3.org/1999/xlink) attribute.
 *
 * This is a complex type.
 */
public interface ShowAttribute extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ShowAttribute.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sECB862A04A055A0DA9480D72543BD8FC").resolveHandle("show06b7attrtypetype");
    
    /**
     * Gets the "show" attribute
     */
    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show.Enum getShow();
    
    /**
     * Gets (as xml) the "show" attribute
     */
    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show xgetShow();
    
    /**
     * True if has "show" attribute
     */
    boolean isSetShow();
    
    /**
     * Sets the "show" attribute
     */
    void setShow(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show.Enum show);
    
    /**
     * Sets (as xml) the "show" attribute
     */
    void xsetShow(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show show);
    
    /**
     * Unsets the "show" attribute
     */
    void unsetShow();
    
    /**
     * An XML show(@http://www.w3.org/1999/xlink).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute$Show.
     */
    public interface Show extends org.apache.xmlbeans.XmlNMTOKEN
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Show.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sECB862A04A055A0DA9480D72543BD8FC").resolveHandle("show4344attrtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum NEW = Enum.forString("new");
        static final Enum REPLACE = Enum.forString("replace");
        static final Enum EMBED = Enum.forString("embed");
        static final Enum OTHER = Enum.forString("other");
        static final Enum NONE = Enum.forString("none");
        
        static final int INT_NEW = Enum.INT_NEW;
        static final int INT_REPLACE = Enum.INT_REPLACE;
        static final int INT_EMBED = Enum.INT_EMBED;
        static final int INT_OTHER = Enum.INT_OTHER;
        static final int INT_NONE = Enum.INT_NONE;
        
        /**
         * Enumeration value class for ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute$Show.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_NEW
         * Enum.forString(s); // returns the enum value for a string
         * Enum.forInt(i); // returns the enum value for an int
         * </pre>
         * Enumeration objects are immutable singleton objects that
         * can be compared using == object equality. They have no
         * public constructor. See the constants defined within this
         * class for all the valid values.
         */
        static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
        {
            /**
             * Returns the enum value for a string, or null if none.
             */
            public static Enum forString(java.lang.String s)
                { return (Enum)table.forString(s); }
            /**
             * Returns the enum value corresponding to an int, or null if none.
             */
            public static Enum forInt(int i)
                { return (Enum)table.forInt(i); }
            
            private Enum(java.lang.String s, int i)
                { super(s, i); }
            
            static final int INT_NEW = 1;
            static final int INT_REPLACE = 2;
            static final int INT_EMBED = 3;
            static final int INT_OTHER = 4;
            static final int INT_NONE = 5;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("new", INT_NEW),
                    new Enum("replace", INT_REPLACE),
                    new Enum("embed", INT_EMBED),
                    new Enum("other", INT_OTHER),
                    new Enum("none", INT_NONE),
                }
            );
            private static final long serialVersionUID = 1L;
            private java.lang.Object readResolve() { return forInt(intValue()); } 
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show newValue(java.lang.Object obj) {
              return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show) type.newValue( obj ); }
            
            public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show newInstance() {
              return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute newInstance() {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
