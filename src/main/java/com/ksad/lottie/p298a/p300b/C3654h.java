package com.ksad.lottie.p298a.p300b;

import android.graphics.Path;
import android.graphics.PointF;
import com.ksad.lottie.C3703d;
import com.ksad.lottie.p303d.C3709f;
import com.ksad.lottie.p304e.C3717a;

/* renamed from: com.ksad.lottie.a.b.h */
public class C3654h extends C3717a<PointF> {
    /* renamed from: h */
    private Path f12539h;

    public C3654h(C3703d dVar, C3717a<PointF> aVar) {
        super(dVar, aVar.f12629a, aVar.f12630b, aVar.f12631c, aVar.f12632d, aVar.f12633e);
        boolean z = (this.f12630b == null || this.f12629a == null || !((PointF) this.f12629a).equals(((PointF) this.f12630b).x, ((PointF) this.f12630b).y)) ? false : true;
        if (this.f12630b != null && !z) {
            this.f12539h = C3709f.m15390a((PointF) this.f12629a, (PointF) this.f12630b, aVar.f12634f, aVar.f12635g);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Path mo22840a() {
        return this.f12539h;
    }
}
