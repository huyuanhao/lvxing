package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* compiled from: NetworkUtils */
/* renamed from: com.bytedance.sdk.openadsdk.utils.w */
public class C2566w {
    /* renamed from: a */
    public static boolean m12241a(Context context) {
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
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static int m12243b(Context context) {
        int c = m12244c(context);
        if (c == 1) {
            return 0;
        }
        if (c == 4) {
            return 1;
        }
        if (c != 5) {
            return c;
        }
        return 4;
    }

    /* renamed from: c */
    public static int m12244c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
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
                            case 19:
                                return 5;
                            default:
                                String subtypeName = activeNetworkInfo.getSubtypeName();
                                if (TextUtils.isEmpty(subtypeName) || (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000"))) {
                                    return 1;
                                }
                                return 3;
                        }
                    } else if (type != 1) {
                        return 1;
                    } else {
                        return 4;
                    }
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    /* renamed from: d */
    public static boolean m12245d(Context context) {
        return m12244c(context) == 4;
    }

    /* renamed from: e */
    public static boolean m12246e(Context context) {
        return m12244c(context) == 5;
    }

    /* renamed from: f */
    public static String m12247f(Context context) {
        int c = m12244c(context);
        if (c == 2) {
            return "2g";
        }
        if (c == 3) {
            return "3g";
        }
        if (c != 4) {
            return c != 5 ? ArgKey.KEY_MOBILE : "4g";
        }
        return "wifi";
    }

    /* renamed from: a */
    public static boolean m12242a(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }
}
