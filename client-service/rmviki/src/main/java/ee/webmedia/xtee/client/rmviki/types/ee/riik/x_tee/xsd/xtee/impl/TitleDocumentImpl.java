/*
 * An XML document type.
 * Localname: title
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one title(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class TitleDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument
{
    private static final long serialVersionUID = 1L;
    
    public TitleDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TITLE$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "title");
    
    
    /**
     * Gets the "title" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title getTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title)get_store().find_element_user(TITLE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "title" element
     */
    public void setTitle(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title)get_store().find_element_user(TITLE$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title)get_store().add_element_user(TITLE$0);
            }
            target.set(title);
        }
    }
    
    /**
     * Appends and returns a new empty "title" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title addNewTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title)get_store().add_element_user(TITLE$0);
            return target;
        }
    }
    /**
     * An XML title(@http://x-tee.riik.ee/xsd/xtee.xsd).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument$Title.
     */
    public static class TitleImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.TitleDocument.Title
    {
        private static final long serialVersionUID = 1L;
        
        public TitleImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, true);
        }
        
        protected TitleImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
        
        private static final javax.xml.namespace.QName LANG$0 = 
            new javax.xml.namespace.QName("http://www.w3.org/XML/1998/namespace", "lang");
        
        
        /**
         * Gets the "lang" attribute
         */
        public java.lang.String getLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANG$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(LANG$0);
                }
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "lang" attribute
         */
        public org.apache.xmlbeans.XmlLanguage xgetLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLanguage target = null;
                target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANG$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLanguage)get_default_attribute_value(LANG$0);
                }
                return target;
            }
        }
        
        /**
         * True if has "lang" attribute
         */
        public boolean isSetLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(LANG$0) != null;
            }
        }
        
        /**
         * Sets the "lang" attribute
         */
        public void setLang(java.lang.String lang)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANG$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LANG$0);
                }
                target.setStringValue(lang);
            }
        }
        
        /**
         * Sets (as xml) the "lang" attribute
         */
        public void xsetLang(org.apache.xmlbeans.XmlLanguage lang)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLanguage target = null;
                target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANG$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLanguage)get_store().add_attribute_user(LANG$0);
                }
                target.set(lang);
            }
        }
        
        /**
         * Unsets the "lang" attribute
         */
        public void unsetLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(LANG$0);
            }
        }
    }
}
