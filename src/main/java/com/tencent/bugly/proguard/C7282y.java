package com.tencent.bugly.proguard;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.y */
public final class C7282y extends C7267m implements Cloneable {
    /* renamed from: q */
    static C7279v f24648q;
    /* renamed from: r */
    static C7278u f24649r;
    /* renamed from: s */
    static C7278u f24650s;
    /* renamed from: t */
    static Map<String, String> f24651t;
    /* renamed from: u */
    static final /* synthetic */ boolean f24652u = (!C7282y.class.desiredAssertionStatus());
    /* renamed from: a */
    public String f24653a;
    /* renamed from: b */
    public String f24654b;
    /* renamed from: c */
    public long f24655c = 0;
    /* renamed from: d */
    public int f24656d = 0;
    /* renamed from: e */
    public C7279v f24657e = null;
    /* renamed from: f */
    public C7278u f24658f = null;
    /* renamed from: g */
    public byte f24659g = 0;
    /* renamed from: h */
    public int f24660h = 0;
    /* renamed from: i */
    public long f24661i = 0;
    /* renamed from: j */
    public C7278u f24662j = null;
    /* renamed from: k */
    public String f24663k;
    /* renamed from: l */
    public Map<String, String> f24664l;
    /* renamed from: m */
    public String f24665m;
    /* renamed from: n */
    public int f24666n;
    /* renamed from: o */
    public long f24667o;
    /* renamed from: p */
    public int f24668p;

    /* renamed from: a */
    public long mo34981a() {
        return this.f24655c;
    }

    /* renamed from: b */
    public C7278u mo34982b() {
        return this.f24658f;
    }

    public C7282y() {
        String str = "";
        this.f24653a = str;
        this.f24654b = str;
        this.f24663k = str;
        this.f24664l = null;
        this.f24665m = str;
        this.f24666n = 0;
        this.f24667o = 0;
        this.f24668p = 0;
    }

