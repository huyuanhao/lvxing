package com.alipay.apmobilesecuritysdk.p106d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p105c.C1438a;
import com.alipay.apmobilesecuritysdk.p107e.C1450e;
import com.alipay.apmobilesecuritysdk.p107e.C1451f;
import com.alipay.apmobilesecuritysdk.p108f.C1455a;
import com.alipay.p109b.p110a.p111a.p112a.C1460a;
import com.alipay.p109b.p110a.p111a.p116d.C1476b;
import com.tencent.mid.api.MidEntity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.alipay.apmobilesecuritysdk.d.c */
public final class C1443c {
    /* renamed from: a */
    public static Map<String, String> m4175a(Context context) {
        C1476b a = C1476b.m4299a();
        HashMap hashMap = new HashMap();
        C1451f a2 = C1450e.m4197a(context);
        String a3 = a.mo12033a(context);
        String b = a.mo12035b(context);
        String k = a.mo12053k(context);
        String n = a.mo12059n(context);
        String m = a.mo12057m(context);
        if (a2 != null) {
            if (C1460a.m4260a(a3)) {
                a3 = a2.mo12007a();
            }
            if (C1460a.m4260a(b)) {
                b = a2.mo12009b();
            }
            if (C1460a.m4260a(k)) {
                k = a2.mo12011c();
            }
            if (C1460a.m4260a(n)) {
                n = a2.mo12013d();
            }
            if (C1460a.m4260a(m)) {
                m = a2.mo12015e();
            }
        }
        C1451f fVar = new C1451f(a3, b, k, n, m);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MidEntity.TAG_IMEI, fVar.mo12007a());
                jSONObject.put("imsi", fVar.mo12009b());
                jSONObject.put(MidEntity.TAG_MAC, fVar.mo12011c());
                jSONObject.put("bluetoothmac", fVar.mo12013d());
                jSONObject.put("gsi", fVar.mo12015e());
                String jSONObject2 = jSONObject.toString();
                C1455a.m4250a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                C1455a.m4249a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e) {
                C1438a.m4169a((Throwable) e);
            }
        }
        hashMap.put("AD1", a3);
        hashMap.put("AD2", b);
        hashMap.put("AD3", a.mo12043f(context));
        hashMap.put("AD5", a.mo12047h(context));
        hashMap.put("AD6", a.mo12049i(context));
        hashMap.put("AD7", a.mo12051j(context));
        hashMap.put("AD8", k);
        hashMap.put("AD9", a.mo12055l(context));
        hashMap.put("AD10", m);
        hashMap.put("AD11", a.mo12038d());
        hashMap.put("AD12", a.mo12040e());
        hashMap.put("AD13", a.mo12042f());
        hashMap.put("AD14", a.mo12046h());
        hashMap.put("AD15", a.mo12048i());
        hashMap.put("AD16", a.mo12050j());
        String str = "";
        hashMap.put("AD17", str);
        hashMap.put("AD18", n);
        hashMap.put("AD19", a.mo12061o(context));
        hashMap.put("AD20", a.mo12054l());
        hashMap.put("AD22", str);
        hashMap.put("AD23", a.mo12056m());
        hashMap.put("AD24", C1460a.m4268g(a.mo12045g(context)));
        hashMap.put("AD26", a.mo12041e(context));
        hashMap.put("AD27", a.mo12066s());
        hashMap.put("AD28", a.mo12070u());
        hashMap.put("AD29", a.mo12072w());
        hashMap.put("AD30", a.mo12068t());
        hashMap.put("AD31", a.mo12071v());
        hashMap.put("AD32", a.mo12063q());
        hashMap.put("AD33", a.mo12065r());
        hashMap.put("AD34", a.mo12067s(context));
        hashMap.put("AD35", a.mo12069t(context));
        hashMap.put("AD36", a.mo12064q(context));
        hashMap.put("AD37", a.mo12060o());
        hashMap.put("AD38", a.mo12058n());
        hashMap.put("AD39", a.mo12037c(context));
        hashMap.put("AD40", a.mo12039d(context));
        hashMap.put("AD41", a.mo12034b());
        hashMap.put("AD42", a.mo12036c());
        hashMap.put("AL3", a.mo12062p(context));
        return hashMap;
    }
}
