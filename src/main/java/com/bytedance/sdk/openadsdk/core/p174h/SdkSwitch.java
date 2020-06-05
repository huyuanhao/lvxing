package com.bytedance.sdk.openadsdk.core.p174h;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.j */
public class SdkSwitch {
    /* renamed from: a */
    private static AtomicInteger f7649a = new AtomicInteger(1);

    /* renamed from: a */
    public static boolean m9757a() {
        return f7649a.get() == 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021  */
    /* renamed from: a */
    protected static void m9756a(int r3) {
        /*
        r0 = 1
        if (r3 == r0) goto L_0x0007
        r1 = 2
        if (r3 == r1) goto L_0x0007
        return
    L_0x0007:
        r1 = 0
        java.util.concurrent.atomic.AtomicInteger r2 = f7649a     // Catch:{ all -> 0x001a }
        int r2 = r2.get()     // Catch:{ all -> 0x001a }
        if (r2 == r3) goto L_0x0018
        java.util.concurrent.atomic.AtomicInteger r1 = f7649a     // Catch:{ all -> 0x0016 }
        r1.set(r3)     // Catch:{ all -> 0x0016 }
        goto L_0x001f
    L_0x0016:
        r3 = move-exception
        goto L_0x001c
    L_0x0018:
        r0 = 0
        goto L_0x001f
    L_0x001a:
        r3 = move-exception
        r0 = 0
    L_0x001c:
        r3.printStackTrace()
    L_0x001f:
        if (r0 == 0) goto L_0x0095
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r0 = "switch status changed: "
        r3.append(r0)
        boolean r0 = m9757a()
        r3.append(r0)
        java.lang.String r3 = r3.toString()
        java.lang.String r0 = "SdkSwitch"
        android.util.Log.e(r0, r3)
        boolean r3 = m9757a()
        if (r3 == 0) goto L_0x0045
        com.bytedance.sdk.openadsdk.core.InternalContainer.m10063b()
        goto L_0x0095
    L_0x0045:
        com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10064c()     // Catch:{ all -> 0x006d }
        if (r3 == 0) goto L_0x0052
        com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10064c()     // Catch:{ all -> 0x006d }
        r3.mo14999b()     // Catch:{ all -> 0x006d }
    L_0x0052:
        com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10066e()     // Catch:{ all -> 0x006d }
        if (r3 == 0) goto L_0x005f
        com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10066e()     // Catch:{ all -> 0x006d }
        r3.mo14999b()     // Catch:{ all -> 0x006d }
    L_0x005f:
        com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10065d()     // Catch:{ all -> 0x006d }
        if (r3 == 0) goto L_0x0071
        com.bytedance.sdk.openadsdk.c.b r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10065d()     // Catch:{ all -> 0x006d }
        r3.mo14999b()     // Catch:{ all -> 0x006d }
        goto L_0x0071
    L_0x006d:
        r3 = move-exception
        r3.printStackTrace()
    L_0x0071:
        com.bytedance.sdk.openadsdk.j.a r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10068g()     // Catch:{ all -> 0x007f }
        if (r3 == 0) goto L_0x0083
        com.bytedance.sdk.openadsdk.j.a r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10068g()     // Catch:{ all -> 0x007f }
        r3.mo16822a()     // Catch:{ all -> 0x007f }
        goto L_0x0083
    L_0x007f:
        r3 = move-exception
        r3.printStackTrace()
    L_0x0083:
        com.bytedance.sdk.openadsdk.f.b.a r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10071j()     // Catch:{ all -> 0x0091 }
        if (r3 == 0) goto L_0x0095
        com.bytedance.sdk.openadsdk.f.b.a r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10071j()     // Catch:{ all -> 0x0091 }
        r3.mo16618b()     // Catch:{ all -> 0x0091 }
        goto L_0x0095
    L_0x0091:
        r3 = move-exception
        r3.printStackTrace()
    L_0x0095:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.p174h.SdkSwitch.m9756a(int):void");
    }
}
