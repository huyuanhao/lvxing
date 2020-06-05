package com.qiyukf.unicorn.p503f.p504a.p505a.p507b;

import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p498b.C5970a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import org.json.JSONObject;

@C6112c(mo29054a = "qiyu_template_mixReply")
/* renamed from: com.qiyukf.unicorn.f.a.a.b.b */
public class C6106b extends C5970a {
    @C6110a(mo29051a = "label")
    /* renamed from: a */
    private String f19090a;
    @C6110a(mo29051a = "type")
    /* renamed from: b */
    private String f19091b;
    /* renamed from: c */
    private transient JSONObject f19092c;

    /* renamed from: a */
    public final void mo29042a(String str) {
        this.f19090a = str;
    }

    /* renamed from: b */
    public final void mo29043b(String str) {
        this.f19091b = str;
    }

    /* renamed from: c */
    public final String mo29044c() {
        return this.f19090a;
    }

    /* renamed from: d */
    public final JSONObject mo29045d() {
        JSONObject jSONObject = this.f19092c;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C5366b.m22032a(jSONObject, "id", mo28537b());
        C5366b.m22032a(jSONObject, "label", this.f19090a);
        return jSONObject;
    }
}
