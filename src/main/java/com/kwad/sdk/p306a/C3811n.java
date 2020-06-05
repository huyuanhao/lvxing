package com.kwad.sdk.p306a;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.kwad.sdk.a.n */
public class C3811n {
    /* renamed from: a */
    private static final SimpleDateFormat f12924a = new SimpleDateFormat("MM/dd", Locale.US);
    /* renamed from: b */
    private static final SimpleDateFormat f12925b = new SimpleDateFormat("yyyy/MM/dd", Locale.US);

    /* renamed from: a */
    public static String m15808a(long j) {
        String format;
        synchronized (f12924a) {
            format = f12924a.format(new Date(j));
        }
        return format;
    }

    /* renamed from: a */
    public static String m15809a(long j, String str) {
        return j <= 0 ? str : m15815c(j);
    }

    /* renamed from: a */
    public static String m15810a(Context context, long j) {
        if (j < 0) {
            return "";
        }
        context.getResources();
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - j);
        if (abs < 60000) {
            return "刚刚";
        }
        String str = abs < 3600000 ? String.format("%d分钟前", new Object[]{Integer.valueOf((int) (abs / 60000))}) : abs < 86400000 ? String.format("%d小时前", new Object[]{Integer.valueOf((int) (abs / 3600000))}) : abs < 604800000 ? String.format("%d天前", new Object[]{Integer.valueOf((int) (abs / 86400000))}) : m15811a(currentTimeMillis, j) ? m15808a(j) : m15813b(j);
        return str;
    }

    /* renamed from: a */
    public static boolean m15811a(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        instance.setTimeInMillis(j2);
        return i == instance.get(1);
    }

    /* renamed from: a */
    public static boolean m15812a(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }

    /* renamed from: b */
    public static String m15813b(long j) {
        String format;
        synchronized (f12925b) {
            format = f12925b.format(new Date(j));
        }
        return format;
    }

    /* renamed from: b */
    public static boolean m15814b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches(".*\\.kpg.*");
        }
        return false;
    }

    /* renamed from: c */
    private static String m15815c(long j) {
        if (j <= 9999) {
            return String.valueOf(j);
        }
        float f = ((float) j) / 10000.0f;
        if (f >= 1000.0f) {
            return "999.9w";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f);
        sb.append("");
        return String.format("%.1fw", new Object[]{Double.valueOf(new BigDecimal(sb.toString()).setScale(1, 4).doubleValue())});
    }

    /* renamed from: c */
    public static String m15816c(String str) {
        return !TextUtils.isEmpty(str) ? str.trim().replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1") : "";
    }
}
