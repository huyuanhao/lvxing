package com.bytedance.sdk.openadsdk.downloadnew.p181a.p183b;

import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.a.b.a */
public class LibEventExtra {
    /* renamed from: a */
    public MaterialMeta f8609a;
    /* renamed from: b */
    public String f8610b;
    /* renamed from: c */
    public String f8611c;
    /* renamed from: d */
    public JSONObject f8612d;

    /* renamed from: a */
    public static LibEventExtra m11189a() {
        return new LibEventExtra();
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    public static com.bytedance.sdk.openadsdk.downloadnew.p181a.p183b.LibEventExtra m11190a(org.json.JSONObject r5) {
        /*
        r0 = 0
        if (r5 != 0) goto L_0x0004
        return r0
    L_0x0004:
        java.lang.String r1 = "tag"
        java.lang.String r1 = r5.optString(r1, r0)     // Catch:{ Exception -> 0x0025 }
        java.lang.String r2 = "label"
        java.lang.String r2 = r5.optString(r2, r0)     // Catch:{ Exception -> 0x0023 }
        java.lang.String r3 = "extra"
        org.json.JSONObject r3 = r5.optJSONObject(r3)     // Catch:{ Exception -> 0x0021 }
        java.lang.String r4 = "material_meta"
        org.json.JSONObject r5 = r5.optJSONObject(r4)     // Catch:{ Exception -> 0x0028 }
        com.bytedance.sdk.openadsdk.core.d.k r0 = com.bytedance.sdk.openadsdk.core.AdInfoFactory.m9163a(r5)     // Catch:{ Exception -> 0x0028 }
        goto L_0x0028
    L_0x0021:
        r3 = r0
        goto L_0x0028
    L_0x0023:
        r2 = r0
        goto L_0x0027
    L_0x0025:
        r1 = r0
        r2 = r1
    L_0x0027:
        r3 = r2
    L_0x0028:
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a r5 = m11189a()
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a r5 = r5.mo16547a(r1)
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a r5 = r5.mo16548b(r2)
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a r5 = r5.mo16549b(r3)
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a r5 = r5.mo16546a(r0)
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.p181a.p183b.LibEventExtra.m11190a(org.json.JSONObject):com.bytedance.sdk.openadsdk.downloadnew.a.b.a");
    }

    /* renamed from: a */
    public LibEventExtra mo16546a(MaterialMeta kVar) {
        this.f8609a = kVar;
        return this;
    }

    /* renamed from: a */
    public LibEventExtra mo16547a(String str) {
        this.f8610b = str;
        return this;
    }

    /* renamed from: b */
    public LibEventExtra mo16548b(String str) {
        this.f8611c = str;
        return this;
    }

    /* renamed from: b */
    public LibEventExtra mo16549b(JSONObject jSONObject) {
        this.f8612d = jSONObject;
        return this;
    }

    /* renamed from: b */
    public JSONObject mo16550b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.f8610b);
            jSONObject.put("label", this.f8611c);
            if (this.f8612d != null) {
                jSONObject.put("extra", this.f8612d);
            }
            if (this.f8609a != null) {
                jSONObject.put("material_meta", this.f8609a.mo15459ae());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
