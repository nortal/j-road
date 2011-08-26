/*
 * An XML document type.
 * Localname: ametniknimi
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AmetniknimiDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one ametniknimi(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class AmetniknimiDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AmetniknimiDocument
{
    private static final long serialVersionUID = 1L;
    
    public AmetniknimiDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AMETNIKNIMI$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "ametniknimi");
    
    
    /**
     * Gets the "ametniknimi" element
     */
    public java.lang.String getAmetniknimi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AMETNIKNIMI$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ametniknimi" element
     */
    public org.apache.xmlbeans.XmlString xgetAmetniknimi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AMETNIKNIMI$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ametniknimi" element
     */
    public void setAmetniknimi(java.lang.String ametniknimi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AMETNIKNIMI$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AMETNIKNIMI$0);
            }
            target.setStringValue(ametniknimi);
        }
    }
    
    /**
     * Sets (as xml) the "ametniknimi" element
     */
    public void xsetAmetniknimi(org.apache.xmlbeans.XmlString ametniknimi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AMETNIKNIMI$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AMETNIKNIMI$0);
            }
            target.set(ametniknimi);
        }
    }
}
