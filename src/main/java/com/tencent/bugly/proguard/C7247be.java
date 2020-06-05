package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.be */
public final class C7247be extends C7267m implements Cloneable {
    /* renamed from: d */
    static byte[] f24449d;
    /* renamed from: a */
    public byte f24450a = 0;
    /* renamed from: b */
    public String f24451b = "";
    /* renamed from: c */
    public byte[] f24452c = null;

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
    }

    public C7247be() {
    }

    public C7247be(byte b, String str, byte[] bArr) {
        this.f24450a = b;
        this.f24451b = str;
        this.f24452c = bArr;
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34946b(this.f24450a, 0);
        lVar.mo34934a(this.f24451b, 1);
        byte[] bArr = this.f24452c;
        if (bArr != null) {
            lVar.mo34939a(bArr, 2);
        }
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24450a = kVar.mo34899a(this.f24450a, 0, true);
        this.f24451b = kVar.mo34907a(1, true);
        if (f24449d == null) {
            f24449d = new byte[1];
            f24449d[0] = 0;
        }
        this.f24452c = kVar.mo34916a(f24449d, 2, false);
    }
}
