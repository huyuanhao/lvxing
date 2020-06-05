package com.p522qq.p523e.ads.cfg;

import com.p522qq.p523e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.cfg.MultiProcessFlag */
public class MultiProcessFlag {
    /* renamed from: a */
    private static boolean f19967a;
    /* renamed from: b */
    private static boolean f19968b;

    public static boolean isMultiProcess() {
        return f19967a;
    }

    public static void setMultiProcess(boolean z) {
        if (!f19968b) {
            f19968b = true;
            f19967a = z;
            return;
        }
        GDTLogger.m25263w("MultiProcessFlag has already be setted,reset will not take any effect");
    }
}
