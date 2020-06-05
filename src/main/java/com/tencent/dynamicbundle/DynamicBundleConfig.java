package com.tencent.dynamicbundle;

import com.tencent.dynamicbundle.p604a.C7284a;

/* compiled from: ProGuard */
public class DynamicBundleConfig {
    /* renamed from: a */
    private static DynamicBundleConfig f24676a = null;
    public static String appDexPath = ".xgcommpack";
    public static String endFileName = ".pack";
    public static int retryLoadDexNum = 2;
    public static String sdDexPath = "/sdcard";

    public static synchronized DynamicBundleConfig getInstance() {
        DynamicBundleConfig dynamicBundleConfig;
        synchronized (DynamicBundleConfig.class) {
            if (f24676a == null) {
                f24676a = new DynamicBundleConfig();
            }
            dynamicBundleConfig = f24676a;
        }
        return dynamicBundleConfig;
    }

    private DynamicBundleConfig() {
        setDebugEnable(true);
    }

    public void setDebugEnable(boolean z) {
        C7284a.m31447a().mo34992a(z);
    }
}
