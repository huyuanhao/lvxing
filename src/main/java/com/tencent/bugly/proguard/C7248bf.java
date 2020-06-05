package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bf */
public final class C7248bf extends C7267m {
    /* renamed from: A */
    static ArrayList<C7247be> f24453A = new ArrayList<>();
    /* renamed from: B */
    static Map<String, String> f24454B = new HashMap();
    /* renamed from: C */
    static Map<String, String> f24455C = new HashMap();
    /* renamed from: v */
    static Map<String, String> f24456v = new HashMap();
    /* renamed from: w */
    static C7246bd f24457w = new C7246bd();
    /* renamed from: x */
    static C7245bc f24458x = new C7245bc();
    /* renamed from: y */
    static ArrayList<C7245bc> f24459y = new ArrayList<>();
    /* renamed from: z */
    static ArrayList<C7245bc> f24460z = new ArrayList<>();
    /* renamed from: a */
    public String f24461a;
    /* renamed from: b */
    public long f24462b = 0;
    /* renamed from: c */
    public String f24463c;
    /* renamed from: d */
    public String f24464d;
    /* renamed from: e */
    public String f24465e;
    /* renamed from: f */
    public String f24466f;
    /* renamed from: g */
    public String f24467g;
    /* renamed from: h */
    public Map<String, String> f24468h;
    /* renamed from: i */
    public String f24469i;
    /* renamed from: j */
    public C7246bd f24470j;
    /* renamed from: k */
    public int f24471k;
    /* renamed from: l */
    public String f24472l;
    /* renamed from: m */
    public String f24473m;
    /* renamed from: n */
    public C7245bc f24474n;
    /* renamed from: o */
    public ArrayList<C7245bc> f24475o;
    /* renamed from: p */
    public ArrayList<C7245bc> f24476p;
    /* renamed from: q */
    public ArrayList<C7247be> f24477q;
    /* renamed from: r */
    public Map<String, String> f24478r;
    /* renamed from: s */
    public Map<String, String> f24479s;
    /* renamed from: t */
    public String f24480t;
    /* renamed from: u */
    public boolean f24481u;

    public C7248bf() {
        String str = "";
        this.f24461a = str;
        this.f24463c = str;
        this.f24464d = str;
        this.f24465e = str;
        this.f24466f = str;
        this.f24467g = str;
        this.f24468h = null;
        this.f24469i = str;
        this.f24470j = null;
        this.f24471k = 0;
        this.f24472l = str;
        this.f24473m = str;
        this.f24474n = null;
        this.f24475o = null;
        this.f24476p = null;
        this.f24477q = null;
        this.f24478r = null;
        this.f24479s = null;
        this.f24480t = str;
        this.f24481u = true;
    }

    /* renamed from: a */
    public void mo34761a(C7266l lVar) {
        lVar.mo34934a(this.f24461a, 0);
        lVar.mo34931a(this.f24462b, 1);
        lVar.mo34934a(this.f24463c, 2);
        String str = this.f24464d;
        if (str != null) {
            lVar.mo34934a(str, 3);
        }
        String str2 = this.f24465e;
        if (str2 != null) {
            lVar.mo34934a(str2, 4);
        }
        String str3 = this.f24466f;
        if (str3 != null) {
            lVar.mo34934a(str3, 5);
        }
        String str4 = this.f24467g;
        if (str4 != null) {
            lVar.mo34934a(str4, 6);
        }
        Map<String, String> map = this.f24468h;
        if (map != null) {
            lVar.mo34936a(map, 7);
        }
        String str5 = this.f24469i;
        if (str5 != null) {
            lVar.mo34934a(str5, 8);
        }
        C7246bd bdVar = this.f24470j;
        if (bdVar != null) {
            lVar.mo34932a((C7267m) bdVar, 9);
        }
        lVar.mo34930a(this.f24471k, 10);
        String str6 = this.f24472l;
        if (str6 != null) {
            lVar.mo34934a(str6, 11);
        }
        String str7 = this.f24473m;
        if (str7 != null) {
            lVar.mo34934a(str7, 12);
        }
        C7245bc bcVar = this.f24474n;
        if (bcVar != null) {
            lVar.mo34932a((C7267m) bcVar, 13);
        }
        ArrayList<C7245bc> arrayList = this.f24475o;
        if (arrayList != null) {
            lVar.mo34935a((Collection<T>) arrayList, 14);
        }
        ArrayList<C7245bc> arrayList2 = this.f24476p;
        if (arrayList2 != null) {
            lVar.mo34935a((Collection<T>) arrayList2, 15);
        }
        ArrayList<C7247be> arrayList3 = this.f24477q;
        if (arrayList3 != null) {
            lVar.mo34935a((Collection<T>) arrayList3, 16);
        }
        Map<String, String> map2 = this.f24478r;
        if (map2 != null) {
            lVar.mo34936a(map2, 17);
        }
        Map<String, String> map3 = this.f24479s;
        if (map3 != null) {
            lVar.mo34936a(map3, 18);
        }
        String str8 = this.f24480t;
        if (str8 != null) {
            lVar.mo34934a(str8, 19);
        }
        lVar.mo34938a(this.f24481u, 20);
    }

    static {
        String str = "";
        f24456v.put(str, str);
        f24459y.add(new C7245bc());
        f24460z.add(new C7245bc());
        f24453A.add(new C7247be());
        f24454B.put(str, str);
        f24455C.put(str, str);
    }

    /* renamed from: a */
    public void mo34760a(C7264k kVar) {
        this.f24461a = kVar.mo34907a(0, true);
        this.f24462b = kVar.mo34904a(this.f24462b, 1, true);
        this.f24463c = kVar.mo34907a(2, true);
        this.f24464d = kVar.mo34907a(3, false);
        this.f24465e = kVar.mo34907a(4, false);
        this.f24466f = kVar.mo34907a(5, false);
        this.f24467g = kVar.mo34907a(6, false);
        this.f24468h = (Map) kVar.mo34906a(f24456v, 7, false);
        this.f24469i = kVar.mo34907a(8, false);
        this.f24470j = (C7246bd) kVar.mo34905a((C7267m) f24457w, 9, false);
        this.f24471k = kVar.mo34902a(this.f24471k, 10, false);
        this.f24472l = kVar.mo34907a(11, false);
        this.f24473m = kVar.mo34907a(12, false);
        this.f24474n = (C7245bc) kVar.mo34905a((C7267m) f24458x, 13, false);
        this.f24475o = (ArrayList) kVar.mo34906a(f24459y, 14, false);
        this.f24476p = (ArrayList) kVar.mo34906a(f24460z, 15, false);
        this.f24477q = (ArrayList) kVar.mo34906a(f24453A, 16, false);
        this.f24478r = (Map) kVar.mo34906a(f24454B, 17, false);
        this.f24479s = (Map) kVar.mo34906a(f24455C, 18, false);
        this.f24480t = kVar.mo34907a(19, false);
        this.f24481u = kVar.mo34915a(this.f24481u, 20, false);
    }
}
