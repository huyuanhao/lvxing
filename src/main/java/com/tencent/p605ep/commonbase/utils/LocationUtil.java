package com.tencent.p605ep.commonbase.utils;

import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.List;

/* renamed from: com.tencent.ep.commonbase.utils.LocationUtil */
public class LocationUtil {
    public static List<ScanResult> getScanResults(WifiManager wifiManager) {
        return wifiManager.getScanResults();
    }

    public static boolean isProviderEnabled(LocationManager locationManager, String str) {
        return locationManager.isProviderEnabled(str);
    }
}
