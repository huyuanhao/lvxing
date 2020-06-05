package com.bytedance.embedapplog.util;

/* renamed from: com.bytedance.embedapplog.util.g */
public class C1855g {
    /* renamed from: a */
    private static boolean f5222a;
    /* renamed from: b */
    private static long f5223b;
    /* renamed from: c */
    private static long f5224c;

    /* renamed from: a */
    public static long m6575a() {
        return System.currentTimeMillis() / 86400000;
    }

    /* renamed from: b */
    public static void m6577b() {
        f5223b++;
        StringBuilder sb = new StringBuilder();
        sb.append("addFailedCount ");
        sb.append(f5223b);
        C1856h.m6581a(sb.toString(), null);
    }

    /* renamed from: c */
    public static boolean m6578c() {
        StringBuilder sb = new StringBuilder();
        sb.append("canSave ");
        sb.append(f5222a);
        C1856h.m6581a(sb.toString(), null);
        return f5222a;
    }

    /* renamed from: d */
    public static boolean m6579d() {
        boolean z = f5223b < 3 && m6575a() != f5224c && f5222a;
        StringBuilder sb = new StringBuilder();
        sb.append("canSend ");
        sb.append(z);
        C1856h.m6581a(sb.toString(), null);
        return z;
    }

    /* renamed from: e */
    public static void m6580e() {
        f5224c = m6575a();
        StringBuilder sb = new StringBuilder();
        sb.append("setSendFinished ");
        sb.append(f5224c);
        C1856h.m6581a(sb.toString(), null);
    }

    /* renamed from: a */
    public static void m6576a(boolean z) {
        f5222a = z;
    }
}
