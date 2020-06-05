package com.bytedance.tea.crash;

import android.content.Context;
import com.bytedance.tea.crash.p218e.CommonParams;
import com.bytedance.tea.crash.p218e.ConfigManager;
import com.bytedance.tea.crash.p218e.SettingManager;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.bytedance.tea.crash.h */
public final class NpthBus {
    /* renamed from: a */
    private static Context f9380a = null;
    /* renamed from: b */
    private static long f9381b = 0;
    /* renamed from: c */
    private static String f9382c = "default";
    /* renamed from: d */
    private static boolean f9383d = false;
    /* renamed from: e */
    private static CommonParams f9384e;
    /* renamed from: f */
    private static ConfigManager f9385f = new ConfigManager();
    /* renamed from: g */
    private static CallCenter f9386g = new CallCenter();
    /* renamed from: h */
    private static volatile ConcurrentHashMap<Integer, String> f9387h;
    /* renamed from: i */
    private static SettingManager f9388i = null;
    /* renamed from: j */
    private static volatile int f9389j;
    /* renamed from: k */
    private static volatile String f9390k;

    /* renamed from: a */
    public static CommonParams m12591a() {
        return f9384e;
    }

    /* renamed from: b */
    public static CallCenter m12593b() {
        return f9386g;
    }

    /* renamed from: c */
    public static SettingManager m12594c() {
        if (f9388i == null) {
            synchronized (NpthBus.class) {
                f9388i = new SettingManager(f9380a);
            }
        }
        return f9388i;
    }

    /* renamed from: a */
    static void m12592a(Context context, ICommonParams dVar) {
        f9381b = System.currentTimeMillis();
        f9380a = context;
        f9384e = new CommonParams(f9380a, dVar);
    }

    /* renamed from: d */
    public static Context m12595d() {
        return f9380a;
    }

    /* renamed from: e */
    public static ConfigManager m12596e() {
        return f9385f;
    }

    /* renamed from: f */
    public static long m12597f() {
        return f9381b;
    }

    /* renamed from: g */
    public static String m12598g() {
        return f9382c;
    }

    /* renamed from: h */
    public static boolean m12599h() {
        return f9383d;
    }

    /* renamed from: i */
    public static ConcurrentHashMap<Integer, String> m12600i() {
        return f9387h;
    }

    /* renamed from: j */
    public static int m12601j() {
        return f9389j;
    }

    /* renamed from: k */
    public static String m12602k() {
        return f9390k;
    }
}
