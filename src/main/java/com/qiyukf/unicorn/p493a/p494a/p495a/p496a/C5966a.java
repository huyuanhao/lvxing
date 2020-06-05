package com.qiyukf.unicorn.p493a.p494a.p495a.p496a;

import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6117d;
import org.json.JSONObject;

@C6111b(mo29052a = 203)
/* renamed from: com.qiyukf.unicorn.a.a.a.a.a */
public class C5966a extends C6144e {
    @C6110a(mo29051a = "type")
    /* renamed from: a */
    private String f18786a;
    @C6110a(mo29051a = "template")
    /* renamed from: b */
    private String f18787b;
    @C6110a(mo29051a = "extendInfo")
    /* renamed from: c */
    private String f18788c;
    /* renamed from: d */
    private C6117d f18789d;

    /* renamed from: a */
    public final String mo28514a() {
        return this.f18786a;
    }

    /* renamed from: a */
    public final void mo28515a(String str, Object obj) {
        JSONObject a = C5366b.m22027a(this.f18787b);
        if (a != null) {
            C5366b.m22031a(a, str, obj);
            this.f18787b = a.toString();
        }
    }

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f18788c)) {
            this.f18789d = new C6117d();
            this.f18789d.mo29073a(C5366b.m22027a(this.f18788c));
        }
    }

    /* renamed from: b */
    public final String mo28517b() {
        return this.f18787b;
    }
}
