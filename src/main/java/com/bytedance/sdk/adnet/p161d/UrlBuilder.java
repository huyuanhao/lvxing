package com.bytedance.sdk.adnet.p161d;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bytedance.sdk.adnet.d.i */
public class UrlBuilder {
    /* renamed from: a */
    private final Map<String, List<String>> f6321a;
    /* renamed from: b */
    private String f6322b;

    public UrlBuilder(String str) {
        this.f6321a = new LinkedHashMap();
        this.f6322b = str;
    }

    public UrlBuilder() {
        this.f6321a = new LinkedHashMap();
        this.f6322b = null;
    }

    /* renamed from: a */
    public void mo14396a(String str, int i) {
        List list = (List) this.f6321a.get(str);
        if (list == null) {
            list = new LinkedList();
        }
        list.add(String.valueOf(i));
        this.f6321a.put(str, list);
    }

    /* renamed from: a */
    public void mo14395a(String str, double d) {
        List list = (List) this.f6321a.get(str);
        if (list == null) {
            list = new LinkedList();
        }
        list.add(String.valueOf(d));
        this.f6321a.put(str, list);
    }

    /* renamed from: a */
    public void mo14397a(String str, String str2) {
        List list = (List) this.f6321a.get(str);
        if (list == null) {
            list = new LinkedList();
        }
        list.add(String.valueOf(str2));
        this.f6321a.put(str, list);
    }

    /* renamed from: a */
    public String mo14393a() {
        String str;
        StringBuilder sb;
        if (this.f6321a.isEmpty()) {
            return this.f6322b;
        }
        String a = mo14394a(this.f6321a, "UTF-8");
        String str2 = this.f6322b;
        if (!(str2 == null || str2.length() == 0)) {
            if (this.f6322b.indexOf(63) >= 0) {
                sb = new StringBuilder();
                sb.append(this.f6322b);
                str = "&";
            } else {
                sb = new StringBuilder();
                sb.append(this.f6322b);
                str = "?";
            }
            sb.append(str);
            sb.append(a);
            a = sb.toString();
        }
        return a;
    }

    /* renamed from: a */
    public String mo14394a(Map<String, List<String>> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            String b = m7960b((String) entry.getKey(), str);
            List<String> list = (List) entry.getValue();
            if (list != null && list.size() > 0) {
                for (String str2 : list) {
                    String b2 = str2 != null ? m7960b(str2, str) : "";
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(b);
                    if (!b2.isEmpty()) {
                        sb.append("=");
                        sb.append(b2);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private String m7960b(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String toString() {
        return mo14393a();
    }
}
