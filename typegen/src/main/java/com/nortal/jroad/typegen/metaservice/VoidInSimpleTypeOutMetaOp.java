package com.nortal.jroad.typegen.metaservice;

import com.nortal.jroad.enums.XRoadProtocolVersion;
import com.nortal.jroad.model.XmlBeansXTeeMetadata;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class VoidInSimpleTypeOutMetaOp implements MetaOperation {
  private final String opName;
  private final String requestElementName;
  private final String responseElementName;
  private final String version;

  public VoidInSimpleTypeOutMetaOp(String opName, int version) {
    if (!(version > 0)) {
      throw new IllegalArgumentException("Operation version must be greater than 0");
    }
    this.opName = opName;
    requestElementName = opName + "Request";
    responseElementName = opName + "Response";
    this.version = "v" + version;
  }

  @Override public String getName() {
    return opName;
  }

  @Override
  public void appendSchemaTypes(Node schemaNode, Document doc) {
    /*
    Currently there is no need to create request/response types, because the only meta-operation using this class
    defines custom implementation, see MetaserviceOperations: getState().
    */
  }

  @Override public XmlBeansXTeeMetadata createXteeMetadata(XRoadProtocolVersion protocolVersion, String operationNs) {
    String namespaceUri = protocolVersion.getNamespaceUri();
    return new XmlBeansXTeeMetadata(opName, namespaceUri,
                                    requestElementName, namespaceUri,
                                    responseElementName, namespaceUri,
                                    version);
  }
}
