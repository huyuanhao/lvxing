package com.qiyukf.unicorn.p503f.p504a.p511e;

import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p453d.p459b.p460a.C5764b;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import org.json.JSONObject;

@C6111b(mo29052a = 4000)
/* renamed from: com.qiyukf.unicorn.f.a.e.a */
public final class C6145a extends C6144e {
    @C6110a(mo29051a = "appKey")
    /* renamed from: a */
    private String f19209a = C5718b.m23020g();
    @C6110a(mo29051a = "terminal")
    /* renamed from: b */
    private int f19210b = 1;
    @C6110a(mo29051a = "version")
    /* renamed from: c */
    private int f19211c;
    @C6110a(mo29051a = "sid")
    /* renamed from: d */
    private Long f19212d;
    @C6110a(mo29051a = "type")
    /* renamed from: e */
    private String f19213e;
    @C6110a(mo29051a = "prop")
    /* renamed from: f */
    private JSONObject f19214f;

    public C6145a() {
        if (C5718b.m23009a() != null) {
            this.f19211c = C5764b.m23176i(C5718b.m23009a());
        }
    }

    /* renamed from: a */
    public final void mo29176a(Long l) {
        this.f19212d = l;
    }

    /* renamed from: a */
    public final void mo29177a(String str) {
        this.f19213e = str;
    }

    /* renamed from: a */
    public final void mo29178a(JSONObject jSONObject) {
        this.f19214f = jSONObject;
    }
}
