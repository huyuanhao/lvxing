package com.kwai.filedownloader.p358f;

import android.util.Log;

/* renamed from: com.kwai.filedownloader.f.d */
public class C4660d {
    /* renamed from: a */
    public static boolean f15179a = false;

    /* renamed from: a */
    private static String m19117a(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("FileDownloader.");
        sb.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
        return sb.toString();
    }

    /* renamed from: a */
    private static void m19118a(int i, Object obj, String str, Object... objArr) {
        m19119a(i, obj, null, str, objArr);
    }

    /* renamed from: a */
    private static void m19119a(int i, Object obj, Throwable th, String str, Object... objArr) {
        if ((i >= 5) || f15179a) {
            Log.println(i, m19117a(obj), C4664f.m19135a(str, objArr));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m19120a(Object obj, String str, Object... objArr) {
        m19118a(6, obj, str, objArr);
    }

    /* renamed from: a */
    public static void m19121a(Object obj, Throwable th, String str, Object... objArr) {
        m19119a(6, obj, th, str, objArr);
    }

    /* renamed from: b */
    public static void m19122b(Object obj, String str, Object... objArr) {
        m19118a(4, obj, str, objArr);
    }

    /* renamed from: c */
    public static void m19123c(Object obj, String str, Object... objArr) {
        m19118a(3, obj, str, objArr);
    }

    /* renamed from: d */
    public static void m19124d(Object obj, String str, Object... objArr) {
        m19118a(5, obj, str, objArr);
    }

    /* renamed from: e */
    public static void m19125e(Object obj, String str, Object... objArr) {
        m19118a(2, obj, str, objArr);
    }
}
