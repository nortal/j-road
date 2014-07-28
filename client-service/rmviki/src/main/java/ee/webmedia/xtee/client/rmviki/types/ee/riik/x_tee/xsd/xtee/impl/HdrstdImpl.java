/*
 * XML Type:  hdrstd
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.Hdrstd
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * An XML hdrstd(@http://x-tee.riik.ee/xsd/xtee.xsd).
 *
 * This is a complex type.
 */
public class HdrstdImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.Hdrstd
{
    private static final long serialVersionUID = 1L;
    
    public HdrstdImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ASUTUS$0 = 
        new javax.xml.namespace.QName("", "asutus");
    private static final javax.xml.namespace.QName ANDMEKOGU$2 = 
        new javax.xml.namespace.QName("", "andmekogu");
    private static final javax.xml.namespace.QName ISIKUKOOD$4 = 
        new javax.xml.namespace.QName("", "isikukood");
    private static final javax.xml.namespace.QName ID$6 = 
        new javax.xml.namespace.QName("", "id");
    private static final javax.xml.namespace.QName NIMI$8 = 
        new javax.xml.namespace.QName("", "nimi");
    private static final javax.xml.namespace.QName TOIMIK$10 = 
        new javax.xml.namespace.QName("", "toimik");
    
    
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
    
    /**
     * Gets the "andmekogu" element
     */
    public java.lang.String getAndmekogu()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ANDMEKOGU$2, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ANDMEKOGU$2, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ANDMEKOGU$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ANDMEKOGU$2);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ANDMEKOGU$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ANDMEKOGU$2);
            }
            target.set(andmekogu);
        }
    }
    
    /**
     * Gets the "isikukood" element
     */
    public java.lang.String getIsikukood()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISIKUKOOD$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "isikukood" element
     */
    public org.apache.xmlbeans.XmlString xgetIsikukood()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISIKUKOOD$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "isikukood" element
     */
    public void setIsikukood(java.lang.String isikukood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISIKUKOOD$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISIKUKOOD$4);
            }
            target.setStringValue(isikukood);
        }
    }
    
    /**
     * Sets (as xml) the "isikukood" element
     */
    public void xsetIsikukood(org.apache.xmlbeans.XmlString isikukood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ISIKUKOOD$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ISIKUKOOD$4);
            }
            target.set(isikukood);
        }
    }
    
    /**
     * Gets the "id" element
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" element
     */
    public org.apache.xmlbeans.XmlString xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "id" element
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ID$6);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" element
     */
    public void xsetId(org.apache.xmlbeans.XmlString id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ID$6);
            }
            target.set(id);
        }
    }
    
    /**
     * Gets the "nimi" element
     */
    public java.lang.String getNimi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NIMI$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "nimi" element
     */
    public org.apache.xmlbeans.XmlString xgetNimi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NIMI$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "nimi" element
     */
    public void setNimi(java.lang.String nimi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NIMI$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NIMI$8);
            }
            target.setStringValue(nimi);
        }
    }
    
    /**
     * Sets (as xml) the "nimi" element
     */
    public void xsetNimi(org.apache.xmlbeans.XmlString nimi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NIMI$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NIMI$8);
            }
            target.set(nimi);
        }
    }
    
    /**
     * Gets the "toimik" element
     */
    public java.lang.String getToimik()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOIMIK$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "toimik" element
     */
    public org.apache.xmlbeans.XmlString xgetToimik()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOIMIK$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "toimik" element
     */
    public boolean isSetToimik()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TOIMIK$10) != 0;
        }
    }
    
    /**
     * Sets the "toimik" element
     */
    public void setToimik(java.lang.String toimik)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOIMIK$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TOIMIK$10);
            }
            target.setStringValue(toimik);
        }
    }
    
    /**
     * Sets (as xml) the "toimik" element
     */
    public void xsetToimik(org.apache.xmlbeans.XmlString toimik)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOIMIK$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TOIMIK$10);
            }
            target.set(toimik);
        }
    }
    
    /**
     * Unsets the "toimik" element
     */
    public void unsetToimik()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TOIMIK$10, 0);
        }
    }
}
