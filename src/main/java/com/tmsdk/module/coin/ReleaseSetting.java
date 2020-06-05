package com.tmsdk.module.coin;

public class ReleaseSetting {
    public static String CHANNEL_NO = "222222";
    public static final boolean NEED_DeviceId = false;

    public static boolean isAllowAndroidID() {
        return true;
    }

    public static boolean isAllowImei() {
        return true;
    }

    public static boolean isAllowImsi() {
        return true;
    }

    public static boolean isAllowMac() {
        return true;
    }

    public static boolean isAllowOther() {
        return true;
    }

    public static boolean isCheckLicence() {
        return false;
    }

    public static boolean isJavaTCC() {
        return true;
    }
}
