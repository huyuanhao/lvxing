package com.alibaba.baichuan.trade.common.adapter.p060b;

import com.alibaba.baichuan.trade.common.adapter.p060b.p062b.C1208a;
import com.alibaba.baichuan.trade.common.adapter.p060b.p062b.C1209b;
import com.alibaba.baichuan.trade.common.utils.C1224a;
import java.util.Map;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.b.b */
public class C1207b {
    /* renamed from: a */
    private static C1207b f2494a;
    /* renamed from: b */
    private boolean f2495b;
    /* renamed from: c */
    private C1204a f2496c;

    private C1207b() {
        if (m2358b()) {
            this.f2496c = new C1209b();
            return;
        }
        this.f2496c = new C1208a();
        this.f2495b = this.f2496c.mo10857a();
    }

    /* renamed from: a */
    public static synchronized C1207b m2357a() {
        C1207b bVar;
        synchronized (C1207b.class) {
            if (f2494a == null) {
                f2494a = new C1207b();
            }
            bVar = f2494a;
        }
        return bVar;
    }

    /* renamed from: b */
    private boolean m2358b() {
        try {
            if (Class.forName("com.alibaba.mtl.appmonitor.a") != null) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            C1224a.m2403a("AlibcUserTracker", "no appmonitor", e);
        }
        return false;
    }

    /* renamed from: a */
    public void mo10867a(String str, String str2, String str3) {
        if (this.f2495b) {
            this.f2496c.mo10853a(str, str2, str3);
        }
    }

    /* renamed from: a */
    public void mo10868a(String str, String str2, String str3, String str4, String str5) {
        if (this.f2495b) {
            this.f2496c.mo10855a(str, str2, str3, str4, str5);
        }
    }

    /* renamed from: a */
    public void mo10869a(String str, String str2, Map<String, String> map) {
        if (this.f2495b) {
            this.f2496c.mo10856a(str, str2, map);
        }
    }
}
