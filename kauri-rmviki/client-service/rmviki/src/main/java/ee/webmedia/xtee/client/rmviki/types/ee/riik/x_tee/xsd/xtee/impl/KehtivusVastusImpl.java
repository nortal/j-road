/*
 * XML Type:  kehtivus_vastus
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.KehtivusVastus
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * An XML kehtivus_vastus(@http://x-tee.riik.ee/xsd/xtee.xsd).
 *
 * This is a complex type.
 */
public class KehtivusVastusImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.KehtivusVastus
{
    private static final long serialVersionUID = 1L;
    
    public KehtivusVastusImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName KEHTIVUS$0 = 
        new javax.xml.namespace.QName("", "kehtivus");
    private static final javax.xml.namespace.QName NIMETUS$2 = 
        new javax.xml.namespace.QName("", "nimetus");
    
    
    /**
     * Gets the "kehtivus" element
     */
    public boolean getKehtivus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KEHTIVUS$0, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "kehtivus" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetKehtivus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(KEHTIVUS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "kehtivus" element
     */
    public void setKehtivus(boolean kehtivus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KEHTIVUS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(KEHTIVUS$0);
            }
            target.setBooleanValue(kehtivus);
        }
    }
    
    /**
     * Sets (as xml) the "kehtivus" element
     */
    public void xsetKehtivus(org.apache.xmlbeans.XmlBoolean kehtivus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(KEHTIVUS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(KEHTIVUS$0);
            }
            target.set(kehtivus);
        }
    }
    
    /**
     * Gets the "nimetus" element
     */
    public java.lang.String getNimetus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NIMETUS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "nimetus" element
     */
    public org.apache.xmlbeans.XmlString xgetNimetus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NIMETUS$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "nimetus" element
     */
    public void setNimetus(java.lang.String nimetus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NIMETUS$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NIMETUS$2);
            }
            target.setStringValue(nimetus);
        }
    }
    
    /**
     * Sets (as xml) the "nimetus" element
     */
    public void xsetNimetus(org.apache.xmlbeans.XmlString nimetus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NIMETUS$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NIMETUS$2);
            }
            target.set(nimetus);
        }
    }
}
