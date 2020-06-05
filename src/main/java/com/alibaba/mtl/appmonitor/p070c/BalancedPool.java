package com.alibaba.mtl.appmonitor.p070c;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.c.a */
public class BalancedPool {
    /* renamed from: b */
    private static BalancedPool f3191b = new BalancedPool();
    /* renamed from: a */
    private Map<Class<? extends Reusable>, ReuseItemPool<? extends Reusable>> f3192a = new HashMap();

    /* renamed from: a */
    public static BalancedPool m3491a() {
        return f3191b;
    }

    private BalancedPool() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* renamed from: a */
    public <T extends com.alibaba.mtl.appmonitor.p070c.Reusable> T mo11627a(java.lang.Class<T> r2, java.lang.Object... r3) {
        /*
        r1 = this;
        com.alibaba.mtl.appmonitor.c.c r0 = r1.m3492a(r2)
        com.alibaba.mtl.appmonitor.c.b r0 = r0.mo11629a()
        if (r0 != 0) goto L_0x0015
        java.lang.Object r2 = r2.newInstance()     // Catch:{ Exception -> 0x0011 }
        com.alibaba.mtl.appmonitor.c.b r2 = (com.alibaba.mtl.appmonitor.p070c.Reusable) r2     // Catch:{ Exception -> 0x0011 }
        goto L_0x0016
    L_0x0011:
        r2 = move-exception
        com.alibaba.mtl.appmonitor.p069b.ExceptionEventBuilder.m3405a(r2)
    L_0x0015:
        r2 = r0
    L_0x0016:
        if (r2 == 0) goto L_0x001b
        r2.mo11548a(r3)
    L_0x001b:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.p070c.BalancedPool.mo11627a(java.lang.Class, java.lang.Object[]):com.alibaba.mtl.appmonitor.c.b");
    }

    /* renamed from: a */
    public <T extends Reusable> void mo11628a(T t) {
        if (t != null && !(t instanceof ReuseJSONObject) && !(t instanceof ReuseJSONArray)) {
            m3492a(t.getClass()).mo11630a(t);
        }
    }

    /* renamed from: a */
    private synchronized <T extends Reusable> ReuseItemPool<T> m3492a(Class<T> cls) {
        ReuseItemPool<T> cVar;
        cVar = (ReuseItemPool) this.f3192a.get(cls);
        if (cVar == null) {
            cVar = new ReuseItemPool<>();
            this.f3192a.put(cls, cVar);
        }
        return cVar;
    }
}
