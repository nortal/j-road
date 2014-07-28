/*
 * XML Type:  rarVtaRequestType
 * Namespace: http://producers.rmviki.xtee.riik.ee/producer/rmviki
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaRequestType
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.impl;
/**
 * An XML rarVtaRequestType(@http://producers.rmviki.xtee.riik.ee/producer/rmviki).
 *
 * This is a complex type.
 */
public class RarVtaRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaRequestType
{
    private static final long serialVersionUID = 1L;
    
    public RarVtaRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
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
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType xgetKood()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType)get_store().find_element_user(KOOD$0, 0);
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
    public void xsetKood(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType kood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType)get_store().find_element_user(KOOD$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType)get_store().add_element_user(KOOD$0);
            }
            target.set(kood);
        }
    }
}
