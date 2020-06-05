package com.kwad.sdk.core.download.p323a;

import android.content.Context;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.page.AdWebViewActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3817t;

/* renamed from: com.kwad.sdk.core.download.a.a */
public class C4087a {

    /* renamed from: com.kwad.sdk.core.download.a.a$a */
    public interface C4088a {
        /* renamed from: a */
        void mo23360a();
    }

    /* renamed from: a */
    public static void m16967a(Context context, AdTemplate adTemplate, C4088a aVar, C4089b bVar) {
        AdInfo e = C4324c.m17668e(adTemplate);
        if (!C3817t.m15866a()) {
            if (C4092c.m16996a(context, adTemplate) == 1) {
                aVar.mo23360a();
            } else if (!C4322a.m17651s(e)) {
                AdWebViewActivity.m17486a(context, adTemplate);
                aVar.mo23360a();
            } else {
                if (bVar != null) {
                    bVar.mo23778c();
                    if (!(e.status == DOWNLOADSTAUS.DOWNLOADING || e.status == DOWNLOADSTAUS.PROGRESS)) {
                        aVar.mo23360a();
                    }
                }
            }
        }
    }
}
