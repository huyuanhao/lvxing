package btmsdkobf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;

/* renamed from: btmsdkobf.h */
public class C0871h {
    public static NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) C0652cl.m85D().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            C0848ff.m906e("NetworkUtil", th.toString());
            return null;
        }
    }

    public static String getSSID() {
        try {
            WifiManager wifiManager = (WifiManager) C0652cl.m85D().getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getSSID();
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getSSID: ");
            sb.append(th);
            C0848ff.m906e("WifiUtil", sb.toString());
        }
        return "";
    }

    /* renamed from: j */
    public static C0651ck m967j() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) C0652cl.m85D().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            C0848ff.m908w("getActiveNetworkInfo", th.getMessage());
            networkInfo = null;
        }
        if (networkInfo == null) {
            return C0651ck.f409fU;
        }
        if (networkInfo.getType() == 1) {
            return C0651ck.f411fW;
        }
        if (networkInfo.getType() != 0) {
            return C0651ck.f413fY;
        }
        String k = m968k();
        return (k == null || k.length() <= 0 || m969l() <= 0) ? C0651ck.f413fY : C0651ck.f412fX;
    }

    /* renamed from: k */
    public static String m968k() {
        return VERSION.SDK_INT >= 14 ? System.getProperty("http.proxyHost") : Proxy.getHost(C0652cl.m85D());
    }

    /* renamed from: l */
    public static int m969l() {
        int i;
        if (VERSION.SDK_INT >= 14) {
            try {
                i = Integer.parseInt(System.getProperty("http.proxyPort"));
            } catch (NumberFormatException unused) {
                return -1;
            }
        } else {
            i = Proxy.getPort(C0652cl.m85D());
        }
        return i;
    }

    /* renamed from: m */
    public static boolean m970m() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) C0652cl.m85D().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            C0848ff.m906e("NetworkUtil", th.toString());
            networkInfo = null;
        }
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isConnected();
    }

    /* renamed from: n */
    public static int m971n() {
        Context D = C0652cl.m85D();
        if (!C0850fh.f989og) {
            C0850fh.f989og = false;
            C0850fh.m921v(D);
        }
        switch (C0850fh.f993ok) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 15;
            case 16:
                return 16;
            default:
                return 0;
        }
    }

    /* renamed from: o */
    public static boolean m972o() {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) C0652cl.m85D().getSystemService("connectivity")).getNetworkInfo(1);
            return networkInfo != null && networkInfo.isConnected();
        } catch (Exception unused) {
        }
    }
}
