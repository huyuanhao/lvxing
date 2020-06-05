package com.qiyukf.basesdk.p412c.p417d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

/* renamed from: com.qiyukf.basesdk.c.d.c */
public final class C5411c {
    /* renamed from: a */
    public static byte f17383a = 0;
    /* renamed from: b */
    private static final Uri f17384b = Uri.parse("content://telephony/carriers/preferapn");

    /* renamed from: a */
    public static int m22134a(Context context) {
        NetworkInfo k = m22144k(context);
        if (k == null) {
            return -1;
        }
        return k.getType();
    }

    /* renamed from: b */
    public static boolean m22135b(Context context) {
        NetworkInfo k = m22144k(context);
        if (k != null) {
            return k.isAvailable();
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m22136c(Context context) {
        NetworkInfo k = m22144k(context);
        if (k != null) {
            return k.isConnected();
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m22137d(Context context) {
        return !(m22139f(context) ? true : m22138e(context));
    }

    /* renamed from: e */
    public static boolean m22138e(Context context) {
        int i = m22142i(context);
        return i == 2 || i == 3;
    }

    /* renamed from: f */
    public static boolean m22139f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception unused) {
        }
    }

    /* renamed from: g */
    public static String m22140g(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getMacAddress() : "";
    }

    /* renamed from: h */
    public static String m22141h(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return activeNetworkInfo.getTypeName();
                }
                StringBuilder sb = new StringBuilder();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                sb.append(activeNetworkInfo.getTypeName());
                sb.append(" [");
                if (telephonyManager != null) {
                    sb.append(telephonyManager.getNetworkOperatorName());
                    sb.append("#");
                }
                sb.append(activeNetworkInfo.getSubtypeName());
                sb.append("]");
                return sb.toString();
            }
        }
        return "";
    }

    /* renamed from: i */
    public static int m22142i(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 1;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 2;
                        case 13:
                            return 3;
                        default:
                            return 0;
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    return 10;
                }
            }
        }
        return 0;
    }

    /* renamed from: j */
    public static String m22143j(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getSimOperator();
        }
        return null;
    }

    /* renamed from: k */
    private static NetworkInfo m22144k(Context context) {
        try {
            return ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }
}
