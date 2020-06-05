package com.bytedance.sdk.openadsdk.p190h;

/* renamed from: com.bytedance.sdk.openadsdk.h.c */
public class IncrementalTimeout {
    /* renamed from: a */
    private final long f8802a;
    /* renamed from: b */
    private final long f8803b;
    /* renamed from: c */
    private final long f8804c;

    /* renamed from: a */
    public long mo16718a(int i) {
        if (i <= 0) {
            return this.f8802a;
        }
        return Math.min(this.f8802a + (this.f8803b * ((long) i)), this.f8804c);
    }
}
