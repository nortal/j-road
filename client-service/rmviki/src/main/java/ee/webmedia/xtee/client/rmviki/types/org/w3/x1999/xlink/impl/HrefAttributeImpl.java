/*
 * An XML attribute type.
 * Localname: href
 * Namespace: http://www.w3.org/1999/xlink
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.HrefAttribute
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.impl;
/**
 * A document containing one href(@http://www.w3.org/1999/xlink) attribute.
 *
 * This is a complex type.
 */
public class HrefAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.HrefAttribute
{
    private static final long serialVersionUID = 1L;
    
    public HrefAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName HREF$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "href");
    
    
    /**
     * Gets the "href" attribute
     */
    public java.lang.String getHref()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HREF$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "href" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetHref()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(HREF$0);
            return target;
        }
    }
    
    /**
     * True if has "href" attribute
     */
    public boolean isSetHref()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(HREF$0) != null;
        }
    }
    
    /**
     * Sets the "href" attribute
     */
    public void setHref(java.lang.String href)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HREF$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(HREF$0);
            }
            target.setStringValue(href);
        }
    }
    
    /**
     * Sets (as xml) the "href" attribute
     */
    public void xsetHref(org.apache.xmlbeans.XmlAnyURI href)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(HREF$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(HREF$0);
            }
            target.set(href);
        }
    }
    
    /**
     * Unsets the "href" attribute
     */
    public void unsetHref()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(HREF$0);
        }
    }
}
