package com.alipay.apmobilesecuritysdk.p107e;

import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alipay.apmobilesecuritysdk.e.i */
public final class C1454i {
    /* renamed from: a */
    private static String f3713a = "";
    /* renamed from: b */
    private static String f3714b = "";
    /* renamed from: c */
    private static String f3715c = "";
    /* renamed from: d */
    private static String f3716d = "";
    /* renamed from: e */
    private static String f3717e = "";
    /* renamed from: f */
    private static Map<String, String> f3718f = new HashMap();

    /* renamed from: a */
    public static synchronized String m4229a(String str) {
        synchronized (C1454i.class) {
            StringBuilder sb = new StringBuilder("apdidTokenCache");
            sb.append(str);
            String sb2 = sb.toString();
            if (f3718f.containsKey(sb2)) {
                String str2 = (String) f3718f.get(sb2);
                if (C1460a.m4263b(str2)) {
                    return str2;
                }
            }
            String str3 = "";
            return str3;
        }
    }

    /* renamed from: a */
    public static synchronized void m4230a() {
        synchronized (C1454i.class) {
        }
    }

    /* renamed from: a */
    public static synchronized void m4231a(C1447b bVar) {
        synchronized (C1454i.class) {
            if (bVar != null) {
                f3713a = bVar.f3699a;
                f3714b = bVar.f3700b;
                f3715c = bVar.f3701c;
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m4232a(C1448c cVar) {
        synchronized (C1454i.class) {
            if (cVar != null) {
                f3713a = cVar.f3702a;
                f3714b = cVar.f3703b;
                f3716d = cVar.f3705d;
                f3717e = cVar.f3706e;
                f3715c = cVar.f3704c;
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m4233a(String str, String str2) {
        synchronized (C1454i.class) {
            StringBuilder sb = new StringBuilder("apdidTokenCache");
            sb.append(str);
            String sb2 = sb.toString();
            if (f3718f.containsKey(sb2)) {
                f3718f.remove(sb2);
            }
            f3718f.put(sb2, str2);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0023  */
    /* renamed from: a */
    public static synchronized boolean m4234a(android.content.Context r8, java.lang.String r9) {
        /*
        java.lang.Class<com.alipay.apmobilesecuritysdk.e.i> r0 = com.alipay.apmobilesecuritysdk.p107e.C1454i.class
        monitor-enter(r0)
        r1 = 86400000(0x5265c00, double:4.2687272E-316)
        long r3 = com.alipay.apmobilesecuritysdk.p107e.C1453h.m4212a(r8)     // Catch:{ all -> 0x0012 }
        r5 = 0
        int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
        if (r7 >= 0) goto L_0x0011
        goto L_0x0012
    L_0x0011:
        r1 = r3
    L_0x0012:
        long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0026 }
        long r8 = com.alipay.apmobilesecuritysdk.p107e.C1453h.m4228h(r8, r9)     // Catch:{ all -> 0x0026 }
        long r3 = r3 - r8
        long r8 = java.lang.Math.abs(r3)     // Catch:{ all -> 0x0026 }
        int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
        if (r3 >= 0) goto L_0x002a
        r8 = 1
    L_0x0024:
        monitor-exit(r0)
        return r8
    L_0x0026:
        r8 = move-exception
        com.alipay.apmobilesecuritysdk.p105c.C1438a.m4169a(r8)     // Catch:{ all -> 0x002c }
    L_0x002a:
        r8 = 0
        goto L_0x0024
    L_0x002c:
        r8 = move-exception
        monitor-exit(r0)
        throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.p107e.C1454i.m4234a(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: b */
    public static synchronized String m4235b() {
        String str;
        synchronized (C1454i.class) {
            str = f3713a;
        }
        return str;
    }

    /* renamed from: b */
    public static void m4236b(String str) {
        f3713a = str;
    }

    /* renamed from: c */
    public static synchronized String m4237c() {
        String str;
        synchronized (C1454i.class) {
            str = f3714b;
        }
        return str;
    }

    /* renamed from: c */
    public static void m4238c(String str) {
        f3714b = str;
    }

    /* renamed from: d */
    public static synchronized String m4239d() {
        String str;
        synchronized (C1454i.class) {
            str = f3716d;
        }
        return str;
    }

    /* renamed from: d */
    public static void m4240d(String str) {
        f3715c = str;
    }

    /* renamed from: e */
    public static synchronized String m4241e() {
        String str;
        synchronized (C1454i.class) {
            str = f3717e;
        }
        return str;
    }

    /* renamed from: e */
    public static void m4242e(String str) {
        f3716d = str;
    }

    /* renamed from: f */
    public static synchronized String m4243f() {
        String str;
        synchronized (C1454i.class) {
            str = f3715c;
        }
        return str;
    }

    /* renamed from: f */
    public static void m4244f(String str) {
        f3717e = str;
    }

    /* renamed from: g */
    public static synchronized C1448c m4245g() {
        C1448c cVar;
        synchronized (C1454i.class) {
            cVar = new C1448c(f3713a, f3714b, f3715c, f3716d, f3717e);
        }
        return cVar;
    }

    /* renamed from: h */
    public static void m4246h() {
        f3718f.clear();
        String str = "";
        f3713a = str;
        f3714b = str;
        f3716d = str;
        f3717e = str;
        f3715c = str;
    }
}
