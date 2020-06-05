package com.qiyukf.nimlib.p453d.p459b.p461b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;
import com.qiyukf.nimlib.p453d.p454a.p458d.C5760b;
import com.tencent.mid.core.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.d.b.b.b */
public final class C5771b {
    /* renamed from: a */
    public static C5770a m23192a(Context context) {
        String str = ".";
        WifiManager c = m23194c(context);
        if (c == null) {
            return null;
        }
        String[] strArr = {Constants.PERMISSION_ACCESS_WIFI_STATE, Constants.PERMISSION_ACCESS_NETWORK_STATE};
        boolean z = false;
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String str2 = context.getApplicationInfo().packageName;
                int i = 0;
                while (true) {
                    if (i >= 2) {
                        z = true;
                        break;
                    } else if (packageManager.checkPermission(strArr[i], str2) != 0) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (!z) {
            C5753a.m23146c("unable to get connected wifi info, as wifi/network permission is not granted");
            return null;
        }
        try {
            if (c.isWifiEnabled()) {
                WifiInfo connectionInfo = c.getConnectionInfo();
                if (connectionInfo != null) {
                    DetailedState detailedStateOf = WifiInfo.getDetailedStateOf(connectionInfo.getSupplicantState());
                    if (detailedStateOf == DetailedState.CONNECTED || detailedStateOf == DetailedState.OBTAINING_IPADDR) {
                        C5770a aVar = new C5770a(connectionInfo.getBSSID(), connectionInfo.getSSID());
                        if (VERSION.SDK_INT >= 21) {
                            aVar.f18380d = connectionInfo.getFrequency();
                        }
                        aVar.f18381e = connectionInfo.getLinkSpeed();
                        aVar.f18379c = connectionInfo.getRssi();
                        int ipAddress = connectionInfo.getIpAddress();
                        StringBuilder sb = new StringBuilder();
                        sb.append(ipAddress & 255);
                        sb.append(str);
                        sb.append((ipAddress >> 8) & 255);
                        sb.append(str);
                        sb.append((ipAddress >> 16) & 255);
                        sb.append(str);
                        sb.append(ipAddress >>> 24);
                        aVar.f18382f = sb.toString();
                        return aVar;
                    }
                }
            } else {
                C5753a.m23146c("wifi is disable");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder sb2 = new StringBuilder("get connected wifi info failed, e=");
            sb2.append(th.getMessage());
            C5753a.m23146c(sb2.toString());
        }
        return null;
    }

    /* renamed from: b */
    public static List<C5770a> m23193b(Context context) {
        String str;
        WifiManager c = m23194c(context);
        if (c == null) {
            return null;
        }
        if (!C5760b.m23157a(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
            str = "unable to scan wifi list, as wifi permission is not granted";
        } else if (C5760b.m23157a(context, "android.permission.ACCESS_COARSE_LOCATION") || C5760b.m23157a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            try {
                if (c.isWifiEnabled()) {
                    List<ScanResult> scanResults = c.getScanResults();
                    if (scanResults != null) {
                        if (!scanResults.isEmpty()) {
                            Collections.sort(scanResults, new Comparator<ScanResult>() {
                                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                    return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                                }
                            });
                            ArrayList arrayList = new ArrayList(scanResults.size());
                            for (ScanResult scanResult : scanResults) {
                                C5770a aVar = new C5770a(scanResult.BSSID, scanResult.SSID);
                                aVar.f18380d = scanResult.frequency;
                                aVar.f18379c = scanResult.level;
                                arrayList.add(aVar);
                                if (arrayList.size() >= 10) {
                                    break;
                                }
                            }
                            return arrayList;
                        }
                    }
                    return null;
                }
                C5753a.m23146c("wifi is disable");
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                StringBuilder sb = new StringBuilder("scan wifi list failed, e=");
                sb.append(th.getMessage());
                C5753a.m23146c(sb.toString());
            }
        } else {
            str = "unable to scan wifi list, as location permission is not granted";
        }
        C5753a.m23146c(str);
        return null;
    }

    /* renamed from: c */
    private static WifiManager m23194c(Context context) {
        try {
            return (WifiManager) context.getApplicationContext().getSystemService("wifi");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("get WifiManager failed, e=");
            sb.append(th.getMessage());
            C5753a.m23146c(sb.toString());
            return null;
        }
    }
}
