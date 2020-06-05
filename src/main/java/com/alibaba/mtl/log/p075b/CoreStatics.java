package com.alibaba.mtl.log.p075b;

import android.text.TextUtils;
import com.alibaba.mtl.log.p077d.NetworkUtil;

/* renamed from: com.alibaba.mtl.log.b.a */
public class CoreStatics {
    /* renamed from: a */
    private static volatile long f3320a;
    /* renamed from: b */
    private static long f3321b;
    /* renamed from: c */
    private static long f3322c;
    /* renamed from: d */
    private static int f3323d;
    /* renamed from: e */
    private static long f3324e;
    /* renamed from: f */
    private static long f3325f;
    /* renamed from: g */
    private static long f3326g;
    /* renamed from: h */
    private static long f3327h;
    /* renamed from: i */
    private static long f3328i;
    /* renamed from: j */
    private static long f3329j;
    /* renamed from: k */
    private static int f3330k;
    /* renamed from: l */
    private static int f3331l;
    /* renamed from: m */
    private static long f3332m;
    /* renamed from: n */
    private static long f3333n;
    /* renamed from: o */
    private static long f3334o;
    /* renamed from: p */
    private static long f3335p;
    /* renamed from: q */
    private static long f3336q;
    /* renamed from: r */
    private static long f3337r;
    /* renamed from: s */
    private static long f3338s;
    /* renamed from: t */
    private static long f3339t;
    /* renamed from: u */
    private static long f3340u;
    /* renamed from: v */
    private static long f3341v;
    /* renamed from: w */
    private static long f3342w;
    /* renamed from: x */
    private static long f3343x;
    /* renamed from: y */
    private static StringBuilder f3344y = new StringBuilder();

    /* renamed from: a */
    public static synchronized void m3739a(String str) {
        synchronized (CoreStatics.class) {
            if (!m3745c(str)) {
                if ("65501".equalsIgnoreCase(str)) {
                    f3343x++;
                } else if ("65133".equalsIgnoreCase(str)) {
                    f3341v++;
                } else if ("65502".equalsIgnoreCase(str)) {
                    f3342w++;
                } else if ("65503".equalsIgnoreCase(str)) {
                    f3340u++;
                }
                f3320a++;
            }
        }
    }

