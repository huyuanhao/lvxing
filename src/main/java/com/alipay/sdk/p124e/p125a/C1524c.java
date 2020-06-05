package com.alipay.sdk.p124e.p125a;

import android.content.Context;
import com.alipay.sdk.p124e.C1526b;
import com.alipay.sdk.p124e.C1529e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.e.a.c */
public class C1524c extends C1529e {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo12173a(String str, JSONObject jSONObject) {
        return str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo12170a() throws JSONException {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo12174a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msp-gzip", String.valueOf(z));
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put("des-mode", "CBC");
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo12175c() throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put("api_name", "/sdk/log");
        hashMap.put("api_version", "1.0.0");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log_v", "1.0");
        return mo12187a(hashMap, hashMap2);
    }

    /* renamed from: a */
    public C1526b mo12172a(Context context, String str) throws Throwable {
        return mo12186a(context, str, "https://mcgw.alipay.com/sdklog.do", true);
    }
}
