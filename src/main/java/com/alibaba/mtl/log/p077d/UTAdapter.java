package com.alibaba.mtl.log.p077d;

import java.util.Map;

/* renamed from: com.alibaba.mtl.log.d.s */
public class UTAdapter {
    /* renamed from: a */
    public static void m3876a(Map<String, String> map) {
        try {
            Object a = ReflectUtils.m3861a("com.ut.mini.UTAnalytics", "getInstance");
            if (a != null) {
                Object a2 = ReflectUtils.m3859a(a, "getDefaultTracker");
                if (a2 != null) {
                    ReflectUtils.m3860a(a2, "send", new Object[]{map}, Map.class);
                }
            }
        } catch (Exception unused) {
        }
    }
}
