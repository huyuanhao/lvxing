package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.ConnectivityMonitor.C1754a;
import com.tencent.mid.core.Constants;

/* renamed from: com.bumptech.glide.manager.f */
public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    /* renamed from: a */
    public ConnectivityMonitor mo13160a(Context context, C1754a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, Constants.PERMISSION_ACCESS_NETWORK_STATE) == 0;
        String str = "ConnectivityMonitor";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new DefaultConnectivityMonitor(context, aVar) : new NullConnectivityMonitor();
    }
}
