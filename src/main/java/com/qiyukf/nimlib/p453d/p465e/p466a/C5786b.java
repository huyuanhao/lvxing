package com.qiyukf.nimlib.p453d.p465e.p466a;

import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: com.qiyukf.nimlib.d.e.a.b */
public final class C5786b {

    /* renamed from: com.qiyukf.nimlib.d.e.a.b$a */
    public interface C5787a {
        /* renamed from: a */
        void mo28071a();

        /* renamed from: b */
        void mo28072b();
    }

    /* renamed from: a */
    public static void m23242a(Context context) {
        if (m23244a()) {
            C5784a.m23233a(context);
        }
    }

    /* renamed from: a */
    public static void m23243a(C5787a aVar) {
        if (m23244a()) {
            C5784a.m23234a(aVar);
        }
    }

    /* renamed from: a */
    private static boolean m23244a() {
        return VERSION.SDK_INT >= 14;
    }

    /* renamed from: b */
    public static void m23245b(Context context) {
        C5784a.m23237b(context);
    }

    /* renamed from: b */
    public static void m23246b(C5787a aVar) {
        if (m23244a()) {
            C5784a.m23238b(aVar);
        }
    }
}
