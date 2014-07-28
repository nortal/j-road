/*
 * An XML document type.
 * Localname: requirecontent
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.RequirecontentDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one requirecontent(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class RequirecontentDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.RequirecontentDocument
{
    private static final long serialVersionUID = 1L;
    
    public RequirecontentDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REQUIRECONTENT$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "requirecontent");
    
    
    /**
     * Gets the "requirecontent" element
     */
    public java.lang.String getRequirecontent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUIRECONTENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "requirecontent" element
     */
    public org.apache.xmlbeans.XmlString xgetRequirecontent()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REQUIRECONTENT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "requirecontent" element
     */
    public void setRequirecontent(java.lang.String requirecontent)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUIRECONTENT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REQUIRECONTENT$0);
            }
            target.setStringValue(requirecontent);
        }
    }
    
    /**
     * Sets (as xml) the "requirecontent" element
     */
    public void xsetRequirecontent(org.apache.xmlbeans.XmlString requirecontent)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(REQUIRECONTENT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(REQUIRECONTENT$0);
            }
            target.set(requirecontent);
        }
    }
}
