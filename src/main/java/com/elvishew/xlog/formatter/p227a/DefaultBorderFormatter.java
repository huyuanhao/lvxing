package com.elvishew.xlog.formatter.p227a;

import com.elvishew.xlog.p224c.SystemCompat;

/* renamed from: com.elvishew.xlog.formatter.a.b */
public class DefaultBorderFormatter implements BorderFormatter {
    /* renamed from: a */
    public String mo17099a(String[] strArr) {
        String str = "";
        if (strArr == null || strArr.length == 0) {
            return str;
        }
        String[] strArr2 = new String[strArr.length];
        int i = 0;
        for (String str2 : strArr) {
            if (str2 != null) {
                int i2 = i + 1;
                strArr2[i] = str2;
                i = i2;
            }
        }
        if (i == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("╔═══════════════════════════════════════════════════════════════════════════════════════════════════");
        sb.append(SystemCompat.f9456a);
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(m12694a(strArr2[i3]));
            if (i3 != i - 1) {
                sb.append(SystemCompat.f9456a);
                sb.append("╟───────────────────────────────────────────────────────────────────────────────────────────────────");
                sb.append(SystemCompat.f9456a);
            } else {
                sb.append(SystemCompat.f9456a);
                sb.append("╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m12694a(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 10);
        String[] split = str.split(SystemCompat.f9456a);
        int length = split.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(SystemCompat.f9456a);
            }
            String str2 = split[i];
            sb.append(9553);
            sb.append(str2);
        }
        return sb.toString();
    }
}
