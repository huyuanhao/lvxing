package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bi */
public final class C7251bi extends C7267m {
    /* renamed from: i */
    static byte[] f24510i = new byte[1];
    /* renamed from: j */
    static Map<String, String> f24511j = new HashMap();
    /* renamed from: a */
    public byte f24512a = 0;
    /* renamed from: b */
    public int f24513b = 0;
    /* renamed from: c */
    public byte[] f24514c = null;
    /* renamed from: d */
    public String f24515d;
    /* renamed from: e */
    public long f24516e;
    /* renamed from: f */
    public String f24517f;
    /* renamed from: g */
    public String f24518g;
    /* renamed from: h */
    public Map<String, String> f24519h;

    public C7251bi() {
        String str = "";
        this.f24515d = str;
        this.f24516e = 0;
        this.f24517f = str;
        this.f24518g = str;
        this.f24519h = null;
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34946b(this.f24512a, 0);
        lVar.mo34930a(this.f24513b, 1);
        byte[] bArr = this.f24514c;
        if (bArr != null) {
            lVar.mo34939a(bArr, 2);
        }
        String str = this.f24515d;
        if (str != null) {
            lVar.mo34934a(str, 3);
        }
        lVar.mo34931a(this.f24516e, 4);
        String str2 = this.f24517f;
        if (str2 != null) {
            lVar.mo34934a(str2, 5);
        }
        String str3 = this.f24518g;
        if (str3 != null) {
            lVar.mo34934a(str3, 6);
        }
        Map<String, String> map = this.f24519h;
        if (map != null) {
            lVar.mo34936a(map, 7);
        }
    }

    static {
        f24510i[0] = 0;
        String str = "";
        f24511j.put(str, str);
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24512a = kVar.mo34899a(this.f24512a, 0, true);
        this.f24513b = kVar.mo34902a(this.f24513b, 1, true);
        this.f24514c = kVar.mo34916a(f24510i, 2, false);
        this.f24515d = kVar.mo34907a(3, false);
        this.f24516e = kVar.mo34904a(this.f24516e, 4, false);
        this.f24517f = kVar.mo34907a(5, false);
        this.f24518g = kVar.mo34907a(6, false);
        this.f24519h = (Map) kVar.mo34906a(f24511j, 7, false);
    }
}
