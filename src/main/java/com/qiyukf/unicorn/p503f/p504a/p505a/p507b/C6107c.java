package com.qiyukf.unicorn.p503f.p504a.p505a.p507b;

import android.content.Context;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p498b.C5970a;
import com.qiyukf.unicorn.p503f.p504a.C6113c;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import org.json.JSONObject;

@C6112c(mo29054a = "qiyu_template_text")
/* renamed from: com.qiyukf.unicorn.f.a.a.b.c */
public class C6107c extends C5970a implements C6113c {
    @C6110a(mo29051a = "label")
    /* renamed from: a */
    private String f19093a;

    /* renamed from: a */
    public final String mo29035a(Context context) {
        return this.f19093a;
    }

    /* renamed from: a */
    public final void mo29046a(String str) {
        this.f19093a = str;
    }

    /* renamed from: c */
    public final JSONObject mo29047c() {
        JSONObject jSONObject = new JSONObject();
        C5366b.m22032a(jSONObject, "label", this.f19093a);
        C5366b.m22032a(jSONObject, "id", mo28537b());
        return jSONObject;
    }

    /* renamed from: d */
    public final String mo29048d() {
        return this.f19093a;
    }
}
