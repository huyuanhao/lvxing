package com.kwad.sdk.core.p337i.p338a;

import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.a.f */
public class C4206f implements C4321b {
    /* renamed from: a */
    public final int f13982a = 1;
    /* renamed from: b */
    public final C4321b f13983b;

    public C4206f(C4321b bVar) {
        this.f13983b = bVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15749a(jSONObject, ArgKey.KEY_RESULT, this.f13982a);
        C3800e.m15751a(jSONObject, "data", this.f13983b);
        return jSONObject;
    }
}
