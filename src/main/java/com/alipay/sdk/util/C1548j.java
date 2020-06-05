package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.C1505a;
import com.p522qq.p523e.comm.constants.Constants.KEYS;

/* renamed from: com.alipay.sdk.util.j */
public class C1548j {
    /* renamed from: a */
    public static void m4652a(Context context, String str) {
        try {
            String a = m4651a(str);
            StringBuilder sb = new StringBuilder();
            sb.append("PayResultUtil::saveTradeToken > tradeToken:");
            sb.append(a);
            C1542e.m4631a("", sb.toString());
            if (!TextUtils.isEmpty(a)) {
                C1549k.m4655a(context, "pref_trade_token", a);
            }
        } catch (Throwable th) {
            C1505a.m4453a(KEYS.BIZ, "SaveTradeTokenError", th);
            C1542e.m4633a(th);
        }
    }

    /* renamed from: a */
    public static String m4651a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(";");
        String str2 = null;
        int i = 0;
        while (i < split.length) {
            if (split[i].startsWith("result={") && split[i].endsWith("}")) {
                String[] split2 = split[i].substring(8, split[i].length() - 1).split("&");
                int i2 = 0;
                while (true) {
                    if (i2 < split2.length) {
                        if (split2[i2].startsWith("trade_token=\"") && split2[i2].endsWith("\"")) {
                            str2 = split2[i2].substring(13, split2[i2].length() - 1);
                            break;
                        } else if (split2[i2].startsWith("trade_token=")) {
                            str2 = split2[i2].substring(12);
                            break;
                        } else {
                            i2++;
                        }
                    } else {
                        break;
                    }
                }
            }
            i++;
        }
        return str2;
    }

    /* renamed from: a */
    public static String m4650a(Context context) {
        String str = "";
        String b = C1549k.m4656b(context, "pref_trade_token", str);
        StringBuilder sb = new StringBuilder();
        sb.append("PayResultUtil::fetchTradeToken > tradeToken:");
        sb.append(b);
        C1542e.m4631a(str, sb.toString());
        return b;
    }
}
