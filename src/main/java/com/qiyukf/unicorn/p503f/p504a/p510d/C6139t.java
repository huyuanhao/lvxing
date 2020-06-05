package com.qiyukf.unicorn.p503f.p504a.p510d;

import android.text.TextUtils;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import org.json.JSONArray;
import org.json.JSONObject;

@C6111b(mo29052a = 42)
/* renamed from: com.qiyukf.unicorn.f.a.d.t */
public class C6139t extends C6144e {
    @C6110a(mo29051a = "sessionId")
    /* renamed from: a */
    private long f19200a;
    @C6110a(mo29051a = "msgIdClient")
    /* renamed from: b */
    private String f19201b;
    @C6110a(mo29051a = "trashWords")
    /* renamed from: c */
    private transient JSONArray f19202c;
    @C6110a(mo29051a = "auditResult")
    /* renamed from: d */
    private int f19203d;
    /* renamed from: e */
    private String f19204e;

    /* renamed from: a */
    public final boolean mo29166a() {
        return this.f19200a > 0 && !TextUtils.isEmpty(this.f19204e);
    }

    /* access modifiers changed from: protected */
    public void afterParse(JSONObject jSONObject) {
        try {
            this.f19204e = this.f19201b.substring(this.f19201b.indexOf(35) + 1);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public final String mo29167b() {
        return this.f19204e;
    }

    /* renamed from: c */
    public final JSONArray mo29168c() {
        return this.f19202c;
    }

    /* renamed from: d */
    public final int mo29169d() {
        return this.f19203d;
    }
}
