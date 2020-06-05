package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bl */
public final class C7254bl extends C7267m {
    /* renamed from: i */
    static Map<String, String> f24537i = new HashMap();
    /* renamed from: a */
    public long f24538a = 0;
    /* renamed from: b */
    public byte f24539b = 0;
    /* renamed from: c */
    public String f24540c;
    /* renamed from: d */
    public String f24541d;
    /* renamed from: e */
    public String f24542e;
    /* renamed from: f */
    public Map<String, String> f24543f;
    /* renamed from: g */
    public String f24544g;
    /* renamed from: h */
    public boolean f24545h;

    public C7254bl() {
        String str = "";
        this.f24540c = str;
        this.f24541d = str;
        this.f24542e = str;
        this.f24543f = null;
        this.f24544g = str;
        this.f24545h = true;
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34931a(this.f24538a, 0);
        lVar.mo34946b(this.f24539b, 1);
        String str = this.f24540c;
        if (str != null) {
            lVar.mo34934a(str, 2);
        }
        String str2 = this.f24541d;
        if (str2 != null) {
            lVar.mo34934a(str2, 3);
        }
        String str3 = this.f24542e;
        if (str3 != null) {
            lVar.mo34934a(str3, 4);
        }
        Map<String, String> map = this.f24543f;
        if (map != null) {
            lVar.mo34936a(map, 5);
        }
        String str4 = this.f24544g;
        if (str4 != null) {
            lVar.mo34934a(str4, 6);
        }
        lVar.mo34938a(this.f24545h, 7);
    }

    static {
        String str = "";
        f24537i.put(str, str);
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24538a = kVar.mo34904a(this.f24538a, 0, true);
        this.f24539b = kVar.mo34899a(this.f24539b, 1, true);
        this.f24540c = kVar.mo34907a(2, false);
        this.f24541d = kVar.mo34907a(3, false);
        this.f24542e = kVar.mo34907a(4, false);
        this.f24543f = (Map) kVar.mo34906a(f24537i, 5, false);
        this.f24544g = kVar.mo34907a(6, false);
        this.f24545h = kVar.mo34915a(this.f24545h, 7, false);
    }
}
