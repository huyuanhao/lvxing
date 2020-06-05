package com.alibaba.baichuan.trade.common.adapter.p060b.p062b;

import com.alibaba.baichuan.trade.common.adapter.p060b.C1204a;
import com.alibaba.baichuan.trade.common.adapter.p060b.p061a.C1205a;
import java.util.Map;

/* renamed from: com.alibaba.baichuan.trade.common.adapter.b.b.a */
public class C1208a extends C1204a {
    /* renamed from: a */
    public static C1210c f2497a = new C1210c();

    /* renamed from: a */
    public void mo10852a(String str, String str2, long j, Map<String, String> map) {
        C1205a a = C1205a.m2348a();
        C1210c cVar = f2497a;
        a.mo10860a(cVar == null ? "" : cVar.mo10870a(str)).mo10863b("mini").mo10859a(j).mo10862b().mo10864c(str2).mo10861a(map).mo10865c();
    }

    /* renamed from: a */
    public void mo10856a(String str, String str2, Map<String, String> map) {
        mo10852a(str, str2, 60, map);
    }

    /* renamed from: a */
    public boolean mo10857a() {
        return true;
    }
}
