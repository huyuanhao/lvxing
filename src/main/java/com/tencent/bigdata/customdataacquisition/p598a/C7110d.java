package com.tencent.bigdata.customdataacquisition.p598a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.bigdata.customdataacquisition.p599b.C7112a;
import com.tencent.mid.core.Constants;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.bigdata.customdataacquisition.a.d */
public class C7110d {
    /* renamed from: a */
    private static String f23630a;

    /* renamed from: a */
    public static String m30471a(Context context) {
        String str = f23630a;
        if (str != null) {
            return str;
        }
        String str2 = "";
        if (C7112a.m30480a(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager != null) {
                    f23630a = wifiManager.getConnectionInfo().getMacAddress();
                    if (f23630a != null) {
                        str2 = f23630a;
                    }
                    return str2;
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("getMacAddress");
                sb.append(e.toString());
                C7112a.m30484c(sb.toString());
            }
        }
        return str2;
    }

    /* renamed from: a */
    public static JSONArray m30472a(Context context, int i) {
        try {
            if (!C7112a.m30480a(context, Constants.PERMISSION_INTERNET) || !C7112a.m30480a(context, Constants.PERMISSION_ACCESS_NETWORK_STATE) || (!C7112a.m30480a(context, "android.permission.ACCESS_COARSE_LOCATION") && !C7112a.m30480a(context, "android.permission.ACCESS_FINE_LOCATION"))) {
                C7112a.m30484c("can not get the permisson for getWifiTopN");
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                List scanResults = wifiManager.getScanResults();
                if (scanResults != null && scanResults.size() > 0) {
                    Collections.sort(scanResults, new Comparator<ScanResult>() {
                        /* renamed from: a */
                        public int compare(ScanResult scanResult, ScanResult scanResult2) {
                            int abs = Math.abs(scanResult.level);
                            int abs2 = Math.abs(scanResult2.level);
                            if (abs > abs2) {
                                return 1;
                            }
                            return abs == abs2 ? 0 : -1;
                        }
                    });
                    JSONArray jSONArray = new JSONArray();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= scanResults.size()) {
                            break;
                        } else if (i2 >= i) {
                            break;
                        } else {
                            ScanResult scanResult = (ScanResult) scanResults.get(i2);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bs", scanResult.BSSID);
                            jSONObject.put("ss", scanResult.SSID);
                            jSONArray.put(jSONObject);
                            i2++;
                        }
                    }
                    return jSONArray;
                }
            }
            return null;
        } catch (Throwable th) {
            C7112a.m30484c(th.toString());
        }
    }

    /* renamed from: b */
    public static String m30473b(Context context) {
        String str = "";
        try {
            if (C7112a.m30480a(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
                Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                            if (!inetAddress.isLoopbackAddress()) {
                                String hostAddress = inetAddress.getHostAddress();
                                if (InetAddressUtils.isIPv4Address(hostAddress)) {
                                    if (hostAddress != null) {
                                        str = hostAddress;
                                    }
                                    return str;
                                }
                            }
                        }
                    }
                }
                return str;
            }
            C7112a.m30484c("Can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getIpV4Address Exception:");
            sb.append(e.toString());
            C7112a.m30484c(sb.toString());
        }
    }

    /* renamed from: c */
    public static WifiInfo m30474c(Context context) {
        if (C7112a.m30480a(context, Constants.PERMISSION_ACCESS_WIFI_STATE)) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
        }
        return null;
    }

    /* renamed from: d */
    public static String m30475d(Context context) {
        String str = "";
        try {
            WifiInfo c = m30474c(context);
            if (c != null) {
                String bssid = c.getBSSID();
                if (bssid == null) {
                    bssid = str;
                }
                return bssid;
            }
        } catch (Throwable th) {
            C7112a.m30484c(th.toString());
        }
        return str;
    }

    /* renamed from: e */
    public static String m30476e(Context context) {
        String str = "";
        try {
            WifiInfo c = m30474c(context);
            if (c != null) {
                String ssid = c.getSSID();
                if (ssid == null) {
                    ssid = str;
                }
                return ssid;
            }
        } catch (Throwable th) {
            C7112a.m30484c(th.toString());
        }
        return str;
    }
}