    public C7282y(String str, String str2, long j, int i, C7279v vVar, C7278u uVar, byte b, int i2, long j2, C7278u uVar2, String str3, Map<String, String> map, String str4, int i3, long j3, int i4) {
        String str5 = "";
        this.f24653a = str5;
        this.f24654b = str5;
        this.f24663k = str5;
        this.f24664l = null;
        this.f24665m = str5;
        this.f24666n = 0;
        this.f24667o = 0;
        this.f24668p = 0;
        this.f24653a = str;
        this.f24654b = str2;
        this.f24655c = j;
        this.f24656d = i;
        this.f24657e = vVar;
        this.f24658f = uVar;
        this.f24659g = b;
        this.f24660h = i2;
        this.f24661i = j2;
        this.f24662j = uVar2;
        this.f24663k = str3;
        this.f24664l = map;
        this.f24665m = str4;
        this.f24666n = i3;
        this.f24667o = j3;
        this.f24668p = i4;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7282y yVar = (C7282y) obj;
        if (C7268n.m31403a((Object) this.f24653a, (Object) yVar.f24653a) && C7268n.m31403a((Object) this.f24654b, (Object) yVar.f24654b) && C7268n.m31402a(this.f24655c, yVar.f24655c) && C7268n.m31401a(this.f24656d, yVar.f24656d) && C7268n.m31403a((Object) this.f24657e, (Object) yVar.f24657e) && C7268n.m31403a((Object) this.f24658f, (Object) yVar.f24658f) && C7268n.m31400a(this.f24659g, yVar.f24659g) && C7268n.m31401a(this.f24660h, yVar.f24660h) && C7268n.m31402a(this.f24661i, yVar.f24661i) && C7268n.m31403a((Object) this.f24662j, (Object) yVar.f24662j) && C7268n.m31403a((Object) this.f24663k, (Object) yVar.f24663k) && C7268n.m31403a((Object) this.f24664l, (Object) yVar.f24664l) && C7268n.m31403a((Object) this.f24665m, (Object) yVar.f24665m) && C7268n.m31401a(this.f24666n, yVar.f24666n) && C7268n.m31402a(this.f24667o, yVar.f24667o) && C7268n.m31401a(this.f24668p, yVar.f24668p)) {
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
            if (f24652u) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34934a(this.f24653a, 0);
        lVar.mo34934a(this.f24654b, 1);
        lVar.mo34931a(this.f24655c, 2);
        lVar.mo34930a(this.f24656d, 3);
        lVar.mo34932a((C7267m) this.f24657e, 4);
        lVar.mo34932a((C7267m) this.f24658f, 5);
        lVar.mo34946b(this.f24659g, 6);
        lVar.mo34930a(this.f24660h, 7);
        lVar.mo34931a(this.f24661i, 8);
        C7278u uVar = this.f24662j;
        if (uVar != null) {
            lVar.mo34932a((C7267m) uVar, 9);
        }
        String str = this.f24663k;
        if (str != null) {
            lVar.mo34934a(str, 10);
        }
        Map<String, String> map = this.f24664l;
        if (map != null) {
            lVar.mo34936a(map, 11);
        }
        String str2 = this.f24665m;
        if (str2 != null) {
            lVar.mo34934a(str2, 12);
        }
        lVar.mo34930a(this.f24666n, 13);
        lVar.mo34931a(this.f24667o, 14);
        lVar.mo34930a(this.f24668p, 15);
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24653a = kVar.mo34907a(0, true);
        this.f24654b = kVar.mo34907a(1, true);
        this.f24655c = kVar.mo34904a(this.f24655c, 2, true);
        this.f24656d = kVar.mo34902a(this.f24656d, 3, true);
        if (f24648q == null) {
            f24648q = new C7279v();
        }
        this.f24657e = (C7279v) kVar.mo34905a((C7267m) f24648q, 4, true);
        if (f24649r == null) {
            f24649r = new C7278u();
        }
        this.f24658f = (C7278u) kVar.mo34905a((C7267m) f24649r, 5, true);
        this.f24659g = kVar.mo34899a(this.f24659g, 6, true);
        this.f24660h = kVar.mo34902a(this.f24660h, 7, false);
        this.f24661i = kVar.mo34904a(this.f24661i, 8, false);
        if (f24650s == null) {
            f24650s = new C7278u();
        }
        this.f24662j = (C7278u) kVar.mo34905a((C7267m) f24650s, 9, false);
        this.f24663k = kVar.mo34907a(10, false);
        if (f24651t == null) {
            f24651t = new HashMap();
            String str = "";
            f24651t.put(str, str);
        }
        this.f24664l = (Map) kVar.mo34906a(f24651t, 11, false);
        this.f24665m = kVar.mo34907a(12, false);
        this.f24666n = kVar.mo34902a(this.f24666n, 13, false);
        this.f24667o = kVar.mo34904a(this.f24667o, 14, false);
        this.f24668p = kVar.mo34902a(this.f24668p, 15, false);
    }

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
        C7262i iVar = new C7262i(sb, i);
        iVar.mo34887a(this.f24653a, "title");
        iVar.mo34887a(this.f24654b, "newFeature");
        iVar.mo34884a(this.f24655c, "publishTime");
        iVar.mo34883a(this.f24656d, "publishType");
        iVar.mo34885a((C7267m) this.f24657e, "appBasicInfo");
        iVar.mo34885a((C7267m) this.f24658f, "apkBaseInfo");
        iVar.mo34879a(this.f24659g, "updateStrategy");
        iVar.mo34883a(this.f24660h, "popTimes");
        iVar.mo34884a(this.f24661i, "popInterval");
        iVar.mo34885a((C7267m) this.f24662j, "diffApkInfo");
        iVar.mo34887a(this.f24663k, "netType");
        iVar.mo34889a(this.f24664l, "reserved");
        iVar.mo34887a(this.f24665m, "strategyId");
        iVar.mo34883a(this.f24666n, NotificationCompat.CATEGORY_STATUS);
        iVar.mo34884a(this.f24667o, "updateTime");
        iVar.mo34883a(this.f24668p, "updateType");
    }
}
