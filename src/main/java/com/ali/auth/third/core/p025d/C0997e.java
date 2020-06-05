package com.ali.auth.third.core.p025d;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.ali.auth.third.core.d.e */
public class C0997e {
    /* renamed from: a */
    public String f1934a;
    /* renamed from: b */
    public String f1935b;
    /* renamed from: c */
    public String f1936c;
    /* renamed from: d */
    public String f1937d;
    /* renamed from: e */
    public long f1938e;
    /* renamed from: f */
    public boolean f1939f;
    /* renamed from: g */
    public boolean f1940g;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1936c);
        sb.append("=");
        sb.append(this.f1937d);
        String str = "; ";
        sb.append(str);
        sb.append("Domain=");
        sb.append(this.f1934a);
        if (this.f1938e > 0) {
            sb.append(str);
            sb.append("Expires=");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            sb.append(simpleDateFormat.format(Long.valueOf(this.f1938e)));
        }
        sb.append(str);
        sb.append("Path=");
        sb.append(this.f1935b);
        if (this.f1939f) {
            sb.append(str);
            sb.append("Secure");
        }
        if (this.f1940g) {
            sb.append(str);
            sb.append("HttpOnly");
        }
        return sb.toString();
    }
}