    /* renamed from: b */
    public static synchronized void m3743b(String str) {
        synchronized (CoreStatics.class) {
            if (!m3745c(str)) {
                f3321b++;
                m3754l();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0080, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m3740a(java.util.List<com.alibaba.mtl.log.model.Log> r11, int r12) {
        /*
        java.lang.Class<com.alibaba.mtl.log.b.a> r0 = com.alibaba.mtl.log.p075b.CoreStatics.class
        monitor-enter(r0)
        if (r11 != 0) goto L_0x0007
        monitor-exit(r0)
        return
    L_0x0007:
        r1 = 0
        r2 = 0
        r3 = 0
    L_0x000a:
        int r4 = r11.size()     // Catch:{ all -> 0x0081 }
        r5 = 1
        if (r2 >= r4) goto L_0x003d
        java.lang.Object r4 = r11.get(r2)     // Catch:{ all -> 0x0081 }
        com.alibaba.mtl.log.model.a r4 = (com.alibaba.mtl.log.model.Log) r4     // Catch:{ all -> 0x0081 }
        if (r4 == 0) goto L_0x003a
        java.lang.String r6 = "6005"
        java.lang.String r7 = r4.f3462b     // Catch:{ all -> 0x0081 }
        boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0081 }
        if (r6 != 0) goto L_0x0025
        int r3 = r3 + 1
    L_0x0025:
        java.lang.StringBuilder r6 = f3344y     // Catch:{ all -> 0x0081 }
        java.lang.String r4 = r4.f3465e     // Catch:{ all -> 0x0081 }
        r6.append(r4)     // Catch:{ all -> 0x0081 }
        int r4 = r11.size()     // Catch:{ all -> 0x0081 }
        int r4 = r4 - r5
        if (r2 == r4) goto L_0x003a
        java.lang.StringBuilder r4 = f3344y     // Catch:{ all -> 0x0081 }
        java.lang.String r5 = ","
        r4.append(r5)     // Catch:{ all -> 0x0081 }
    L_0x003a:
        int r2 = r2 + 1
        goto L_0x000a
    L_0x003d:
        java.lang.String r11 = "CoreStatics"
        r2 = 4
        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0081 }
        java.lang.String r4 = "[uploadInc]:"
        r2[r1] = r4     // Catch:{ all -> 0x0081 }
        long r6 = f3322c     // Catch:{ all -> 0x0081 }
        java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0081 }
        r2[r5] = r4     // Catch:{ all -> 0x0081 }
        java.lang.String r4 = "count:"
        r6 = 2
        r2[r6] = r4     // Catch:{ all -> 0x0081 }
        r4 = 3
        java.lang.Integer r7 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0081 }
        r2[r4] = r7     // Catch:{ all -> 0x0081 }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r11, r2)     // Catch:{ all -> 0x0081 }
        long r7 = f3322c     // Catch:{ all -> 0x0081 }
        long r9 = (long) r12     // Catch:{ all -> 0x0081 }
        long r7 = r7 + r9
        f3322c = r7     // Catch:{ all -> 0x0081 }
        java.lang.String r11 = "CoreStatics"
        java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0081 }
        java.lang.String r4 = "[uploadInc]:"
        r2[r1] = r4     // Catch:{ all -> 0x0081 }
        long r6 = f3322c     // Catch:{ all -> 0x0081 }
        java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0081 }
        r2[r5] = r1     // Catch:{ all -> 0x0081 }
        com.alibaba.mtl.log.p077d.Logger.m3833a(r11, r2)     // Catch:{ all -> 0x0081 }
        if (r3 == r12) goto L_0x007f
        java.lang.String r11 = "CoreStatics"
        java.lang.String r12 = "Mutil Process Upload Error"
        com.alibaba.mtl.log.p077d.Logger.m3831a(r11, r12)     // Catch:{ all -> 0x0081 }
    L_0x007f:
        monitor-exit(r0)
        return
    L_0x0081:
        r11 = move-exception
        monitor-exit(r0)
        throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p075b.CoreStatics.m3740a(java.util.List, int):void");
    }

    /* renamed from: a */
    public static synchronized void m3738a(int i) {
        synchronized (CoreStatics.class) {
            f3323d += i;
        }
    }

    /* renamed from: a */
    public static synchronized void m3737a() {
        synchronized (CoreStatics.class) {
            f3324e++;
        }
    }

    /* renamed from: b */
    public static synchronized void m3742b() {
        synchronized (CoreStatics.class) {
            f3325f++;
        }
    }

    /* renamed from: c */
    public static synchronized void m3744c() {
        synchronized (CoreStatics.class) {
            f3332m++;
        }
    }

    /* renamed from: d */
    public static synchronized void m3746d() {
        synchronized (CoreStatics.class) {
            f3333n++;
        }
    }

    /* renamed from: e */
    public static synchronized void m3747e() {
        synchronized (CoreStatics.class) {
            f3334o++;
        }
    }

    /* renamed from: f */
    public static synchronized void m3748f() {
        synchronized (CoreStatics.class) {
            f3335p++;
        }
    }

    /* renamed from: g */
    public static synchronized void m3749g() {
        synchronized (CoreStatics.class) {
            f3336q++;
        }
    }

    /* renamed from: h */
    public static synchronized void m3750h() {
        synchronized (CoreStatics.class) {
            f3337r++;
        }
    }

    /* renamed from: i */
    public static synchronized void m3751i() {
        synchronized (CoreStatics.class) {
            f3338s++;
        }
    }

    /* renamed from: j */
    public static synchronized void m3752j() {
        synchronized (CoreStatics.class) {
            f3339t++;
        }
    }

    /* renamed from: a */
    public static synchronized void m3741a(boolean z) {
        synchronized (CoreStatics.class) {
        }
    }

    /* renamed from: l */
    private static void m3754l() {
        String a = NetworkUtil.m3843a();
        if ("wifi".equalsIgnoreCase(a)) {
            f3329j++;
        } else if ("3G".equalsIgnoreCase(a)) {
            f3327h++;
        } else if ("4G".equalsIgnoreCase(a)) {
            f3328i++;
        } else if ("2G".equalsIgnoreCase(a)) {
            f3326g++;
        } else {
            f3330k++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
            return;
     */
    /* renamed from: k */
    public static synchronized void m3753k() {
        /*
        java.lang.Class<com.alibaba.mtl.log.b.a> r0 = com.alibaba.mtl.log.p075b.CoreStatics.class
        monitor-enter(r0)
        int r1 = f3331l     // Catch:{ all -> 0x0027 }
        r2 = 1
        int r1 = r1 + r2
        f3331l = r1     // Catch:{ all -> 0x0027 }
        long r3 = f3320a     // Catch:{ all -> 0x0027 }
        r5 = 0
        int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r1 != 0) goto L_0x0019
        long r3 = f3322c     // Catch:{ all -> 0x0027 }
        int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r1 != 0) goto L_0x0019
        monitor-exit(r0)
        return
    L_0x0019:
        boolean r1 = com.alibaba.mtl.log.UTDC.f3270a     // Catch:{ all -> 0x0027 }
        if (r1 != 0) goto L_0x0022
        int r1 = f3331l     // Catch:{ all -> 0x0027 }
        r3 = 6
        if (r1 < r3) goto L_0x0025
    L_0x0022:
        m3741a(r2)     // Catch:{ all -> 0x0027 }
    L_0x0025:
        monitor-exit(r0)
        return
    L_0x0027:
        r1 = move-exception
        monitor-exit(r0)
        throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.p075b.CoreStatics.m3753k():void");
    }

    /* renamed from: c */
    private static boolean m3745c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "6005".equalsIgnoreCase(str.trim());
    }
}
