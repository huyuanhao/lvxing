package com.alipay.sdk.p124e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.app.C1502i;
import com.alipay.sdk.p123d.C1518a;
import com.alipay.sdk.p123d.C1518a.C1519a;
import com.alipay.sdk.p123d.C1518a.C1520b;
import com.alipay.sdk.p126f.C1531b;
import com.alipay.sdk.sys.C1536b;
import com.alipay.sdk.util.C1540c;
import com.alipay.sdk.util.C1542e;
import com.alipay.sdk.util.C1552n;
import com.alipay.sdk.util.C1553o;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.e.e */
public abstract class C1529e {
    /* renamed from: a */
    protected boolean f3901a = true;
    /* renamed from: b */
    protected boolean f3902b = true;

    /* renamed from: a */
    public abstract JSONObject mo12170a() throws JSONException;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo12171b() {
        return "4.9.0";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo12174a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msp-gzip", String.valueOf(z));
        hashMap.put("Operation-Type", "alipay.msp.cashier.dispatch.bytes");
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put("Version", "2.0");
        hashMap.put("AppId", "TAOBAO");
        hashMap.put("Msp-Param", C1521a.m4527a(str));
        hashMap.put("des-mode", "CBC");
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo12175c() throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put("device", Build.MODEL);
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put("api_name", "com.alipay.mcpay");
        hashMap.put("api_version", mo12171b());
        return mo12187a(hashMap, new HashMap<>());
    }

    /* renamed from: a */
    protected static JSONObject m4556a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo12173a(String str, JSONObject jSONObject) {
        C1536b a = C1536b.m4608a();
        C1531b a2 = C1531b.m4573a(a.mo12202b());
        JSONObject a3 = C1540c.m4627a(new JSONObject(), jSONObject);
        try {
            a3.put("tid", a2.mo12193a());
            a3.put("user_agent", a.mo12203c().mo12163a(a2));
            a3.put("has_alipay", C1553o.m4682b(a.mo12202b(), C1502i.f3836a));
            a3.put("has_msp_app", C1553o.m4674a(a.mo12202b()));
            a3.put("external_info", str);
            a3.put("app_key", "2014052600006128");
            a3.put("utdid", a.mo12204e());
            a3.put("new_client_key", a2.mo12195b());
            a3.put("pa", a.mo12203c().mo12162a(a.mo12202b()));
        } catch (Throwable th) {
            C1542e.m4633a(th);
        }
        return a3.toString();
    }

    /* renamed from: a */
    private static boolean m4557a(C1520b bVar) {
        return Boolean.valueOf(m4555a(bVar, "msp-gzip")).booleanValue();
    }

    /* renamed from: a */
    private static String m4555a(C1520b bVar, String str) {
        if (bVar == null || str == null || bVar.f3892a == null) {
            return null;
        }
        List list = (List) bVar.f3892a.get(str);
        if (list == null) {
            return null;
        }
        return TextUtils.join(StorageInterface.KEY_SPLITER, list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo12187a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
        }
        if (hashMap2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Entry entry2 : hashMap2.entrySet()) {
                jSONObject3.put((String) entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    /* renamed from: a */
    private boolean m4558a(String str) {
        String str2 = "params";
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has(str2)) {
                return false;
            }
            String optString = jSONObject.getJSONObject(str2).optString("public_key", null);
            if (!TextUtils.isEmpty(optString)) {
                C1536b.m4608a().mo12203c().mo12164a(optString);
                z = true;
            }
            return z;
        } catch (JSONException e) {
            C1542e.m4633a(e);
        }
    }

    /* renamed from: a */
    public C1526b mo12184a(Context context) throws Throwable {
        return mo12172a(context, "");
    }

    /* renamed from: a */
    public C1526b mo12172a(Context context, String str) throws Throwable {
        return mo12185a(context, str, C1552n.m4664a(context));
    }

    /* renamed from: a */
    public C1526b mo12185a(Context context, String str, String str2) throws Throwable {
        return mo12186a(context, str, str2, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1526b mo12186a(Context context, String str, String str2, boolean z) throws Throwable {
        StringBuilder sb = new StringBuilder();
        sb.append("PacketTask::request url >");
        sb.append(str2);
        C1542e.m4631a("", sb.toString());
        C1527c cVar = new C1527c(this.f3902b);
        C1528d a = cVar.mo12181a(new C1526b(mo12175c(), mo12173a(str, mo12170a())), this.f3901a);
        C1520b a2 = C1518a.m4522a(context, new C1519a(str2, mo12174a(a.mo12182a(), str), a.mo12183b()));
        if (a2 != null) {
            C1526b a3 = cVar.mo12180a(new C1528d(m4557a(a2), a2.f3894c));
            if (a3 == null || !m4558a(a3.mo12176a()) || !z) {
                return a3;
            }
            return mo12186a(context, str, str2, false);
        }
        throw new RuntimeException("Response is null.");
    }
}
