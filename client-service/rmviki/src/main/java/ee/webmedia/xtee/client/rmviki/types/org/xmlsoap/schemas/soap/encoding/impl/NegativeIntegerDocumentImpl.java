/*
 * An XML document type.
 * Localname: negativeInteger
 * Namespace: http://schemas.xmlsoap.org/soap/encoding/
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeIntegerDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.impl;
/**
 * A document containing one negativeInteger(@http://schemas.xmlsoap.org/soap/encoding/) element.
 *
 * This is a complex type.
 */
public class NegativeIntegerDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeIntegerDocument
{
    private static final long serialVersionUID = 1L;
    
    public NegativeIntegerDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NEGATIVEINTEGER$0 = 
        new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "negativeInteger");
    
    
    /**
     * Gets the "negativeInteger" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger getNegativeInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger)get_store().find_element_user(NEGATIVEINTEGER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "negativeInteger" element
     */
    public void setNegativeInteger(ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger negativeInteger)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger)get_store().find_element_user(NEGATIVEINTEGER$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger)get_store().add_element_user(NEGATIVEINTEGER$0);
            }
            target.set(negativeInteger);
        }
    }
    
    /**
     * Appends and returns a new empty "negativeInteger" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger addNewNegativeInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.NegativeInteger)get_store().add_element_user(NEGATIVEINTEGER$0);
            return target;
        }
    }
}
