package com.tmsdk.module.coin;

public class AppRetainSpUtil {
    public static final String FILE_NAME = "APP_RETAIN_SP";

    public static ISharePreferenceImp getISharePreferenceImp() {
        return new ISharePreferenceImp(TMSDKContext.getApplicationContext(), FILE_NAME);
    }
}
