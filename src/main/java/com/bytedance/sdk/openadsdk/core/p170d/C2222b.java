package com.bytedance.sdk.openadsdk.core.p170d;

import com.bytedance.sdk.openadsdk.utils.C2564t;
import org.json.JSONObject;

/* compiled from: AppInfo */
/* renamed from: com.bytedance.sdk.openadsdk.core.d.b */
public class C2222b {
    /* renamed from: a */
    private String f7321a;
    /* renamed from: b */
    private String f7322b;
    /* renamed from: c */
    private String f7323c;
    /* renamed from: d */
    private int f7324d;
    /* renamed from: e */
    private int f7325e;
    /* renamed from: f */
    private int f7326f;
    /* renamed from: g */
    private String f7327g;

    /* renamed from: a */
    public String mo15339a() {
        return this.f7327g;
    }

    /* renamed from: a */
    public void mo15341a(String str) {
        this.f7327g = str;
    }

    /* renamed from: b */
    public String mo15342b() {
        return this.f7321a;
    }

    /* renamed from: b */
    public void mo15344b(String str) {
        this.f7321a = str;
    }

    /* renamed from: c */
    public String mo15345c() {
        return this.f7322b;
    }

    /* renamed from: c */
    public void mo15347c(String str) {
        this.f7322b = str;
    }

    /* renamed from: d */
    public String mo15348d() {
        return this.f7323c;
    }

    /* renamed from: d */
    public void mo15349d(String str) {
        this.f7323c = str;
    }

    /* renamed from: e */
    public int mo15350e() {
        return this.f7324d;
    }

    /* renamed from: a */
    public void mo15340a(int i) {
        this.f7324d = i;
    }

    /* renamed from: f */
    public int mo15351f() {
        return this.f7325e;
    }

    /* renamed from: b */
    public void mo15343b(int i) {
        this.f7325e = i;
    }

    /* renamed from: g */
    public int mo15352g() {
        return this.f7326f;
    }

    /* renamed from: c */
    public void mo15346c(int i) {
        this.f7326f = i;
    }

    /* renamed from: h */
    public JSONObject mo15353h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", mo15345c());
            jSONObject.put("app_size", mo15352g());
            jSONObject.put("comment_num", mo15351f());
            jSONObject.put("download_url", mo15342b());
            jSONObject.put("package_name", mo15348d());
            jSONObject.put("score", mo15350e());
        } catch (Exception e) {
            C2564t.m12219b(e.toString());
        }
        return jSONObject;
    }
}
