package com.kwad.sdk.reward;

import com.kwad.sdk.core.diskcache.p322b.C4079a;
import com.kwad.sdk.core.p319c.C4065b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;
import com.kwad.sdk.p306a.C3805h;
import java.io.File;

/* renamed from: com.kwad.sdk.reward.e */
public class C4542e {
    /* renamed from: a */
    public static boolean m18435a(AdTemplate adTemplate) {
        if (m18436b(adTemplate)) {
            return true;
        }
        String a = C4322a.m17632a(C4324c.m17668e(adTemplate));
        String a2 = C3805h.m15773a(a);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("start cache video key:");
        sb.append(a2);
        sb.append("--url:");
        sb.append(a);
        String str = "VideoCacheHelper";
        C4065b.m16867b(str, sb.toString());
        boolean b = C4079a.m16947a().mo23761b(a);
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("finish cache video key:");
        sb2.append(a2);
        sb2.append("--cache time:");
        sb2.append(currentTimeMillis2 - currentTimeMillis);
        sb2.append("--success:");
        sb2.append(b);
        C4065b.m16867b(str, sb2.toString());
        return b;
    }

    /* renamed from: b */
    public static boolean m18436b(AdTemplate adTemplate) {
        File c = C4079a.m16947a().mo23762c(C4322a.m17632a(C4324c.m17668e(adTemplate)));
        return c != null && c.exists();
    }
}
