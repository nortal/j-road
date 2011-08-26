/*
 * An XML attribute type.
 * Localname: from
 * Namespace: http://www.w3.org/1999/xlink
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.FromAttribute
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.impl;
/**
 * A document containing one from(@http://www.w3.org/1999/xlink) attribute.
 *
 * This is a complex type.
 */
public class FromAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.FromAttribute
{
    private static final long serialVersionUID = 1L;
    
    public FromAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FROM$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "from");
    
    
    /**
     * Gets the "from" attribute
     */
    public java.lang.String getFrom()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FROM$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "from" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetFrom()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(FROM$0);
            return target;
        }
    }
    
    /**
     * True if has "from" attribute
     */
    public boolean isSetFrom()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(FROM$0) != null;
        }
    }
    
    /**
     * Sets the "from" attribute
     */
    public void setFrom(java.lang.String from)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FROM$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FROM$0);
            }
            target.setStringValue(from);
        }
    }
    
    /**
     * Sets (as xml) the "from" attribute
     */
    public void xsetFrom(org.apache.xmlbeans.XmlAnyURI from)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(FROM$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(FROM$0);
            }
            target.set(from);
        }
    }
    
    /**
     * Unsets the "from" attribute
     */
    public void unsetFrom()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(FROM$0);
        }
    }
}
