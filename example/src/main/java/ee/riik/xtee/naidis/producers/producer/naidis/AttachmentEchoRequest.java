/**
 * AttachmentEchoRequest.java This file was auto-generated from WSDL by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT)
 * WSDL2Java emitter.
 */

package ee.riik.xtee.naidis.producers.producer.naidis;

public class AttachmentEchoRequest implements java.io.Serializable {
  private ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoNest nest;

  public AttachmentEchoRequest() {
  }

  public AttachmentEchoRequest(ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoNest nest) {
    this.nest = nest;
  }

  /**
   * Gets the nest value for this AttachmentEchoRequest.
   * 
   * @return nest
   */
  public ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoNest getNest() {
    return nest;
  }

  /**
   * Sets the nest value for this AttachmentEchoRequest.
   * 
   * @param nest
   */
  public void setNest(ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoNest nest) {
    this.nest = nest;
  }

  private java.lang.Object __equalsCalc = null;

  public synchronized boolean equals(java.lang.Object obj) {
    if (!(obj instanceof AttachmentEchoRequest))
      return false;
    AttachmentEchoRequest other = (AttachmentEchoRequest) obj;
    if (obj == null)
      return false;
    if (this == obj)
      return true;
    if (__equalsCalc != null) {
      return (__equalsCalc == obj);
    }
    __equalsCalc = obj;
    boolean _equals;
    _equals =
        true && ((this.nest == null && other.getNest() == null) || (this.nest != null && this.nest.equals(other.getNest())));
    __equalsCalc = null;
    return _equals;
  }

  private boolean __hashCodeCalc = false;

  public synchronized int hashCode() {
    if (__hashCodeCalc) {
      return 0;
    }
    __hashCodeCalc = true;
    int _hashCode = 1;
    if (getNest() != null) {
      _hashCode += getNest().hashCode();
    }
    __hashCodeCalc = false;
    return _hashCode;
  }

  // Type metadata
  private static org.apache.axis.description.TypeDesc typeDesc =
      new org.apache.axis.description.TypeDesc(AttachmentEchoRequest.class, true);

  static {
    typeDesc.setXmlType(new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis",
                                                      "AttachmentEchoRequest"));
    org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
    elemField.setFieldName("nest");
    elemField.setXmlName(new javax.xml.namespace.QName("", "Nest"));
    elemField.setXmlType(new javax.xml.namespace.QName("http://producers.naidis.xtee.riik.ee/producer/naidis",
                                                       "AttachmentEchoNest"));
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
  }

  /**
   * Return type metadata object
   */
  public static org.apache.axis.description.TypeDesc getTypeDesc() {
    return typeDesc;
  }

  /**
   * Get Custom Serializer
   */
  public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType,
                                                                  java.lang.Class _javaType,
                                                                  javax.xml.namespace.QName _xmlType) {
    return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
  }

  /**
   * Get Custom Deserializer
   */
  public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType,
                                                                      java.lang.Class _javaType,
                                                                      javax.xml.namespace.QName _xmlType) {
    return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
  }

}
