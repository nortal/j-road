/*
 * An XML document type.
 * Localname: unsignedByte
 * Namespace: http://schemas.xmlsoap.org/soap/encoding/
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByteDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.impl;
/**
 * A document containing one unsignedByte(@http://schemas.xmlsoap.org/soap/encoding/) element.
 *
 * This is a complex type.
 */
public class UnsignedByteDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByteDocument
{
    private static final long serialVersionUID = 1L;
    
    public UnsignedByteDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNSIGNEDBYTE$0 = 
        new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "unsignedByte");
    
    
    /**
     * Gets the "unsignedByte" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte getUnsignedByte()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte)get_store().find_element_user(UNSIGNEDBYTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "unsignedByte" element
     */
    public void setUnsignedByte(ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte unsignedByte)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte)get_store().find_element_user(UNSIGNEDBYTE$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte)get_store().add_element_user(UNSIGNEDBYTE$0);
            }
            target.set(unsignedByte);
        }
    }
    
    /**
     * Appends and returns a new empty "unsignedByte" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte addNewUnsignedByte()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.UnsignedByte)get_store().add_element_user(UNSIGNEDBYTE$0);
            return target;
        }
    }
}
