package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.kwad.sdk.core.videocache.d */
class C4348d {
    /* renamed from: d */
    private static final Pattern f14257d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    /* renamed from: e */
    private static final Pattern f14258e = Pattern.compile("GET /(.*) HTTP");
    /* renamed from: a */
    public final String f14259a;
    /* renamed from: b */
    public final long f14260b;
    /* renamed from: c */
    public final boolean f14261c;

    public C4348d(String str) {
        C4362j.m17805a(str);
        long a = m17750a(str);
        this.f14260b = Math.max(0, a);
        this.f14261c = a >= 0;
        this.f14259a = m17752b(str);
    }

    /* renamed from: a */
    private long m17750a(String str) {
        Matcher matcher = f14257d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1;
    }

    /* renamed from: a */
    public static C4348d m17751a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new C4348d(sb.toString());
            }
            sb.append(readLine);
            sb.append(10);
        }
    }

    /* renamed from: b */
    private String m17752b(String str) {
        Matcher matcher = f14258e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid request `");
        sb.append(str);
        sb.append("`: url not found!");
        throw new IllegalArgumentException(sb.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetRequest{rangeOffset=");
        sb.append(this.f14260b);
        sb.append(", partial=");
        sb.append(this.f14261c);
        sb.append(", uri='");
        sb.append(this.f14259a);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
