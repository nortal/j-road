/*
 * An XML attribute type.
 * Localname: show
 * Namespace: http://www.w3.org/1999/xlink
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.impl;
/**
 * A document containing one show(@http://www.w3.org/1999/xlink) attribute.
 *
 * This is a complex type.
 */
public class ShowAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute
{
    private static final long serialVersionUID = 1L;
    
    public ShowAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SHOW$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "show");
    
    
    /**
     * Gets the "show" attribute
     */
    public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show.Enum getShow()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SHOW$0);
            if (target == null)
            {
                return null;
            }
            return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "show" attribute
     */
    public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show xgetShow()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show)get_store().find_attribute_user(SHOW$0);
            return target;
        }
    }
    
    /**
     * True if has "show" attribute
     */
    public boolean isSetShow()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(SHOW$0) != null;
        }
    }
    
    /**
     * Sets the "show" attribute
     */
    public void setShow(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show.Enum show)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SHOW$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SHOW$0);
            }
            target.setEnumValue(show);
        }
    }
    
    /**
     * Sets (as xml) the "show" attribute
     */
    public void xsetShow(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show show)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show)get_store().find_attribute_user(SHOW$0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show)get_store().add_attribute_user(SHOW$0);
            }
            target.set(show);
        }
    }
    
    /**
     * Unsets the "show" attribute
     */
    public void unsetShow()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(SHOW$0);
        }
    }
    /**
     * An XML show(@http://www.w3.org/1999/xlink).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute$Show.
     */
    public static class ShowImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show
    {
        private static final long serialVersionUID = 1L;
        
        public ShowImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ShowImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
