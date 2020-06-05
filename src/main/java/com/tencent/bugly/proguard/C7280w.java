package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.w */
public final class C7280w extends C7267m implements Cloneable {
    /* renamed from: i */
    static C7279v f24634i;
    /* renamed from: j */
    static Map<String, String> f24635j;
    /* renamed from: k */
    static final /* synthetic */ boolean f24636k = (!C7280w.class.desiredAssertionStatus());
    /* renamed from: a */
    public String f24637a;
    /* renamed from: b */
    public long f24638b = 0;
    /* renamed from: c */
    public byte f24639c = 0;
    /* renamed from: d */
    public long f24640d = 0;
    /* renamed from: e */
    public C7279v f24641e = null;
    /* renamed from: f */
    public String f24642f;
    /* renamed from: g */
    public int f24643g;
    /* renamed from: h */
    public Map<String, String> f24644h;

    public C7280w() {
        String str = "";
        this.f24637a = str;
        this.f24642f = str;
        this.f24643g = 0;
        this.f24644h = null;
    }

    public C7280w(String str, long j, byte b, long j2, C7279v vVar, String str2, int i, Map<String, String> map) {
        String str3 = "";
        this.f24637a = str3;
        this.f24642f = str3;
        this.f24643g = 0;
        this.f24644h = null;
        this.f24637a = str;
        this.f24638b = j;
        this.f24639c = b;
        this.f24640d = j2;
        this.f24641e = vVar;
        this.f24642f = str2;
        this.f24643g = i;
        this.f24644h = map;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7280w wVar = (C7280w) obj;
        if (C7268n.m31403a((Object) this.f24637a, (Object) wVar.f24637a) && C7268n.m31402a(this.f24638b, wVar.f24638b) && C7268n.m31400a(this.f24639c, wVar.f24639c) && C7268n.m31402a(this.f24640d, wVar.f24640d) && C7268n.m31403a((Object) this.f24641e, (Object) wVar.f24641e) && C7268n.m31403a((Object) this.f24642f, (Object) wVar.f24642f) && C7268n.m31401a(this.f24643g, wVar.f24643g) && C7268n.m31403a((Object) this.f24644h, (Object) wVar.f24644h)) {
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
            if (f24636k) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34934a(this.f24637a, 0);
        lVar.mo34931a(this.f24638b, 1);
        lVar.mo34946b(this.f24639c, 2);
        lVar.mo34931a(this.f24640d, 3);
        C7279v vVar = this.f24641e;
        if (vVar != null) {
            lVar.mo34932a((C7267m) vVar, 4);
        }
        String str = this.f24642f;
        if (str != null) {
            lVar.mo34934a(str, 5);
        }
        lVar.mo34930a(this.f24643g, 6);
        Map<String, String> map = this.f24644h;
        if (map != null) {
            lVar.mo34936a(map, 7);
        }
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24637a = kVar.mo34907a(0, true);
        this.f24638b = kVar.mo34904a(this.f24638b, 1, true);
        this.f24639c = kVar.mo34899a(this.f24639c, 2, true);
        this.f24640d = kVar.mo34904a(this.f24640d, 3, false);
        if (f24634i == null) {
            f24634i = new C7279v();
        }
        this.f24641e = (C7279v) kVar.mo34905a((C7267m) f24634i, 4, false);
        this.f24642f = kVar.mo34907a(5, false);
        this.f24643g = kVar.mo34902a(this.f24643g, 6, false);
        if (f24635j == null) {
            f24635j = new HashMap();
            String str = "";
            f24635j.put(str, str);
        }
        this.f24644h = (Map) kVar.mo34906a(f24635j, 7, false);
    }

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
        C7262i iVar = new C7262i(sb, i);
        iVar.mo34887a(this.f24637a, "eventType");
        iVar.mo34884a(this.f24638b, "eventTime");
        iVar.mo34879a(this.f24639c, "eventResult");
        iVar.mo34884a(this.f24640d, "eventElapse");
        iVar.mo34885a((C7267m) this.f24641e, "destAppInfo");
        iVar.mo34887a(this.f24642f, "strategyId");
        iVar.mo34883a(this.f24643g, "updateType");
        iVar.mo34889a(this.f24644h, "reserved");
    }
}
