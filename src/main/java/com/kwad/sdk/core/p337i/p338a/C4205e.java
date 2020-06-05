package com.kwad.sdk.core.p337i.p338a;

import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.a.e */
public class C4205e implements C4321b {
    /* renamed from: a */
    private final int f13980a;
    /* renamed from: b */
    private final String f13981b;

    public C4205e(int i, String str) {
        this.f13980a = i;
        this.f13981b = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15749a(jSONObject, ArgKey.KEY_RESULT, this.f13980a);
        C3800e.m15752a(jSONObject, "error_msg", this.f13981b);
        return jSONObject;
    }
}
