package com.tencent.mid.api;

import android.content.Context;
import com.tencent.mid.core.ServiceIMPL;
import com.tencent.mid.sotrage.UnifiedStorage;

public class MidService {
    private static boolean enableReportWifiList = true;

    public static String getMidRequestHost() {
        return null;
    }

    public static String getMidRequestUrl() {
        return null;
    }

    public static void setMidRequestUrl(String str) {
    }

    public static void requestMid(Context context, MidCallback midCallback) throws IllegalArgumentException {
        if (midCallback == null) {
            throw new IllegalArgumentException("error, callback is null!");
        } else if (context == null) {
            midCallback.onFail(-10000, "content is null!");
        } else {
            ServiceIMPL.requestMid(context.getApplicationContext(), midCallback);
        }
    }

    public static String getLocalMidOnly(Context context) {
        return UnifiedStorage.getInstance(context).readMidString();
    }

    public static String getMid(Context context) {
        return ServiceIMPL.getMid(context);
    }

    public static long getGuid(Context context) {
        return ServiceIMPL.getGuid(context);
    }

    public static boolean isMidValid(String str) {
        return ServiceIMPL.isMidValid(str);
    }

    public static void enableDebug(boolean z) {
        ServiceIMPL.enableDebug(z);
    }

    public static boolean isEnableDebug() {
        return ServiceIMPL.isEnableDebug();
    }

    public static boolean isEnableReportWifiList() {
        return enableReportWifiList;
    }

    public static void setEnableReportWifiList(boolean z) {
        enableReportWifiList = z;
    }

    public static String getNewMid(Context context) {
        return UnifiedStorage.getInstance(context).readNewVersionMidStr();
    }
}
