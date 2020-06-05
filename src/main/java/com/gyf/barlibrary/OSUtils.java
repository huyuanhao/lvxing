package com.gyf.barlibrary;

import android.text.TextUtils;

public class OSUtils {
    private static final String KEY_DISPLAY = "ro.build.display.id";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_MIUI_VERSION_NAME, ""));
    }

    public static boolean isMIUI6Later() {
        String mIUIVersion = getMIUIVersion();
        if (!mIUIVersion.isEmpty()) {
            boolean z = true;
            try {
                if (Integer.valueOf(mIUIVersion.substring(1)).intValue() < 6) {
                    z = false;
                }
                return z;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public static String getMIUIVersion() {
        String str = "";
        return isMIUI() ? getSystemProperty(KEY_MIUI_VERSION_NAME, str) : str;
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty(KEY_EMUI_VERSION_NAME, ""));
    }

    public static String getEMUIVersion() {
        String str = "";
        return isEMUI() ? getSystemProperty(KEY_EMUI_VERSION_NAME, str) : str;
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
    }

    public static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_x() {
        return isEMUI3_0() || isEMUI3_1();
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        int i;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains("os")) {
                i = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                i = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            if (i >= 4) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFlymeOS5() {
        int i;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains("os")) {
                i = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                i = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            if (i == 5) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static String getFlymeOSVersion() {
        String str = "";
        return isFlymeOS() ? getSystemProperty(KEY_DISPLAY, str) : str;
    }

    private static String getFlymeOSFlag() {
        return getSystemProperty(KEY_DISPLAY, "");
    }

    private static String getSystemProperty(String str, String str2) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str2});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
