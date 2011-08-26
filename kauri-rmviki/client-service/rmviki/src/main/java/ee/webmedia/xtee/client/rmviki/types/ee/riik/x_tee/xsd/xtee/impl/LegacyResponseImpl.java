/*
 * XML Type:  legacy_response
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.LegacyResponse
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * An XML legacy_response(@http://x-tee.riik.ee/xsd/xtee.xsd).
 *
 * This is a complex type.
 */
public class LegacyResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.LegacyResponse
{
    private static final long serialVersionUID = 1L;
    
    public LegacyResponseImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName URL$0 = 
        new javax.xml.namespace.QName("", "url");
    
    
    /**
     * Gets the "url" element
     */
    public java.lang.String getUrl()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(URL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "url" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.Url xgetUrl()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.Url target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.Url)get_store().find_element_user(URL$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "url" element
     */
    public void setUrl(java.lang.String url)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(URL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(URL$0);
            }
            target.setStringValue(url);
        }
    }
    
    /**
     * Sets (as xml) the "url" element
     */
    public void xsetUrl(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.Url url)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.Url target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.Url)get_store().find_element_user(URL$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.Url)get_store().add_element_user(URL$0);
            }
            target.set(url);
        }
    }
}
