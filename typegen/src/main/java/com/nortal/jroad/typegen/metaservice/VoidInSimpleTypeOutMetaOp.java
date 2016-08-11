package com.nortal.jroad.typegen.metaservice;

import com.nortal.jroad.model.XmlBeansXTeeMetadata;
import com.nortal.jroad.typegen.TypeGen;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class VoidInSimpleTypeOutMetaOp implements MetaOperation {
  private final String opName;
  private final String responseXsdType;
  private final String requestElementName;
  private final String responseElementName;
  private final String version;

  public VoidInSimpleTypeOutMetaOp(String opName, int version, String responseXsdType) {
    if (!(version > 0)) {
      throw new IllegalArgumentException("Operation version must be greater than 0");
    }
    this.opName = opName;
    this.responseXsdType = responseXsdType;
    requestElementName = opName + "Request";
    responseElementName = opName + "Response";
    this.version = "v" + version;
  }

  @Override
  public void appendSchemaTypes(Node schemaNode, Document doc) {
    {
      Element outerElement = doc.createElementNS(TypeGen.SCHEMA_NS, "element");
      outerElement.setAttribute("name", requestElementName);

      Element complexType = doc.createElementNS(TypeGen.SCHEMA_NS, "complexType");
      Element sequence = doc.createElementNS(TypeGen.SCHEMA_NS, "sequence");
      complexType.appendChild(sequence);

      outerElement.appendChild(complexType);
      schemaNode.appendChild(outerElement);
    }
    {
      Element outerElement = doc.createElementNS(TypeGen.SCHEMA_NS, "element");
      outerElement.setAttribute("name", responseElementName);
      Node complexType = doc.createElementNS(TypeGen.SCHEMA_NS, "complexType");
      Element sequence = doc.createElementNS(TypeGen.SCHEMA_NS, "sequence");
      Element requestElement = doc.createElementNS(TypeGen.SCHEMA_NS, "element");
      requestElement.setAttribute("name", "response");
      requestElement.setAttribute("type", responseXsdType);

      sequence.appendChild(requestElement);
      complexType.appendChild(sequence);

      outerElement.appendChild(complexType);
      schemaNode.appendChild(outerElement);
    }
  }

  @Override
  public XmlBeansXTeeMetadata createXteeMetadata(String operationNs) {
    return new XmlBeansXTeeMetadata(opName,
                                    operationNs,
                                    requestElementName,
                                    operationNs,
                                    responseElementName,
                                    operationNs,
                                    version);
  }
}
