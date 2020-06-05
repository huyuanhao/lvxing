package com.ksad.lottie.p298a.p300b;

import android.graphics.PointF;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p304e.C3717a;
import java.util.Collections;

/* renamed from: com.ksad.lottie.a.b.m */
public class C3659m extends C3646a<PointF, PointF> {
    /* renamed from: c */
    private final PointF f12547c = new PointF();
    /* renamed from: d */
    private final C3646a<Float, Float> f12548d;
    /* renamed from: e */
    private final C3646a<Float, Float> f12549e;

    public C3659m(C3646a<Float, Float> aVar, C3646a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f12548d = aVar;
        this.f12549e = aVar2;
        mo22826a(mo22832f());
    }

    /* renamed from: a */
    public void mo22826a(float f) {
        this.f12548d.mo22826a(f);
        this.f12549e.mo22826a(f);
        this.f12547c.set(((Float) this.f12548d.mo22831e()).floatValue(), ((Float) this.f12549e.mo22831e()).floatValue());
        for (int i = 0; i < this.f12529a.size(); i++) {
            ((C3647a) this.f12529a.get(i)).mo22811a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public PointF mo22824a(C3717a<PointF> aVar, float f) {
        return this.f12547c;
    }

    /* renamed from: g */
    public PointF mo22831e() {
        return mo22824a(null, 0.0f);
    }
}
