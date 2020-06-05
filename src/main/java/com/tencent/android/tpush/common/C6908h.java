package com.tencent.android.tpush.common;

import android.content.Context;
import com.tencent.android.tpush.common.C6910j.C6912a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.common.h */
public class C6908h {
    /* renamed from: a */
    private static C6910j f22977a;

    /* renamed from: a */
    static synchronized C6910j m29482a(Context context) {
        C6910j jVar;
        synchronized (C6908h.class) {
            if (f22977a == null) {
                f22977a = C6910j.m29490a(context);
            }
            jVar = f22977a;
        }
        return jVar;
    }

    /* renamed from: a */
    public static long m29481a(Context context, String str, long j) {
        return m29482a(context).mo33110a(str, j);
    }

    /* renamed from: b */
    public static void m29486b(Context context, String str, long j) {
        C6912a a = m29482a(context).mo33111a();
        a.mo33114a(str, j);
        a.mo33118b();
    }

    /* renamed from: a */
    public static int m29480a(Context context, String str, int i) {
        return m29482a(context).mo33109a(str, i);
    }

    /* renamed from: b */
    public static void m29485b(Context context, String str, int i) {
        C6912a a = m29482a(context).mo33111a();
        a.mo33113a(str, i);
        a.mo33118b();
    }

    /* renamed from: a */
    public static String m29483a(Context context, String str, String str2) {
        return m29482a(context).mo33112a(str, str2);
    }

    /* renamed from: b */
    public static void m29487b(Context context, String str, String str2) {
        C6912a a = m29482a(context).mo33111a();
        a.mo33115a(str, str2);
        a.mo33118b();
    }

    /* renamed from: a */
    public static void m29484a(Context context, String str) {
        if (m29482a(context) != null) {
            C6912a a = m29482a(context).mo33111a();
            a.mo33117a(str);
            a.mo33118b();
        }
    }
}
