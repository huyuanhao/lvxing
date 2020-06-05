package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.u */
public final class C7278u extends C7267m implements Cloneable {
    /* renamed from: f */
    static final /* synthetic */ boolean f24616f = (!C7278u.class.desiredAssertionStatus());
    /* renamed from: a */
    public String f24617a;
    /* renamed from: b */
    public String f24618b;
    /* renamed from: c */
    public String f24619c;
    /* renamed from: d */
    public long f24620d = 0;
    /* renamed from: e */
    public String f24621e;

    /* renamed from: a */
    public String mo34968a() {
        return this.f24618b;
    }

    public C7278u() {
        String str = "";
        this.f24617a = str;
        this.f24618b = str;
        this.f24619c = str;
        this.f24621e = str;
    }

    public C7278u(String str, String str2, String str3, long j, String str4) {
        String str5 = "";
        this.f24617a = str5;
        this.f24618b = str5;
        this.f24619c = str5;
        this.f24621e = str5;
        this.f24617a = str;
        this.f24618b = str2;
        this.f24619c = str3;
        this.f24620d = j;
        this.f24621e = str4;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7278u uVar = (C7278u) obj;
        if (C7268n.m31403a((Object) this.f24617a, (Object) uVar.f24617a) && C7268n.m31403a((Object) this.f24618b, (Object) uVar.f24618b) && C7268n.m31403a((Object) this.f24619c, (Object) uVar.f24619c) && C7268n.m31402a(this.f24620d, uVar.f24620d) && C7268n.m31403a((Object) this.f24621e, (Object) uVar.f24621e)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f24616f) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34934a(this.f24617a, 0);
        lVar.mo34934a(this.f24618b, 1);
        String str = this.f24619c;
        if (str != null) {
            lVar.mo34934a(str, 2);
        }
        lVar.mo34931a(this.f24620d, 3);
        String str2 = this.f24621e;
        if (str2 != null) {
            lVar.mo34934a(str2, 4);
        }
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24617a = kVar.mo34907a(0, true);
        this.f24618b = kVar.mo34907a(1, true);
        this.f24619c = kVar.mo34907a(2, false);
        this.f24620d = kVar.mo34904a(this.f24620d, 3, true);
        this.f24621e = kVar.mo34907a(4, false);
    }

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
        C7262i iVar = new C7262i(sb, i);
        iVar.mo34887a(this.f24617a, "apkMd5");
        iVar.mo34887a(this.f24618b, "apkUrl");
        iVar.mo34887a(this.f24619c, "manifestMd5");
        iVar.mo34884a(this.f24620d, "fileSize");
        iVar.mo34887a(this.f24621e, "signatureMd5");
    }
}
