/*
 * XML Type:  invalidInput
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.InvalidInput
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * An XML invalidInput(@http://x-tee.riik.ee/xsd/xtee.xsd).
 *
 * This is a complex type.
 */
public class InvalidInputImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.InvalidInput
{
    private static final long serialVersionUID = 1L;
    
    public InvalidInputImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FAULTCODE$0 = 
        new javax.xml.namespace.QName("", "faultCode");
    private static final javax.xml.namespace.QName FAULTSTRING$2 = 
        new javax.xml.namespace.QName("", "faultString");
    
    
    /**
     * Gets the "faultCode" element
     */
    public java.lang.String getFaultCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAULTCODE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "faultCode" element
     */
    public org.apache.xmlbeans.XmlString xgetFaultCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAULTCODE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "faultCode" element
     */
    public void setFaultCode(java.lang.String faultCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAULTCODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FAULTCODE$0);
            }
            target.setStringValue(faultCode);
        }
    }
    
    /**
     * Sets (as xml) the "faultCode" element
     */
    public void xsetFaultCode(org.apache.xmlbeans.XmlString faultCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAULTCODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FAULTCODE$0);
            }
            target.set(faultCode);
        }
    }
    
    /**
     * Gets the "faultString" element
     */
    public java.lang.String getFaultString()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAULTSTRING$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "faultString" element
     */
    public org.apache.xmlbeans.XmlString xgetFaultString()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAULTSTRING$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "faultString" element
     */
    public void setFaultString(java.lang.String faultString)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FAULTSTRING$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FAULTSTRING$2);
            }
            target.setStringValue(faultString);
        }
    }
    
    /**
     * Sets (as xml) the "faultString" element
     */
    public void xsetFaultString(org.apache.xmlbeans.XmlString faultString)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FAULTSTRING$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FAULTSTRING$2);
            }
            target.set(faultString);
        }
    }
}
