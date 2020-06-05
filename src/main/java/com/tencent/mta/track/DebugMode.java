package com.tencent.mta.track;

/* compiled from: ProGuard */
public enum DebugMode {
    DEBUG_OFF(false, false),
    DEBUG_ONLY(true, false),
    DEBUG_AND_TRACK(true, true);
    
    private final boolean debugMode;
    private final boolean debugWriteData;

    private DebugMode(boolean z, boolean z2) {
        this.debugMode = z;
        this.debugWriteData = z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo35806a() {
        return this.debugMode;
    }
}
