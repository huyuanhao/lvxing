package com.bytedance.sdk.openadsdk.core.p170d;

/* renamed from: com.bytedance.sdk.openadsdk.core.d.n */
public class SplashAdCache {
    /* renamed from: a */
    private MaterialMeta f7466a;
    /* renamed from: b */
    private byte[] f7467b;
    /* renamed from: c */
    private AdInfo f7468c;

    public SplashAdCache(AdInfo aVar, MaterialMeta kVar, byte[] bArr) {
        this.f7468c = aVar;
        this.f7466a = kVar;
        this.f7467b = bArr;
    }

    /* renamed from: a */
    public MaterialMeta mo15545a() {
        return this.f7466a;
    }

    /* renamed from: a */
    public void mo15546a(MaterialMeta kVar) {
        this.f7466a = kVar;
        MaterialMeta kVar2 = this.f7466a;
        if (kVar2 != null) {
            kVar2.mo15470c(true);
        }
    }

    /* renamed from: b */
    public byte[] mo15548b() {
        return this.f7467b;
    }

    /* renamed from: a */
    public void mo15547a(byte[] bArr) {
        this.f7467b = bArr;
    }

    /* renamed from: c */
    public AdInfo mo15549c() {
        return this.f7468c;
    }
}
