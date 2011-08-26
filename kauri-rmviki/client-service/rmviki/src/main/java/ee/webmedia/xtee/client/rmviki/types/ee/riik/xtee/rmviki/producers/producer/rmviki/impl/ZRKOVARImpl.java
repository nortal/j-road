/*
 * XML Type:  ZRKOVAR
 * Namespace: http://producers.rmviki.xtee.riik.ee/producer/rmviki
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.impl;
/**
 * An XML ZRKOVAR(@http://producers.rmviki.xtee.riik.ee/producer/rmviki).
 *
 * This is a complex type.
 */
public class ZRKOVARImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR
{
    private static final long serialVersionUID = 1L;
    
    public ZRKOVARImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName KOOD$0 = 
        new javax.xml.namespace.QName("", "KOOD");
    private static final javax.xml.namespace.QName NIMETUS$2 = 
        new javax.xml.namespace.QName("", "NIMETUS");
    private static final javax.xml.namespace.QName AADRESS$4 = 
        new javax.xml.namespace.QName("", "AADRESS");
    private static final javax.xml.namespace.QName INDEKS$6 = 
        new javax.xml.namespace.QName("", "INDEKS");
    private static final javax.xml.namespace.QName LINN$8 = 
        new javax.xml.namespace.QName("", "LINN");
    private static final javax.xml.namespace.QName MAAKOND$10 = 
        new javax.xml.namespace.QName("", "MAAKOND");
    private static final javax.xml.namespace.QName TELEFON$12 = 
        new javax.xml.namespace.QName("", "TELEFON");
    private static final javax.xml.namespace.QName EPOST$14 = 
        new javax.xml.namespace.QName("", "EPOST");
    private static final javax.xml.namespace.QName STAATUS$16 = 
        new javax.xml.namespace.QName("", "STAATUS");
    private static final javax.xml.namespace.QName ENDDATE$18 = 
        new javax.xml.namespace.QName("", "ENDDATE");
    private static final javax.xml.namespace.QName EHAK$20 = 
        new javax.xml.namespace.QName("", "EHAK");
    private static final javax.xml.namespace.QName LIIK$22 = 
        new javax.xml.namespace.QName("", "LIIK");
    
    
    /**
     * Gets the "KOOD" element
     */
    public java.lang.String getKOOD()
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
     * Gets (as xml) the "KOOD" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.KOOD xgetKOOD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.KOOD target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.KOOD)get_store().find_element_user(KOOD$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "KOOD" element
     */
    public boolean isSetKOOD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(KOOD$0) != 0;
        }
    }
    
    /**
     * Sets the "KOOD" element
     */
    public void setKOOD(java.lang.String kood)
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
     * Sets (as xml) the "KOOD" element
     */
    public void xsetKOOD(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.KOOD kood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.KOOD target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.KOOD)get_store().find_element_user(KOOD$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.KOOD)get_store().add_element_user(KOOD$0);
            }
            target.set(kood);
        }
    }
    
    /**
     * Unsets the "KOOD" element
     */
    public void unsetKOOD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(KOOD$0, 0);
        }
    }
    
    /**
     * Gets the "NIMETUS" element
     */
    public java.lang.String getNIMETUS()
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
     * Gets (as xml) the "NIMETUS" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.NIMETUS xgetNIMETUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.NIMETUS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.NIMETUS)get_store().find_element_user(NIMETUS$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "NIMETUS" element
     */
    public boolean isSetNIMETUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NIMETUS$2) != 0;
        }
    }
    
    /**
     * Sets the "NIMETUS" element
     */
    public void setNIMETUS(java.lang.String nimetus)
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
     * Sets (as xml) the "NIMETUS" element
     */
    public void xsetNIMETUS(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.NIMETUS nimetus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.NIMETUS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.NIMETUS)get_store().find_element_user(NIMETUS$2, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.NIMETUS)get_store().add_element_user(NIMETUS$2);
            }
            target.set(nimetus);
        }
    }
    
    /**
     * Unsets the "NIMETUS" element
     */
    public void unsetNIMETUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NIMETUS$2, 0);
        }
    }
    
    /**
     * Gets the "AADRESS" element
     */
    public java.lang.String getAADRESS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AADRESS$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AADRESS" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.AADRESS xgetAADRESS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.AADRESS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.AADRESS)get_store().find_element_user(AADRESS$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "AADRESS" element
     */
    public boolean isSetAADRESS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(AADRESS$4) != 0;
        }
    }
    
    /**
     * Sets the "AADRESS" element
     */
    public void setAADRESS(java.lang.String aadress)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AADRESS$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AADRESS$4);
            }
            target.setStringValue(aadress);
        }
    }
    
    /**
     * Sets (as xml) the "AADRESS" element
     */
    public void xsetAADRESS(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.AADRESS aadress)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.AADRESS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.AADRESS)get_store().find_element_user(AADRESS$4, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.AADRESS)get_store().add_element_user(AADRESS$4);
            }
            target.set(aadress);
        }
    }
    
    /**
     * Unsets the "AADRESS" element
     */
    public void unsetAADRESS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(AADRESS$4, 0);
        }
    }
    
    /**
     * Gets the "INDEKS" element
     */
    public java.lang.String getINDEKS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDEKS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "INDEKS" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.INDEKS xgetINDEKS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.INDEKS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.INDEKS)get_store().find_element_user(INDEKS$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "INDEKS" element
     */
    public boolean isSetINDEKS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INDEKS$6) != 0;
        }
    }
    
    /**
     * Sets the "INDEKS" element
     */
    public void setINDEKS(java.lang.String indeks)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDEKS$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INDEKS$6);
            }
            target.setStringValue(indeks);
        }
    }
    
    /**
     * Sets (as xml) the "INDEKS" element
     */
    public void xsetINDEKS(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.INDEKS indeks)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.INDEKS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.INDEKS)get_store().find_element_user(INDEKS$6, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.INDEKS)get_store().add_element_user(INDEKS$6);
            }
            target.set(indeks);
        }
    }
    
    /**
     * Unsets the "INDEKS" element
     */
    public void unsetINDEKS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INDEKS$6, 0);
        }
    }
    
    /**
     * Gets the "LINN" element
     */
    public java.lang.String getLINN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LINN$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "LINN" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LINN xgetLINN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LINN target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LINN)get_store().find_element_user(LINN$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "LINN" element
     */
    public boolean isSetLINN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LINN$8) != 0;
        }
    }
    
    /**
     * Sets the "LINN" element
     */
    public void setLINN(java.lang.String linn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LINN$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LINN$8);
            }
            target.setStringValue(linn);
        }
    }
    
    /**
     * Sets (as xml) the "LINN" element
     */
    public void xsetLINN(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LINN linn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LINN target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LINN)get_store().find_element_user(LINN$8, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LINN)get_store().add_element_user(LINN$8);
            }
            target.set(linn);
        }
    }
    
    /**
     * Unsets the "LINN" element
     */
    public void unsetLINN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LINN$8, 0);
        }
    }
    
    /**
     * Gets the "MAAKOND" element
     */
    public java.lang.String getMAAKOND()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAAKOND$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "MAAKOND" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.MAAKOND xgetMAAKOND()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.MAAKOND target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.MAAKOND)get_store().find_element_user(MAAKOND$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "MAAKOND" element
     */
    public boolean isSetMAAKOND()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MAAKOND$10) != 0;
        }
    }
    
    /**
     * Sets the "MAAKOND" element
     */
    public void setMAAKOND(java.lang.String maakond)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MAAKOND$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MAAKOND$10);
            }
            target.setStringValue(maakond);
        }
    }
    
    /**
     * Sets (as xml) the "MAAKOND" element
     */
    public void xsetMAAKOND(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.MAAKOND maakond)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.MAAKOND target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.MAAKOND)get_store().find_element_user(MAAKOND$10, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.MAAKOND)get_store().add_element_user(MAAKOND$10);
            }
            target.set(maakond);
        }
    }
    
    /**
     * Unsets the "MAAKOND" element
     */
    public void unsetMAAKOND()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MAAKOND$10, 0);
        }
    }
    
    /**
     * Gets the "TELEFON" element
     */
    public java.lang.String getTELEFON()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TELEFON$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TELEFON" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.TELEFON xgetTELEFON()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.TELEFON target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.TELEFON)get_store().find_element_user(TELEFON$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "TELEFON" element
     */
    public boolean isSetTELEFON()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TELEFON$12) != 0;
        }
    }
    
    /**
     * Sets the "TELEFON" element
     */
    public void setTELEFON(java.lang.String telefon)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TELEFON$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TELEFON$12);
            }
            target.setStringValue(telefon);
        }
    }
    
    /**
     * Sets (as xml) the "TELEFON" element
     */
    public void xsetTELEFON(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.TELEFON telefon)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.TELEFON target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.TELEFON)get_store().find_element_user(TELEFON$12, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.TELEFON)get_store().add_element_user(TELEFON$12);
            }
            target.set(telefon);
        }
    }
    
    /**
     * Unsets the "TELEFON" element
     */
    public void unsetTELEFON()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TELEFON$12, 0);
        }
    }
    
    /**
     * Gets the "EPOST" element
     */
    public java.lang.String getEPOST()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EPOST$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "EPOST" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EPOST xgetEPOST()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EPOST target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EPOST)get_store().find_element_user(EPOST$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "EPOST" element
     */
    public boolean isSetEPOST()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(EPOST$14) != 0;
        }
    }
    
    /**
     * Sets the "EPOST" element
     */
    public void setEPOST(java.lang.String epost)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EPOST$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EPOST$14);
            }
            target.setStringValue(epost);
        }
    }
    
    /**
     * Sets (as xml) the "EPOST" element
     */
    public void xsetEPOST(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EPOST epost)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EPOST target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EPOST)get_store().find_element_user(EPOST$14, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EPOST)get_store().add_element_user(EPOST$14);
            }
            target.set(epost);
        }
    }
    
    /**
     * Unsets the "EPOST" element
     */
    public void unsetEPOST()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(EPOST$14, 0);
        }
    }
    
    /**
     * Gets the "STAATUS" element
     */
    public java.lang.String getSTAATUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STAATUS$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "STAATUS" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.STAATUS xgetSTAATUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.STAATUS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.STAATUS)get_store().find_element_user(STAATUS$16, 0);
            return target;
        }
    }
    
    /**
     * True if has "STAATUS" element
     */
    public boolean isSetSTAATUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(STAATUS$16) != 0;
        }
    }
    
    /**
     * Sets the "STAATUS" element
     */
    public void setSTAATUS(java.lang.String staatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STAATUS$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STAATUS$16);
            }
            target.setStringValue(staatus);
        }
    }
    
    /**
     * Sets (as xml) the "STAATUS" element
     */
    public void xsetSTAATUS(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.STAATUS staatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.STAATUS target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.STAATUS)get_store().find_element_user(STAATUS$16, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.STAATUS)get_store().add_element_user(STAATUS$16);
            }
            target.set(staatus);
        }
    }
    
    /**
     * Unsets the "STAATUS" element
     */
    public void unsetSTAATUS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(STAATUS$16, 0);
        }
    }
    
    /**
     * Gets the "ENDDATE" element
     */
    public java.lang.String getENDDATE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENDDATE$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ENDDATE" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Date xgetENDDATE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Date target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Date)get_store().find_element_user(ENDDATE$18, 0);
            return target;
        }
    }
    
    /**
     * True if has "ENDDATE" element
     */
    public boolean isSetENDDATE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ENDDATE$18) != 0;
        }
    }
    
    /**
     * Sets the "ENDDATE" element
     */
    public void setENDDATE(java.lang.String enddate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENDDATE$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENDDATE$18);
            }
            target.setStringValue(enddate);
        }
    }
    
    /**
     * Sets (as xml) the "ENDDATE" element
     */
    public void xsetENDDATE(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Date enddate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Date target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Date)get_store().find_element_user(ENDDATE$18, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.Date)get_store().add_element_user(ENDDATE$18);
            }
            target.set(enddate);
        }
    }
    
    /**
     * Unsets the "ENDDATE" element
     */
    public void unsetENDDATE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ENDDATE$18, 0);
        }
    }
    
    /**
     * Gets the "EHAK" element
     */
    public java.lang.String getEHAK()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EHAK$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "EHAK" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EHAK xgetEHAK()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EHAK target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EHAK)get_store().find_element_user(EHAK$20, 0);
            return target;
        }
    }
    
    /**
     * Sets the "EHAK" element
     */
    public void setEHAK(java.lang.String ehak)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EHAK$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EHAK$20);
            }
            target.setStringValue(ehak);
        }
    }
    
    /**
     * Sets (as xml) the "EHAK" element
     */
    public void xsetEHAK(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EHAK ehak)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EHAK target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EHAK)get_store().find_element_user(EHAK$20, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EHAK)get_store().add_element_user(EHAK$20);
            }
            target.set(ehak);
        }
    }
    
    /**
     * Gets the "LIIK" element
     */
    public java.lang.String getLIIK()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LIIK$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "LIIK" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LIIK xgetLIIK()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LIIK target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LIIK)get_store().find_element_user(LIIK$22, 0);
            return target;
        }
    }
    
    /**
     * Sets the "LIIK" element
     */
    public void setLIIK(java.lang.String liik)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LIIK$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LIIK$22);
            }
            target.setStringValue(liik);
        }
    }
    
    /**
     * Sets (as xml) the "LIIK" element
     */
    public void xsetLIIK(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LIIK liik)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LIIK target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LIIK)get_store().find_element_user(LIIK$22, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LIIK)get_store().add_element_user(LIIK$22);
            }
            target.set(liik);
        }
    }
    /**
     * An XML KOOD(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$KOOD.
     */
    public static class KOODImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.KOOD
    {
        private static final long serialVersionUID = 1L;
        
        public KOODImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected KOODImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML NIMETUS(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$NIMETUS.
     */
    public static class NIMETUSImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.NIMETUS
    {
        private static final long serialVersionUID = 1L;
        
        public NIMETUSImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected NIMETUSImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML AADRESS(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$AADRESS.
     */
    public static class AADRESSImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.AADRESS
    {
        private static final long serialVersionUID = 1L;
        
        public AADRESSImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected AADRESSImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML INDEKS(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$INDEKS.
     */
    public static class INDEKSImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.INDEKS
    {
        private static final long serialVersionUID = 1L;
        
        public INDEKSImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected INDEKSImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML LINN(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$LINN.
     */
    public static class LINNImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LINN
    {
        private static final long serialVersionUID = 1L;
        
        public LINNImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected LINNImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML MAAKOND(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$MAAKOND.
     */
    public static class MAAKONDImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.MAAKOND
    {
        private static final long serialVersionUID = 1L;
        
        public MAAKONDImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected MAAKONDImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML TELEFON(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$TELEFON.
     */
    public static class TELEFONImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.TELEFON
    {
        private static final long serialVersionUID = 1L;
        
        public TELEFONImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected TELEFONImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML EPOST(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$EPOST.
     */
    public static class EPOSTImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EPOST
    {
        private static final long serialVersionUID = 1L;
        
        public EPOSTImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected EPOSTImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML STAATUS(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$STAATUS.
     */
    public static class STAATUSImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.STAATUS
    {
        private static final long serialVersionUID = 1L;
        
        public STAATUSImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected STAATUSImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML EHAK(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$EHAK.
     */
    public static class EHAKImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.EHAK
    {
        private static final long serialVersionUID = 1L;
        
        public EHAKImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected EHAKImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML LIIK(@).
     *
     * This is an atomic type that is a restriction of ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR$LIIK.
     */
    public static class LIIKImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR.LIIK
    {
        private static final long serialVersionUID = 1L;
        
        public LIIKImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected LIIKImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
