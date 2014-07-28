/*
 * XML Type:  Broneeringud
 * Namespace: http://producers.rmviki.xtee.riik.ee/producer/rmviki
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.impl;
/**
 * An XML Broneeringud(@http://producers.rmviki.xtee.riik.ee/producer/rmviki).
 *
 * This is a complex type.
 */
public class BroneeringudImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud
{
    private static final long serialVersionUID = 1L;
    
    public BroneeringudImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BRONEERING$0 = 
        new javax.xml.namespace.QName("", "broneering");
    
    
    /**
     * Gets a List of "broneering" elements
     */
    public java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering> getBroneeringList()
    {
        final class BroneeringList extends java.util.AbstractList<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering>
        {
            public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering get(int i)
                { return BroneeringudImpl.this.getBroneeringArray(i); }
            
            public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering set(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering o)
            {
                ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering old = BroneeringudImpl.this.getBroneeringArray(i);
                BroneeringudImpl.this.setBroneeringArray(i, o);
                return old;
            }
            
            public void add(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering o)
                { BroneeringudImpl.this.insertNewBroneering(i).set(o); }
            
            public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering remove(int i)
            {
                ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering old = BroneeringudImpl.this.getBroneeringArray(i);
                BroneeringudImpl.this.removeBroneering(i);
                return old;
            }
            
            public int size()
                { return BroneeringudImpl.this.sizeOfBroneeringArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new BroneeringList();
        }
    }
    
    /**
     * Gets array of all "broneering" elements
     * @deprecated
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering[] getBroneeringArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering> targetList = new java.util.ArrayList<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering>();
            get_store().find_all_element_users(BRONEERING$0, targetList);
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering[] result = new ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "broneering" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering getBroneeringArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering)get_store().find_element_user(BRONEERING$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Tests for nil ith "broneering" element
     */
    public boolean isNilBroneeringArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering)get_store().find_element_user(BRONEERING$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.isNil();
        }
    }
    
    /**
     * Returns number of "broneering" element
     */
    public int sizeOfBroneeringArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(BRONEERING$0);
        }
    }
    
    /**
     * Sets array of all "broneering" element
     */
    public void setBroneeringArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering[] broneeringArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(broneeringArray, BRONEERING$0);
        }
    }
    
    /**
     * Sets ith "broneering" element
     */
    public void setBroneeringArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering broneering)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering)get_store().find_element_user(BRONEERING$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(broneering);
        }
    }
    
    /**
     * Nils the ith "broneering" element
     */
    public void setNilBroneeringArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering)get_store().find_element_user(BRONEERING$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setNil();
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "broneering" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering insertNewBroneering(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering)get_store().insert_element_user(BRONEERING$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "broneering" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering addNewBroneering()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneering)get_store().add_element_user(BRONEERING$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "broneering" element
     */
    public void removeBroneering(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(BRONEERING$0, i);
        }
    }
}
