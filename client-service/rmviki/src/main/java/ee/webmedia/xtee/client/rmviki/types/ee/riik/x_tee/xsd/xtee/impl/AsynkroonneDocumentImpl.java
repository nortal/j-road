/*
 * An XML document type.
 * Localname: asynkroonne
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AsynkroonneDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one asynkroonne(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class AsynkroonneDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AsynkroonneDocument
{
    private static final long serialVersionUID = 1L;
    
    public AsynkroonneDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASYNKROONNE$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "asynkroonne");
    
    
    /**
     * Gets the "asynkroonne" element
     */
    public boolean getAsynkroonne()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASYNKROONNE$0, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "asynkroonne" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetAsynkroonne()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ASYNKROONNE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "asynkroonne" element
     */
    public void setAsynkroonne(boolean asynkroonne)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ASYNKROONNE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ASYNKROONNE$0);
            }
            target.setBooleanValue(asynkroonne);
        }
    }
    
    /**
     * Sets (as xml) the "asynkroonne" element
     */
    public void xsetAsynkroonne(org.apache.xmlbeans.XmlBoolean asynkroonne)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ASYNKROONNE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ASYNKROONNE$0);
            }
            target.set(asynkroonne);
        }
    }
}
