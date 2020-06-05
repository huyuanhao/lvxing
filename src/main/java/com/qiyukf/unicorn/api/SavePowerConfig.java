package com.qiyukf.unicorn.api;

import java.io.Serializable;

public class SavePowerConfig implements Serializable {
    public long activeDelay;
    public long checkInterval;
    public boolean customPush;
    public String deviceIdentifier;

    public SavePowerConfig() {
        this(false, 259200, 3600);
    }

    public SavePowerConfig(boolean z, long j, long j2) {
        this.customPush = z;
        this.activeDelay = j;
        this.checkInterval = j2;
    }
}
