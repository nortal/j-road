/*
 * An XML document type.
 * Localname: nonNegativeInteger
 * Namespace: http://schemas.xmlsoap.org/soap/encoding/
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeIntegerDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.impl;
/**
 * A document containing one nonNegativeInteger(@http://schemas.xmlsoap.org/soap/encoding/) element.
 *
 * This is a complex type.
 */
public class NonNegativeIntegerDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeIntegerDocument
{
    private static final long serialVersionUID = 1L;
    
    public NonNegativeIntegerDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NONNEGATIVEINTEGER$0 = 
        new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "nonNegativeInteger");
    
    
    /**
     * Gets the "nonNegativeInteger" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger getNonNegativeInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger)get_store().find_element_user(NONNEGATIVEINTEGER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "nonNegativeInteger" element
     */
    public void setNonNegativeInteger(ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger nonNegativeInteger)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger)get_store().find_element_user(NONNEGATIVEINTEGER$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger)get_store().add_element_user(NONNEGATIVEINTEGER$0);
            }
            target.set(nonNegativeInteger);
        }
    }
    
    /**
     * Appends and returns a new empty "nonNegativeInteger" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger addNewNonNegativeInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NonNegativeInteger)get_store().add_element_user(NONNEGATIVEINTEGER$0);
            return target;
        }
    }
}
