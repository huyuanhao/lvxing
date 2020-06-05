package okhttp3.internal.p698b;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import okhttp3.internal.C8417c;

/* compiled from: HttpDate */
/* renamed from: okhttp3.internal.b.d */
public final class C8407d {
    /* renamed from: a */
    private static final ThreadLocal<DateFormat> f28501a = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(C8417c.f28534g);
            return simpleDateFormat;
        }
    };
    /* renamed from: b */
    private static final String[] f28502b = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    /* renamed from: c */
    private static final DateFormat[] f28503c = new DateFormat[f28502b.length];

    /* renamed from: a */
    public static Date m35973a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = ((DateFormat) f28501a.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f28502b) {
            int length = f28502b.length;
            for (int i = 0; i < length; i++) {
                DateFormat dateFormat = f28503c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f28502b[i], Locale.US);
                    dateFormat.setTimeZone(C8417c.f28534g);
                    f28503c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m35972a(Date date) {
        return ((DateFormat) f28501a.get()).format(date);
    }
}
