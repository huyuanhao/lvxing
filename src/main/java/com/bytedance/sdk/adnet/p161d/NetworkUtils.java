package com.bytedance.sdk.adnet.p161d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.util.Log;

/* renamed from: com.bytedance.sdk.adnet.d.f */
public class NetworkUtils {
    /* renamed from: a */
    public static boolean m7954a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                int length = allNetworkInfo.length;
                for (int i = 0; i < length; i++) {
                    NetworkInfo networkInfo = allNetworkInfo[i];
                    if (networkInfo.getState() == State.CONNECTED || networkInfo.getState() == State.CONNECTING) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("ignored", th.toString());
        }
    }
}
