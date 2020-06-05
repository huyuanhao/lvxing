package com.alibaba.alibclinkpartner.smartlink.p042b;

import android.util.Log;

/* renamed from: com.alibaba.alibclinkpartner.smartlink.b.b */
public class ALSLLogUtil {
    /* renamed from: a */
    public static boolean f2233a = false;

    /* renamed from: a */
    public static void m2123a(String str, String str2, String str3) {
        if (f2233a) {
            StringBuilder sb = new StringBuilder();
            sb.append("class = ");
            sb.append(str);
            sb.append(" === method: ");
            sb.append(str2);
            sb.append("\n");
            sb.append("errMsg = ");
            sb.append(str3);
            Log.e("alsl", sb.toString());
        }
    }

    /* renamed from: b */
    public static void m2124b(String str, String str2, String str3) {
        if (f2233a) {
            StringBuilder sb = new StringBuilder();
            sb.append("class = ");
            sb.append(str);
            sb.append(" === method: ");
            sb.append(str2);
            sb.append("\n");
            sb.append("debugMsg = ");
            sb.append(str3);
            Log.i("alsl", sb.toString());
        }
    }
}
