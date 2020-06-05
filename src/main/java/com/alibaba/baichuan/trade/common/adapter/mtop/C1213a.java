package com.alibaba.baichuan.trade.common.adapter.mtop;

import com.alibaba.baichuan.trade.common.adapter.mtop.C1221d.C1222a;
import com.alibaba.baichuan.trade.common.adapter.mtop.p063a.C1216a;
import com.alibaba.baichuan.trade.common.adapter.mtop.p063a.C1217b;
import com.alibaba.baichuan.trade.common.utils.C1224a;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.mtop.a */
public class C1213a implements C1221d {
    /* renamed from: a */
    private C1219b f2502a;
    /* renamed from: b */
    private boolean f2503b;

    /* renamed from: com.alibaba.baichuan.trade.common.adapter.mtop.a$a */
    private static class C1215a {
        /* renamed from: a */
        public static C1213a f2504a = new C1213a();
    }

    private C1213a() {
        this.f2502a = m2378b() ? new C1217b() : new C1216a();
    }

    /* renamed from: a */
    public static C1213a m2377a() {
        return C1215a.f2504a;
    }

    /* renamed from: b */
    private boolean m2378b() {
        try {
            if (Class.forName("mtopsdk.mtop.b.a") != null) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            C1224a.m2403a("AlibcMtop", "no mtop", e);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo10876a(C1222a aVar, NetworkRequest networkRequest) {
        if (this.f2503b) {
            return this.f2502a.mo10876a(aVar, networkRequest);
        }
        return false;
    }
}
