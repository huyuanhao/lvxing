package com.alibaba.baichuan.trade.common.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.alibaba.baichuan.trade.common.utils.network.a */
public class C1233a {
    /* renamed from: a */
    public static boolean m2445a(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                z = true;
            }
        }
        return z;
    }
}
