package com.bytedance.sdk.p145a.p147b.p148a.p151c;

/* renamed from: com.bytedance.sdk.a.b.a.c.f */
public final class HttpMethod {
    /* renamed from: a */
    public static boolean m6999a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m7000b(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* renamed from: c */
    public static boolean m7001c(String str) {
        return m7000b(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    /* renamed from: d */
    public static boolean m7002d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m7003e(String str) {
        return !str.equals("PROPFIND");
    }
}
