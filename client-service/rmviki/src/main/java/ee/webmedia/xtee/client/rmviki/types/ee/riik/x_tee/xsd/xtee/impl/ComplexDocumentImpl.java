/*
 * An XML document type.
 * Localname: complex
 * Namespace: http://x-tee.riik.ee/xsd/xtee.xsd
 * Java type: ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument
 *
 * Automatically generated - do not modify.
 */
package ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.impl;
/**
 * A document containing one complex(@http://x-tee.riik.ee/xsd/xtee.xsd) element.
 *
 * This is a complex type.
 */
public class ComplexDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument
{
    private static final long serialVersionUID = 1L;
    
    public ComplexDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPLEX$0 = 
        new javax.xml.namespace.QName("http://x-tee.riik.ee/xsd/xtee.xsd", "complex");
    
    
    /**
     * Gets the "complex" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex getComplex()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex)get_store().find_element_user(COMPLEX$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "complex" element
     */
    public void setComplex(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex complex)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex)get_store().find_element_user(COMPLEX$0, 0);
            if (target == null)
            {
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex)get_store().add_element_user(COMPLEX$0);
            }
            target.set(complex);
        }
    }
    
    /**
     * Appends and returns a new empty "complex" element
     */
    public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex addNewComplex()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex target = null;
            target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex)get_store().add_element_user(COMPLEX$0);
            return target;
        }
    }
    /**
     * An XML complex(@http://x-tee.riik.ee/xsd/xtee.xsd).
     *
     * This is a complex type.
     */
    public static class ComplexImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex
    {
        private static final long serialVersionUID = 1L;
        
        public ComplexImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SUBOPERATION$0 = 
            new javax.xml.namespace.QName("", "suboperation");
        private static final javax.xml.namespace.QName ARC$2 = 
            new javax.xml.namespace.QName("", "arc");
        private static final javax.xml.namespace.QName SUBSTITUTION$4 = 
            new javax.xml.namespace.QName("", "substitution");
        private static final javax.xml.namespace.QName TYPE$6 = 
            new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "type");
        
        
        /**
         * Gets a List of "suboperation" elements
         */
        public java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation> getSuboperationList()
        {
            final class SuboperationList extends java.util.AbstractList<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation>
            {
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation get(int i)
                    { return ComplexImpl.this.getSuboperationArray(i); }
                
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation set(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation o)
                {
                    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation old = ComplexImpl.this.getSuboperationArray(i);
                    ComplexImpl.this.setSuboperationArray(i, o);
                    return old;
                }
                
                public void add(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation o)
                    { ComplexImpl.this.insertNewSuboperation(i).set(o); }
                
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation remove(int i)
                {
                    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation old = ComplexImpl.this.getSuboperationArray(i);
                    ComplexImpl.this.removeSuboperation(i);
                    return old;
                }
                
                public int size()
                    { return ComplexImpl.this.sizeOfSuboperationArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new SuboperationList();
            }
        }
        
        /**
         * Gets array of all "suboperation" elements
         * @deprecated
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation[] getSuboperationArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation> targetList = new java.util.ArrayList<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation>();
                get_store().find_all_element_users(SUBOPERATION$0, targetList);
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation[] result = new ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "suboperation" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation getSuboperationArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation)get_store().find_element_user(SUBOPERATION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "suboperation" element
         */
        public int sizeOfSuboperationArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SUBOPERATION$0);
            }
        }
        
        /**
         * Sets array of all "suboperation" element
         */
        public void setSuboperationArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation[] suboperationArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(suboperationArray, SUBOPERATION$0);
            }
        }
        
        /**
         * Sets ith "suboperation" element
         */
        public void setSuboperationArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation suboperation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation)get_store().find_element_user(SUBOPERATION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(suboperation);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "suboperation" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation insertNewSuboperation(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation)get_store().insert_element_user(SUBOPERATION$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "suboperation" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation addNewSuboperation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation)get_store().add_element_user(SUBOPERATION$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "suboperation" element
         */
        public void removeSuboperation(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SUBOPERATION$0, i);
            }
        }
        
        /**
         * Gets a List of "arc" elements
         */
        public java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc> getArcList()
        {
            final class ArcList extends java.util.AbstractList<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc>
            {
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc get(int i)
                    { return ComplexImpl.this.getArcArray(i); }
                
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc set(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc o)
                {
                    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc old = ComplexImpl.this.getArcArray(i);
                    ComplexImpl.this.setArcArray(i, o);
                    return old;
                }
                
                public void add(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc o)
                    { ComplexImpl.this.insertNewArc(i).set(o); }
                
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc remove(int i)
                {
                    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc old = ComplexImpl.this.getArcArray(i);
                    ComplexImpl.this.removeArc(i);
                    return old;
                }
                
                public int size()
                    { return ComplexImpl.this.sizeOfArcArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new ArcList();
            }
        }
        
        /**
         * Gets array of all "arc" elements
         * @deprecated
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc[] getArcArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc> targetList = new java.util.ArrayList<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc>();
                get_store().find_all_element_users(ARC$2, targetList);
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc[] result = new ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "arc" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc getArcArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc)get_store().find_element_user(ARC$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "arc" element
         */
        public int sizeOfArcArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ARC$2);
            }
        }
        
        /**
         * Sets array of all "arc" element
         */
        public void setArcArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc[] arcArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(arcArray, ARC$2);
            }
        }
        
        /**
         * Sets ith "arc" element
         */
        public void setArcArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc arc)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc)get_store().find_element_user(ARC$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(arc);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "arc" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc insertNewArc(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc)get_store().insert_element_user(ARC$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "arc" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc addNewArc()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc)get_store().add_element_user(ARC$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "arc" element
         */
        public void removeArc(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ARC$2, i);
            }
        }
        
        /**
         * Gets a List of "substitution" elements
         */
        public java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution> getSubstitutionList()
        {
            final class SubstitutionList extends java.util.AbstractList<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution>
            {
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution get(int i)
                    { return ComplexImpl.this.getSubstitutionArray(i); }
                
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution set(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution o)
                {
                    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution old = ComplexImpl.this.getSubstitutionArray(i);
                    ComplexImpl.this.setSubstitutionArray(i, o);
                    return old;
                }
                
                public void add(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution o)
                    { ComplexImpl.this.insertNewSubstitution(i).set(o); }
                
                public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution remove(int i)
                {
                    ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution old = ComplexImpl.this.getSubstitutionArray(i);
                    ComplexImpl.this.removeSubstitution(i);
                    return old;
                }
                
                public int size()
                    { return ComplexImpl.this.sizeOfSubstitutionArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new SubstitutionList();
            }
        }
        
        /**
         * Gets array of all "substitution" elements
         * @deprecated
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution[] getSubstitutionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution> targetList = new java.util.ArrayList<ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution>();
                get_store().find_all_element_users(SUBSTITUTION$4, targetList);
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution[] result = new ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "substitution" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution getSubstitutionArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution)get_store().find_element_user(SUBSTITUTION$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "substitution" element
         */
        public int sizeOfSubstitutionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SUBSTITUTION$4);
            }
        }
        
        /**
         * Sets array of all "substitution" element
         */
        public void setSubstitutionArray(ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution[] substitutionArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(substitutionArray, SUBSTITUTION$4);
            }
        }
        
        /**
         * Sets ith "substitution" element
         */
        public void setSubstitutionArray(int i, ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution substitution)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution)get_store().find_element_user(SUBSTITUTION$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(substitution);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "substitution" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution insertNewSubstitution(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution)get_store().insert_element_user(SUBSTITUTION$4, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "substitution" element
         */
        public ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution addNewSubstitution()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution)get_store().add_element_user(SUBSTITUTION$4);
                return target;
            }
        }
        
        /**
         * Removes the ith "substitution" element
         */
        public void removeSubstitution(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SUBSTITUTION$4, i);
            }
        }
        
        /**
         * Gets the "type" attribute
         */
        public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum getType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(TYPE$6);
                }
                if (target == null)
                {
                    return null;
                }
                return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "type" attribute
         */
        public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type xgetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_store().find_attribute_user(TYPE$6);
                if (target == null)
                {
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_default_attribute_value(TYPE$6);
                }
                return target;
            }
        }
        
        /**
         * True if has "type" attribute
         */
        public boolean isSetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(TYPE$6) != null;
            }
        }
        
        /**
         * Sets the "type" attribute
         */
        public void setType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TYPE$6);
                }
                target.setEnumValue(type);
            }
        }
        
        /**
         * Sets (as xml) the "type" attribute
         */
        public void xsetType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type target = null;
                target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_store().find_attribute_user(TYPE$6);
                if (target == null)
                {
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_store().add_attribute_user(TYPE$6);
                }
                target.set(type);
            }
        }
        
        /**
         * Unsets the "type" attribute
         */
        public void unsetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(TYPE$6);
            }
        }
        /**
         * An XML suboperation(@).
         *
         * This is a complex type.
         */
        public static class SuboperationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Suboperation
        {
            private static final long serialVersionUID = 1L;
            
            public SuboperationImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName TYPE$0 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "type");
            private static final javax.xml.namespace.QName TITLE$2 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "title");
            private static final javax.xml.namespace.QName HREF$4 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "href");
            private static final javax.xml.namespace.QName LABEL$6 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "label");
            private static final javax.xml.namespace.QName ACTUATE$8 = 
                new javax.xml.namespace.QName("", "actuate");
            
            
            /**
             * Gets the "type" attribute
             */
            public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum getType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$0);
                    if (target == null)
                    {
                      return null;
                    }
                    return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum)target.getEnumValue();
                }
            }
            
            /**
             * Gets (as xml) the "type" attribute
             */
            public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type xgetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type target = null;
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_store().find_attribute_user(TYPE$0);
                    return target;
                }
            }
            
            /**
             * True if has "type" attribute
             */
            public boolean isSetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(TYPE$0) != null;
                }
            }
            
            /**
             * Sets the "type" attribute
             */
            public void setType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TYPE$0);
                    }
                    target.setEnumValue(type);
                }
            }
            
            /**
             * Sets (as xml) the "type" attribute
             */
            public void xsetType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type target = null;
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_store().find_attribute_user(TYPE$0);
                    if (target == null)
                    {
                      target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_store().add_attribute_user(TYPE$0);
                    }
                    target.set(type);
                }
            }
            
            /**
             * Unsets the "type" attribute
             */
            public void unsetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(TYPE$0);
                }
            }
            
            /**
             * Gets the "title" attribute
             */
            public java.lang.String getTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TITLE$2);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "title" attribute
             */
            public org.apache.xmlbeans.XmlString xgetTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TITLE$2);
                    return target;
                }
            }
            
            /**
             * True if has "title" attribute
             */
            public boolean isSetTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(TITLE$2) != null;
                }
            }
            
            /**
             * Sets the "title" attribute
             */
            public void setTitle(java.lang.String title)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TITLE$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TITLE$2);
                    }
                    target.setStringValue(title);
                }
            }
            
            /**
             * Sets (as xml) the "title" attribute
             */
            public void xsetTitle(org.apache.xmlbeans.XmlString title)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TITLE$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TITLE$2);
                    }
                    target.set(title);
                }
            }
            
            /**
             * Unsets the "title" attribute
             */
            public void unsetTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(TITLE$2);
                }
            }
            
            /**
             * Gets the "href" attribute
             */
            public java.lang.String getHref()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HREF$4);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "href" attribute
             */
            public org.apache.xmlbeans.XmlAnyURI xgetHref()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlAnyURI target = null;
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(HREF$4);
                    return target;
                }
            }
            
            /**
             * True if has "href" attribute
             */
            public boolean isSetHref()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(HREF$4) != null;
                }
            }
            
            /**
             * Sets the "href" attribute
             */
            public void setHref(java.lang.String href)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HREF$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(HREF$4);
                    }
                    target.setStringValue(href);
                }
            }
            
            /**
             * Sets (as xml) the "href" attribute
             */
            public void xsetHref(org.apache.xmlbeans.XmlAnyURI href)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlAnyURI target = null;
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(HREF$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(HREF$4);
                    }
                    target.set(href);
                }
            }
            
            /**
             * Unsets the "href" attribute
             */
            public void unsetHref()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(HREF$4);
                }
            }
            
            /**
             * Gets the "label" attribute
             */
            public java.lang.String getLabel()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LABEL$6);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "label" attribute
             */
            public org.apache.xmlbeans.XmlNMTOKEN xgetLabel()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlNMTOKEN target = null;
                    target = (org.apache.xmlbeans.XmlNMTOKEN)get_store().find_attribute_user(LABEL$6);
                    return target;
                }
            }
            
            /**
             * True if has "label" attribute
             */
            public boolean isSetLabel()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(LABEL$6) != null;
                }
            }
            
            /**
             * Sets the "label" attribute
             */
            public void setLabel(java.lang.String label)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LABEL$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LABEL$6);
                    }
                    target.setStringValue(label);
                }
            }
            
            /**
             * Sets (as xml) the "label" attribute
             */
            public void xsetLabel(org.apache.xmlbeans.XmlNMTOKEN label)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlNMTOKEN target = null;
                    target = (org.apache.xmlbeans.XmlNMTOKEN)get_store().find_attribute_user(LABEL$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlNMTOKEN)get_store().add_attribute_user(LABEL$6);
                    }
                    target.set(label);
                }
            }
            
            /**
             * Unsets the "label" attribute
             */
            public void unsetLabel()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(LABEL$6);
                }
            }
            
            /**
             * Gets the "actuate" attribute
             */
            public java.lang.String getActuate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ACTUATE$8);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "actuate" attribute
             */
            public org.apache.xmlbeans.XmlString xgetActuate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ACTUATE$8);
                    return target;
                }
            }
            
            /**
             * True if has "actuate" attribute
             */
            public boolean isSetActuate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(ACTUATE$8) != null;
                }
            }
            
            /**
             * Sets the "actuate" attribute
             */
            public void setActuate(java.lang.String actuate)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ACTUATE$8);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ACTUATE$8);
                    }
                    target.setStringValue(actuate);
                }
            }
            
            /**
             * Sets (as xml) the "actuate" attribute
             */
            public void xsetActuate(org.apache.xmlbeans.XmlString actuate)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ACTUATE$8);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ACTUATE$8);
                    }
                    target.set(actuate);
                }
            }
            
            /**
             * Unsets the "actuate" attribute
             */
            public void unsetActuate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(ACTUATE$8);
                }
            }
        }
        /**
         * An XML arc(@).
         *
         * This is a complex type.
         */
        public static class ArcImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Arc
        {
            private static final long serialVersionUID = 1L;
            
            public ArcImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName TYPE$0 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "type");
            private static final javax.xml.namespace.QName TITLE$2 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "title");
            private static final javax.xml.namespace.QName FROM$4 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "from");
            private static final javax.xml.namespace.QName TO$6 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "to");
            private static final javax.xml.namespace.QName SHOW$8 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "show");
            private static final javax.xml.namespace.QName ACTUATE$10 = 
                new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "actuate");
            
            
            /**
             * Gets the "type" attribute
             */
            public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum getType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(TYPE$0);
                    }
                    if (target == null)
                    {
                      return null;
                    }
                    return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum)target.getEnumValue();
                }
            }
            
            /**
             * Gets (as xml) the "type" attribute
             */
            public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type xgetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type target = null;
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_store().find_attribute_user(TYPE$0);
                    if (target == null)
                    {
                      target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_default_attribute_value(TYPE$0);
                    }
                    return target;
                }
            }
            
            /**
             * True if has "type" attribute
             */
            public boolean isSetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(TYPE$0) != null;
                }
            }
            
            /**
             * Sets the "type" attribute
             */
            public void setType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type.Enum type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TYPE$0);
                    }
                    target.setEnumValue(type);
                }
            }
            
            /**
             * Sets (as xml) the "type" attribute
             */
            public void xsetType(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type type)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type target = null;
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_store().find_attribute_user(TYPE$0);
                    if (target == null)
                    {
                      target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.TypeAttribute.Type)get_store().add_attribute_user(TYPE$0);
                    }
                    target.set(type);
                }
            }
            
            /**
             * Unsets the "type" attribute
             */
            public void unsetType()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(TYPE$0);
                }
            }
            
            /**
             * Gets the "title" attribute
             */
            public java.lang.String getTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TITLE$2);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "title" attribute
             */
            public org.apache.xmlbeans.XmlString xgetTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TITLE$2);
                    return target;
                }
            }
            
            /**
             * True if has "title" attribute
             */
            public boolean isSetTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(TITLE$2) != null;
                }
            }
            
            /**
             * Sets the "title" attribute
             */
            public void setTitle(java.lang.String title)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TITLE$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TITLE$2);
                    }
                    target.setStringValue(title);
                }
            }
            
            /**
             * Sets (as xml) the "title" attribute
             */
            public void xsetTitle(org.apache.xmlbeans.XmlString title)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TITLE$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TITLE$2);
                    }
                    target.set(title);
                }
            }
            
            /**
             * Unsets the "title" attribute
             */
            public void unsetTitle()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(TITLE$2);
                }
            }
            
            /**
             * Gets the "from" attribute
             */
            public java.lang.String getFrom()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FROM$4);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "from" attribute
             */
            public org.apache.xmlbeans.XmlAnyURI xgetFrom()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlAnyURI target = null;
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(FROM$4);
                    return target;
                }
            }
            
            /**
             * True if has "from" attribute
             */
            public boolean isSetFrom()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(FROM$4) != null;
                }
            }
            
            /**
             * Sets the "from" attribute
             */
            public void setFrom(java.lang.String from)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FROM$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FROM$4);
                    }
                    target.setStringValue(from);
                }
            }
            
            /**
             * Sets (as xml) the "from" attribute
             */
            public void xsetFrom(org.apache.xmlbeans.XmlAnyURI from)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlAnyURI target = null;
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(FROM$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(FROM$4);
                    }
                    target.set(from);
                }
            }
            
            /**
             * Unsets the "from" attribute
             */
            public void unsetFrom()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(FROM$4);
                }
            }
            
            /**
             * Gets the "to" attribute
             */
            public java.lang.String getTo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TO$6);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "to" attribute
             */
            public org.apache.xmlbeans.XmlAnyURI xgetTo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlAnyURI target = null;
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(TO$6);
                    return target;
                }
            }
            
            /**
             * True if has "to" attribute
             */
            public boolean isSetTo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(TO$6) != null;
                }
            }
            
            /**
             * Sets the "to" attribute
             */
            public void setTo(java.lang.String to)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TO$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TO$6);
                    }
                    target.setStringValue(to);
                }
            }
            
            /**
             * Sets (as xml) the "to" attribute
             */
            public void xsetTo(org.apache.xmlbeans.XmlAnyURI to)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlAnyURI target = null;
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(TO$6);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(TO$6);
                    }
                    target.set(to);
                }
            }
            
            /**
             * Unsets the "to" attribute
             */
            public void unsetTo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(TO$6);
                }
            }
            
            /**
             * Gets the "show" attribute
             */
            public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show.Enum getShow()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SHOW$8);
                    if (target == null)
                    {
                      return null;
                    }
                    return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show.Enum)target.getEnumValue();
                }
            }
            
            /**
             * Gets (as xml) the "show" attribute
             */
            public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show xgetShow()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show target = null;
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show)get_store().find_attribute_user(SHOW$8);
                    return target;
                }
            }
            
            /**
             * True if has "show" attribute
             */
            public boolean isSetShow()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(SHOW$8) != null;
                }
            }
            
            /**
             * Sets the "show" attribute
             */
            public void setShow(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show.Enum show)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SHOW$8);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SHOW$8);
                    }
                    target.setEnumValue(show);
                }
            }
            
            /**
             * Sets (as xml) the "show" attribute
             */
            public void xsetShow(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show show)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show target = null;
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show)get_store().find_attribute_user(SHOW$8);
                    if (target == null)
                    {
                      target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ShowAttribute.Show)get_store().add_attribute_user(SHOW$8);
                    }
                    target.set(show);
                }
            }
            
            /**
             * Unsets the "show" attribute
             */
            public void unsetShow()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(SHOW$8);
                }
            }
            
            /**
             * Gets the "actuate" attribute
             */
            public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum getActuate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ACTUATE$10);
                    if (target == null)
                    {
                      return null;
                    }
                    return (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum)target.getEnumValue();
                }
            }
            
            /**
             * Gets (as xml) the "actuate" attribute
             */
            public ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate xgetActuate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate target = null;
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate)get_store().find_attribute_user(ACTUATE$10);
                    return target;
                }
            }
            
            /**
             * True if has "actuate" attribute
             */
            public boolean isSetActuate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(ACTUATE$10) != null;
                }
            }
            
            /**
             * Sets the "actuate" attribute
             */
            public void setActuate(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum actuate)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ACTUATE$10);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ACTUATE$10);
                    }
                    target.setEnumValue(actuate);
                }
            }
            
            /**
             * Sets (as xml) the "actuate" attribute
             */
            public void xsetActuate(ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate actuate)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate target = null;
                    target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate)get_store().find_attribute_user(ACTUATE$10);
                    if (target == null)
                    {
                      target = (ee.webmedia.xtee.client.rmviki.types.org.w3.x1999.xlink.ActuateAttribute.Actuate)get_store().add_attribute_user(ACTUATE$10);
                    }
                    target.set(actuate);
                }
            }
            
            /**
             * Unsets the "actuate" attribute
             */
            public void unsetActuate()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(ACTUATE$10);
                }
            }
        }
        /**
         * An XML substitution(@).
         *
         * This is a complex type.
         */
        public static class SubstitutionImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ee.webmedia.xtee.client.rmviki.types.ee.riik.x_tee.xsd.xtee.ComplexDocument.Complex.Substitution
        {
            private static final long serialVersionUID = 1L;
            
            public SubstitutionImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName FROM$0 = 
                new javax.xml.namespace.QName("", "from");
            private static final javax.xml.namespace.QName TO$2 = 
                new javax.xml.namespace.QName("", "to");
            private static final javax.xml.namespace.QName WHEN$4 = 
                new javax.xml.namespace.QName("", "when");
            
            
            /**
             * Gets the "from" attribute
             */
            public java.lang.String getFrom()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FROM$0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "from" attribute
             */
            public org.apache.xmlbeans.XmlString xgetFrom()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FROM$0);
                    return target;
                }
            }
            
            /**
             * True if has "from" attribute
             */
            public boolean isSetFrom()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(FROM$0) != null;
                }
            }
            
            /**
             * Sets the "from" attribute
             */
            public void setFrom(java.lang.String from)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FROM$0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FROM$0);
                    }
                    target.setStringValue(from);
                }
            }
            
            /**
             * Sets (as xml) the "from" attribute
             */
            public void xsetFrom(org.apache.xmlbeans.XmlString from)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FROM$0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(FROM$0);
                    }
                    target.set(from);
                }
            }
            
            /**
             * Unsets the "from" attribute
             */
            public void unsetFrom()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(FROM$0);
                }
            }
            
            /**
             * Gets the "to" attribute
             */
            public java.lang.String getTo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TO$2);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "to" attribute
             */
            public org.apache.xmlbeans.XmlString xgetTo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TO$2);
                    return target;
                }
            }
            
            /**
             * True if has "to" attribute
             */
            public boolean isSetTo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(TO$2) != null;
                }
            }
            
            /**
             * Sets the "to" attribute
             */
            public void setTo(java.lang.String to)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TO$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TO$2);
                    }
                    target.setStringValue(to);
                }
            }
            
            /**
             * Sets (as xml) the "to" attribute
             */
            public void xsetTo(org.apache.xmlbeans.XmlString to)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TO$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TO$2);
                    }
                    target.set(to);
                }
            }
            
            /**
             * Unsets the "to" attribute
             */
            public void unsetTo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(TO$2);
                }
            }
            
            /**
             * Gets the "when" attribute
             */
            public java.lang.String getWhen()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(WHEN$4);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "when" attribute
             */
            public org.apache.xmlbeans.XmlString xgetWhen()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(WHEN$4);
                    return target;
                }
            }
            
            /**
             * True if has "when" attribute
             */
            public boolean isSetWhen()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(WHEN$4) != null;
                }
            }
            
            /**
             * Sets the "when" attribute
             */
            public void setWhen(java.lang.String when)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(WHEN$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(WHEN$4);
                    }
                    target.setStringValue(when);
                }
            }
            
            /**
             * Sets (as xml) the "when" attribute
             */
            public void xsetWhen(org.apache.xmlbeans.XmlString when)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(WHEN$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(WHEN$4);
                    }
                    target.set(when);
                }
            }
            
            /**
             * Unsets the "when" attribute
             */
            public void unsetWhen()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(WHEN$4);
                }
            }
        }
    }
}
