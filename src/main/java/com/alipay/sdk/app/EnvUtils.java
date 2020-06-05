package com.alipay.sdk.app;

public class EnvUtils {
    /* renamed from: a */
    private static EnvEnum f3793a = EnvEnum.ONLINE;

    /* renamed from: com.alipay.sdk.app.EnvUtils$EnvEnum */
    public enum EnvEnum {
        ONLINE,
        SANDBOX
    }

    /* renamed from: a */
    public static boolean m4395a() {
        return f3793a == EnvEnum.SANDBOX;
    }
}
