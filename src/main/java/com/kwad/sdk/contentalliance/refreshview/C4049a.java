package com.kwad.sdk.contentalliance.refreshview;

import android.content.Context;
import com.kwad.sdk.p306a.C3817t;

/* renamed from: com.kwad.sdk.contentalliance.refreshview.a */
public class C4049a implements C4050b {
    /* renamed from: a */
    private final float f13612a;

    public C4049a(Context context) {
        this.f13612a = (float) C3817t.m15870b(context);
    }

    /* renamed from: a */
    public float mo23630a(float f, float f2) {
        float f3 = this.f13612a;
        return f3 - (((f3 * f3) * 2.0f) / (f + (2.0f * f3)));
    }
}
