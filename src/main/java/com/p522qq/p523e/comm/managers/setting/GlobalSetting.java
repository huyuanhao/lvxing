package com.p522qq.p523e.comm.managers.setting;

import com.p522qq.p523e.comm.p525pi.CustomLandingPageListener;

/* renamed from: com.qq.e.comm.managers.setting.GlobalSetting */
public final class GlobalSetting {
    /* renamed from: a */
    private static volatile CustomLandingPageListener f20216a;
    /* renamed from: b */
    private static volatile Integer f20217b;
    /* renamed from: c */
    private static volatile boolean f20218c;
    /* renamed from: d */
    private static volatile Boolean f20219d;
    /* renamed from: e */
    private static volatile String f20220e;
    /* renamed from: f */
    private static volatile String f20221f;
    /* renamed from: g */
    private static volatile String f20222g;
    /* renamed from: h */
    private static volatile String f20223h;
    /* renamed from: i */
    private static volatile String f20224i;

    public static Integer getChannel() {
        return f20217b;
    }

    public static String getCustomADActivityClassName() {
        return f20220e;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        return f20216a;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f20223h;
    }

    public static String getCustomPortraitActivityClassName() {
        return f20221f;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f20224i;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f20222g;
    }

    public static Boolean isAgreePrivacyStrategy() {
        return f20219d;
    }

    public static boolean isEnableMediationTool() {
        return f20218c;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (f20219d == null) {
            f20219d = Boolean.valueOf(z);
        }
    }

    public static void setChannel(int i) {
        if (f20217b == null) {
            f20217b = Integer.valueOf(i);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f20220e = str;
    }

    public static void setCustomLandingPageListener(CustomLandingPageListener customLandingPageListener) {
        f20216a = customLandingPageListener;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f20223h = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f20221f = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f20224i = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f20222g = str;
    }

    public static void setEnableMediationTool(boolean z) {
        f20218c = z;
    }
}
