package ee.webmedia.xtee.typegen.database;

import ee.webmedia.xtee.model.XmlBeansXTeeMetadata;
import org.apache.xmlbeans.impl.common.NameUtil;

/**
 * @author Roman Tekhov
 */
public class DatabaseServiceMethodVersion {

  private String name;
  private int version;


  public DatabaseServiceMethodVersion(XmlBeansXTeeMetadata serviceMetadata, int version) {
    this.version = version;
    name = NameUtil.lowerCamelCase(serviceMetadata.getOperationName() + "_v" + version);
  }


  public String getName() {
    return name;
  }

  public int getVersion() {
    return version;
  }
}