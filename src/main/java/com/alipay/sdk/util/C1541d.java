package com.alipay.sdk.util;

import p655io.reactivex.annotations.SchedulerSupport;

/* renamed from: com.alipay.sdk.util.d */
public enum C1541d {
    f3934a(0, r1),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, r6),
    NETWORK_TYPE_6(6, r6),
    NETWORK_TYPE_12(12, r6),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NONE(-1, SchedulerSupport.NONE);
    
    /* renamed from: p */
    private int f3950p;
    /* renamed from: q */
    private String f3951q;

    private C1541d(int i, String str) {
        this.f3950p = i;
        this.f3951q = str;
    }

    /* renamed from: a */
    public final int mo12214a() {
        return this.f3950p;
    }

    /* renamed from: b */
    public final String mo12215b() {
        return this.f3951q;
    }

    /* renamed from: a */
    public static C1541d m4628a(int i) {
        C1541d[] values;
        for (C1541d dVar : values()) {
            if (dVar.mo12214a() == i) {
                return dVar;
            }
        }
        return NONE;
    }
}
