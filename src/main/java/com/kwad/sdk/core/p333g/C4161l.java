package com.kwad.sdk.core.p333g;

import com.ksad.download.p297c.C3607b;
import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p326e.p327a.C4105a;
import com.kwad.sdk.core.response.p341a.C4320a;

/* renamed from: com.kwad.sdk.core.g.l */
public abstract class C4161l extends C4105a<C4162m> {
    /* renamed from: a */
    private void m17232a(C4162m mVar) {
        try {
            for (String doGet : mVar.mo23863d()) {
                KsAdSDK.getProxyForHttp().doGet(doGet, null);
            }
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23796a(C4162m mVar, C4320a aVar) {
    }

    /* renamed from: b */
    public void mo23797b() {
        if (!C3607b.m15045a(KsAdSDK.getContext())) {
            C4065b.m16869d("ReportNetwork", "no network while report log");
        } else {
            super.mo23797b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23798c() {
        String str;
        C4162m mVar = (C4162m) mo23795a();
        try {
            C4320a doGet = KsAdSDK.getProxyForHttp().doGet(mVar.mo23849a(), null);
            String str2 = "ReportNetwork";
            if (doGet != null) {
                if (doGet.f14210a == 200) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("report success actionType:");
                    sb.append(mVar.f13883a);
                    str = sb.toString();
                    C4065b.m16863a(str2, str);
                    m17232a(mVar);
                }
            }
            str = "report fail result is null";
            C4065b.m16863a(str2, str);
            m17232a(mVar);
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }
}
