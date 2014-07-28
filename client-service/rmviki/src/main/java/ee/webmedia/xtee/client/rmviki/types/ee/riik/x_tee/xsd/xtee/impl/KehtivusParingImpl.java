/*
 * XML Type:  kehtivus_paring
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.KehtivusParing
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * An XML kehtivus_paring(@http://x-tee.riik.ee/xsd/xtee.xsd).
 *
 * This is a complex type.
 */
public class KehtivusParingImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.KehtivusParing
{
    private static final long serialVersionUID = 1L;
    
    public KehtivusParingImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName KOOD$0 = 
        new javax.xml.namespace.QName("", "kood");
    
    
    /**
     * Gets the "kood" element
     */
    public java.lang.String getKood()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KOOD$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "kood" element
     */
    public org.apache.xmlbeans.XmlString xgetKood()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(KOOD$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "kood" element
     */
    public void setKood(java.lang.String kood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KOOD$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(KOOD$0);
            }
            target.setStringValue(kood);
        }
    }
    
    /**
     * Sets (as xml) the "kood" element
     */
    public void xsetKood(org.apache.xmlbeans.XmlString kood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(KOOD$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(KOOD$0);
            }
            target.set(kood);
        }
    }
}
