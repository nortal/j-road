/*
 * An XML document type.
 * Localname: complex
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee;


/**
 * A document containing one complex(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public interface ComplexDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ComplexDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sECB862A04A055A0DA9480D72543BD8FC").resolveHandle("complex76afdoctype");
    
    /**
     * Gets the "complex" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex getComplex();
    
    /**
     * Sets the "complex" element
     */
    void setComplex(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex complex);
    
    /**
     * Appends and returns a new empty "complex" element
     */
    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex addNewComplex();
    
    /**
     * An XML complex(@http://x-tee.riik.ee/xsd/xtee.xsd).
     *
     * This is a complex type.
     */
    public interface Complex extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Complex.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sECB862A04A055A0DA9480D72543BD8FC").resolveHandle("complex3dcbelemtype");
        
        /**
         * Gets a List of "suboperation" elements
         */
        java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation> getSuboperationList();
        
        /**
         * Gets array of all "suboperation" elements
         * @deprecated
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation[] getSuboperationArray();
        
        /**
         * Gets ith "suboperation" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation getSuboperationArray(int i);
        
        /**
         * Returns number of "suboperation" element
         */
        int sizeOfSuboperationArray();
        
        /**
         * Sets array of all "suboperation" element
         */
        void setSuboperationArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation[] suboperationArray);
        
        /**
         * Sets ith "suboperation" element
         */
        void setSuboperationArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation suboperation);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "suboperation" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation insertNewSuboperation(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "suboperation" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation addNewSuboperation();
        
        /**
         * Removes the ith "suboperation" element
         */
        void removeSuboperation(int i);
        
        /**
         * Gets a List of "arc" elements
         */
        java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc> getArcList();
        
        /**
         * Gets array of all "arc" elements
         * @deprecated
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc[] getArcArray();
        
        /**
         * Gets ith "arc" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc getArcArray(int i);
        
        /**
         * Returns number of "arc" element
         */
        int sizeOfArcArray();
        
        /**
         * Sets array of all "arc" element
         */
        void setArcArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc[] arcArray);
        
        /**
         * Sets ith "arc" element
         */
        void setArcArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc arc);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "arc" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc insertNewArc(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "arc" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc addNewArc();
        
        /**
         * Removes the ith "arc" element
         */
        void removeArc(int i);
        
        /**
         * Gets a List of "substitution" elements
         */
        java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution> getSubstitutionList();
        
        /**
         * Gets array of all "substitution" elements
         * @deprecated
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution[] getSubstitutionArray();
        
        /**
         * Gets ith "substitution" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution getSubstitutionArray(int i);
        
        /**
         * Returns number of "substitution" element
         */
        int sizeOfSubstitutionArray();
        
        /**
         * Sets array of all "substitution" element
         */
        void setSubstitutionArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution[] substitutionArray);
        
        /**
         * Sets ith "substitution" element
         */
        void setSubstitutionArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution substitution);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "substitution" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution insertNewSubstitution(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "substitution" element
         */
        ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution addNewSubstitution();
        
        /**
         * Removes the ith "substitution" element
         */
        void removeSubstitution(int i);
        
        /**
         * Gets the "type" attribute
         */
        ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum getType();
        
        /**
         * Gets (as xml) the "type" attribute
         */
        ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type xgetType();
        
        /**
         * True if has "type" attribute
         */
        boolean isSetType();
        
        /**
         * Sets the "type" attribute
         */
        void setType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum type);
        
        /**
         * Sets (as xml) the "type" attribute
         */
        void xsetType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type type);
        
        /**
         * Unsets the "type" attribute
         */
        void unsetType();
        
        /**
         * An XML suboperation(@).
         *
         * This is a complex type.
         */
        public interface Suboperation extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Suboperation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sECB862A04A055A0DA9480D72543BD8FC").resolveHandle("suboperationb73eelemtype");
            
            /**
             * Gets the "type" attribute
             */
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum getType();
            
            /**
             * Gets (as xml) the "type" attribute
             */
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type xgetType();
            
            /**
             * True if has "type" attribute
             */
            boolean isSetType();
            
            /**
             * Sets the "type" attribute
             */
            void setType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum type);
            
            /**
             * Sets (as xml) the "type" attribute
             */
            void xsetType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type type);
            
            /**
             * Unsets the "type" attribute
             */
            void unsetType();
            
            /**
             * Gets the "title" attribute
             */
            java.lang.String getTitle();
            
            /**
             * Gets (as xml) the "title" attribute
             */
            org.apache.xmlbeans.XmlString xgetTitle();
            
            /**
             * True if has "title" attribute
             */
            boolean isSetTitle();
            
            /**
             * Sets the "title" attribute
             */
            void setTitle(java.lang.String title);
            
            /**
             * Sets (as xml) the "title" attribute
             */
            void xsetTitle(org.apache.xmlbeans.XmlString title);
            
            /**
             * Unsets the "title" attribute
             */
            void unsetTitle();
            
            /**
             * Gets the "href" attribute
             */
            java.lang.String getHref();
            
            /**
             * Gets (as xml) the "href" attribute
             */
            org.apache.xmlbeans.XmlAnyURI xgetHref();
            
            /**
             * True if has "href" attribute
             */
            boolean isSetHref();
            
            /**
             * Sets the "href" attribute
             */
            void setHref(java.lang.String href);
            
            /**
             * Sets (as xml) the "href" attribute
             */
            void xsetHref(org.apache.xmlbeans.XmlAnyURI href);
            
            /**
             * Unsets the "href" attribute
             */
            void unsetHref();
            
            /**
             * Gets the "label" attribute
             */
            java.lang.String getLabel();
            
            /**
             * Gets (as xml) the "label" attribute
             */
            org.apache.xmlbeans.XmlNMTOKEN xgetLabel();
            
            /**
             * True if has "label" attribute
             */
            boolean isSetLabel();
            
            /**
             * Sets the "label" attribute
             */
            void setLabel(java.lang.String label);
            
            /**
             * Sets (as xml) the "label" attribute
             */
            void xsetLabel(org.apache.xmlbeans.XmlNMTOKEN label);
            
            /**
             * Unsets the "label" attribute
             */
            void unsetLabel();
            
            /**
             * Gets the "actuate" attribute
             */
            java.lang.String getActuate();
            
            /**
             * Gets (as xml) the "actuate" attribute
             */
            org.apache.xmlbeans.XmlString xgetActuate();
            
            /**
             * True if has "actuate" attribute
             */
            boolean isSetActuate();
            
            /**
             * Sets the "actuate" attribute
             */
            void setActuate(java.lang.String actuate);
            
            /**
             * Sets (as xml) the "actuate" attribute
             */
            void xsetActuate(org.apache.xmlbeans.XmlString actuate);
            
            /**
             * Unsets the "actuate" attribute
             */
            void unsetActuate();
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation newInstance() {
                  return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML arc(@).
         *
         * This is a complex type.
         */
        public interface Arc extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Arc.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sECB862A04A055A0DA9480D72543BD8FC").resolveHandle("arc5a19elemtype");
            
            /**
             * Gets the "type" attribute
             */
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum getType();
            
            /**
             * Gets (as xml) the "type" attribute
             */
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type xgetType();
            
            /**
             * True if has "type" attribute
             */
            boolean isSetType();
            
            /**
             * Sets the "type" attribute
             */
            void setType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum type);
            
            /**
             * Sets (as xml) the "type" attribute
             */
            void xsetType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type type);
            
            /**
             * Unsets the "type" attribute
             */
            void unsetType();
            
            /**
             * Gets the "title" attribute
             */
            java.lang.String getTitle();
            
            /**
             * Gets (as xml) the "title" attribute
             */
            org.apache.xmlbeans.XmlString xgetTitle();
            
            /**
             * True if has "title" attribute
             */
            boolean isSetTitle();
            
            /**
             * Sets the "title" attribute
             */
            void setTitle(java.lang.String title);
            
            /**
             * Sets (as xml) the "title" attribute
             */
            void xsetTitle(org.apache.xmlbeans.XmlString title);
            
            /**
             * Unsets the "title" attribute
             */
            void unsetTitle();
            
            /**
             * Gets the "from" attribute
             */
            java.lang.String getFrom();
            
            /**
             * Gets (as xml) the "from" attribute
             */
            org.apache.xmlbeans.XmlAnyURI xgetFrom();
            
            /**
             * True if has "from" attribute
             */
            boolean isSetFrom();
            
            /**
             * Sets the "from" attribute
             */
            void setFrom(java.lang.String from);
            
            /**
             * Sets (as xml) the "from" attribute
             */
            void xsetFrom(org.apache.xmlbeans.XmlAnyURI from);
            
            /**
             * Unsets the "from" attribute
             */
            void unsetFrom();
            
            /**
             * Gets the "to" attribute
             */
            java.lang.String getTo();
            
            /**
             * Gets (as xml) the "to" attribute
             */
            org.apache.xmlbeans.XmlAnyURI xgetTo();
            
            /**
             * True if has "to" attribute
             */
            boolean isSetTo();
            
            /**
             * Sets the "to" attribute
             */
            void setTo(java.lang.String to);
            
            /**
             * Sets (as xml) the "to" attribute
             */
            void xsetTo(org.apache.xmlbeans.XmlAnyURI to);
            
            /**
             * Unsets the "to" attribute
             */
            void unsetTo();
            
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
             * Gets the "actuate" attribute
             */
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum getActuate();
            
            /**
             * Gets (as xml) the "actuate" attribute
             */
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate xgetActuate();
            
            /**
             * True if has "actuate" attribute
             */
            boolean isSetActuate();
            
            /**
             * Sets the "actuate" attribute
             */
            void setActuate(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum actuate);
            
            /**
             * Sets (as xml) the "actuate" attribute
             */
            void xsetActuate(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate actuate);
            
            /**
             * Unsets the "actuate" attribute
             */
            void unsetActuate();
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc newInstance() {
                  return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML substitution(@).
         *
         * This is a complex type.
         */
        public interface Substitution extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Substitution.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sECB862A04A055A0DA9480D72543BD8FC").resolveHandle("substitution9e94elemtype");
            
            /**
             * Gets the "from" attribute
             */
            java.lang.String getFrom();
            
            /**
             * Gets (as xml) the "from" attribute
             */
            org.apache.xmlbeans.XmlString xgetFrom();
            
            /**
             * True if has "from" attribute
             */
            boolean isSetFrom();
            
            /**
             * Sets the "from" attribute
             */
            void setFrom(java.lang.String from);
            
            /**
             * Sets (as xml) the "from" attribute
             */
            void xsetFrom(org.apache.xmlbeans.XmlString from);
            
            /**
             * Unsets the "from" attribute
             */
            void unsetFrom();
            
            /**
             * Gets the "to" attribute
             */
            java.lang.String getTo();
            
            /**
             * Gets (as xml) the "to" attribute
             */
            org.apache.xmlbeans.XmlString xgetTo();
            
            /**
             * True if has "to" attribute
             */
            boolean isSetTo();
            
            /**
             * Sets the "to" attribute
             */
            void setTo(java.lang.String to);
            
            /**
             * Sets (as xml) the "to" attribute
             */
            void xsetTo(org.apache.xmlbeans.XmlString to);
            
            /**
             * Unsets the "to" attribute
             */
            void unsetTo();
            
            /**
             * Gets the "when" attribute
             */
            java.lang.String getWhen();
            
            /**
             * Gets (as xml) the "when" attribute
             */
            org.apache.xmlbeans.XmlString xgetWhen();
            
            /**
             * True if has "when" attribute
             */
            boolean isSetWhen();
            
            /**
             * Sets the "when" attribute
             */
            void setWhen(java.lang.String when);
            
            /**
             * Sets (as xml) the "when" attribute
             */
            void xsetWhen(org.apache.xmlbeans.XmlString when);
            
            /**
             * Unsets the "when" attribute
             */
            void unsetWhen();
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution newInstance() {
                  return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex newInstance() {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument newInstance() {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
