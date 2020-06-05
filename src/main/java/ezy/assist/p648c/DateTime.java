package ezy.assist.p648c;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: ezy.assist.c.b */
public class DateTime {
    /* renamed from: a */
    public static TimeZone f27272a = TimeZone.getTimeZone("GMT+0");
    /* renamed from: b */
    public static TimeZone f27273b = TimeZone.getTimeZone("GMT+8");
    /* renamed from: c */
    private static SimpleDateFormat f27274c = new SimpleDateFormat();

    /* renamed from: a */
    public static String m34799a(long j) {
        return m34801a("HH:mm", new Date(j));
    }

    /* renamed from: a */
    public static String m34800a(String str, long j) {
        return m34801a(str, new Date(j));
    }

    /* renamed from: a */
    public static String m34801a(String str, Date date) {
        return m34802a(str, date, f27273b);
    }

    /* renamed from: a */
    public static String m34802a(String str, Date date, TimeZone timeZone) {
        String format;
        synchronized (f27274c) {
            f27274c.setTimeZone(timeZone);
            f27274c.applyPattern(str);
            format = f27274c.format(date);
        }
        return format;
    }
}
