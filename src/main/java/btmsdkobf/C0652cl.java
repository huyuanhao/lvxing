package btmsdkobf;

import android.content.Context;

/* renamed from: btmsdkobf.cl */
public class C0652cl {
    /* renamed from: ga */
    static Context f417ga;
    /* renamed from: gb */
    static C0562a f418gb;

    /* renamed from: C */
    public static boolean m84C() {
        return C0843fb.m895cM().getBoolean("auto_conn", true);
    }

    /* renamed from: D */
    public static Context m85D() {
        Context context = f417ga;
        if (context != null) {
            return context.getApplicationContext();
        }
        C0848ff.m908w("TMSDKBaseContextInner", "sContext == null");
        return null;
    }

    /* renamed from: E */
    public static C0562a m86E() {
        return f418gb;
    }

    /* renamed from: F */
    public static boolean m87F() {
        return m86E().mo9080d().compareToIgnoreCase("mazutest.3g.qq.com") == 0;
    }

    /* renamed from: a */
    public static void m88a(Context context) {
        if (context != null) {
            f417ga = context;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
            return false;
     */
    /* renamed from: a */
    public static synchronized boolean m89a(android.content.Context r4, btmsdkobf.C0562a r5) {
        /*
        java.lang.Class<btmsdkobf.cl> r0 = btmsdkobf.C0652cl.class
        monitor-enter(r0)
        java.lang.String r1 = "TMSDKBaseContextInner"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
        r2.<init>()     // Catch:{ all -> 0x009c }
        java.lang.String r3 = "init, aContext:["
        r2.append(r3)     // Catch:{ all -> 0x009c }
        r2.append(r4)     // Catch:{ all -> 0x009c }
        java.lang.String r3 = "]aTMSConfig:["
        r2.append(r3)     // Catch:{ all -> 0x009c }
        r2.append(r5)     // Catch:{ all -> 0x009c }
        java.lang.String r3 = "]"
        r2.append(r3)     // Catch:{ all -> 0x009c }
        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x009c }
        btmsdkobf.C0848ff.m905d(r1, r2)     // Catch:{ all -> 0x009c }
        r1 = 0
        if (r4 == 0) goto L_0x009a
        if (r5 != 0) goto L_0x002c
        goto L_0x009a
    L_0x002c:
        android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x009c }
        f417ga = r4     // Catch:{ all -> 0x009c }
        f418gb = r5     // Catch:{ all -> 0x009c }
        btmsdkobf.a r4 = f418gb     // Catch:{ all -> 0x009c }
        boolean r4 = r4.isJavaTCC()     // Catch:{ all -> 0x009c }
        if (r4 != 0) goto L_0x004b
        boolean r4 = tmsdk.common.tcc.C8708b.m37729cJ()     // Catch:{ all -> 0x009c }
        if (r4 != 0) goto L_0x004b
        java.lang.String r4 = "TMSDKBaseContextInner"
        java.lang.String r5 = "loadLibraryIfNot false"
        btmsdkobf.C0848ff.m908w(r4, r5)     // Catch:{ all -> 0x009c }
        monitor-exit(r0)
        return r1
    L_0x004b:
        btmsdkobf.a r4 = f418gb     // Catch:{ all -> 0x009c }
        boolean r4 = r4.isCheckLicence()     // Catch:{ all -> 0x009c }
        if (r4 == 0) goto L_0x0062
        boolean r4 = checkLicence()     // Catch:{ all -> 0x009c }
        if (r4 != 0) goto L_0x0062
        java.lang.String r4 = "TMSDKBaseContextInner"
        java.lang.String r5 = "checkLisence false"
        btmsdkobf.C0848ff.m908w(r4, r5)     // Catch:{ all -> 0x009c }
        monitor-exit(r0)
        return r1
    L_0x0062:
        btmsdkobf.cx r4 = btmsdkobf.C0670cx.m165al()     // Catch:{ all -> 0x009c }
        r4.mo9215am()     // Catch:{ all -> 0x009c }
        btmsdkobf.cx r4 = btmsdkobf.C0670cx.m165al()     // Catch:{ all -> 0x009c }
        r4.mo9216an()     // Catch:{ all -> 0x009c }
        btmsdkobf.C0664ct.init()     // Catch:{ all -> 0x009c }
        boolean r4 = m84C()     // Catch:{ all -> 0x009c }
        if (r4 == 0) goto L_0x0090
        btmsdkobf.cx r4 = btmsdkobf.C0670cx.m165al()     // Catch:{ all -> 0x009c }
        r4.mo9217ao()     // Catch:{ all -> 0x009c }
        btmsdkobf.cx r4 = btmsdkobf.C0670cx.m165al()     // Catch:{ all -> 0x009c }
        r4.mo9218ap()     // Catch:{ all -> 0x009c }
        btmsdkobf.C0664ct.m136X()     // Catch:{ all -> 0x009c }
        btmsdkobf.C0638c.m80g()     // Catch:{ all -> 0x009c }
        btmsdkobf.C0638c.m81h()     // Catch:{ all -> 0x009c }
    L_0x0090:
        java.lang.String r4 = "TMSDKBaseContextInner"
        java.lang.String r5 = "init, true"
        btmsdkobf.C0848ff.m905d(r4, r5)     // Catch:{ all -> 0x009c }
        r4 = 1
        monitor-exit(r0)
        return r4
    L_0x009a:
        monitor-exit(r0)
        return r1
    L_0x009c:
        r4 = move-exception
        monitor-exit(r0)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0652cl.m89a(android.content.Context, btmsdkobf.a):boolean");
    }

    /* renamed from: c */
    public static String m90c() {
        return C0660cq.m122Q().mo9185c();
    }

    public static boolean checkLicence() {
        try {
            return C0660cq.m122Q().mo9184O();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setAutoConnectionSwitch(Context context, boolean z) {
        if (context != null) {
            f417ga = context.getApplicationContext();
        }
        C0843fb.m895cM().putBoolean("auto_conn", z);
    }
}
