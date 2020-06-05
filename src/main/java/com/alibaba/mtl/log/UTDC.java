package com.alibaba.mtl.log;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.log.model.Log;
import com.alibaba.mtl.log.p075b.CoreStatics;
import com.alibaba.mtl.log.p076c.LogStoreMgr;
import com.alibaba.mtl.log.p077d.AppInfoUtil;
import com.alibaba.mtl.log.p077d.Logger;
import com.alibaba.mtl.log.p077d.NetworkUtil;
import com.alibaba.mtl.log.p078e.IRequestAuth;
import com.alibaba.mtl.log.p079f.UploadEngine;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.alibaba.mtl.log.a */
public class UTDC {
    /* renamed from: a */
    public static boolean f3270a = false;
    /* renamed from: b */
    public static int f3271b = 10000;
    /* renamed from: c */
    public static int f3272c = 0;
    /* renamed from: d */
    public static long f3273d = -1;
    /* renamed from: e */
    public static boolean f3274e = false;
    /* renamed from: f */
    public static String f3275f = String.valueOf(System.currentTimeMillis());
    /* renamed from: g */
    public static final AtomicInteger f3276g = new AtomicInteger(0);
    /* renamed from: h */
    public static boolean f3277h = true;
    /* renamed from: i */
    public static IRequestAuth f3278i = null;
    /* renamed from: j */
    public static boolean f3279j = true;
    /* renamed from: k */
    private static Context f3280k = null;
    /* renamed from: l */
    private static boolean f3281l = false;
    /* renamed from: m */
    private static boolean f3282m = (f3272c <= f3271b);

    /* renamed from: g */
    public static String m3701g() {
        return "";
    }

    /* renamed from: h */
    public static String m3702h() {
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
            return;
     */
    /* renamed from: a */
    public static synchronized void m3692a(android.content.Context r4) {
        /*
        java.lang.Class<com.alibaba.mtl.log.a> r0 = com.alibaba.mtl.log.UTDC.class
        monitor-enter(r0)
        if (r4 != 0) goto L_0x001d
        java.lang.String r1 = "UTDC"
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0033 }
        r2.<init>()     // Catch:{ all -> 0x0033 }
        java.lang.String r3 = "UTDC init failed ,context:"
        r2.append(r3)     // Catch:{ all -> 0x0033 }
        r2.append(r4)     // Catch:{ all -> 0x0033 }
        java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0033 }
        com.alibaba.mtl.log.p077d.Logger.m3831a(r1, r4)     // Catch:{ all -> 0x0033 }
        monitor-exit(r0)
        return
    L_0x001d:
        boolean r1 = f3281l     // Catch:{ all -> 0x0033 }
        if (r1 != 0) goto L_0x0031
        r1 = 1
        f3281l = r1     // Catch:{ all -> 0x0033 }
        android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x0033 }
        f3280k = r4     // Catch:{ all -> 0x0033 }
        com.alibaba.mtl.log.f.a r4 = com.alibaba.mtl.log.p079f.UploadEngine.m3889a()     // Catch:{ all -> 0x0033 }
        r4.mo11829b()     // Catch:{ all -> 0x0033 }
    L_0x0031:
        monitor-exit(r0)
        return
    L_0x0033:
        r4 = move-exception
        monitor-exit(r0)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.UTDC.m3692a(android.content.Context):void");
    }

    /* renamed from: a */
    public static void m3693a(IRequestAuth bVar) {
        f3278i = bVar;
        IRequestAuth bVar2 = f3278i;
        if (bVar2 != null) {
            AppInfoUtil.m3795b(bVar2.mo11826a());
        }
    }

    /* renamed from: a */
    public static void m3694a(String str) {
        AppInfoUtil.m3791a(str);
    }

    /* renamed from: a */
    public static void m3691a() {
        Logger.m3833a("UTDC", "[onBackground]");
        f3270a = true;
        CoreStatics.m3753k();
    }

    /* renamed from: b */
    public static void m3696b() {
        Logger.m3833a("UTDC", "[onForeground]");
        f3270a = false;
        UploadEngine.m3889a().mo11829b();
    }

    /* renamed from: a */
    public static void m3695a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        String str6 = "UTDC";
        if (f3280k == null) {
            Logger.m3831a(str6, (Object) "please call UTDC.init(context) before commit log,and this log will be discarded");
        } else if (f3278i == null) {
            Logger.m3831a(str6, (Object) "please call UTDC.setRequestAuthentication(auth) before commit log,and this log will be discarded");
        } else {
            Logger.m3833a(str6, "[commit] page:", str, "eventId:", str2, "arg1:", str3, "arg2:", str4, "arg3:", str5, "args:", map);
            CoreStatics.m3739a(str2);
            Log aVar = new Log(str, str2, str3, str4, str5, map);
            LogStoreMgr.m3777a().mo11791a(aVar);
        }
    }

    /* renamed from: c */
    public static Context m3697c() {
        return f3280k;
    }

    /* renamed from: d */
    public static IRequestAuth m3698d() {
        IRequestAuth bVar = f3278i;
        if (bVar == null || TextUtils.isEmpty(bVar.mo11826a())) {
            String str = "please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ";
            if (!Logger.m3837b()) {
                android.util.Log.w("UTDC", str);
            } else {
                throw new RuntimeException(str);
            }
        }
        return f3278i;
    }

    /* renamed from: e */
    public static String m3699e() {
        try {
            return NetworkUtil.m3845a(m3697c())[0];
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    /* renamed from: f */
    public static String m3700f() {
        String str = "Unknown";
        try {
            String[] a = NetworkUtil.m3845a(m3697c());
            return a[0].equals("2G/3G") ? a[1] : str;
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: i */
    public static void m3703i() {
        UploadEngine.m3889a().mo11829b();
    }
}
