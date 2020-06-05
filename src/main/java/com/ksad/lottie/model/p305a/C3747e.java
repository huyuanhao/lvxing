package com.ksad.lottie.model.p305a;

import android.graphics.PointF;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3655i;
import com.ksad.lottie.p298a.p300b.C3656j;
import com.ksad.lottie.p304e.C3717a;
import java.util.Collections;
import java.util.List;

/* renamed from: com.ksad.lottie.model.a.e */
public class C3747e implements C3755m<PointF, PointF> {
    /* renamed from: a */
    private final List<C3717a<PointF>> f12709a;

    public C3747e() {
        this.f12709a = Collections.singletonList(new C3717a(new PointF(0.0f, 0.0f)));
    }

    public C3747e(List<C3717a<PointF>> list) {
        this.f12709a = list;
    }

    /* renamed from: a */
    public C3646a<PointF, PointF> mo23036a() {
        return ((C3717a) this.f12709a.get(0)).mo22944d() ? new C3656j(this.f12709a) : new C3655i(this.f12709a);
    }
}
