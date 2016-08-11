package com.nortal.jroad.typegen;

import com.nortal.jroad.enums.XRoadProtocolVersion;
import org.apache.commons.lang.BooleanUtils;

import java.util.Properties;

public class DatabaseDescriptor {
    private String id;
    private boolean overrideId;
    private XRoadProtocolVersion version;
    private final boolean generateMetaOperations;

    public DatabaseDescriptor(Properties databaseProps) {
        String generateMetaValue = databaseProps.getProperty("generateMetaOperations");
        this.generateMetaOperations = generateMetaValue != null && BooleanUtils.toBoolean(generateMetaValue);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        setId(id, false);
    }

    /**
     * @param overrides when 'true', the given database id will be fixed and further assignments will not have effect
     */
    public void setId(String id, boolean overrides) {
        if (overrideId) {
            return;
        }
        this.id = id;
        this.overrideId = overrides;
    }

    public void set(String id, XRoadProtocolVersion version) {
        this.version = version;
        setId(id);
    }

    public XRoadProtocolVersion getVersion() {
        return version;
    }

    public boolean isGenerateMetaOperations() {
        return generateMetaOperations;
    }
}
