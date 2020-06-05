package com.tencent.p605ep.commonbase.utils;

import android.content.ComponentName;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.p605ep.commonbase.QQPIM.ConnectType;
import com.tencent.p605ep.commonbase.api.AppContext;
import com.tencent.p605ep.commonbase.api.Log;

/* renamed from: com.tencent.ep.commonbase.utils.NetworkUtil */
public class NetworkUtil {
    public static final int NETWORK_CLASS_2_G = 2;
    public static final int NETWORK_CLASS_3_G = 3;
    public static final int NETWORK_CLASS_4_G = 4;
    public static final int NETWORK_CLASS_UNAVAILABLE = -1;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_CLASS_WIFI = 1;
    public static final int NETWORK_TYPE_GSM = 16;
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    private static final String TAG = "NetworkUtil";
    private static int mTargetSdkVersion;

    public static boolean canNetworkOnMainThread() {
        if (SDKUtil.getSDKVersion() < 11) {
            return true;
        }
        if (mTargetSdkVersion < 1) {
            mTargetSdkVersion = AppContext.getAppContext().getApplicationInfo().targetSdkVersion;
        }
        return mTargetSdkVersion < 10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033 A[SYNTHETIC, Splitter:B:17:0x0033] */
    public static boolean detectConnection(java.lang.String r4) {
        /*
        java.lang.String r4 = "www.qq.com"
        r0 = 0
        r1 = 0
        java.net.InetAddress r4 = java.net.InetAddress.getByName(r4)     // Catch:{ IOException -> 0x003d, all -> 0x0030 }
        java.net.InetSocketAddress r2 = new java.net.InetSocketAddress     // Catch:{ IOException -> 0x003d, all -> 0x0030 }
        r3 = 80
        r2.<init>(r4, r3)     // Catch:{ IOException -> 0x003d, all -> 0x0030 }
        java.net.Socket r4 = new java.net.Socket     // Catch:{ IOException -> 0x003d, all -> 0x0030 }
        r4.<init>()     // Catch:{ IOException -> 0x003d, all -> 0x0030 }
        r4.setSoLinger(r0, r0)     // Catch:{ IOException -> 0x002e, all -> 0x002c }
        r1 = 5000(0x1388, float:7.006E-42)
        r4.connect(r2, r1)     // Catch:{ IOException -> 0x002e, all -> 0x002c }
        r0 = 1
        boolean r1 = r4.isConnected()     // Catch:{ all -> 0x0027 }
        if (r1 == 0) goto L_0x0049
        r4.close()     // Catch:{ all -> 0x0027 }
        goto L_0x0049
    L_0x0027:
        r4 = move-exception
        r4.printStackTrace()
        goto L_0x0049
        goto L_0x0031
        goto L_0x003e
    L_0x0030:
        r4 = r1
    L_0x0031:
        if (r4 == 0) goto L_0x0049
        boolean r1 = r4.isConnected()     // Catch:{ all -> 0x0027 }
        if (r1 == 0) goto L_0x0049
        r4.close()     // Catch:{ all -> 0x0027 }
        goto L_0x0049
    L_0x003d:
        r4 = r1
    L_0x003e:
        if (r4 == 0) goto L_0x0049
        boolean r1 = r4.isConnected()     // Catch:{ all -> 0x0027 }
        if (r1 == 0) goto L_0x0049
        r4.close()     // Catch:{ all -> 0x0027 }
    L_0x0049:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p605ep.commonbase.utils.NetworkUtil.detectConnection(java.lang.String):boolean");
    }

    public static NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) AppContext.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static ConnectivityManager getConnectivityManager() {
        try {
            return (ConnectivityManager) AppContext.getAppContext().getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getNetworkClass() {
        int i;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppContext.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return -1;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return 1;
            }
            if (type == 0) {
                i = ((TelephonyManager) AppContext.getAppContext().getSystemService("phone")).getNetworkType();
                return getNetworkClassByType(i);
            }
            i = 0;
            return getNetworkClassByType(i);
        } catch (Exception e) {
            Log.m31479e(TAG, e.getMessage());
        }
    }

    private static int getNetworkClassByType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
                return 4;
            default:
                return 0;
        }
    }

    public static String getNetworkName() {
        NetworkInfo networkInfo;
        try {
            networkInfo = getActiveNetworkInfo();
        } catch (NullPointerException unused) {
            networkInfo = null;
        }
        String str = "";
        if (networkInfo == null) {
            return str;
        }
        String ssid = networkInfo.getType() == 1 ? getSSID() : networkInfo.getExtraInfo();
        if (ssid == null) {
            ssid = str;
        }
        return ssid;
    }

    public static ConnectType getNetworkType() {
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
        if (networkInfo == null) {
            return ConnectType.CT_NONE;
        }
        if (networkInfo.getType() == 1) {
            return ConnectType.CT_WIFI;
        }
        if (networkInfo.getType() != 0) {
            return ConnectType.CT_GPRS_NET;
        }
        String proxyHost = getProxyHost();
        return (proxyHost == null || proxyHost.length() <= 0 || getProxyPort() <= 0) ? ConnectType.CT_GPRS_NET : ConnectType.CT_GPRS_WAP;
    }

    public static String getProxyHost() {
        return isLaterThanIcs() ? System.getProperty("http.proxyHost") : Proxy.getHost(AppContext.getAppContext());
    }

    public static int getProxyPort() {
        int i;
        if (isLaterThanIcs()) {
            try {
                i = Integer.parseInt(System.getProperty("http.proxyPort"));
            } catch (NumberFormatException unused) {
                return -1;
            }
        } else {
            i = Proxy.getPort(AppContext.getAppContext());
        }
        return i;
    }

    public static String getSSID() {
        try {
            WifiManager wifiManager = (WifiManager) AppContext.getAppContext().getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getSSID();
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static int getWIFISignalLevel(int i) {
        try {
            if (getNetworkType().value() != 2) {
                return -1;
            }
            WifiInfo connectionInfo = ((WifiManager) AppContext.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return WifiManager.calculateSignalLevel(connectionInfo.getRssi(), i);
            }
            return -1;
        } catch (Throwable th) {
            Log.m31487w(TAG, th);
        }
    }

    public static int gotoSystemNetworkSetting() {
        Intent intent = new Intent("android.settings.DATA_ROAMING_SETTINGS");
        intent.setComponent(new ComponentName("com.android.phone", "com.android.phone.Settings"));
        intent.setFlags(268435456);
        try {
            AppContext.getAppContext().startActivity(intent);
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean is2GNetWork() {
        NetworkInfo networkInfo;
        try {
            networkInfo = getActiveNetworkInfo();
        } catch (NullPointerException unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.getType() == 0 && (networkInfo.getSubtype() == 1 || networkInfo.getSubtype() == 4 || networkInfo.getSubtype() == 2);
    }

    public static boolean isLaterThanIcs() {
        return VERSION.SDK_INT >= 14;
    }

    public static boolean isNetworkAvaliable() {
        try {
            ConnectivityManager connectivityManager = getConnectivityManager();
            if (connectivityManager != null) {
                NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo != null) {
                    for (NetworkInfo state : allNetworkInfo) {
                        if (state.getState() == State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static boolean isRedirect(int i) {
        return (i >= 300 && i <= 303) || i == 307 || i == 308;
    }

    public static boolean isWifiActive() {
        NetworkInfo networkInfo;
        try {
            networkInfo = getActiveNetworkInfo();
        } catch (NullPointerException unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.getType() == 1;
    }
}
