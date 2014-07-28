/*
 * XML Type:  esindus_vastus
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * An XML esindus_vastus(@http://x-tee.riik.ee/xsd/xtee.xsd).
 *
 * This is a complex type.
 */
public class EsindusVastusImpl extends ee.webmedia.xtee.client.rmviki.types.org.xmlsoap.schemas.soap.encoding.impl.ArrayImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus
{
    private static final long serialVersionUID = 1L;
    
    public EsindusVastusImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ITEM$0 = 
        new javax.xml.namespace.QName("", "item");
    
    
    /**
     * Gets a List of "item" elements
     */
    public java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item> getItemList()
    {
        final class ItemList extends java.util.AbstractList<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item>
        {
            public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item get(int i)
                { return EsindusVastusImpl.this.getItemArray(i); }
            
            public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item set(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item o)
            {
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item old = EsindusVastusImpl.this.getItemArray(i);
                EsindusVastusImpl.this.setItemArray(i, o);
                return old;
            }
            
            public void add(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item o)
                { EsindusVastusImpl.this.insertNewItem(i).set(o); }
            
            public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item remove(int i)
            {
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item old = EsindusVastusImpl.this.getItemArray(i);
                EsindusVastusImpl.this.removeItem(i);
                return old;
            }
            
            public int size()
                { return EsindusVastusImpl.this.sizeOfItemArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new ItemList();
        }
    }
    
    /**
     * Gets array of all "item" elements
     * @deprecated
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item[] getItemArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item> targetList = new java.util.ArrayList<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item>();
            get_store().find_all_element_users(ITEM$0, targetList);
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item[] result = new ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "item" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item getItemArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item)get_store().find_element_user(ITEM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "item" element
     */
    public int sizeOfItemArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ITEM$0);
        }
    }
    
    /**
     * Sets array of all "item" element
     */
    public void setItemArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item[] itemArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(itemArray, ITEM$0);
        }
    }
    
    /**
     * Sets ith "item" element
     */
    public void setItemArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item item)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item)get_store().find_element_user(ITEM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(item);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "item" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item insertNewItem(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item)get_store().insert_element_user(ITEM$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "item" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item addNewItem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item)get_store().add_element_user(ITEM$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "item" element
     */
    public void removeItem(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ITEM$0, i);
        }
    }
    /**
     * An XML item(@).
     *
     * This is a complex type.
     */
    public static class ItemImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.EsindusVastus.Item
    {
        private static final long serialVersionUID = 1L;
        
        public ItemImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName KOOD$0 = 
            new javax.xml.namespace.QName("", "kood");
        private static final javax.xml.namespace.QName NIMETUS$2 = 
            new javax.xml.namespace.QName("", "nimetus");
        
        
        /**
         * Gets the "kood" element
         */
        public java.lang.String getKood()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KOOD$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "kood" element
         */
        public org.apache.xmlbeans.XmlString xgetKood()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(KOOD$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "kood" element
         */
        public void setKood(java.lang.String kood)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KOOD$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(KOOD$0);
                }
                target.setStringValue(kood);
            }
        }
        
        /**
         * Sets (as xml) the "kood" element
         */
        public void xsetKood(org.apache.xmlbeans.XmlString kood)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(KOOD$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(KOOD$0);
                }
                target.set(kood);
            }
        }
        
        /**
         * Gets the "nimetus" element
         */
        public java.lang.String getNimetus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NIMETUS$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "nimetus" element
         */
        public org.apache.xmlbeans.XmlString xgetNimetus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NIMETUS$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "nimetus" element
         */
        public void setNimetus(java.lang.String nimetus)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NIMETUS$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NIMETUS$2);
                }
                target.setStringValue(nimetus);
            }
        }
        
        /**
         * Sets (as xml) the "nimetus" element
         */
        public void xsetNimetus(org.apache.xmlbeans.XmlString nimetus)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NIMETUS$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NIMETUS$2);
                }
                target.set(nimetus);
            }
        }
    }
}
