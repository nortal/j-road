/*
 * An XML document type.
 * Localname: anyURI
 * Namespace: http://schemas.xmlsoap.org/soap/encoding/
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURIDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.impl;
/**
 * A document containing one anyURI(@http://schemas.xmlsoap.org/soap/encoding/) element.
 *
 * This is a complex type.
 */
public class AnyURIDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURIDocument
{
    private static final long serialVersionUID = 1L;
    
    public AnyURIDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANYURI$0 = 
        new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "anyURI");
    
    
    /**
     * Gets the "anyURI" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI getAnyURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI)get_store().find_element_user(ANYURI$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "anyURI" element
     */
    public void setAnyURI(ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI anyURI)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI)get_store().find_element_user(ANYURI$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI)get_store().add_element_user(ANYURI$0);
            }
            target.set(anyURI);
        }
    }
    
    /**
     * Appends and returns a new empty "anyURI" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI addNewAnyURI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.AnyURI)get_store().add_element_user(ANYURI$0);
            return target;
        }
    }
}
