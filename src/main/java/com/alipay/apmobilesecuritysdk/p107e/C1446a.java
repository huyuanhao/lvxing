package com.alipay.apmobilesecuritysdk.p107e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p105c.C1438a;
import com.alipay.apmobilesecuritysdk.p108f.C1455a;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import discoveryAD.C7880W.C7881a;
import org.json.JSONObject;

/* renamed from: com.alipay.apmobilesecuritysdk.e.a */
public final class C1446a {
    /* renamed from: a */
    private static C1447b m4183a(String str) {
        try {
            if (C1460a.m4260a(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new C1447b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString(C7881a.TIMESTAMP));
        } catch (Exception e) {
            C1438a.m4169a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    public static synchronized void m4184a() {
        synchronized (C1446a.class) {
        }
    }

    /* renamed from: a */
    public static synchronized void m4185a(Context context) {
        synchronized (C1446a.class) {
            C1455a.m4249a(context, "vkeyid_profiles_v3", "deviceid", "");
            C1455a.m4250a("wxcasxx_v3", "wxcasxx", "");
        }
    }

    /* renamed from: a */
    public static synchronized void m4186a(Context context, C1447b bVar) {
        synchronized (C1446a.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", bVar.f3699a);
                jSONObject.put("deviceInfoHash", bVar.f3700b);
                jSONObject.put(C7881a.TIMESTAMP, bVar.f3701c);
                String jSONObject2 = jSONObject.toString();
                C1455a.m4249a(context, "vkeyid_profiles_v3", "deviceid", jSONObject2);
                C1455a.m4250a("wxcasxx_v3", "wxcasxx", jSONObject2);
            } catch (Exception e) {
                C1438a.m4169a((Throwable) e);
            }
        }
    }

    /* renamed from: b */
    public static synchronized C1447b m4187b() {
        synchronized (C1446a.class) {
            String a = C1455a.m4248a("wxcasxx_v3", "wxcasxx");
            if (C1460a.m4260a(a)) {
                return null;
            }
            C1447b a2 = m4183a(a);
            return a2;
        }
    }

    /* renamed from: b */
    public static synchronized C1447b m4188b(Context context) {
        C1447b a;
        synchronized (C1446a.class) {
            String a2 = C1455a.m4247a(context, "vkeyid_profiles_v3", "deviceid");
            if (C1460a.m4260a(a2)) {
                a2 = C1455a.m4248a("wxcasxx_v3", "wxcasxx");
            }
            a = m4183a(a2);
        }
        return a;
    }

    /* renamed from: c */
    public static synchronized C1447b m4189c(Context context) {
        synchronized (C1446a.class) {
            String a = C1455a.m4247a(context, "vkeyid_profiles_v3", "deviceid");
            if (C1460a.m4260a(a)) {
                return null;
            }
            C1447b a2 = m4183a(a);
            return a2;
        }
    }
}
