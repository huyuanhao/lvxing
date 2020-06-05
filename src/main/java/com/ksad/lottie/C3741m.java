package com.ksad.lottie;

import java.util.Map;

/* renamed from: com.ksad.lottie.m */
public class C3741m {
    /* renamed from: a */
    private final Map<String, String> f12704a;
    /* renamed from: b */
    private boolean f12705b;

    /* renamed from: b */
    private String m15513b(String str) {
        return str;
    }

    /* renamed from: a */
    public final String mo23029a(String str) {
        if (this.f12705b && this.f12704a.containsKey(str)) {
            return (String) this.f12704a.get(str);
        }
        String b = m15513b(str);
        if (this.f12705b) {
            this.f12704a.put(str, b);
        }
        return b;
    }
}
