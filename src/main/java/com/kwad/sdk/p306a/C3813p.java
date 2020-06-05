package com.kwad.sdk.p306a;

/* renamed from: com.kwad.sdk.a.p */
public class C3813p {
    /* renamed from: a */
    private long f12930a;
    /* renamed from: b */
    private long f12931b = -1;

    public C3813p() {
        mo23210e();
    }

    /* renamed from: a */
    public void mo23206a() {
        mo23210e();
        this.f12931b = System.currentTimeMillis();
    }

    /* renamed from: b */
    public void mo23207b() {
        if (this.f12931b > 0) {
            this.f12930a += System.currentTimeMillis() - this.f12931b;
            this.f12931b = -1;
        }
    }

    /* renamed from: c */
    public void mo23208c() {
        this.f12931b = System.currentTimeMillis();
    }

    /* renamed from: d */
    public void mo23209d() {
        if (this.f12931b > 0) {
            this.f12930a += System.currentTimeMillis() - this.f12931b;
            this.f12931b = -1;
        }
    }

    /* renamed from: e */
    public void mo23210e() {
        this.f12930a = 0;
        this.f12931b = -1;
    }

    /* renamed from: f */
    public long mo23211f() {
        if (this.f12931b > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f12930a += currentTimeMillis - this.f12931b;
            this.f12931b = currentTimeMillis;
        }
        return this.f12930a;
    }
}
