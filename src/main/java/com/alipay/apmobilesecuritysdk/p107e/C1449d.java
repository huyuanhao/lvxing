package com.alipay.apmobilesecuritysdk.p107e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p105c.C1438a;
import com.alipay.apmobilesecuritysdk.p108f.C1455a;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import discoveryAD.C7880W.C7881a;
import org.json.JSONObject;

/* renamed from: com.alipay.apmobilesecuritysdk.e.d */
public final class C1449d {
    /* renamed from: a */
    private static C1448c m4190a(String str) {
        try {
            if (C1460a.m4260a(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            C1448c cVar = new C1448c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString(C7881a.TIMESTAMP), jSONObject.optString("tid"), jSONObject.optString("utdid"));
            return cVar;
        } catch (Exception e) {
            C1438a.m4169a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    public static synchronized void m4191a() {
        synchronized (C1449d.class) {
        }
    }

    /* renamed from: a */
    public static synchronized void m4192a(Context context) {
        synchronized (C1449d.class) {
            C1455a.m4249a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
            C1455a.m4250a("wxcasxx_v4", "key_wxcasxx_v4", "");
        }
    }

    /* renamed from: a */
    public static synchronized void m4193a(Context context, C1448c cVar) {
        synchronized (C1449d.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", cVar.f3702a);
                jSONObject.put("deviceInfoHash", cVar.f3703b);
                jSONObject.put(C7881a.TIMESTAMP, cVar.f3704c);
                jSONObject.put("tid", cVar.f3705d);
                jSONObject.put("utdid", cVar.f3706e);
                String jSONObject2 = jSONObject.toString();
                C1455a.m4249a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                C1455a.m4250a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
            } catch (Exception e) {
                C1438a.m4169a((Throwable) e);
            }
        }
    }

    /* renamed from: b */
    public static synchronized C1448c m4194b() {
        synchronized (C1449d.class) {
            String a = C1455a.m4248a("wxcasxx_v4", "key_wxcasxx_v4");
            if (C1460a.m4260a(a)) {
                return null;
            }
            C1448c a2 = m4190a(a);
            return a2;
        }
    }

    /* renamed from: b */
    public static synchronized C1448c m4195b(Context context) {
        C1448c a;
        synchronized (C1449d.class) {
            String a2 = C1455a.m4247a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (C1460a.m4260a(a2)) {
                a2 = C1455a.m4248a("wxcasxx_v4", "key_wxcasxx_v4");
            }
            a = m4190a(a2);
        }
        return a;
    }

    /* renamed from: c */
    public static synchronized C1448c m4196c(Context context) {
        synchronized (C1449d.class) {
            String a = C1455a.m4247a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (C1460a.m4260a(a)) {
                return null;
            }
            C1448c a2 = m4190a(a);
            return a2;
        }
    }
}
