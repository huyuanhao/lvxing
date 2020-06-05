package com.tencent.mta.track.thrift;

/* compiled from: ProGuard */
public enum DeviceType {
    Android(0),
    iOS(1);
    
    private final int value;

    private DeviceType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    /* renamed from: a */
    public static DeviceType m31887a(int i) {
        if (i == 0) {
            return Android;
        }
        if (i != 1) {
            return null;
        }
        return iOS;
    }
}
