/*
 * An XML document type.
 * Localname: integer
 * Namespace: http://schemas.xmlsoap.org/soap/encoding/
 * Java type: ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.IntegerDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.impl;
/**
 * A document containing one integer(@http://schemas.xmlsoap.org/soap/encoding/) element.
 *
 * This is a complex type.
 */
public class IntegerDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.IntegerDocument
{
    private static final long serialVersionUID = 1L;
    
    public IntegerDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INTEGER$0 = 
        new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "integer");
    
    
    /**
     * Gets the "integer" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer getInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer)get_store().find_element_user(INTEGER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "integer" element
     */
    public void setInteger(ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer integer)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer)get_store().find_element_user(INTEGER$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer)get_store().add_element_user(INTEGER$0);
            }
            target.set(integer);
        }
    }
    
    /**
     * Appends and returns a new empty "integer" element
     */
    public ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer addNewInteger()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.Integer)get_store().add_element_user(INTEGER$0);
            return target;
        }
    }
}
