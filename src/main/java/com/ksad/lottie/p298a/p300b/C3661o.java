package com.ksad.lottie.p298a.p300b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.model.p305a.C3754l;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p304e.C3720d;

/* renamed from: com.ksad.lottie.a.b.o */
public class C3661o {
    /* renamed from: a */
    private final Matrix f12550a = new Matrix();
    /* renamed from: b */
    private final C3646a<PointF, PointF> f12551b;
    /* renamed from: c */
    private final C3646a<?, PointF> f12552c;
    /* renamed from: d */
    private final C3646a<C3720d, C3720d> f12553d;
    /* renamed from: e */
    private final C3646a<Float, Float> f12554e;
    /* renamed from: f */
    private final C3646a<Integer, Integer> f12555f;
    /* renamed from: g */
    private final C3646a<?, Float> f12556g;
    /* renamed from: h */
    private final C3646a<?, Float> f12557h;

    public C3661o(C3754l lVar) {
        this.f12551b = lVar.mo23040a().mo23036a();
        this.f12552c = lVar.mo23041b().mo23036a();
        this.f12553d = lVar.mo23042c().mo23036a();
        this.f12554e = lVar.mo23043d().mo23036a();
        this.f12555f = lVar.mo23044e().mo23036a();
        if (lVar.mo23045f() != null) {
            this.f12556g = lVar.mo23045f().mo23036a();
        } else {
            this.f12556g = null;
        }
        if (lVar.mo23046g() != null) {
            this.f12557h = lVar.mo23046g().mo23036a();
        } else {
            this.f12557h = null;
        }
    }

    /* renamed from: a */
    public C3646a<?, Integer> mo22848a() {
        return this.f12555f;
    }

    /* renamed from: a */
    public void mo22849a(float f) {
        this.f12551b.mo22826a(f);
        this.f12552c.mo22826a(f);
        this.f12553d.mo22826a(f);
        this.f12554e.mo22826a(f);
        this.f12555f.mo22826a(f);
        C3646a<?, Float> aVar = this.f12556g;
        if (aVar != null) {
            aVar.mo22826a(f);
        }
        C3646a<?, Float> aVar2 = this.f12557h;
        if (aVar2 != null) {
            aVar2.mo22826a(f);
        }
    }

    /* renamed from: a */
    public void mo22850a(C3647a aVar) {
        this.f12551b.mo22827a(aVar);
        this.f12552c.mo22827a(aVar);
        this.f12553d.mo22827a(aVar);
        this.f12554e.mo22827a(aVar);
        this.f12555f.mo22827a(aVar);
        C3646a<?, Float> aVar2 = this.f12556g;
        if (aVar2 != null) {
            aVar2.mo22827a(aVar);
        }
        C3646a<?, Float> aVar3 = this.f12557h;
        if (aVar3 != null) {
            aVar3.mo22827a(aVar);
        }
    }

    /* renamed from: a */
    public void mo22851a(C3774a aVar) {
        aVar.mo23169a(this.f12551b);
        aVar.mo23169a(this.f12552c);
        aVar.mo23169a(this.f12553d);
        aVar.mo23169a(this.f12554e);
        aVar.mo23169a(this.f12555f);
        C3646a<?, Float> aVar2 = this.f12556g;
        if (aVar2 != null) {
            aVar.mo23169a(aVar2);
        }
        C3646a<?, Float> aVar3 = this.f12557h;
        if (aVar3 != null) {
            aVar.mo23169a(aVar3);
        }
    }

    /* renamed from: b */
    public Matrix mo22852b(float f) {
        PointF pointF = (PointF) this.f12552c.mo22831e();
        PointF pointF2 = (PointF) this.f12551b.mo22831e();
        C3720d dVar = (C3720d) this.f12553d.mo22831e();
        float floatValue = ((Float) this.f12554e.mo22831e()).floatValue();
        this.f12550a.reset();
        this.f12550a.preTranslate(pointF.x * f, pointF.y * f);
        double d = (double) f;
        this.f12550a.preScale((float) Math.pow((double) dVar.mo22949a(), d), (float) Math.pow((double) dVar.mo22950b(), d));
        this.f12550a.preRotate(floatValue * f, pointF2.x, pointF2.y);
        return this.f12550a;
    }

    /* renamed from: b */
    public C3646a<?, Float> mo22853b() {
        return this.f12556g;
    }

    /* renamed from: c */
    public C3646a<?, Float> mo22854c() {
        return this.f12557h;
    }

    /* renamed from: d */
    public Matrix mo22855d() {
        this.f12550a.reset();
        PointF pointF = (PointF) this.f12552c.mo22831e();
        if (!(pointF.x == 0.0f && pointF.y == 0.0f)) {
            this.f12550a.preTranslate(pointF.x, pointF.y);
        }
        float floatValue = ((Float) this.f12554e.mo22831e()).floatValue();
        if (floatValue != 0.0f) {
            this.f12550a.preRotate(floatValue);
        }
        C3720d dVar = (C3720d) this.f12553d.mo22831e();
        if (!(dVar.mo22949a() == 1.0f && dVar.mo22950b() == 1.0f)) {
            this.f12550a.preScale(dVar.mo22949a(), dVar.mo22950b());
        }
        PointF pointF2 = (PointF) this.f12551b.mo22831e();
        if (!(pointF2.x == 0.0f && pointF2.y == 0.0f)) {
            this.f12550a.preTranslate(-pointF2.x, -pointF2.y);
        }
        return this.f12550a;
    }
}
