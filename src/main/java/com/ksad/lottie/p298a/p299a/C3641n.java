package com.ksad.lottie.p298a.p299a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.content.C3765f;
import com.ksad.lottie.model.content.ShapeTrimPath.Type;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p300b.C3646a;
import com.ksad.lottie.p298a.p300b.C3646a.C3647a;
import com.ksad.lottie.p303d.C3709f;
import java.util.List;

/* renamed from: com.ksad.lottie.a.a.n */
public class C3641n implements C3635j, C3638l, C3647a {
    /* renamed from: a */
    private final Path f12495a = new Path();
    /* renamed from: b */
    private final RectF f12496b = new RectF();
    /* renamed from: c */
    private final String f12497c;
    /* renamed from: d */
    private final C3721f f12498d;
    /* renamed from: e */
    private final C3646a<?, PointF> f12499e;
    /* renamed from: f */
    private final C3646a<?, PointF> f12500f;
    /* renamed from: g */
    private final C3646a<?, Float> f12501g;
    /* renamed from: h */
    private C3645r f12502h;
    /* renamed from: i */
    private boolean f12503i;

    public C3641n(C3721f fVar, C3774a aVar, C3765f fVar2) {
        this.f12497c = fVar2.mo23111a();
        this.f12498d = fVar;
        this.f12499e = fVar2.mo23114d().mo23036a();
        this.f12500f = fVar2.mo23113c().mo23036a();
        this.f12501g = fVar2.mo23112b().mo23036a();
        aVar.mo23169a(this.f12499e);
        aVar.mo23169a(this.f12500f);
        aVar.mo23169a(this.f12501g);
        this.f12499e.mo22827a((C3647a) this);
        this.f12500f.mo22827a((C3647a) this);
        this.f12501g.mo22827a((C3647a) this);
    }

    /* renamed from: b */
    private void m15170b() {
        this.f12503i = false;
        this.f12498d.invalidateSelf();
    }

    /* renamed from: a */
    public void mo22811a() {
        m15170b();
    }

    /* renamed from: a */
    public void mo22814a(List<C3627b> list, List<C3627b> list2) {
        for (int i = 0; i < list.size(); i++) {
            C3627b bVar = (C3627b) list.get(i);
            if (bVar instanceof C3645r) {
                C3645r rVar = (C3645r) bVar;
                if (rVar.mo22820b() == Type.Simultaneously) {
                    this.f12502h = rVar;
                    this.f12502h.mo22819a(this);
                }
            }
        }
    }

    /* renamed from: d */
    public Path mo22817d() {
        if (this.f12503i) {
            return this.f12495a;
        }
        this.f12495a.reset();
        PointF pointF = (PointF) this.f12500f.mo22831e();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        C3646a<?, Float> aVar = this.f12501g;
        float floatValue = aVar == null ? 0.0f : ((Float) aVar.mo22831e()).floatValue();
        float min = Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF pointF2 = (PointF) this.f12499e.mo22831e();
        this.f12495a.moveTo(pointF2.x + f, (pointF2.y - f2) + floatValue);
        this.f12495a.lineTo(pointF2.x + f, (pointF2.y + f2) - floatValue);
        int i = (floatValue > 0.0f ? 1 : (floatValue == 0.0f ? 0 : -1));
        if (i > 0) {
            float f3 = floatValue * 2.0f;
            this.f12496b.set((pointF2.x + f) - f3, (pointF2.y + f2) - f3, pointF2.x + f, pointF2.y + f2);
            this.f12495a.arcTo(this.f12496b, 0.0f, 90.0f, false);
        }
        this.f12495a.lineTo((pointF2.x - f) + floatValue, pointF2.y + f2);
        if (i > 0) {
            float f4 = floatValue * 2.0f;
            this.f12496b.set(pointF2.x - f, (pointF2.y + f2) - f4, (pointF2.x - f) + f4, pointF2.y + f2);
            this.f12495a.arcTo(this.f12496b, 90.0f, 90.0f, false);
        }
        this.f12495a.lineTo(pointF2.x - f, (pointF2.y - f2) + floatValue);
        if (i > 0) {
            float f5 = floatValue * 2.0f;
            this.f12496b.set(pointF2.x - f, pointF2.y - f2, (pointF2.x - f) + f5, (pointF2.y - f2) + f5);
            this.f12495a.arcTo(this.f12496b, 180.0f, 90.0f, false);
        }
        this.f12495a.lineTo((pointF2.x + f) - floatValue, pointF2.y - f2);
        if (i > 0) {
            float f6 = floatValue * 2.0f;
            this.f12496b.set((pointF2.x + f) - f6, pointF2.y - f2, pointF2.x + f, (pointF2.y - f2) + f6);
            this.f12495a.arcTo(this.f12496b, 270.0f, 90.0f, false);
        }
        this.f12495a.close();
        C3709f.m15392a(this.f12495a, this.f12502h);
        this.f12503i = true;
        return this.f12495a;
    }
}
