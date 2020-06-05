package com.kwad.sdk.core.request.p340a;

import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p318b.C4062b;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.a.a */
public abstract class C4257a implements C4258b {
    /* renamed from: a */
    private final Map<String, String> f14077a = new HashMap();
    /* renamed from: b */
    private final JSONObject f14078b = new JSONObject();

    protected C4257a() {
        mo23861b();
        mo23862c();
    }

    /* renamed from: a */
    public void mo24376a(String str, long j) {
        C3800e.m15750a(this.f14078b, str, j);
    }

    /* renamed from: a */
    public void mo24377a(String str, C4321b bVar) {
        C3800e.m15751a(this.f14078b, str, bVar);
    }

    /* renamed from: a */
    public void mo24378a(String str, String str2) {
        C3800e.m15752a(this.f14078b, str, str2);
    }

    /* renamed from: a */
    public void mo24379a(String str, List<? extends C4321b> list) {
        C3800e.m15753a(this.f14078b, str, list);
    }

    /* renamed from: a */
    public void mo24380a(String str, JSONArray jSONArray) {
        C3800e.m15754a(this.f14078b, str, jSONArray);
    }

    /* renamed from: a */
    public void mo24381a(String str, JSONObject jSONObject) {
        C3800e.m15755a(this.f14078b, str, jSONObject);
    }

    /* renamed from: b */
    public abstract void mo23861b();

    /* renamed from: c */
    public abstract void mo23862c();

    /* renamed from: e */
    public Map<String, String> mo24382e() {
        return this.f14077a;
    }

    /* renamed from: f */
    public final JSONObject mo24383f() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15752a(jSONObject, AppEntity.KEY_VERSION_STR, KsAdSDK.getSDKVersion());
        C3800e.m15752a(jSONObject, "message", C4062b.m16852a(this.f14078b.toString()));
        return jSONObject;
    }
}
