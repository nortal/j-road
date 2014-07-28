/*
 * XML Type:  AbiType
 * Namespace: http://producers.rmviki.xtee.riik.ee/producer/rmviki
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.impl;
/**
 * An XML AbiType(@http://producers.rmviki.xtee.riik.ee/producer/rmviki).
 *
 * This is a complex type.
 */
public class AbiTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.AbiType
{
    private static final long serialVersionUID = 1L;
    
    public AbiTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName KOOD$0 = 
        new javax.xml.namespace.QName("", "kood");
    private static final javax.xml.namespace.QName NIMI$2 = 
        new javax.xml.namespace.QName("", "nimi");
    private static final javax.xml.namespace.QName ABIANDJAKOOD$4 = 
        new javax.xml.namespace.QName("", "abiAndjaKood");
    private static final javax.xml.namespace.QName ABIANDJANIMI$6 = 
        new javax.xml.namespace.QName("", "abiAndjaNimi");
    private static final javax.xml.namespace.QName ABIANDMISEKPV$8 = 
        new javax.xml.namespace.QName("", "abiAndmiseKpv");
    private static final javax.xml.namespace.QName ABIANDMISEOTSUS$10 = 
        new javax.xml.namespace.QName("", "abiAndmiseOtsus");
    private static final javax.xml.namespace.QName ABINIMETUS$12 = 
        new javax.xml.namespace.QName("", "abiNimetus");
    private static final javax.xml.namespace.QName ABIALUS$14 = 
        new javax.xml.namespace.QName("", "abiAlus");
    private static final javax.xml.namespace.QName ABIALUSALAM$16 = 
        new javax.xml.namespace.QName("", "abiAlusAlam");
    private static final javax.xml.namespace.QName ABISUMMA$18 = 
        new javax.xml.namespace.QName("", "abiSumma");
    private static final javax.xml.namespace.QName KASMAANTEETRANSPORT$20 = 
        new javax.xml.namespace.QName("", "kasMaanteetransport");
    private static final javax.xml.namespace.QName KASMAJANDUSHUVI$22 = 
        new javax.xml.namespace.QName("", "kasMajandushuvi");
    
    
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
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType xgetKood()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType)get_store().find_element_user(KOOD$0, 0);
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
    public void xsetKood(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType kood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType)get_store().find_element_user(KOOD$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.KoodType)get_store().add_element_user(KOOD$0);
            }
            target.set(kood);
        }
    }
    
    /**
     * Gets the "nimi" element
     */
    public java.lang.String getNimi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NIMI$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "nimi" element
     */
    public org.apache.xmlbeans.XmlString xgetNimi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NIMI$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "nimi" element
     */
    public void setNimi(java.lang.String nimi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NIMI$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NIMI$2);
            }
            target.setStringValue(nimi);
        }
    }
    
    /**
     * Sets (as xml) the "nimi" element
     */
    public void xsetNimi(org.apache.xmlbeans.XmlString nimi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NIMI$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NIMI$2);
            }
            target.set(nimi);
        }
    }
    
    /**
     * Gets the "abiAndjaKood" element
     */
    public java.lang.String getAbiAndjaKood()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIANDJAKOOD$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "abiAndjaKood" element
     */
    public org.apache.xmlbeans.XmlString xgetAbiAndjaKood()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIANDJAKOOD$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "abiAndjaKood" element
     */
    public void setAbiAndjaKood(java.lang.String abiAndjaKood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIANDJAKOOD$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABIANDJAKOOD$4);
            }
            target.setStringValue(abiAndjaKood);
        }
    }
    
    /**
     * Sets (as xml) the "abiAndjaKood" element
     */
    public void xsetAbiAndjaKood(org.apache.xmlbeans.XmlString abiAndjaKood)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIANDJAKOOD$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ABIANDJAKOOD$4);
            }
            target.set(abiAndjaKood);
        }
    }
    
    /**
     * Gets the "abiAndjaNimi" element
     */
    public java.lang.String getAbiAndjaNimi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIANDJANIMI$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "abiAndjaNimi" element
     */
    public org.apache.xmlbeans.XmlString xgetAbiAndjaNimi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIANDJANIMI$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "abiAndjaNimi" element
     */
    public void setAbiAndjaNimi(java.lang.String abiAndjaNimi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIANDJANIMI$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABIANDJANIMI$6);
            }
            target.setStringValue(abiAndjaNimi);
        }
    }
    
    /**
     * Sets (as xml) the "abiAndjaNimi" element
     */
    public void xsetAbiAndjaNimi(org.apache.xmlbeans.XmlString abiAndjaNimi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIANDJANIMI$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ABIANDJANIMI$6);
            }
            target.set(abiAndjaNimi);
        }
    }
    
    /**
     * Gets the "abiAndmiseKpv" element
     */
    public java.util.Calendar getAbiAndmiseKpv()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIANDMISEKPV$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "abiAndmiseKpv" element
     */
    public org.apache.xmlbeans.XmlDate xgetAbiAndmiseKpv()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ABIANDMISEKPV$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "abiAndmiseKpv" element
     */
    public void setAbiAndmiseKpv(java.util.Calendar abiAndmiseKpv)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIANDMISEKPV$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABIANDMISEKPV$8);
            }
            target.setCalendarValue(abiAndmiseKpv);
        }
    }
    
    /**
     * Sets (as xml) the "abiAndmiseKpv" element
     */
    public void xsetAbiAndmiseKpv(org.apache.xmlbeans.XmlDate abiAndmiseKpv)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(ABIANDMISEKPV$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(ABIANDMISEKPV$8);
            }
            target.set(abiAndmiseKpv);
        }
    }
    
    /**
     * Gets the "abiAndmiseOtsus" element
     */
    public java.lang.String getAbiAndmiseOtsus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIANDMISEOTSUS$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "abiAndmiseOtsus" element
     */
    public org.apache.xmlbeans.XmlString xgetAbiAndmiseOtsus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIANDMISEOTSUS$10, 0);
            return target;
        }
    }
    
    /**
     * Sets the "abiAndmiseOtsus" element
     */
    public void setAbiAndmiseOtsus(java.lang.String abiAndmiseOtsus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIANDMISEOTSUS$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABIANDMISEOTSUS$10);
            }
            target.setStringValue(abiAndmiseOtsus);
        }
    }
    
    /**
     * Sets (as xml) the "abiAndmiseOtsus" element
     */
    public void xsetAbiAndmiseOtsus(org.apache.xmlbeans.XmlString abiAndmiseOtsus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIANDMISEOTSUS$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ABIANDMISEOTSUS$10);
            }
            target.set(abiAndmiseOtsus);
        }
    }
    
    /**
     * Gets the "abiNimetus" element
     */
    public java.lang.String getAbiNimetus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABINIMETUS$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "abiNimetus" element
     */
    public org.apache.xmlbeans.XmlString xgetAbiNimetus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABINIMETUS$12, 0);
            return target;
        }
    }
    
    /**
     * Sets the "abiNimetus" element
     */
    public void setAbiNimetus(java.lang.String abiNimetus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABINIMETUS$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABINIMETUS$12);
            }
            target.setStringValue(abiNimetus);
        }
    }
    
    /**
     * Sets (as xml) the "abiNimetus" element
     */
    public void xsetAbiNimetus(org.apache.xmlbeans.XmlString abiNimetus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABINIMETUS$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ABINIMETUS$12);
            }
            target.set(abiNimetus);
        }
    }
    
    /**
     * Gets the "abiAlus" element
     */
    public java.lang.String getAbiAlus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIALUS$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "abiAlus" element
     */
    public org.apache.xmlbeans.XmlString xgetAbiAlus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIALUS$14, 0);
            return target;
        }
    }
    
    /**
     * Sets the "abiAlus" element
     */
    public void setAbiAlus(java.lang.String abiAlus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIALUS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABIALUS$14);
            }
            target.setStringValue(abiAlus);
        }
    }
    
    /**
     * Sets (as xml) the "abiAlus" element
     */
    public void xsetAbiAlus(org.apache.xmlbeans.XmlString abiAlus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIALUS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ABIALUS$14);
            }
            target.set(abiAlus);
        }
    }
    
    /**
     * Gets the "abiAlusAlam" element
     */
    public java.lang.String getAbiAlusAlam()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIALUSALAM$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "abiAlusAlam" element
     */
    public org.apache.xmlbeans.XmlString xgetAbiAlusAlam()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIALUSALAM$16, 0);
            return target;
        }
    }
    
    /**
     * Sets the "abiAlusAlam" element
     */
    public void setAbiAlusAlam(java.lang.String abiAlusAlam)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABIALUSALAM$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABIALUSALAM$16);
            }
            target.setStringValue(abiAlusAlam);
        }
    }
    
    /**
     * Sets (as xml) the "abiAlusAlam" element
     */
    public void xsetAbiAlusAlam(org.apache.xmlbeans.XmlString abiAlusAlam)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABIALUSALAM$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ABIALUSALAM$16);
            }
            target.set(abiAlusAlam);
        }
    }
    
    /**
     * Gets the "abiSumma" element
     */
    public java.math.BigDecimal getAbiSumma()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABISUMMA$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigDecimalValue();
        }
    }
    
    /**
     * Gets (as xml) the "abiSumma" element
     */
    public org.apache.xmlbeans.XmlDecimal xgetAbiSumma()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(ABISUMMA$18, 0);
            return target;
        }
    }
    
    /**
     * Sets the "abiSumma" element
     */
    public void setAbiSumma(java.math.BigDecimal abiSumma)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABISUMMA$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABISUMMA$18);
            }
            target.setBigDecimalValue(abiSumma);
        }
    }
    
    /**
     * Sets (as xml) the "abiSumma" element
     */
    public void xsetAbiSumma(org.apache.xmlbeans.XmlDecimal abiSumma)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDecimal target = null;
            target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(ABISUMMA$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(ABISUMMA$18);
            }
            target.set(abiSumma);
        }
    }
    
    /**
     * Gets the "kasMaanteetransport" element
     */
    public java.lang.String getKasMaanteetransport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KASMAANTEETRANSPORT$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "kasMaanteetransport" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType xgetKasMaanteetransport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType)get_store().find_element_user(KASMAANTEETRANSPORT$20, 0);
            return target;
        }
    }
    
    /**
     * Sets the "kasMaanteetransport" element
     */
    public void setKasMaanteetransport(java.lang.String kasMaanteetransport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KASMAANTEETRANSPORT$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(KASMAANTEETRANSPORT$20);
            }
            target.setStringValue(kasMaanteetransport);
        }
    }
    
    /**
     * Sets (as xml) the "kasMaanteetransport" element
     */
    public void xsetKasMaanteetransport(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType kasMaanteetransport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType)get_store().find_element_user(KASMAANTEETRANSPORT$20, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType)get_store().add_element_user(KASMAANTEETRANSPORT$20);
            }
            target.set(kasMaanteetransport);
        }
    }
    
    /**
     * Gets the "kasMajandushuvi" element
     */
    public java.lang.String getKasMajandushuvi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KASMAJANDUSHUVI$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "kasMajandushuvi" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType xgetKasMajandushuvi()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType)get_store().find_element_user(KASMAJANDUSHUVI$22, 0);
            return target;
        }
    }
    
    /**
     * Sets the "kasMajandushuvi" element
     */
    public void setKasMajandushuvi(java.lang.String kasMajandushuvi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(KASMAJANDUSHUVI$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(KASMAJANDUSHUVI$22);
            }
            target.setStringValue(kasMajandushuvi);
        }
    }
    
    /**
     * Sets (as xml) the "kasMajandushuvi" element
     */
    public void xsetKasMajandushuvi(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType kasMajandushuvi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType)get_store().find_element_user(KASMAJANDUSHUVI$22, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.JahEiType)get_store().add_element_user(KASMAJANDUSHUVI$22);
            }
            target.set(kasMajandushuvi);
        }
    }
}
