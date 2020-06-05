package com.kwad.sdk.core.videocache.p345c;

import android.content.Context;
import com.kwad.sdk.core.videocache.C4353f;
import com.kwad.sdk.core.videocache.C4353f.C4355a;

/* renamed from: com.kwad.sdk.core.videocache.c.a */
public class C4347a {
    /* renamed from: a */
    private static C4353f f14256a;

    /* renamed from: a */
    public static C4353f m17748a(Context context) {
        C4353f fVar = f14256a;
        if (fVar != null) {
            return fVar;
        }
        C4353f b = m17749b(context);
        f14256a = b;
        return b;
    }

    /* renamed from: b */
    private static C4353f m17749b(Context context) {
        return new C4355a(context).mo24509a(209715200).mo24510a();
    }
}
