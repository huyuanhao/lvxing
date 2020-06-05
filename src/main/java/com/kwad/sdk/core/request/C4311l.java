package com.kwad.sdk.core.request;

import com.kwad.sdk.KsAdSDK;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.p326e.p327a.C4105a;
import com.kwad.sdk.core.response.p341a.C4320a;

/* renamed from: com.kwad.sdk.core.request.l */
public abstract class C4311l extends C4105a<C4280c> {
    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23798c() {
        String str = "RequestNetwork";
        C4280c cVar = (C4280c) mo23795a();
        try {
            long j = cVar.mo24409d().posId;
            StringBuilder sb = new StringBuilder();
            sb.append("request start posId:");
            sb.append(j);
            C4065b.m16863a(str, sb.toString());
            C4320a doPost = KsAdSDK.getProxyForHttp().doPost(cVar.mo23849a(), cVar.mo24382e(), cVar.mo24383f());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("request success posId:");
            sb2.append(j);
            C4065b.m16863a(str, sb2.toString());
            mo23796a(cVar, doPost);
        } catch (Exception e) {
            C4065b.m16865a(e);
        }
    }
}
