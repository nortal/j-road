/*
 * An XML attribute type.
 * Localname: to
 * Namespace: http://www.w3.org/1999/xlink
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ToAttribute
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.impl;
/**
 * A document containing one to(@http://www.w3.org/1999/xlink) attribute.
 *
 * This is a complex type.
 */
public class ToAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ToAttribute
{
    private static final long serialVersionUID = 1L;
    
    public ToAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TO$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "to");
    
    
    /**
     * Gets the "to" attribute
     */
    public java.lang.String getTo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TO$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "to" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetTo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(TO$0);
            return target;
        }
    }
    
    /**
     * True if has "to" attribute
     */
    public boolean isSetTo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(TO$0) != null;
        }
    }
    
    /**
     * Sets the "to" attribute
     */
    public void setTo(java.lang.String to)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TO$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TO$0);
            }
            target.setStringValue(to);
        }
    }
    
    /**
     * Sets (as xml) the "to" attribute
     */
    public void xsetTo(org.apache.xmlbeans.XmlAnyURI to)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(TO$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(TO$0);
            }
            target.set(to);
        }
    }
    
    /**
     * Unsets the "to" attribute
     */
    public void unsetTo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(TO$0);
        }
    }
}
