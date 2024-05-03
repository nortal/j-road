package com.nortal.jroad.typegen;

import com.nortal.jroad.enums.XRoadProtocolVersion;

public class DatabaseDescriptor {
    private String id;
    private boolean overrideId;
    private XRoadProtocolVersion version;

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

}
