/*
 * An XML document type.
 * Localname: andmekogu
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AndmekoguDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one andmekogu(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class AndmekoguDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AndmekoguDocument
{
    private static final long serialVersionUID = 1L;
    
    public AndmekoguDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANDMEKOGU$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "andmekogu");
    
    
    /**
     * Gets the "andmekogu" element
     */
    public java.lang.String getAndmekogu()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ANDMEKOGU$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "andmekogu" element
     */
    public org.apache.xmlbeans.XmlString xgetAndmekogu()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ANDMEKOGU$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "andmekogu" element
     */
    public void setAndmekogu(java.lang.String andmekogu)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ANDMEKOGU$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ANDMEKOGU$0);
            }
            target.setStringValue(andmekogu);
        }
    }
    
    /**
     * Sets (as xml) the "andmekogu" element
     */
    public void xsetAndmekogu(org.apache.xmlbeans.XmlString andmekogu)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ANDMEKOGU$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ANDMEKOGU$0);
            }
            target.set(andmekogu);
        }
    }
}
