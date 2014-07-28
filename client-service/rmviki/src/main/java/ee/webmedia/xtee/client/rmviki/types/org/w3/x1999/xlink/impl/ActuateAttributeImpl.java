/*
 * An XML attribute type.
 * Localname: actuate
 * Namespace: http://www.w3.org/1999/xlink
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.impl;
/**
 * A document containing one actuate(@http://www.w3.org/1999/xlink) attribute.
 *
 * This is a complex type.
 */
public class ActuateAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute
{
    private static final long serialVersionUID = 1L;
    
    public ActuateAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ACTUATE$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "actuate");
    
    
    /**
     * Gets the "actuate" attribute
     */
    public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum getActuate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ACTUATE$0);
            if (target == null)
            {
                return null;
            }
            return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "actuate" attribute
     */
    public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate xgetActuate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate)get_store().find_attribute_user(ACTUATE$0);
            return target;
        }
    }
    
    /**
     * True if has "actuate" attribute
     */
    public boolean isSetActuate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(ACTUATE$0) != null;
        }
    }
    
    /**
     * Sets the "actuate" attribute
     */
    public void setActuate(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum actuate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ACTUATE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ACTUATE$0);
            }
            target.setEnumValue(actuate);
        }
    }
    
    /**
     * Sets (as xml) the "actuate" attribute
     */
    public void xsetActuate(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate actuate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate)get_store().find_attribute_user(ACTUATE$0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate)get_store().add_attribute_user(ACTUATE$0);
            }
            target.set(actuate);
        }
    }
    
    /**
     * Unsets the "actuate" attribute
     */
    public void unsetActuate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(ACTUATE$0);
        }
    }
    /**
     * An XML actuate(@http://www.w3.org/1999/xlink).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute$Actuate.
     */
    public static class ActuateImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate
    {
        private static final long serialVersionUID = 1L;
        
        public ActuateImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ActuateImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
