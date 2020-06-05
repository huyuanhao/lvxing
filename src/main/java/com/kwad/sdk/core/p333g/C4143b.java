package com.kwad.sdk.core.p333g;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p306a.C3803g.C3804a;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.g.b */
public class C4143b {
    /* renamed from: a */
    public static void m17115a(AdTemplate adTemplate) {
        m17127b(adTemplate, 4);
    }

    /* renamed from: a */
    public static void m17116a(AdTemplate adTemplate, int i) {
        C4163a aVar = new C4163a();
        aVar.f13887a = i;
        m17119a(adTemplate, 402, aVar, (JSONObject) null);
    }

    /* renamed from: a */
    public static void m17117a(AdTemplate adTemplate, int i, C3804a aVar) {
        C4163a aVar2 = new C4163a();
        aVar2.f13888b = i;
        if (aVar != null) {
            aVar2.f13891e = aVar;
        }
        m17119a(adTemplate, 2, aVar2, (JSONObject) null);
    }

    /* renamed from: a */
    public static void m17118a(AdTemplate adTemplate, int i, C3804a aVar, JSONObject jSONObject) {
        C4163a aVar2 = new C4163a();
        aVar2.f13888b = i;
        aVar2.f13891e = aVar;
        m17119a(adTemplate, 2, aVar2, jSONObject);
    }

    /* renamed from: a */
    private static void m17119a(final AdTemplate adTemplate, final int i, final C4163a aVar, final JSONObject jSONObject) {
        if (adTemplate != null) {
            new C4161l() {
                /* access modifiers changed from: protected */
                /* renamed from: d */
                public C4162m mo23795a() {
                    return new C4162m(adTemplate, i, aVar, jSONObject);
                }
            }.mo23797b();
        }
    }

    /* renamed from: a */
    public static void m17120a(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        C4163a aVar = new C4163a();
        aVar.f13889c = i;
        m17119a(adTemplate, 3, aVar, jSONObject);
    }

    /* renamed from: a */
    public static void m17121a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        C4163a aVar = new C4163a();
        aVar.f13892f = str;
        m17119a(adTemplate, i, aVar, jSONObject);
    }

    /* renamed from: a */
    public static void m17122a(AdTemplate adTemplate, C3804a aVar) {
        C4163a aVar2 = new C4163a();
        aVar2.f13891e = aVar;
        m17119a(adTemplate, 2, aVar2, (JSONObject) null);
    }

    /* renamed from: a */
    public static void m17123a(AdTemplate adTemplate, JSONObject jSONObject) {
        if (!adTemplate.mPvReported) {
            adTemplate.mPvReported = true;
            m17119a(adTemplate, 1, (C4163a) null, jSONObject);
        }
    }

    /* renamed from: a */
    public static void m17124a(AdTemplate adTemplate, JSONObject jSONObject, C3804a aVar, String str) {
        C4163a aVar2 = new C4163a();
        aVar2.f13891e = aVar;
        aVar2.f13892f = str;
        m17119a(adTemplate, 2, aVar2, jSONObject);
    }

    /* renamed from: a */
    public static void m17125a(AdTemplate adTemplate, JSONObject jSONObject, String str) {
        C4163a aVar = new C4163a();
        aVar.f13892f = str;
        m17119a(adTemplate, 2, aVar, jSONObject);
    }

    /* renamed from: b */
    public static void m17126b(AdTemplate adTemplate) {
        m17127b(adTemplate, 30);
    }

    /* renamed from: b */
    private static void m17127b(AdTemplate adTemplate, int i) {
        m17119a(adTemplate, i, (C4163a) null, new JSONObject());
    }

    /* renamed from: b */
    public static void m17128b(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        C4163a aVar = new C4163a();
        aVar.f13887a = i;
        m17119a(adTemplate, 402, aVar, jSONObject);
    }

    /* renamed from: b */
    public static void m17129b(AdTemplate adTemplate, JSONObject jSONObject) {
        m17134d(adTemplate, 33, jSONObject);
    }

    /* renamed from: c */
    public static void m17130c(AdTemplate adTemplate) {
        m17127b(adTemplate, 31);
    }

    /* renamed from: c */
    public static void m17131c(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        C4163a aVar = new C4163a();
        aVar.f13890d = i;
        m17119a(adTemplate, 140, aVar, jSONObject);
    }

    /* renamed from: c */
    public static void m17132c(AdTemplate adTemplate, JSONObject jSONObject) {
        m17134d(adTemplate, 34, jSONObject);
    }

    /* renamed from: d */
    public static void m17133d(AdTemplate adTemplate) {
        m17127b(adTemplate, 32);
    }

    /* renamed from: d */
    private static void m17134d(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        m17119a(adTemplate, i, (C4163a) null, jSONObject);
    }

    /* renamed from: d */
    public static void m17135d(AdTemplate adTemplate, JSONObject jSONObject) {
        m17134d(adTemplate, 31, jSONObject);
    }

    /* renamed from: e */
    public static void m17136e(AdTemplate adTemplate) {
        m17139f(adTemplate, null);
    }

    /* renamed from: e */
    public static void m17137e(AdTemplate adTemplate, JSONObject jSONObject) {
        m17134d(adTemplate, 35, jSONObject);
    }

    /* renamed from: f */
    public static void m17138f(AdTemplate adTemplate) {
        m17141g(adTemplate, null);
    }

    /* renamed from: f */
    public static void m17139f(AdTemplate adTemplate, JSONObject jSONObject) {
        m17134d(adTemplate, 399, jSONObject);
    }

    /* renamed from: g */
    public static void m17140g(AdTemplate adTemplate) {
        m17127b(adTemplate, 320);
    }

    /* renamed from: g */
    public static void m17141g(AdTemplate adTemplate, JSONObject jSONObject) {
        m17134d(adTemplate, 400, jSONObject);
    }

    /* renamed from: h */
    public static void m17142h(AdTemplate adTemplate) {
        m17127b(adTemplate, 321);
    }

    /* renamed from: h */
    public static void m17143h(AdTemplate adTemplate, JSONObject jSONObject) {
        m17134d(adTemplate, 501, jSONObject);
    }

    /* renamed from: i */
    public static void m17144i(AdTemplate adTemplate) {
        m17127b(adTemplate, 323);
    }

    /* renamed from: i */
    public static void m17145i(AdTemplate adTemplate, JSONObject jSONObject) {
        m17134d(adTemplate, TinkerReport.KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR, jSONObject);
    }

    /* renamed from: j */
    public static void m17146j(AdTemplate adTemplate) {
        m17127b(adTemplate, 50);
    }

    /* renamed from: j */
    public static void m17147j(AdTemplate adTemplate, JSONObject jSONObject) {
        m17134d(adTemplate, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, jSONObject);
    }

    /* renamed from: k */
    public static void m17148k(AdTemplate adTemplate) {
        m17127b(adTemplate, 51);
    }

    /* renamed from: l */
    public static void m17149l(AdTemplate adTemplate) {
        m17127b(adTemplate, 52);
    }

    /* renamed from: m */
    public static void m17150m(AdTemplate adTemplate) {
        m17119a(adTemplate, (int) OtherError.CONTAINER_INVISIBLE_ERROR, (C4163a) null, (JSONObject) null);
    }
}
