package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bk */
public final class C7253bk extends C7267m implements Cloneable {
    /* renamed from: m */
    static C7252bj f24522m = new C7252bj();
    /* renamed from: n */
    static Map<String, String> f24523n = new HashMap();
    /* renamed from: o */
    static final /* synthetic */ boolean f24524o = (!C7253bk.class.desiredAssertionStatus());
    /* renamed from: a */
    public boolean f24525a = true;
    /* renamed from: b */
    public boolean f24526b = true;
    /* renamed from: c */
    public boolean f24527c = true;
    /* renamed from: d */
    public String f24528d;
    /* renamed from: e */
    public String f24529e;
    /* renamed from: f */
    public C7252bj f24530f;
    /* renamed from: g */
    public Map<String, String> f24531g;
    /* renamed from: h */
    public long f24532h;
    /* renamed from: i */
    public String f24533i;
    /* renamed from: j */
    public String f24534j;
    /* renamed from: k */
    public int f24535k;
    /* renamed from: l */
    public int f24536l;

    static {
        String str = "";
        f24523n.put(str, str);
    }

    public C7253bk() {
        String str = "";
        this.f24528d = str;
        this.f24529e = str;
        this.f24530f = null;
        this.f24531g = null;
        this.f24532h = 0;
        this.f24533i = str;
        this.f24534j = str;
        this.f24535k = 0;
        this.f24536l = 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7253bk bkVar = (C7253bk) obj;
        if (C7268n.m31404a(this.f24525a, bkVar.f24525a) && C7268n.m31404a(this.f24526b, bkVar.f24526b) && C7268n.m31404a(this.f24527c, bkVar.f24527c) && C7268n.m31403a((Object) this.f24528d, (Object) bkVar.f24528d) && C7268n.m31403a((Object) this.f24529e, (Object) bkVar.f24529e) && C7268n.m31403a((Object) this.f24530f, (Object) bkVar.f24530f) && C7268n.m31403a((Object) this.f24531g, (Object) bkVar.f24531g) && C7268n.m31402a(this.f24532h, bkVar.f24532h) && C7268n.m31403a((Object) this.f24533i, (Object) bkVar.f24533i) && C7268n.m31403a((Object) this.f24534j, (Object) bkVar.f24534j) && C7268n.m31401a(this.f24535k, bkVar.f24535k) && C7268n.m31401a(this.f24536l, bkVar.f24536l)) {
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
            if (f24524o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34938a(this.f24525a, 0);
        lVar.mo34938a(this.f24526b, 1);
        lVar.mo34938a(this.f24527c, 2);
        String str = this.f24528d;
        if (str != null) {
            lVar.mo34934a(str, 3);
        }
        String str2 = this.f24529e;
        if (str2 != null) {
            lVar.mo34934a(str2, 4);
        }
        C7252bj bjVar = this.f24530f;
        if (bjVar != null) {
            lVar.mo34932a((C7267m) bjVar, 5);
        }
        Map<String, String> map = this.f24531g;
        if (map != null) {
            lVar.mo34936a(map, 6);
        }
        lVar.mo34931a(this.f24532h, 7);
        String str3 = this.f24533i;
        if (str3 != null) {
            lVar.mo34934a(str3, 8);
        }
        String str4 = this.f24534j;
        if (str4 != null) {
            lVar.mo34934a(str4, 9);
        }
        lVar.mo34930a(this.f24535k, 10);
        lVar.mo34930a(this.f24536l, 11);
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24525a = kVar.mo34915a(this.f24525a, 0, true);
        this.f24526b = kVar.mo34915a(this.f24526b, 1, true);
        this.f24527c = kVar.mo34915a(this.f24527c, 2, true);
        this.f24528d = kVar.mo34907a(3, false);
        this.f24529e = kVar.mo34907a(4, false);
        this.f24530f = (C7252bj) kVar.mo34905a((C7267m) f24522m, 5, false);
        this.f24531g = (Map) kVar.mo34906a(f24523n, 6, false);
        this.f24532h = kVar.mo34904a(this.f24532h, 7, false);
        this.f24533i = kVar.mo34907a(8, false);
        this.f24534j = kVar.mo34907a(9, false);
        this.f24535k = kVar.mo34902a(this.f24535k, 10, false);
        this.f24536l = kVar.mo34902a(this.f24536l, 11, false);
    }

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
        C7262i iVar = new C7262i(sb, i);
        iVar.mo34891a(this.f24525a, "enable");
        iVar.mo34891a(this.f24526b, "enableUserInfo");
        iVar.mo34891a(this.f24527c, "enableQuery");
        iVar.mo34887a(this.f24528d, "url");
        iVar.mo34887a(this.f24529e, "expUrl");
        iVar.mo34885a((C7267m) this.f24530f, "security");
        iVar.mo34889a(this.f24531g, "valueMap");
        iVar.mo34884a(this.f24532h, "strategylastUpdateTime");
        iVar.mo34887a(this.f24533i, "httpsUrl");
        iVar.mo34887a(this.f24534j, "httpsExpUrl");
        iVar.mo34883a(this.f24535k, "eventRecordCount");
        iVar.mo34883a(this.f24536l, "eventTimeInterval");
    }
}
