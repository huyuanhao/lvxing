package com.kwad.sdk.core.p333g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.kwad.sdk.core.p319c.C4065b;
import java.util.UUID;

/* renamed from: com.kwad.sdk.core.g.k */
public class C4160k {
    /* renamed from: a */
    private static String f13880a = m17231f();
    /* renamed from: b */
    private static long f13881b = 0;
    /* renamed from: c */
    private static Context f13882c;

    /* renamed from: a */
    public static String m17223a() {
        C4065b.m16863a("ReportIdManager", ">> updateSessionId");
        f13880a = m17231f();
        return f13880a;
    }

    /* renamed from: a */
    public static void m17224a(Context context) {
        f13882c = context;
    }

    /* renamed from: a */
    private static boolean m17225a(Context context, long j) {
        if (context == null) {
            return false;
        }
        Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        edit.putLong("seq", j);
        return edit.commit();
    }

    /* renamed from: b */
    private static long m17226b(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getLong("seq", 1);
            }
        }
        return 0;
    }

    /* renamed from: b */
    public static String m17227b() {
        return f13880a;
    }

    /* renamed from: c */
    public static long m17228c() {
        long b = m17226b(f13882c);
        m17225a(f13882c, 1 + b);
        return b;
    }

    /* renamed from: d */
    public static long m17229d() {
        C4065b.m16863a("ReportIdManager", ">> updateListId");
        f13881b = System.currentTimeMillis();
        return f13881b;
    }

    /* renamed from: e */
    public static long m17230e() {
        return f13881b;
    }

    /* renamed from: f */
    private static String m17231f() {
        return UUID.randomUUID().toString();
    }
}
