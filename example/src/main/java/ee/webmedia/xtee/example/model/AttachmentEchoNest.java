//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2009.09.23 at 11:57:10 PM EEST
//

package com.nortal.jroad.example.model;

import jakarta.activation.DataHandler;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttachmentRef;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for AttachmentEchoNest complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;AttachmentEchoNest&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;Attachment&quot; type=&quot;{http://ws-i.org/profiles/basic/1.1/xsd}swaRef&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentEchoNest", propOrder = { "attachment" })
public class AttachmentEchoNest {

  @XmlElement(name = "Attachment", required = true, type = String.class)
  @XmlAttachmentRef
  protected DataHandler attachment;

  /**
   * Gets the value of the attachment property.
   * 
   * @return possible object is {@link String }
   */
  public DataHandler getAttachment() {
    return attachment;
  }

  /**
   * Sets the value of the attachment property.
   * 
   * @param value allowed object is {@link String }
   */
  public void setAttachment(DataHandler value) {
    this.attachment = value;
  }

}
