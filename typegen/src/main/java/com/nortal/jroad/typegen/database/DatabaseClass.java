package com.nortal.jroad.typegen.database;

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.common.NameUtil;

/**
 * @author Roman Tekhov
 */
public class DatabaseClass {

	private static final String DATABASE_CLASS_NAME_SUFFIX = "XTeeDatabase";
	private static final String DATABASE_IMPL_CLASS_NAME_SUFFIX = "XTeeDatabaseImpl";

	private static final String XTEE_BASE_IMPL_CLASS_NAME = "XTeeDatabaseService";
	private static final String XROAD_BASE_IMPL_CLASS_NAME = "XRoadDatabaseService";

	private String packageName;
	private String interfaceName;
	private String implementationName;
	private String baseImplementationName;
	private List<DatabaseServiceMethod> methods = new ArrayList<DatabaseServiceMethod>();
	private final String database;

	public DatabaseClass(String database, String packageName, boolean useXroadServiceImpl) {
		this.database = database;
		this.packageName = packageName;

		interfaceName = NameUtil.upperCamelCase(database) + DATABASE_CLASS_NAME_SUFFIX;
		implementationName = NameUtil.upperCamelCase(database) + DATABASE_IMPL_CLASS_NAME_SUFFIX;
		baseImplementationName = useXroadServiceImpl ? XROAD_BASE_IMPL_CLASS_NAME : XTEE_BASE_IMPL_CLASS_NAME;
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
}