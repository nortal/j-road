/*
 * XML Type:  Z_RKOVAR.Response
 * Namespace: http://producers.rmviki.xtee.riik.ee/producer/rmviki
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.impl;
/**
 * An XML Z_RKOVAR.Response(@http://producers.rmviki.xtee.riik.ee/producer/rmviki).
 *
 * This is a complex type.
 */
public class ZRKOVARResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse
{
    private static final long serialVersionUID = 1L;
    
    public ZRKOVARResponseImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EKSPORDIAEG$0 = 
        new javax.xml.namespace.QName("", "EKSPORDIAEG");
    private static final javax.xml.namespace.QName ISIKUD$2 = 
        new javax.xml.namespace.QName("", "ISIKUD");
    
    
    /**
     * Gets the "EKSPORDIAEG" element
     */
    public long getEKSPORDIAEG()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EKSPORDIAEG$0, 0);
            if (target == null)
            {
                return 0L;
            }
            return target.getLongValue();
        }
    }
    
    /**
     * Gets (as xml) the "EKSPORDIAEG" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG xgetEKSPORDIAEG()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG)get_store().find_element_user(EKSPORDIAEG$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EKSPORDIAEG" element
     */
    public void setEKSPORDIAEG(long ekspordiaeg)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EKSPORDIAEG$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EKSPORDIAEG$0);
            }
            target.setLongValue(ekspordiaeg);
        }
    }
    
    /**
     * Sets (as xml) the "EKSPORDIAEG" element
     */
    public void xsetEKSPORDIAEG(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG ekspordiaeg)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG)get_store().find_element_user(EKSPORDIAEG$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG)get_store().add_element_user(EKSPORDIAEG$0);
            }
            target.set(ekspordiaeg);
        }
    }
    
    /**
     * Gets the "ISIKUD" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD getISIKUD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD)get_store().find_element_user(ISIKUD$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ISIKUD" element
     */
    public void setISIKUD(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD isikud)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD)get_store().find_element_user(ISIKUD$2, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD)get_store().add_element_user(ISIKUD$2);
            }
            target.set(isikud);
        }
    }
    
    /**
     * Appends and returns a new empty "ISIKUD" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD addNewISIKUD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD)get_store().add_element_user(ISIKUD$2);
            return target;
        }
    }
    /**
     * An XML EKSPORDIAEG(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse$EKSPORDIAEG.
     */
    public static class EKSPORDIAEGImpl extends org.apache.xmlbeans.impl.values.JavaLongHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.EKSPORDIAEG
    {
        private static final long serialVersionUID = 1L;
        
        public EKSPORDIAEGImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected EKSPORDIAEGImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML ISIKUD(@).
     *
     * This is a complex type.
     */
    public static class ISIKUDImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse.ISIKUD
    {
        private static final long serialVersionUID = 1L;
        
        public ISIKUDImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ITEM$0 = 
            new javax.xml.namespace.QName("", "item");
        
        
        /**
         * Gets a List of "item" elements
         */
        public java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR> getItemList()
        {
            final class ItemList extends java.util.AbstractList<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR>
            {
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR get(int i)
                    { return ISIKUDImpl.this.getItemArray(i); }
                
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR set(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR o)
                {
                    ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR old = ISIKUDImpl.this.getItemArray(i);
                    ISIKUDImpl.this.setItemArray(i, o);
                    return old;
                }
                
                public void add(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR o)
                    { ISIKUDImpl.this.insertNewItem(i).set(o); }
                
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR remove(int i)
                {
                    ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR old = ISIKUDImpl.this.getItemArray(i);
                    ISIKUDImpl.this.removeItem(i);
                    return old;
                }
                
                public int size()
                    { return ISIKUDImpl.this.sizeOfItemArray(); }
                
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
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR[] getItemArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR> targetList = new java.util.ArrayList<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR>();
                get_store().find_all_element_users(ITEM$0, targetList);
                ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR[] result = new ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "item" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR getItemArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR)get_store().find_element_user(ITEM$0, i);
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
        public void setItemArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR[] itemArray)
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
        public void setItemArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR item)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR)get_store().find_element_user(ITEM$0, i);
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
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR insertNewItem(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR)get_store().insert_element_user(ITEM$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "item" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR addNewItem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR)get_store().add_element_user(ITEM$0);
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
    }
}
