package com.tencent.bugly.crashreport.crash.p603h5;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.h5.a */
public class C7200a {
    /* renamed from: a */
    public String f24248a = null;
    /* renamed from: b */
    public String f24249b = null;
    /* renamed from: c */
    public String f24250c = null;
    /* renamed from: d */
    public String f24251d = null;
    /* renamed from: e */
    public String f24252e = null;
    /* renamed from: f */
    public String f24253f = null;
    /* renamed from: g */
    public String f24254g = null;
    /* renamed from: h */
    public String f24255h = null;
    /* renamed from: i */
    public String f24256i = null;
    /* renamed from: j */
    public long f24257j = 0;
    /* renamed from: k */
    public long f24258k = 0;

    /* renamed from: a */
    public Map<String, String> mo34723a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.f24248a;
        if (str != null) {
            linkedHashMap.put("[JS] projectRoot", str);
        }
        String str2 = this.f24249b;
        if (str2 != null) {
            linkedHashMap.put("[JS] context", str2);
        }
        String str3 = this.f24250c;
        if (str3 != null) {
            linkedHashMap.put("[JS] url", str3);
        }
        String str4 = this.f24251d;
        if (str4 != null) {
            linkedHashMap.put("[JS] userAgent", str4);
        }
        String str5 = this.f24256i;
        if (str5 != null) {
            linkedHashMap.put("[JS] file", str5);
        }
        long j = this.f24257j;
        if (j != 0) {
            linkedHashMap.put("[JS] lineNumber", Long.toString(j));
        }
        return linkedHashMap;
    }
}
