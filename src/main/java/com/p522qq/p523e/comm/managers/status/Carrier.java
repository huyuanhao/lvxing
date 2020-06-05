package com.p522qq.p523e.comm.managers.status;

/* renamed from: com.qq.e.comm.managers.status.Carrier */
public enum Carrier {
    UNKNOWN(0),
    CMCC(1),
    UNICOM(2),
    TELECOM(3);
    
    /* renamed from: a */
    private int f20246a;

    private Carrier(int i) {
        this.f20246a = i;
    }

    public final int getValue() {
        return this.f20246a;
    }
}
