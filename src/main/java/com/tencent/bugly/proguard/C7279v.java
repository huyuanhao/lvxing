package com.tencent.bugly.proguard;

import com.tencent.p605ep.commonbase.software.AppEntity;
import com.tencent.p607mm.opensdk.constants.ConstantsAPI.Token;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.v */
public final class C7279v extends C7267m implements Cloneable {
    /* renamed from: l */
    static final /* synthetic */ boolean f24622l = (!C7279v.class.desiredAssertionStatus());
    /* renamed from: a */
    public String f24623a;
    /* renamed from: b */
    public byte f24624b = 0;
    /* renamed from: c */
    public int f24625c = 0;
    /* renamed from: d */
    public String f24626d;
    /* renamed from: e */
    public int f24627e;
    /* renamed from: f */
    public String f24628f;
    /* renamed from: g */
    public long f24629g;
    /* renamed from: h */
    public String f24630h;
    /* renamed from: i */
    public String f24631i;
    /* renamed from: j */
    public String f24632j;
    /* renamed from: k */
    public String f24633k;

    public C7279v() {
        String str = "";
        this.f24623a = str;
        this.f24626d = str;
        this.f24627e = 0;
        this.f24628f = str;
        this.f24629g = 0;
        this.f24630h = str;
        this.f24631i = str;
        this.f24632j = str;
        this.f24633k = str;
    }

    public C7279v(String str, byte b, int i, String str2, int i2, String str3, long j, String str4, String str5, String str6, String str7) {
        String str8 = "";
        this.f24623a = str8;
        this.f24626d = str8;
        this.f24627e = 0;
        this.f24628f = str8;
        this.f24629g = 0;
        this.f24630h = str8;
        this.f24631i = str8;
        this.f24632j = str8;
        this.f24633k = str8;
        this.f24623a = str;
        this.f24624b = b;
        this.f24625c = i;
        this.f24626d = str2;
        this.f24627e = i2;
        this.f24628f = str3;
        this.f24629g = j;
        this.f24630h = str4;
        this.f24631i = str5;
        this.f24632j = str6;
        this.f24633k = str7;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7279v vVar = (C7279v) obj;
        if (C7268n.m31403a((Object) this.f24623a, (Object) vVar.f24623a) && C7268n.m31400a(this.f24624b, vVar.f24624b) && C7268n.m31401a(this.f24625c, vVar.f24625c) && C7268n.m31403a((Object) this.f24626d, (Object) vVar.f24626d) && C7268n.m31401a(this.f24627e, vVar.f24627e) && C7268n.m31403a((Object) this.f24628f, (Object) vVar.f24628f) && C7268n.m31402a(this.f24629g, vVar.f24629g) && C7268n.m31403a((Object) this.f24630h, (Object) vVar.f24630h) && C7268n.m31403a((Object) this.f24631i, (Object) vVar.f24631i) && C7268n.m31403a((Object) this.f24632j, (Object) vVar.f24632j) && C7268n.m31403a((Object) this.f24633k, (Object) vVar.f24633k)) {
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
            if (f24622l) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34934a(this.f24623a, 0);
        lVar.mo34946b(this.f24624b, 1);
        lVar.mo34930a(this.f24625c, 2);
        String str = this.f24626d;
        if (str != null) {
            lVar.mo34934a(str, 3);
        }
        lVar.mo34930a(this.f24627e, 4);
        String str2 = this.f24628f;
        if (str2 != null) {
            lVar.mo34934a(str2, 5);
        }
        lVar.mo34931a(this.f24629g, 6);
        String str3 = this.f24630h;
        if (str3 != null) {
            lVar.mo34934a(str3, 7);
        }
        String str4 = this.f24631i;
        if (str4 != null) {
            lVar.mo34934a(str4, 8);
        }
        String str5 = this.f24632j;
        if (str5 != null) {
            lVar.mo34934a(str5, 9);
        }
        String str6 = this.f24633k;
        if (str6 != null) {
            lVar.mo34934a(str6, 10);
        }
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24623a = kVar.mo34907a(0, true);
        this.f24624b = kVar.mo34899a(this.f24624b, 1, true);
        this.f24625c = kVar.mo34902a(this.f24625c, 2, true);
        this.f24626d = kVar.mo34907a(3, false);
        this.f24627e = kVar.mo34902a(this.f24627e, 4, false);
        this.f24628f = kVar.mo34907a(5, false);
        this.f24629g = kVar.mo34904a(this.f24629g, 6, false);
        this.f24630h = kVar.mo34907a(7, false);
        this.f24631i = kVar.mo34907a(8, false);
        this.f24632j = kVar.mo34907a(9, false);
        this.f24633k = kVar.mo34907a(10, false);
    }

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
        C7262i iVar = new C7262i(sb, i);
        iVar.mo34887a(this.f24623a, "appId");
        iVar.mo34879a(this.f24624b, Token.WX_TOKEN_PLATFORMID_KEY);
        iVar.mo34883a(this.f24625c, AppEntity.KEY_VERSION_CODE_INT);
        iVar.mo34887a(this.f24626d, "versionName");
        iVar.mo34883a(this.f24627e, "buildNo");
        iVar.mo34887a(this.f24628f, "iconUrl");
        iVar.mo34884a(this.f24629g, "apkId");
        iVar.mo34887a(this.f24630h, C7887a.f26838Mh);
        iVar.mo34887a(this.f24631i, "md5");
        iVar.mo34887a(this.f24632j, "sdkVer");
        iVar.mo34887a(this.f24633k, "bundleId");
    }
}
