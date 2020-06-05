package com.pgl.p359a.p360a;

/* renamed from: com.pgl.a.a.a */
public class C4777a {
    /* renamed from: a */
    public static int f15412a = 255;

    /* renamed from: a */
    public static String m19588a() {
        int i = f15412a;
        return i != 0 ? i != 2 ? i != 3 ? "" : "https://bds-va.byteoversea.com" : "https://bds-sg.byteoversea.com" : "https://bds.snssdk.com";
    }

    /* renamed from: a */
    public static synchronized void m19589a(int i) {
        synchronized (C4777a.class) {
            f15412a = i;
        }
    }

    /* renamed from: b */
    public static String m19590b() {
        int i = f15412a;
        return i != 0 ? i != 2 ? i != 3 ? "" : "https://sdfp-va.byteoversea.com" : "https://sdfp-sg.byteoversea.com" : "https://sdfp.snssdk.com";
    }
}
