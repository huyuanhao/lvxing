package com.ali.auth.third.p034ui.p037iv;

import com.ali.auth.third.core.model.C1027h;
import com.ali.auth.third.core.model.C1028i;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p030h.C1013c;
import com.ali.auth.third.core.util.C1034a;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.ui.iv.a */
public class C1078a {
    /* renamed from: a */
    public static void m2095a(String str, String str2, C1028i iVar) {
        C1027h hVar = new C1027h();
        hVar.f2048a = "mtop.alibaba.havanaappiv.getStrategyForNative";
        hVar.f2049b = "1.0";
        hVar.mo10372a("trustToken", str);
        hVar.mo10372a("validatorTags", str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", C0989a.m1884a());
            jSONObject.put("sdkVersion", C0989a.f1890e);
            jSONObject.put("appVersion", C1034a.m1985e());
            jSONObject.put("site", "0");
            hVar.mo10372a("ext", jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ((C1013c) C0989a.m1882a(C1013c.class)).mo10354a(hVar, String.class, iVar);
    }
}
