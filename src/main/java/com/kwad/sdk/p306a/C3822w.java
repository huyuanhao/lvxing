package com.kwad.sdk.p306a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.request.model.C4312a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.a.w */
public class C3822w {
    /* renamed from: a */
    public static List<C4312a> m15878a(Context context, int i) {
        String str = "";
        String str2 = "\"";
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        try {
            if (VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1) {
                return arrayList;
            }
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return arrayList;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                for (ScanResult scanResult : scanResults) {
                    C4312a aVar = new C4312a();
                    aVar.f14172b = scanResult.SSID;
                    aVar.f14173c = scanResult.BSSID;
                    aVar.f14171a = scanResult.level;
                    if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace(str2, str), scanResult.BSSID.replace(str2, str)) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace(str2, str), scanResult.SSID.replace(str2, str))) {
                        arrayList.add(aVar);
                    } else {
                        arrayList.add(0, aVar);
                    }
                    if (arrayList.size() >= i) {
                        return arrayList;
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }
}
