package com.nortal.jroad.typegen.database;

import com.nortal.jroad.model.XmlBeansXRoadMetadata;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.schema.FileResourceLoader;
import org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;

/**
 * @author Roman Tekhov
 */
public class DatabaseServiceMethod {

  private String inputClass;
  private String outputClass;

  private String name;

  private List<DatabaseServiceMethodVersion> versions;

  private String baseDirectory;


  public DatabaseServiceMethod(XmlBeansXRoadMetadata metadata, String baseDirectory)
        throws IOException, NoDescriptionFoundException {

    this.baseDirectory = baseDirectory;

    name = metadata.getOperationName();

    QName requestElementQName = new QName(metadata.getRequestElementNs(),
                                          metadata.getRequestElementName());

    QName responseElementQName = new QName(metadata.getResponseElementNs(),
                                           metadata.getResponseElementName());

    SchemaType requestElementType = find(requestElementQName);
    SchemaType responseElementType = find(responseElementQName);

    inputClass = requestElementType.getFullJavaName().replaceAll("\\$", ".");
    outputClass = responseElementType.getFullJavaName().replaceAll("\\$", ".");

    createVersions(metadata);
  }


  private void createVersions(XmlBeansXRoadMetadata metadata) {
    // According to specification only the last version of a service needs to be defined
    // in WSDL but the database adapter must also support all previous versions.

    if(!StringUtils.isBlank(metadata.getVersion())){
        int lastVersion = Integer.valueOf(metadata.getVersion().substring(1));

        versions = new ArrayList<DatabaseServiceMethodVersion>(lastVersion);
        for (int i = 1; i <= lastVersion; i++) {
            versions.add(new DatabaseServiceMethodVersion(metadata, i));
        }
    }else{
        versions = new ArrayList<DatabaseServiceMethodVersion>();
        versions.add(new DatabaseServiceMethodVersion(metadata));
    }

  }


  private SchemaType find(QName name) throws IOException, NoDescriptionFoundException {
    SchemaTypeLoaderImpl loader = (SchemaTypeLoaderImpl) XmlBeans.getContextTypeLoader();

    SchemaType type = loader.findType(name);
    if (type != null) {
      return type;
    }

    String typeLocation =
        baseDirectory + "/schema" + SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD + "/type/"
            + QNameHelper.hexsafedir(name) + ".xsb";

    File file = new File(typeLocation);
    boolean isTypeFile = true;
    if (!file.exists()) {
      isTypeFile = false;
      String elementLocation =
          baseDirectory + "/schema" + SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD + "/element/"
              + QNameHelper.hexsafedir(name) + ".xsb";
      file = new File(elementLocation);
      if (!file.exists()) {
        throw new NoDescriptionFoundException();
      }
    }

    SchemaTypeSystem ts = null;
    InputStream stream = null;
    try {
      stream = new FileInputStream(file);
      String tsname = SchemaTypeSystemImpl.crackPointer(stream);

      ts = new SchemaTypeSystemImpl(new FileResourceLoader(new File(baseDirectory)), tsname, loader);
    } finally {
      if (stream != null) {
        stream.close();
      }
    }

    if (isTypeFile) {
      return ts.findTypeRef(name).get();
    } else {
      return ts.findElementRef(name).get().getType();
    }
  }


  public String getInputClass() {
    return inputClass;
  }

  public String getOutputClass() {
    return outputClass;
  }

  public String getName() {
    return name;
  }

  public List<DatabaseServiceMethodVersion> getVersions() {
    return versions;
  }
}