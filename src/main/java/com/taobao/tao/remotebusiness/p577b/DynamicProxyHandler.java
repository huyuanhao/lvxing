package com.taobao.tao.remotebusiness.p577b;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.InvocationHandler;
import mtopsdk.mtop.common.MtopListener;

/* renamed from: com.taobao.tao.remotebusiness.b.a */
final class DynamicProxyHandler implements InvocationHandler {
    /* renamed from: a */
    private MtopFinishListenerImpl f22568a;
    /* renamed from: b */
    private MtopProgressListenerImpl f22569b;
    /* renamed from: c */
    private MtopCacheListenerImpl f22570c;
    /* renamed from: d */
    private MtopBusiness f22571d;
    /* renamed from: e */
    private MtopListener f22572e;

    public DynamicProxyHandler(MtopBusiness fVar, MtopListener gVar) {
        this.f22568a = new MtopFinishListenerImpl(fVar, gVar);
        this.f22571d = fVar;
        this.f22572e = gVar;
    }

    public final java.lang.Object invoke(java.lang.Object r5, java.lang.reflect.Method r6, java.lang.Object[] r7) throws java.lang.Throwable {
        /*
        r4 = this;
        java.lang.String r5 = r6.getName()
        int r0 = r5.hashCode()
        r1 = 3
        r2 = 2
        r3 = 1
        switch(r0) {
            case -1809154262: goto L_0x002d;
            case 1030363105: goto L_0x0023;
            case 1177139532: goto L_0x0019;
            case 2096292721: goto L_0x000f;
            default: goto L_0x000e;
        }
    L_0x000e:
        goto L_0x0037
    L_0x000f:
        java.lang.String r0 = "onFinished"
        boolean r5 = r5.equals(r0)
        if (r5 == 0) goto L_0x0037
        r5 = 0
        goto L_0x0038
    L_0x0019:
        java.lang.String r0 = "onHeader"
        boolean r5 = r5.equals(r0)
        if (r5 == 0) goto L_0x0037
        r5 = 2
        goto L_0x0038
    L_0x0023:
        java.lang.String r0 = "onCached"
        boolean r5 = r5.equals(r0)
        if (r5 == 0) goto L_0x0037
        r5 = 3
        goto L_0x0038
    L_0x002d:
        java.lang.String r0 = "onDataReceived"
        boolean r5 = r5.equals(r0)
        if (r5 == 0) goto L_0x0037
        r5 = 1
        goto L_0x0038
    L_0x0037:
        r5 = -1
    L_0x0038:
        if (r5 == 0) goto L_0x006e
        if (r5 == r3) goto L_0x0058
        if (r5 == r2) goto L_0x0058
        if (r5 == r1) goto L_0x0042
        r5 = 0
        return r5
    L_0x0042:
        com.taobao.tao.remotebusiness.b.c r5 = r4.f22570c
        if (r5 != 0) goto L_0x0051
        com.taobao.tao.remotebusiness.b.c r5 = new com.taobao.tao.remotebusiness.b.c
        com.taobao.tao.remotebusiness.f r0 = r4.f22571d
        mtopsdk.mtop.common.g r1 = r4.f22572e
        r5.m51761init(r0, r1)
        r4.f22570c = r5
    L_0x0051:
        com.taobao.tao.remotebusiness.b.c r5 = r4.f22570c
        java.lang.Object r5 = r6.invoke(r5, r7)
        return r5
    L_0x0058:
        com.taobao.tao.remotebusiness.b.f r5 = r4.f22569b
        if (r5 != 0) goto L_0x0067
        com.taobao.tao.remotebusiness.b.f r5 = new com.taobao.tao.remotebusiness.b.f
        com.taobao.tao.remotebusiness.f r0 = r4.f22571d
        mtopsdk.mtop.common.g r1 = r4.f22572e
        r5.m51764init(r0, r1)
        r4.f22569b = r5
    L_0x0067:
        com.taobao.tao.remotebusiness.b.f r5 = r4.f22569b
        java.lang.Object r5 = r6.invoke(r5, r7)
        return r5
    L_0x006e:
        com.taobao.tao.remotebusiness.b.d r5 = r4.f22568a
        java.lang.Object r5 = r6.invoke(r5, r7)
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.p577b.DynamicProxyHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }
}
