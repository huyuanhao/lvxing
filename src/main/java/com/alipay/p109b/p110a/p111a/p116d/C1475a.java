package com.alipay.p109b.p110a.p111a.p116d;

import android.content.Context;

/* renamed from: com.alipay.b.a.a.d.a */
public class C1475a {
    /* renamed from: a */
    private static C1475a f3752a = new C1475a();

    private C1475a() {
    }

    /* renamed from: a */
    public static C1475a m4297a() {
        return f3752a;
    }

    /* renamed from: a */
    public String mo12032a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return "0.0.0";
        }
    }
}
