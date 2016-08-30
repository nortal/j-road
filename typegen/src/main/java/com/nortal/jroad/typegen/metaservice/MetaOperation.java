package com.nortal.jroad.typegen.metaservice;

import com.nortal.jroad.enums.XRoadProtocolVersion;
import com.nortal.jroad.model.XmlBeansXTeeMetadata;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface MetaOperation {

  String getName();

  /*
    TypeGen processing will add a *Database/*DatabaseImpl method for every registered operation that has
    also a definition of its request (and response) types in the types/schema part of WSDL.

    Since meta-operations and request/response types are not included in the WSDL file, they need to be added
    to the XmlBeans schemas on-the-fly.

   Note that it is not required to create type definitions, unless the method for particular meta-operation needs to
   be added (generated) to *DatabaseImpl.
   But when you need it to be generated, this method could look like this:

    { // request type
      Element outerElement = doc.createElementNS(TypeGen.SCHEMA_NS, "element");
      outerElement.setAttribute("name", requestElementName);

      Element complexType = doc.createElementNS(TypeGen.SCHEMA_NS, "complexType");
      Element sequence = doc.createElementNS(TypeGen.SCHEMA_NS, "sequence");
      complexType.appendChild(sequence);

      outerElement.appendChild(complexType);
      schemaNode.appendChild(outerElement);
    }
    { // response type
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


   */
  void appendSchemaTypes(Node schemaNode, Document doc);

  XmlBeansXTeeMetadata createXteeMetadata(XRoadProtocolVersion protocolVersion, String operationNs);
}
