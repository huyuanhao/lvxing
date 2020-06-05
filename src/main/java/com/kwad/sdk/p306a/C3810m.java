package com.kwad.sdk.p306a;

import android.content.Context;

/* renamed from: com.kwad.sdk.a.m */
public class C3810m {
    /* renamed from: a */
    public static long m15799a(Context context, String str) {
        return context.getSharedPreferences("ksadsdk_pref", 0).getLong(str, 0);
    }

    /* renamed from: a */
    public static void m15800a(Context context, String str, long j) {
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(str, j).apply();
    }

    /* renamed from: a */
    public static void m15801a(Context context, boolean z) {
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putBoolean("ksadsdk_guider_playloop", z).apply();
    }

    /* renamed from: a */
    public static boolean m15802a(Context context) {
        return context.getSharedPreferences("ksadsdk_pref", 0).getBoolean("ksadsdk_guider_like", true);
    }

    /* renamed from: b */
    public static void m15803b(Context context) {
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putBoolean("ksadsdk_guider_like", false).apply();
    }

    /* renamed from: c */
    public static boolean m15804c(Context context) {
        return m15802a(context) || m15805d(context);
    }

    /* renamed from: d */
    public static boolean m15805d(Context context) {
        return context.getSharedPreferences("ksadsdk_pref", 0).getBoolean("ksadsdk_guider_slideup", true);
    }

    /* renamed from: e */
    public static void m15806e(Context context) {
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putBoolean("ksadsdk_guider_slideup", false).apply();
    }

    /* renamed from: f */
    public static boolean m15807f(Context context) {
        if (!m15804c(context)) {
            return false;
        }
        return context.getSharedPreferences("ksadsdk_pref", 0).getBoolean("ksadsdk_guider_playloop", true);
    }
}
