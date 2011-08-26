/*
 * An XML document type.
 * Localname: wildcard
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one wildcard(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class WildcardDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument
{
    private static final long serialVersionUID = 1L;
    
    public WildcardDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WILDCARD$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "wildcard");
    
    
    /**
     * Gets the "wildcard" element
     */
    public java.lang.String getWildcard()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WILDCARD$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "wildcard" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument.Wildcard xgetWildcard()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument.Wildcard target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument.Wildcard)get_store().find_element_user(WILDCARD$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "wildcard" element
     */
    public void setWildcard(java.lang.String wildcard)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WILDCARD$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WILDCARD$0);
            }
            target.setStringValue(wildcard);
        }
    }
    
    /**
     * Sets (as xml) the "wildcard" element
     */
    public void xsetWildcard(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument.Wildcard wildcard)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument.Wildcard target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument.Wildcard)get_store().find_element_user(WILDCARD$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument.Wildcard)get_store().add_element_user(WILDCARD$0);
            }
            target.set(wildcard);
        }
    }
    /**
     * An XML wildcard(@http://x-tee.riik.ee/xsd/xtee.xsd).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument$Wildcard.
     */
    public static class WildcardImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.WildcardDocument.Wildcard
    {
        private static final long serialVersionUID = 1L;
        
        public WildcardImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected WildcardImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
