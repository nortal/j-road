/*
 * An XML document type.
 * Localname: address
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one address(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class AddressDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument
{
    private static final long serialVersionUID = 1L;
    
    public AddressDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDRESS$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "address");
    
    
    /**
     * Gets the "address" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address getAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address)get_store().find_element_user(ADDRESS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "address" element
     */
    public void setAddress(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address address)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address)get_store().find_element_user(ADDRESS$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address)get_store().add_element_user(ADDRESS$0);
            }
            target.set(address);
        }
    }
    
    /**
     * Appends and returns a new empty "address" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address addNewAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address)get_store().add_element_user(ADDRESS$0);
            return target;
        }
    }
    /**
     * An XML address(@http://x-tee.riik.ee/xsd/xtee.xsd).
     *
     * This is a complex type.
     */
    public static class AddressImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.AddressDocument.Address
    {
        private static final long serialVersionUID = 1L;
        
        public AddressImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PRODUCER$0 = 
            new javax.xml.namespace.QName("", "producer");
        
        
        /**
         * Gets the "producer" attribute
         */
        public java.lang.String getProducer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PRODUCER$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "producer" attribute
         */
        public org.apache.xmlbeans.XmlString xgetProducer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PRODUCER$0);
                return target;
            }
        }
        
        /**
         * True if has "producer" attribute
         */
        public boolean isSetProducer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(PRODUCER$0) != null;
            }
        }
        
        /**
         * Sets the "producer" attribute
         */
        public void setProducer(java.lang.String producer)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PRODUCER$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PRODUCER$0);
                }
                target.setStringValue(producer);
            }
        }
        
        /**
         * Sets (as xml) the "producer" attribute
         */
        public void xsetProducer(org.apache.xmlbeans.XmlString producer)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PRODUCER$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PRODUCER$0);
                }
                target.set(producer);
            }
        }
        
        /**
         * Unsets the "producer" attribute
         */
        public void unsetProducer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(PRODUCER$0);
            }
        }
    }
}
