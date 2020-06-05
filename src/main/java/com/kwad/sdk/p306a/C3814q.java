package com.kwad.sdk.p306a;

import java.util.Formatter;
import java.util.Locale;

/* renamed from: com.kwad.sdk.a.q */
public class C3814q {
    /* renamed from: a */
    public static String m15858a(long j) {
        Formatter format;
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        if (j5 > 0) {
            format = formatter.format("%d:%02d:%02d", new Object[]{Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)});
        } else {
            format = formatter.format("%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j3)});
        }
        return format.toString();
    }
}
