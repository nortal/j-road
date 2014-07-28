/*
 * XML Type:  rarVtaResponseType
 * Namespace: http://producers.rmviki.xtee.riik.ee/producer/rmviki
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaResponseType
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.impl;
/**
 * An XML rarVtaResponseType(@http://producers.rmviki.xtee.riik.ee/producer/rmviki).
 *
 * This is a complex type.
 */
public class RarVtaResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaResponseType
{
    private static final long serialVersionUID = 1L;
    
    public RarVtaResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SGEIJAAK$0 = 
        new javax.xml.namespace.QName("", "sgeiJaak");
    private static final javax.xml.namespace.QName VTAJAAK$2 = 
        new javax.xml.namespace.QName("", "vtaJaak");
    private static final javax.xml.namespace.QName TRANSPORDIVTAJAAK$4 = 
        new javax.xml.namespace.QName("", "transpordiVtaJaak");
    private static final javax.xml.namespace.QName BRONEERINGUD$6 = 
        new javax.xml.namespace.QName("", "broneeringud");
    private static final javax.xml.namespace.QName ABI$8 = 
        new javax.xml.namespace.QName("", "abi");
    
    
    /**
     * Gets the "sgeiJaak" element
     */
    public java.math.BigDecimal getSgeiJaak()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SGEIJAAK$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "sgeiJaak" element
     */
    public org.apache.xmlbeans.XmlDecimal xgetSgeiJaak()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(SGEIJAAK$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "sgeiJaak" element
     */
    public void setSgeiJaak(java.math.BigDecimal sgeiJaak)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SGEIJAAK$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SGEIJAAK$0);
            }
            target.setBigDecimalValue(sgeiJaak);
        }
    }
    
    /**
     * Sets (as xml) the "sgeiJaak" element
     */
    public void xsetSgeiJaak(org.apache.xmlbeans.XmlDecimal sgeiJaak)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(SGEIJAAK$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(SGEIJAAK$0);
            }
            target.set(sgeiJaak);
        }
    }
    
    /**
     * Gets the "vtaJaak" element
     */
    public java.math.BigDecimal getVtaJaak()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VTAJAAK$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "vtaJaak" element
     */
    public org.apache.xmlbeans.XmlDecimal xgetVtaJaak()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(VTAJAAK$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "vtaJaak" element
     */
    public void setVtaJaak(java.math.BigDecimal vtaJaak)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VTAJAAK$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VTAJAAK$2);
            }
            target.setBigDecimalValue(vtaJaak);
        }
    }
    
    /**
     * Sets (as xml) the "vtaJaak" element
     */
    public void xsetVtaJaak(org.apache.xmlbeans.XmlDecimal vtaJaak)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(VTAJAAK$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(VTAJAAK$2);
            }
            target.set(vtaJaak);
        }
    }
    
    /**
     * Gets the "transpordiVtaJaak" element
     */
    public java.math.BigDecimal getTranspordiVtaJaak()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TRANSPORDIVTAJAAK$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "transpordiVtaJaak" element
     */
    public org.apache.xmlbeans.XmlDecimal xgetTranspordiVtaJaak()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(TRANSPORDIVTAJAAK$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "transpordiVtaJaak" element
     */
    public void setTranspordiVtaJaak(java.math.BigDecimal transpordiVtaJaak)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TRANSPORDIVTAJAAK$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TRANSPORDIVTAJAAK$4);
            }
            target.setBigDecimalValue(transpordiVtaJaak);
        }
    }
    
    /**
     * Sets (as xml) the "transpordiVtaJaak" element
     */
    public void xsetTranspordiVtaJaak(org.apache.xmlbeans.XmlDecimal transpordiVtaJaak)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(TRANSPORDIVTAJAAK$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(TRANSPORDIVTAJAAK$4);
            }
            target.set(transpordiVtaJaak);
        }
    }
    
    /**
     * Gets the "broneeringud" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud getBroneeringud()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud)get_store().find_element_user(BRONEERINGUD$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Tests for nil "broneeringud" element
     */
    public boolean isNilBroneeringud()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud)get_store().find_element_user(BRONEERINGUD$6, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "broneeringud" element
     */
    public void setBroneeringud(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud broneeringud)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud)get_store().find_element_user(BRONEERINGUD$6, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud)get_store().add_element_user(BRONEERINGUD$6);
            }
            target.set(broneeringud);
        }
    }
    
    /**
     * Appends and returns a new empty "broneeringud" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud addNewBroneeringud()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud)get_store().add_element_user(BRONEERINGUD$6);
            return target;
        }
    }
    
    /**
     * Nils the "broneeringud" element
     */
    public void setNilBroneeringud()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud)get_store().find_element_user(BRONEERINGUD$6, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Broneeringud)get_store().add_element_user(BRONEERINGUD$6);
            }
            target.setNil();
        }
    }
    
    /**
     * Gets a List of "abi" elements
     */
    public java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType> getAbiList()
    {
        final class AbiList extends java.util.AbstractList<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType>
        {
            public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType get(int i)
                { return RarVtaResponseTypeImpl.this.getAbiArray(i); }
            
            public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType set(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType o)
            {
                ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType old = RarVtaResponseTypeImpl.this.getAbiArray(i);
                RarVtaResponseTypeImpl.this.setAbiArray(i, o);
                return old;
            }
            
            public void add(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType o)
                { RarVtaResponseTypeImpl.this.insertNewAbi(i).set(o); }
            
            public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType remove(int i)
            {
                ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType old = RarVtaResponseTypeImpl.this.getAbiArray(i);
                RarVtaResponseTypeImpl.this.removeAbi(i);
                return old;
            }
            
            public int size()
                { return RarVtaResponseTypeImpl.this.sizeOfAbiArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new AbiList();
        }
    }
    
    /**
     * Gets array of all "abi" elements
     * @deprecated
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType[] getAbiArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType> targetList = new java.util.ArrayList<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType>();
            get_store().find_all_element_users(ABI$8, targetList);
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType[] result = new ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "abi" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType getAbiArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType)get_store().find_element_user(ABI$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "abi" element
     */
    public int sizeOfAbiArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ABI$8);
        }
    }
    
    /**
     * Sets array of all "abi" element
     */
    public void setAbiArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType[] abiArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(abiArray, ABI$8);
        }
    }
    
    /**
     * Sets ith "abi" element
     */
    public void setAbiArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType abi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType)get_store().find_element_user(ABI$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(abi);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "abi" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType insertNewAbi(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType)get_store().insert_element_user(ABI$8, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "abi" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType addNewAbi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType)get_store().add_element_user(ABI$8);
            return target;
        }
    }
    
    /**
     * Removes the ith "abi" element
     */
    public void removeAbi(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ABI$8, i);
        }
    }
}
