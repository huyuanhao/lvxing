package com.kwad.sdk.core.response.p342b;

import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;

/* renamed from: com.kwad.sdk.core.response.b.c */
public class C4324c {
    /* renamed from: a */
    public static boolean m17664a(AdTemplate adTemplate) {
        return adTemplate.contentType == 2 && !adTemplate.adInfoList.isEmpty() && adTemplate.adInfoList.get(0) != null;
    }

    /* renamed from: b */
    public static long m17665b(AdTemplate adTemplate) {
        return adTemplate.posId;
    }

    /* renamed from: c */
    public static int m17666c(AdTemplate adTemplate) {
        return adTemplate.contentType;
    }

    /* renamed from: d */
    public static long m17667d(AdTemplate adTemplate) {
        return adTemplate.llsid;
    }

    /* renamed from: e */
    public static AdInfo m17668e(AdTemplate adTemplate) {
        AdInfo adInfo = (AdInfo) adTemplate.adInfoList.get(0);
        if (adInfo != null) {
            return adInfo;
        }
        C4065b.m16869d("AdTemplateHelper", "adInfo in null");
        return new AdInfo();
    }

    /* renamed from: f */
    public static PhotoInfo m17669f(AdTemplate adTemplate) {
        return adTemplate.photoInfo;
    }

    /* renamed from: g */
    public static String m17670g(AdTemplate adTemplate) {
        return m17664a(adTemplate) ? C4322a.m17632a(m17668e(adTemplate)) : C4325d.m17672a(m17669f(adTemplate));
    }

    /* renamed from: h */
    public static String m17671h(AdTemplate adTemplate) {
        return m17664a(adTemplate) ? C4322a.m17638f(m17668e(adTemplate)) : C4325d.m17677f(m17669f(adTemplate));
    }
}
