package com.kwad.sdk.core.download.p323a;

import android.content.Context;
import com.ksad.download.C3601a;
import com.ksad.download.C3603b;
import com.ksad.download.C3605c;
import com.ksad.download.C3608d;
import com.kwad.sdk.core.download.C4094b;
import com.kwad.sdk.core.download.p324b.C4095a;
import com.kwad.sdk.core.download.p325c.C4098a;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import java.io.File;

/* renamed from: com.kwad.sdk.core.download.a.d */
public class C4093d {
    /* renamed from: a */
    public static AdDownloadProxy m16998a(Context context, File file, C3601a aVar, boolean z) {
        C3608d.m15051a(context, file, new C4095a());
        C3608d.m15048a().mo22719a((C3605c) new C4094b());
        C3603b.m15025a(aVar);
        return new C4098a(z);
    }
}
