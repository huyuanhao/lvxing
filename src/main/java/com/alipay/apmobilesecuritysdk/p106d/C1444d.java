package com.alipay.apmobilesecuritysdk.p106d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p105c.C1439b;
import com.alipay.p109b.p110a.p111a.p116d.C1476b;
import com.alipay.p109b.p110a.p111a.p116d.C1478d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.alipay.apmobilesecuritysdk.d.d */
public final class C1444d {
    /* renamed from: a */
    public static synchronized Map<String, String> m4176a() {
        HashMap hashMap;
        synchronized (C1444d.class) {
            hashMap = new HashMap();
            String str = "AE16";
            try {
                new C1439b();
                hashMap.put(str, "");
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static synchronized Map<String, String> m4177a(Context context) {
        HashMap hashMap;
        synchronized (C1444d.class) {
            C1478d a = C1478d.m4348a();
            C1476b a2 = C1476b.m4299a();
            hashMap = new HashMap();
            hashMap.put("AE1", a.mo12075b());
            String str = "AE2";
            StringBuilder sb = new StringBuilder();
            sb.append(a.mo12076c() ? "1" : "0");
            hashMap.put(str, sb.toString());
            String str2 = "AE3";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.mo12074a(context) ? "1" : "0");
            hashMap.put(str2, sb2.toString());
            hashMap.put("AE4", a.mo12077d());
            hashMap.put("AE5", a.mo12078e());
            hashMap.put("AE6", a.mo12079f());
            hashMap.put("AE7", a.mo12080g());
            hashMap.put("AE8", a.mo12081h());
            hashMap.put("AE9", a.mo12082i());
            hashMap.put("AE10", a.mo12083j());
            hashMap.put("AE11", a.mo12084k());
            hashMap.put("AE12", a.mo12085l());
            hashMap.put("AE13", a.mo12086m());
            hashMap.put("AE14", a.mo12087n());
            hashMap.put("AE15", a.mo12088o());
            hashMap.put("AE21", a2.mo12044g());
        }
        return hashMap;
    }
}
