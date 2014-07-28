/*
 * An XML document type.
 * Localname: asutus
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AsutusDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one asutus(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class AsutusDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AsutusDocument
{
    private static final long serialVersionUID = 1L;
    
    public AsutusDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASUTUS$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "asutus");
    
    
    /**
     * Gets the "asutus" element
     */
    public java.lang.String getAsutus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASUTUS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "asutus" element
     */
    public org.apache.xmlbeans.XmlString xgetAsutus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ASUTUS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "asutus" element
     */
    public void setAsutus(java.lang.String asutus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASUTUS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASUTUS$0);
            }
            target.setStringValue(asutus);
        }
    }
    
    /**
     * Sets (as xml) the "asutus" element
     */
    public void xsetAsutus(org.apache.xmlbeans.XmlString asutus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ASUTUS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ASUTUS$0);
            }
            target.set(asutus);
        }
    }
}
