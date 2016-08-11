package com.nortal.jroad.typegen.metaservice;

import com.nortal.jroad.model.XmlBeansXTeeMetadata;
import com.nortal.jroad.typegen.DatabaseDescriptor;
import com.nortal.jroad.typegen.XteeMetadataModifier;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class MetaServicesGen {

  private final boolean addMetaOperations;
  private List<MetaOperation> metaOperations = new ArrayList<MetaOperation>();

  public MetaServicesGen(DatabaseDescriptor config) {
    addMetaOperations = config.isGenerateMetaOperations();
    { // getState
      metaOperations.add(new VoidInSimpleTypeOutMetaOp("getState", 1, "int"));
    }
  }

  public void tryAddMetaOpsToSchema(Node schemaNode) {
    if (addMetaOperations) {
      if (schemaNode == null) {
        throw new IllegalArgumentException("Cannot add meta operations, schema is null.");
      }

      Document doc = schemaNode.getOwnerDocument();

      for (MetaOperation metaOperation : metaOperations) {
        metaOperation.appendSchemaTypes(schemaNode, doc);
      }
    }
  }

  public void tryAddMetaOpsToMetadata(XteeMetadataModifier metadataModifier, String operationNs) {
    if (addMetaOperations) {
      for (MetaOperation metaOperation : metaOperations) {
        XmlBeansXTeeMetadata xTeeMetadata = metaOperation.createXteeMetadata(operationNs);
        metadataModifier.addOperation(xTeeMetadata);
      }
    }
  }
}
