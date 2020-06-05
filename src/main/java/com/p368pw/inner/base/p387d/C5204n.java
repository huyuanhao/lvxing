package com.p368pw.inner.base.p387d;

import com.google.gson.Gson;

/* renamed from: com.pw.inner.base.d.n */
public class C5204n {
    /* renamed from: a */
    private static final Gson f16927a = new Gson();

    /* renamed from: a */
    public static <T> T m21459a(String str, Class<T> cls) {
        return f16927a.fromJson(str, cls);
    }

    /* renamed from: a */
    public static String m21460a(Object obj) {
        try {
            return f16927a.toJson(obj);
        } catch (Throwable unused) {
            return "";
        }
    }
}
