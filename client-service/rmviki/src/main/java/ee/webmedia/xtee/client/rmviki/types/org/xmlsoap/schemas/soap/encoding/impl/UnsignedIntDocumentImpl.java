/*
 * An XML document type.
 * Localname: unsignedInt
 * Namespace: http://schemas.xmlsoap.org/soap/encoding/
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedIntDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.impl;
/**
 * A document containing one unsignedInt(@http://schemas.xmlsoap.org/soap/encoding/) element.
 *
 * This is a complex type.
 */
public class UnsignedIntDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedIntDocument
{
    private static final long serialVersionUID = 1L;
    
    public UnsignedIntDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNSIGNEDINT$0 = 
        new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedInt");
    
    
    /**
     * Gets the "unsignedInt" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt getUnsignedInt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt)get_store().find_element_user(UNSIGNEDINT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "unsignedInt" element
     */
    public void setUnsignedInt(ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt unsignedInt)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt)get_store().find_element_user(UNSIGNEDINT$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt)get_store().add_element_user(UNSIGNEDINT$0);
            }
            target.set(unsignedInt);
        }
    }
    
    /**
     * Appends and returns a new empty "unsignedInt" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt addNewUnsignedInt()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedInt)get_store().add_element_user(UNSIGNEDINT$0);
            return target;
        }
    }
}
