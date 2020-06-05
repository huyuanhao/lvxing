package com.kwad.sdk.core.p333g;

import android.text.TextUtils;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p326e.p327a.C4105a;
import com.kwad.sdk.core.request.ErrorCode;
import com.kwad.sdk.core.response.model.C4328c;
import com.kwad.sdk.core.response.p341a.C4320a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.g.d */
public abstract class C4146d extends C4105a<C4148e> {
    /* renamed from: a */
    private final C4147a f13830a;

    /* renamed from: com.kwad.sdk.core.g.d$a */
    public interface C4147a {
        /* renamed from: a */
        void mo23847a(long j);

        /* renamed from: a */
        void mo23848a(long j, String str);
    }

    public C4146d(C4147a aVar) {
        this.f13830a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23796a(C4148e eVar, C4320a aVar) {
        String str = "BatchReportNetwork";
        if (aVar == null) {
            C4065b.m16869d(str, "response is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("response.body=");
        sb.append(aVar.f14211b);
        C4065b.m16863a(str, sb.toString());
        if (TextUtils.isEmpty(aVar.f14211b)) {
            this.f13830a.mo23848a((long) aVar.f14210a, "http error.");
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(aVar.f14211b);
        } catch (JSONException e) {
            C4065b.m16865a(e);
            this.f13830a.mo23848a((long) ErrorCode.ERROR_DATA_PARSE_FAIL.errorCode, ErrorCode.ERROR_DATA_PARSE_FAIL.msg);
        }
        C4328c cVar = new C4328c();
        cVar.mo24469a(jSONObject);
        if (cVar.mo24472d()) {
            this.f13830a.mo23847a(cVar.mo24471c());
        } else {
            this.f13830a.mo23848a(cVar.mo24468a(), cVar.mo24470b());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23798c() {
        C4148e eVar = (C4148e) mo23795a();
        try {
            mo23796a(eVar, KsAdSDK.getProxyForHttp().doPost(eVar.mo23849a(), eVar.mo24382e(), eVar.mo24383f()));
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }
}
