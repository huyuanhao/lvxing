package com.bytedance.embed_device_register;

import com.bytedance.embed_device_register.DrLogWriter.C1777a;

/* renamed from: com.bytedance.embed_device_register.c */
final class C1780c {
    /* renamed from: a */
    private static int f4929a;
    /* renamed from: b */
    private static DrLogWriter f4930b;

    static {
        m6174a(2);
        m6175a((DrLogWriter) new C1777a());
    }

    /* renamed from: a */
    public static void m6175a(DrLogWriter drLogWriter) {
        f4930b = drLogWriter;
    }

    /* renamed from: a */
    public static void m6174a(int i) {
        f4929a = i;
    }

    /* renamed from: a */
    public static void m6176a(String str, String str2) {
        m6177a(str, str2, null);
    }

    /* renamed from: a */
    public static void m6177a(String str, String str2, Throwable th) {
        DrLogWriter drLogWriter = f4930b;
        if (drLogWriter != null && f4929a <= 3) {
            drLogWriter.logD(str, str2, th);
        }
    }

    /* renamed from: b */
    public static void m6178b(String str, String str2, Throwable th) {
        DrLogWriter drLogWriter = f4930b;
        if (drLogWriter != null && f4929a <= 6) {
            drLogWriter.logE(str, str2, th);
        }
    }
}
