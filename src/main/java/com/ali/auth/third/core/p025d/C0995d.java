package com.ali.auth.third.core.p025d;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.ali.auth.third.core.d.d */
public class C0995d {
    /* renamed from: a */
    private static final Pattern f1929a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
    /* renamed from: b */
    private static final Pattern f1930b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    /* renamed from: com.ali.auth.third.core.d.d$a */
    private static class C0996a {
        /* renamed from: a */
        int f1931a;
        /* renamed from: b */
        int f1932b;
        /* renamed from: c */
        int f1933c;

        C0996a(int i, int i2, int i3) {
            this.f1931a = i;
            this.f1932b = i2;
            this.f1933c = i3;
        }
    }

    /* renamed from: a */
    public static long m1903a(String str) throws IllegalArgumentException {
        int i;
        int i2;
        int i3;
        C0996a aVar;
        int i4;
        int i5;
        int i6;
        Matcher matcher = f1929a.matcher(str);
        if (matcher.find()) {
            int b = m1904b(matcher.group(1));
            int c = m1905c(matcher.group(2));
            int d = m1906d(matcher.group(3));
            aVar = m1907e(matcher.group(4));
            i2 = c;
            i3 = b;
            i = d;
        } else {
            Matcher matcher2 = f1930b.matcher(str);
            if (matcher2.find()) {
                int c2 = m1905c(matcher2.group(1));
                int b2 = m1904b(matcher2.group(2));
                C0996a e = m1907e(matcher2.group(3));
                i = m1906d(matcher2.group(4));
                i2 = c2;
                i3 = b2;
                aVar = e;
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (i >= 2038) {
            i6 = 1;
            i5 = 0;
            i4 = 2038;
        } else {
            i4 = i;
            i6 = i3;
            i5 = i2;
        }
        Time time = new Time("UTC");
        time.set(aVar.f1933c, aVar.f1932b, aVar.f1931a, i6, i5, i4);
        return time.toMillis(false);
    }

    /* renamed from: b */
    private static int m1904b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    /* renamed from: c */
    private static int m1905c(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        int i = 9;
        if (lowerCase == 9) {
            return 11;
        }
        if (lowerCase == 10) {
            return 1;
        }
        if (lowerCase == 22) {
            return 0;
        }
        if (lowerCase == 26) {
            return 7;
        }
        if (lowerCase == 29) {
            return 2;
        }
        if (lowerCase == 32) {
            return 3;
        }
        if (lowerCase == 40) {
            return 6;
        }
        if (lowerCase == 42) {
            return 5;
        }
        if (lowerCase == 48) {
            return 10;
        }
        switch (lowerCase) {
            case 35:
                break;
            case 36:
                i = 4;
                break;
            case 37:
                return 8;
            default:
                throw new IllegalArgumentException();
        }
        return i;
    }

    /* renamed from: d */
    private static int m1906d(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + 1900 : charAt + 2000;
        } else if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        } else {
            if (str.length() == 4) {
                return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
            }
            return 1970;
        }
    }

    /* renamed from: e */
    private static C0996a m1907e(String str) {
        int i;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            i = 2;
            charAt = (charAt * 10) + (str.charAt(1) - '0');
        } else {
            i = 1;
        }
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = i3 + 1 + 1;
        return new C0996a(charAt, ((str.charAt(i2) - '0') * 10) + (str.charAt(i3) - '0'), ((str.charAt(i4) - '0') * 10) + (str.charAt(i4 + 1) - '0'));
    }
}
