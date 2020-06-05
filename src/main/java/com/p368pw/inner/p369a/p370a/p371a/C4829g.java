package com.p368pw.inner.p369a.p370a.p371a;

import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.p369a.p379e.C4958h;
import org.json.JSONObject;

/* renamed from: com.pw.inner.a.a.a.g */
public class C4829g {
    /* renamed from: a */
    private int f15549a;
    /* renamed from: b */
    private C4958h f15550b;
    /* renamed from: c */
    private C4828f f15551c;
    /* renamed from: d */
    private C4826d f15552d;

    public C4829g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                C5205o.m21462a("off em");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("off jsonstr = ");
            sb.append(str);
            C5205o.m21462a(sb.toString());
            JSONObject jSONObject = new JSONObject(str);
            this.f15549a = jSONObject.optInt("offer_type", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject != null) {
                this.f15550b = new C4958h(optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("native");
            if (optJSONObject2 != null) {
                this.f15551c = new C4828f(optJSONObject2.toString());
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("banner");
            if (optJSONObject3 != null) {
                this.f15552d = new C4826d(optJSONObject3.toString());
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public C4958h mo25833a() {
        return this.f15550b;
    }

    /* renamed from: b */
    public C4828f mo25834b() {
        return this.f15551c;
    }

    /* renamed from: c */
    public C4826d mo25835c() {
        return this.f15552d;
    }
}
