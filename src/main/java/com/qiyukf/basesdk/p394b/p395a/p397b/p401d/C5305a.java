package com.qiyukf.basesdk.p394b.p395a.p397b.p401d;

import com.qiyukf.basesdk.C5263a;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.tencent.bugly.BuglyStrategy.C7120a;

/* renamed from: com.qiyukf.basesdk.b.a.b.d.a */
public final class C5305a {
    /* renamed from: a */
    private String f17198a = "utf-8";
    /* renamed from: b */
    private int f17199b = 131072;
    /* renamed from: c */
    private int f17200c = C7120a.MAX_USERDATA_VALUE_LENGTH;
    /* renamed from: d */
    private int f17201d = C7120a.MAX_USERDATA_VALUE_LENGTH;
    /* renamed from: e */
    private int f17202e = 2;
    /* renamed from: f */
    private int f17203f = 2;
    /* renamed from: g */
    private long f17204g = 7200000;

    /* renamed from: c */
    public static int m21810c() {
        try {
            int i = C5411c.m22142i(C5263a.m21607a());
            if (i == 0) {
                return 131072;
            }
            if (i == 1) {
                return 16384;
            }
            if (i != 2) {
                return i != 3 ? 131072 : 131072;
            }
            return 65536;
        } catch (Exception e) {
            e.printStackTrace();
            return 131072;
        }
    }

    /* renamed from: a */
    public final int mo27208a() {
        return this.f17200c;
    }

    /* renamed from: b */
    public final int mo27209b() {
        return this.f17201d;
    }

    /* renamed from: d */
    public final int mo27210d() {
        return this.f17202e;
    }

    /* renamed from: e */
    public final int mo27211e() {
        return this.f17203f;
    }
}
