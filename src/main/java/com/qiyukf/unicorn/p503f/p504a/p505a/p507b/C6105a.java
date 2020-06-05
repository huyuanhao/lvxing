package com.qiyukf.unicorn.p503f.p504a.p505a.p507b;

import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p498b.C5970a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6084f.C6085a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6112c;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@C6112c(mo29054a = "qiyu_template_botForm")
/* renamed from: com.qiyukf.unicorn.f.a.a.b.a */
public class C6105a extends C5970a {
    @C6110a(mo29051a = "forms")
    /* renamed from: a */
    private List<C6085a> f19089a;

    /* renamed from: a */
    public final void mo29039a(List<C6085a> list) {
        this.f19089a = list;
    }

    /* renamed from: c */
    public final JSONObject mo29040c() {
        JSONObject jSONObject = new JSONObject();
        C5366b.m22032a(jSONObject, "id", mo28537b());
        JSONArray jSONArray = new JSONArray();
        for (C6085a aVar : this.f19089a) {
            JSONObject jSONObject2 = new JSONObject();
            C5366b.m22032a(jSONObject2, "label", aVar.mo28964c());
            C5366b.m22032a(jSONObject2, "type", aVar.mo28963b());
            C5366b.m22031a(jSONObject2, ArgKey.KEY_VALUE, aVar.mo28967f());
            C5366b.m22028a(jSONArray, (Object) jSONObject2);
        }
        C5366b.m22031a(jSONObject, "forms", (Object) jSONArray);
        return jSONObject;
    }

    /* renamed from: d */
    public final List<C6085a> mo29041d() {
        return this.f19089a;
    }
}
