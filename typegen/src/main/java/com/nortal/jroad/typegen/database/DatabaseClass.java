package com.nortal.jroad.typegen.database;

import com.nortal.jroad.enums.XRoadProtocolVersion;
import java.beans.Introspector;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.impl.common.NameUtil;

/**
 * @author Roman Tekhov
 */
public class DatabaseClass {

	private static final String XTEE_DATABASE_CLASS_NAME_SUFFIX = "XTeeDatabase";
	private static final String XTEE_DATABASE_IMPL_CLASS_NAME_SUFFIX = "XTeeDatabaseImpl";
	private static final String XROAD_DATABASE_CLASS_NAME_SUFFIX = "XRoadDatabase";
	private static final String XROAD_DATABASE_IMPL_CLASS_NAME_SUFFIX = "XRoadDatabaseImpl";

	private static final String XTEE_BASE_IMPL_CLASS_NAME = "XTeeDatabaseService";
	private static final String XROAD_BASE_IMPL_CLASS_NAME = "XRoadDatabaseService";

	private final String database;
	private String packageName;
	private String interfaceName;
	private String implementationName;
	private String baseImplementationName;
	private final XRoadProtocolVersion version;
	private List<DatabaseServiceMethod> methods = new ArrayList<DatabaseServiceMethod>();

	public DatabaseClass(String database, String packageName, XRoadProtocolVersion version) {
		this.database = database;
		this.packageName = packageName;
		this.version = version;

    switch (version) {
    case V2_0:
      interfaceName = NameUtil.upperCamelCase(database) + XTEE_DATABASE_CLASS_NAME_SUFFIX;
      implementationName = NameUtil.upperCamelCase(database) + XTEE_DATABASE_IMPL_CLASS_NAME_SUFFIX;
      baseImplementationName = XTEE_BASE_IMPL_CLASS_NAME;
      break;
    default:
      interfaceName = NameUtil.upperCamelCase(database) + XROAD_DATABASE_CLASS_NAME_SUFFIX;
      implementationName = NameUtil.upperCamelCase(database) + XROAD_DATABASE_IMPL_CLASS_NAME_SUFFIX;
      baseImplementationName = XROAD_BASE_IMPL_CLASS_NAME;
      break;
    }
	}

	void add(DatabaseServiceMethod method) {
		methods.add(method);
	}

	public String getDatabase() {
		return database;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public String getInterfaceNameDecapitalized() {
		return Introspector.decapitalize(interfaceName);
	}

	public String getImplementationName() {
		return implementationName;
	}

	public String getBaseImplementationName() {
		return baseImplementationName;
	}

	public void setBaseImplementationName(String baseImplementationName) {
		this.baseImplementationName = baseImplementationName;
	}

	public String getQualifiedInterfaceName() {
		return packageName + "." + interfaceName;
	}

	public String getQualifiedImplementationName() {
		return packageName + "." + implementationName;
	}

	public List<DatabaseServiceMethod> getMethods() {
		return methods;
	}

  public String getPackageSuffix() {
    return version.getPackageSuffix();
  }
}