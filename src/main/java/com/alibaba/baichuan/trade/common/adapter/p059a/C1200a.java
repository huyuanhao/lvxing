package com.alibaba.baichuan.trade.common.adapter.p059a;

import com.alibaba.baichuan.trade.common.utils.C1224a;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.a.a */
public class C1200a {
    /* renamed from: a */
    private static C1200a f2484a;
    /* renamed from: b */
    private static C1201b f2485b;
    /* renamed from: c */
    private boolean f2486c;

    private C1200a() {
        f2485b = m2334b() ? new C1203d() : new C1202c();
    }

    /* renamed from: a */
    public static synchronized C1200a m2333a() {
        C1200a aVar;
        synchronized (C1200a.class) {
            if (f2484a == null) {
                f2484a = new C1200a();
            }
            aVar = f2484a;
        }
        return aVar;
    }

    /* renamed from: b */
    private boolean m2334b() {
        try {
            if (Class.forName("com.alibaba.wireless.security.open.b") != null) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            C1224a.m2403a("AlibcSecurityGuard", "no SecurityGuardManager", e);
        }
        return false;
    }

    /* renamed from: a */
    public String mo10848a(String str) {
        return this.f2486c ? f2485b.mo10850a(str) : "";
    }

    /* renamed from: b */
    public String mo10849b(String str) {
        return this.f2486c ? f2485b.mo10851b(str) : "";
    }
}
