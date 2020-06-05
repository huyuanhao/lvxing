package com.airbnb.lottie;

import java.util.Map;

/* renamed from: com.airbnb.lottie.m */
public class TextDelegate {
    /* renamed from: a */
    private final Map<String, String> f1565a;
    /* renamed from: b */
    private boolean f1566b;

    /* renamed from: b */
    private String m1519b(String str) {
        return str;
    }

    /* renamed from: a */
    public final String mo10010a(String str) {
        if (this.f1566b && this.f1565a.containsKey(str)) {
            return (String) this.f1565a.get(str);
        }
        String b = m1519b(str);
        if (this.f1566b) {
            this.f1565a.put(str, b);
        }
        return b;
    }
}
