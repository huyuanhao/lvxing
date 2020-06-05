package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.z */
public final class C7283z extends C7267m implements Cloneable {
    /* renamed from: e */
    static Map<String, String> f24669e;
    /* renamed from: f */
    static final /* synthetic */ boolean f24670f = (!C7283z.class.desiredAssertionStatus());
    /* renamed from: a */
    public int f24671a = 0;
    /* renamed from: b */
    public String f24672b = "";
    /* renamed from: c */
    public long f24673c = 0;
    /* renamed from: d */
    public Map<String, String> f24674d = null;

    public C7283z() {
    }

    public C7283z(int i, String str, long j, Map<String, String> map) {
        this.f24671a = i;
        this.f24672b = str;
        this.f24673c = j;
        this.f24674d = map;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        C7283z zVar = (C7283z) obj;
        if (C7268n.m31401a(this.f24671a, zVar.f24671a) && C7268n.m31403a((Object) this.f24672b, (Object) zVar.f24672b) && C7268n.m31402a(this.f24673c, zVar.f24673c) && C7268n.m31403a((Object) this.f24674d, (Object) zVar.f24674d)) {
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
            if (f24670f) {
                return null;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34930a(this.f24671a, 0);
        String str = this.f24672b;
        if (str != null) {
            lVar.mo34934a(str, 1);
        }
        lVar.mo34931a(this.f24673c, 2);
        Map<String, String> map = this.f24674d;
        if (map != null) {
            lVar.mo34936a(map, 3);
        }
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24671a = kVar.mo34902a(this.f24671a, 0, false);
        this.f24672b = kVar.mo34907a(1, false);
        this.f24673c = kVar.mo34904a(this.f24673c, 2, false);
        if (f24669e == null) {
            f24669e = new HashMap();
            String str = "";
            f24669e.put(str, str);
        }
        this.f24674d = (Map) kVar.mo34906a(f24669e, 3, false);
    }

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
        C7262i iVar = new C7262i(sb, i);
        iVar.mo34883a(this.f24671a, "flag");
        iVar.mo34887a(this.f24672b, "localStrategyId");
        iVar.mo34884a(this.f24673c, "localStrategyTime");
        iVar.mo34889a(this.f24674d, "reserved");
    }
}
