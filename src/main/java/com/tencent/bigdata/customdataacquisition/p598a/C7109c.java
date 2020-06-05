package com.tencent.bigdata.customdataacquisition.p598a;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.bigdata.customdataacquisition.p599b.C7112a;
import com.tencent.mid.core.Constants;

/* renamed from: com.tencent.bigdata.customdataacquisition.a.c */
public class C7109c {
    /* renamed from: a */
    private static String f23626a;
    /* renamed from: b */
    private static String f23627b;
    /* renamed from: c */
    private static String f23628c;
    /* renamed from: d */
    private static String f23629d;

    /* renamed from: a */
    public static String m30467a(Context context) {
        String str = "";
        String str2 = f23626a;
        if (str2 != null) {
            return str2;
        }
        try {
            if (C7112a.m30480a(context, Constants.PERMISSION_READ_PHONE_STATE)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f23626a = telephonyManager.getDeviceId();
                    if (f23626a != null) {
                        str = f23626a;
                    }
                    return str;
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getDeviceIMEI error");
            sb.append(th.toString());
            C7112a.m30484c(sb.toString());
        }
        return str;
    }

    /* renamed from: b */
    public static String m30468b(Context context) {
        String str = "";
        String str2 = f23627b;
        if (str2 != null) {
            return str2;
        }
        try {
            if (C7112a.m30480a(context, Constants.PERMISSION_READ_PHONE_STATE)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f23627b = telephonyManager.getSubscriberId();
                    if (f23627b != null) {
                        str = f23627b;
                    }
                    return str;
                }
            } else {
                C7112a.m30484c("Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("get subscriber id error:");
            sb.append(th.toString());
            C7112a.m30484c(sb.toString());
        }
        return str;
    }

    /* renamed from: c */
    public static String m30469c(Context context) {
        String str = "";
        String str2 = f23628c;
        if (str2 != null) {
            return str2;
        }
        try {
            if (C7112a.m30480a(context, Constants.PERMISSION_READ_PHONE_STATE)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f23628c = telephonyManager.getSimOperator();
                    if (f23628c != null) {
                        str = f23628c;
                    }
                    return str;
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getSimOperator error");
            sb.append(th.toString());
            C7112a.m30484c(sb.toString());
        }
        return str;
    }

    /* renamed from: d */
    public static String m30470d(Context context) {
        String str = "";
        String str2 = f23629d;
        if (str2 != null) {
            return str2;
        }
        try {
            f23629d = Secure.getString(context.getContentResolver(), "android_id");
            if (f23629d != null) {
                str = f23629d;
            }
            return str;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getAndroidId error");
            sb.append(th.toString());
            C7112a.m30484c(sb.toString());
            return str;
        }
    }
}
