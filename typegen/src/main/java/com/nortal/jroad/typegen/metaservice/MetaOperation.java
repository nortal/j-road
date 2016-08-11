package com.nortal.jroad.typegen.metaservice;

import com.nortal.jroad.model.XmlBeansXTeeMetadata;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface MetaOperation {
  void appendSchemaTypes(Node schemaNode, Document doc);

  XmlBeansXTeeMetadata createXteeMetadata(String operationNs);
}
