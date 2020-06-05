package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.p306a.C3800e;
import com.kwad.sdk.p306a.C3812o;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.b */
public class C4313b implements C4321b {
    /* renamed from: a */
    private String f14174a;
    /* renamed from: b */
    private String f14175b;
    /* renamed from: c */
    private String f14176c;
    /* renamed from: d */
    private String f14177d;

    /* renamed from: a */
    public static C4313b m17618a() {
        C4313b bVar = new C4313b();
        bVar.f14174a = KsAdSDK.getAppId();
        bVar.f14175b = KsAdSDK.getAppName();
        Context context = KsAdSDK.getContext();
        if (context != null) {
            bVar.f14176c = context.getPackageName();
            bVar.f14177d = C3812o.m15844k(context);
        }
        return bVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C3800e.m15752a(jSONObject, "appId", this.f14174a);
        C3800e.m15752a(jSONObject, ArgKey.KEY_NAME, this.f14175b);
        C3800e.m15752a(jSONObject, Constants.FLAG_PACKAGE_NAME, this.f14176c);
        C3800e.m15752a(jSONObject, AppEntity.KEY_VERSION_STR, this.f14177d);
        return jSONObject;
    }
}
