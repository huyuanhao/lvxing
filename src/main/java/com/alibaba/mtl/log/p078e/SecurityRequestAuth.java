package com.alibaba.mtl.log.p078e;

import com.alibaba.mtl.log.p077d.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: com.alibaba.mtl.log.e.c */
public class SecurityRequestAuth implements IRequestAuth {
    /* renamed from: a */
    private String f3437a = null;
    /* renamed from: b */
    private String f3438b;
    /* renamed from: c */
    private Object f3439c = null;
    /* renamed from: d */
    private Object f3440d = null;
    /* renamed from: e */
    private Class f3441e = null;
    /* renamed from: f */
    private Field f3442f = null;
    /* renamed from: g */
    private Field f3443g = null;
    /* renamed from: h */
    private Field f3444h = null;
    /* renamed from: i */
    private Method f3445i = null;
    /* renamed from: j */
    private int f3446j = 1;
    /* renamed from: k */
    private boolean f3447k = false;

    /* renamed from: a */
    public String mo11826a() {
        return this.f3437a;
    }

    public SecurityRequestAuth(String str, String str2) {
        this.f3437a = str;
        this.f3438b = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* renamed from: b */
    private synchronized void m3886b() {
        /*
        r7 = this;
        monitor-enter(r7)
        boolean r0 = r7.f3447k     // Catch:{ all -> 0x00d5 }
        if (r0 == 0) goto L_0x0007
        monitor-exit(r7)
        return
    L_0x0007:
        r0 = 0
        r1 = 1
        r2 = 0
        java.lang.String r3 = "com.alibaba.wireless.security.open.b"
        java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x003f }
        java.lang.String r4 = "getInstance"
        java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ all -> 0x003d }
        java.lang.Class<android.content.Context> r6 = android.content.Context.class
        r5[r2] = r6     // Catch:{ all -> 0x003d }
        java.lang.reflect.Method r4 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x003d }
        java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x003d }
        android.content.Context r6 = com.alibaba.mtl.log.UTDC.m3697c()     // Catch:{ all -> 0x003d }
        r5[r2] = r6     // Catch:{ all -> 0x003d }
        java.lang.Object r4 = r4.invoke(r0, r5)     // Catch:{ all -> 0x003d }
        r7.f3439c = r4     // Catch:{ all -> 0x003d }
        java.lang.String r4 = "getSecureSignatureComp"
        java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ all -> 0x003d }
        java.lang.reflect.Method r4 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x003d }
        java.lang.Object r5 = r7.f3439c     // Catch:{ all -> 0x003d }
        java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x003d }
        java.lang.Object r4 = r4.invoke(r5, r6)     // Catch:{ all -> 0x003d }
        r7.f3440d = r4     // Catch:{ all -> 0x003d }
        goto L_0x0048
    L_0x003d:
        r4 = move-exception
        goto L_0x0041
    L_0x003f:
        r4 = move-exception
        r3 = r0
    L_0x0041:
        java.lang.String r5 = "SecurityRequestAuth"
        java.lang.String r6 = "initSecurityCheck"
        com.alibaba.mtl.log.p077d.Logger.m3832a(r5, r6, r4)     // Catch:{ all -> 0x00d5 }
    L_0x0048:
        if (r3 == 0) goto L_0x00d1
        java.lang.String r4 = "com.alibaba.wireless.security.open.c"
        java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ all -> 0x00c9 }
        r7.f3441e = r4     // Catch:{ all -> 0x00c9 }
        java.lang.Class r4 = r7.f3441e     // Catch:{ all -> 0x00c9 }
        java.lang.String r5 = "appKey"
        java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ all -> 0x00c9 }
        r7.f3442f = r4     // Catch:{ all -> 0x00c9 }
        java.lang.Class r4 = r7.f3441e     // Catch:{ all -> 0x00c9 }
        java.lang.String r5 = "paramMap"
        java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ all -> 0x00c9 }
        r7.f3443g = r4     // Catch:{ all -> 0x00c9 }
        java.lang.Class r4 = r7.f3441e     // Catch:{ all -> 0x00c9 }
        java.lang.String r5 = "requestType"
        java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ all -> 0x00c9 }
        r7.f3444h = r4     // Catch:{ all -> 0x00c9 }
        java.lang.String r4 = "isOpen"
        java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ all -> 0x0079 }
        java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x0079 }
        goto L_0x0082
    L_0x0079:
        r3 = move-exception
        java.lang.String r4 = "SecurityRequestAuth"
        java.lang.String r5 = "initSecurityCheck"
        com.alibaba.mtl.log.p077d.Logger.m3832a(r4, r5, r3)     // Catch:{ all -> 0x00c9 }
        r3 = r0
    L_0x0082:
        if (r3 == 0) goto L_0x0093
        java.lang.Object r0 = r7.f3439c     // Catch:{ all -> 0x00c9 }
        java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x00c9 }
        java.lang.Object r0 = r3.invoke(r0, r4)     // Catch:{ all -> 0x00c9 }
        java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00c9 }
        boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00c9 }
        goto L_0x00a7
    L_0x0093:
        java.lang.String r3 = "com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent"
        java.lang.Class r0 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x009a }
        goto L_0x00a2
    L_0x009a:
        r3 = move-exception
        java.lang.String r4 = "SecurityRequestAuth"
        java.lang.String r5 = "initSecurityCheck"
        com.alibaba.mtl.log.p077d.Logger.m3832a(r4, r5, r3)     // Catch:{ all -> 0x00c9 }
    L_0x00a2:
        if (r0 != 0) goto L_0x00a6
        r0 = 1
        goto L_0x00a7
    L_0x00a6:
        r0 = 0
    L_0x00a7:
        if (r0 == 0) goto L_0x00ab
        r0 = 1
        goto L_0x00ad
    L_0x00ab:
        r0 = 12
    L_0x00ad:
        r7.f3446j = r0     // Catch:{ all -> 0x00c9 }
        java.lang.String r0 = "com.alibaba.wireless.security.open.k.a"
        java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x00c9 }
        java.lang.String r3 = "signRequest"
        r4 = 2
        java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ all -> 0x00c9 }
        java.lang.Class r5 = r7.f3441e     // Catch:{ all -> 0x00c9 }
        r4[r2] = r5     // Catch:{ all -> 0x00c9 }
        java.lang.Class<java.lang.String> r2 = java.lang.String.class
        r4[r1] = r2     // Catch:{ all -> 0x00c9 }
        java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch:{ all -> 0x00c9 }
        r7.f3445i = r0     // Catch:{ all -> 0x00c9 }
        goto L_0x00d1
    L_0x00c9:
        r0 = move-exception
        java.lang.String r2 = "SecurityRequestAuth"
        java.lang.String r3 = "initSecurityCheck"
        com.alibaba.mtl.log.p077d.Logger.m3832a(r2, r3, r0)     // Catch:{ all -> 0x00d5 }
    L_0x00d1:
        r7.f3447k = r1     // Catch:{ all -> 0x00d5 }
        monitor-exit(r7)
        return
    L_0x00d5:
        r0 = move-exception
        monitor-exit(r7)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p078e.SecurityRequestAuth.m3886b():void");
    }

    /* renamed from: a */
    public String mo11827a(String str) {
        String str2;
        if (!this.f3447k) {
            m3886b();
        }
        if (this.f3437a == null) {
            Logger.m3833a("SecurityRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            if (this.f3439c != null) {
                Class cls = this.f3441e;
                if (!(cls == null || this.f3442f == null || this.f3443g == null || this.f3444h == null || this.f3445i == null || this.f3440d == null)) {
                    try {
                        Object newInstance = cls.newInstance();
                        this.f3442f.set(newInstance, this.f3437a);
                        ((Map) this.f3443g.get(newInstance)).put("INPUT", str);
                        this.f3444h.set(newInstance, Integer.valueOf(this.f3446j));
                        str2 = (String) this.f3445i.invoke(this.f3440d, new Object[]{newInstance, this.f3438b});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return str2;
                }
            }
            str2 = null;
            return str2;
        }
    }
}
