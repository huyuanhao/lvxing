package com.qiyukf.basesdk;

import android.content.Context;
import com.qiyukf.basesdk.sdk.ServerAddresses;

/* renamed from: com.qiyukf.basesdk.a */
public final class C5263a {
    /* renamed from: a */
    private static Context f17051a;
    /* renamed from: b */
    private static C5272b f17052b;

    /* renamed from: a */
    public static Context m21607a() {
        return f17051a;
    }

    /* renamed from: a */
    public static void m21608a(Context context, C5272b bVar) {
        f17051a = context.getApplicationContext();
        f17052b = bVar;
    }

    /* renamed from: b */
    public static String m21609b() {
        return f17052b.mo27114a();
    }

    /* renamed from: c */
    public static int m21610c() {
        return f17052b.mo27115b();
    }

    /* renamed from: d */
    public static ServerAddresses m21611d() {
        return f17052b.mo27116c();
    }

    /* renamed from: e */
    public static String m21612e() {
        return f17052b.mo27117d();
    }

    /* renamed from: f */
    public static String m21613f() {
        return f17052b.mo27118e();
    }

    /* renamed from: g */
    public static void m21614g() {
        f17052b.mo27119f();
    }
}
