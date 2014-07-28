/*
 * An XML document type.
 * Localname: notes
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one notes(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class NotesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument
{
    private static final long serialVersionUID = 1L;
    
    public NotesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NOTES$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "notes");
    
    
    /**
     * Gets the "notes" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes getNotes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes)get_store().find_element_user(NOTES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "notes" element
     */
    public void setNotes(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes notes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes)get_store().find_element_user(NOTES$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes)get_store().add_element_user(NOTES$0);
            }
            target.set(notes);
        }
    }
    
    /**
     * Appends and returns a new empty "notes" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes addNewNotes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes)get_store().add_element_user(NOTES$0);
            return target;
        }
    }
    /**
     * An XML notes(@http://x-tee.riik.ee/xsd/xtee.xsd).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument$Notes.
     */
    public static class NotesImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.NotesDocument.Notes
    {
        private static final long serialVersionUID = 1L;
        
        public NotesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, true);
        }
        
        protected NotesImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
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
