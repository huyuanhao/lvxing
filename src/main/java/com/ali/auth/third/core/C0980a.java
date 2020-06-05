package com.ali.auth.third.core;

import com.ali.auth.third.core.p024c.C0989a;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.ali.auth.third.core.a */
public class C0980a {
    /* renamed from: a */
    private static final Map<String, String> f1884a = Collections.singletonMap("$isv_scope$", "true");

    /* renamed from: a */
    public static <T> T m1867a(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        return C0989a.f1900o.mo10325a(cls, f1884a);
    }
}
