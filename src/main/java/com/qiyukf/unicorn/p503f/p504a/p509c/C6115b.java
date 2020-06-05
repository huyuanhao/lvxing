package com.qiyukf.unicorn.p503f.p504a.p509c;

import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p503f.p504a.C6070a;
import com.qiyukf.unicorn.p503f.p504a.C6109b;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.f.a.c.b */
public final class C6115b implements C6070a {
    @C6110a(mo29051a = "type")
    /* renamed from: a */
    private int f19099a;
    @C6110a(mo29051a = "messageInvite")
    /* renamed from: b */
    private String f19100b;
    @C6110a(mo29051a = "messageThanks")
    /* renamed from: c */
    private String f19101c;
    @C6110a(mo29051a = "list")
    /* renamed from: d */
    private List<C6116c> f19102d;
    @C6110a(mo29051a = "webappSort")
    /* renamed from: e */
    private int f19103e;
    @C6110a(mo29051a = "evaluation_timeout")
    /* renamed from: f */
    private long f19104f;
    @C6110a(mo29051a = "enable_evaluation_muttimes")
    /* renamed from: g */
    private boolean f19105g;
    @C6110a(mo29051a = "show_evaluation_button")
    /* renamed from: h */
    private boolean f19106h;
    /* renamed from: i */
    private transient JSONObject f19107i;

    /* renamed from: a */
    public static C6115b m24278a() {
        JSONObject jSONObject = new JSONObject();
        String string = C6029d.m24039c().getString(C5961R.string.ysf_evaluation_satisfied);
        String str = ArgKey.KEY_NAME;
        C5366b.m22032a(jSONObject, str, string);
        String str2 = ArgKey.KEY_VALUE;
        C5366b.m22029a(jSONObject, str2, 100);
        JSONObject jSONObject2 = new JSONObject();
        C5366b.m22032a(jSONObject2, str, C6029d.m24039c().getString(C5961R.string.ysf_evaluation_dissatisfied));
        C5366b.m22029a(jSONObject2, str2, 1);
        JSONArray jSONArray = new JSONArray();
        C5366b.m22028a(jSONArray, (Object) jSONObject);
        C5366b.m22028a(jSONArray, (Object) jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        C5366b.m22031a(jSONObject3, "list", (Object) jSONArray);
        C5366b.m22029a(jSONObject3, "type", 2);
        C5366b.m22037c(jSONObject, "evaluation_timeout");
        C5366b.m22033a(jSONObject, "enable_evaluation_muttimes");
        C5366b.m22033a(jSONObject, "session_end_switch");
        C5366b.m22033a(jSONObject, "session_open_switch");
        C5366b.m22033a(jSONObject, "session_timeout_switch");
        C6115b bVar = new C6115b();
        bVar.mo29058a(jSONObject3);
        return bVar;
    }

    /* renamed from: a */
    public final void mo29058a(JSONObject jSONObject) {
        this.f19107i = jSONObject;
        C6109b.m24269a((Object) this, jSONObject);
    }

    /* renamed from: b */
    public final JSONObject mo29059b() {
        return this.f19107i;
    }

    /* renamed from: c */
    public final int mo29060c() {
        return this.f19099a;
    }

    /* renamed from: d */
    public final String mo29061d() {
        return this.f19100b;
    }

    /* renamed from: e */
    public final String mo29062e() {
        return this.f19101c;
    }

    /* renamed from: f */
    public final List<C6116c> mo29063f() {
        return this.f19102d;
    }

    /* renamed from: g */
    public final Long mo29064g() {
        return Long.valueOf(this.f19104f);
    }

    /* renamed from: h */
    public final boolean mo29065h() {
        return this.f19105g;
    }

    /* renamed from: i */
    public final int mo29066i() {
        return this.f19103e;
    }

    /* renamed from: j */
    public final boolean mo29067j() {
        return this.f19106h;
    }
}
