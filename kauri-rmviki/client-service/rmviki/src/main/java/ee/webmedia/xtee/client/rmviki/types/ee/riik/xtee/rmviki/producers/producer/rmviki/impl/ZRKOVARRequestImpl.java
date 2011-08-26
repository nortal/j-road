/*
 * XML Type:  Z_RKOVAR.Request
 * Namespace: http://producers.rmviki.xtee.riik.ee/producer/rmviki
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.impl;
/**
 * An XML Z_RKOVAR.Request(@http://producers.rmviki.xtee.riik.ee/producer/rmviki).
 *
 * This is a complex type.
 */
public class ZRKOVARRequestImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest
{
    private static final long serialVersionUID = 1L;
    
    public ZRKOVARRequestImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName KOOD$0 = 
        new javax.xml.namespace.QName("", "KOOD");
    private static final javax.xml.namespace.QName NIMETUS$2 = 
        new javax.xml.namespace.QName("", "NIMETUS");
    
    
    /**
     * Gets the "KOOD" element
     */
    public java.lang.String getKOOD()
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
     * Gets (as xml) the "KOOD" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.KOOD xgetKOOD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.KOOD target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.KOOD)get_store().find_element_user(KOOD$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "KOOD" element
     */
    public boolean isSetKOOD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(KOOD$0) != 0;
        }
    }
    
    /**
     * Sets the "KOOD" element
     */
    public void setKOOD(java.lang.String kood)
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
     * Sets (as xml) the "KOOD" element
     */
    public void xsetKOOD(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.KOOD kood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.KOOD target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.KOOD)get_store().find_element_user(KOOD$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.KOOD)get_store().add_element_user(KOOD$0);
            }
            target.set(kood);
        }
    }
    
    /**
     * Unsets the "KOOD" element
     */
    public void unsetKOOD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(KOOD$0, 0);
        }
    }
    
    /**
     * Gets the "NIMETUS" element
     */
    public java.lang.String getNIMETUS()
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
     * Gets (as xml) the "NIMETUS" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.NIMETUS xgetNIMETUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.NIMETUS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.NIMETUS)get_store().find_element_user(NIMETUS$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "NIMETUS" element
     */
    public boolean isSetNIMETUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NIMETUS$2) != 0;
        }
    }
    
    /**
     * Sets the "NIMETUS" element
     */
    public void setNIMETUS(java.lang.String nimetus)
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
     * Sets (as xml) the "NIMETUS" element
     */
    public void xsetNIMETUS(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.NIMETUS nimetus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.NIMETUS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.NIMETUS)get_store().find_element_user(NIMETUS$2, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.NIMETUS)get_store().add_element_user(NIMETUS$2);
            }
            target.set(nimetus);
        }
    }
    
    /**
     * Unsets the "NIMETUS" element
     */
    public void unsetNIMETUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NIMETUS$2, 0);
        }
    }
    /**
     * An XML KOOD(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest$KOOD.
     */
    public static class KOODImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.KOOD
    {
        private static final long serialVersionUID = 1L;
        
        public KOODImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected KOODImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML NIMETUS(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest$NIMETUS.
     */
    public static class NIMETUSImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest.NIMETUS
    {
        private static final long serialVersionUID = 1L;
        
        public NIMETUSImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected NIMETUSImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
