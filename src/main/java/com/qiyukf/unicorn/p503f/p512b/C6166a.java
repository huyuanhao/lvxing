package com.qiyukf.unicorn.p503f.p512b;

import android.text.TextUtils;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5314b;
import com.qiyukf.nimlib.p450b.C5725d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.qiyukf.unicorn.f.b.a */
public final class C6166a {
    /* renamed from: a */
    public static String m24464a() {
        int a = C5725d.m23052a();
        return a == 1 ? "http://qytest.netease.com" : a == 2 ? "http://qiyukf.netease.com" : "https://qy-swallow.qiyukf.com";
    }

    /* renamed from: a */
    public static String m24465a(String str, String str2, Map<String, String> map) {
        try {
            return C5314b.m21851b(m24471c(str, str2, map), "GET", "Common");
        } catch (IOException e) {
            throw new C6167b("get request error", e);
        }
    }

    /* renamed from: a */
    public static String m24466a(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        String str3 = "UTF-8";
        String c = m24471c(str, str2, map);
        try {
            HttpURLConnection a = C5314b.m21844a(c, "POST", "Common");
            C5314b.m21848a(a, "charset", str3);
            C5314b.m21848a(a, "Content-Type", "application/x-www-form-urlencoded");
            StringBuilder sb = new StringBuilder();
            for (Entry entry : map2.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append(URLEncoder.encode((String) entry.getValue()));
                }
            }
            C5314b.m21850a(a, sb.toString().getBytes(str3));
            int responseCode = a.getResponseCode();
            if (responseCode == 200) {
                return C5314b.m21842a(a.getInputStream());
            }
            StringBuilder sb2 = new StringBuilder("query url: ");
            sb2.append(c);
            sb2.append("failed: ");
            sb2.append(responseCode);
            C5264a.m21617a("HttpUtil", sb2.toString());
            return null;
        } catch (IOException e) {
            throw new C6167b("post form data error", e);
        }
    }

    /* renamed from: a */
    public static String m24467a(String str, Map<String, String> map) {
        return m24465a(m24468b(), str, map);
    }

    /* renamed from: b */
    private static String m24468b() {
        int a = C5725d.m23052a();
        return a == 1 ? "http://qytest.netease.com" : a == 2 ? "http://qiyukf.netease.com" : a == 3 ? "http://qydev.netease.com" : "https://nim.qiyukf.com";
    }

    /* renamed from: b */
    private static String m24469b(String str, String str2, Map<String, String> map) {
        try {
            return C5314b.m21851b(m24471c(str, str2, map), "POST", "Common");
        } catch (IOException e) {
            throw new C6167b("post request error", e);
        }
    }

    /* renamed from: b */
    public static String m24470b(String str, Map<String, String> map) {
        return m24469b(m24468b(), str, map);
    }

    /* renamed from: c */
    private static String m24471c(String str, String str2, Map<String, String> map) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        String sb2 = sb.toString();
        if (map != null) {
            int i = 0;
            for (Entry entry : map.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sb2);
                    sb3.append(i == 0 ? "?" : "&");
                    String sb4 = sb3.toString();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(sb4);
                    sb5.append((String) entry.getKey());
                    sb5.append("=");
                    sb5.append(URLEncoder.encode((String) entry.getValue()));
                    sb2 = sb5.toString();
                    i++;
                }
            }
        }
        StringBuilder sb6 = new StringBuilder("http request: ");
        sb6.append(str3);
        C5264a.m21620b("test", sb6.toString());
        return str3;
    }
}
