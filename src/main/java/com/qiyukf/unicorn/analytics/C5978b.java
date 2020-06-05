package com.qiyukf.unicorn.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Random;

/* renamed from: com.qiyukf.unicorn.analytics.b */
public final class C5978b {
    /* renamed from: a */
    private static Context f18813a;

    /* renamed from: a */
    public static void m23894a(float f) {
        String str = "YSF_SAMPLING_RATE";
        if (f != m23904d().getFloat(str, 0.0f)) {
            m23904d().edit().putFloat(str, f).commit();
            m23904d().edit().putBoolean("YSF_SWITCH", new Random().nextFloat() < f).commit();
        }
    }

    /* renamed from: a */
    public static void m23895a(long j) {
        m23903c("YSF_DISTINCT_PERIOD", j * 60000);
    }

    /* renamed from: a */
    public static void m23896a(Context context) {
        f18813a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static void m23897a(String str, long j) {
        StringBuilder sb = new StringBuilder("YSF_ERROR_");
        sb.append(str);
        m23903c(sb.toString(), j);
    }

    /* renamed from: a */
    public static boolean m23898a() {
        return m23904d().getBoolean("YSF_SWITCH", false);
    }

    /* renamed from: a */
    public static boolean m23899a(String str) {
        if (!m23898a()) {
            return false;
        }
        StringBuilder sb = new StringBuilder("YSF_ERROR_");
        sb.append(str);
        return System.currentTimeMillis() - m23900b(sb.toString(), 0) > m23900b("YSF_DISTINCT_PERIOD", 3600000);
    }

    /* renamed from: b */
    private static long m23900b(String str, long j) {
        return m23904d().getLong(str, j);
    }

    /* renamed from: b */
    public static boolean m23901b() {
        return System.currentTimeMillis() - m23900b("YSF_LAST_CONFIG_TIME", 0) >= 86400000;
    }

    /* renamed from: c */
    public static void m23902c() {
        m23903c("YSF_LAST_CONFIG_TIME", System.currentTimeMillis());
    }

    /* renamed from: c */
    private static void m23903c(String str, long j) {
        m23904d().edit().putLong(str, j).commit();
    }

    /* renamed from: d */
    private static SharedPreferences m23904d() {
        return f18813a.getSharedPreferences("com.qiyukf.analytics", 0);
    }
}
