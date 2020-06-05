package com.tencent.p605ep.commonbase.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.p605ep.commonbase.api.AppContext;
import com.tencent.p605ep.commonbase.api.Log;

/* renamed from: com.tencent.ep.commonbase.utils.WifiUtil */
public class WifiUtil {
    private static final String TAG = "WifiUtil";

    public static NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) AppContext.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(" getActiveNetworkInfo NullPointerException--- \n");
            sb.append(th.getMessage());
            Log.m31487w("getActiveNetworkInfo", sb.toString());
            return null;
        }
    }

    public static boolean isWifiNetwork() {
        NetworkInfo networkInfo;
        try {
            networkInfo = getActiveNetworkInfo();
        } catch (NullPointerException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(" getActiveNetworkInfo NullPointerException--- \n");
            sb.append(e.getMessage());
            Log.m31487w("getActiveNetworkInfo", sb.toString());
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.getType() == 1;
    }
}
