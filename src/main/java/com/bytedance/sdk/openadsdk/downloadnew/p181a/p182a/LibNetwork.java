package com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a;

import android.content.Context;
import com.p530ss.android.p531a.p532a.p533a.DownloadNetworkFactory;
import java.lang.ref.WeakReference;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.a.c */
public class LibNetwork implements DownloadNetworkFactory {
    /* renamed from: a */
    private final WeakReference<Context> f8529a;

    public LibNetwork(Context context) {
        this.f8529a = new WeakReference<>(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public void mo16479a(java.lang.String r11, java.lang.String r12, java.util.Map<java.lang.String, java.lang.Object> r13, com.p530ss.android.p531a.p532a.p533a.IHttpCallback r14) {
        /*
        r10 = this;
        int r0 = r11.hashCode()
        r1 = 70454(0x11336, float:9.8727E-41)
        r2 = 0
        r3 = 1
        if (r0 == r1) goto L_0x001b
        r1 = 2461856(0x2590a0, float:3.449795E-39)
        if (r0 == r1) goto L_0x0011
        goto L_0x0025
    L_0x0011:
        java.lang.String r0 = "POST"
        boolean r11 = r11.equals(r0)
        if (r11 == 0) goto L_0x0025
        r11 = 1
        goto L_0x0026
    L_0x001b:
        java.lang.String r0 = "GET"
        boolean r11 = r11.equals(r0)
        if (r11 == 0) goto L_0x0025
        r11 = 0
        goto L_0x0026
    L_0x0025:
        r11 = -1
    L_0x0026:
        if (r11 == 0) goto L_0x002a
        if (r11 == r3) goto L_0x002c
    L_0x002a:
        r6 = 0
        goto L_0x002d
    L_0x002c:
        r6 = 1
    L_0x002d:
        com.bytedance.sdk.adnet.b.i r11 = com.bytedance.sdk.adnet.p159b.RequestFuture.m7746a()
        com.bytedance.sdk.openadsdk.downloadnew.a.a.c$1 r0 = new com.bytedance.sdk.openadsdk.downloadnew.a.a.c$1
        r4 = r0
        r5 = r10
        r7 = r12
        r8 = r11
        r9 = r13
        r4.m43973init(r6, r7, r8, r9)
        android.content.Context r12 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()
        com.bytedance.sdk.openadsdk.g.e r12 = com.bytedance.sdk.openadsdk.p188g.TTNetClient.m11428a(r12)
        com.bytedance.sdk.adnet.core.o r12 = r12.mo16657d()
        r0.build(r12)
        r12 = 0
        com.bytedance.sdk.adnet.core.p r11 = r11.get()     // Catch:{ all -> 0x0050 }
        goto L_0x0051
    L_0x0050:
        r11 = r12
    L_0x0051:
        if (r11 == 0) goto L_0x0063
        boolean r13 = r11.mo14373a()
        if (r13 == 0) goto L_0x0063
        if (r14 == 0) goto L_0x0095
        T r11 = r11.f6293a
        java.lang.String r11 = (java.lang.String) r11
        r14.mo31039a(r11)
        goto L_0x0095
    L_0x0063:
        if (r11 == 0) goto L_0x006a
        com.bytedance.sdk.adnet.err.VAdError r13 = r11.f6295c
        if (r13 == 0) goto L_0x006a
        r2 = 1
    L_0x006a:
        if (r2 == 0) goto L_0x0072
        com.bytedance.sdk.adnet.err.VAdError r12 = r11.f6295c
        java.lang.String r12 = r12.getMessage()
    L_0x0072:
        boolean r12 = android.text.TextUtils.isEmpty(r12)
        r12 = r12 ^ r3
        if (r14 == 0) goto L_0x0095
        if (r12 == 0) goto L_0x0082
        com.bytedance.sdk.adnet.err.VAdError r11 = r11.f6295c
        java.lang.String r11 = r11.getMessage()
        goto L_0x008d
    L_0x0082:
        if (r11 == 0) goto L_0x008b
        long r11 = r11.f6300h
        java.lang.String r11 = java.lang.String.valueOf(r11)
        goto L_0x008d
    L_0x008b:
        java.lang.String r11 = ""
    L_0x008d:
        java.lang.Exception r12 = new java.lang.Exception
        r12.<init>(r11)
        r14.mo31040a(r12)
    L_0x0095:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.p181a.p182a.LibNetwork.mo16479a(java.lang.String, java.lang.String, java.util.Map, com.ss.android.a.a.a.m):void");
    }
}
