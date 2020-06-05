package com.bytedance.embedapplog.util;

import android.telephony.TelephonyManager;
import com.bytedance.embedapplog.AppLog;
import java.util.ArrayList;

/* renamed from: com.bytedance.embedapplog.util.e */
public class C1853e {
    /* renamed from: a */
    public static ArrayList<String> f5221a = new ArrayList<>();

    /* renamed from: a */
    public static String m6567a(TelephonyManager telephonyManager) {
        if (C1856h.f5226b) {
            C1856h.m6581a("SensitiveUtils gDI c", null);
        }
        return telephonyManager.getDeviceId();
    }

    /* renamed from: b */
    public static String m6569b(TelephonyManager telephonyManager) {
        if (C1856h.f5226b) {
            C1856h.m6581a("SensitiveUtils gSSN c", null);
        }
        return telephonyManager.getSimSerialNumber();
    }

    /* renamed from: c */
    public static String m6570c(TelephonyManager telephonyManager) {
        if (C1856h.f5226b) {
            C1856h.m6581a("SensitiveUtils gSI c", null);
        }
        return AppLog.getInitConfig() != null ? AppLog.getInitConfig().getSensitiveInfoProvider().getImsi() : "";
    }

    /* renamed from: d */
    public static String m6571d(TelephonyManager telephonyManager) {
        if (C1856h.f5226b) {
            C1856h.m6581a("SensitiveUtils gLN c", null);
        }
        return "";
    }

    /* renamed from: a */
    public static boolean m6568a(String str) {
        boolean z = !f5221a.contains(str);
        if (C1856h.f5226b) {
            StringBuilder sb = new StringBuilder();
            sb.append("SensitiveUtils allowed c ");
            sb.append(str);
            sb.append(" ");
            sb.append(z);
            C1856h.m6581a(sb.toString(), null);
        }
        return z;
    }
}
