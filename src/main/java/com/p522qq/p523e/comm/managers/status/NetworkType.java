package com.p522qq.p523e.comm.managers.status;

import androidx.core.p003os.EnvironmentCompat;

/* renamed from: com.qq.e.comm.managers.status.NetworkType */
public enum NetworkType {
    UNKNOWN(0, 1, EnvironmentCompat.MEDIA_UNKNOWN),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, "2g"),
    NET_3G(3, 8, "3g"),
    NET_4G(4, 16, "4g");
    
    /* renamed from: a */
    private int f20264a;
    /* renamed from: b */
    private int f20265b;
    /* renamed from: c */
    private String f20266c;

    private NetworkType(int i, int i2, String str) {
        this.f20264a = i;
        this.f20265b = i2;
        this.f20266c = str;
    }

    public final int getConnValue() {
        return this.f20264a;
    }

    public final String getNameValue() {
        return this.f20266c;
    }

    public final int getPermValue() {
        return this.f20265b;
    }
}
