package com.alipay.android.phone.mrpc.core;

/* renamed from: com.alipay.android.phone.mrpc.core.p */
public final class C1425p extends C1430u {
    /* renamed from: c */
    private int f3654c;
    /* renamed from: d */
    private String f3655d;
    /* renamed from: e */
    private long f3656e;
    /* renamed from: f */
    private long f3657f;
    /* renamed from: g */
    private String f3658g;
    /* renamed from: h */
    private HttpUrlHeader f3659h;

    public C1425p(HttpUrlHeader httpUrlHeader, int i, String str, byte[] bArr) {
        this.f3659h = httpUrlHeader;
        this.f3654c = i;
        this.f3655d = str;
        this.f3680a = bArr;
    }

    /* renamed from: a */
    public final HttpUrlHeader mo11988a() {
        return this.f3659h;
    }

    /* renamed from: a */
    public final void mo11989a(long j) {
        this.f3656e = j;
    }

    /* renamed from: a */
    public final void mo11990a(String str) {
        this.f3658g = str;
    }

    /* renamed from: b */
    public final void mo11991b(long j) {
        this.f3657f = j;
    }
}
