package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bm */
public final class C7255bm extends C7267m implements Cloneable {
    /* renamed from: f */
    static ArrayList<C7254bl> f24546f;
    /* renamed from: g */
    static Map<String, String> f24547g;
    /* renamed from: a */
    public byte f24548a = 0;
    /* renamed from: b */
    public String f24549b;
    /* renamed from: c */
    public String f24550c;
    /* renamed from: d */
    public ArrayList<C7254bl> f24551d;
    /* renamed from: e */
    public Map<String, String> f24552e;

    /* renamed from: a */
    public void mo34762a(StringBuilder sb, int i) {
    }

    public C7255bm() {
        String str = "";
        this.f24549b = str;
        this.f24550c = str;
        this.f24551d = null;
        this.f24552e = null;
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34946b(this.f24548a, 0);
        String str = this.f24549b;
        if (str != null) {
            lVar.mo34934a(str, 1);
        }
        String str2 = this.f24550c;
        if (str2 != null) {
            lVar.mo34934a(str2, 2);
        }
        ArrayList<C7254bl> arrayList = this.f24551d;
        if (arrayList != null) {
            lVar.mo34935a((Collection<T>) arrayList, 3);
        }
        Map<String, String> map = this.f24552e;
        if (map != null) {
            lVar.mo34936a(map, 4);
        }
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24548a = kVar.mo34899a(this.f24548a, 0, true);
        this.f24549b = kVar.mo34907a(1, false);
        this.f24550c = kVar.mo34907a(2, false);
        if (f24546f == null) {
            f24546f = new ArrayList<>();
            f24546f.add(new C7254bl());
        }
        this.f24551d = (ArrayList) kVar.mo34906a(f24546f, 3, false);
        if (f24547g == null) {
            f24547g = new HashMap();
            String str = "";
            f24547g.put(str, str);
        }
        this.f24552e = (Map) kVar.mo34906a(f24547g, 4, false);
    }
}
