package com.bytedance.sdk.p145a.p147b.p148a.p151c;

import com.bytedance.sdk.p145a.p147b.C1935u;
import com.bytedance.sdk.p145a.p147b.Cookie;
import com.bytedance.sdk.p145a.p147b.CookieJar;
import com.bytedance.sdk.p145a.p147b.HttpUrl;
import com.bytedance.sdk.p145a.p147b.Response;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.bytedance.sdk.a.b.a.c.e */
public final class HttpHeaders {
    /* renamed from: a */
    private static final Pattern f5424a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    /* renamed from: a */
    public static long m6993a(Response bVar) {
        return m6994a(bVar.mo13945f());
    }

    /* renamed from: a */
    public static long m6994a(C1935u uVar) {
        return m6995a(uVar.mo14071a("Content-Length"));
    }

    /* renamed from: a */
    private static long m6995a(String str) {
        long j = -1;
        if (str == null) {
            return -1;
        }
        try {
            j = Long.parseLong(str);
        } catch (NumberFormatException unused) {
        }
        return j;
    }

    /* renamed from: a */
    public static void m6996a(CookieJar pVar, HttpUrl vVar, C1935u uVar) {
        if (pVar != CookieJar.f5944a) {
            List a = Cookie.m7476a(vVar, uVar);
            if (!a.isEmpty()) {
                pVar.mo14037a(vVar, a);
            }
        }
    }

    /* renamed from: b */
    public static boolean m6998b(Response bVar) {
        if (bVar.mo13937a().mo13912b().equals("HEAD")) {
            return false;
        }
        int c = bVar.mo13941c();
        if (((c >= 100 && c < 200) || c == 204 || c == 304) && m6993a(bVar) == -1) {
            if ("chunked".equalsIgnoreCase(bVar.mo13938a("Transfer-Encoding"))) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static int m6992a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m6991a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != 9) {
                break;
            }
            i++;
        }
        return i;
    }

    /* renamed from: b */
    public static int m6997b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (parseLong < 0) {
                return 0;
            }
            i = (int) parseLong;
            return i;
        } catch (NumberFormatException unused) {
        }
    }
}
