package com.p368pw.inner.p369a.p379e;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.pw.inner.a.e.f */
public class C4941f {
    /* renamed from: a */
    private static final Map<Integer, C4933e> f15996a = new ConcurrentHashMap();

    /* renamed from: a */
    public static C4933e m20536a(int i) {
        return (C4933e) f15996a.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public static void m20537a(int i, C4933e eVar) {
        f15996a.put(Integer.valueOf(i), eVar);
    }

    /* renamed from: b */
    public static void m20538b(int i) {
        C4933e eVar = (C4933e) f15996a.remove(Integer.valueOf(i));
        if (eVar != null) {
            eVar.mo26153g();
        }
    }
}
