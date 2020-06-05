package com.alipay.sdk.p124e;

import android.text.TextUtils;

/* renamed from: com.alipay.sdk.e.a */
public class C1521a {
    /* renamed from: a */
    public static String m4527a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String[] split = str.split("&");
        if (split.length == 0) {
            return str2;
        }
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        for (String str7 : split) {
            if (TextUtils.isEmpty(str3)) {
                str3 = m4528b(str7);
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = m4529c(str7);
            }
            if (TextUtils.isEmpty(str5)) {
                str5 = m4530d(str7);
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = m4532f(str7);
            }
        }
        StringBuilder sb = new StringBuilder();
        String str8 = ";";
        if (!TextUtils.isEmpty(str3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("biz_type=");
            sb2.append(str3);
            sb2.append(str8);
            sb.append(sb2.toString());
        }
        if (!TextUtils.isEmpty(str4)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("biz_no=");
            sb3.append(str4);
            sb3.append(str8);
            sb.append(sb3.toString());
        }
        if (!TextUtils.isEmpty(str5)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("trade_no=");
            sb4.append(str5);
            sb4.append(str8);
            sb.append(sb4.toString());
        }
        if (!TextUtils.isEmpty(str6)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("app_userid=");
            sb5.append(str6);
            sb5.append(str8);
            sb.append(sb5.toString());
        }
        String sb6 = sb.toString();
        if (sb6.endsWith(str8)) {
            sb6 = sb6.substring(0, sb6.length() - 1);
        }
        return sb6;
    }

    /* renamed from: b */
    private static String m4528b(String str) {
        if (!str.contains("biz_type")) {
            return null;
        }
        return m4531e(str);
    }

    /* renamed from: c */
    private static String m4529c(String str) {
        if (!str.contains("biz_no")) {
            return null;
        }
        return m4531e(str);
    }

    /* renamed from: d */
    private static String m4530d(String str) {
        if (!str.contains("trade_no") || str.startsWith("out_trade_no")) {
            return null;
        }
        return m4531e(str);
    }

    /* renamed from: e */
    private static String m4531e(String str) {
        String[] split = str.split("=");
        if (split.length <= 1) {
            return null;
        }
        String str2 = split[1];
        String str3 = "\"";
        return str2.contains(str3) ? str2.replaceAll(str3, "") : str2;
    }

    /* renamed from: f */
    private static String m4532f(String str) {
        if (!str.contains("app_userid")) {
            return null;
        }
        return m4531e(str);
    }
}
